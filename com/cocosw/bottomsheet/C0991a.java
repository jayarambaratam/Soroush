package com.cocosw.bottomsheet;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.p007d.p008a.C0048a;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;

/* renamed from: com.cocosw.bottomsheet.a */
class C0991a implements C0048a {
    private static final int[] f3747c;
    private Context f3748a;
    private boolean f3749b;
    private ArrayList<C0992b> f3750d;

    static {
        f3747c = new int[]{1, 4, 5, 3, 2, 0};
    }

    public C0991a(Context context) {
        this.f3748a = context;
        this.f3750d = new ArrayList();
    }

    private static int m6057a(ArrayList<C0992b> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0992b) arrayList.get(size)).getOrder() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private C0992b m6058a(int i, KeyEvent keyEvent) {
        boolean z = this.f3749b;
        ArrayList arrayList = this.f3750d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0992b c0992b = (C0992b) arrayList.get(i2);
            if (i == (z ? c0992b.getAlphabeticShortcut() : c0992b.getNumericShortcut())) {
                return c0992b;
            }
        }
        return null;
    }

    private static int m6059b(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f3747c.length) {
            return (f3747c[i2] << 16) | (InBandBytestreamManager.MAXIMUM_BLOCK_SIZE & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private int m6060c(int i) {
        ArrayList arrayList = this.f3750d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0992b) arrayList.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public Context m6061a() {
        return this.f3748a;
    }

    MenuItem m6062a(C0992b c0992b) {
        this.f3750d.add(C0991a.m6057a(this.f3750d, C0991a.m6059b(c0992b.getOrder())), c0992b);
        return c0992b;
    }

    C0991a m6063a(int i) {
        C0991a c0991a = new C0991a(m6061a());
        c0991a.f3750d = new ArrayList(this.f3750d.subList(0, i));
        return c0991a;
    }

    public MenuItem add(int i) {
        return add(0, 0, 0, i);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return add(i, i2, i3, this.f3748a.getResources().getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        MenuItem c0992b = new C0992b(m6061a(), i, i2, 0, i3, charSequence);
        this.f3750d.add(C0991a.m6057a(this.f3750d, C0991a.m6059b(i3)), c0992b);
        return c0992b;
    }

    public MenuItem add(CharSequence charSequence) {
        return add(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f3748a.getPackageManager();
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
        return null;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return null;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return null;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    void m6064b() {
        Iterator it = this.f3750d.iterator();
        while (it.hasNext()) {
            if (!((C0992b) it.next()).isVisible()) {
                it.remove();
            }
        }
    }

    public void clear() {
        this.f3750d.clear();
    }

    public void close() {
    }

    public MenuItem findItem(int i) {
        return (MenuItem) this.f3750d.get(m6060c(i));
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f3750d.get(i);
    }

    public boolean hasVisibleItems() {
        ArrayList arrayList = this.f3750d;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((C0992b) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m6058a(i, keyEvent) != null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        int c = m6060c(i);
        return c < 0 ? false : ((C0992b) this.f3750d.get(c)).m6072b();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        C0992b a = m6058a(i, keyEvent);
        return a == null ? false : a.m6072b();
    }

    public void removeGroup(int i) {
        ArrayList arrayList = this.f3750d;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            if (((C0992b) arrayList.get(i2)).getGroupId() == i) {
                arrayList.remove(i2);
                size--;
            } else {
                i2++;
            }
        }
    }

    public void removeItem(int i) {
        this.f3750d.remove(m6060c(i));
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ArrayList arrayList = this.f3750d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0992b c0992b = (C0992b) arrayList.get(i2);
            if (c0992b.getGroupId() == i) {
                c0992b.setCheckable(z);
                c0992b.m6070a(z2);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        ArrayList arrayList = this.f3750d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0992b c0992b = (C0992b) arrayList.get(i2);
            if (c0992b.getGroupId() == i) {
                c0992b.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        ArrayList arrayList = this.f3750d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0992b c0992b = (C0992b) arrayList.get(i2);
            if (c0992b.getGroupId() == i) {
                c0992b.setVisible(z);
            }
        }
    }

    public void setQwertyMode(boolean z) {
        this.f3749b = z;
    }

    public int size() {
        return this.f3750d.size();
    }
}
