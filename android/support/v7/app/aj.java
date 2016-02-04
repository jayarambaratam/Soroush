package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.support.v7.view.C0376c;
import android.support.v7.view.C0378b;
import android.support.v7.view.C0433i;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.view.Window.Callback;

abstract class aj extends ai {
    final Context f1728a;
    final Window f1729b;
    final Callback f1730c;
    final Callback f1731d;
    final ah f1732e;
    C0370a f1733f;
    MenuInflater f1734g;
    boolean f1735h;
    boolean f1736i;
    boolean f1737j;
    boolean f1738k;
    boolean f1739l;
    private CharSequence f1740m;
    private boolean f1741n;

    aj(Context context, Window window, ah ahVar) {
        this.f1728a = context;
        this.f1729b = window;
        this.f1732e = ahVar;
        this.f1730c = this.f1729b.getCallback();
        if (this.f1730c instanceof am) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f1731d = m3484a(this.f1730c);
        this.f1729b.setCallback(this.f1731d);
    }

    public C0370a m3482a() {
        m3494i();
        return this.f1733f;
    }

    abstract C0378b m3483a(C0376c c0376c);

    Callback m3484a(Callback callback) {
        return new am(this, callback);
    }

    abstract void m3485a(int i, Menu menu);

    public final void m3486a(CharSequence charSequence) {
        this.f1740m = charSequence;
        m3490b(charSequence);
    }

    abstract boolean m3487a(int i, KeyEvent keyEvent);

    abstract boolean m3488a(KeyEvent keyEvent);

    public MenuInflater m3489b() {
        if (this.f1734g == null) {
            m3494i();
            this.f1734g = new C0433i(this.f1733f != null ? this.f1733f.m3580c() : this.f1728a);
        }
        return this.f1734g;
    }

    abstract void m3490b(CharSequence charSequence);

    abstract boolean m3491b(int i, Menu menu);

    public final void m3492f() {
        this.f1741n = true;
    }

    public final C0372g m3493g() {
        return new al();
    }

    abstract void m3494i();

    final C0370a m3495j() {
        return this.f1733f;
    }

    final Context m3496k() {
        Context context = null;
        C0370a a = m3482a();
        if (a != null) {
            context = a.m3580c();
        }
        return context == null ? this.f1728a : context;
    }

    public boolean m3497l() {
        return false;
    }

    final boolean m3498m() {
        return this.f1741n;
    }

    final Callback m3499n() {
        return this.f1729b.getCallback();
    }

    final CharSequence m3500o() {
        return this.f1730c instanceof Activity ? ((Activity) this.f1730c).getTitle() : this.f1740m;
    }
}
