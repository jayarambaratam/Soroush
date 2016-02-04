package mobi.mmdt.ott.view.main.p237c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.main.c.g */
class C2356g implements OnClickListener {
    final /* synthetic */ String f7791a;
    final /* synthetic */ C2347a f7792b;

    C2356g(C2347a c2347a, String str) {
        this.f7792b = c2347a;
        this.f7791a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7792b.m10381b().runOnUiThread(new C2357h(this));
    }
}
