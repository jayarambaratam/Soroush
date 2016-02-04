package android.support.design.widget;

import android.view.View;
import java.util.Comparator;

/* renamed from: android.support.design.widget.p */
class C0091p implements Comparator<View> {
    final /* synthetic */ CoordinatorLayout f663a;

    C0091p(CoordinatorLayout coordinatorLayout) {
        this.f663a = coordinatorLayout;
    }

    public int m820a(View view, View view2) {
        return view == view2 ? 0 : ((C0095u) view.getLayoutParams()).m830a(this.f663a, view, view2) ? 1 : ((C0095u) view2.getLayoutParams()).m830a(this.f663a, view2, view) ? -1 : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m820a((View) obj, (View) obj2);
    }
}
