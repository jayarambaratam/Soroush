package mobi.mmdt.ott.view.stickermarket;

import android.support.design.widget.Snackbar;

/* renamed from: mobi.mmdt.ott.view.stickermarket.j */
class C2586j implements Runnable {
    final /* synthetic */ Runnable f8291a;
    final /* synthetic */ StickerDetailsActivity f8292b;

    C2586j(StickerDetailsActivity stickerDetailsActivity, Runnable runnable) {
        this.f8292b = stickerDetailsActivity;
        this.f8291a = runnable;
    }

    public void run() {
        Snackbar a = Snackbar.m377a(this.f8292b.f8234t, this.f8292b.getString(2131230821), -2);
        a.m392a(2131230916, new C2587k(this));
        if (!this.f8292b.f8235u) {
            this.f8292b.f8235u = true;
            a.m395a();
        }
    }
}
