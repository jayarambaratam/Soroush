package mobi.mmdt.ott.view.conversation.activities;

class bz implements Runnable {
    final /* synthetic */ bw f6467a;

    bz(bw bwVar) {
        this.f6467a = bwVar;
    }

    public void run() {
        if (this.f6467a.f6464a.f6384u != null) {
            this.f6467a.f6464a.f6384u.setVisible(this.f6467a.f6464a.f6386w);
        }
        if (this.f6467a.f6464a.f6383t != null) {
            this.f6467a.f6464a.f6383t.setChecked(this.f6467a.f6464a.f6385v);
            this.f6467a.f6464a.f6383t.setVisible(this.f6467a.f6464a.f6386w);
        }
    }
}
