package com.bugpass.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 加密工具类
 *
 * @author RuanYaofeng
 * @date 2018-06-28 12:05
 */
public class EncryptUtil {

    /**
     * 生成盐
     *
     * @return 16进制的盐
     */
    public static String createSalt() {
        byte[] bytes = new byte[16];
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.nextBytes(bytes);
            return new BigInteger(bytes).toString(16).replace("-", "");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * 生成摘要
     *
     * @param str 待加密字符串
     * @param algorithm 加密算法
     * @return 加密后的字符串
     */
    public static String digest(String str, String algorithm) {
        BigInteger bigInteger = null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] bytes = str.getBytes();
            md.update(bytes);
            bigInteger = new BigInteger(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigInteger.toString(16);
    }

    /**
     * MD5加密
     *
     * @param str 待加密字符串
     * @return 加密后的字符串
     */
    public static String getMD5(String str) {
        return digest(str, "MD5");
    }

    /**
     * SHA-1加密
     *
     * @param str 待加密字符串
     * @return 加密后的字符串
     */
    public static String getSHA1(String str) {
        return digest(str, "SHA");
    }
}
