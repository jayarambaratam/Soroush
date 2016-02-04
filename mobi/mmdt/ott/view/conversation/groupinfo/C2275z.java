package mobi.mmdt.ott.view.conversation.groupinfo;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.z */
class C2275z implements Runnable {
    final /* synthetic */ int f7502a;
    final /* synthetic */ C2274y f7503b;

    C2275z(C2274y c2274y, int i) {
        this.f7503b = c2274y;
        this.f7502a = i;
    }

    public void run() {
        this.f7503b.f7501a.f7412w.setText("Shared Media (" + this.f7502a + ")");
        if (this.f7502a > 0) {
            this.f7503b.f7501a.f7412w.setOnClickListener(new aa(this));
        } else {
            this.f7503b.f7501a.f7412w.setOnClickListener(new ab(this));
        }
    }
}
