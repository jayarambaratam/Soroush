package p025b.p026a.p027a.p028a.p031c;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

@TargetApi(9)
/* renamed from: b.a.a.a.c.a */
public class C0553a extends C0552d {
    protected final OverScroller f2297a;
    private boolean f2298b;

    public C0553a(Context context) {
        this.f2298b = false;
        this.f2297a = new OverScroller(context);
    }

    public void m4172a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f2297a.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public void m4173a(boolean z) {
        this.f2297a.forceFinished(z);
    }

    public boolean m4174a() {
        if (this.f2298b) {
            this.f2297a.computeScrollOffset();
            this.f2298b = false;
        }
        return this.f2297a.computeScrollOffset();
    }

    public boolean m4175b() {
        return this.f2297a.isFinished();
    }

    public int m4176c() {
        return this.f2297a.getCurrX();
    }

    public int m4177d() {
        return this.f2297a.getCurrY();
    }
}
