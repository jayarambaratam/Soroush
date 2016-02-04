package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components;

import android.text.TextUtils;
import android.view.View;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.s */
public class C2474s {
    public final int f8040a;
    public final boolean f8041b;
    public final int f8042c;
    public final String f8043d;
    public final int f8044e;
    public final int f8045f;
    public final int f8046g;
    public final int f8047h;
    public final int f8048i;
    final int f8049j;
    final int f8050k;
    C2461j f8051l;

    public C2474s(LayoutManager layoutManager, View view) {
        int paddingStart = layoutManager.getPaddingStart();
        int paddingEnd = layoutManager.getPaddingEnd();
        this.f8051l = (C2461j) view.getLayoutParams();
        if (this.f8051l.f8010a) {
            this.f8045f = layoutManager.getDecoratedMeasuredWidth(view);
            this.f8046g = layoutManager.getDecoratedMeasuredHeight(view);
            if (!this.f8051l.m10772f() || this.f8051l.m10773g()) {
                this.f8042c = this.f8046g;
            } else {
                this.f8042c = 0;
            }
            if (!this.f8051l.f8014e) {
                this.f8049j = this.f8051l.f8013d;
            } else if (!this.f8051l.m10774h() || this.f8051l.m10773g()) {
                this.f8049j = 0;
            } else {
                this.f8049j = this.f8045f;
            }
            if (!this.f8051l.f8015f) {
                this.f8050k = this.f8051l.f8012c;
            } else if (!this.f8051l.m10771e() || this.f8051l.m10773g()) {
                this.f8050k = 0;
            } else {
                this.f8050k = this.f8045f;
            }
        } else {
            this.f8042c = 0;
            this.f8046g = 0;
            this.f8045f = 0;
            this.f8049j = this.f8051l.f8013d;
            this.f8050k = this.f8051l.f8012c;
        }
        this.f8047h = this.f8050k + paddingEnd;
        this.f8048i = this.f8049j + paddingStart;
        this.f8041b = this.f8051l.f8010a;
        this.f8040a = this.f8051l.m10770d();
        this.f8043d = this.f8051l.f8016g;
        this.f8044e = this.f8051l.f8017h;
    }

    public int m10796a() {
        return this.f8050k + this.f8049j;
    }

    public boolean m10797a(C2461j c2461j) {
        return c2461j.f8017h == this.f8044e || TextUtils.equals(c2461j.f8016g, this.f8043d);
    }
}
