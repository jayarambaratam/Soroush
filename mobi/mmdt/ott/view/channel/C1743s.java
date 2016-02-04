package mobi.mmdt.ott.view.channel;

import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1356h;

/* renamed from: mobi.mmdt.ott.view.channel.s */
class C1743s implements Runnable {
    final /* synthetic */ C1741q f5721a;

    C1743s(C1741q c1741q) {
        this.f5721a = c1741q;
    }

    public void run() {
        C1494c.m7540b(new C1356h(this.f5721a.f5719b.getApplicationContext(), this.f5721a.f5718a));
    }
}
