package mobi.mmdt.ott.view.contact.contactprofileinfo;

import android.support.design.widget.Snackbar;

/* renamed from: mobi.mmdt.ott.view.contact.contactprofileinfo.p */
class C1979p implements Runnable {
    final /* synthetic */ C1976m f6334a;

    C1979p(C1976m c1976m) {
        this.f6334a = c1976m;
    }

    public void run() {
        Snackbar.m377a(this.f6334a.f6331a.i, (CharSequence) "Successfully unblocked.", -1).m395a();
    }
}
