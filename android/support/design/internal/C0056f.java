package android.support.design.internal;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.view.menu.C0448m;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: android.support.design.internal.f */
class C0056f extends Adapter<C0054n> {
    final /* synthetic */ C0052c f250a;
    private final ArrayList<C0057h> f251b;
    private C0448m f252c;
    private ColorDrawable f253d;
    private boolean f254e;

    C0056f(C0052c c0052c) {
        this.f250a = c0052c;
        this.f251b = new ArrayList();
        m165c();
    }

    private void m164a(int i, int i2) {
        while (i < i2) {
            MenuItem a = ((C0060j) this.f251b.get(i)).m176a();
            if (a.getIcon() == null) {
                if (this.f253d == null) {
                    this.f253d = new ColorDrawable(17170445);
                }
                a.setIcon(this.f253d);
            }
            i++;
        }
    }

    private void m165c() {
        if (!this.f254e) {
            this.f254e = true;
            this.f251b.clear();
            this.f251b.add(new C0058g());
            int i = -1;
            int i2 = 0;
            Object obj = null;
            int size = this.f250a.f237d.m129i().size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2;
                int i4;
                int i5;
                C0448m c0448m = (C0448m) this.f250a.f237d.m129i().get(i3);
                if (c0448m.isChecked()) {
                    m171a(c0448m);
                }
                if (c0448m.isCheckable()) {
                    c0448m.m4065a(false);
                }
                int i6;
                if (c0448m.hasSubMenu()) {
                    SubMenu subMenu = c0448m.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i3 != 0) {
                            this.f251b.add(new C0059i(this.f250a.f247n, 0));
                        }
                        this.f251b.add(new C0060j(null));
                        Object obj3 = null;
                        int size2 = this.f251b.size();
                        int size3 = subMenu.size();
                        for (i6 = 0; i6 < size3; i6++) {
                            C0448m c0448m2 = (C0448m) subMenu.getItem(i6);
                            if (c0448m2.isVisible()) {
                                if (obj3 == null && c0448m2.getIcon() != null) {
                                    obj3 = 1;
                                }
                                if (c0448m2.isCheckable()) {
                                    c0448m2.m4065a(false);
                                }
                                if (c0448m.isChecked()) {
                                    m171a(c0448m);
                                }
                                this.f251b.add(new C0060j(null));
                            }
                        }
                        if (obj3 != null) {
                            m164a(size2, this.f251b.size());
                        }
                    }
                    obj2 = obj;
                    i4 = i2;
                    i5 = i;
                } else {
                    Object obj4;
                    i6 = c0448m.getGroupId();
                    if (i6 != i) {
                        i2 = this.f251b.size();
                        obj = c0448m.getIcon() != null ? 1 : null;
                        if (i3 != 0) {
                            i2++;
                            this.f251b.add(new C0059i(this.f250a.f247n, this.f250a.f247n));
                            obj4 = obj;
                            i5 = i2;
                        }
                        obj4 = obj;
                        i5 = i2;
                    } else {
                        if (obj == null && c0448m.getIcon() != null) {
                            obj = 1;
                            m164a(i2, this.f251b.size());
                        }
                        obj4 = obj;
                        i5 = i2;
                    }
                    if (obj4 != null && c0448m.getIcon() == null) {
                        c0448m.setIcon(17170445);
                    }
                    this.f251b.add(new C0060j(null));
                    obj2 = obj4;
                    i4 = i5;
                    i5 = i6;
                }
                i3++;
                i2 = i4;
                i = i5;
                obj = obj2;
            }
            this.f254e = false;
        }
    }

    public C0054n m166a(ViewGroup viewGroup, int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                return new C0061k(this.f250a.f240g, viewGroup, this.f250a.f248o);
            case VideoSize.CIF /*1*/:
                return new C0063m(this.f250a.f240g, viewGroup);
            case VideoSize.HVGA /*2*/:
                return new C0062l(this.f250a.f240g, viewGroup);
            case Version.API03_CUPCAKE_15 /*3*/:
                return new C0055e(this.f250a.f235b);
            default:
                return null;
        }
    }

    public void m167a() {
        m165c();
        notifyDataSetChanged();
    }

    public void m168a(Bundle bundle) {
        C0057h c0057h;
        int i = bundle.getInt("android:menu:checked", 0);
        if (i != 0) {
            this.f254e = true;
            Iterator it = this.f251b.iterator();
            while (it.hasNext()) {
                c0057h = (C0057h) it.next();
                if (c0057h instanceof C0060j) {
                    C0448m a = ((C0060j) c0057h).m176a();
                    if (a != null && a.getItemId() == i) {
                        m171a(a);
                        break;
                    }
                }
            }
            this.f254e = false;
            m165c();
        }
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
        Iterator it2 = this.f251b.iterator();
        while (it2.hasNext()) {
            c0057h = (C0057h) it2.next();
            if (c0057h instanceof C0060j) {
                C0448m a2 = ((C0060j) c0057h).m176a();
                View actionView = a2 != null ? a2.getActionView() : null;
                if (actionView != null) {
                    actionView.restoreHierarchyState((SparseArray) sparseParcelableArray.get(a2.getItemId()));
                }
            }
        }
    }

    public void m169a(C0054n c0054n) {
        if (c0054n instanceof C0061k) {
            ((NavigationMenuItemView) c0054n.itemView).m78a();
        }
    }

    public void m170a(C0054n c0054n, int i) {
        switch (getItemViewType(i)) {
            case VideoSize.QCIF /*0*/:
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) c0054n.itemView;
                navigationMenuItemView.setIconTintList(this.f250a.f244k);
                if (this.f250a.f242i) {
                    navigationMenuItemView.m79a(navigationMenuItemView.getContext(), this.f250a.f241h);
                }
                if (this.f250a.f243j != null) {
                    navigationMenuItemView.setTextColor(this.f250a.f243j);
                }
                navigationMenuItemView.setBackgroundDrawable(this.f250a.f245l != null ? this.f250a.f245l.getConstantState().newDrawable() : null);
                navigationMenuItemView.m80a(((C0060j) this.f251b.get(i)).m176a(), 0);
            case VideoSize.CIF /*1*/:
                ((TextView) c0054n.itemView).setText(((C0060j) this.f251b.get(i)).m176a().getTitle());
            case VideoSize.HVGA /*2*/:
                C0059i c0059i = (C0059i) this.f251b.get(i);
                c0054n.itemView.setPadding(0, c0059i.m174a(), 0, c0059i.m175b());
            default:
        }
    }

    public void m171a(C0448m c0448m) {
        if (this.f252c != c0448m && c0448m.isCheckable()) {
            if (this.f252c != null) {
                this.f252c.setChecked(false);
            }
            this.f252c = c0448m;
            c0448m.setChecked(true);
        }
    }

    public void m172a(boolean z) {
        this.f254e = z;
    }

    public Bundle m173b() {
        Bundle bundle = new Bundle();
        if (this.f252c != null) {
            bundle.putInt("android:menu:checked", this.f252c.getItemId());
        }
        SparseArray sparseArray = new SparseArray();
        Iterator it = this.f251b.iterator();
        while (it.hasNext()) {
            C0057h c0057h = (C0057h) it.next();
            if (c0057h instanceof C0060j) {
                C0448m a = ((C0060j) c0057h).m176a();
                View actionView = a != null ? a.getActionView() : null;
                if (actionView != null) {
                    SparseArray parcelableSparseArray = new ParcelableSparseArray();
                    actionView.saveHierarchyState(parcelableSparseArray);
                    sparseArray.put(a.getItemId(), parcelableSparseArray);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
        return bundle;
    }

    public int getItemCount() {
        return this.f251b.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        C0057h c0057h = (C0057h) this.f251b.get(i);
        if (c0057h instanceof C0059i) {
            return 2;
        }
        if (c0057h instanceof C0058g) {
            return 3;
        }
        if (c0057h instanceof C0060j) {
            return ((C0060j) c0057h).m176a().hasSubMenu() ? 1 : 0;
        } else {
            throw new RuntimeException("Unknown item type.");
        }
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        m170a((C0054n) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m166a(viewGroup, i);
    }

    public /* synthetic */ void onViewRecycled(ViewHolder viewHolder) {
        m169a((C0054n) viewHolder);
    }
}
