package mobi.mmdt.ott.view.conversation.conversationtextbox;

import java.util.TimerTask;
import mobi.mmdt.ott.p089b.C1162g;

/* renamed from: mobi.mmdt.ott.view.conversation.conversationtextbox.c */
class C2139c extends TimerTask {
    final /* synthetic */ C2138b f6998a;

    C2139c(C2138b c2138b) {
        this.f6998a = c2138b;
    }

    public void run() {
        this.f6998a.f6997a.f6994r = false;
        this.f6998a.f6997a.f6977a.m9357a(C1162g.PAUSED);
    }
}
