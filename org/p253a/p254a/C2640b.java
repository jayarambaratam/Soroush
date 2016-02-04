package org.p253a.p254a;

import java.util.Calendar;
import java.util.Comparator;

/* renamed from: org.a.a.b */
final class C2640b implements Comparator<Calendar> {
    final /* synthetic */ Calendar f8383a;

    C2640b(Calendar calendar) {
        this.f8383a = calendar;
    }

    public int m11076a(Calendar calendar, Calendar calendar2) {
        return new Long(this.f8383a.getTimeInMillis() - calendar.getTimeInMillis()).compareTo(new Long(this.f8383a.getTimeInMillis() - calendar2.getTimeInMillis()));
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m11076a((Calendar) obj, (Calendar) obj2);
    }
}
