package android.support.v4.view.p017a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.View;
import mobi.mmdt.ott.C1317h;
import org.apache.http.myHttp.protocol.HTTP;
import org.linphone.core.Privacy;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: android.support.v4.view.a.g */
public class C0284g {
    private static final C0286l f1294a;
    private final Object f1295b;

    static {
        if (VERSION.SDK_INT >= 22) {
            f1294a = new C0294j();
        } else if (VERSION.SDK_INT >= 21) {
            f1294a = new C0293i();
        } else if (VERSION.SDK_INT >= 19) {
            f1294a = new C0292p();
        } else if (VERSION.SDK_INT >= 18) {
            f1294a = new C0291o();
        } else if (VERSION.SDK_INT >= 17) {
            f1294a = new C0290n();
        } else if (VERSION.SDK_INT >= 16) {
            f1294a = new C0289m();
        } else if (VERSION.SDK_INT >= 14) {
            f1294a = new C0288k();
        } else {
            f1294a = new C0287q();
        }
    }

    public C0284g(Object obj) {
        this.f1295b = obj;
    }

    public static C0284g m1941a(C0284g c0284g) {
        return C0284g.m1942a(f1294a.m1996a(c0284g.f1295b));
    }

    static C0284g m1942a(Object obj) {
        return obj != null ? new C0284g(obj) : null;
    }

