package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.p016f.C0223a;
import android.support.v4.p016f.C0228e;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: android.support.v4.app.e */
final class C0132e extends an implements Runnable {
    static final boolean f937a;
    final C0153z f938b;
    C0136i f939c;
    C0136i f940d;
    int f941e;
    int f942f;
    int f943g;
    int f944h;
    int f945i;
    int f946j;
    int f947k;
    boolean f948l;
    boolean f949m;
    String f950n;
    boolean f951o;
    int f952p;
    int f953q;
    CharSequence f954r;
    int f955s;
    CharSequence f956t;
    ArrayList<String> f957u;
    ArrayList<String> f958v;

    static {
        f937a = VERSION.SDK_INT >= 21;
    }

    public C0132e(C0153z c0153z) {
        this.f949m = true;
        this.f952p = -1;
        this.f938b = c0153z;
    }

    private C0137j m1249a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i = 0;
        C0137j c0137j = new C0137j(this);
        c0137j.f986d = new View(this.f938b.f1032o.m1328g());
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4 = m1270a(sparseArray.keyAt(i2), c0137j, z, (SparseArray) sparseArray, (SparseArray) sparseArray2) ? 1 : i3;
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && m1270a(i4, c0137j, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        return i3 == 0 ? null : c0137j;
    }

    private C0223a<String, View> m1251a(C0137j c0137j, Fragment fragment, boolean z) {
        C0223a c0223a = new C0223a();
        if (this.f957u != null) {
            ao.m1077a((Map) c0223a, fragment.m996i());
            if (z) {
                c0223a.m1671a(this.f958v);
            } else {
                c0223a = C0132e.m1253a(this.f957u, this.f958v, c0223a);
            }
        }
        if (z) {
            if (fragment.f751Y != null) {
                fragment.f751Y.m1239a(this.f958v, c0223a);
            }
            m1263a(c0137j, c0223a, false);
        } else {
            if (fragment.f752Z != null) {
                fragment.f752Z.m1239a(this.f958v, c0223a);
            }
            m1273b(c0137j, c0223a, false);
        }
        return c0223a;
    }

    private C0223a<String, View> m1252a(C0137j c0137j, boolean z, Fragment fragment) {
        C0223a b = m1271b(c0137j, fragment, z);
        if (z) {
            if (fragment.f752Z != null) {
                fragment.f752Z.m1239a(this.f958v, b);
            }
            m1263a(c0137j, b, true);
        } else {
            if (fragment.f751Y != null) {
                fragment.f751Y.m1239a(this.f958v, b);
            }
            m1273b(c0137j, b, true);
        }
        return b;
    }

