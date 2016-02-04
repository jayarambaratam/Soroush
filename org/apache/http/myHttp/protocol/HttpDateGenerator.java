package org.apache.http.myHttp.protocol;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.myHttp.annotation.GuardedBy;
import org.apache.http.myHttp.annotation.ThreadSafe;

@ThreadSafe
public class HttpDateGenerator {
    public static final TimeZone GMT;
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
    @GuardedBy("this")
    private long dateAsLong;
    @GuardedBy("this")
    private String dateAsText;
    @GuardedBy("this")
    private final DateFormat dateformat;

    static {
        GMT = TimeZone.getTimeZone("GMT");
    }

    public HttpDateGenerator() {
        this.dateAsLong = 0;
        this.dateAsText = null;
        this.dateformat = new SimpleDateFormat(PATTERN_RFC1123, Locale.US);
        this.dateformat.setTimeZone(GMT);
    }

    public synchronized String getCurrentDate() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dateAsLong > 1000) {
            this.dateAsText = this.dateformat.format(new Date(currentTimeMillis));
            this.dateAsLong = currentTimeMillis;
        }
        return this.dateAsText;
    }
}
