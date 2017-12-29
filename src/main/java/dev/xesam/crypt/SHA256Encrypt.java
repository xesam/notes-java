package dev.xesam.crypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xesamguo@gmail.com on 17-2-27.
 */
public class SHA256Encrypt {

    public static void main(String[] args) {
        System.out.println(getHash("111"));
    }

    private static byte[] getHash(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        digest.reset();
        return digest.digest(password.getBytes());
    }

    public static String bin2hex(String strForEncrypt) {
        byte[] data = getHash(strForEncrypt);
        return String.format("%0" + (data.length * 2) + "X", new BigInteger(1, data));
    }
}
