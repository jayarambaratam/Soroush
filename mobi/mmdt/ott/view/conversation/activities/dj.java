package mobi.mmdt.ott.view.conversation.activities;

import mobi.mmdt.componentsutils.view.p085a.C1123a;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p125d.p127b.C1395a;

class dj implements Runnable {
    final /* synthetic */ di f6519a;

    dj(di diVar) {
        this.f6519a = diVar;
    }

    public void run() {
        C1123a.m6432a(this.f6519a.f6518a.f6517a.m8494q()).m6439a(false);
        C1494c.m7539a(new C1395a(this.f6519a.f6518a.f6517a.getApplicationContext(), this.f6519a.f6518a.f6517a.f6401p));
    }
}
