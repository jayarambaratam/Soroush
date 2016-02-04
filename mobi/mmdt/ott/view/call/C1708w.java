package mobi.mmdt.ott.view.call;

/* renamed from: mobi.mmdt.ott.view.call.w */
class C1708w implements Runnable {
    final /* synthetic */ String f5613a;
    final /* synthetic */ C1707v f5614b;

    C1708w(C1707v c1707v, String str) {
        this.f5614b = c1707v;
        this.f5613a = str;
    }

    public void run() {
        if (this.f5613a != null && !this.f5613a.isEmpty()) {
            this.f5614b.f5607e.setText(this.f5613a);
        }
    }
}
