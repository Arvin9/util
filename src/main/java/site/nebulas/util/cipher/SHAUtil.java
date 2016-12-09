package site.nebulas.util.cipher;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2016/11/29.
 */
public class SHAUtil {
    public static void main(String[] args) {
        String str = "314159";
        System.out.println("待加密串：" + str);
        System.out.println("加密结果：" + encode(str));
    }
    public static String encode(String str){
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        sha.update(str.getBytes());
        return Hex.encodeHexString(sha.digest());
    }
}
