package mobi.mmdt.ott.view.contact.contactprofileinfo;

import mobi.mmdt.ott.provider.p169c.C1583c;

/* renamed from: mobi.mmdt.ott.view.contact.contactprofileinfo.d */
class C1967d implements Runnable {
    final /* synthetic */ ContactProfileInfoActivity f6321a;

    C1967d(ContactProfileInfoActivity contactProfileInfoActivity) {
        this.f6321a = contactProfileInfoActivity;
    }

    public void run() {
        Thread.currentThread().setPriority(1);
        this.f6321a.runOnUiThread(new C1968e(this, C1583c.m8002m(this.f6321a.getApplicationContext(), this.f6321a.f6315x)));
    }
}
