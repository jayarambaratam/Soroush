package mobi.mmdt.ott.view.contact.contactprofileinfo;

/* renamed from: mobi.mmdt.ott.view.contact.contactprofileinfo.e */
class C1968e implements Runnable {
    final /* synthetic */ int f6322a;
    final /* synthetic */ C1967d f6323b;

    C1968e(C1967d c1967d, int i) {
        this.f6323b = c1967d;
        this.f6322a = i;
    }

    public void run() {
        this.f6323b.f6321a.f6308q.setText("Shared Media (" + this.f6322a + ")");
        if (this.f6322a > 0) {
            this.f6323b.f6321a.f6308q.setOnClickListener(new C1969f(this));
        } else {
            this.f6323b.f6321a.f6308q.setOnClickListener(new C1970g(this));
        }
    }
}
