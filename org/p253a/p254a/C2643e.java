package org.p253a.p254a;

import net.frakbot.glowpadbackport.BuildConfig;
import org.p253a.p254a.p255a.C2638e;

/* renamed from: org.a.a.e */
public class C2643e {
    private static final C2638e<String, String> f8399a;
    private static final C2638e<String, String> f8400b;

    static {
        f8399a = new C2638e(100);
        f8400b = new C2638e(100);
    }

    public static String m11079a(CharSequence charSequence, CharSequence charSequence2) {
        return C2643e.m11081a(charSequence != null ? charSequence.toString() : null, charSequence2.toString());
    }

    public static String m11080a(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(64);
        if (indexOf <= 0) {
            return BuildConfig.FLAVOR;
        }
        int indexOf2 = str.indexOf(47);
        return (indexOf2 < 0 || indexOf2 >= indexOf) ? str.substring(0, indexOf) : BuildConfig.FLAVOR;
    }

    public static String m11081a(String str, String str2) {
        return C2643e.m11082a(str, str2, null);
    }

    public static String m11082a(String str, String str2, String str3) {
        int i = 0;
        if (str2 == null) {
            throw new IllegalArgumentException("domainpart must not be null");
        }
        int length = str != null ? str.length() : 0;
        int length2 = str2.length();
        if (str3 != null) {
            i = str3.length();
        }
        StringBuilder stringBuilder = new StringBuilder(((length2 + length) + i) + 2);
        if (length > 0) {
            stringBuilder.append(str).append('@');
        }
        stringBuilder.append(str2);
        if (i > 0) {
            stringBuilder.append('/').append(str3);
        }
        return stringBuilder.toString();
    }

    public static String m11083b(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(64);
        if (indexOf + 1 > str.length()) {
            return BuildConfig.FLAVOR;
        }
        int indexOf2 = str.indexOf(47);
        return indexOf2 > 0 ? indexOf2 > indexOf ? str.substring(indexOf + 1, indexOf2) : str.substring(0, indexOf2) : str.substring(indexOf + 1);
    }

    public static String m11084b(String str, String str2) {
        return str + '\t' + str2;
    }

    public static String m11085c(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        return (indexOf + 1 > str.length() || indexOf < 0) ? BuildConfig.FLAVOR : str.substring(indexOf + 1);
    }

    public static String m11086d(String str) {
        int indexOf = str.indexOf(47);
        return indexOf < 0 ? str : indexOf == 0 ? BuildConfig.FLAVOR : str.substring(0, indexOf);
    }

    public static boolean m11087e(String str) {
        return C2643e.m11080a(str).length() > 0 && C2643e.m11083b(str).length() > 0 && C2643e.m11085c(str).length() > 0;
    }
}
