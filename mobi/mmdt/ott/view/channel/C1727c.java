package mobi.mmdt.ott.view.channel;

/* renamed from: mobi.mmdt.ott.view.channel.c */
class C1727c implements Runnable {
    final /* synthetic */ int f5703a;
    final /* synthetic */ C1726b f5704b;

    C1727c(C1726b c1726b, int i) {
        this.f5704b = c1726b;
        this.f5703a = i;
    }

    public void run() {
        this.f5704b.f5702a.f5633p.setText("Shared Media (" + this.f5703a + ")");
        if (this.f5703a > 0) {
            this.f5704b.f5702a.f5633p.setOnClickListener(new C1728d(this));
        } else {
            this.f5704b.f5702a.f5633p.setOnClickListener(new C1729e(this));
        }
    }
}
