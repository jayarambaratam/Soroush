package org.apache.http.myHttp.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetUtils {
    public static Charset get(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (UnsupportedCharsetException e) {
            throw new UnsupportedEncodingException(str);
        }
    }

    public static Charset lookup(String str) {
        Charset charset = null;
        if (str != null) {
            try {
                charset = Charset.forName(str);
            } catch (UnsupportedCharsetException e) {
            }
        }
        return charset;
    }
}
