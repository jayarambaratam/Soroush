package p025b.p026a.p027a.p028a.p031c;

import android.content.Context;
import android.widget.Scroller;

/* renamed from: b.a.a.a.c.c */
public class C0555c extends C0552d {
    private final Scroller f2299a;

    public C0555c(Context context) {
        this.f2299a = new Scroller(context);
    }

    public void m4179a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f2299a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m4180a(boolean z) {
        this.f2299a.forceFinished(z);
    }

    public boolean m4181a() {
        return this.f2299a.computeScrollOffset();
    }

    public boolean m4182b() {
        return this.f2299a.isFinished();
    }

    public int m4183c() {
        return this.f2299a.getCurrX();
    }

    public int m4184d() {
        return this.f2299a.getCurrY();
    }
}
