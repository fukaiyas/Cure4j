package test.util;

import java.nio.charset.Charset;

public class TestUtil {
    public static String waveDash2FullwidthTilde(String s) {
        if(Charset.defaultCharset().equals(Charset.forName("windows-31j"))){
            return s.replace('〜', '～');
        }
        return s;
    }
}
