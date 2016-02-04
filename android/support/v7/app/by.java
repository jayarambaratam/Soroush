package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.cb;
import android.support.v4.view.el;
import android.support.v4.view.fc;
import android.support.v4.view.fe;
import android.support.v7.p019a.C0359b;
import android.support.v7.p019a.C0364g;
import android.support.v7.p019a.C0369l;
import android.support.v7.view.C0376c;
import android.support.v7.view.C0378b;
import android.support.v7.view.C0427a;
import android.support.v7.view.C0436l;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

public class by extends C0370a implements ActionBarVisibilityCallback {
    static final /* synthetic */ boolean f1824h;
    private static final Interpolator f1825i;
    private static final Interpolator f1826j;
    private static final boolean f1827k;
    private boolean f1828A;
    private int f1829B;
    private boolean f1830C;
    private boolean f1831D;
    private boolean f1832E;
    private boolean f1833F;
    private boolean f1834G;
    private C0436l f1835H;
    private boolean f1836I;
    cc f1837a;
    C0378b f1838b;
    C0376c f1839c;
    boolean f1840d;
    final fc f1841e;
    final fc f1842f;
    final fe f1843g;
    private Context f1844l;
    private Context f1845m;
    private Activity f1846n;
    private Dialog f1847o;
    private ActionBarOverlayLayout f1848p;
    private ActionBarContainer f1849q;
    private DecorToolbar f1850r;
    private ActionBarContextView f1851s;
    private View f1852t;
    private ScrollingTabContainerView f1853u;
    private ArrayList<Object> f1854v;
    private int f1855w;
    private boolean f1856x;
    private boolean f1857y;
    private ArrayList<C0377c> f1858z;

    static {
        boolean z = true;
        f1824h = !by.class.desiredAssertionStatus();
        f1825i = new AccelerateInterpolator();
        f1826j = new DecelerateInterpolator();
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        f1827k = z;
    }

    public by(Activity activity, boolean z) {
        this.f1854v = new ArrayList();
        this.f1855w = -1;
        this.f1858z = new ArrayList();
        this.f1829B = 0;
        this.f1830C = true;
        this.f1834G = true;
        this.f1841e = new bz(this);
        this.f1842f = new ca(this);
        this.f1843g = new cb(this);
        this.f1846n = activity;
        View decorView = activity.getWindow().getDecorView();
        m3714a(decorView);
        if (!z) {
            this.f1852t = decorView.findViewById(16908290);
        }
    }

    public by(Dialog dialog) {
        this.f1854v = new ArrayList();
        this.f1855w = -1;
        this.f1858z = new ArrayList();
        this.f1829B = 0;
        this.f1830C = true;
        this.f1834G = true;
        this.f1841e = new bz(this);
        this.f1842f = new ca(this);
        this.f1843g = new cb(this);
        this.f1847o = dialog;
        m3714a(dialog.getWindow().getDecorView());
    }

