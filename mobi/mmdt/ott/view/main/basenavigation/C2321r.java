package mobi.mmdt.ott.view.main.basenavigation;

import android.support.v4.view.bt;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.r */
public class C2321r extends bt {
    final /* synthetic */ C2285a f7636a;

    public C2321r(C2285a c2285a) {
        this.f7636a = c2285a;
    }

    public Object m10431a(ViewGroup viewGroup, int i) {
        View view = (View) this.f7636a.f7541j.get(i);
        viewGroup.addView(view, 0);
        return view;
    }

    public void m10432a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public boolean m10433a(View view, Object obj) {
        return obj == view;
    }

    public int m10434b() {
        return 3;
    }
}
