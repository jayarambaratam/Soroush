package mobi.mmdt.ott.view.p178a.p179a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* renamed from: mobi.mmdt.ott.view.a.a.f */
class C1658f extends AsyncTask<Integer, Void, Bitmap> {
    final /* synthetic */ C1656d f5478a;
    private int f5479b;
    private final WeakReference<ImageView> f5480c;

    public C1658f(C1656d c1656d, ImageView imageView) {
        this.f5478a = c1656d;
        this.f5480c = new WeakReference(imageView);
    }

    private ImageView m8420a() {
        ImageView imageView = (ImageView) this.f5480c.get();
        return this == C1656d.m8412b(imageView) ? imageView : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected android.graphics.Bitmap m8421a(java.lang.Integer... r4) {
        /*
        r3 = this;
        r0 = java.lang.Thread.currentThread();
        r1 = 1;
        r0.setPriority(r1);
        r0 = 0;
        r0 = r4[r0];
        r0 = r0.intValue();
        r3.f5479b = r0;
        r0 = 0;
        r1 = r3.f5478a;
        r1 = r1.f5474d;
        monitor-enter(r1);
    L_0x0019:
        r2 = r3.f5478a;	 Catch:{ all -> 0x0062 }
        r2 = r2.f5473c;	 Catch:{ all -> 0x0062 }
        if (r2 == 0) goto L_0x0033;
    L_0x0021:
        r2 = r3.isCancelled();	 Catch:{ all -> 0x0062 }
        if (r2 != 0) goto L_0x0033;
    L_0x0027:
        r2 = r3.f5478a;	 Catch:{ InterruptedException -> 0x0031 }
        r2 = r2.f5474d;	 Catch:{ InterruptedException -> 0x0031 }
        r2.wait();	 Catch:{ InterruptedException -> 0x0031 }
        goto L_0x0019;
    L_0x0031:
        r2 = move-exception;
        goto L_0x0019;
    L_0x0033:
        monitor-exit(r1);	 Catch:{ all -> 0x0062 }
        r1 = r3.isCancelled();
        if (r1 != 0) goto L_0x0048;
    L_0x003a:
        r1 = r3.m8420a();
        if (r1 == 0) goto L_0x0048;
    L_0x0040:
        r0 = r3.f5478a;
        r1 = r3.f5479b;
        r0 = r0.m8415a(r1);
    L_0x0048:
        if (r0 == 0) goto L_0x0061;
    L_0x004a:
        r1 = r3.f5478a;
        r1 = r1.m8407a();
        if (r1 == 0) goto L_0x0061;
    L_0x0052:
        r1 = r3.f5478a;
        r1 = r1.m8407a();
        r2 = r3.f5479b;
        r2 = java.lang.Integer.valueOf(r2);
        r1.m8402a(r2, r0);
    L_0x0061:
        return r0;
    L_0x0062:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0062 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.view.a.a.f.a(java.lang.Integer[]):android.graphics.Bitmap");
    }

    protected void m8422a(Bitmap bitmap) {
        if (isCancelled()) {
            bitmap = null;
        }
        ImageView a = m8420a();
        if (bitmap != null && a != null) {
            this.f5478a.m8409a(a, bitmap);
        }
    }

    @SuppressLint({"NewApi"})
    protected void m8423b(Bitmap bitmap) {
        if (VERSION.SDK_INT > 11) {
            super.onCancelled(bitmap);
        }
        synchronized (this.f5478a.f5474d) {
            this.f5478a.f5474d.notifyAll();
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m8421a((Integer[]) objArr);
    }

    protected /* synthetic */ void onCancelled(Object obj) {
        m8423b((Bitmap) obj);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m8422a((Bitmap) obj);
    }
}
