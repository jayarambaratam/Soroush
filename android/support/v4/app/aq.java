package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

final class aq implements OnPreDrawListener {
    final /* synthetic */ View f822a;
    final /* synthetic */ Transition f823b;
    final /* synthetic */ View f824c;
    final /* synthetic */ au f825d;
    final /* synthetic */ Map f826e;
    final /* synthetic */ Map f827f;
    final /* synthetic */ ArrayList f828g;

    aq(View view, Transition transition, View view2, au auVar, Map map, Map map2, ArrayList arrayList) {
        this.f822a = view;
        this.f823b = transition;
        this.f824c = view2;
        this.f825d = auVar;
        this.f826e = map;
        this.f827f = map2;
        this.f828g = arrayList;
    }

    public boolean onPreDraw() {
        this.f822a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f823b != null) {
            this.f823b.removeTarget(this.f824c);
        }
        View a = this.f825d.m1086a();
        if (a != null) {
            if (!this.f826e.isEmpty()) {
                ao.m1077a(this.f827f, a);
                this.f827f.keySet().retainAll(this.f826e.values());
                for (Entry entry : this.f826e.entrySet()) {
                    View view = (View) this.f827f.get((String) entry.getValue());
                    if (view != null) {
                        view.setTransitionName((String) entry.getKey());
                    }
                }
            }
            if (this.f823b != null) {
                ao.m1084b(this.f828g, a);
                this.f828g.removeAll(this.f827f.values());
                this.f828g.add(this.f824c);
                ao.m1083b(this.f823b, this.f828g);
            }
        }
        return true;
    }
}
