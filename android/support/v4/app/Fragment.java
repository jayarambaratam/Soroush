package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p016f.C0222q;
import android.support.v4.p016f.C0227d;
import android.support.v4.view.ah;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    static final Object f726a;
    private static final C0222q<String, Class<?>> aa;
    boolean f727A;
    boolean f728B;
    boolean f729C;
    boolean f730D;
    boolean f731E;
    boolean f732F;
    boolean f733G;
    int f734H;
    ViewGroup f735I;
    View f736J;
    View f737K;
    boolean f738L;
    boolean f739M;
    ax f740N;
    boolean f741O;
    boolean f742P;
    Object f743Q;
    Object f744R;
    Object f745S;
    Object f746T;
    Object f747U;
    Object f748V;
    Boolean f749W;
    Boolean f750X;
    cz f751Y;
    cz f752Z;
    int f753b;
    View f754c;
    int f755d;
    Bundle f756e;
    SparseArray<Parcelable> f757f;
    int f758g;
    String f759h;
    Bundle f760i;
    Fragment f761j;
    int f762k;
    int f763l;
    boolean f764m;
    boolean f765n;
    boolean f766o;
    boolean f767p;
    boolean f768q;
    boolean f769r;
    int f770s;
    C0153z f771t;
    C0147w f772u;
    C0153z f773v;
    Fragment f774w;
    int f775x;
    int f776y;
    String f777z;

    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        final Bundle f725a;

        static {
            CREATOR = new C0144p();
        }

        SavedState(Bundle bundle) {
            this.f725a = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.f725a = parcel.readBundle();
            if (classLoader != null && this.f725a != null) {
                this.f725a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f725a);
        }
    }

    static {
        aa = new C0222q();
        f726a = new Object();
    }

    public Fragment() {
        this.f753b = 0;
        this.f758g = -1;
        this.f762k = -1;
        this.f732F = true;
        this.f739M = true;
        this.f743Q = null;
        this.f744R = f726a;
        this.f745S = null;
        this.f746T = f726a;
        this.f747U = null;
        this.f748V = f726a;
        this.f751Y = null;
        this.f752Z = null;
    }

    public static Fragment m941a(Context context, String str) {
        return m942a(context, str, null);
    }

    public static Fragment m942a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) aa.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                aa.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.f760i = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new C0143o("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new C0143o("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new C0143o("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean m943b(Context context, String str) {
        try {
            Class cls = (Class) aa.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                aa.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    void m944A() {
        this.f773v = new C0153z();
        this.f773v.m1416a(this.f772u, new C0142n(this), this);
    }

    void m945B() {
        if (this.f773v != null) {
            this.f773v.m1444i();
            this.f773v.m1438e();
        }
        this.f733G = false;
        m998j();
        if (this.f733G) {
            if (this.f773v != null) {
                this.f773v.m1447l();
            }
            if (this.f740N != null) {
                this.f740N.m1105g();
                return;
            }
            return;
        }
        throw new da("Fragment " + this + " did not call through to super.onStart()");
    }

    void m946C() {
        if (this.f773v != null) {
            this.f773v.m1444i();
            this.f773v.m1438e();
        }
        this.f733G = false;
        m1000k();
        if (!this.f733G) {
            throw new da("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f773v != null) {
            this.f773v.m1448m();
            this.f773v.m1438e();
        }
    }

    void m947D() {
        onLowMemory();
        if (this.f773v != null) {
            this.f773v.m1454s();
        }
    }

    void m948E() {
        if (this.f773v != null) {
            this.f773v.m1449n();
        }
        this.f733G = false;
        m1001l();
        if (!this.f733G) {
            throw new da("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void m949F() {
        if (this.f773v != null) {
            this.f773v.m1450o();
        }
        this.f733G = false;
        m1002m();
        if (!this.f733G) {
            throw new da("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void m950G() {
        if (this.f773v != null) {
            this.f773v.m1451p();
        }
        if (this.f741O) {
            this.f741O = false;
            if (!this.f742P) {
                this.f742P = true;
                this.f740N = this.f772u.m1313a(this.f759h, this.f741O, false);
            }
            if (this.f740N == null) {
                return;
            }
            if (this.f772u.m1332k()) {
                this.f740N.m1102d();
            } else {
                this.f740N.m1101c();
            }
        }
    }

    void m951H() {
        if (this.f773v != null) {
            this.f773v.m1452q();
        }
        this.f733G = false;
        m1003n();
        if (!this.f733G) {
            throw new da("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f740N != null) {
            this.f740N.m1104f();
        }
    }

    void m952I() {
        if (this.f773v != null) {
            this.f773v.m1453r();
        }
        this.f733G = false;
        m1004o();
        if (!this.f733G) {
            throw new da("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    public View m953a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation m954a(int i, boolean z, int i2) {
        return null;
    }

    public void m955a(int i, int i2, Intent intent) {
    }

    final void m956a(int i, Fragment fragment) {
        this.f758g = i;
        if (fragment != null) {
            this.f759h = fragment.f759h + ":" + this.f758g;
        } else {
            this.f759h = "android:fragment:" + this.f758g;
        }
    }

    public void m957a(int i, String[] strArr, int[] iArr) {
    }

    @Deprecated
    public void m958a(Activity activity) {
        this.f733G = true;
    }

    @Deprecated
    public void m959a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f733G = true;
    }

    public void m960a(Context context) {
        this.f733G = true;
        Activity f = this.f772u == null ? null : this.f772u.m1327f();
        if (f != null) {
            this.f733G = false;
            m958a(f);
        }
    }

    public void m961a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f733G = true;
        Activity f = this.f772u == null ? null : this.f772u.m1327f();
        if (f != null) {
            this.f733G = false;
            m959a(f, attributeSet, bundle);
        }
    }

    void m962a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f773v != null) {
            this.f773v.m1410a(configuration);
        }
    }

    final void m963a(Bundle bundle) {
        if (this.f757f != null) {
            this.f737K.restoreHierarchyState(this.f757f);
            this.f757f = null;
        }
        this.f733G = false;
        m990f(bundle);
        if (!this.f733G) {
            throw new da("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void m964a(SavedState savedState) {
        if (this.f758g >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle bundle = (savedState == null || savedState.f725a == null) ? null : savedState.f725a;
        this.f756e = bundle;
    }

    public void m965a(Menu menu) {
    }

    public void m966a(Menu menu, MenuInflater menuInflater) {
    }

    public void m967a(View view, Bundle bundle) {
    }

    public void m968a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f775x));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f776y));
        printWriter.print(" mTag=");
        printWriter.println(this.f777z);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f753b);
        printWriter.print(" mIndex=");
        printWriter.print(this.f758g);
        printWriter.print(" mWho=");
        printWriter.print(this.f759h);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f770s);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f764m);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f765n);
        printWriter.print(" mResumed=");
        printWriter.print(this.f766o);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f767p);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f768q);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f727A);
        printWriter.print(" mDetached=");
        printWriter.print(this.f728B);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f732F);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f731E);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f729C);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f730D);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f739M);
        if (this.f771t != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f771t);
        }
        if (this.f772u != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f772u);
        }
        if (this.f774w != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f774w);
        }
        if (this.f760i != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f760i);
        }
        if (this.f756e != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f756e);
        }
        if (this.f757f != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f757f);
        }
        if (this.f761j != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f761j);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f763l);
        }
        if (this.f734H != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f734H);
        }
        if (this.f735I != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f735I);
        }
        if (this.f736J != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f736J);
        }
        if (this.f737K != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f736J);
        }
        if (this.f754c != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f754c);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f755d);
        }
        if (this.f740N != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f740N.m1098a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f773v != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f773v + ":");
            this.f773v.m1418a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void m969a(boolean z) {
    }

    final boolean m970a() {
        return this.f770s > 0;
    }

    public boolean m971a(MenuItem menuItem) {
        return false;
    }

    public final Bundle m972b() {
        return this.f760i;
    }

    View m973b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f773v != null) {
            this.f773v.m1444i();
        }
        return m953a(layoutInflater, viewGroup, bundle);
    }

    public void m974b(Bundle bundle) {
        if (this.f758g >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.f760i = bundle;
    }

    public void m975b(Menu menu) {
    }

    public void m976b(boolean z) {
        if (this.f732F != z) {
            this.f732F = z;
            if (this.f731E && m991f() && !m995h()) {
                this.f772u.m1324c();
            }
        }
    }

    boolean m977b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f727A) {
            return false;
        }
        if (this.f731E && this.f732F) {
            z = true;
            m966a(menu, menuInflater);
        }
        return this.f773v != null ? z | this.f773v.m1421a(menu, menuInflater) : z;
    }

    public boolean m978b(MenuItem menuItem) {
        return false;
    }

    public final C0145q m979c() {
        return this.f772u == null ? null : (C0145q) this.f772u.m1327f();
    }

    public LayoutInflater m980c(Bundle bundle) {
        LayoutInflater b = this.f772u.m1321b();
        m988e();
        ah.m2224a(b, this.f773v.m1455t());
        return b;
    }

    public void m981c(boolean z) {
        if (!this.f739M && z && this.f753b < 4) {
            this.f771t.m1424b(this);
        }
        this.f739M = z;
        this.f738L = !z;
    }

    boolean m982c(Menu menu) {
        boolean z = false;
        if (this.f727A) {
            return false;
        }
        if (this.f731E && this.f732F) {
            z = true;
            m965a(menu);
        }
        return this.f773v != null ? z | this.f773v.m1420a(menu) : z;
    }

    boolean m983c(MenuItem menuItem) {
        if (!this.f727A) {
            if (this.f731E && this.f732F && m971a(menuItem)) {
                return true;
            }
            if (this.f773v != null && this.f773v.m1422a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final Resources m984d() {
        if (this.f772u != null) {
            return this.f772u.m1328g().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void m985d(Bundle bundle) {
        this.f733G = true;
    }

    void m986d(Menu menu) {
        if (!this.f727A) {
            if (this.f731E && this.f732F) {
                m975b(menu);
            }
            if (this.f773v != null) {
                this.f773v.m1427b(menu);
            }
        }
    }

    boolean m987d(MenuItem menuItem) {
        if (!this.f727A) {
            if (m978b(menuItem)) {
                return true;
            }
            if (this.f773v != null && this.f773v.m1429b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final C0151x m988e() {
        if (this.f773v == null) {
            m944A();
            if (this.f753b >= 5) {
                this.f773v.m1448m();
            } else if (this.f753b >= 4) {
                this.f773v.m1447l();
            } else if (this.f753b >= 2) {
                this.f773v.m1446k();
            } else if (this.f753b >= 1) {
                this.f773v.m1445j();
            }
        }
        return this.f773v;
    }

    public void m989e(Bundle bundle) {
        this.f733G = true;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void m990f(Bundle bundle) {
        this.f733G = true;
    }

    public final boolean m991f() {
        return this.f772u != null && this.f764m;
    }

    public void m992g(Bundle bundle) {
    }

    public final boolean m993g() {
        return this.f728B;
    }

    void m994h(Bundle bundle) {
        if (this.f773v != null) {
            this.f773v.m1444i();
        }
        this.f733G = false;
        m985d(bundle);
        if (!this.f733G) {
            throw new da("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.f773v == null) {
                    m944A();
                }
                this.f773v.m1412a(parcelable, null);
                this.f773v.m1445j();
            }
        }
    }

    public final boolean m995h() {
        return this.f727A;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public View m996i() {
        return this.f736J;
    }

    void m997i(Bundle bundle) {
        if (this.f773v != null) {
            this.f773v.m1444i();
        }
        this.f733G = false;
        m989e(bundle);
        if (!this.f733G) {
            throw new da("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f773v != null) {
            this.f773v.m1446k();
        }
    }

    public void m998j() {
        this.f733G = true;
        if (!this.f741O) {
            this.f741O = true;
            if (!this.f742P) {
                this.f742P = true;
                this.f740N = this.f772u.m1313a(this.f759h, this.f741O, false);
            }
            if (this.f740N != null) {
                this.f740N.m1100b();
            }
        }
    }

    void m999j(Bundle bundle) {
        m992g(bundle);
        if (this.f773v != null) {
            Parcelable h = this.f773v.m1443h();
            if (h != null) {
                bundle.putParcelable("android:support:fragments", h);
            }
        }
    }

    public void m1000k() {
        this.f733G = true;
    }

    public void m1001l() {
        this.f733G = true;
    }

    public void m1002m() {
        this.f733G = true;
    }

    public void m1003n() {
        this.f733G = true;
    }

    public void m1004o() {
        this.f733G = true;
        if (!this.f742P) {
            this.f742P = true;
            this.f740N = this.f772u.m1313a(this.f759h, this.f741O, false);
        }
        if (this.f740N != null) {
            this.f740N.m1106h();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f733G = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        m979c().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.f733G = true;
    }

    void m1005p() {
        this.f758g = -1;
        this.f759h = null;
        this.f764m = false;
        this.f765n = false;
        this.f766o = false;
        this.f767p = false;
        this.f768q = false;
        this.f769r = false;
        this.f770s = 0;
        this.f771t = null;
        this.f773v = null;
        this.f772u = null;
        this.f775x = 0;
        this.f776y = 0;
        this.f777z = null;
        this.f727A = false;
        this.f728B = false;
        this.f730D = false;
        this.f740N = null;
        this.f741O = false;
        this.f742P = false;
    }

    public void m1006q() {
        this.f733G = true;
    }

    public void m1007r() {
    }

    public Object m1008s() {
        return this.f743Q;
    }

    public Object m1009t() {
        return this.f744R == f726a ? m1008s() : this.f744R;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0227d.m1705a(this, stringBuilder);
        if (this.f758g >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f758g);
        }
        if (this.f775x != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f775x));
        }
        if (this.f777z != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f777z);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Object m1010u() {
        return this.f745S;
    }

    public Object m1011v() {
        return this.f746T == f726a ? m1010u() : this.f746T;
    }

    public Object m1012w() {
        return this.f747U;
    }

    public Object m1013x() {
        return this.f748V == f726a ? m1012w() : this.f748V;
    }

    public boolean m1014y() {
        return this.f750X == null ? true : this.f750X.booleanValue();
    }

    public boolean m1015z() {
        return this.f749W == null ? true : this.f749W.booleanValue();
    }
}
