package encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Base64;

public class Encrypter {

	private final static String SECRET_KEY = "12345678901234567890123456789012";
	private static byte[] SECRET_DATA_16;
	private static byte[] SECRET_DATA_32;
	private static SecretKey SECURE_KEY;

	static {
		try {
			SECRET_DATA_16 = SECRET_KEY.substring(0, 16).getBytes(CharEncoding.UTF_8);
			SECRET_DATA_32 = SECRET_KEY.getBytes(CharEncoding.UTF_8);
			SECURE_KEY = new SecretKeySpec(SECRET_DATA_32, "AES");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static String encode(String str) {

		byte[] encryptedByte = null;
		try {
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, SECURE_KEY, new IvParameterSpec(SECRET_DATA_16));

			encryptedByte = c.doFinal(str.getBytes("UTF-8"));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String encryptedString = new String(Base64.encodeBase64(encryptedByte));

		return encryptedString;
	}

	public static String decode(String str) { 
		Cipher cipher = null;
		String decodeString = null;

		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, SECURE_KEY, new IvParameterSpec(SECRET_DATA_16));

			byte[] base64Decoded = Base64.decodeBase64(str.getBytes(CharEncoding.UTF_8));
			decodeString = new String(cipher.doFinal(base64Decoded), "UTF-8");

		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		return decodeString; 
	}
}
