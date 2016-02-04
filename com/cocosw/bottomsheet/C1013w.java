package com.cocosw.bottomsheet;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.Arrays;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: com.cocosw.bottomsheet.w */
class C1013w extends BaseAdapter {
    SparseArray<C1016z> f3812a;
    private boolean f3813b;
    private int f3814c;
    private LayoutInflater f3815d;
    private ListAdapter f3816e;
    private C1016z[] f3817f;
    private Context f3818g;
    private View f3819h;
    private int f3820i;
    private int f3821j;
    private int f3822k;
    private int f3823l;
    private int f3824m;
    private int f3825n;
    private int f3826o;
    private int f3827p;
    private GridView f3828q;
    private int f3829r;
    private int f3830s;

    public C1013w(Context context, BaseAdapter baseAdapter, int i, int i2, int i3) {
        this.f3813b = true;
        this.f3812a = new SparseArray();
        this.f3817f = new C1016z[0];
        this.f3815d = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f3814c = i;
        this.f3829r = i2;
        this.f3830s = i3;
        this.f3816e = baseAdapter;
        this.f3818g = context;
        this.f3816e.registerDataSetObserver(new C1014x(this));
    }

    private C1006p m6131a(View view) {
        C1006p c1006p = new C1006p(this.f3818g);
        c1006p.m6129a(view);
        return c1006p;
    }

    private int m6133b() {
        if (this.f3820i > 0) {
            return this.f3820i;
        }
        if (this.f3822k != this.f3828q.getWidth()) {
            this.f3825n = this.f3828q.getStretchMode();
            this.f3822k = ((PinnedSectionGridView) this.f3828q).m6056a() - (this.f3828q.getPaddingLeft() + this.f3828q.getPaddingRight());
            this.f3821j = ((PinnedSectionGridView) this.f3828q).getNumColumns();
            this.f3826o = ((PinnedSectionGridView) this.f3828q).getColumnWidth();
            this.f3827p = ((PinnedSectionGridView) this.f3828q).getHorizontalSpacing();
        }
        int i = (this.f3822k - (this.f3821j * this.f3826o)) - ((this.f3821j - 1) * this.f3827p);
        switch (this.f3825n) {
            case VideoSize.QCIF /*0*/:
                this.f3822k -= i;
                this.f3823l = this.f3826o;
                this.f3824m = this.f3827p;
                break;
            case VideoSize.CIF /*1*/:
                this.f3823l = this.f3826o;
                if (this.f3821j <= 1) {
                    this.f3824m = i + this.f3827p;
                    break;
                }
                this.f3824m = (i / (this.f3821j - 1)) + this.f3827p;
                break;
            case VideoSize.HVGA /*2*/:
                this.f3823l = (i / this.f3821j) + this.f3826o;
                this.f3824m = this.f3827p;
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f3823l = this.f3826o;
                this.f3824m = this.f3827p;
                this.f3822k = (this.f3822k - i) + (this.f3824m * 2);
                break;
        }
        this.f3820i = this.f3822k + ((this.f3821j - 1) * (this.f3823l + this.f3824m));
        return this.f3820i;
    }

    public int m6134a(int i) {
        if (m6138b(i)) {
            return -1;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f3812a.size() && ((C1016z) this.f3812a.valueAt(i2)).f3834b <= i) {
            i3--;
            i2++;
        }
        return i + i3;
    }

