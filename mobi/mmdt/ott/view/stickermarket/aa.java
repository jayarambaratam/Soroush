package mobi.mmdt.ott.view.stickermarket;

import mobi.mmdt.ott.view.components.imageslider.p201b.C1840a;
import mobi.mmdt.ott.view.components.imageslider.p201b.C1844f;
import mobi.mmdt.ott.view.components.imageslider.p201b.C1845g;

class aa implements Runnable {
    final /* synthetic */ StickerMarketTopFragment f8271a;

    aa(StickerMarketTopFragment stickerMarketTopFragment) {
        this.f8271a = stickerMarketTopFragment;
    }

    public void run() {
        for (String str : this.f8271a.f8251c.keySet()) {
            C1840a c1845g = new C1845g(this.f8271a.getActivity());
            c1845g.m8939a(str).m8946b((String) this.f8271a.f8251c.get(str)).m8941a(C1844f.Fit).m8940a(this.f8271a);
            this.f8271a.f8250b.m8856a(c1845g);
        }
    }
}
