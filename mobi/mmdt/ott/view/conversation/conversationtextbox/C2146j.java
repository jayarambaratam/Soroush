package mobi.mmdt.ott.view.conversation.conversationtextbox;

/* renamed from: mobi.mmdt.ott.view.conversation.conversationtextbox.j */
class C2146j implements Runnable {
    final /* synthetic */ int f7009a;
    final /* synthetic */ C2145i f7010b;

    C2146j(C2145i c2145i, int i) {
        this.f7010b = c2145i;
        this.f7009a = i;
    }

    public void run() {
        this.f7010b.f7007c.f6991o.rightMargin = this.f7009a;
        this.f7010b.f7007c.f6989m.setLayoutParams(this.f7010b.f7007c.f6991o);
    }
}
