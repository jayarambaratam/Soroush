package mobi.mmdt.ott.view.stickermarket;

import mobi.mmdt.ott.logic.p112a.p149i.p151b.C1469g;
import mobi.mmdt.ott.logic.p112a.p149i.p151b.C1470h;

/* renamed from: mobi.mmdt.ott.view.stickermarket.i */
class C2585i implements Runnable {
    final /* synthetic */ StickerDetailsActivity f8290a;

    C2585i(StickerDetailsActivity stickerDetailsActivity) {
        this.f8290a = stickerDetailsActivity;
    }

    public void run() {
        if (this.f8290a.f8236v instanceof C1469g) {
            this.f8290a.m10965l();
        } else if (this.f8290a.f8236v instanceof C1470h) {
            this.f8290a.m10968m();
        }
        this.f8290a.f8235u = false;
    }
}
