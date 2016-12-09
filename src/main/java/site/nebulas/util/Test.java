package site.nebulas.util;

import java.math.BigInteger;
/**
 * Created by Administrator on 2016/11/11.
 */
public class Test {
    public static void main(String[] args) {
        BigInteger p = new BigInteger("7");
        BigInteger q = new BigInteger("17");

        BigInteger n = null;
        n = p.multiply(q);
        System.out.println("n:" + n);

        BigInteger fn = null;
        fn = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
        System.out.println("fn:" + fn);

        for(Integer i = 2; i <= fn.intValue();i++){
            if(fn.gcd(new BigInteger(i.toString())).equals(new BigInteger("1"))){
                //System.out.println(i);
            }
        }

        //e需求
        BigInteger e = new BigInteger("5");
        //d需求
        BigInteger d = new BigInteger("7");

        //此时公开钥为{5,119}  {e,n}
        //私密钥为{77,119}    {d,n}

        //明文为19，求密文
        BigInteger m = new BigInteger("19");
        BigInteger c = null;
        c = m.pow(5).mod(n);
        System.out.println("密文为19,加密结果：" + c);

        //求明文
        m = c.pow(77).mod(n);
        System.out.println("密文为19,解密结果：" + m);
    }
}
