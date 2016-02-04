package mobi.mmdt.ott.view.components.mediaviewer;

import java.util.List;

/* renamed from: mobi.mmdt.ott.view.components.mediaviewer.f */
class C1931f implements Runnable {
    final /* synthetic */ List f6199a;
    final /* synthetic */ C1930e f6200b;

    C1931f(C1930e c1930e, List list) {
        this.f6200b = c1930e;
        this.f6199a = list;
    }

    public void run() {
        this.f6200b.f6198b.f6155i.setVisibility(8);
        this.f6200b.f6198b.f6156j.m8656a(this.f6199a);
        this.f6200b.f6198b.m8493f((this.f6200b.f6198b.f6164r + 1) + " of " + this.f6200b.f6197a.getCount());
        this.f6200b.f6198b.f6159m.scrollToPosition(this.f6200b.f6198b.f6164r);
    }
}
