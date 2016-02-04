package mobi.mmdt.ott.view.main.basenavigation.viewpager;

import android.view.View;
import java.util.Comparator;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.viewpager.m */
class C2338m implements Comparator<View> {
    C2338m() {
    }

    public int m10503a(View view, View view2) {
        C2333h c2333h = (C2333h) view.getLayoutParams();
        C2333h c2333h2 = (C2333h) view2.getLayoutParams();
        return c2333h.f7721a != c2333h2.f7721a ? c2333h.f7721a ? 1 : -1 : c2333h.f7725e - c2333h2.f7725e;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m10503a((View) obj, (View) obj2);
    }
}
