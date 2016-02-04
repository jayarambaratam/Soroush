package android.support.v4.p015e;

import java.util.Locale;
import org.linphone.core.VideoSize;

/* renamed from: android.support.v4.e.s */
class C0219s {
    private C0219s() {
    }

    private static int m1655b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case VideoSize.CIF /*1*/:
            case VideoSize.HVGA /*2*/:
                return 1;
            default:
                return 0;
        }
    }

    public int m1656a(Locale locale) {
        if (!(locale == null || locale.equals(C0217q.f1121a))) {
            String a = C0201a.m1630a(locale);
            if (a == null) {
                return C0219s.m1655b(locale);
            }
            if (a.equalsIgnoreCase(C0217q.f1123c) || a.equalsIgnoreCase(C0217q.f1124d)) {
                return 1;
            }
        }
        return 0;
    }
}
