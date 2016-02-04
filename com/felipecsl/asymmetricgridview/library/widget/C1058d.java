package com.felipecsl.asymmetricgridview.library.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.felipecsl.asymmetricgridview.library.C1040a;
import com.felipecsl.asymmetricgridview.library.C1053n;
import com.felipecsl.asymmetricgridview.library.C1054o;
import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;
import com.felipecsl.asymmetricgridview.library.widget.d$com.felipecsl.asymmetricgridview.library.widget.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.felipecsl.asymmetricgridview.library.widget.d */
public abstract class C1058d<T extends AsymmetricItem> extends BaseAdapter implements OnClickListener, OnLongClickListener, C1040a {
    protected final AsymmetricGridView f3984a;
    protected final Context f3985b;
    protected final List<T> f3986c;
    private Map<Integer, RowInfo<T>> f3987d;
    private final ViewPool<C1062g> f3988e;
    private final ViewPool<View> f3989f;
    private e f3990g;

    public C1058d(Context context, AsymmetricGridView asymmetricGridView, List<T> list) {
        this.f3987d = new HashMap();
        this.f3989f = new ViewPool();
        this.f3988e = new ViewPool(new C1064h(context));
        this.f3986c = list;
        this.f3985b = context;
        this.f3984a = asymmetricGridView;
    }

    private RowInfo<T> m6270a(List<T> list, float f) {
        List arrayList = new ArrayList();
        int i = 0;
        int i2 = 1;
        float f2 = f;
        while (f2 > 0.0f && i < list.size()) {
            int b;
            float b2;
            int i3 = i + 1;
            AsymmetricItem asymmetricItem = (AsymmetricItem) list.get(i);
            float b3 = (float) (asymmetricItem.m6243b() * asymmetricItem.m6242a());
            if (this.f3984a.m6251c()) {
                Log.d("AsymmetricGridViewAdapter", String.format("item %s in row with height %s consumes %s area", new Object[]{asymmetricItem, Integer.valueOf(i2), Float.valueOf(b3)}));
            }
            if (i2 < asymmetricItem.m6243b()) {
                arrayList.clear();
                b = asymmetricItem.m6243b();
                i2 = 0;
                b2 = ((float) asymmetricItem.m6243b()) * f;
            } else if (f2 >= b3) {
                f2 -= b3;
                arrayList.add(asymmetricItem);
                b2 = f2;
                b = i2;
                i2 = i3;
            } else if (!this.f3984a.m6249b()) {
                break;
            } else {
                b2 = f2;
                b = i2;
                i2 = i3;
            }
            float f3 = b2;
            i = i2;
            i2 = b;
            f2 = f3;
        }
        return new RowInfo(i2, arrayList, f2);
    }

    private C1062g m6271a(View view) {
        C1062g c1062g;
        if (view == null || !(view instanceof C1062g)) {
            c1062g = new C1062g(this.f3985b, null);
            c1062g.setShowDividers(2);
            c1062g.setDividerDrawable(this.f3985b.getResources().getDrawable(C1053n.item_divider_horizontal));
            c1062g.setLayoutParams(new LayoutParams(-1, -2));
        } else {
            c1062g = (C1062g) view;
        }
        for (int i = 0; i < c1062g.getChildCount(); i++) {
            View view2 = (C1062g) c1062g.getChildAt(i);
            this.f3988e.m6256a(view2);
            for (int i2 = 0; i2 < view2.getChildCount(); i2++) {
                this.f3989f.m6256a(view2.getChildAt(i2));
            }
            view2.removeAllViews();
        }
        c1062g.removeAllViews();
        return c1062g;
    }

    private C1062g m6272a(LinearLayout linearLayout, int i) {
        C1062g c1062g = (C1062g) linearLayout.getChildAt(i);
        if (c1062g != null) {
            return c1062g;
        }
        c1062g = (C1062g) this.f3988e.m6254a();
        c1062g.setOrientation(1);
        c1062g.setShowDividers(2);
        c1062g.setDividerDrawable(this.f3985b.getResources().getDrawable(C1053n.item_divider_vertical));
        c1062g.setLayoutParams(new LayoutParams(-2, -1));
        linearLayout.addView(c1062g);
        return c1062g;
    }

    private RowInfo<T> m6274b(List<T> list) {
        return m6270a((List) list, (float) this.f3984a.getNumColumns());
    }

    protected int m6275a(AsymmetricItem asymmetricItem) {
        return m6281b(asymmetricItem.m6243b());
    }

