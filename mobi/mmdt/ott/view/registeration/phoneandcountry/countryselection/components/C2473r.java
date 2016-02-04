package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components;

import android.view.View;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.r */
public class C2473r extends C2459t {
    public static int f8039a;

    static {
        f8039a = 1;
    }

    public C2473r(LayoutManager layoutManager) {
        super(layoutManager);
    }

    private int m10789a(C2472q c2472q, int i, C2465i c2465i, C2474s c2474s, C2471p c2471p) {
        int i2;
        int i3;
        int decoratedMeasuredHeight = this.b.getDecoratedMeasuredHeight(c2472q.f8037a);
        int decoratedMeasuredWidth = this.b.getDecoratedMeasuredWidth(c2472q.f8037a);
        int i4 = c2471p.f8035c ? c2474s.f8048i : c2474s.f8047h;
        int i5 = i4 + decoratedMeasuredWidth;
        if (c2465i == C2465i.END) {
            i2 = i + decoratedMeasuredHeight;
            i3 = i;
        } else {
            i3 = i - decoratedMeasuredHeight;
            i2 = i;
        }
        this.b.layoutDecorated(c2472q.f8037a, i4, i3, i5, i2);
        return c2465i == C2465i.END ? this.b.getDecoratedBottom(c2472q.f8037a) : this.b.getDecoratedTop(c2472q.f8037a);
    }

    private void m10790a(C2472q c2472q, C2474s c2474s) {
        this.b.measureChildWithMargins(c2472q.f8037a, c2474s.m10796a(), 0);
    }

    public int m10791a(int i, int i2, int i3, C2474s c2474s, C2471p c2471p) {
        int itemCount = c2471p.m10782a().getItemCount();
        int i4 = i2;
        while (i3 < itemCount && i4 < i) {
            C2472q c = c2471p.m10787c(i3);
            if (c.m10788a().m10770d() != c2474s.f8040a) {
                c2471p.m10784a(i3, c.f8037a);
                break;
            }
            m10790a(c, c2474s);
            i4 = m10789a(c, i4, C2465i.END, c2474s, c2471p);
            m10736a(c, i3, C2465i.END, c2471p);
            i3++;
        }
        return i4;
    }

    public int m10792a(int i, View view, C2474s c2474s, C2471p c2471p) {
        int position = this.b.getPosition(view);
        return m10791a(i, this.b.getDecoratedBottom(view), position + 1, c2474s, c2471p);
    }

    public int m10793a(int i, C2474s c2474s, C2471p c2471p) {
        int i2 = c2474s.f8040a + 1;
        int i3 = 0;
        while (i3 < c2474s.f8046g && i2 < i) {
            C2472q c = c2471p.m10787c(i2);
            m10790a(c, c2474s);
            i3 += this.b.getDecoratedMeasuredHeight(c.f8037a);
            c2471p.m10784a(i2, c.f8037a);
            i2++;
        }
        return i3 == c2474s.f8046g ? 0 : i3 > c2474s.f8046g ? 1 : -i3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m10794b(int r10, int r11, int r12, mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2474s r13, mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2471p r14) {
        /*
        r9 = this;
        r2 = 0;
        r1 = r2;
    L_0x0002:
        r0 = r14.m10782a();
        r0 = r0.getItemCount();
        if (r1 >= r0) goto L_0x00b9;
    L_0x000c:
        r0 = r9.b;
        r0 = r0.getChildAt(r2);
        if (r0 != 0) goto L_0x0044;
    L_0x0014:
        r8 = r2;
    L_0x0015:
        r1 = -1;
        if (r8 == 0) goto L_0x00b4;
    L_0x0018:
        r3 = r12;
        r0 = r2;
    L_0x001a:
        if (r3 < 0) goto L_0x0031;
    L_0x001c:
        r4 = r14.m10787c(r3);
        r5 = r4.f8037a;
        r14.m10784a(r3, r5);
        r5 = r4.m10788a();
        r6 = r5.m10770d();
        r7 = r13.f8040a;
        if (r6 == r7) goto L_0x005f;
    L_0x0031:
        r3 = r13.f8042c;
        if (r0 >= r3) goto L_0x00b4;
    L_0x0035:
        r2 = r13.f8042c;
        r2 = r0 - r2;
        r11 = r11 + r2;
        r6 = r2;
        r7 = r1;
    L_0x003c:
        r2 = r11;
    L_0x003d:
        if (r12 < 0) goto L_0x0043;
    L_0x003f:
        r0 = r2 - r6;
        if (r0 > r10) goto L_0x0078;
    L_0x0043:
        return r2;
    L_0x0044:
        r0 = r0.getLayoutParams();
        r0 = (mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2461j) r0;
        r3 = r0.m10770d();
        r4 = r13.f8040a;
        if (r3 == r4) goto L_0x0055;
    L_0x0052:
        r0 = 1;
        r8 = r0;
        goto L_0x0015;
    L_0x0055:
        r0 = r0.f8010a;
        if (r0 != 0) goto L_0x005b;
    L_0x0059:
        r8 = r2;
        goto L_0x0015;
    L_0x005b:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0002;
    L_0x005f:
        r5 = r5.f8010a;
        if (r5 == 0) goto L_0x0066;
    L_0x0063:
        r3 = r3 + -1;
        goto L_0x001a;
    L_0x0066:
        r9.m10790a(r4, r13);
        r1 = r9.b;
        r4 = r4.f8037a;
        r1 = r1.getDecoratedMeasuredHeight(r4);
        r0 = r0 + r1;
        r1 = r13.f8042c;
        if (r0 < r1) goto L_0x00b7;
    L_0x0076:
        r1 = r3;
        goto L_0x0031;
    L_0x0078:
        r1 = r14.m10787c(r12);
        r0 = r1.m10788a();
        r3 = r0.f8010a;
        if (r3 == 0) goto L_0x008a;
    L_0x0084:
        r0 = r1.f8037a;
        r14.m10784a(r12, r0);
        goto L_0x0043;
    L_0x008a:
        r0 = r0.m10770d();
        r3 = r13.f8040a;
        if (r0 == r3) goto L_0x0098;
    L_0x0092:
        r0 = r1.f8037a;
        r14.m10784a(r12, r0);
        goto L_0x0043;
    L_0x0098:
        if (r8 == 0) goto L_0x009c;
    L_0x009a:
        if (r12 >= r7) goto L_0x00b0;
    L_0x009c:
        r9.m10790a(r1, r13);
    L_0x009f:
        r3 = mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2465i.START;
        r0 = r9;
        r4 = r13;
        r5 = r14;
        r2 = r0.m10789a(r1, r2, r3, r4, r5);
        r0 = mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2465i.START;
        r9.m10736a(r1, r12, r0, r14);
        r12 = r12 + -1;
        goto L_0x003d;
    L_0x00b0:
        r14.m10783a(r12);
        goto L_0x009f;
    L_0x00b4:
        r6 = r2;
        r7 = r1;
        goto L_0x003c;
    L_0x00b7:
        r1 = r3;
        goto L_0x0063;
    L_0x00b9:
        r8 = r2;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.r.b(int, int, int, mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.s, mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.p):int");
    }

    public int m10795b(int i, View view, C2474s c2474s, C2471p c2471p) {
        int position = this.b.getPosition(view);
        return m10794b(i, this.b.getDecoratedTop(view), position - 1, c2474s, c2471p);
    }
}
