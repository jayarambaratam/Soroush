package mobi.mmdt.ott.view.settings.mainsettings.profile_info.deactivate_account;

import android.support.design.widget.Snackbar;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.profile_info.deactivate_account.f */
class C2557f implements Runnable {
    final /* synthetic */ C2555d f8195a;

    C2557f(C2555d c2555d) {
        this.f8195a = c2555d;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f8195a.f8193a.f8181i, this.f8195a.f8193a.getString(2131230821), -2);
        a.m392a(2131230916, new C2558g(this));
        a.m395a();
    }
}
