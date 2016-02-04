package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p007d.p008a.C0048a;
import android.support.v4.p012b.C0125h;
import android.support.v4.view.C0319n;
import android.support.v4.view.ax;
import android.support.v7.p019a.C0360c;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;

/* renamed from: android.support.v7.view.menu.i */
public class C0049i implements C0048a {
    private static final int[] f209d;
    CharSequence f210a;
    Drawable f211b;
    View f212c;
    private final Context f213e;
    private final Resources f214f;
    private boolean f215g;
    private boolean f216h;
    private C0074j f217i;
    private ArrayList<C0448m> f218j;
    private ArrayList<C0448m> f219k;
    private boolean f220l;
    private ArrayList<C0448m> f221m;
    private ArrayList<C0448m> f222n;
    private boolean f223o;
    private int f224p;
    private ContextMenuInfo f225q;
    private boolean f226r;
    private boolean f227s;
    private boolean f228t;
    private boolean f229u;
    private ArrayList<C0448m> f230v;
    private CopyOnWriteArrayList<WeakReference<C0051x>> f231w;
    private C0448m f232x;
    private boolean f233y;

    static {
        f209d = new int[]{1, 4, 5, 3, 2, 0};
    }

    public C0049i(Context context) {
        this.f224p = 0;
        this.f226r = false;
        this.f227s = false;
        this.f228t = false;
        this.f229u = false;
        this.f230v = new ArrayList();
        this.f231w = new CopyOnWriteArrayList();
        this.f213e = context;
        this.f214f = context.getResources();
        this.f218j = new ArrayList();
        this.f219k = new ArrayList();
        this.f220l = true;
        this.f221m = new ArrayList();
        this.f222n = new ArrayList();
        this.f223o = true;
        m90e(true);
    }

