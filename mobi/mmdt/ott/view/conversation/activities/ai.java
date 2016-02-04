package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class ai implements Runnable {
    final /* synthetic */ ah f6420a;

    ai(ah ahVar) {
        this.f6420a = ahVar;
    }

    public void run() {
        new Handler().postDelayed(new aj(this), 50);
    }
}
