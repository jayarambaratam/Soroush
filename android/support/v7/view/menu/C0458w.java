package android.support.v7.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.w */
class C0458w extends BaseAdapter {
    final /* synthetic */ C0457v f2212a;
    private C0049i f2213b;
    private int f2214c;

    public C0458w(C0457v c0457v, C0049i c0049i) {
        this.f2212a = c0457v;
        this.f2214c = -1;
        this.f2213b = c0049i;
        m4093a();
    }

    public C0448m m4092a(int i) {
        ArrayList l = this.f2212a.mOverflowOnly ? this.f2213b.m132l() : this.f2213b.m129i();
        if (this.f2214c >= 0 && i >= this.f2214c) {
            i++;
        }
        return (C0448m) l.get(i);
    }

    void m4093a() {
        C0448m r = this.f2212a.mMenu.m138r();
        if (r != null) {
            ArrayList l = this.f2212a.mMenu.m132l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((C0448m) l.get(i)) == r) {
                    this.f2214c = i;
                    return;
                }
            }
        }
        this.f2214c = -1;
    }

    public int getCount() {
        ArrayList l = this.f2212a.mOverflowOnly ? this.f2213b.m132l() : this.f2213b.m129i();
        return this.f2214c < 0 ? l.size() : l.size() - 1;
    }

    public /* synthetic */ Object getItem(int i) {
        return m4092a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f2212a.mInflater.inflate(C0457v.ITEM_LAYOUT, viewGroup, false) : view;
        aa aaVar = (aa) inflate;
        if (this.f2212a.mForceShowIcon) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        aaVar.m75a(m4092a(i), 0);
        return inflate;
    }

    public void notifyDataSetChanged() {
        m4093a();
        super.notifyDataSetChanged();
    }
}
