package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class di implements Runnable {
    final /* synthetic */ dh f6518a;

    di(dh dhVar) {
        this.f6518a = dhVar;
    }

    public void run() {
        new Handler().postDelayed(new dj(this), 50);
    }
}
