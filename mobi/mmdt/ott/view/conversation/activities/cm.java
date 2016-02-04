package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class cm implements Runnable {
    final /* synthetic */ cl f6490a;

    cm(cl clVar) {
        this.f6490a = clVar;
    }

    public void run() {
        new Handler().postDelayed(new cn(this), 50);
    }
}