    public void m6135a() {
        this.f3812a.clear();
        m6133b();
        Arrays.sort(this.f3817f, new C1015y(this));
        int i = 0;
        for (int i2 = 0; i2 < this.f3817f.length; i2++) {
            C1016z c1016z = this.f3817f[i2];
            int i3 = i;
            for (i = 0; i < this.f3821j - 1; i++) {
                C1016z c1016z2 = new C1016z(c1016z.f3833a, c1016z.f3835c);
                c1016z2.f3836d = 2;
                c1016z2.f3834b = c1016z2.f3833a + i3;
                this.f3812a.append(c1016z2.f3834b, c1016z2);
                i3++;
            }
            C1016z c1016z3 = new C1016z(c1016z.f3833a, c1016z.f3835c);
            c1016z3.f3836d = 1;
            c1016z3.f3834b = c1016z3.f3833a + i3;
            this.f3812a.append(c1016z3.f3834b, c1016z3);
            i = i3 + 1;
            if (i2 < this.f3817f.length - 1) {
                int i4 = this.f3817f[i2 + 1].f3833a;
                int i5 = this.f3821j - ((i4 - c1016z.f3833a) % this.f3821j);
                if (this.f3821j != i5) {
                    i3 = 0;
                    while (i3 < i5) {
                        c1016z2 = new C1016z(c1016z.f3833a, c1016z.f3835c);
                        c1016z2.f3836d = 0;
                        c1016z2.f3834b = i4 + i;
                        this.f3812a.append(c1016z2.f3834b, c1016z2);
                        i3++;
                        i++;
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public void m6136a(GridView gridView) {
        if (gridView instanceof PinnedSectionGridView) {
            this.f3828q = gridView;
            this.f3825n = gridView.getStretchMode();
            this.f3822k = gridView.getWidth() - (this.f3828q.getPaddingLeft() + this.f3828q.getPaddingRight());
            this.f3821j = ((PinnedSectionGridView) gridView).getNumColumns();
            this.f3826o = ((PinnedSectionGridView) gridView).getColumnWidth();
            this.f3827p = ((PinnedSectionGridView) gridView).getHorizontalSpacing();
            return;
        }
        throw new IllegalArgumentException("Does your grid view extends PinnedSectionGridView?");
    }

    public void m6137a(C1016z... c1016zArr) {
        this.f3817f = c1016zArr;
        m6135a();
    }

    public boolean areAllItemsEnabled() {
        return this.f3816e.areAllItemsEnabled();
    }

    public boolean m6138b(int i) {
        return this.f3812a.get(i) != null;
    }

    public int getCount() {
        return this.f3813b ? this.f3816e.getCount() + this.f3812a.size() : 0;
    }

    public Object getItem(int i) {
        return m6138b(i) ? this.f3812a.get(i) : this.f3816e.getItem(m6134a(i));
    }

    public long getItemId(int i) {
        return m6138b(i) ? (long) (ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - this.f3812a.indexOfKey(i)) : this.f3816e.getItemId(m6134a(i));
    }

    public int getItemViewType(int i) {
        return m6138b(i) ? getViewTypeCount() - 1 : this.f3816e.getItemViewType(m6134a(i));
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (m6138b(i)) {
            if (view == null) {
                view = this.f3815d.inflate(this.f3814c, viewGroup, false);
            } else if (view.findViewById(this.f3829r) == null) {
                view = this.f3815d.inflate(this.f3814c, viewGroup, false);
            }
            HeaderLayout headerLayout;
            switch (((C1016z) this.f3812a.get(i)).f3836d) {
                case VideoSize.CIF /*1*/:
                    headerLayout = (HeaderLayout) view.findViewById(this.f3829r);
                    if (!TextUtils.isEmpty(((C1016z) this.f3812a.get(i)).f3835c)) {
                        ((TextView) view.findViewById(this.f3830s)).setText(((C1016z) this.f3812a.get(i)).f3835c);
                    }
                    headerLayout.m6055a(m6133b());
                    return view;
                case VideoSize.HVGA /*2*/:
                    headerLayout = (HeaderLayout) view.findViewById(this.f3829r);
                    if (!TextUtils.isEmpty(((C1016z) this.f3812a.get(i)).f3835c)) {
                        ((TextView) view.findViewById(this.f3830s)).setText(((C1016z) this.f3812a.get(i)).f3835c);
                    }
                    headerLayout.m6055a(0);
                    return view;
                default:
                    return m6131a(this.f3819h);
            }
        }
        view = this.f3816e.getView(m6134a(i), view, viewGroup);
        this.f3819h = view;
        return view;
    }

    public int getViewTypeCount() {
        return this.f3816e.getViewTypeCount() + 1;
    }

    public boolean hasStableIds() {
        return this.f3816e.hasStableIds();
    }

    public boolean isEmpty() {
        return this.f3816e.isEmpty();
    }

    public boolean isEnabled(int i) {
        return m6138b(i) ? false : this.f3816e.isEnabled(m6134a(i));
    }
}
