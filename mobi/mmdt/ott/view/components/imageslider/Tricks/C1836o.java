package mobi.mmdt.ott.view.components.imageslider.Tricks;

import android.view.View;
import java.util.Comparator;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.Tricks.o */
class C1836o implements Comparator<View> {
    C1836o() {
    }

    public int m8921a(View view, View view2) {
        C1830h c1830h = (C1830h) view.getLayoutParams();
        C1830h c1830h2 = (C1830h) view2.getLayoutParams();
        return c1830h.f5949a != c1830h2.f5949a ? c1830h.f5949a ? 1 : -1 : c1830h.f5953e - c1830h2.f5953e;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m8921a((View) obj, (View) obj2);
    }
}
