package p025b.p026a.p027a.p028a.p031c;

import android.content.Context;
import android.os.Build.VERSION;

/* renamed from: b.a.a.a.c.d */
public abstract class C0552d {
    public static C0552d m4165a(Context context) {
        return VERSION.SDK_INT < 9 ? new C0555c(context) : VERSION.SDK_INT < 14 ? new C0553a(context) : new C0554b(context);
    }

    public abstract void m4166a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    public abstract void m4167a(boolean z);

    public abstract boolean m4168a();

    public abstract boolean m4169b();

    public abstract int m4170c();

    public abstract int m4171d();
}
