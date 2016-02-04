package mobi.mmdt.ott.view.conversation.activities;

import android.support.design.widget.Snackbar;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.p */
class C2008p implements Runnable {
    final /* synthetic */ C1992a f6547a;

    C2008p(C1992a c1992a) {
        this.f6547a = c1992a;
    }

    public void run() {
        Snackbar.m377a(this.f6547a.f6361k, (CharSequence) "File to send is too large!", 0).m395a();
    }
}
