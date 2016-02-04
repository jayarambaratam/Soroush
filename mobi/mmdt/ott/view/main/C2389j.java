package mobi.mmdt.ott.view.main;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.main.j */
class C2389j implements OnClickListener {
    final /* synthetic */ MainActivity f7856a;

    C2389j(MainActivity mainActivity) {
        this.f7856a = mainActivity;
    }

    public void onClick(View view) {
        new Handler().postDelayed(new C2390k(this), 10);
    }
}
