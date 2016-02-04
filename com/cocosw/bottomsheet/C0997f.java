package com.cocosw.bottomsheet;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: com.cocosw.bottomsheet.f */
class C0997f extends BaseAdapter {
    final /* synthetic */ C0993c f3788a;

    C0997f(C0993c c0993c) {
        this.f3788a = c0993c;
    }

    public MenuItem m6103a(int i) {
        return this.f3788a.f3784t.getItem(i);
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public int getCount() {
        return this.f3788a.f3784t.size() - this.f3788a.f3773i.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return m6103a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        C0998g c0998g;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.f3788a.getContext().getSystemService("layout_inflater");
            inflate = this.f3788a.f3772h.f3801e ? layoutInflater.inflate(C1010t.bs_grid_entry, viewGroup, false) : layoutInflater.inflate(C1010t.bs_list_entry, viewGroup, false);
            C0998g c0998g2 = new C0998g(this);
            c0998g2.f3790b = (TextView) inflate.findViewById(C1009s.bs_list_title);
            c0998g2.f3791c = (ImageView) inflate.findViewById(C1009s.bs_list_image);
            inflate.setTag(c0998g2);
            c0998g = c0998g2;
        } else {
            c0998g = (C0998g) view.getTag();
            inflate = view;
        }
        for (int i2 = 0; i2 < this.f3788a.f3773i.size(); i2++) {
            if (this.f3788a.f3773i.valueAt(i2) <= i) {
                i++;
            }
        }
        MenuItem a = m6103a(i);
        c0998g.f3790b.setText(a.getTitle());
        if (a.getIcon() == null) {
            c0998g.f3791c.setVisibility(this.f3788a.f3768d ? 8 : 4);
        } else {
            c0998g.f3791c.setVisibility(0);
            c0998g.f3791c.setImageDrawable(a.getIcon());
        }
        c0998g.f3791c.setEnabled(a.isEnabled());
        c0998g.f3790b.setEnabled(a.isEnabled());
        return inflate;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean isEnabled(int i) {
        return m6103a(i).isEnabled();
    }
}
