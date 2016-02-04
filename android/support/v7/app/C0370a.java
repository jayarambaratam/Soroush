package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.C0376c;
import android.support.v7.view.C0378b;
import android.view.KeyEvent;

/* renamed from: android.support.v7.app.a */
public abstract class C0370a {
    public abstract int m3567a();

    public C0378b m3568a(C0376c c0376c) {
        return null;
    }

    public void m3569a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public abstract void m3570a(int i);

    public void m3571a(Configuration configuration) {
    }

    public void m3572a(Drawable drawable) {
    }

    public abstract void m3573a(CharSequence charSequence);

    public abstract void m3574a(boolean z);

    public boolean m3575a(int i, KeyEvent keyEvent) {
        return false;
    }

    public abstract void m3576b();

    public void m3577b(int i) {
    }

    public abstract void m3578b(CharSequence charSequence);

    public void m3579b(boolean z) {
    }

    public Context m3580c() {
        return null;
    }

    public void m3581c(int i) {
    }

    public void m3582c(CharSequence charSequence) {
    }

    public void m3583c(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void m3584d(boolean z) {
    }

    public boolean m3585d() {
        return false;
    }

    public void m3586e(boolean z) {
    }

    public boolean m3587e() {
        return false;
    }

    public void m3588f(boolean z) {
    }
}
