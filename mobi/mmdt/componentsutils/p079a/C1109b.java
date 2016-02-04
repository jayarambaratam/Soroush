package mobi.mmdt.componentsutils.p079a;

import java.util.Calendar;
import java.util.Date;

/* renamed from: mobi.mmdt.componentsutils.a.b */
public class C1109b {
    public static Date f4147a;

    static {
        f4147a = new Date(Long.MAX_VALUE);
    }

    public static boolean m6382a(Calendar calendar) {
        if (calendar == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.set(6, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return calendar.getTimeInMillis() >= instance.getTimeInMillis();
    }

    public static boolean m6383a(Calendar calendar, int i) {
        if (calendar == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.add(6, -i);
        return C1109b.m6386b(calendar, instance) && !C1109b.m6386b(calendar, instance2);
    }

    public static boolean m6384a(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        } else {
            throw new IllegalArgumentException("The dates must not be null");
        }
    }

    public static boolean m6385b(Calendar calendar) {
        return C1109b.m6384a(calendar, Calendar.getInstance());
    }

    public static boolean m6386b(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(0) < calendar2.get(0) ? true : calendar.get(0) > calendar2.get(0) ? false : calendar.get(1) >= calendar2.get(1) ? calendar.get(1) > calendar2.get(1) ? false : calendar.get(6) < calendar2.get(6) : true;
        } else {
            throw new IllegalArgumentException("The dates must not be null");
        }
    }
}
