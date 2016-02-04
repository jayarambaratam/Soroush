package mobi.mmdt.ott.p086a.p087a;

import org.linphone.SipLibService;

/* renamed from: mobi.mmdt.ott.a.a.d */
class C1132d extends Thread {
    final /* synthetic */ C1130b f4191a;

    private C1132d(C1130b c1130b) {
        this.f4191a = c1130b;
    }

    public void run() {
        while (!SipLibService.isReady()) {
            try {
                C1132d.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException("waiting thread sleep() has been interrupted");
            }
        }
        this.f4191a.m6473l();
        this.f4191a.f4186b = null;
    }
}
