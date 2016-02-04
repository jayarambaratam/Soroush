package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.p016f.C0227d;
import android.support.v4.p016f.C0228e;
import android.support.v4.view.ar;
import android.support.v4.view.cb;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: android.support.v4.app.z */
final class C0153z extends C0151x implements ar {
    static final Interpolator f1013A;
    static final Interpolator f1014B;
    static final Interpolator f1015C;
    static final Interpolator f1016D;
    static boolean f1017a;
    static final boolean f1018b;
    static Field f1019r;
    ArrayList<Runnable> f1020c;
    Runnable[] f1021d;
    boolean f1022e;
    ArrayList<Fragment> f1023f;
    ArrayList<Fragment> f1024g;
    ArrayList<Integer> f1025h;
    ArrayList<C0132e> f1026i;
    ArrayList<Fragment> f1027j;
    ArrayList<C0132e> f1028k;
    ArrayList<Integer> f1029l;
    ArrayList<C0152y> f1030m;
    int f1031n;
    C0147w f1032o;
    C0141u f1033p;
    Fragment f1034q;
    boolean f1035s;
    boolean f1036t;
    boolean f1037u;
    String f1038v;
    boolean f1039w;
    Bundle f1040x;
    SparseArray<Parcelable> f1041y;
    Runnable f1042z;

    static {
        boolean z = false;
        f1017a = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f1018b = z;
        f1019r = null;
        f1013A = new DecelerateInterpolator(2.5f);
        f1014B = new DecelerateInterpolator(1.5f);
        f1015C = new AccelerateInterpolator(2.5f);
        f1016D = new AccelerateInterpolator(1.5f);
    }

    C0153z() {
        this.f1031n = 0;
        this.f1040x = null;
        this.f1041y = null;
        this.f1042z = new aa(this);
    }

