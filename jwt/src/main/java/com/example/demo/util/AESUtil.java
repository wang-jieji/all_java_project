package com.example.demo.util;



import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/*****************************************************
 * AES加密解密工具
 ****************************************************/

public  class AESUtil {

    private static final Logger logger =  LoggerFactory.getLogger(AESUtil.class); //log日志


    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";    //"算法/模式/补码方式"

    private static final String KEY = "oP8(@$ux52(*&^`s";

    /*****************************************************
     * AES加密
     * @param content 加密内容
     * @param key 加密密码，由字母或数字组成
    此方法使用AES-128-ECB加密模式，key需要为16位
    加密解密key必须相同，如：abcd1234abcd1234
     * @return 加密密文
     ****************************************************/

    public static String enCode(String content) {

        try {
            byte[] raw = KEY.getBytes();  //获得密码的字节数组
            SecretKeySpec skey = new SecretKeySpec(raw, "AES"); //根据密码生成AES密钥
            Cipher cipher = Cipher.getInstance(ALGORITHM);  //根据指定算法ALGORITHM自成密码器
            cipher.init(Cipher.ENCRYPT_MODE, skey); //初始化密码器，第一个参数为加密(ENCRYPT_MODE)或者解密(DECRYPT_MODE)操作，第二个参数为生成的AES密钥
            byte [] byte_content = content.getBytes("utf-8"); //获取加密内容的字节数组(设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte [] encode_content = cipher.doFinal(byte_content); //密码器加密数据
            return Base64.encodeBase64String(encode_content); //将加密后的数据转换为字符串返回
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*****************************************************
     * AES解密
     * @param content 加密密文
     * @param key 加密密码,由字母或数字组成
    此方法使用AES-128-ECB加密模式，key需要为16位
    加密解密key必须相同
     * @return 解密明文
     ****************************************************/

    public static String deCode(String content) {

        try {
            byte[] raw = KEY.getBytes();  //获得密码的字节数组
            SecretKeySpec skey = new SecretKeySpec(raw, "AES"); //根据密码生成AES密钥
            Cipher cipher = Cipher.getInstance(ALGORITHM);  //根据指定算法ALGORITHM自成密码器
            cipher.init(Cipher.DECRYPT_MODE, skey); //初始化密码器，第一个参数为加密(ENCRYPT_MODE)或者解密(DECRYPT_MODE)操作，第二个参数为生成的AES密钥
            byte [] encode_content = Base64.decodeBase64(content); //把密文字符串转回密文字节数组
            byte [] byte_content = cipher.doFinal(encode_content); //密码器解密数据
            return new String(byte_content,"utf-8"); //将解密后的数据转换为字符串返回
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*****************************************************
     * AES加密解密测试
     * @param args
     * @return
     ****************************************************/

    public static void main(String[] args) {

        String deResult = deCode("jFAs6ObWfhaBJxUjU5kc2A==");
        System.out.println("解密result："+deResult);
    }
}