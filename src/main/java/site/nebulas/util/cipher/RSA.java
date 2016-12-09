package site.nebulas.util.cipher;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by Administrator on 2016/12/6.
 */
public class RSA {
    private static String str = "hello";

    public static void main(String[] args) {
        try {
            //1.密钥初始化
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            //获取公钥
            RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
            //获取私钥
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();

            System.out.println("PublicKey:"+Base64.encodeBase64String(rsaPublicKey.getEncoded()));
            System.out.println("PrivateKey:"+Base64.encodeBase64String(rsaPrivateKey.getEncoded()));

            //私钥加密、公钥解密-----加密
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE,privateKey);
            byte[] restlt = cipher.doFinal(str.getBytes());
            System.out.println("私钥加密、公钥解密-----加密结果："+ Base64.encodeBase64String(restlt));

            //私钥加密、公钥解密-----解密
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
            keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE,publicKey);
            restlt = cipher.doFinal(restlt);
            System.out.println("私钥加密、公钥解密-----解密结果："+ new String(restlt));

            //公钥加密、私钥解密-----加密
            x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
            keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            restlt = cipher.doFinal(restlt);
            System.out.println("公钥加密、私钥解密-----加密结果："+ Base64.encodeBase64String(restlt));

            //公钥加密、私钥解密-----解密
            pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
            keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE,privateKey);
            restlt = cipher.doFinal(restlt);
            System.out.println("公钥加密、私钥解密-----解密结果："+ new String(restlt));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
