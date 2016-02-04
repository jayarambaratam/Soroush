package mobi.mmdt.ott.view.stickermarket;

import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1458d;

/* renamed from: mobi.mmdt.ott.view.stickermarket.l */
class C2588l implements Runnable {
    final /* synthetic */ C1458d f8294a;
    final /* synthetic */ StickerDetailsActivity f8295b;

    C2588l(StickerDetailsActivity stickerDetailsActivity, C1458d c1458d) {
        this.f8295b = stickerDetailsActivity;
        this.f8294a = c1458d;
    }

    public void run() {
        this.f8295b.f8233s.setVisibility(0);
        this.f8295b.f8231q.setText(this.f8294a.m7402b());
        this.f8295b.f8232r.setText(this.f8294a.m7401a());
        this.f8295b.f8229o.setText(Double.parseDouble(this.f8294a.m7407g()) == 0.0d ? "Free" : this.f8294a.m7407g());
        this.f8295b.f8230p.setText(this.f8294a.m7405e());
        this.f8295b.m8492e(this.f8294a.m7406f());
        C0872i.m5270b(this.f8295b.getApplicationContext()).m5329a(this.f8294a.m7404d()).m4413a(this.f8295b.f8237w).m4409a(C0652e.SOURCE).m4409a(C0652e.SOURCE).m4406a(0.25f).m4417a(this.f8295b.f8227m);
        C0872i.m5265a(this.f8295b.m8494q()).m5329a(this.f8294a.m7403c()).m5047j().m4285a(new C2589m(this, this.f8295b.f8228n));
    }
}