    private void m3714a(View view) {
        this.f1848p = (ActionBarOverlayLayout) view.findViewById(C0364g.decor_content_parent);
        if (this.f1848p != null) {
            this.f1848p.setActionBarVisibilityCallback(this);
        }
        this.f1850r = m3717b(view.findViewById(C0364g.action_bar));
        this.f1851s = (ActionBarContextView) view.findViewById(C0364g.action_context_bar);
        this.f1849q = (ActionBarContainer) view.findViewById(C0364g.action_bar_container);
        if (this.f1850r == null || this.f1851s == null || this.f1849q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f1844l = this.f1850r.getContext();
        boolean z = (this.f1850r.getDisplayOptions() & 4) != 0;
        if (z) {
            this.f1856x = true;
        }
        C0427a a = C0427a.m3956a(this.f1844l);
        z = a.m3962f() || z;
        m3743b(z);
        m3729j(a.m3960d());
        TypedArray obtainStyledAttributes = this.f1844l.obtainStyledAttributes(null, C0369l.ActionBar, C0359b.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0369l.ActionBar_hideOnContentScroll, false)) {
            m3747c(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0369l.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            m3733a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private DecorToolbar m3717b(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private static boolean m3719b(boolean z, boolean z2, boolean z3) {
        return z3 ? true : (z || z2) ? false : true;
    }

    private void m3726h() {
        if (!this.f1833F) {
            this.f1833F = true;
            if (this.f1848p != null) {
                this.f1848p.setShowingForActionMode(true);
            }
            m3730k(false);
        }
    }

    private void m3728i() {
        if (this.f1833F) {
            this.f1833F = false;
            if (this.f1848p != null) {
                this.f1848p.setShowingForActionMode(false);
            }
            m3730k(false);
        }
    }

    private void m3729j(boolean z) {
        boolean z2 = true;
        this.f1828A = z;
        if (this.f1828A) {
            this.f1849q.setTabContainer(null);
            this.f1850r.setEmbeddedTabView(this.f1853u);
        } else {
            this.f1850r.setEmbeddedTabView(null);
            this.f1849q.setTabContainer(this.f1853u);
        }
        boolean z3 = m3753g() == 2;
        if (this.f1853u != null) {
            if (z3) {
                this.f1853u.setVisibility(0);
                if (this.f1848p != null) {
                    cb.m2446w(this.f1848p);
                }
            } else {
                this.f1853u.setVisibility(8);
            }
        }
        DecorToolbar decorToolbar = this.f1850r;
        boolean z4 = !this.f1828A && z3;
        decorToolbar.setCollapsible(z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1848p;
        if (this.f1828A || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void m3730k(boolean z) {
        if (m3719b(this.f1831D, this.f1832E, this.f1833F)) {
            if (!this.f1834G) {
                this.f1834G = true;
                m3754g(z);
            }
        } else if (this.f1834G) {
            this.f1834G = false;
            m3755h(z);
        }
    }

    public int m3731a() {
        return this.f1850r.getDisplayOptions();
    }

    public C0378b m3732a(C0376c c0376c) {
        if (this.f1837a != null) {
            this.f1837a.m3784c();
        }
        this.f1848p.setHideOnContentScrollEnabled(false);
        this.f1851s.killMode();
        C0378b ccVar = new cc(this, this.f1851s.getContext(), c0376c);
        if (!ccVar.m3786e()) {
            return null;
        }
        ccVar.m3785d();
        this.f1851s.initForMode(ccVar);
        m3756i(true);
        this.f1851s.sendAccessibilityEvent(32);
        this.f1837a = ccVar;
        return ccVar;
    }

    public void m3733a(float f) {
        cb.m2432j(this.f1849q, f);
    }

    public void m3734a(int i) {
        m3738a(this.f1844l.getString(i));
    }

    public void m3735a(int i, int i2) {
        int displayOptions = this.f1850r.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.f1856x = true;
        }
        this.f1850r.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
    }

    public void m3736a(Configuration configuration) {
        m3729j(C0427a.m3956a(this.f1844l).m3960d());
    }

    public void m3737a(Drawable drawable) {
        this.f1850r.setNavigationIcon(drawable);
    }

    public void m3738a(CharSequence charSequence) {
        this.f1850r.setTitle(charSequence);
    }

    public void m3739a(boolean z) {
        m3735a(z ? 4 : 0, 4);
    }

    public void m3740b() {
        if (!this.f1831D) {
            this.f1831D = true;
            m3730k(false);
        }
    }

    public void m3741b(int i) {
        this.f1850r.setNavigationIcon(i);
    }

    public void m3742b(CharSequence charSequence) {
        this.f1850r.setSubtitle(charSequence);
    }

    public void m3743b(boolean z) {
        this.f1850r.setHomeButtonEnabled(z);
    }

    public Context m3744c() {
        if (this.f1845m == null) {
            TypedValue typedValue = new TypedValue();
            this.f1844l.getTheme().resolveAttribute(C0359b.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1845m = new ContextThemeWrapper(this.f1844l, i);
            } else {
                this.f1845m = this.f1844l;
            }
        }
        return this.f1845m;
    }

    public void m3745c(int i) {
        this.f1850r.setNavigationContentDescription(i);
    }

    public void m3746c(CharSequence charSequence) {
        this.f1850r.setWindowTitle(charSequence);
    }

    public void m3747c(boolean z) {
        if (!z || this.f1848p.isInOverlayMode()) {
            this.f1840d = z;
            this.f1848p.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void m3748d(boolean z) {
        if (!this.f1856x) {
            m3739a(z);
        }
    }

    public void m3749e(boolean z) {
        this.f1836I = z;
        if (!z && this.f1835H != null) {
            this.f1835H.m4016b();
        }
    }

    public boolean m3750e() {
        if (this.f1850r == null || !this.f1850r.hasExpandedActionView()) {
            return false;
        }
        this.f1850r.collapseActionView();
        return true;
    }

    public void enableContentAnimations(boolean z) {
        this.f1830C = z;
    }

    void m3751f() {
        if (this.f1839c != null) {
            this.f1839c.m3645a(this.f1838b);
            this.f1838b = null;
            this.f1839c = null;
        }
    }

    public void m3752f(boolean z) {
        if (z != this.f1857y) {
            this.f1857y = z;
            int size = this.f1858z.size();
            for (int i = 0; i < size; i++) {
                ((C0377c) this.f1858z.get(i)).m3757a(z);
            }
        }
    }

    public int m3753g() {
        return this.f1850r.getNavigationMode();
    }

    public void m3754g(boolean z) {
        if (this.f1835H != null) {
            this.f1835H.m4016b();
        }
        this.f1849q.setVisibility(0);
        if (this.f1829B == 0 && f1827k && (this.f1836I || z)) {
            cb.m2408b(this.f1849q, 0.0f);
            float f = (float) (-this.f1849q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1849q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            cb.m2408b(this.f1849q, f);
            C0436l c0436l = new C0436l();
            el c = cb.m2442s(this.f1849q).m2806c(0.0f);
            c.m2801a(this.f1843g);
            c0436l.m4011a(c);
            if (this.f1830C && this.f1852t != null) {
                cb.m2408b(this.f1852t, f);
                c0436l.m4011a(cb.m2442s(this.f1852t).m2806c(0.0f));
            }
            c0436l.m4014a(f1826j);
            c0436l.m4010a(250);
            c0436l.m4013a(this.f1842f);
            this.f1835H = c0436l;
            c0436l.m4015a();
        } else {
            cb.m2413c(this.f1849q, 1.0f);
            cb.m2408b(this.f1849q, 0.0f);
            if (this.f1830C && this.f1852t != null) {
                cb.m2408b(this.f1852t, 0.0f);
            }
            this.f1842f.onAnimationEnd(null);
        }
        if (this.f1848p != null) {
            cb.m2446w(this.f1848p);
        }
    }

    public void m3755h(boolean z) {
        if (this.f1835H != null) {
            this.f1835H.m4016b();
        }
        if (this.f1829B == 0 && f1827k && (this.f1836I || z)) {
            cb.m2413c(this.f1849q, 1.0f);
            this.f1849q.setTransitioning(true);
            C0436l c0436l = new C0436l();
            float f = (float) (-this.f1849q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1849q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            el c = cb.m2442s(this.f1849q).m2806c(f);
            c.m2801a(this.f1843g);
            c0436l.m4011a(c);
            if (this.f1830C && this.f1852t != null) {
                c0436l.m4011a(cb.m2442s(this.f1852t).m2806c(f));
            }
            c0436l.m4014a(f1825i);
            c0436l.m4010a(250);
            c0436l.m4013a(this.f1841e);
            this.f1835H = c0436l;
            c0436l.m4015a();
            return;
        }
        this.f1841e.onAnimationEnd(null);
    }

    public void hideForSystem() {
        if (!this.f1832E) {
            this.f1832E = true;
            m3730k(true);
        }
    }

    public void m3756i(boolean z) {
        el elVar;
        el elVar2;
        if (z) {
            m3726h();
        } else {
            m3728i();
        }
        if (z) {
            elVar = this.f1850r.setupAnimatorToVisibility(4, 100);
            elVar2 = this.f1851s.setupAnimatorToVisibility(0, 200);
        } else {
            elVar2 = this.f1850r.setupAnimatorToVisibility(0, 200);
            elVar = this.f1851s.setupAnimatorToVisibility(8, 100);
        }
        C0436l c0436l = new C0436l();
        c0436l.m4012a(elVar, elVar2);
        c0436l.m4015a();
    }

    public void onContentScrollStarted() {
        if (this.f1835H != null) {
            this.f1835H.m4016b();
            this.f1835H = null;
        }
    }

    public void onContentScrollStopped() {
    }

    public void onWindowVisibilityChanged(int i) {
        this.f1829B = i;
    }

    public void showForSystem() {
        if (this.f1832E) {
            this.f1832E = false;
            m3730k(true);
        }
    }
}
