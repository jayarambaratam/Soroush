package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.e */
public class C2460e extends C2459t {
    public static int f8004a;
    private final Context f8005c;
    private int f8006d;
    private int f8007e;
    private int f8008f;
    private boolean f8009g;

    static {
        f8004a = 2;
    }

    public C2460e(LayoutManager layoutManager, Context context) {
        super(layoutManager);
        this.f8006d = 0;
        this.f8007e = 0;
        this.f8005c = context;
    }

    private void m10746a(C2472q c2472q, int i, int i2, int i3, C2474s c2474s, C2471p c2471p) {
        if (c2472q.m10788a().height != -1) {
            i3 = this.b.getDecoratedMeasuredHeight(c2472q.f8037a);
        }
        int i4 = (this.f8008f * i2) + (c2471p.f8035c ? c2474s.f8048i : c2474s.f8047h);
        this.b.layoutDecorated(c2472q.f8037a, i4, i, i4 + (i2 == this.f8007e + -1 ? this.b.getDecoratedMeasuredWidth(c2472q.f8037a) : Math.min(this.f8008f, this.b.getDecoratedMeasuredWidth(c2472q.f8037a))), i + i3);
    }

    private void m10747a(C2472q c2472q, C2474s c2474s) {
        this.b.measureChildWithMargins(c2472q.f8037a, ((this.f8007e - 1) * this.f8008f) + (c2474s.f8049j + c2474s.f8050k), 0);
    }

    private void m10748c(C2474s c2474s) {
        int width = (this.b.getWidth() - c2474s.f8048i) - c2474s.f8047h;
        if (!this.f8009g) {
            if (this.f8006d <= 0) {
                this.f8006d = (int) TypedValue.applyDimension(1, 48.0f, this.f8005c.getResources().getDisplayMetrics());
            }
            this.f8007e = width / Math.abs(this.f8006d);
        }
        if (this.f8007e < 1) {
            this.f8007e = 1;
        }
        this.f8008f = width / this.f8007e;
        if (this.f8008f == 0) {
            Log.e("GridSection", "Too many columns (" + this.f8007e + ") for available width" + width + ".");
        }
    }

    public int m10749a(int i, int i2, int i3) {
        Object obj = null;
        int width = this.b.getWidth();
        int i4 = 0;
        while (i2 >= 0) {
            View childAt = this.b.getChildAt(i2);
            C2461j c2461j = (C2461j) childAt.getLayoutParams();
            if (c2461j.m10770d() != i) {
                break;
            }
            int left;
            Object obj2;
            if (!c2461j.f8010a) {
                if (childAt.getLeft() >= width) {
                    break;
                }
                left = childAt.getLeft();
                obj2 = 1;
                width = Math.max(i4, this.b.getDecoratedBottom(childAt));
            } else {
                obj2 = obj;
                left = width;
                width = i4;
            }
            i2--;
            i4 = width;
            width = left;
            obj = obj2;
        }
        return obj != null ? i4 : i3;
    }

    public int m10750a(int i, int i2, int i3, C2474s c2474s, C2471p c2471p) {
        if (i2 >= i) {
            return i2;
        }
        int itemCount = c2471p.m10782a().getItemCount();
        if (i3 >= itemCount) {
            return i2;
        }
        C2472q c = c2471p.m10787c(i3);
        c2471p.m10784a(i3, c.f8037a);
        if (c.m10788a().m10770d() != c2474s.f8040a) {
            return i2;
        }
        int i4;
        int i5 = (i3 - (c2474s.f8041b ? c2474s.f8040a + 1 : c2474s.f8040a)) % this.f8007e;
        int i6 = 1;
        int i7 = i2;
        while (i6 <= i5) {
            int decoratedTop;
            i4 = 1;
            while (i4 <= this.b.getChildCount()) {
                View childAt = this.b.getChildAt(this.b.getChildCount() - i4);
                if (this.b.getPosition(childAt) == i3 - i6) {
                    decoratedTop = this.b.getDecoratedTop(childAt);
                    this.b.detachAndScrapViewAt(i4, c2471p.f8033a);
                    break;
                } else if (((C2461j) childAt.getLayoutParams()).m10770d() != c2474s.f8040a) {
                    decoratedTop = i7;
                    break;
                } else {
                    i4++;
                }
            }
            decoratedTop = i7;
            i6++;
            i7 = decoratedTop;
        }
        i4 = i7;
        i7 = i3 - i5;
        while (i7 < itemCount && i4 <= i) {
            c = c2471p.m10787c(i7);
            if (c.m10788a().m10770d() != c2474s.f8040a) {
                c2471p.m10784a(i7, c.f8037a);
                break;
            }
            i4 += m10751a(i4, i7, C2465i.END, true, c2474s, c2471p);
            i7 += this.f8007e;
        }
        return i4;
    }