    private static int m82a(ArrayList<C0448m> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0448m) arrayList.get(size)).m4069c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private C0448m m83a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0448m(this, i, i2, i3, i4, charSequence, i5);
    }

    private void m84a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = m122d();
        if (view != null) {
            this.f212c = view;
            this.f210a = null;
            this.f211b = null;
        } else {
            if (i > 0) {
                this.f210a = d.getText(i);
            } else if (charSequence != null) {
                this.f210a = charSequence;
            }
            if (i2 > 0) {
                this.f211b = C0125h.m1018a(m125e(), i2);
            } else if (drawable != null) {
                this.f211b = drawable;
            }
            this.f212c = null;
        }
        m107a(false);
    }

    private void m85a(int i, boolean z) {
        if (i >= 0 && i < this.f218j.size()) {
            this.f218j.remove(i);
            if (z) {
                m107a(true);
            }
        }
    }

    private boolean m86a(ad adVar, C0051x c0051x) {
        boolean z = false;
        if (this.f231w.isEmpty()) {
            return false;
        }
        if (c0051x != null) {
            z = c0051x.onSubMenuSelected(adVar);
        }
        Iterator it = this.f231w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0051x c0051x2 = (C0051x) weakReference.get();
            if (c0051x2 == null) {
                this.f231w.remove(weakReference);
                z = z2;
            } else {
                z = !z2 ? c0051x2.onSubMenuSelected(adVar) : z2;
            }
            z2 = z;
        }
        return z2;
    }

    private static int m87d(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f209d.length) {
            return (f209d[i2] << 16) | (InBandBytestreamManager.MAXIMUM_BLOCK_SIZE & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void m88d(boolean z) {
        if (!this.f231w.isEmpty()) {
            m127g();
            Iterator it = this.f231w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0051x c0051x = (C0051x) weakReference.get();
                if (c0051x == null) {
                    this.f231w.remove(weakReference);
                } else {
                    c0051x.updateMenuView(z);
                }
            }
            m128h();
        }
    }

    private void m89e(Bundle bundle) {
        if (!this.f231w.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.f231w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0051x c0051x = (C0051x) weakReference.get();
                if (c0051x == null) {
                    this.f231w.remove(weakReference);
                } else {
                    int id = c0051x.getId();
                    if (id > 0) {
                        Parcelable onSaveInstanceState = c0051x.onSaveInstanceState();
                        if (onSaveInstanceState != null) {
                            sparseArray.put(id, onSaveInstanceState);
                        }
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    private void m90e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f214f.getConfiguration().keyboard != 1 && this.f214f.getBoolean(C0360c.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f216h = z2;
    }

    private void m91f(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.f231w.isEmpty()) {
            Iterator it = this.f231w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0051x c0051x = (C0051x) weakReference.get();
                if (c0051x == null) {
                    this.f231w.remove(weakReference);
                } else {
                    int id = c0051x.getId();
                    if (id > 0) {
                        Parcelable parcelable = (Parcelable) sparseParcelableArray.get(id);
                        if (parcelable != null) {
                            c0051x.onRestoreInstanceState(parcelable);
                        }
                    }
                }
            }
        }
    }

    public int m92a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0448m) this.f218j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public C0049i m93a(int i) {
        this.f224p = i;
        return this;
    }

    protected C0049i m94a(Drawable drawable) {
        m84a(0, null, 0, drawable, null);
        return this;
    }

    protected C0049i m95a(View view) {
        m84a(0, null, 0, null, view);
        return this;
    }

    protected C0049i m96a(CharSequence charSequence) {
        m84a(0, charSequence, 0, null, null);
        return this;
    }

    C0448m m97a(int i, KeyEvent keyEvent) {
        List list = this.f230v;
        list.clear();
        m106a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (C0448m) list.get(0);
        }
        boolean b = m116b();
        for (int i2 = 0; i2 < size; i2++) {
            C0448m c0448m = (C0448m) list.get(i2);
            char alphabeticShortcut = b ? c0448m.getAlphabeticShortcut() : c0448m.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0448m;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0448m;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return c0448m;
            }
        }
        return null;
    }

    protected MenuItem m98a(int i, int i2, int i3, CharSequence charSequence) {
        int d = C0049i.m87d(i3);
        MenuItem a = m83a(i, i2, i3, d, charSequence, this.f224p);
        if (this.f225q != null) {
            a.m4064a(this.f225q);
        }
        this.f218j.add(C0049i.m82a(this.f218j, d), a);
        m107a(true);
        return a;
    }

    protected String m99a() {
        return "android:menu:actionviewstates";
    }

    public void m100a(Bundle bundle) {
        m89e(bundle);
    }

    public void m101a(C0074j c0074j) {
        this.f217i = c0074j;
    }

    void m102a(C0448m c0448m) {
        this.f220l = true;
        m107a(true);
    }

    public void m103a(C0051x c0051x) {
        m104a(c0051x, this.f213e);
    }

    public void m104a(C0051x c0051x, Context context) {
        this.f231w.add(new WeakReference(c0051x));
        c0051x.initForMenu(context, this);
        this.f223o = true;
    }

    void m105a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f218j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C0448m) this.f218j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m4076g() && menuItem2.isCheckable()) {
                menuItem2.m4067b(menuItem2 == menuItem);
            }
        }
    }

    void m106a(List<C0448m> list, int i, KeyEvent keyEvent) {
        boolean b = m116b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f218j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0448m c0448m = (C0448m) this.f218j.get(i2);
                if (c0448m.hasSubMenu()) {
                    ((C0049i) c0448m.getSubMenu()).m106a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = b ? c0448m.getAlphabeticShortcut() : c0448m.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && c0448m.isEnabled())) {
                    list.add(c0448m);
                }
            }
        }
    }

    public void m107a(boolean z) {
        if (this.f226r) {
            this.f227s = true;
            return;
        }
        if (z) {
            this.f220l = true;
            this.f223o = true;
        }
        m88d(z);
    }

    boolean m108a(C0049i c0049i, MenuItem menuItem) {
        return this.f217i != null && this.f217i.onMenuItemSelected(c0049i, menuItem);
    }

    public boolean m109a(MenuItem menuItem, int i) {
        return m110a(menuItem, null, i);
    }

    public boolean m110a(MenuItem menuItem, C0051x c0051x, int i) {
        C0448m c0448m = (C0448m) menuItem;
        if (c0448m == null || !c0448m.isEnabled()) {
            return false;
        }
        boolean b = c0448m.m4068b();
        C0319n a = c0448m.m4061a();
        boolean z = a != null && a.hasSubMenu();
        boolean expandActionView;
        if (c0448m.m4083n()) {
            expandActionView = c0448m.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            m115b(true);
            return expandActionView;
        } else if (c0448m.hasSubMenu() || z) {
            m115b(false);
            if (!c0448m.hasSubMenu()) {
                c0448m.m4063a(new ad(m125e(), this, c0448m));
            }
            ad adVar = (ad) c0448m.getSubMenu();
            if (z) {
                a.onPrepareSubMenu(adVar);
            }
            expandActionView = m86a(adVar, c0051x) | b;
            if (expandActionView) {
                return expandActionView;
            }
            m115b(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m115b(true);
            }
            return b;
        }
    }

    public MenuItem add(int i) {
        return m98a(0, 0, 0, this.f214f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m98a(i, i2, i3, this.f214f.getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m98a(i, i2, i3, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return m98a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f213e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f214f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f214f.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0448m c0448m = (C0448m) m98a(i, i2, i3, charSequence);
        ad adVar = new ad(this.f213e, this, c0448m);
        c0448m.m4063a(adVar);
        return adVar;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int m111b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0448m) this.f218j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void m112b(Bundle bundle) {
        m91f(bundle);
    }

    void m113b(C0448m c0448m) {
        this.f223o = true;
        m107a(true);
    }

    public void m114b(C0051x c0051x) {
        Iterator it = this.f231w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0051x c0051x2 = (C0051x) weakReference.get();
            if (c0051x2 == null || c0051x2 == c0051x) {
                this.f231w.remove(weakReference);
            }
        }
    }

    public final void m115b(boolean z) {
        if (!this.f229u) {
            this.f229u = true;
            Iterator it = this.f231w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0051x c0051x = (C0051x) weakReference.get();
                if (c0051x == null) {
                    this.f231w.remove(weakReference);
                } else {
                    c0051x.onCloseMenu(this, z);
                }
            }
            this.f229u = false;
        }
    }

    boolean m116b() {
        return this.f215g;
    }

    public int m117c(int i) {
        return m92a(i, 0);
    }

    public void m118c(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = ax.m2245a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (ax.m2249c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((ad) item.getSubMenu()).m118c(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(m99a(), sparseArray);
        }
    }

    public void m119c(boolean z) {
        this.f233y = z;
    }

    public boolean m120c() {
        return this.f216h;
    }

    public boolean m121c(C0448m c0448m) {
        boolean z = false;
        if (!this.f231w.isEmpty()) {
            m127g();
            Iterator it = this.f231w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0051x c0051x = (C0051x) weakReference.get();
                if (c0051x == null) {
                    this.f231w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0051x.expandItemActionView(this, c0448m);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m128h();
            if (z) {
                this.f232x = c0448m;
            }
        }
        return z;
    }

    public void clear() {
        if (this.f232x != null) {
            m124d(this.f232x);
        }
        this.f218j.clear();
        m107a(true);
    }

    public void clearHeader() {
        this.f211b = null;
        this.f210a = null;
        this.f212c = null;
        m107a(false);
    }

    public void close() {
        m115b(true);
    }

    Resources m122d() {
        return this.f214f;
    }

    public void m123d(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(m99a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = ax.m2245a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((ad) item.getSubMenu()).m123d(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    ax.m2248b(item);
                }
            }
        }
    }

    public boolean m124d(C0448m c0448m) {
        boolean z = false;
        if (!this.f231w.isEmpty() && this.f232x == c0448m) {
            m127g();
            Iterator it = this.f231w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0051x c0051x = (C0051x) weakReference.get();
                if (c0051x == null) {
                    this.f231w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0051x.collapseItemActionView(this, c0448m);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m128h();
            if (z) {
                this.f232x = null;
            }
        }
        return z;
    }

    public Context m125e() {
        return this.f213e;
    }

    public void m126f() {
        if (this.f217i != null) {
            this.f217i.onMenuModeChange(this);
        }
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0448m c0448m = (C0448m) this.f218j.get(i2);
            if (c0448m.getItemId() == i) {
                return c0448m;
            }
            if (c0448m.hasSubMenu()) {
                MenuItem findItem = c0448m.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public void m127g() {
        if (!this.f226r) {
            this.f226r = true;
            this.f227s = false;
        }
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f218j.get(i);
    }

    public void m128h() {
        this.f226r = false;
        if (this.f227s) {
            this.f227s = false;
            m107a(true);
        }
    }

    public boolean hasVisibleItems() {
        if (this.f233y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0448m) this.f218j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<C0448m> m129i() {
        if (!this.f220l) {
            return this.f219k;
        }
        this.f219k.clear();
        int size = this.f218j.size();
        for (int i = 0; i < size; i++) {
            C0448m c0448m = (C0448m) this.f218j.get(i);
            if (c0448m.isVisible()) {
                this.f219k.add(c0448m);
            }
        }
        this.f220l = false;
        this.f223o = true;
        return this.f219k;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m97a(i, keyEvent) != null;
    }

    public void m130j() {
        ArrayList i = m129i();
        if (this.f223o) {
            Iterator it = this.f231w.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                C0051x c0051x = (C0051x) weakReference.get();
                if (c0051x == null) {
                    this.f231w.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = c0051x.flagActionItems() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.f221m.clear();
                this.f222n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    C0448m c0448m = (C0448m) i.get(i4);
                    if (c0448m.m4079j()) {
                        this.f221m.add(c0448m);
                    } else {
                        this.f222n.add(c0448m);
                    }
                }
            } else {
                this.f221m.clear();
                this.f222n.clear();
                this.f222n.addAll(m129i());
            }
            this.f223o = false;
        }
    }

    public ArrayList<C0448m> m131k() {
        m130j();
        return this.f221m;
    }

    public ArrayList<C0448m> m132l() {
        m130j();
        return this.f222n;
    }

    public CharSequence m133m() {
        return this.f210a;
    }

    public Drawable m134n() {
        return this.f211b;
    }

    public View m135o() {
        return this.f212c;
    }

    public C0049i m136p() {
        return this;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m109a(findItem(i), i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m97a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m109a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m115b(true);
        }
        return z;
    }

    boolean m137q() {
        return this.f228t;
    }

    public C0448m m138r() {
        return this.f232x;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeGroup(int r6) {
        /*
        r5 = this;
        r1 = 0;
        r3 = r5.m117c(r6);
        if (r3 < 0) goto L_0x002b;
    L_0x0007:
        r0 = r5.f218j;
        r0 = r0.size();
        r4 = r0 - r3;
        r0 = r1;
    L_0x0010:
        r2 = r0 + 1;
        if (r0 >= r4) goto L_0x0027;
    L_0x0014:
        r0 = r5.f218j;
        r0 = r0.get(r3);
        r0 = (android.support.v7.view.menu.C0448m) r0;
        r0 = r0.getGroupId();
        if (r0 != r6) goto L_0x0027;
    L_0x0022:
        r5.m85a(r3, r1);
        r0 = r2;
        goto L_0x0010;
    L_0x0027:
        r0 = 1;
        r5.m107a(r0);
    L_0x002b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.i.removeGroup(int):void");
    }

    public void removeItem(int i) {
        m85a(m111b(i), true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f218j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0448m c0448m = (C0448m) this.f218j.get(i2);
            if (c0448m.getGroupId() == i) {
                c0448m.m4065a(z2);
                c0448m.setCheckable(z);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f218j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0448m c0448m = (C0448m) this.f218j.get(i2);
            if (c0448m.getGroupId() == i) {
                c0448m.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f218j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            C0448m c0448m = (C0448m) this.f218j.get(i2);
            boolean z3 = (c0448m.getGroupId() == i && c0448m.m4070c(z)) ? true : z2;
            i2++;
            z2 = z3;
        }
        if (z2) {
            m107a(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.f215g = z;
        m107a(false);
    }

    public int size() {
        return this.f218j.size();
    }
}
