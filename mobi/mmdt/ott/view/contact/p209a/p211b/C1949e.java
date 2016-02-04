package mobi.mmdt.ott.view.contact.p209a.p211b;

import mobi.mmdt.ott.view.contact.p209a.p210a.C1942a;

/* renamed from: mobi.mmdt.ott.view.contact.a.b.e */
class C1949e implements Runnable {
    final /* synthetic */ C1942a f6257a;
    final /* synthetic */ C1948d f6258b;

    C1949e(C1948d c1948d, C1942a c1942a) {
        this.f6258b = c1948d;
        this.f6257a = c1942a;
    }

    public void run() {
        this.f6258b.f6256b.setText(this.f6257a.m9223a() + "/" + this.f6257a.m9224b() + "  " + this.f6258b.f6255a.getString(2131230824));
    }
}