    public int m10751a(int i, int i2, C2465i c2465i, boolean z, C2474s c2474s, C2471p c2471p) {
        int i3 = 0;
        C2472q[] c2472qArr = new C2472q[this.f8007e];
        for (int i4 = 0; i4 < this.f8007e; i4++) {
            int i5 = i2 + i4;
            if (i5 >= c2471p.m10782a().getItemCount()) {
                break;
            }
            C2472q c = c2471p.m10787c(i5);
            if (c.m10788a().m10770d() != c2474s.f8040a) {
                c2471p.m10784a(i5, c.f8037a);
                break;
            }
            if (z) {
                m10747a(c, c2474s);
            } else {
                c2471p.m10783a(i4 + i2);
            }
            i3 = Math.max(i3, this.b.getDecoratedMeasuredHeight(c.f8037a));
            c2472qArr[i4] = c;
        }
        Object obj = c2465i == C2465i.START ? 1 : null;
        int i6 = obj != null ? i - i3 : i;
        for (int i7 = 0; i7 < this.f8007e; i7++) {
            int i8;
            int i9 = obj != null ? (this.f8007e - i7) - 1 : i7;
            if (c2471p.f8035c) {
                i8 = obj != null ? (this.f8007e - i7) - 1 : i7;
            } else {
                i8 = obj != null ? i7 : (this.f8007e - i7) - 1;
            }
            if (c2472qArr[i9] != null) {
                m10746a(c2472qArr[i9], i6, i8, i3, c2474s, c2471p);
                m10736a(c2472qArr[i9], i9 + i2, c2465i, c2471p);
            }
        }
        return i3;
    }

    public int m10752a(int i, View view, C2474s c2474s, C2471p c2471p) {
        int position = this.b.getPosition(view);
        return m10750a(i, m10749a(c2474s.f8040a, this.b.getChildCount() - 1, this.b.getDecoratedBottom(view)), position + 1, c2474s, c2471p);
    }

