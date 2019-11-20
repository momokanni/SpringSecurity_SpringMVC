package com.caishen91.jupiter.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class DownUtil {
	
	
	public synchronized static String genDownSeq() {
		String s = System.currentTimeMillis() + "";
		
		try {
			Thread.sleep(1L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	public static void fileWriter(byte[] bs, File file) {
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			fos.write(bs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
