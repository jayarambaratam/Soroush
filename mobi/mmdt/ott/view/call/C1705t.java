package mobi.mmdt.ott.view.call;

/* renamed from: mobi.mmdt.ott.view.call.t */
class C1705t implements Runnable {
    final /* synthetic */ C1704s f5601a;

    C1705t(C1704s c1704s) {
        this.f5601a = c1704s;
    }

    public void run() {
        if (this.f5601a.f5600a.f5568o && !this.f5601a.f5600a.f5569p && this.f5601a.f5600a.f5567n != null) {
            this.f5601a.f5600a.f5567n.ping();
        }
    }
}