    private static C0223a<String, View> m1253a(ArrayList<String> arrayList, ArrayList<String> arrayList2, C0223a<String, View> c0223a) {
        if (c0223a.isEmpty()) {
            return c0223a;
        }
        C0223a<String, View> c0223a2 = new C0223a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) c0223a.get(arrayList.get(i));
            if (view != null) {
                c0223a2.put(arrayList2.get(i), view);
            }
        }
        return c0223a2;
    }

    private static Object m1254a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return ao.m1082b(z ? fragment2.m1013x() : fragment.m1012w());
    }

    private static Object m1255a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return ao.m1063a(z ? fragment.m1011v() : fragment.m1008s());
    }

    private static Object m1256a(Object obj, Fragment fragment, ArrayList<View> arrayList, C0223a<String, View> c0223a, View view) {
        return obj != null ? ao.m1064a(obj, fragment.m996i(), arrayList, c0223a, view) : obj;
    }

    private void m1257a(int i, Fragment fragment, String str, int i2) {
        fragment.f771t = this.f938b;
        if (str != null) {
            if (fragment.f777z == null || str.equals(fragment.f777z)) {
                fragment.f777z = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f777z + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.f775x == 0 || fragment.f775x == i) {
                fragment.f775x = i;
                fragment.f776y = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f775x + " now " + i);
            }
        }
        C0136i c0136i = new C0136i();
        c0136i.f976c = i2;
        c0136i.f977d = fragment;
        m1284a(c0136i);
    }

    private void m1261a(C0137j c0137j, int i, Object obj) {
        if (this.f938b.f1024g != null) {
            for (int i2 = 0; i2 < this.f938b.f1024g.size(); i2++) {
                Fragment fragment = (Fragment) this.f938b.f1024g.get(i2);
                if (!(fragment.f736J == null || fragment.f735I == null || fragment.f776y != i)) {
                    if (!fragment.f727A) {
                        ao.m1072a(obj, fragment.f736J, false);
                        c0137j.f984b.remove(fragment.f736J);
                    } else if (!c0137j.f984b.contains(fragment.f736J)) {
                        ao.m1072a(obj, fragment.f736J, true);
                        c0137j.f984b.add(fragment.f736J);
                    }
                }
            }
        }
    }

    private void m1262a(C0137j c0137j, Fragment fragment, Fragment fragment2, boolean z, C0223a<String, View> c0223a) {
        cz czVar = z ? fragment2.f751Y : fragment.f751Y;
        if (czVar != null) {
            czVar.m1240b(new ArrayList(c0223a.keySet()), new ArrayList(c0223a.values()), null);
        }
    }

    private void m1263a(C0137j c0137j, C0223a<String, View> c0223a, boolean z) {
        int size = this.f958v == null ? 0 : this.f958v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f957u.get(i);
            View view = (View) c0223a.get((String) this.f958v.get(i));
            if (view != null) {
                String a = ao.m1066a(view);
                if (z) {
                    C0132e.m1267a(c0137j.f983a, str, a);
                } else {
                    C0132e.m1267a(c0137j.f983a, a, str);
                }
            }
        }
    }

    private void m1264a(C0137j c0137j, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new C0134g(this, view, obj, arrayList, c0137j, z, fragment, fragment2));
    }

    private static void m1265a(C0137j c0137j, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                C0132e.m1267a(c0137j.f983a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void m1266a(C0223a<String, View> c0223a, C0137j c0137j) {
        if (this.f958v != null && !c0223a.isEmpty()) {
            View view = (View) c0223a.get(this.f958v.get(0));
            if (view != null) {
                c0137j.f985c.f842a = view;
            }
        }
    }

    private static void m1267a(C0223a<String, String> c0223a, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < c0223a.size(); i++) {
                if (str.equals(c0223a.m1668c(i))) {
                    c0223a.m1664a(i, (Object) str2);
                    return;
                }
            }
            c0223a.put(str, str2);
        }
    }

    private static void m1268a(SparseArray<Fragment> sparseArray, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f776y;
            if (i != 0 && !fragment.m995h() && fragment.m991f() && fragment.m996i() != null && sparseArray.get(i) == null) {
                sparseArray.put(i, fragment);
            }
        }
    }

    private void m1269a(View view, C0137j c0137j, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new C0135h(this, view, c0137j, i, obj));
    }

    private boolean m1270a(int i, C0137j c0137j, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        View view = (ViewGroup) this.f938b.f1033p.m1296a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        ArrayList arrayList;
        Object a;
        View view2;
        au c0133f;
        ArrayList arrayList2;
        Map c0223a;
        boolean z2;
        Object a2;
        Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        Object a3 = C0132e.m1255a(fragment, z);
        Object a4 = C0132e.m1254a(fragment, fragment2, z);
        Object b = C0132e.m1272b(fragment2, z);
        Map map = null;
        ArrayList arrayList3 = new ArrayList();
        if (a4 != null) {
            map = m1251a(c0137j, fragment2, z);
            if (map.isEmpty()) {
                map = null;
                obj = null;
                if (a3 != null && obj == null && b == null) {
                    return false;
                }
                arrayList = new ArrayList();
                a = C0132e.m1256a(b, fragment2, arrayList, (C0223a) map, c0137j.f986d);
                if (!(this.f958v == null || map == null)) {
                    view2 = (View) map.get(this.f958v.get(0));
                    if (view2 != null) {
                        if (a != null) {
                            ao.m1070a(a, view2);
                        }
                        if (obj != null) {
                            ao.m1070a(obj, view2);
                        }
                    }
                }
                c0133f = new C0133f(this, fragment);
                arrayList2 = new ArrayList();
                c0223a = new C0223a();
                z2 = true;
                if (fragment != null) {
                    z2 = z ? fragment.m1015z() : fragment.m1014y();
                }
                a2 = ao.m1065a(a3, a, obj, z2);
                if (a2 != null) {
                    ao.m1073a(a3, obj, view, c0133f, c0137j.f986d, c0137j.f985c, c0137j.f983a, arrayList2, map, c0223a, arrayList3);
                    m1269a(view, c0137j, i, a2);
                    ao.m1072a(a2, c0137j.f986d, true);
                    m1261a(c0137j, i, a2);
                    ao.m1069a((ViewGroup) view, a2);
                    ao.m1068a(view, c0137j.f986d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0137j.f984b, c0223a);
                }
                return a2 == null;
            } else {
                cz czVar = z ? fragment2.f751Y : fragment.f751Y;
                if (czVar != null) {
                    czVar.m1238a(new ArrayList(map.keySet()), new ArrayList(map.values()), null);
                }
                m1264a(c0137j, view, a4, fragment, fragment2, z, arrayList3);
            }
        }
        obj = a4;
        if (a3 != null) {
        }
        arrayList = new ArrayList();
        a = C0132e.m1256a(b, fragment2, arrayList, (C0223a) map, c0137j.f986d);
        view2 = (View) map.get(this.f958v.get(0));
        if (view2 != null) {
            if (a != null) {
                ao.m1070a(a, view2);
            }
            if (obj != null) {
                ao.m1070a(obj, view2);
            }
        }
        c0133f = new C0133f(this, fragment);
        arrayList2 = new ArrayList();
        c0223a = new C0223a();
        z2 = true;
        if (fragment != null) {
            if (z) {
            }
        }
        a2 = ao.m1065a(a3, a, obj, z2);
        if (a2 != null) {
            ao.m1073a(a3, obj, view, c0133f, c0137j.f986d, c0137j.f985c, c0137j.f983a, arrayList2, map, c0223a, arrayList3);
            m1269a(view, c0137j, i, a2);
            ao.m1072a(a2, c0137j.f986d, true);
            m1261a(c0137j, i, a2);
            ao.m1069a((ViewGroup) view, a2);
            ao.m1068a(view, c0137j.f986d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0137j.f984b, c0223a);
        }
        if (a2 == null) {
        }
    }

    private C0223a<String, View> m1271b(C0137j c0137j, Fragment fragment, boolean z) {
        C0223a c0223a = new C0223a();
        View i = fragment.m996i();
        if (i == null || this.f957u == null) {
            return c0223a;
        }
        ao.m1077a((Map) c0223a, i);
        if (z) {
            return C0132e.m1253a(this.f957u, this.f958v, c0223a);
        }
        c0223a.m1671a(this.f958v);
        return c0223a;
    }

    private static Object m1272b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return ao.m1063a(z ? fragment.m1009t() : fragment.m1010u());
    }

    private void m1273b(C0137j c0137j, C0223a<String, View> c0223a, boolean z) {
        int size = c0223a.size();
        for (int i = 0; i < size; i++) {
            String str = (String) c0223a.m1667b(i);
            String a = ao.m1066a((View) c0223a.m1668c(i));
            if (z) {
                C0132e.m1267a(c0137j.f983a, str, a);
            } else {
                C0132e.m1267a(c0137j.f983a, a, str);
            }
        }
    }

    private void m1274b(SparseArray<Fragment> sparseArray, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f776y;
            if (i != 0) {
                sparseArray.put(i, fragment);
            }
        }
    }

    private void m1275b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f938b.f1033p.m1297a()) {
            for (C0136i c0136i = this.f939c; c0136i != null; c0136i = c0136i.f974a) {
                switch (c0136i.f976c) {
                    case VideoSize.CIF /*1*/:
                        m1274b((SparseArray) sparseArray2, c0136i.f977d);
                        break;
                    case VideoSize.HVGA /*2*/:
                        Fragment fragment;
                        Fragment fragment2 = c0136i.f977d;
                        if (this.f938b.f1024g != null) {
                            fragment = fragment2;
                            for (int i = 0; i < this.f938b.f1024g.size(); i++) {
                                Fragment fragment3 = (Fragment) this.f938b.f1024g.get(i);
                                if (fragment == null || fragment3.f776y == fragment.f776y) {
                                    if (fragment3 == fragment) {
                                        fragment = null;
                                    } else {
                                        C0132e.m1268a((SparseArray) sparseArray, fragment3);
                                    }
                                }
                            }
                        } else {
                            fragment = fragment2;
                        }
                        m1274b((SparseArray) sparseArray2, fragment);
                        break;
                    case Version.API03_CUPCAKE_15 /*3*/:
                        C0132e.m1268a((SparseArray) sparseArray, c0136i.f977d);
                        break;
                    case Version.API04_DONUT_16 /*4*/:
                        C0132e.m1268a((SparseArray) sparseArray, c0136i.f977d);
                        break;
                    case Version.API05_ECLAIR_20 /*5*/:
                        m1274b((SparseArray) sparseArray2, c0136i.f977d);
                        break;
                    case Version.API06_ECLAIR_201 /*6*/:
                        C0132e.m1268a((SparseArray) sparseArray, c0136i.f977d);
                        break;
                    case Version.API07_ECLAIR_21 /*7*/:
                        m1274b((SparseArray) sparseArray2, c0136i.f977d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public int m1276a() {
        return m1277a(false);
    }

    int m1277a(boolean z) {
        if (this.f951o) {
            throw new IllegalStateException("commit already called");
        }
        if (C0153z.f1017a) {
            Log.v("FragmentManager", "Commit: " + this);
            m1286a("  ", null, new PrintWriter(new C0228e("FragmentManager")), null);
        }
        this.f951o = true;
        if (this.f948l) {
            this.f952p = this.f938b.m1399a(this);
        } else {
            this.f952p = -1;
        }
        this.f938b.m1417a((Runnable) this, z);
        return this.f952p;
    }

    public an m1278a(int i, Fragment fragment) {
        m1257a(i, fragment, null, 1);
        return this;
    }

    public an m1279a(int i, Fragment fragment, String str) {
        m1257a(i, fragment, str, 1);
        return this;
    }

    public an m1280a(Fragment fragment) {
        C0136i c0136i = new C0136i();
        c0136i.f976c = 3;
        c0136i.f977d = fragment;
        m1284a(c0136i);
        return this;
    }

    public an m1281a(Fragment fragment, String str) {
        m1257a(0, fragment, str, 1);
        return this;
    }

    public C0137j m1282a(boolean z, C0137j c0137j, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (C0153z.f1017a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m1286a("  ", null, new PrintWriter(new C0228e("FragmentManager")), null);
        }
        if (f937a) {
            if (c0137j == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    c0137j = m1249a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                C0132e.m1265a(c0137j, this.f958v, this.f957u);
            }
        }
        m1283a(-1);
        int i = c0137j != null ? 0 : this.f947k;
        int i2 = c0137j != null ? 0 : this.f946j;
        C0136i c0136i = this.f940d;
        while (c0136i != null) {
            int i3 = c0137j != null ? 0 : c0136i.f980g;
            int i4 = c0137j != null ? 0 : c0136i.f981h;
            Fragment fragment;
            Fragment fragment2;
            switch (c0136i.f976c) {
                case VideoSize.CIF /*1*/:
                    fragment = c0136i.f977d;
                    fragment.f734H = i4;
                    this.f938b.m1413a(fragment, C0153z.m1397c(i2), i);
                    break;
                case VideoSize.HVGA /*2*/:
                    fragment = c0136i.f977d;
                    if (fragment != null) {
                        fragment.f734H = i4;
                        this.f938b.m1413a(fragment, C0153z.m1397c(i2), i);
                    }
                    if (c0136i.f982i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < c0136i.f982i.size(); i5++) {
                        fragment2 = (Fragment) c0136i.f982i.get(i5);
                        fragment2.f734H = i3;
                        this.f938b.m1415a(fragment2, false);
                    }
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    fragment2 = c0136i.f977d;
                    fragment2.f734H = i3;
                    this.f938b.m1415a(fragment2, false);
                    break;
                case Version.API04_DONUT_16 /*4*/:
                    fragment2 = c0136i.f977d;
                    fragment2.f734H = i3;
                    this.f938b.m1431c(fragment2, C0153z.m1397c(i2), i);
                    break;
                case Version.API05_ECLAIR_20 /*5*/:
                    fragment = c0136i.f977d;
                    fragment.f734H = i4;
                    this.f938b.m1425b(fragment, C0153z.m1397c(i2), i);
                    break;
                case Version.API06_ECLAIR_201 /*6*/:
                    fragment2 = c0136i.f977d;
                    fragment2.f734H = i3;
                    this.f938b.m1437e(fragment2, C0153z.m1397c(i2), i);
                    break;
                case Version.API07_ECLAIR_21 /*7*/:
                    fragment2 = c0136i.f977d;
                    fragment2.f734H = i3;
                    this.f938b.m1435d(fragment2, C0153z.m1397c(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0136i.f976c);
            }
            c0136i = c0136i.f975b;
        }
        if (z) {
            this.f938b.m1407a(this.f938b.f1031n, C0153z.m1397c(i2), i, true);
            c0137j = null;
        }
        if (this.f952p >= 0) {
            this.f938b.m1423b(this.f952p);
            this.f952p = -1;
        }
        return c0137j;
    }

    void m1283a(int i) {
        if (this.f948l) {
            if (C0153z.f1017a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0136i c0136i = this.f939c; c0136i != null; c0136i = c0136i.f974a) {
                Fragment fragment;
                if (c0136i.f977d != null) {
                    fragment = c0136i.f977d;
                    fragment.f770s += i;
                    if (C0153z.f1017a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0136i.f977d + " to " + c0136i.f977d.f770s);
                    }
                }
                if (c0136i.f982i != null) {
                    for (int size = c0136i.f982i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) c0136i.f982i.get(size);
                        fragment.f770s += i;
                        if (C0153z.f1017a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f770s);
                        }
                    }
                }
            }
        }
    }

    void m1284a(C0136i c0136i) {
        if (this.f939c == null) {
            this.f940d = c0136i;
            this.f939c = c0136i;
        } else {
            c0136i.f975b = this.f940d;
            this.f940d.f974a = c0136i;
            this.f940d = c0136i;
        }
        c0136i.f978e = this.f942f;
        c0136i.f979f = this.f943g;
        c0136i.f980g = this.f944h;
        c0136i.f981h = this.f945i;
        this.f941e++;
    }

    public void m1285a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f938b.f1033p.m1297a()) {
            for (C0136i c0136i = this.f939c; c0136i != null; c0136i = c0136i.f974a) {
                switch (c0136i.f976c) {
                    case VideoSize.CIF /*1*/:
                        C0132e.m1268a((SparseArray) sparseArray, c0136i.f977d);
                        break;
                    case VideoSize.HVGA /*2*/:
                        if (c0136i.f982i != null) {
                            for (int size = c0136i.f982i.size() - 1; size >= 0; size--) {
                                m1274b((SparseArray) sparseArray2, (Fragment) c0136i.f982i.get(size));
                            }
                        }
                        C0132e.m1268a((SparseArray) sparseArray, c0136i.f977d);
                        break;
                    case Version.API03_CUPCAKE_15 /*3*/:
                        m1274b((SparseArray) sparseArray2, c0136i.f977d);
                        break;
                    case Version.API04_DONUT_16 /*4*/:
                        m1274b((SparseArray) sparseArray2, c0136i.f977d);
                        break;
                    case Version.API05_ECLAIR_20 /*5*/:
                        C0132e.m1268a((SparseArray) sparseArray, c0136i.f977d);
                        break;
                    case Version.API06_ECLAIR_201 /*6*/:
                        m1274b((SparseArray) sparseArray2, c0136i.f977d);
                        break;
                    case Version.API07_ECLAIR_21 /*7*/:
                        C0132e.m1268a((SparseArray) sparseArray, c0136i.f977d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void m1286a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m1287a(str, printWriter, true);
    }

    public void m1287a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f950n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f952p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f951o);
            if (this.f946j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f946j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f947k));
            }
            if (!(this.f942f == 0 && this.f943g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f942f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f943g));
            }
            if (!(this.f944h == 0 && this.f945i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f944h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f945i));
            }
            if (!(this.f953q == 0 && this.f954r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f953q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f954r);
            }
            if (!(this.f955s == 0 && this.f956t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f955s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f956t);
            }
        }
        if (this.f939c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            C0136i c0136i = this.f939c;
            while (c0136i != null) {
                String str3;
                switch (c0136i.f976c) {
                    case VideoSize.QCIF /*0*/:
                        str3 = "NULL";
                        break;
                    case VideoSize.CIF /*1*/:
                        str3 = "ADD";
                        break;
                    case VideoSize.HVGA /*2*/:
                        str3 = "REPLACE";
                        break;
                    case Version.API03_CUPCAKE_15 /*3*/:
                        str3 = "REMOVE";
                        break;
                    case Version.API04_DONUT_16 /*4*/:
                        str3 = "HIDE";
                        break;
                    case Version.API05_ECLAIR_20 /*5*/:
                        str3 = "SHOW";
                        break;
                    case Version.API06_ECLAIR_201 /*6*/:
                        str3 = "DETACH";
                        break;
                    case Version.API07_ECLAIR_21 /*7*/:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + c0136i.f976c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(c0136i.f977d);
                if (z) {
                    if (!(c0136i.f978e == 0 && c0136i.f979f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0136i.f978e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0136i.f979f));
                    }
                    if (!(c0136i.f980g == 0 && c0136i.f981h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0136i.f980g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0136i.f981h));
                    }
                }
                if (c0136i.f982i != null && c0136i.f982i.size() > 0) {
                    for (int i2 = 0; i2 < c0136i.f982i.size(); i2++) {
                        printWriter.print(str2);
                        if (c0136i.f982i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0136i.f982i.get(i2));
                    }
                }
                c0136i = c0136i.f974a;
                i++;
            }
        }
    }

    public int m1288b() {
        return m1277a(true);
    }

    public an m1289b(Fragment fragment) {
        C0136i c0136i = new C0136i();
        c0136i.f976c = 6;
        c0136i.f977d = fragment;
        m1284a(c0136i);
        return this;
    }

    public an m1290c(Fragment fragment) {
        C0136i c0136i = new C0136i();
        c0136i.f976c = 7;
        c0136i.f977d = fragment;
        m1284a(c0136i);
        return this;
    }

    public String m1291c() {
        return this.f950n;
    }

    public void run() {
        if (C0153z.f1017a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f948l || this.f952p >= 0) {
            C0137j a;
            m1283a(1);
            if (f937a) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m1275b(sparseArray, sparseArray2);
                a = m1249a(sparseArray, sparseArray2, false);
            } else {
                a = null;
            }
            int i = a != null ? 0 : this.f947k;
            int i2 = a != null ? 0 : this.f946j;
            C0136i c0136i = this.f939c;
            while (c0136i != null) {
                int i3 = a != null ? 0 : c0136i.f978e;
                int i4 = a != null ? 0 : c0136i.f979f;
                Fragment fragment;
                switch (c0136i.f976c) {
                    case VideoSize.CIF /*1*/:
                        fragment = c0136i.f977d;
                        fragment.f734H = i3;
                        this.f938b.m1415a(fragment, false);
                        break;
                    case VideoSize.HVGA /*2*/:
                        Fragment fragment2;
                        Fragment fragment3 = c0136i.f977d;
                        int i5 = fragment3.f776y;
                        if (this.f938b.f1024g != null) {
                            fragment2 = fragment3;
                            for (int i6 = 0; i6 < this.f938b.f1024g.size(); i6++) {
                                fragment = (Fragment) this.f938b.f1024g.get(i6);
                                if (C0153z.f1017a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment.f776y == i5) {
                                    if (fragment == fragment2) {
                                        fragment2 = null;
                                        c0136i.f977d = null;
                                    } else {
                                        if (c0136i.f982i == null) {
                                            c0136i.f982i = new ArrayList();
                                        }
                                        c0136i.f982i.add(fragment);
                                        fragment.f734H = i4;
                                        if (this.f948l) {
                                            fragment.f770s++;
                                            if (C0153z.f1017a) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f770s);
                                            }
                                        }
                                        this.f938b.m1413a(fragment, i2, i);
                                    }
                                }
                            }
                        } else {
                            fragment2 = fragment3;
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.f734H = i3;
                        this.f938b.m1415a(fragment2, false);
                        break;
                    case Version.API03_CUPCAKE_15 /*3*/:
                        fragment = c0136i.f977d;
                        fragment.f734H = i4;
                        this.f938b.m1413a(fragment, i2, i);
                        break;
                    case Version.API04_DONUT_16 /*4*/:
                        fragment = c0136i.f977d;
                        fragment.f734H = i4;
                        this.f938b.m1425b(fragment, i2, i);
                        break;
                    case Version.API05_ECLAIR_20 /*5*/:
                        fragment = c0136i.f977d;
                        fragment.f734H = i3;
                        this.f938b.m1431c(fragment, i2, i);
                        break;
                    case Version.API06_ECLAIR_201 /*6*/:
                        fragment = c0136i.f977d;
                        fragment.f734H = i4;
                        this.f938b.m1435d(fragment, i2, i);
                        break;
                    case Version.API07_ECLAIR_21 /*7*/:
                        fragment = c0136i.f977d;
                        fragment.f734H = i3;
                        this.f938b.m1437e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0136i.f976c);
                }
                c0136i = c0136i.f974a;
            }
            this.f938b.m1407a(this.f938b.f1031n, i2, i, true);
            if (this.f948l) {
                this.f938b.m1426b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f952p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f952p);
        }
        if (this.f950n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f950n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
