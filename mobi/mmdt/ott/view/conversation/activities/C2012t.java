package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.t */
class C2012t implements OnClickListener {
    final /* synthetic */ Runnable f6551a;
    final /* synthetic */ C1992a f6552b;

    C2012t(C1992a c1992a, Runnable runnable) {
        this.f6552b = c1992a;
        this.f6551a = runnable;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6551a.run();
    }
}
