package com.fundoonotes.utility;
<<<<<<< HEAD

=======
>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;
<<<<<<< HEAD

@Component
public class EncryptPassword {
=======
@Component
public class EncryptPassword {
	

>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
	public static String getMD5EncryptedValue(String password) {
        final byte[] defaultBytes = password.getBytes();
        try {
            final MessageDigest md5MsgDigest = MessageDigest.getInstance("MD5");
            md5MsgDigest.reset();
            md5MsgDigest.update(defaultBytes);
            final byte messageDigest[] = md5MsgDigest.digest();
            final StringBuffer hexString = new StringBuffer();
            for (final byte element : messageDigest) {
                final String hex = Integer.toHexString(0xFF & element);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            password = hexString + "";
        } catch (final NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return password;
    }
    public static void main(String[] args) {
       
    }
}
<<<<<<< HEAD
=======

>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
