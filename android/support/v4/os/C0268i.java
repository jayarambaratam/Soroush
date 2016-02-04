package android.support.v4.os;

/* renamed from: android.support.v4.os.i */
public class C0268i extends RuntimeException {
    public C0268i() {
        this(null);
    }

    public C0268i(String str) {
        if (str == null) {
            str = "The operation has been canceled.";
        }
        super(str);
    }
}
