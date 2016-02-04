package android.support.v7.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.h */
class C0446h extends BaseAdapter {
    final /* synthetic */ C0445g f2171a;
    private int f2172b;

    public C0446h(C0445g c0445g) {
        this.f2171a = c0445g;
        this.f2172b = -1;
        m4053a();
    }

    public C0448m m4052a(int i) {
        ArrayList l = this.f2171a.f2163c.m132l();
        int a = this.f2171a.f2168h + i;
        if (this.f2172b >= 0 && a >= this.f2172b) {
            a++;
        }
        return (C0448m) l.get(a);
    }

    void m4053a() {
        C0448m r = this.f2171a.f2163c.m138r();
        if (r != null) {
            ArrayList l = this.f2171a.f2163c.m132l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((C0448m) l.get(i)) == r) {
                    this.f2172b = i;
                    return;
                }
            }
        }
        this.f2172b = -1;
    }

    public int getCount() {
        int size = this.f2171a.f2163c.m132l().size() - this.f2171a.f2168h;
        return this.f2172b < 0 ? size : size - 1;
    }

    public /* synthetic */ Object getItem(int i) {
        return m4052a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f2171a.f2162b.inflate(this.f2171a.f2166f, viewGroup, false) : view;
        ((aa) inflate).m75a(m4052a(i), 0);
        return inflate;
    }

    public void notifyDataSetChanged() {
        m4053a();
        super.notifyDataSetChanged();
    }
}
