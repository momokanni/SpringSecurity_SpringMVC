package com.caishen91.jupiter.util;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;


public class EncryptUtil
{
  public static final String KEY_ALGORITHM_RSA = "RSA";
  public static final String KEY_ALGORITHM_AES = "AES";
  public static final String PUBLIC_KEY = "RSAPublicKey";
  public static final String PRIVATE_KEY = "RSAPrivateKey";
  public static final String SIGNATURE_ALGORITHM_MD5_RSA = "MD5withRSA";

  public static String getCRC32Value(String str)
  {
    CRC32 crc32 = new CRC32();
    crc32.update(str.getBytes());
    return Long.toString(crc32.getValue());
  }

  public static String getAESRandomKeyString()
  {
    try
    {
      KeyGenerator keygen = KeyGenerator.getInstance("AES");
      SecureRandom random = new SecureRandom();
      keygen.init(random);
      Key key = keygen.generateKey();

      String key64Str = Base64.encodeBase64String(key.getEncoded());
      return key64Str;
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String encryptByAESAndBase64(String base64EncodedAESKey, String dataStr)
  {
    SecretKey secretKey = restoreAESKey(base64EncodedAESKey);
    try
    {
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(1, secretKey);

      String encryptedDataStr = Base64.encodeBase64String(cipher.doFinal(dataStr.getBytes()));

      return encryptedDataStr;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String decryptByAESAndBase64(String base64EncodedAESKey, String encryptedDataStr)
  {
    SecretKey secretKey = restoreAESKey(base64EncodedAESKey);
    try {
      Cipher cipher = Cipher.getInstance("AES");

      cipher.init(2, secretKey);

      String decryptedDataStr = new String(cipher.doFinal(Base64.decodeBase64(encryptedDataStr)));

      return decryptedDataStr;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static SecretKey restoreAESKey(String base64EncodedAESKey)
  {
    byte[] keyByteArray = Base64.decodeBase64(base64EncodedAESKey);

    SecretKey secretKey = new SecretKeySpec(keyByteArray, "AES");

    return secretKey;
  }

  public static Map<String, String> getRSARandomKeyPair()
  {
    try
    {
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      keyPairGen.initialize(512);
      KeyPair keyPair = keyPairGen.generateKeyPair();

      RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();

      RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();

      String publicKeyStr = Base64.encodeBase64String(publicKey.getEncoded());

      String privateKeyStr = Base64.encodeBase64String(privateKey.getEncoded());

      Map keyMap = new HashMap(2);
      keyMap.put("RSAPublicKey", publicKeyStr);
      keyMap.put("RSAPrivateKey", privateKeyStr);
      return keyMap;
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String encryptByRSAPublicKeyAndBase64(String publicRSAKey, String dataStr)
  {
    byte[] data = dataStr.getBytes();

    Key decodePublicKey = restoreRSAPublicKeyFromBase64KeyEncodeStr(publicRSAKey);
    try
    {
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(1, decodePublicKey);
      byte[] encodedData = cipher.doFinal(data);
      String encodedDataStr = Base64.encodeBase64String(encodedData);
      return encodedDataStr;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String decryptByRSAPublicKeyAndBase64(String publicRSAKey, String encryptedDataStr)
  {
    Key decodePublicKey = restoreRSAPublicKeyFromBase64KeyEncodeStr(publicRSAKey);
    try
    {
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(2, decodePublicKey);
      byte[] decodedData = cipher.doFinal(Base64.decodeBase64(encryptedDataStr));

      String decodedDataStr = new String(decodedData);
      return decodedDataStr;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String getSignFromEncryptedDataWithPrivateKey(String privateRSAKey, String encryotedDataStr)
  {
    byte[] data = Base64.decodeBase64(encryotedDataStr);

    Key decodePrivateKey = restoreRSAPrivateKeyFromBase64KeyEncodeStr(privateRSAKey);
    try
    {
      Signature signature = Signature.getInstance("MD5withRSA");
      signature.initSign((PrivateKey)decodePrivateKey);
      signature.update(data);

      String sign = Base64.encodeBase64String(signature.sign());
      return sign;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static boolean verifySign(String publicRSAKey, String sign, String encryotedDataStr)
  {
    byte[] data = Base64.decodeBase64(encryotedDataStr);
    Key decodePublicKey = restoreRSAPublicKeyFromBase64KeyEncodeStr(publicRSAKey);
    try
    {
      Signature signature = Signature.getInstance("MD5withRSA");
      signature.initVerify((PublicKey)decodePublicKey);
      signature.update(data);
      boolean ret = signature.verify(Base64.decodeBase64(sign));
      return ret;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  public static String encryptByRSAPrivateKeyAndBase64(String privateRSAKey, String dataStr)
  {
    byte[] data = dataStr.getBytes();

    Key decodePrivateKey = restoreRSAPrivateKeyFromBase64KeyEncodeStr(privateRSAKey);
    try
    {
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(1, decodePrivateKey);
      byte[] encodedData = cipher.doFinal(data);
      String encodedDataStr = Base64.encodeBase64String(encodedData);
      return encodedDataStr;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String decryptByRSAPrivateKeyAndBase64(String privateRSAKey, String encryptedDataStr)
  {
    Key decodePrivateKey = restoreRSAPrivateKeyFromBase64KeyEncodeStr(privateRSAKey);
    try
    {
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(2, decodePrivateKey);
      byte[] decodedData = cipher.doFinal(Base64.decodeBase64(encryptedDataStr));

      String decodedDataStr = new String(decodedData);
      return decodedDataStr;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private static Key restoreRSAPublicKeyFromBase64KeyEncodeStr(String keyStr)
  {
    byte[] keyBytes = Base64.decodeBase64(keyStr);
    X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
    Key publicKey = null;
    try {
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      publicKey = keyFactory.generatePublic(x509KeySpec);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return publicKey;
  }

  private static Key restoreRSAPrivateKeyFromBase64KeyEncodeStr(String keyStr)
  {
    byte[] keyBytes = Base64.decodeBase64(keyStr);

    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

    Key privateKey = null;
    try {
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return privateKey;
  }

  public static String escapeSymbol(String content)
  {
    if ((content.indexOf("+") > 0) || (content.indexOf("/") > 0)) {
      content = content.replaceAll("\\+", ".");
      content = content.replaceAll("\\/", "_");
    }
    return content;
  }

  public static String restoreSymbol(String content)
  {
    if ((content.indexOf(".") > 0) || (content.indexOf("_") > 0)) {
      content = content.replaceAll("\\.", "+");
      content = content.replaceAll("\\_", "/");
    }
    return content;
  }
}