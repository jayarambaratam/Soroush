package mobi.mmdt.ott.view.channel;

import java.util.List;

class af implements Runnable {
    final /* synthetic */ List f5684a;
    final /* synthetic */ ad f5685b;

    af(ad adVar, List list) {
        this.f5685b = adVar;
        this.f5684a = list;
    }

    public void run() {
        if (this.f5685b.getView() != null) {
            this.f5685b.f5674b.setVisibility(8);
            this.f5685b.f5675c.m8656a(this.f5684a);
        }
    }
}
