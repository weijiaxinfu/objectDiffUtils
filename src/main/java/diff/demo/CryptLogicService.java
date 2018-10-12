package diff.demo;


import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

/**
 * 手机号码加解密服务
 *
 * @author xuexiaojin
 * @create 2018-03-12 17:07
 **/
@Service
public class CryptLogicService {

    private static String cryptCode = "8UKN95GC4K9SC51V";

    /**
     * 解密收到的十六进制字符串，重载类，使用默认key
     *
     * @param content：十六进制字符串，使用前需要先进行hex2byte操作
     * @return 解密后的明文字符串（UTF-8编码）
     * @throws Exception
     */
    public static String decrypt(String content) throws Exception {
        byte[] buffer = decrypt(hex2Byte(content), cryptCode.getBytes());
        String result = new String(buffer, "utf-8");
        return result;
    }

    protected static byte[] decrypt(byte[] content, byte[] password) {
        return aesCrypt(Cipher.DECRYPT_MODE, content, password);
    }

    /**
     * 重载类，使用默认key
     *
     * @param content：待加密内容，普通字符串
     * @return 加密后的内容，进行byte2hex后的内容
     * @throws Exception
     * @throws UnsupportedEncodingException
     */
    public static String encrypt(String content) throws Exception {
        return byte2Hex(encrypt(content.getBytes("utf-8"), cryptCode.getBytes()));
    }

    /**
     * 加密
     *
     * @param content  需要加密的内容
     * @param password 加密密钥
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

    /**
     * AES加密/解密
     *
     * @param content  需要 加密/解密 的内容
     * @param password 加密/解密 密钥
     * @return
     */
    protected static byte[] aesCrypt(int mode, byte[] content, byte[] password) {
        try {
            SecureRandom sRandom = SecureRandom.getInstance("SHA1PRNG");
            sRandom.setSeed(password);
            byte[] randomBytes = password.clone();
            sRandom.nextBytes(randomBytes);
            SecretKeySpec key = new SecretKeySpec(randomBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(mode, key);

            byte[] result = cipher.doFinal(content);// 加密/解密
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String byte2Hex(byte buf[]) {
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

    public static byte[] hex2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;

    }

    public String decryptPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return null;
        } else {
            try {
                return ShortDataCryptUtil.decrypt(phone);
            } catch (Exception e) {

            }
            return null;
        }
    }


    public String encryptPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return null;
        } else {
            try {
                return ShortDataCryptUtil.encrypt(phone);
            } catch (Exception e) {

                return null;
            }
        }

    }
}
