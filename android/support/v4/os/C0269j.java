package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.os.j */
public class C0269j {
    public static <T> Creator<T> m1809a(C0065l<T> c0065l) {
        return VERSION.SDK_INT >= 13 ? C0272n.m1810a(c0065l) : new C0270k(c0065l);
    }
}
