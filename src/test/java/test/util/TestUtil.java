package test.util;

import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;
import java.nio.charset.Charset;
import java.util.List;

public class TestUtil {
    public static String waveDash2FullwidthTilde(String s) {
        if(Charset.defaultCharset().equals(Charset.forName("windows-31j"))){
            return s.replace('〜', '～');
        }
        return s;
    }

    public static void assertVariableList(List<String> expected, List<String> actual){
        assertEquals(expected.size(), actual.size());
        for(int i = 0; i < expected.size(); i++){
            String exp = expected.get(i);
            if(!"*any*".equals(exp)){
                assertEquals(exp, actual.get(i));
            }
        }
    }
}
