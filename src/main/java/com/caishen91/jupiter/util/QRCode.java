package com.caishen91.jupiter.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * 利用zxing开源工具生成二维码QRCode
 * 
 * @date 2012-10-26
 * @author xhw
 * 
 */
public class QRCode {
	private static final int BLACK = 0xff000000;
	private static final int WHITE = 0xFFFFFFFF;

	private static int margin = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QRCode test = new QRCode();
		File file = new File("/home/wangyi/share/qr/abc.png");
		/**
		 * 在com.google.zxing.MultiFormatWriter类中，定义了一些我们不知道的码,二维码只是其中的一种<br>
		 * public BitMatrix encode(String contents, BarcodeFormat format, int
		 * width, int height, Map<EncodeHintType,?> hints) throws
		 * WriterException { Writer writer; switch (format) { case EAN_8: writer
		 * = new EAN8Writer(); break; case EAN_13: writer = new EAN13Writer();
		 * break; case UPC_A: writer = new UPCAWriter(); break; case QR_CODE:
		 * //这里是二维码 writer = new QRCodeWriter(); break; case CODE_39: writer =
		 * new Code39Writer(); break; case CODE_128: //这个可以生成 writer = new
		 * Code128Writer(); break; case ITF: writer = new ITFWriter(); break;
		 * case PDF_417: //这个可以生成 writer = new PDF417Writer(); break; case
		 * CODABAR: writer = new CodaBarWriter(); break; default: throw new
		 * IllegalArgumentException("No encoder available for format " +
		 * format); } return writer.encode(contents, format, width, height,
		 * hints); }
		 */
		test.encode("http://www.jgnycz.com", file, BarcodeFormat.QR_CODE, 400, 400, null);
		int x = 3;
	}

	/**
	 * 生成QRCode二维码<br>
	 * 在编码时需要将com.google.zxing.qrcode.encoder.Encoder.java中的<br>
	 * static final String DEFAULT_BYTE_MODE_ENCODING = "ISO8859-1";<br>
	 * 修改为UTF-8，否则中文编译后解析不了<br>
	 */
	public void encode(String contents, File file, BarcodeFormat format,
			int width, int height, Map<EncodeHintType, ?> hints) {
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
					format, width, height);
			bitMatrix = updateBit(bitMatrix, margin);
			writeToFile(bitMatrix, "png", file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成二维码图片<br>
	 * 
	 * @param matrix
	 * @param format
	 *            图片格式
	 * @param file
	 *            生成二维码图片位置
	 * @throws IOException
	 */
	public static void writeToFile(BitMatrix matrix, String format, File file)
			throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		ImageIO.write(image, format, file);
	}

	public static void writeToStream(String contents, int width, int height,
			OutputStream out) {
		if (StringUtil.isEmpty(contents)) {
			return;
		}
		BitMatrix bitMatrix = null;
		try {
			bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height);
			bitMatrix = updateBit(bitMatrix, margin);
		} catch (WriterException e1) {
			e1.printStackTrace();
		}
		if (bitMatrix != null) {
			BufferedImage image = toBufferedImage(bitMatrix);
			try {
				ImageIO.write(image, "png", out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static BitMatrix updateBit(BitMatrix matrix, int margin) {
		int tempM = margin * 2;
		int[] rec = matrix.getEnclosingRectangle(); // 获取二维码图案的属性
		int resWidth = rec[2] + tempM;
		int resHeight = rec[3] + tempM;
		BitMatrix resMatrix = new BitMatrix(resWidth, resHeight); // 按照自定义边框生成新的BitMatrix
		resMatrix.clear();
		for (int i = margin; i < resWidth - margin; i++) { // 循环，将二维码图案绘制到新的bitMatrix中
			for (int j = margin; j < resHeight - margin; j++) {
				if (matrix.get(i - margin + rec[0], j - margin + rec[1])) {
					resMatrix.set(i, j);
				}
			}
		}
		return resMatrix;
	}

	/**
	 * 生成二维码内容<br>
	 * 
	 * @param matrix
	 * @return
	 */
	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) == true ? BLACK : WHITE);
			}
		}
		return image;
	}

}
