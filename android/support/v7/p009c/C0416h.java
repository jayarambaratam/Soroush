package android.support.v7.p009c;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

/* renamed from: android.support.v7.c.h */
class C0416h extends AsyncTask<Bitmap, Void, C0412e> {
    final /* synthetic */ C0417k f2041a;
    final /* synthetic */ C0415g f2042b;

    C0416h(C0415g c0415g, C0417k c0417k) {
        this.f2042b = c0415g;
        this.f2041a = c0417k;
    }

    protected C0412e m3946a(Bitmap... bitmapArr) {
        try {
            return this.f2042b.m3945a();
        } catch (Throwable e) {
            Log.e("Palette", "Exception thrown during async generate", e);
            return null;
        }
    }

    protected void m3947a(C0412e c0412e) {
        this.f2041a.m3948a(c0412e);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3946a((Bitmap[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m3947a((C0412e) obj);
    }
}
