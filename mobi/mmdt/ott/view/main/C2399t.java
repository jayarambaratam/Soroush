package mobi.mmdt.ott.view.main;

import android.os.Handler;
import java.util.ArrayList;

/* renamed from: mobi.mmdt.ott.view.main.t */
class C2399t implements Runnable {
    final /* synthetic */ String f7868a;
    final /* synthetic */ String f7869b;
    final /* synthetic */ String f7870c;
    final /* synthetic */ ArrayList f7871d;
    final /* synthetic */ NewGroupContactSelectionListActivity f7872e;

    C2399t(NewGroupContactSelectionListActivity newGroupContactSelectionListActivity, String str, String str2, String str3, ArrayList arrayList) {
        this.f7872e = newGroupContactSelectionListActivity;
        this.f7868a = str;
        this.f7869b = str2;
        this.f7870c = str3;
        this.f7871d = arrayList;
    }

    public void run() {
        new Handler().postDelayed(new C2400u(this), 50);
    }
}
