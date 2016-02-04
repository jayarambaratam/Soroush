package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import mobi.mmdt.ott.view.components.p181b.C1722f;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.k */
class C2003k implements OnClickListener {
    final /* synthetic */ C1722f f6541a;
    final /* synthetic */ C1992a f6542b;

    C2003k(C1992a c1992a, C1722f c1722f) {
        this.f6542b = c1992a;
        this.f6541a = c1722f;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        new Handler().postDelayed(new C2004l(this), 50);
    }
}
