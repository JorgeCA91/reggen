package reggen.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author jorge
 */
public class Md5 {
    public static String text = null;
    public static String passEncrypted = null;
    public static MessageDigest msgd;
    public static byte[] array = null;
    StringBuilder strbCadenaMD5;
    
    public static String encriptaEnMD5(String stringAEncriptar)
    {
        text = stringAEncriptar;
        try {
            msgd = java.security.MessageDigest.getInstance("MD5");
            array = msgd.digest(text.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            passEncrypted = sb.toString();
            return passEncrypted;
        } catch (java.security.NoSuchAlgorithmException e) {
            return null;
        }
    }
}