package site.nebulas.util.cipher;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by Administrator on 2016/12/6.
 */
public class DESUtil {
    private static String str = "hello";
    public static void main(String[] args) {
        try {
            //生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytesKey = secretKey.getEncoded();

            //Key转换
            DESKeySpec desKeySpec =new DESKeySpec(bytesKey);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            Key key = secretKeyFactory.generateSecret(desKeySpec);

            //加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] result = cipher.doFinal(str.getBytes());
            System.out.println("加密结果：" + Base64.encodeBase64String(result));

            //解密
            cipher.init(Cipher.DECRYPT_MODE,key);
            result = cipher.doFinal(result);
            System.out.println("解密结果：" + new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
