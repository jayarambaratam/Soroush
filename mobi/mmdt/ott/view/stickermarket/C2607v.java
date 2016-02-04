package mobi.mmdt.ott.view.stickermarket;

import java.util.List;

/* renamed from: mobi.mmdt.ott.view.stickermarket.v */
class C2607v implements Runnable {
    final /* synthetic */ List f8339a;
    final /* synthetic */ C2594r f8340b;

    C2607v(C2594r c2594r, List list) {
        this.f8340b = c2594r;
        this.f8339a = list;
    }

    public void run() {
        if (this.f8340b.getView() != null && this.f8339a != null && !this.f8339a.isEmpty()) {
            this.f8340b.f8303b.setVisibility(8);
            this.f8340b.f8304c.m8656a(this.f8339a);
        }
    }
}
