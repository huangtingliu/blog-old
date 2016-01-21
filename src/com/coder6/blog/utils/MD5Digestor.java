package com.coder6.blog.utils;


import java.io.IOException;
import java.security.MessageDigest;

public class MD5Digestor {

    public static String getMd5(String content) {
        try {
            MessageDigest md = MessageDigest. getInstance("MD5");
            byte[] results = md.digest(content.getBytes());
            return byteArrayToHexString(results);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 轮换字节数组为十六进制字符串
     * @param b 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString( byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b. length; i++) {
            resultSb.append( byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 将一个字节转化成十六进制形式的字符串
     */
    private static String byteToHexString( byte b) {
     System.out.println(b);
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEXDIGITS[d1] + HEXDIGITS[d2];
    }

    private static final String[] HEXDIGITS = { "0", "1", "2", "3", "4" , "5" , "6" , "7" , "8" , "9" ,
            "A", "B", "C", "D", "E", "F" };

    public static void main (String[] args) throws IOException {
        String mKey = "DcdOplConfig.getInstance().getClientVersion()"
                + "DcdOplConfig.getInstance().getPassword()" ;
        System. out.println( getMd5(mKey));
    }

}