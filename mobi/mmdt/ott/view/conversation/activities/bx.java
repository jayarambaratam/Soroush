package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class bx implements Runnable {
    final /* synthetic */ bw f6465a;

    bx(bw bwVar) {
        this.f6465a = bwVar;
    }

    public void run() {
        new Handler().postDelayed(new by(this), 10);
    }
}
