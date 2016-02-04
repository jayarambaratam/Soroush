package android.support.design.widget;

class bb implements bp {
    final /* synthetic */ Snackbar f490a;

    bb(Snackbar snackbar) {
        this.f490a = snackbar;
    }

    public void m561a() {
        Snackbar.f369a.sendMessage(Snackbar.f369a.obtainMessage(0, this.f490a));
    }

    public void m562a(int i) {
        Snackbar.f369a.sendMessage(Snackbar.f369a.obtainMessage(1, i, 0, this.f490a));
    }
}
