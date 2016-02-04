package mobi.mmdt.ott.view.main.p238d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.main.d.d */
class C2374d implements OnClickListener {
    final /* synthetic */ String f7837a;
    final /* synthetic */ C2369a f7838b;

    C2374d(C2369a c2369a, String str) {
        this.f7838b = c2369a;
        this.f7837a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7838b.m10381b().runOnUiThread(new C2375e(this));
    }
}
