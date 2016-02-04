package mobi.mmdt.ott.view.contact.contactprofileinfo;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.contact.contactprofileinfo.b */
class C1965b implements Runnable {
    final /* synthetic */ ContactProfileInfoActivity f6319a;

    C1965b(ContactProfileInfoActivity contactProfileInfoActivity) {
        this.f6319a = contactProfileInfoActivity;
    }

    public void run() {
        new Handler().postDelayed(new C1966c(this), 50);
    }
}