    public int m10753a(int i, C2474s c2474s, C2471p c2471p) {
        int itemCount = c2471p.m10782a().getItemCount();
        int i2 = c2474s.f8040a + 1;
        int i3 = 0;
        while (i3 < c2474s.f8046g && i2 < i) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.f8007e && i2 + i4 < itemCount) {
                C2472q c = c2471p.m10787c(i2 + i4);
                m10747a(c, c2474s);
                i5 = Math.max(i5, this.b.getDecoratedMeasuredHeight(c.f8037a));
                c2471p.m10784a(i2 + i4, c.f8037a);
                i4++;
            }
            i3 += i5;
            i2 += this.f8007e;
        }
        return i3 == c2474s.f8046g ? 0 : i3 > c2474s.f8046g ? 1 : -i3;
    }

    public C2460e m10754a(C2474s c2474s) {
        super.m10744b(c2474s);
        if (c2474s.f8051l instanceof C2462f) {
            C2462f c2462f = (C2462f) c2474s.f8051l;
            int a = c2462f.m10778a();
            int b = c2462f.m10779b();
            if (a < 0 && b < 0) {
                b = 1;
            }
            if (b == -1) {
                m10757a(a);
            } else {
                m10761b(b);
            }
        }
        m10748c(c2474s);
        return this;
    }

    public C2461j m10755a(Context context, AttributeSet attributeSet) {
        return new C2462f(context, attributeSet);
    }

    public C2461j m10756a(C2461j c2461j) {
        return C2462f.m10776a(c2461j);
    }

    @Deprecated
    public void m10757a(int i) {
        this.f8006d = i;
        this.f8009g = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m10758b(int r13, int r14, int r15, mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2474s r16, mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2471p r17) {
        /*
        r12 = this;
        r0 = r16;
        r1 = r0.f8041b;
        if (r1 == 0) goto L_0x0062;
    L_0x0006:
        r0 = r16;
        r1 = r0.f8040a;
        r1 = r1 + 1;
        r2 = r1;
    L_0x000d:
        r4 = 0;
        r1 = 0;
        r3 = r1;
    L_0x0010:
        r1 = r12.b;
        r1 = r1.getChildCount();
        if (r3 >= r1) goto L_0x015e;
    L_0x0018:
        r1 = r12.b;
        r5 = 0;
        r1 = r1.getChildAt(r5);
        r1 = r1.getLayoutParams();
        r1 = (mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2461j) r1;
        r5 = r1.m10770d();
        r0 = r16;
        r6 = r0.f8040a;
        if (r5 == r6) goto L_0x0068;
    L_0x002f:
        r1 = 1;
        r8 = r1;
    L_0x0031:
        r1 = r15 - r2;
        r2 = r12.f8007e;
        r4 = r1 % r2;
        r1 = 1;
        r2 = r1;
    L_0x0039:
        r1 = r12.f8007e;
        r1 = r1 - r4;
        if (r2 >= r1) goto L_0x008b;
    L_0x003e:
        r1 = 0;
        r3 = r1;
    L_0x0040:
        r1 = r12.b;
        r1 = r1.getChildCount();
        if (r3 >= r1) goto L_0x005e;
    L_0x0048:
        r1 = r12.b;
        r5 = r1.getChildAt(r3);
        r1 = r5.getLayoutParams();
        r1 = (mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2461j) r1;
        r1 = r1.m10770d();
        r0 = r16;
        r6 = r0.f8040a;
        if (r1 == r6) goto L_0x0073;
    L_0x005e:
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0039;
    L_0x0062:
        r0 = r16;
        r1 = r0.f8040a;
        r2 = r1;
        goto L_0x000d;
    L_0x0068:
        r1 = r1.f8010a;
        if (r1 != 0) goto L_0x006f;
    L_0x006c:
        r1 = 0;
        r8 = r1;
        goto L_0x0031;
    L_0x006f:
        r1 = r3 + 1;
        r3 = r1;
        goto L_0x0010;
    L_0x0073:
        r1 = r12.b;
        r1 = r1.getPosition(r5);
        r5 = r15 + r2;
        if (r1 != r5) goto L_0x0087;
    L_0x007d:
        r1 = r12.b;
        r0 = r17;
        r5 = r0.f8033a;
        r1.detachAndScrapViewAt(r3, r5);
        goto L_0x005e;
    L_0x0087:
        r1 = r3 + 1;
        r3 = r1;
        goto L_0x0040;
    L_0x008b:
        r6 = r15 - r4;
        r2 = -1;
        r3 = 0;
        r5 = 0;
        if (r8 == 0) goto L_0x0156;
    L_0x0092:
        r4 = r6;
        r1 = r2;
    L_0x0094:
        if (r4 < 0) goto L_0x015a;
    L_0x0096:
        r0 = r17;
        r2 = r0.m10787c(r4);
        r7 = r2.f8037a;
        r0 = r17;
        r0.m10784a(r4, r7);
        r2 = r2.m10788a();
        r2 = r2.m10770d();
        r0 = r16;
        r7 = r0.f8040a;
        if (r2 == r7) goto L_0x00ca;
    L_0x00b1:
        r2 = r1;
        r1 = r3;
    L_0x00b3:
        r0 = r16;
        r3 = r0.f8042c;
        if (r1 >= r3) goto L_0x0156;
    L_0x00b9:
        r0 = r16;
        r3 = r0.f8042c;
        r1 = r1 - r3;
        r14 = r14 + r1;
        r9 = r1;
        r10 = r2;
    L_0x00c1:
        r3 = r6;
        r2 = r14;
    L_0x00c3:
        if (r3 < 0) goto L_0x00c9;
    L_0x00c5:
        r1 = r2 - r9;
        if (r1 > r13) goto L_0x011f;
    L_0x00c9:
        return r2;
    L_0x00ca:
        r2 = 0;
        r1 = 0;
    L_0x00cc:
        r7 = r12.f8007e;
        if (r1 >= r7) goto L_0x00f3;
    L_0x00d0:
        r7 = r4 + r1;
        if (r7 > r15) goto L_0x00f3;
    L_0x00d4:
        r7 = r4 + r1;
        r0 = r17;
        r7 = r0.m10787c(r7);
        r9 = r4 + r1;
        r10 = r7.f8037a;
        r0 = r17;
        r0.m10784a(r9, r10);
        r9 = r7.m10788a();
        r10 = r9.m10770d();
        r0 = r16;
        r11 = r0.f8040a;
        if (r10 == r11) goto L_0x00fd;
    L_0x00f3:
        r1 = r3 + r2;
        r0 = r16;
        r2 = r0.f8042c;
        if (r1 < r2) goto L_0x0116;
    L_0x00fb:
        r2 = r4;
        goto L_0x00b3;
    L_0x00fd:
        r9 = r9.f8010a;
        if (r9 == 0) goto L_0x0104;
    L_0x0101:
        r1 = r1 + 1;
        goto L_0x00cc;
    L_0x0104:
        r0 = r16;
        r12.m10747a(r7, r0);
        r9 = r12.b;
        r7 = r7.f8037a;
        r7 = r9.getDecoratedMeasuredHeight(r7);
        r2 = java.lang.Math.max(r2, r7);
        goto L_0x0101;
    L_0x0116:
        r2 = r12.f8007e;
        r2 = r4 - r2;
        r3 = r1;
        r1 = r4;
        r4 = r2;
        goto L_0x0094;
    L_0x011f:
        r0 = r17;
        r1 = r0.m10787c(r3);
        r4 = r1.f8037a;
        r0 = r17;
        r0.m10784a(r3, r4);
        r1 = r1.m10788a();
        r4 = r1.f8010a;
        if (r4 != 0) goto L_0x00c9;
    L_0x0134:
        r1 = r1.m10770d();
        r0 = r16;
        r4 = r0.f8040a;
        if (r1 != r4) goto L_0x00c9;
    L_0x013e:
        if (r8 == 0) goto L_0x0142;
    L_0x0140:
        if (r3 >= r10) goto L_0x0154;
    L_0x0142:
        r5 = 1;
    L_0x0143:
        r4 = mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2465i.START;
        r1 = r12;
        r6 = r16;
        r7 = r17;
        r1 = r1.m10751a(r2, r3, r4, r5, r6, r7);
        r2 = r2 - r1;
        r1 = r12.f8007e;
        r3 = r3 - r1;
        goto L_0x00c3;
    L_0x0154:
        r5 = 0;
        goto L_0x0143;
    L_0x0156:
        r9 = r5;
        r10 = r2;
        goto L_0x00c1;
    L_0x015a:
        r2 = r1;
        r1 = r3;
        goto L_0x00b3;
    L_0x015e:
        r8 = r4;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.e.b(int, int, int, mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.s, mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.p):int");
    }

    public int m10759b(int i, View view, C2474s c2474s, C2471p c2471p) {
        int position = this.b.getPosition(view);
        return m10758b(i, this.b.getDecoratedTop(view), position - 1, c2474s, c2471p);
    }

    public /* synthetic */ C2459t m10760b(C2474s c2474s) {
        return m10754a(c2474s);
    }

    @Deprecated
    public void m10761b(int i) {
        this.f8007e = i;
        this.f8006d = 0;
        this.f8009g = true;
    }
}
