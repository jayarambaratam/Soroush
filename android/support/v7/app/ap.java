package android.support.v7.app;

import android.support.v7.view.C0376c;
import android.support.v7.view.C0378b;
import android.support.v7.view.C0432h;
import android.view.ActionMode;
import android.view.Window.Callback;

class ap extends am {
    final /* synthetic */ ao f1781b;

    ap(ao aoVar, Callback callback) {
        this.f1781b = aoVar;
        super(aoVar, callback);
    }

    final ActionMode m3642a(ActionMode.Callback callback) {
        Object c0432h = new C0432h(this.f1781b.a, callback);
        C0378b b = this.f1781b.m3551b((C0376c) c0432h);
        return b != null ? c0432h.m3985b(b) : null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f1781b.m3641l() ? m3642a(callback) : super.onWindowStartingActionMode(callback);
    }
}
