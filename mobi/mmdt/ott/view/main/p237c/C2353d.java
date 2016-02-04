package mobi.mmdt.ott.view.main.p237c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.main.c.d */
class C2353d implements OnClickListener {
    final /* synthetic */ String f7787a;
    final /* synthetic */ C2347a f7788b;

    C2353d(C2347a c2347a, String str) {
        this.f7788b = c2347a;
        this.f7787a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7788b.m10381b().runOnUiThread(new C2354e(this));
    }
}