    private static String m1943b(int i) {
        switch (i) {
            case VideoSize.CIF /*1*/:
                return "ACTION_FOCUS";
            case VideoSize.HVGA /*2*/:
                return "ACTION_CLEAR_FOCUS";
            case Version.API04_DONUT_16 /*4*/:
                return "ACTION_SELECT";
            case Version.API08_FROYO_22 /*8*/:
                return "ACTION_CLEAR_SELECTION";
            case Version.API16_JELLY_BEAN_41 /*16*/:
                return "ACTION_CLICK";
            case HTTP.SP /*32*/:
                return "ACTION_LONG_CLICK";
            case C1317h.Theme_imageButtonStyle /*64*/:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case ItemAnimator.FLAG_MOVED /*2048*/:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT /*4096*/:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case Privacy.DEFAULT /*32768*/:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public Object m1945a() {
        return this.f1295b;
    }

    public void m1946a(int i) {
        f1294a.m1997a(this.f1295b, i);
    }

    public void m1947a(Rect rect) {
        f1294a.m1998a(this.f1295b, rect);
    }

    public void m1948a(View view) {
        f1294a.m2011c(this.f1295b, view);
    }

    public void m1949a(CharSequence charSequence) {
        f1294a.m2018d(this.f1295b, charSequence);
    }

    public void m1950a(boolean z) {
        f1294a.m2014c(this.f1295b, z);
    }

    public boolean m1951a(C0285h c0285h) {
        return f1294a.m2002a(this.f1295b, c0285h.f1318w);
    }

    public int m1952b() {
        return f1294a.m2003b(this.f1295b);
    }

    public void m1953b(Rect rect) {
        f1294a.m2010c(this.f1295b, rect);
    }

    public void m1954b(View view) {
        f1294a.m1999a(this.f1295b, view);
    }

    public void m1955b(CharSequence charSequence) {
        f1294a.m2006b(this.f1295b, charSequence);
    }

    public void m1956b(Object obj) {
        f1294a.m2007b(this.f1295b, ((C0295r) obj).f1319a);
    }

    public void m1957b(boolean z) {
        f1294a.m2019d(this.f1295b, z);
    }

    public void m1958c(Rect rect) {
        f1294a.m2004b(this.f1295b, rect);
    }

    public void m1959c(View view) {
        f1294a.m2005b(this.f1295b, view);
    }

    public void m1960c(CharSequence charSequence) {
        f1294a.m2021e(this.f1295b, charSequence);
    }

    public void m1961c(Object obj) {
        f1294a.m2013c(this.f1295b, ((C0296s) obj).f1320a);
    }

    public void m1962c(boolean z) {
        f1294a.m2027h(this.f1295b, z);
    }

    public boolean m1963c() {
        return f1294a.m2026g(this.f1295b);
    }

    public void m1964d(Rect rect) {
        f1294a.m2016d(this.f1295b, rect);
    }

    public void m1965d(View view) {
        f1294a.m2017d(this.f1295b, view);
    }

    public void m1966d(CharSequence charSequence) {
        f1294a.m2012c(this.f1295b, charSequence);
    }

    public void m1967d(boolean z) {
        f1294a.m2029i(this.f1295b, z);
    }

    public boolean m1968d() {
        return f1294a.m2028h(this.f1295b);
    }

    public void m1969e(CharSequence charSequence) {
        f1294a.m2000a(this.f1295b, charSequence);
    }

    public void m1970e(boolean z) {
        f1294a.m2025g(this.f1295b, z);
    }

    public boolean m1971e() {
        return f1294a.m2033k(this.f1295b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0284g c0284g = (C0284g) obj;
        return this.f1295b == null ? c0284g.f1295b == null : this.f1295b.equals(c0284g.f1295b);
    }

    public void m1972f(boolean z) {
        f1294a.m2001a(this.f1295b, z);
    }

    public boolean m1973f() {
        return f1294a.m2034l(this.f1295b);
    }

    public void m1974g(boolean z) {
        f1294a.m2022e(this.f1295b, z);
    }

    public boolean m1975g() {
        return f1294a.m2040r(this.f1295b);
    }

    public void m1976h(boolean z) {
        f1294a.m2008b(this.f1295b, z);
    }

    public boolean m1977h() {
        return f1294a.m2041s(this.f1295b);
    }

    public int hashCode() {
        return this.f1295b == null ? 0 : this.f1295b.hashCode();
    }

    public void m1978i(boolean z) {
        f1294a.m2024f(this.f1295b, z);
    }

    public boolean m1979i() {
        return f1294a.m2038p(this.f1295b);
    }

    public void m1980j(boolean z) {
        f1294a.m2031j(this.f1295b, z);
    }

    public boolean m1981j() {
        return f1294a.m2030i(this.f1295b);
    }

    public boolean m1982k() {
        return f1294a.m2035m(this.f1295b);
    }

    public boolean m1983l() {
        return f1294a.m2032j(this.f1295b);
    }

    public boolean m1984m() {
        return f1294a.m2036n(this.f1295b);
    }

    public boolean m1985n() {
        return f1294a.m2037o(this.f1295b);
    }

    public CharSequence m1986o() {
        return f1294a.m2020e(this.f1295b);
    }

    public CharSequence m1987p() {
        return f1294a.m2009c(this.f1295b);
    }

    public CharSequence m1988q() {
        return f1294a.m2023f(this.f1295b);
    }

    public CharSequence m1989r() {
        return f1294a.m2015d(this.f1295b);
    }

    public void m1990s() {
        f1294a.m2039q(this.f1295b);
    }

    public String m1991t() {
        return f1294a.m2042t(this.f1295b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m1947a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m1958c(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m1986o());
        stringBuilder.append("; className: ").append(m1987p());
        stringBuilder.append("; text: ").append(m1988q());
        stringBuilder.append("; contentDescription: ").append(m1989r());
        stringBuilder.append("; viewId: ").append(m1991t());
        stringBuilder.append("; checkable: ").append(m1963c());
        stringBuilder.append("; checked: ").append(m1968d());
        stringBuilder.append("; focusable: ").append(m1971e());
        stringBuilder.append("; focused: ").append(m1973f());
        stringBuilder.append("; selected: ").append(m1979i());
        stringBuilder.append("; clickable: ").append(m1981j());
        stringBuilder.append("; longClickable: ").append(m1982k());
        stringBuilder.append("; enabled: ").append(m1983l());
        stringBuilder.append("; password: ").append(m1984m());
        stringBuilder.append("; scrollable: " + m1985n());
        stringBuilder.append("; [");
        int b = m1952b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(C0284g.m1943b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