    static Animation m1390a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f1014B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    static Animation m1391a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f1013A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f1014B);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private void m1392a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0228e("FragmentManager"));
        if (this.f1032o != null) {
            try {
                this.f1032o.m1317a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                m1418a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    static boolean m1393a(View view, Animation animation) {
        return VERSION.SDK_INT >= 19 && cb.m2426g(view) == 0 && cb.m2449z(view) && C0153z.m1394a(animation);
    }

    static boolean m1394a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    public static int m1395b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    private void m1396b(View view, Animation animation) {
        if (view != null && animation != null && C0153z.m1393a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (f1019r == null) {
                    f1019r = Animation.class.getDeclaredField("mListener");
                    f1019r.setAccessible(true);
                }
                animationListener = (AnimationListener) f1019r.get(animation);
            } catch (Throwable e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            animation.setAnimationListener(new ac(view, animation, animationListener));
        }
    }

    public static int m1397c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void m1398u() {
        if (this.f1036t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f1038v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f1038v);
        }
    }

    public int m1399a(C0132e c0132e) {
        int size;
        synchronized (this) {
            if (this.f1029l == null || this.f1029l.size() <= 0) {
                if (this.f1028k == null) {
                    this.f1028k = new ArrayList();
                }
                size = this.f1028k.size();
                if (f1017a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0132e);
                }
                this.f1028k.add(c0132e);
            } else {
                size = ((Integer) this.f1029l.remove(this.f1029l.size() - 1)).intValue();
                if (f1017a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0132e);
                }
                this.f1028k.set(size, c0132e);
            }
        }
        return size;
    }

    public SavedState m1400a(Fragment fragment) {
        if (fragment.f758g < 0) {
            m1392a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.f753b <= 0) {
            return null;
        }
        Bundle g = m1441g(fragment);
        return g != null ? new SavedState(g) : null;
    }

    public Fragment m1401a(int i) {
        int size;
        Fragment fragment;
        if (this.f1024g != null) {
            for (size = this.f1024g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f1024g.get(size);
                if (fragment != null && fragment.f775x == i) {
                    return fragment;
                }
            }
        }
        if (this.f1023f != null) {
            for (size = this.f1023f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f1023f.get(size);
                if (fragment != null && fragment.f775x == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment m1402a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f1023f.size()) {
            m1392a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f1023f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m1392a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public Fragment m1403a(String str) {
        int size;
        Fragment fragment;
        if (!(this.f1024g == null || str == null)) {
            for (size = this.f1024g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f1024g.get(size);
                if (fragment != null && str.equals(fragment.f777z)) {
                    return fragment;
                }
            }
        }
        if (!(this.f1023f == null || str == null)) {
            for (size = this.f1023f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f1023f.get(size);
                if (fragment != null && str.equals(fragment.f777z)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public an m1404a() {
        return new C0132e(this);
    }

    public View m1405a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, af.f808a);
        String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.m943b(this.f1032o.m1328g(), string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment a = resourceId != -1 ? m1401a(resourceId) : null;
        if (a == null && string2 != null) {
            a = m1403a(string2);
        }
        if (a == null && id != -1) {
            a = m1401a(id);
        }
        if (f1017a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a);
        }
        if (a == null) {
            Fragment a2 = Fragment.m941a(context, string);
            a2.f767p = true;
            a2.f775x = resourceId != 0 ? resourceId : id;
            a2.f776y = id;
            a2.f777z = string2;
            a2.f768q = true;
            a2.f771t = this;
            a2.f772u = this.f1032o;
            a2.m961a(this.f1032o.m1328g(), attributeSet, a2.f756e);
            m1415a(a2, true);
            fragment = a2;
        } else if (a.f768q) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            a.f768q = true;
            if (!a.f730D) {
                a.m961a(this.f1032o.m1328g(), attributeSet, a.f756e);
            }
            fragment = a;
        }
        if (this.f1031n >= 1 || !fragment.f767p) {
            m1430c(fragment);
        } else {
            m1414a(fragment, 1, 0, 0, false);
        }
        if (fragment.f736J == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.f736J.setId(resourceId);
        }
        if (fragment.f736J.getTag() == null) {
            fragment.f736J.setTag(string2);
        }
        return fragment.f736J;
    }

    Animation m1406a(Fragment fragment, int i, boolean z, int i2) {
        Animation a = fragment.m954a(i, z, fragment.f734H);
        if (a != null) {
            return a;
        }
        if (fragment.f734H != 0) {
            a = AnimationUtils.loadAnimation(this.f1032o.m1328g(), fragment.f734H);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = C0153z.m1395b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case VideoSize.CIF /*1*/:
                return C0153z.m1391a(this.f1032o.m1328g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case VideoSize.HVGA /*2*/:
                return C0153z.m1391a(this.f1032o.m1328g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case Version.API03_CUPCAKE_15 /*3*/:
                return C0153z.m1391a(this.f1032o.m1328g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case Version.API04_DONUT_16 /*4*/:
                return C0153z.m1391a(this.f1032o.m1328g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case Version.API05_ECLAIR_20 /*5*/:
                return C0153z.m1390a(this.f1032o.m1328g(), 0.0f, 1.0f);
            case Version.API06_ECLAIR_201 /*6*/:
                return C0153z.m1390a(this.f1032o.m1328g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f1032o.m1325d()) {
                    i2 = this.f1032o.m1326e();
                }
                return i2 == 0 ? null : null;
        }
    }

    void m1407a(int i, int i2, int i3, boolean z) {
        if (this.f1032o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.f1031n != i) {
            this.f1031n = i;
            if (this.f1023f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f1023f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f1023f.get(i4);
                    if (fragment != null) {
                        m1414a(fragment, i, i2, i3, false);
                        if (fragment.f740N != null) {
                            a = i5 | fragment.f740N.m1099a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m1433d();
                }
                if (this.f1035s && this.f1032o != null && this.f1031n == 5) {
                    this.f1032o.m1324c();
                    this.f1035s = false;
                }
            }
        }
    }

    public void m1408a(int i, C0132e c0132e) {
        synchronized (this) {
            if (this.f1028k == null) {
                this.f1028k = new ArrayList();
            }
            int size = this.f1028k.size();
            if (i < size) {
                if (f1017a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0132e);
                }
                this.f1028k.set(i, c0132e);
            } else {
                while (size < i) {
                    this.f1028k.add(null);
                    if (this.f1029l == null) {
                        this.f1029l = new ArrayList();
                    }
                    if (f1017a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f1029l.add(Integer.valueOf(size));
                    size++;
                }
                if (f1017a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0132e);
                }
                this.f1028k.add(c0132e);
            }
        }
    }

    void m1409a(int i, boolean z) {
        m1407a(i, 0, 0, z);
    }

    public void m1410a(Configuration configuration) {
        if (this.f1024g != null) {
            for (int i = 0; i < this.f1024g.size(); i++) {
                Fragment fragment = (Fragment) this.f1024g.get(i);
                if (fragment != null) {
                    fragment.m962a(configuration);
                }
            }
        }
    }

    public void m1411a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f758g < 0) {
            m1392a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.f758g);
    }

    void m1412a(Parcelable parcelable, List<Fragment> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f778a != null) {
                int i;
                Fragment fragment;
                int i2;
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        fragment = (Fragment) list.get(i);
                        if (f1017a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f778a[fragment.f758g];
                        fragmentState.f791k = fragment;
                        fragment.f757f = null;
                        fragment.f770s = 0;
                        fragment.f768q = false;
                        fragment.f764m = false;
                        fragment.f761j = null;
                        if (fragmentState.f790j != null) {
                            fragmentState.f790j.setClassLoader(this.f1032o.m1328g().getClassLoader());
                            fragment.f757f = fragmentState.f790j.getSparseParcelableArray("android:view_state");
                            fragment.f756e = fragmentState.f790j;
                        }
                    }
                }
                this.f1023f = new ArrayList(fragmentManagerState.f778a.length);
                if (this.f1025h != null) {
                    this.f1025h.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.f778a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.f778a[i2];
                    if (fragmentState2 != null) {
                        Fragment a = fragmentState2.m1016a(this.f1032o, this.f1034q);
                        if (f1017a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.f1023f.add(a);
                        fragmentState2.f791k = null;
                    } else {
                        this.f1023f.add(null);
                        if (this.f1025h == null) {
                            this.f1025h = new ArrayList();
                        }
                        if (f1017a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f1025h.add(Integer.valueOf(i2));
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        fragment = (Fragment) list.get(i3);
                        if (fragment.f762k >= 0) {
                            if (fragment.f762k < this.f1023f.size()) {
                                fragment.f761j = (Fragment) this.f1023f.get(fragment.f762k);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.f762k);
                                fragment.f761j = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f779b != null) {
                    this.f1024g = new ArrayList(fragmentManagerState.f779b.length);
                    for (i = 0; i < fragmentManagerState.f779b.length; i++) {
                        fragment = (Fragment) this.f1023f.get(fragmentManagerState.f779b[i]);
                        if (fragment == null) {
                            m1392a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f779b[i]));
                        }
                        fragment.f764m = true;
                        if (f1017a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment);
                        }
                        if (this.f1024g.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f1024g.add(fragment);
                    }
                } else {
                    this.f1024g = null;
                }
                if (fragmentManagerState.f780c != null) {
                    this.f1026i = new ArrayList(fragmentManagerState.f780c.length);
                    for (i2 = 0; i2 < fragmentManagerState.f780c.length; i2++) {
                        C0132e a2 = fragmentManagerState.f780c[i2].m940a(this);
                        if (f1017a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.f952p + "): " + a2);
                            a2.m1287a("  ", new PrintWriter(new C0228e("FragmentManager")), false);
                        }
                        this.f1026i.add(a2);
                        if (a2.f952p >= 0) {
                            m1408a(a2.f952p, a2);
                        }
                    }
                    return;
                }
                this.f1026i = null;
            }
        }
    }

    public void m1413a(Fragment fragment, int i, int i2) {
        if (f1017a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f770s);
        }
        boolean z = !fragment.m970a();
        if (!fragment.f728B || z) {
            if (this.f1024g != null) {
                this.f1024g.remove(fragment);
            }
            if (fragment.f731E && fragment.f732F) {
                this.f1035s = true;
            }
            fragment.f764m = false;
            fragment.f765n = true;
            m1414a(fragment, z ? 0 : 1, i, i2, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1414a(android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r3 = 0;
        r7 = 0;
        r0 = r11.f764m;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.f728B;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.f765n;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.f753b;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.f753b;
    L_0x001a:
        r0 = r11.f738L;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.f753b;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.f753b;
        if (r0 >= r12) goto L_0x0274;
    L_0x0029:
        r0 = r11.f767p;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.f768q;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.f754c;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.f754c = r7;
        r2 = r11.f755d;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m1414a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.f753b;
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x013e;
            case 2: goto L_0x020f;
            case 3: goto L_0x020f;
            case 4: goto L_0x0230;
            default: goto L_0x0045;
        };
    L_0x0045:
        r11.f753b = r12;
        goto L_0x0031;
    L_0x0048:
        r0 = f1017a;
        if (r0 == 0) goto L_0x0064;
    L_0x004c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0064:
        r0 = r11.f756e;
        if (r0 == 0) goto L_0x00ac;
    L_0x0068:
        r0 = r11.f756e;
        r1 = r10.f1032o;
        r1 = r1.m1328g();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.f756e;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.f757f = r0;
        r0 = r11.f756e;
        r1 = "android:target_state";
        r0 = r10.m1402a(r0, r1);
        r11.f761j = r0;
        r0 = r11.f761j;
        if (r0 == 0) goto L_0x0099;
    L_0x008f:
        r0 = r11.f756e;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.f763l = r0;
    L_0x0099:
        r0 = r11.f756e;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.f739M = r0;
        r0 = r11.f739M;
        if (r0 != 0) goto L_0x00ac;
    L_0x00a7:
        r11.f738L = r5;
        if (r12 <= r6) goto L_0x00ac;
    L_0x00ab:
        r12 = r6;
    L_0x00ac:
        r0 = r10.f1032o;
        r11.f772u = r0;
        r0 = r10.f1034q;
        r11.f774w = r0;
        r0 = r10.f1034q;
        if (r0 == 0) goto L_0x00ec;
    L_0x00b8:
        r0 = r10.f1034q;
        r0 = r0.f773v;
    L_0x00bc:
        r11.f771t = r0;
        r11.f733G = r3;
        r0 = r10.f1032o;
        r0 = r0.m1328g();
        r11.m960a(r0);
        r0 = r11.f733G;
        if (r0 != 0) goto L_0x00f3;
    L_0x00cd:
        r0 = new android.support.v4.app.da;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00ec:
        r0 = r10.f1032o;
        r0 = r0.m1330i();
        goto L_0x00bc;
    L_0x00f3:
        r0 = r11.f774w;
        if (r0 != 0) goto L_0x00fc;
    L_0x00f7:
        r0 = r10.f1032o;
        r0.m1322b(r11);
    L_0x00fc:
        r0 = r11.f730D;
        if (r0 != 0) goto L_0x0105;
    L_0x0100:
        r0 = r11.f756e;
        r11.m994h(r0);
    L_0x0105:
        r11.f730D = r3;
        r0 = r11.f767p;
        if (r0 == 0) goto L_0x013e;
    L_0x010b:
        r0 = r11.f756e;
        r0 = r11.m980c(r0);
        r1 = r11.f756e;
        r0 = r11.m973b(r0, r7, r1);
        r11.f736J = r0;
        r0 = r11.f736J;
        if (r0 == 0) goto L_0x0263;
    L_0x011d:
        r0 = r11.f736J;
        r11.f737K = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x0259;
    L_0x0127:
        r0 = r11.f736J;
        android.support.v4.view.cb.m2410b(r0, r3);
    L_0x012c:
        r0 = r11.f727A;
        if (r0 == 0) goto L_0x0137;
    L_0x0130:
        r0 = r11.f736J;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0137:
        r0 = r11.f736J;
        r1 = r11.f756e;
        r11.m967a(r0, r1);
    L_0x013e:
        if (r12 <= r5) goto L_0x020f;
    L_0x0140:
        r0 = f1017a;
        if (r0 == 0) goto L_0x015c;
    L_0x0144:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x015c:
        r0 = r11.f767p;
        if (r0 != 0) goto L_0x01ff;
    L_0x0160:
        r0 = r11.f776y;
        if (r0 == 0) goto L_0x03d1;
    L_0x0164:
        r0 = r10.f1033p;
        r1 = r11.f776y;
        r0 = r0.m1296a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01b3;
    L_0x0170:
        r1 = r11.f769r;
        if (r1 != 0) goto L_0x01b3;
    L_0x0174:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "No view found for id 0x";
        r2 = r2.append(r4);
        r4 = r11.f776y;
        r4 = java.lang.Integer.toHexString(r4);
        r2 = r2.append(r4);
        r4 = " (";
        r2 = r2.append(r4);
        r4 = r11.m984d();
        r8 = r11.f776y;
        r4 = r4.getResourceName(r8);
        r2 = r2.append(r4);
        r4 = ") for fragment ";
        r2 = r2.append(r4);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r1.<init>(r2);
        r10.m1392a(r1);
    L_0x01b3:
        r11.f735I = r0;
        r1 = r11.f756e;
        r1 = r11.m980c(r1);
        r2 = r11.f756e;
        r1 = r11.m973b(r1, r0, r2);
        r11.f736J = r1;
        r1 = r11.f736J;
        if (r1 == 0) goto L_0x0271;
    L_0x01c7:
        r1 = r11.f736J;
        r11.f737K = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x0267;
    L_0x01d1:
        r1 = r11.f736J;
        android.support.v4.view.cb.m2410b(r1, r3);
    L_0x01d6:
        if (r0 == 0) goto L_0x01ed;
    L_0x01d8:
        r1 = r10.m1406a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x01e8;
    L_0x01de:
        r2 = r11.f736J;
        r10.m1396b(r2, r1);
        r2 = r11.f736J;
        r2.startAnimation(r1);
    L_0x01e8:
        r1 = r11.f736J;
        r0.addView(r1);
    L_0x01ed:
        r0 = r11.f727A;
        if (r0 == 0) goto L_0x01f8;
    L_0x01f1:
        r0 = r11.f736J;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x01f8:
        r0 = r11.f736J;
        r1 = r11.f756e;
        r11.m967a(r0, r1);
    L_0x01ff:
        r0 = r11.f756e;
        r11.m997i(r0);
        r0 = r11.f736J;
        if (r0 == 0) goto L_0x020d;
    L_0x0208:
        r0 = r11.f756e;
        r11.m963a(r0);
    L_0x020d:
        r11.f756e = r7;
    L_0x020f:
        if (r12 <= r6) goto L_0x0230;
    L_0x0211:
        r0 = f1017a;
        if (r0 == 0) goto L_0x022d;
    L_0x0215:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x022d:
        r11.m945B();
    L_0x0230:
        if (r12 <= r9) goto L_0x0045;
    L_0x0232:
        r0 = f1017a;
        if (r0 == 0) goto L_0x024e;
    L_0x0236:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x024e:
        r11.f766o = r5;
        r11.m946C();
        r11.f756e = r7;
        r11.f757f = r7;
        goto L_0x0045;
    L_0x0259:
        r0 = r11.f736J;
        r0 = android.support.v4.app.be.m1143a(r0);
        r11.f736J = r0;
        goto L_0x012c;
    L_0x0263:
        r11.f737K = r7;
        goto L_0x013e;
    L_0x0267:
        r1 = r11.f736J;
        r1 = android.support.v4.app.be.m1143a(r1);
        r11.f736J = r1;
        goto L_0x01d6;
    L_0x0271:
        r11.f737K = r7;
        goto L_0x01ff;
    L_0x0274:
        r0 = r11.f753b;
        if (r0 <= r12) goto L_0x0045;
    L_0x0278:
        r0 = r11.f753b;
        switch(r0) {
            case 1: goto L_0x027f;
            case 2: goto L_0x02ff;
            case 3: goto L_0x02de;
            case 4: goto L_0x02bd;
            case 5: goto L_0x0299;
            default: goto L_0x027d;
        };
    L_0x027d:
        goto L_0x0045;
    L_0x027f:
        if (r12 >= r5) goto L_0x0045;
    L_0x0281:
        r0 = r10.f1037u;
        if (r0 == 0) goto L_0x0290;
    L_0x0285:
        r0 = r11.f754c;
        if (r0 == 0) goto L_0x0290;
    L_0x0289:
        r0 = r11.f754c;
        r11.f754c = r7;
        r0.clearAnimation();
    L_0x0290:
        r0 = r11.f754c;
        if (r0 == 0) goto L_0x036e;
    L_0x0294:
        r11.f755d = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x0299:
        r0 = 5;
        if (r12 >= r0) goto L_0x02bd;
    L_0x029c:
        r0 = f1017a;
        if (r0 == 0) goto L_0x02b8;
    L_0x02a0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02b8:
        r11.m948E();
        r11.f766o = r3;
    L_0x02bd:
        if (r12 >= r9) goto L_0x02de;
    L_0x02bf:
        r0 = f1017a;
        if (r0 == 0) goto L_0x02db;
    L_0x02c3:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02db:
        r11.m949F();
    L_0x02de:
        if (r12 >= r6) goto L_0x02ff;
    L_0x02e0:
        r0 = f1017a;
        if (r0 == 0) goto L_0x02fc;
    L_0x02e4:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02fc:
        r11.m950G();
    L_0x02ff:
        r0 = 2;
        if (r12 >= r0) goto L_0x027f;
    L_0x0302:
        r0 = f1017a;
        if (r0 == 0) goto L_0x031e;
    L_0x0306:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x031e:
        r0 = r11.f736J;
        if (r0 == 0) goto L_0x0331;
    L_0x0322:
        r0 = r10.f1032o;
        r0 = r0.m1320a(r11);
        if (r0 == 0) goto L_0x0331;
    L_0x032a:
        r0 = r11.f757f;
        if (r0 != 0) goto L_0x0331;
    L_0x032e:
        r10.m1440f(r11);
    L_0x0331:
        r11.m951H();
        r0 = r11.f736J;
        if (r0 == 0) goto L_0x0366;
    L_0x0338:
        r0 = r11.f735I;
        if (r0 == 0) goto L_0x0366;
    L_0x033c:
        r0 = r10.f1031n;
        if (r0 <= 0) goto L_0x03ce;
    L_0x0340:
        r0 = r10.f1037u;
        if (r0 != 0) goto L_0x03ce;
    L_0x0344:
        r0 = r10.m1406a(r11, r13, r3, r14);
    L_0x0348:
        if (r0 == 0) goto L_0x035f;
    L_0x034a:
        r1 = r11.f736J;
        r11.f754c = r1;
        r11.f755d = r12;
        r1 = r11.f736J;
        r2 = new android.support.v4.app.ab;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.f736J;
        r1.startAnimation(r0);
    L_0x035f:
        r0 = r11.f735I;
        r1 = r11.f736J;
        r0.removeView(r1);
    L_0x0366:
        r11.f735I = r7;
        r11.f736J = r7;
        r11.f737K = r7;
        goto L_0x027f;
    L_0x036e:
        r0 = f1017a;
        if (r0 == 0) goto L_0x038a;
    L_0x0372:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x038a:
        r0 = r11.f730D;
        if (r0 != 0) goto L_0x0391;
    L_0x038e:
        r11.m952I();
    L_0x0391:
        r11.f733G = r3;
        r11.m1006q();
        r0 = r11.f733G;
        if (r0 != 0) goto L_0x03b9;
    L_0x039a:
        r0 = new android.support.v4.app.da;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x03b9:
        if (r15 != 0) goto L_0x0045;
    L_0x03bb:
        r0 = r11.f730D;
        if (r0 != 0) goto L_0x03c4;
    L_0x03bf:
        r10.m1436e(r11);
        goto L_0x0045;
    L_0x03c4:
        r11.f772u = r7;
        r11.f774w = r7;
        r11.f771t = r7;
        r11.f773v = r7;
        goto L_0x0045;
    L_0x03ce:
        r0 = r7;
        goto L_0x0348;
    L_0x03d1:
        r0 = r7;
        goto L_0x01b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.z.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    public void m1415a(Fragment fragment, boolean z) {
        if (this.f1024g == null) {
            this.f1024g = new ArrayList();
        }
        if (f1017a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m1434d(fragment);
        if (!fragment.f728B) {
            if (this.f1024g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.f1024g.add(fragment);
            fragment.f764m = true;
            fragment.f765n = false;
            if (fragment.f731E && fragment.f732F) {
                this.f1035s = true;
            }
            if (z) {
                m1430c(fragment);
            }
        }
    }

    public void m1416a(C0147w c0147w, C0141u c0141u, Fragment fragment) {
        if (this.f1032o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f1032o = c0147w;
        this.f1033p = c0141u;
        this.f1034q = fragment;
    }

    public void m1417a(Runnable runnable, boolean z) {
        if (!z) {
            m1398u();
        }
        synchronized (this) {
            if (this.f1037u || this.f1032o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f1020c == null) {
                this.f1020c = new ArrayList();
            }
            this.f1020c.add(runnable);
            if (this.f1020c.size() == 1) {
                this.f1032o.m1329h().removeCallbacks(this.f1042z);
                this.f1032o.m1329h().post(this.f1042z);
            }
        }
    }

    public void m1418a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f1023f != null) {
            size = this.f1023f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f1023f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.m968a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f1024g != null) {
            size = this.f1024g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f1024g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f1027j != null) {
            size = this.f1027j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f1027j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f1026i != null) {
            size = this.f1026i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0132e c0132e = (C0132e) this.f1026i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0132e.toString());
                    c0132e.m1286a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f1028k != null) {
                int size2 = this.f1028k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0132e = (C0132e) this.f1028k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0132e);
                    }
                }
            }
            if (this.f1029l != null && this.f1029l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f1029l.toArray()));
            }
        }
        if (this.f1020c != null) {
            i = this.f1020c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f1020c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1032o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1033p);
        if (this.f1034q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1034q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1031n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f1036t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f1037u);
        if (this.f1035s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f1035s);
        }
        if (this.f1038v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f1038v);
        }
        if (this.f1025h != null && this.f1025h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f1025h.toArray()));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m1419a(android.os.Handler r12, java.lang.String r13, int r14, int r15) {
        /*
        r11 = this;
        r4 = 0;
        r2 = 1;
        r3 = 0;
        r0 = r11.f1026i;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r3;
    L_0x0008:
        if (r13 != 0) goto L_0x0037;
    L_0x000a:
        if (r14 >= 0) goto L_0x0037;
    L_0x000c:
        r0 = r15 & 1;
        if (r0 != 0) goto L_0x0037;
    L_0x0010:
        r0 = r11.f1026i;
        r0 = r0.size();
        r0 = r0 + -1;
        if (r0 < 0) goto L_0x0007;
    L_0x001a:
        r1 = r11.f1026i;
        r0 = r1.remove(r0);
        r0 = (android.support.v4.app.C0132e) r0;
        r1 = new android.util.SparseArray;
        r1.<init>();
        r3 = new android.util.SparseArray;
        r3.<init>();
        r0.m1285a(r1, r3);
        r0.m1282a(r2, r4, r1, r3);
        r11.m1439f();
    L_0x0035:
        r3 = r2;
        goto L_0x0007;
    L_0x0037:
        r0 = -1;
        if (r13 != 0) goto L_0x003c;
    L_0x003a:
        if (r14 < 0) goto L_0x008b;
    L_0x003c:
        r0 = r11.f1026i;
        r0 = r0.size();
        r1 = r0 + -1;
    L_0x0044:
        if (r1 < 0) goto L_0x005a;
    L_0x0046:
        r0 = r11.f1026i;
        r0 = r0.get(r1);
        r0 = (android.support.v4.app.C0132e) r0;
        if (r13 == 0) goto L_0x0081;
    L_0x0050:
        r5 = r0.m1291c();
        r5 = r13.equals(r5);
        if (r5 == 0) goto L_0x0081;
    L_0x005a:
        if (r1 < 0) goto L_0x0007;
    L_0x005c:
        r0 = r15 & 1;
        if (r0 == 0) goto L_0x008a;
    L_0x0060:
        r1 = r1 + -1;
    L_0x0062:
        if (r1 < 0) goto L_0x008a;
    L_0x0064:
        r0 = r11.f1026i;
        r0 = r0.get(r1);
        r0 = (android.support.v4.app.C0132e) r0;
        if (r13 == 0) goto L_0x0078;
    L_0x006e:
        r5 = r0.m1291c();
        r5 = r13.equals(r5);
        if (r5 != 0) goto L_0x007e;
    L_0x0078:
        if (r14 < 0) goto L_0x008a;
    L_0x007a:
        r0 = r0.f952p;
        if (r14 != r0) goto L_0x008a;
    L_0x007e:
        r1 = r1 + -1;
        goto L_0x0062;
    L_0x0081:
        if (r14 < 0) goto L_0x0087;
    L_0x0083:
        r0 = r0.f952p;
        if (r14 == r0) goto L_0x005a;
    L_0x0087:
        r1 = r1 + -1;
        goto L_0x0044;
    L_0x008a:
        r0 = r1;
    L_0x008b:
        r1 = r11.f1026i;
        r1 = r1.size();
        r1 = r1 + -1;
        if (r0 == r1) goto L_0x0007;
    L_0x0095:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r1 = r11.f1026i;
        r1 = r1.size();
        r1 = r1 + -1;
    L_0x00a2:
        if (r1 <= r0) goto L_0x00b0;
    L_0x00a4:
        r5 = r11.f1026i;
        r5 = r5.remove(r1);
        r6.add(r5);
        r1 = r1 + -1;
        goto L_0x00a2;
    L_0x00b0:
        r0 = r6.size();
        r7 = r0 + -1;
        r8 = new android.util.SparseArray;
        r8.<init>();
        r9 = new android.util.SparseArray;
        r9.<init>();
        r1 = r3;
    L_0x00c1:
        if (r1 > r7) goto L_0x00d0;
    L_0x00c3:
        r0 = r6.get(r1);
        r0 = (android.support.v4.app.C0132e) r0;
        r0.m1285a(r8, r9);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00c1;
    L_0x00d0:
        r5 = r4;
        r4 = r3;
    L_0x00d2:
        if (r4 > r7) goto L_0x0108;
    L_0x00d4:
        r0 = f1017a;
        if (r0 == 0) goto L_0x00f4;
    L_0x00d8:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r10 = "Popping back stack state: ";
        r1 = r1.append(r10);
        r10 = r6.get(r4);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x00f4:
        r0 = r6.get(r4);
        r0 = (android.support.v4.app.C0132e) r0;
        if (r4 != r7) goto L_0x0106;
    L_0x00fc:
        r1 = r2;
    L_0x00fd:
        r1 = r0.m1282a(r1, r5, r8, r9);
        r0 = r4 + 1;
        r4 = r0;
        r5 = r1;
        goto L_0x00d2;
    L_0x0106:
        r1 = r3;
        goto L_0x00fd;
    L_0x0108:
        r11.m1439f();
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.z.a(android.os.Handler, java.lang.String, int, int):boolean");
    }

    public boolean m1420a(Menu menu) {
        if (this.f1024g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f1024g.size(); i++) {
            Fragment fragment = (Fragment) this.f1024g.get(i);
            if (fragment != null && fragment.m982c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m1421a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f1024g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f1024g.size()) {
                fragment = (Fragment) this.f1024g.get(i2);
                if (fragment != null && fragment.m977b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f1027j != null) {
            while (i < this.f1027j.size()) {
                fragment = (Fragment) this.f1027j.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.m1007r();
                }
                i++;
            }
        }
        this.f1027j = arrayList;
        return z;
    }

    public boolean m1422a(MenuItem menuItem) {
        if (this.f1024g == null) {
            return false;
        }
        for (int i = 0; i < this.f1024g.size(); i++) {
            Fragment fragment = (Fragment) this.f1024g.get(i);
            if (fragment != null && fragment.m983c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m1423b(int i) {
        synchronized (this) {
            this.f1028k.set(i, null);
            if (this.f1029l == null) {
                this.f1029l = new ArrayList();
            }
            if (f1017a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f1029l.add(Integer.valueOf(i));
        }
    }

    public void m1424b(Fragment fragment) {
        if (!fragment.f738L) {
            return;
        }
        if (this.f1022e) {
            this.f1039w = true;
            return;
        }
        fragment.f738L = false;
        m1414a(fragment, this.f1031n, 0, 0, false);
    }

    public void m1425b(Fragment fragment, int i, int i2) {
        if (f1017a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.f727A) {
            fragment.f727A = true;
            if (fragment.f736J != null) {
                Animation a = m1406a(fragment, i, false, i2);
                if (a != null) {
                    m1396b(fragment.f736J, a);
                    fragment.f736J.startAnimation(a);
                }
                fragment.f736J.setVisibility(8);
            }
            if (fragment.f764m && fragment.f731E && fragment.f732F) {
                this.f1035s = true;
            }
            fragment.m969a(true);
        }
    }

    void m1426b(C0132e c0132e) {
        if (this.f1026i == null) {
            this.f1026i = new ArrayList();
        }
        this.f1026i.add(c0132e);
        m1439f();
    }

    public void m1427b(Menu menu) {
        if (this.f1024g != null) {
            for (int i = 0; i < this.f1024g.size(); i++) {
                Fragment fragment = (Fragment) this.f1024g.get(i);
                if (fragment != null) {
                    fragment.m986d(menu);
                }
            }
        }
    }

    public boolean m1428b() {
        return m1438e();
    }

    public boolean m1429b(MenuItem menuItem) {
        if (this.f1024g == null) {
            return false;
        }
        for (int i = 0; i < this.f1024g.size(); i++) {
            Fragment fragment = (Fragment) this.f1024g.get(i);
            if (fragment != null && fragment.m987d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void m1430c(Fragment fragment) {
        m1414a(fragment, this.f1031n, 0, 0, false);
    }

    public void m1431c(Fragment fragment, int i, int i2) {
        if (f1017a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f727A) {
            fragment.f727A = false;
            if (fragment.f736J != null) {
                Animation a = m1406a(fragment, i, true, i2);
                if (a != null) {
                    m1396b(fragment.f736J, a);
                    fragment.f736J.startAnimation(a);
                }
                fragment.f736J.setVisibility(0);
            }
            if (fragment.f764m && fragment.f731E && fragment.f732F) {
                this.f1035s = true;
            }
            fragment.m969a(false);
        }
    }

    public boolean m1432c() {
        m1398u();
        m1428b();
        return m1419a(this.f1032o.m1329h(), null, -1, 0);
    }

    void m1433d() {
        if (this.f1023f != null) {
            for (int i = 0; i < this.f1023f.size(); i++) {
                Fragment fragment = (Fragment) this.f1023f.get(i);
                if (fragment != null) {
                    m1424b(fragment);
                }
            }
        }
    }

    void m1434d(Fragment fragment) {
        if (fragment.f758g < 0) {
            if (this.f1025h == null || this.f1025h.size() <= 0) {
                if (this.f1023f == null) {
                    this.f1023f = new ArrayList();
                }
                fragment.m956a(this.f1023f.size(), this.f1034q);
                this.f1023f.add(fragment);
            } else {
                fragment.m956a(((Integer) this.f1025h.remove(this.f1025h.size() - 1)).intValue(), this.f1034q);
                this.f1023f.set(fragment.f758g, fragment);
            }
            if (f1017a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    public void m1435d(Fragment fragment, int i, int i2) {
        if (f1017a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.f728B) {
            fragment.f728B = true;
            if (fragment.f764m) {
                if (this.f1024g != null) {
                    if (f1017a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f1024g.remove(fragment);
                }
                if (fragment.f731E && fragment.f732F) {
                    this.f1035s = true;
                }
                fragment.f764m = false;
                m1414a(fragment, 1, i, i2, false);
            }
        }
    }

    void m1436e(Fragment fragment) {
        if (fragment.f758g >= 0) {
            if (f1017a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f1023f.set(fragment.f758g, null);
            if (this.f1025h == null) {
                this.f1025h = new ArrayList();
            }
            this.f1025h.add(Integer.valueOf(fragment.f758g));
            this.f1032o.m1316a(fragment.f759h);
            fragment.m1005p();
        }
    }

    public void m1437e(Fragment fragment, int i, int i2) {
        if (f1017a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f728B) {
            fragment.f728B = false;
            if (!fragment.f764m) {
                if (this.f1024g == null) {
                    this.f1024g = new ArrayList();
                }
                if (this.f1024g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f1017a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f1024g.add(fragment);
                fragment.f764m = true;
                if (fragment.f731E && fragment.f732F) {
                    this.f1035s = true;
                }
                m1414a(fragment, this.f1031n, i, i2, false);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m1438e() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.f1022e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.f1032o;
        r3 = r3.m1329h();
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0026;
    L_0x001e:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r1 = r2;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.f1020c;	 Catch:{ all -> 0x009b }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.f1020c;	 Catch:{ all -> 0x009b }
        r3 = r3.size();	 Catch:{ all -> 0x009b }
        if (r3 != 0) goto L_0x005c;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r0 = r6.f1039w;
        if (r0 == 0) goto L_0x00a9;
    L_0x0039:
        r3 = r2;
        r4 = r2;
    L_0x003b:
        r0 = r6.f1023f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x00a2;
    L_0x0043:
        r0 = r6.f1023f;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x0058;
    L_0x004d:
        r5 = r0.f740N;
        if (r5 == 0) goto L_0x0058;
    L_0x0051:
        r0 = r0.f740N;
        r0 = r0.m1099a();
        r4 = r4 | r0;
    L_0x0058:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x003b;
    L_0x005c:
        r1 = r6.f1020c;	 Catch:{ all -> 0x009b }
        r3 = r1.size();	 Catch:{ all -> 0x009b }
        r1 = r6.f1021d;	 Catch:{ all -> 0x009b }
        if (r1 == 0) goto L_0x006b;
    L_0x0066:
        r1 = r6.f1021d;	 Catch:{ all -> 0x009b }
        r1 = r1.length;	 Catch:{ all -> 0x009b }
        if (r1 >= r3) goto L_0x006f;
    L_0x006b:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x009b }
        r6.f1021d = r1;	 Catch:{ all -> 0x009b }
    L_0x006f:
        r1 = r6.f1020c;	 Catch:{ all -> 0x009b }
        r4 = r6.f1021d;	 Catch:{ all -> 0x009b }
        r1.toArray(r4);	 Catch:{ all -> 0x009b }
        r1 = r6.f1020c;	 Catch:{ all -> 0x009b }
        r1.clear();	 Catch:{ all -> 0x009b }
        r1 = r6.f1032o;	 Catch:{ all -> 0x009b }
        r1 = r1.m1329h();	 Catch:{ all -> 0x009b }
        r4 = r6.f1042z;	 Catch:{ all -> 0x009b }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x009b }
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r6.f1022e = r0;
        r1 = r2;
    L_0x008a:
        if (r1 >= r3) goto L_0x009e;
    L_0x008c:
        r4 = r6.f1021d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.f1021d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x008a;
    L_0x009b:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        throw r0;
    L_0x009e:
        r6.f1022e = r2;
        r1 = r0;
        goto L_0x0027;
    L_0x00a2:
        if (r4 != 0) goto L_0x00a9;
    L_0x00a4:
        r6.f1039w = r2;
        r6.m1433d();
    L_0x00a9:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.z.e():boolean");
    }

    void m1439f() {
        if (this.f1030m != null) {
            for (int i = 0; i < this.f1030m.size(); i++) {
                ((C0152y) this.f1030m.get(i)).m1388a();
            }
        }
    }

    void m1440f(Fragment fragment) {
        if (fragment.f737K != null) {
            if (this.f1041y == null) {
                this.f1041y = new SparseArray();
            } else {
                this.f1041y.clear();
            }
            fragment.f737K.saveHierarchyState(this.f1041y);
            if (this.f1041y.size() > 0) {
                fragment.f757f = this.f1041y;
                this.f1041y = null;
            }
        }
    }

    Bundle m1441g(Fragment fragment) {
        Bundle bundle;
        if (this.f1040x == null) {
            this.f1040x = new Bundle();
        }
        fragment.m999j(this.f1040x);
        if (this.f1040x.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f1040x;
            this.f1040x = null;
        }
        if (fragment.f736J != null) {
            m1440f(fragment);
        }
        if (fragment.f757f != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f757f);
        }
        if (!fragment.f739M) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.f739M);
        }
        return bundle;
    }

    ArrayList<Fragment> m1442g() {
        ArrayList<Fragment> arrayList = null;
        if (this.f1023f != null) {
            for (int i = 0; i < this.f1023f.size(); i++) {
                Fragment fragment = (Fragment) this.f1023f.get(i);
                if (fragment != null && fragment.f729C) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.f730D = true;
                    fragment.f762k = fragment.f761j != null ? fragment.f761j.f758g : -1;
                    if (f1017a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    Parcelable m1443h() {
        BackStackState[] backStackStateArr = null;
        m1438e();
        if (f1018b) {
            this.f1036t = true;
        }
        if (this.f1023f == null || this.f1023f.size() <= 0) {
            return null;
        }
        int size = this.f1023f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f1023f.get(i);
            if (fragment != null) {
                if (fragment.f758g < 0) {
                    m1392a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f758g));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.f753b <= 0 || fragmentState.f790j != null) {
                    fragmentState.f790j = fragment.f756e;
                } else {
                    fragmentState.f790j = m1441g(fragment);
                    if (fragment.f761j != null) {
                        if (fragment.f761j.f758g < 0) {
                            m1392a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f761j));
                        }
                        if (fragmentState.f790j == null) {
                            fragmentState.f790j = new Bundle();
                        }
                        m1411a(fragmentState.f790j, "android:target_state", fragment.f761j);
                        if (fragment.f763l != 0) {
                            fragmentState.f790j.putInt("android:target_req_state", fragment.f763l);
                        }
                    }
                }
                if (f1017a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f790j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.f1024g != null) {
                i = this.f1024g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.f1024g.get(i2)).f758g;
                        if (iArr[i2] < 0) {
                            m1392a(new IllegalStateException("Failure saving state: active " + this.f1024g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f1017a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f1024g.get(i2));
                        }
                    }
                    if (this.f1026i != null) {
                        i = this.f1026i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState((C0132e) this.f1026i.get(i2));
                                if (f1017a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f1026i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.f778a = fragmentStateArr;
                    fragmentManagerState.f779b = iArr;
                    fragmentManagerState.f780c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.f1026i != null) {
                i = this.f1026i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((C0132e) this.f1026i.get(i2));
                        if (f1017a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f1026i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f778a = fragmentStateArr;
            fragmentManagerState.f779b = iArr;
            fragmentManagerState.f780c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f1017a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public void m1444i() {
        this.f1036t = false;
    }

    public void m1445j() {
        this.f1036t = false;
        m1409a(1, false);
    }

    public void m1446k() {
        this.f1036t = false;
        m1409a(2, false);
    }

    public void m1447l() {
        this.f1036t = false;
        m1409a(4, false);
    }

    public void m1448m() {
        this.f1036t = false;
        m1409a(5, false);
    }

    public void m1449n() {
        m1409a(4, false);
    }

    public void m1450o() {
        this.f1036t = true;
        m1409a(3, false);
    }

    public void m1451p() {
        m1409a(2, false);
    }

    public void m1452q() {
        m1409a(1, false);
    }

    public void m1453r() {
        this.f1037u = true;
        m1438e();
        m1409a(0, false);
        this.f1032o = null;
        this.f1033p = null;
        this.f1034q = null;
    }

    public void m1454s() {
        if (this.f1024g != null) {
            for (int i = 0; i < this.f1024g.size(); i++) {
                Fragment fragment = (Fragment) this.f1024g.get(i);
                if (fragment != null) {
                    fragment.m947D();
                }
            }
        }
    }

    ar m1455t() {
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f1034q != null) {
            C0227d.m1705a(this.f1034q, stringBuilder);
        } else {
            C0227d.m1705a(this.f1032o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
