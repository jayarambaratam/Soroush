package android.support.v4.p015e;

import org.linphone.core.VideoSize;

/* renamed from: android.support.v4.e.n */
abstract class C0214n implements C0208h {
    private final C0211m f1118a;

    public C0214n(C0211m c0211m) {
        this.f1118a = c0211m;
    }

    private boolean m1647b(CharSequence charSequence, int i, int i2) {
        switch (this.f1118a.m1644a(charSequence, i, i2)) {
            case VideoSize.QCIF /*0*/:
                return true;
            case VideoSize.CIF /*1*/:
                return false;
            default:
                return m1648a();
        }
    }

    protected abstract boolean m1648a();

    public boolean m1649a(CharSequence charSequence, int i, int i2) {
        if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
            return this.f1118a == null ? m1648a() : m1647b(charSequence, i, i2);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
