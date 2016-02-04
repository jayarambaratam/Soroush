package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

class ed implements Comparator<View> {
    ed() {
    }

    public int m2757a(View view, View view2) {
        dw dwVar = (dw) view.getLayoutParams();
        dw dwVar2 = (dw) view2.getLayoutParams();
        return dwVar.f1361a != dwVar2.f1361a ? dwVar.f1361a ? 1 : -1 : dwVar.f1365e - dwVar2.f1365e;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2757a((View) obj, (View) obj2);
    }
}