    public abstract View m6276a(int i, View view, ViewGroup viewGroup);

    public T m6277a(int i) {
        return (AsymmetricItem) this.f3986c.get(i);
    }

    public void m6278a() {
        if (this.f3990g != null) {
            this.f3990g.m6235a(true);
        }
        this.f3988e.m6257b();
        this.f3989f.m6257b();
        this.f3987d.clear();
        new ArrayList().addAll(this.f3986c);
        this.f3990g = new C1059e(this);
        this.f3990g.m6239c((Object[]) new List[]{r0});
    }

    public void m6279a(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            int i = bundle.getInt("totalItems");
            List arrayList = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add((AsymmetricItem) bundle.getParcelable("item_" + i2));
            }
            m6280a(arrayList);
        }
    }

    public void m6280a(List<T> list) {
        this.f3988e.m6257b();
        this.f3989f.m6257b();
        this.f3986c.clear();
        this.f3986c.addAll(list);
        m6278a();
        notifyDataSetChanged();
    }

    protected int m6281b(int i) {
        return (this.f3984a.getColumnWidth() * i) + ((i - 1) * this.f3984a.getDividerHeight());
    }

    protected int m6282b(AsymmetricItem asymmetricItem) {
        return m6285c(asymmetricItem.m6242a());
    }

    public Parcelable m6283b() {
        Parcelable bundle = new Bundle();
        bundle.putInt("totalItems", this.f3986c.size());
        for (int i = 0; i < this.f3986c.size(); i++) {
            bundle.putParcelable("item_" + i, (Parcelable) this.f3986c.get(i));
        }
        return bundle;
    }

    public int m6284c() {
        return this.f3987d.size();
    }

    protected int m6285c(int i) {
        return Math.min((this.f3984a.getColumnWidth() * i) + ((i - 1) * this.f3984a.getRequestedHorizontalSpacing()), C1054o.m6244a(this.f3985b));
    }

    public int getCount() {
        return m6284c();
    }

    public /* synthetic */ Object getItem(int i) {
        return m6277a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f3984a.m6251c()) {
            Log.d("AsymmetricGridViewAdapter", "getView(" + String.valueOf(i) + ")");
        }
        LinearLayout a = m6271a(view);
        RowInfo rowInfo = (RowInfo) this.f3987d.get(Integer.valueOf(i));
        List arrayList = new ArrayList();
        arrayList.addAll(rowInfo.m6252a());
        int b = rowInfo.m6253b();
        int i2 = 0;
        int i3 = 0;
        while (!arrayList.isEmpty() && i3 < this.f3984a.getNumColumns()) {
            AsymmetricItem asymmetricItem = (AsymmetricItem) arrayList.get(i2);
            if (b == 0) {
                i2 = 0;
                i3++;
                b = rowInfo.m6253b();
            } else {
                int i4;
                if (b < asymmetricItem.m6243b()) {
                    if (i2 >= arrayList.size() - 1) {
                        break;
                    }
                    int i5 = b;
                    b = i2 + 1;
                    i4 = i5;
                } else {
                    arrayList.remove(asymmetricItem);
                    i2 = this.f3986c.indexOf(asymmetricItem);
                    LinearLayout a2 = m6272a(a, i3);
                    View a3 = m6276a(i2, this.f3989f.m6254a(), viewGroup);
                    a3.setTag(asymmetricItem);
                    a3.setOnClickListener(this);
                    a3.setOnLongClickListener(this);
                    b -= asymmetricItem.m6243b();
                    a3.setLayoutParams(new LinearLayout.LayoutParams(m6282b(asymmetricItem), m6275a(asymmetricItem)));
                    a2.addView(a3);
                    i4 = b;
                    b = 0;
                }
                i2 = b;
                b = i4;
            }
        }
        if (this.f3984a.m6251c() && i % 20 == 0) {
            Log.d("AsymmetricGridViewAdapter", this.f3988e.m6255a("LinearLayout"));
            Log.d("AsymmetricGridViewAdapter", this.f3989f.m6255a("Views"));
        }
        return a;
    }

    public void onClick(View view) {
        this.f3984a.m6248a(this.f3986c.indexOf((AsymmetricItem) view.getTag()), view);
    }

    public boolean onLongClick(View view) {
        return this.f3984a.m6250b(this.f3986c.indexOf((AsymmetricItem) view.getTag()), view);
    }
}
