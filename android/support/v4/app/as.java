package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

final class as implements OnPreDrawListener {
    final /* synthetic */ View f831a;
    final /* synthetic */ Transition f832b;
    final /* synthetic */ ArrayList f833c;
    final /* synthetic */ Transition f834d;
    final /* synthetic */ ArrayList f835e;
    final /* synthetic */ Transition f836f;
    final /* synthetic */ ArrayList f837g;
    final /* synthetic */ Map f838h;
    final /* synthetic */ ArrayList f839i;
    final /* synthetic */ Transition f840j;
    final /* synthetic */ View f841k;

    as(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
        this.f831a = view;
        this.f832b = transition;
        this.f833c = arrayList;
        this.f834d = transition2;
        this.f835e = arrayList2;
        this.f836f = transition3;
        this.f837g = arrayList3;
        this.f838h = map;
        this.f839i = arrayList4;
        this.f840j = transition4;
        this.f841k = view2;
    }

    public boolean onPreDraw() {
        this.f831a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f832b != null) {
            ao.m1074a(this.f832b, this.f833c);
        }
        if (this.f834d != null) {
            ao.m1074a(this.f834d, this.f835e);
        }
        if (this.f836f != null) {
            ao.m1074a(this.f836f, this.f837g);
        }
        for (Entry entry : this.f838h.entrySet()) {
            ((View) entry.getValue()).setTransitionName((String) entry.getKey());
        }
        int size = this.f839i.size();
        for (int i = 0; i < size; i++) {
            this.f840j.excludeTarget((View) this.f839i.get(i), false);
        }
        this.f840j.excludeTarget(this.f841k, false);
        return true;
    }
}
