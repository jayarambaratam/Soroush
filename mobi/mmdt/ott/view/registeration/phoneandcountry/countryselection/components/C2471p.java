package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.SparseArray;
import android.view.View;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.p */
public class C2471p {
    public final Recycler f8033a;
    public final SparseArray<View> f8034b;
    public final boolean f8035c;
    private final State f8036d;

    public C2471p(LayoutManager layoutManager, Recycler recycler, State state) {
        this.f8034b = new SparseArray(layoutManager.getChildCount());
        this.f8036d = state;
        this.f8033a = recycler;
        this.f8035c = layoutManager.getLayoutDirection() == 0;
    }

    public State m10782a() {
        return this.f8036d;
    }

    public void m10783a(int i) {
        this.f8034b.remove(i);
    }

    public void m10784a(int i, View view) {
        this.f8034b.put(i, view);
    }

    public View m10785b(int i) {
        return (View) this.f8034b.get(i);
    }

    public void m10786b() {
        for (int i = 0; i < this.f8034b.size(); i++) {
            this.f8033a.recycleView((View) this.f8034b.valueAt(i));
        }
    }

    public C2472q m10787c(int i) {
        View b = m10785b(i);
        boolean z = b != null;
        if (b == null) {
            b = this.f8033a.getViewForPosition(i);
        }
        return new C2472q(b, z);
    }
}
