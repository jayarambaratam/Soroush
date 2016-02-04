package android.support.v7.p009c;

import java.util.Arrays;

/* renamed from: android.support.v7.c.c */
class C0409c {
    final /* synthetic */ C0407a f2013a;
    private int f2014b;
    private int f2015c;
    private int f2016d;
    private int f2017e;
    private int f2018f;
    private int f2019g;
    private int f2020h;
    private int f2021i;
    private int f2022j;

    C0409c(C0407a c0407a, int i, int i2) {
        this.f2013a = c0407a;
        this.f2014b = i;
        this.f2015c = i2;
        m3913d();
    }

    final int m3910a() {
        return (((this.f2018f - this.f2017e) + 1) * ((this.f2020h - this.f2019g) + 1)) * ((this.f2022j - this.f2021i) + 1);
    }

    final boolean m3911b() {
        return m3912c() > 1;
    }

    final int m3912c() {
        return (this.f2015c + 1) - this.f2014b;
    }

    final void m3913d() {
        int[] iArr = this.f2013a.f2007a;
        int[] iArr2 = this.f2013a.f2008b;
        int i = RtlSpacingHelper.UNDEFINED;
        int i2 = 0;
        int i3 = RtlSpacingHelper.UNDEFINED;
        int i4 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i5 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i6 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i7 = RtlSpacingHelper.UNDEFINED;
        for (int i8 = this.f2014b; i8 <= this.f2015c; i8++) {
            int i9 = iArr[i8];
            i2 += iArr2[i9];
            int a = C0407a.m3905h(i9);
            int b = C0407a.m3906i(i9);
            i9 = C0407a.m3907j(i9);
            if (a > i3) {
                i3 = a;
            }
            if (a < i6) {
                i6 = a;
            }
            if (b > i7) {
                i7 = b;
            }
            if (b < i5) {
                i5 = b;
            }
            if (i9 > i) {
                i = i9;
            }
            if (i9 < i4) {
                i4 = i9;
            }
        }
        this.f2017e = i6;
        this.f2018f = i3;
        this.f2019g = i5;
        this.f2020h = i7;
        this.f2021i = i4;
        this.f2022j = i;
        this.f2016d = i2;
    }

    final C0409c m3914e() {
        if (m3911b()) {
            int g = m3916g();
            C0409c c0409c = new C0409c(this.f2013a, g + 1, this.f2015c);
            this.f2015c = g;
            m3913d();
            return c0409c;
        }
        throw new IllegalStateException("Can not split a box with only 1 color");
    }

    final int m3915f() {
        int i = this.f2018f - this.f2017e;
        int i2 = this.f2020h - this.f2019g;
        int i3 = this.f2022j - this.f2021i;
        return (i < i2 || i < i3) ? (i2 < i || i2 < i3) ? -1 : -2 : -3;
    }

    final int m3916g() {
        int f = m3915f();
        int[] iArr = this.f2013a.f2007a;
        int[] iArr2 = this.f2013a.f2008b;
        C0407a.m3898b(iArr, f, this.f2014b, this.f2015c);
        Arrays.sort(iArr, this.f2014b, this.f2015c + 1);
        C0407a.m3898b(iArr, f, this.f2014b, this.f2015c);
        int i = this.f2016d / 2;
        f = 0;
        for (int i2 = this.f2014b; i2 <= this.f2015c; i2++) {
            f += iArr2[iArr[i2]];
            if (f >= i) {
                return i2;
            }
        }
        return this.f2014b;
    }

    final C0418l m3917h() {
        int i = 0;
        int[] iArr = this.f2013a.f2007a;
        int[] iArr2 = this.f2013a.f2008b;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = this.f2014b; i5 <= this.f2015c; i5++) {
            int i6 = iArr[i5];
            int i7 = iArr2[i6];
            i += i7;
            i4 += C0407a.m3905h(i6) * i7;
            i3 += C0407a.m3906i(i6) * i7;
            i2 += C0407a.m3907j(i6) * i7;
        }
        return new C0418l(C0407a.m3897b(Math.round(((float) i4) / ((float) i)), Math.round(((float) i3) / ((float) i)), Math.round(((float) i2) / ((float) i))), i);
    }
}
