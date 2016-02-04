package org.p253a.p254a;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: org.a.a.c */
public enum C2641c {
    XEP_0082_DATE_PROFILE("yyyy-MM-dd"),
    XEP_0082_DATETIME_PROFILE("yyyy-MM-dd'T'HH:mm:ssZ"),
    XEP_0082_DATETIME_MILLIS_PROFILE("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
    XEP_0082_TIME_PROFILE("hh:mm:ss"),
    XEP_0082_TIME_ZONE_PROFILE("hh:mm:ssZ"),
    XEP_0082_TIME_MILLIS_PROFILE("hh:mm:ss.SSS"),
    XEP_0082_TIME_MILLIS_ZONE_PROFILE("hh:mm:ss.SSSZ"),
    XEP_0091_DATETIME("yyyyMMdd'T'HH:mm:ss");
    
    private final String f8393i;
    private final DateFormat f8394j;
    private final boolean f8395k;
    private final boolean f8396l;

    private C2641c(String str) {
        this.f8393i = str;
        this.f8394j = new SimpleDateFormat(this.f8393i);
        this.f8394j.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.f8395k = str.charAt(str.length() + -1) == 'Z';
        this.f8396l = str.contains("SSS");
    }

    public String m11077a(Date date) {
        String format;
        synchronized (this.f8394j) {
            format = this.f8394j.format(date);
        }
        return this.f8395k ? C2639a.m11073d(format) : format;
    }

    public Date m11078a(String str) {
        Date parse;
        if (this.f8395k) {
            str = C2639a.m11072c(str);
        }
        if (this.f8396l) {
            str = C2639a.m11075f(str);
        }
        synchronized (this.f8394j) {
            parse = this.f8394j.parse(str);
        }
        return parse;
    }
}
