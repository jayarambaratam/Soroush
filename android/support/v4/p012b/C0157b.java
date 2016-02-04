package android.support.v4.p012b;

import android.support.v4.os.C0268i;
import java.util.concurrent.CountDownLatch;

/* renamed from: android.support.v4.b.b */
final class C0157b extends C0156x<Void, Void, D> implements Runnable {
    boolean f1076a;
    final /* synthetic */ C0155a f1077b;
    private final CountDownLatch f1078d;

    C0157b(C0155a c0155a) {
        this.f1077b = c0155a;
        this.f1078d = new CountDownLatch(1);
    }

    protected D m1511a(Void... voidArr) {
        try {
            return this.f1077b.m1490e();
        } catch (C0268i e) {
            if (m1509c()) {
                return null;
            }
            throw e;
        }
    }

    protected void m1512a(D d) {
        try {
            this.f1077b.m1486b(this, d);
        } finally {
            this.f1078d.countDown();
        }
    }

    protected void m1513b(D d) {
        try {
            this.f1077b.m1483a(this, d);
        } finally {
            this.f1078d.countDown();
        }
    }

    public void run() {
        this.f1076a = false;
        this.f1077b.m1488c();
    }
}
