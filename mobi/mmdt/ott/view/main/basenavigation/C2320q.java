package mobi.mmdt.ott.view.main.basenavigation;

import android.support.v4.view.bt;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.q */
public class C2320q extends bt {
    final /* synthetic */ C2285a f7635a;

    public C2320q(C2285a c2285a) {
        this.f7635a = c2285a;
    }

    public Object m10427a(ViewGroup viewGroup, int i) {
        View view = (View) this.f7635a.f7542k.get(i);
        viewGroup.addView(view, 0);
        return view;
    }

    public void m10428a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public boolean m10429a(View view, Object obj) {
        return obj == view;
    }

    public int m10430b() {
        return 3;
    }
}
