package org.p253a.p254a;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: org.a.a.a */
public class C2639a {
    private static final C2641c f8362a;
    private static final Pattern f8363b;
    private static final C2641c f8364c;
    private static final Pattern f8365d;
    private static final C2641c f8366e;
    private static final Pattern f8367f;
    private static final C2641c f8368g;
    private static final Pattern f8369h;
    private static final C2641c f8370i;
    private static final Pattern f8371j;
    private static final C2641c f8372k;
    private static final Pattern f8373l;
    private static final C2641c f8374m;
    private static final Pattern f8375n;
    private static final DateFormat f8376o;
    private static final DateFormat f8377p;
    private static final DateFormat f8378q;
    private static final DateFormat f8379r;
    private static final Pattern f8380s;
    private static final List<C2642d> f8381t;
    private static final Pattern f8382u;

    static {
        f8362a = C2641c.XEP_0082_DATE_PROFILE;
        f8363b = Pattern.compile("^\\d+-\\d+-\\d+$");
        f8364c = C2641c.XEP_0082_TIME_MILLIS_ZONE_PROFILE;
        f8365d = Pattern.compile("^(\\d+:){2}\\d+.\\d+(Z|([+-](\\d+:\\d+)))$");
        f8366e = C2641c.XEP_0082_TIME_MILLIS_PROFILE;
        f8367f = Pattern.compile("^(\\d+:){2}\\d+.\\d+$");
        f8368g = C2641c.XEP_0082_TIME_ZONE_PROFILE;
        f8369h = Pattern.compile("^(\\d+:){2}\\d+(Z|([+-](\\d+:\\d+)))$");
        f8370i = C2641c.XEP_0082_TIME_PROFILE;
        f8371j = Pattern.compile("^(\\d+:){2}\\d+$");
        f8372k = C2641c.XEP_0082_DATETIME_MILLIS_PROFILE;
        f8373l = Pattern.compile("^\\d+(-\\d+){2}+T(\\d+:){2}\\d+.\\d+(Z|([+-](\\d+:\\d+)))?$");
        f8374m = C2641c.XEP_0082_DATETIME_PROFILE;
        f8375n = Pattern.compile("^\\d+(-\\d+){2}+T(\\d+:){2}\\d+(Z|([+-](\\d+:\\d+)))?$");
        f8376o = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ss");
        f8377p = new SimpleDateFormat("yyyyMd'T'HH:mm:ss");
        f8378q = new SimpleDateFormat("yyyyMdd'T'HH:mm:ss");
        f8379r = new SimpleDateFormat("yyyyMMd'T'HH:mm:ss");
        f8380s = Pattern.compile("^\\d+T\\d+:\\d+:\\d+$");
        f8381t = new ArrayList();
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        f8376o.setTimeZone(timeZone);
        f8377p.setTimeZone(timeZone);
        f8378q.setTimeZone(timeZone);
        f8378q.setLenient(false);
        f8379r.setTimeZone(timeZone);
        f8379r.setLenient(false);
        f8381t.add(new C2642d(f8363b, f8362a));
        f8381t.add(new C2642d(f8373l, f8372k));
        f8381t.add(new C2642d(f8375n, f8374m));
        f8381t.add(new C2642d(f8365d, f8364c));
        f8381t.add(new C2642d(f8367f, f8366e));
        f8381t.add(new C2642d(f8369h, f8368g));
        f8381t.add(new C2642d(f8371j, f8370i));
        f8382u = Pattern.compile(".*\\.(\\d{1,})(Z|((\\+|-)\\d{4}))");
    }

    public static String m11064a(Date date) {
        String a;
        synchronized (f8372k) {
            a = f8372k.m11077a(date);
        }
        return a;
    }

    public static String m11065a(TimeZone timeZone) {
        int rawOffset = timeZone.getRawOffset();
        rawOffset = Math.abs((rawOffset / 60000) - ((rawOffset / 3600000) * 60));
        return String.format("%+d:%02d", new Object[]{Integer.valueOf(r1), Integer.valueOf(rawOffset)});
    }

    private static Calendar m11066a(String str, DateFormat dateFormat) {
        try {
            Calendar calendar;
            synchronized (dateFormat) {
                dateFormat.parse(str);
                calendar = dateFormat.getCalendar();
            }
            return calendar;
        } catch (ParseException e) {
            return null;
        }
    }

    private static Calendar m11067a(Calendar calendar, List<Calendar> list) {
        Collections.sort(list, new C2640b(calendar));
        return (Calendar) list.get(0);
    }

    public static Date m11068a(String str) {
        Date a;
        for (C2642d c2642d : f8381t) {
            if (c2642d.f8397a.matcher(str).matches()) {
                return c2642d.f8398b.m11078a(str);
            }
        }
        synchronized (f8374m) {
            a = f8374m.m11078a(str);
        }
        return a;
    }

    private static Date m11069a(String str, int i) {
        if (i == 6) {
            Date parse;
            synchronized (f8377p) {
                parse = f8377p.parse(str);
            }
            return parse;
        }
        Calendar instance = Calendar.getInstance();
        Calendar a = C2639a.m11066a(str, f8378q);
        Calendar a2 = C2639a.m11066a(str, f8379r);
        List a3 = C2639a.m11070a(instance, a, a2);
        return !a3.isEmpty() ? C2639a.m11067a(instance, a3).getTime() : null;
    }

    private static List<Calendar> m11070a(Calendar calendar, Calendar... calendarArr) {
        List<Calendar> arrayList = new ArrayList();
        for (Calendar calendar2 : calendarArr) {
            if (calendar2 != null && calendar2.before(calendar)) {
                arrayList.add(calendar2);
            }
        }
        return arrayList;
    }

    public static Date m11071b(String str) {
        if (f8380s.matcher(str).matches()) {
            int length = str.split("T")[0].length();
            Date a;
            if (length < 8) {
                a = C2639a.m11069a(str, length);
                if (a != null) {
                    return a;
                }
            }
            synchronized (f8376o) {
                a = f8376o.parse(str);
            }
            return a;
        }
        return C2639a.m11068a(str);
    }

    public static String m11072c(String str) {
        return str.charAt(str.length() + -1) == 'Z' ? str.replace("Z", "+0000") : str.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
    }

    public static String m11073d(String str) {
        int length = str.length();
        return (str.substring(0, length - 2) + ':') + str.substring(length - 2, length);
    }

    private static String m11075f(String str) {
        Matcher matcher = f8382u.matcher(str);
        if (!matcher.matches()) {
            return str;
        }
        int length = matcher.group(1).length();
        if (length == 3) {
            return str;
        }
        int indexOf = str.indexOf(".");
        StringBuilder stringBuilder = new StringBuilder((str.length() - length) + 3);
        if (length > 3) {
            stringBuilder.append(str.substring(0, indexOf + 4));
        } else {
            stringBuilder.append(str.substring(0, (indexOf + length) + 1));
            for (int i = length; i < 3; i++) {
                stringBuilder.append('0');
            }
        }
        stringBuilder.append(str.substring((indexOf + length) + 1));
        return stringBuilder.toString();
    }
}
