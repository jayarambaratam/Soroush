package mobi.mmdt.ott.view.stickermarket;

import java.util.List;

/* renamed from: mobi.mmdt.ott.view.stickermarket.u */
class C2606u implements Runnable {
    final /* synthetic */ List f8337a;
    final /* synthetic */ C2594r f8338b;

    C2606u(C2594r c2594r, List list) {
        this.f8338b = c2594r;
        this.f8337a = list;
    }

    public void run() {
        if (this.f8338b.getView() != null && this.f8337a != null && !this.f8337a.isEmpty()) {
            this.f8338b.f8303b.setVisibility(8);
            this.f8338b.f8304c.m8656a(this.f8337a);
        }
    }
}
