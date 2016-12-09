package site.nebulas.util.cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/28.
 */
public class Base64Util {
    public static void main(String[] args) {
        String str = "this is base64";
        String temp = Base64Util.encode(str);
        System.out.println(temp);

        System.out.println(Base64Util.decode(temp));
    }

    /**
     * Base64解密
     * */
    public static String decode(String str){
        BASE64Decoder decode = new BASE64Decoder();
        String res = "";
        try {
            res =  new String(decode.decodeBuffer(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    /**
     * Base64加密
     * */
    public static String encode(String str){
        BASE64Encoder encode = new BASE64Encoder();
        return encode.encode(str.getBytes());
    }
}
