package site.nebulas.util;

import java.io.File;

/**
 * Created by Administrator on 2016/12/9.
 */
public class FileUtil {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        list = path.list();
        for (String s: list) {
            System.out.println(s);
        }
    }
}
