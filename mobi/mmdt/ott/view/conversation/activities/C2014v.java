package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1370d;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.v */
class C2014v implements OnClickListener {
    final /* synthetic */ String f6554a;
    final /* synthetic */ C1992a f6555b;

    C2014v(C1992a c1992a, String str) {
        this.f6555b = c1992a;
        this.f6554a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C1494c.m7539a(new C1370d(this.f6555b.getApplicationContext(), this.f6554a, this.f6555b.f6368r));
    }
}
