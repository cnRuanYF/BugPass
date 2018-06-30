package com.bugpass.test;

import com.bugpass.util.EncryptUtil;
import org.junit.Test;

/**
 * 加密工具测试类
 *
 * @author RuanYaofeng
 * @date 2018/6/29 10:22
 **/
public class TestEncryptionUtil {

    private static String PASSWD = "123456";

    @Test
    public void testEncrypt() {
        String salt = EncryptUtil.createSalt();
        String md5 = EncryptUtil.getMD5(PASSWD + salt);
        String sha1 = EncryptUtil.getSHA1(PASSWD + salt);
        System.out.println("passwd: " + PASSWD);
        System.out.println("salt: " + salt);
        System.out.println("MD5: " + md5);
        System.out.println("SHA-1: " + sha1);
    }

}
