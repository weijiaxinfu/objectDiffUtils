package diff.demo;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
* @author liupeng
* @date 2015-06-07
* @version 1.0
* @Description 用于短文本的字符串加密解密工具类
*/
public class ShortDataCryptUtil {

	public static String cryptCode = "8UKN95GC4K9SC51V";
	
	/**
	 * 重载类，使用默认key
	 * @param content：待加密内容，普通字符串
	 * @return  加密后的内容，进行byte2hex后的内容
	 * @throws Exception
	 * @throws UnsupportedEncodingException
	 */
	public static String encrypt(String content) throws Exception, UnsupportedEncodingException {
		return Byte2Hex(encrypt(content.getBytes("utf-8"), cryptCode.getBytes()));
	}

	/**
	 * 解密收到的十六进制字符串，重载类，使用默认key
	 * @param content：十六进制字符串，使用前需要先进行hex2byte操作
	 * @return 解密后的明文字符串（UTF-8编码）
	 * @throws Exception
	 * @throws UnsupportedEncodingException
	 */
	public static String decrypt(String content) throws Exception, UnsupportedEncodingException {
		byte[] buffer = decrypt(Hex2Byte(content), cryptCode.getBytes());
		String result = new String(buffer, "utf-8");
		return result;
	}
	
	/**
	 *
	 * @param content：待加密内容，普通字符串
	 * @param password：十六进制key，使用前需要先进行hex2byte操作
	 * @return  加密后的内容，进行byte2hex后的内容
	 * @throws Exception
	 * @throws UnsupportedEncodingException
	 */
	public static String encrypt(String content, String password) throws Exception, UnsupportedEncodingException {
		return Byte2Hex(encrypt(content.getBytes("utf-8"), password.getBytes()));
	}

	/**
	 * 解密收到的十六进制字符串
	 * @param content：十六进制字符串，使用前需要先进行hex2byte操作
	 * @param password：十六进制key，使用前需要先进行hex2byte操作
	 * @return 解密后的明文字符串（UTF-8编码）
	 * @throws Exception
	 * @throws UnsupportedEncodingException
	 */
	public static String decrypt(String content, String password) throws Exception, UnsupportedEncodingException {
		byte[] buffer = decrypt(Hex2Byte(content), password.getBytes());
		String result = new String(buffer, "utf-8");
		return result;
	}
	
	/**
	 * 加密
	 * @param content 需要加密的内容
	 * @param password  加密密钥
	 * @return
	 */
	protected static byte[] encrypt(byte[] content, byte[] password) {
		return aesCrypt(Cipher.ENCRYPT_MODE, content, password);
	}

	/**解密
	 * @param content  待解密内容
	 * @param password 解密密钥
	 * @return
	 */
	protected static byte[] decrypt(byte[] content, byte[] password) {
		return aesCrypt(Cipher.DECRYPT_MODE, content, password);
	}
	
	/**
	 * AES加密/解密
	 * @param content 需要 加密/解密 的内容
	 * @param password  加密/解密 密钥
	 * @return
	 */
	protected static byte[] aesCrypt(int mode, byte[] content, byte[] password) {
		try {
			/*KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom sRandom = SecureRandom.getInstance("SHA1PRNG");
			sRandom.setSeed(password);
			kgen.init(128, sRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(mode, key);*/
			SecureRandom sRandom = SecureRandom.getInstance("SHA1PRNG");
			sRandom.setSeed(password);
			byte[] randomBytes = password.clone();
			sRandom.nextBytes(randomBytes);
			SecretKeySpec key = new SecretKeySpec(randomBytes, "AES");

			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(mode, key);


			byte[] result = cipher.doFinal(content);// 加密/解密
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将二进制转换成16进制 
	 * @param buf
	 * @return
	 */
	public static String Byte2Hex(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}
	
	/**
	 * 将16进制转换为二进制
	 * @param hexStr
	 * @return
	 */
	public static byte[] Hex2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
		
	}
	
	//for test purpose
	public static void main(String[] args) {
		if(args.length >= 2) {
			if(args[0].equals("-d")) {
				printEncodeString(args[1]);
			}
			else if(args[0].equals("-e")) {
				printDecodeString(args[1]);
			}

			return;
		}

		String test = "1234abcdUI分就当减肥383+————+*（）&*（%&*￥*jdfsjfkl893479kfkdf__+_fjdkj";
		test = "A11BA4ED7F4C53E1068A74444744B8ED";
		System.out.println("origin=" + test);
		 try {
			String encode = ShortDataCryptUtil.encrypt(test);
			System.out.println("encode=" + encode);

			 encode = "4B704AF20E7F8F26729F37310C2998867766A73C8B7E6F0FD12B787E6D5ABEDC0C68B74CE5073B96662D6F7568FB37D2A57FA0DBBC0F63A2A062D3A564D99C6371DECFB6B5F246F7E16228A97B96ACCC7F636EF377E7CA914288C1814E373347";
			encode= "A11BA4ED7F4C53E1068A74444744B8ED";
			String decode = ShortDataCryptUtil.decrypt(encode);
			System.out.println("decode=" + decode);
			
			System.out.println(test.equals(decode) ? "equal" : "Not equal");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printEncodeString(String encodedStr) {
		try {
			System.out.println(ShortDataCryptUtil.decrypt(encodedStr));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printDecodeString(String OriginStr) {
		try {
			System.out.println(ShortDataCryptUtil.encrypt(OriginStr));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
