package org.apache.http.myHttp;

import java.nio.charset.Charset;
import org.apache.http.myHttp.protocol.HTTP;
import org.jivesoftware.smack.util.StringUtils;

public final class Consts {
    public static final Charset ASCII;
    public static final int CR = 13;
    public static final int HT = 9;
    public static final Charset ISO_8859_1;
    public static final int LF = 10;
    public static final int SP = 32;
    public static final Charset UTF_8;

    static {
        UTF_8 = Charset.forName(StringUtils.UTF8);
        ASCII = Charset.forName(StringUtils.USASCII);
        ISO_8859_1 = Charset.forName(HTTP.ISO_8859_1);
    }

    private Consts() {
    }
}
