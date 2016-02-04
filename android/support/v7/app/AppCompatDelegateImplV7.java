package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.az;
import android.support.v4.os.C0269j;
import android.support.v4.view.ah;
import android.support.v4.view.ar;
import android.support.v4.view.cb;
import android.support.v4.view.db;
import android.support.v4.view.el;
import android.support.v4.widget.ax;
import android.support.v7.p019a.C0359b;
import android.support.v7.p019a.C0361d;
import android.support.v7.p019a.C0364g;
import android.support.v7.p019a.C0366i;
import android.support.v7.p019a.C0368k;
import android.support.v7.p019a.C0369l;
import android.support.v7.view.C0376c;
import android.support.v7.view.C0378b;
import android.support.v7.view.C0429e;
import android.support.v7.view.C0430f;
import android.support.v7.view.menu.C0047z;
import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0074j;
import android.support.v7.view.menu.C0374y;
import android.support.v7.view.menu.C0445g;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import mobi.mmdt.ott.C1317h;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

class AppCompatDelegateImplV7 extends aj implements ar, C0074j {
    private boolean f1742A;
    private boolean f1743B;
    private PanelFeatureState[] f1744C;
    private PanelFeatureState f1745D;
    private boolean f1746E;
    private boolean f1747F;
    private int f1748G;
    private final Runnable f1749H;
    private boolean f1750I;
    private Rect f1751J;
    private Rect f1752K;
    private bg f1753L;
    C0378b f1754m;
    ActionBarContextView f1755n;
    PopupWindow f1756o;
    Runnable f1757p;
    el f1758q;
    private DecorContentParent f1759r;
    private az f1760s;
    private be f1761t;
    private boolean f1762u;
    private ViewGroup f1763v;
    private ViewGroup f1764w;
    private TextView f1765x;
    private View f1766y;
    private boolean f1767z;

    final class PanelFeatureState {
        int f1709a;
        int f1710b;
        int f1711c;
        int f1712d;
        int f1713e;
        int f1714f;
        ViewGroup f1715g;
        View f1716h;
        View f1717i;
        C0049i f1718j;
        C0445g f1719k;
        Context f1720l;
        boolean f1721m;
        boolean f1722n;
        boolean f1723o;
        public boolean f1724p;
        boolean f1725q;
        boolean f1726r;
        Bundle f1727s;

        class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR;
            int f1706a;
            boolean f1707b;
            Bundle f1708c;

            static {
                CREATOR = C0269j.m1809a(new bd());
            }

            private SavedState() {
            }

            private static SavedState m3456b(Parcel parcel, ClassLoader classLoader) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.f1706a = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.f1707b = z;
                if (savedState.f1707b) {
                    savedState.f1708c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1706a);
                parcel.writeInt(this.f1707b ? 1 : 0);
                if (this.f1707b) {
                    parcel.writeBundle(this.f1708c);
                }
            }
        }

        PanelFeatureState(int i) {
            this.f1709a = i;
            this.f1725q = false;
        }

        C0047z m3457a(C0374y c0374y) {
            if (this.f1718j == null) {
                return null;
            }
            if (this.f1719k == null) {
                this.f1719k = new C0445g(this.f1720l, C0366i.abc_list_menu_item_layout);
                this.f1719k.m4050a(c0374y);
                this.f1718j.m103a(this.f1719k);
            }
            return this.f1719k.m4047a(this.f1715g);
        }

        void m3458a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0359b.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0359b.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0368k.Theme_AppCompat_CompactMenu, true);
            }
            Context c0429e = new C0429e(context, 0);
            c0429e.getTheme().setTo(newTheme);
            this.f1720l = c0429e;
            TypedArray obtainStyledAttributes = c0429e.obtainStyledAttributes(C0369l.Theme);
            this.f1710b = obtainStyledAttributes.getResourceId(C0369l.Theme_panelBackground, 0);
            this.f1714f = obtainStyledAttributes.getResourceId(C0369l.Theme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void m3459a(C0049i c0049i) {
            if (c0049i != this.f1718j) {
                if (this.f1718j != null) {
                    this.f1718j.m114b(this.f1719k);
                }
                this.f1718j = c0049i;
                if (c0049i != null && this.f1719k != null) {
                    c0049i.m103a(this.f1719k);
                }
            }
        }

        public boolean m3460a() {
            return this.f1716h == null ? false : this.f1717i != null || this.f1719k.m4048a().getCount() > 0;
        }
    }

    AppCompatDelegateImplV7(Context context, Window window, ah ahVar) {
        super(context, window, ahVar);
        this.f1758q = null;
        this.f1749H = new as(this);
    }

    private PanelFeatureState m3502a(int i, boolean z) {
        Object obj = this.f1744C;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.f1744C = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    private PanelFeatureState m3504a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f1744C;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.f1718j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    private void m3505a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.f1744C.length) {
                panelFeatureState = this.f1744C[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f1718j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f1723o) && !m3498m()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3506a(android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r11.f1723o;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.m3498m();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.f1709a;
        if (r0 != 0) goto L_0x0034;
    L_0x0013:
        r4 = r10.a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r4 = r9;
    L_0x0030:
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r4 != 0) goto L_0x000e;
    L_0x0034:
        r0 = r10.m3499n();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.f1709a;
        r5 = r11.f1718j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.m3507a(r11, r9);
        goto L_0x000e;
    L_0x0048:
        r0 = r3;
        goto L_0x0025;
    L_0x004a:
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x0059:
        r0 = r10.m3521b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x005f:
        r0 = r11.f1715g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.f1725q;
        if (r0 == 0) goto L_0x00f1;
    L_0x0067:
        r0 = r11.f1715g;
        if (r0 != 0) goto L_0x00df;
    L_0x006b:
        r0 = r10.m3514a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0071:
        r0 = r11.f1715g;
        if (r0 == 0) goto L_0x000e;
    L_0x0075:
        r0 = r10.m3525c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x007b:
        r0 = r11.m3460a();
        if (r0 == 0) goto L_0x000e;
    L_0x0081:
        r0 = r11.f1716h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0103;
    L_0x0089:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008f:
        r0 = r11.f1710b;
        r4 = r11.f1715g;
        r4.setBackgroundResource(r0);
        r0 = r11.f1716h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a9;
    L_0x00a2:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.f1716h;
        r0.removeView(r4);
    L_0x00a9:
        r0 = r11.f1715g;
        r4 = r11.f1716h;
        r0.addView(r4, r1);
        r0 = r11.f1716h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bd;
    L_0x00b8:
        r0 = r11.f1716h;
        r0.requestFocus();
    L_0x00bd:
        r1 = r2;
    L_0x00be:
        r11.f1722n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.f1712d;
        r4 = r11.f1713e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.f1711c;
        r0.gravity = r1;
        r1 = r11.f1714f;
        r0.windowAnimations = r1;
        r1 = r11.f1715g;
        r8.addView(r1, r0);
        r11.f1723o = r9;
        goto L_0x000e;
    L_0x00df:
        r0 = r11.f1725q;
        if (r0 == 0) goto L_0x0075;
    L_0x00e3:
        r0 = r11.f1715g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0075;
    L_0x00eb:
        r0 = r11.f1715g;
        r0.removeAllViews();
        goto L_0x0075;
    L_0x00f1:
        r0 = r11.f1717i;
        if (r0 == 0) goto L_0x0101;
    L_0x00f5:
        r0 = r11.f1717i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0101;
    L_0x00fd:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00be;
    L_0x0101:
        r1 = r2;
        goto L_0x00be;
    L_0x0103:
        r1 = r0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.a(android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState, android.view.KeyEvent):void");
    }

    private void m3507a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.f1709a == 0 && this.f1759r != null && this.f1759r.isOverflowMenuShowing()) {
            m3512a(panelFeatureState.f1718j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.f1723o || panelFeatureState.f1715g == null)) {
            windowManager.removeView(panelFeatureState.f1715g);
            if (z) {
                m3505a(panelFeatureState.f1709a, panelFeatureState, null);
            }
        }
        panelFeatureState.f1721m = false;
        panelFeatureState.f1722n = false;
        panelFeatureState.f1723o = false;
        panelFeatureState.f1716h = null;
        panelFeatureState.f1725q = true;
        if (this.f1745D == panelFeatureState) {
            this.f1745D = null;
        }
    }

    private void m3512a(C0049i c0049i) {
        if (!this.f1743B) {
            this.f1743B = true;
            this.f1759r.dismissPopups();
            Callback n = m3499n();
            if (!(n == null || m3498m())) {
                n.onPanelClosed(C1317h.Theme_spinnerStyle, c0049i);
            }
            this.f1743B = false;
        }
    }

    private void m3513a(C0049i c0049i, boolean z) {
        if (this.f1759r == null || !this.f1759r.canShowOverflowMenu() || (db.m2731b(ViewConfiguration.get(this.a)) && !this.f1759r.isOverflowMenuShowPending())) {
            PanelFeatureState a = m3502a(0, true);
            a.f1725q = true;
            m3507a(a, false);
            m3506a(a, null);
            return;
        }
        Callback n = m3499n();
        if (this.f1759r.isOverflowMenuShowing() && z) {
            this.f1759r.hideOverflowMenu();
            if (!m3498m()) {
                n.onPanelClosed(C1317h.Theme_spinnerStyle, m3502a(0, true).f1718j);
            }
        } else if (n != null && !m3498m()) {
            if (this.f1747F && (this.f1748G & 1) != 0) {
                this.f1763v.removeCallbacks(this.f1749H);
                this.f1749H.run();
            }
            PanelFeatureState a2 = m3502a(0, true);
            if (a2.f1718j != null && !a2.f1726r && n.onPreparePanel(0, a2.f1717i, a2.f1718j)) {
                n.onMenuOpened(C1317h.Theme_spinnerStyle, a2.f1718j);
                this.f1759r.showOverflowMenu();
            }
        }
    }

    private boolean m3514a(PanelFeatureState panelFeatureState) {
        panelFeatureState.m3458a(m3496k());
        panelFeatureState.f1715g = new bc(this, panelFeatureState.f1720l);
        panelFeatureState.f1711c = 81;
        return true;
    }

    private boolean m3515a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((panelFeatureState.f1721m || m3521b(panelFeatureState, keyEvent)) && panelFeatureState.f1718j != null) {
                z = panelFeatureState.f1718j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f1759r == null) {
                m3507a(panelFeatureState, true);
            }
        }
        return z;
    }

    private boolean m3517a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == this.f1763v || !(viewParent2 instanceof View) || cb.m2387F((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    private boolean m3520b(PanelFeatureState panelFeatureState) {
        Context c0429e;
        C0049i c0049i;
        Context context = this.a;
        if ((panelFeatureState.f1709a == 0 || panelFeatureState.f1709a == C1317h.Theme_spinnerStyle) && this.f1759r != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C0359b.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0359b.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0359b.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                c0429e = new C0429e(context, 0);
                c0429e.getTheme().setTo(theme3);
                c0049i = new C0049i(c0429e);
                c0049i.m101a((C0074j) this);
                panelFeatureState.m3459a(c0049i);
                return true;
            }
        }
        c0429e = context;
        c0049i = new C0049i(c0429e);
        c0049i.m101a((C0074j) this);
        panelFeatureState.m3459a(c0049i);
        return true;
    }

    private boolean m3521b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (m3498m()) {
            return false;
        }
        if (panelFeatureState.f1721m) {
            return true;
        }
        if (!(this.f1745D == null || this.f1745D == panelFeatureState)) {
            m3507a(this.f1745D, false);
        }
        Callback n = m3499n();
        if (n != null) {
            panelFeatureState.f1717i = n.onCreatePanelView(panelFeatureState.f1709a);
        }
        boolean z = panelFeatureState.f1709a == 0 || panelFeatureState.f1709a == C1317h.Theme_spinnerStyle;
        if (z && this.f1759r != null) {
            this.f1759r.setMenuPrepared();
        }
        if (panelFeatureState.f1717i == null && !(z && (m3495j() instanceof br))) {
            if (panelFeatureState.f1718j == null || panelFeatureState.f1726r) {
                if (panelFeatureState.f1718j == null && (!m3520b(panelFeatureState) || panelFeatureState.f1718j == null)) {
                    return false;
                }
                if (z && this.f1759r != null) {
                    if (this.f1760s == null) {
                        this.f1760s = new az();
                    }
                    this.f1759r.setMenu(panelFeatureState.f1718j, this.f1760s);
                }
                panelFeatureState.f1718j.m127g();
                if (n.onCreatePanelMenu(panelFeatureState.f1709a, panelFeatureState.f1718j)) {
                    panelFeatureState.f1726r = false;
                } else {
                    panelFeatureState.m3459a(null);
                    if (!z || this.f1759r == null) {
                        return false;
                    }
                    this.f1759r.setMenu(null, this.f1760s);
                    return false;
                }
            }
            panelFeatureState.f1718j.m127g();
            if (panelFeatureState.f1727s != null) {
                panelFeatureState.f1718j.m123d(panelFeatureState.f1727s);
                panelFeatureState.f1727s = null;
            }
            if (n.onPreparePanel(0, panelFeatureState.f1717i, panelFeatureState.f1718j)) {
                panelFeatureState.f1724p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
                panelFeatureState.f1718j.setQwertyMode(panelFeatureState.f1724p);
                panelFeatureState.f1718j.m128h();
            } else {
                if (z && this.f1759r != null) {
                    this.f1759r.setMenu(null, this.f1760s);
                }
                panelFeatureState.f1718j.m128h();
                return false;
            }
        }
        panelFeatureState.f1721m = true;
        panelFeatureState.f1722n = false;
        this.f1745D = panelFeatureState;
        return true;
    }

    private void m3523c(int i) {
        m3507a(m3502a(i, true), true);
    }

    private boolean m3525c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.f1717i != null) {
            panelFeatureState.f1716h = panelFeatureState.f1717i;
            return true;
        } else if (panelFeatureState.f1718j == null) {
            return false;
        } else {
            if (this.f1761t == null) {
                this.f1761t = new be();
            }
            panelFeatureState.f1716h = (View) panelFeatureState.m3457a(this.f1761t);
            return panelFeatureState.f1716h != null;
        }
    }

    private void m3526d(int i) {
        this.f1748G |= 1 << i;
        if (!this.f1747F && this.f1763v != null) {
            cb.m2402a(this.f1763v, this.f1749H);
            this.f1747F = true;
        }
    }

    private boolean m3528d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState a = m3502a(i, true);
            if (!a.f1723o) {
                return m3521b(a, keyEvent);
            }
        }
        return false;
    }

    private void m3529e(int i) {
        PanelFeatureState a = m3502a(i, true);
        if (a.f1718j != null) {
            Bundle bundle = new Bundle();
            a.f1718j.m118c(bundle);
            if (bundle.size() > 0) {
                a.f1727s = bundle;
            }
            a.f1718j.m127g();
            a.f1718j.clear();
        }
        a.f1726r = true;
        a.f1725q = true;
        if ((i == C1317h.Theme_spinnerStyle || i == 0) && this.f1759r != null) {
            a = m3502a(0, false);
            if (a != null) {
                a.f1721m = false;
                m3521b(a, null);
            }
        }
    }

    private boolean m3530e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.f1754m != null) {
            return false;
        }
        PanelFeatureState a = m3502a(i, true);
        if (i != 0 || this.f1759r == null || !this.f1759r.canShowOverflowMenu() || db.m2731b(ViewConfiguration.get(this.a))) {
            boolean z2;
            if (a.f1723o || a.f1722n) {
                z2 = a.f1723o;
                m3507a(a, true);
                z = z2;
            } else {
                if (a.f1721m) {
                    if (a.f1726r) {
                        a.f1721m = false;
                        z2 = m3521b(a, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        m3506a(a, keyEvent);
                    }
                }
                z = false;
            }
        } else if (this.f1759r.isOverflowMenuShowing()) {
            z = this.f1759r.hideOverflowMenu();
        } else {
            if (!m3498m() && m3521b(a, keyEvent)) {
                z = this.f1759r.showOverflowMenu();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private int m3531f(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.f1755n == null || !(this.f1755n.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1755n.getLayoutParams();
            if (this.f1755n.isShown()) {
                if (this.f1751J == null) {
                    this.f1751J = new Rect();
                    this.f1752K = new Rect();
                }
                Rect rect = this.f1751J;
                Rect rect2 = this.f1752K;
                rect.set(0, i, 0, 0);
                ViewUtils.computeFitSystemWindows(this.f1764w, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f1766y == null) {
                        this.f1766y = new View(this.a);
                        this.f1766y.setBackgroundColor(this.a.getResources().getColor(C0361d.abc_input_method_navigation_guard));
                        this.f1764w.addView(this.f1766y, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.f1766y.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f1766y.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.f1766y == null) {
                    i3 = 0;
                }
                if (!(this.j || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.f1755n.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.f1766y != null) {
            View view = this.f1766y;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private int m3532g(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return C1317h.Theme_spinnerStyle;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return C1317h.Theme_switchStyle;
        }
    }

    private void m3533q() {
        if (!this.f1762u) {
            this.f1764w = m3534r();
            CharSequence o = m3500o();
            if (!TextUtils.isEmpty(o)) {
                m3555b(o);
            }
            m3535s();
            m3548a(this.f1764w);
            this.f1762u = true;
            PanelFeatureState a = m3502a(0, false);
            if (!m3498m()) {
                if (a == null || a.f1718j == null) {
                    m3526d(C1317h.Theme_spinnerStyle);
                }
            }
        }
    }

    private ViewGroup m3534r() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0369l.Theme);
        if (obtainStyledAttributes.hasValue(C0369l.Theme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(C0369l.Theme_windowNoTitle, false)) {
                m3556b(1);
            } else if (obtainStyledAttributes.getBoolean(C0369l.Theme_windowActionBar, false)) {
                m3556b((int) C1317h.Theme_spinnerStyle);
            }
            if (obtainStyledAttributes.getBoolean(C0369l.Theme_windowActionBarOverlay, false)) {
                m3556b((int) C1317h.Theme_switchStyle);
            }
            if (obtainStyledAttributes.getBoolean(C0369l.Theme_windowActionModeOverlay, false)) {
                m3556b(10);
            }
            this.k = obtainStyledAttributes.getBoolean(C0369l.Theme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.l) {
                View view2 = this.j ? (ViewGroup) from.inflate(C0366i.abc_screen_simple_overlay_action_mode, null) : (ViewGroup) from.inflate(C0366i.abc_screen_simple, null);
                if (VERSION.SDK_INT >= 21) {
                    cb.m2401a(view2, new at(this));
                    view = view2;
                } else {
                    ((FitWindowsViewGroup) view2).setOnFitSystemWindowsListener(new au(this));
                    view = view2;
                }
            } else if (this.k) {
                r0 = (ViewGroup) from.inflate(C0366i.abc_dialog_title_material, null);
                this.i = false;
                this.h = false;
                view = r0;
            } else if (this.h) {
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(C0359b.actionBarTheme, typedValue, true);
                r0 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C0429e(this.a, typedValue.resourceId) : this.a).inflate(C0366i.abc_screen_toolbar, null);
                this.f1759r = (DecorContentParent) r0.findViewById(C0364g.decor_content_parent);
                this.f1759r.setWindowCallback(m3499n());
                if (this.i) {
                    this.f1759r.initFeature(C1317h.Theme_switchStyle);
                }
                if (this.f1767z) {
                    this.f1759r.initFeature(2);
                }
                if (this.f1742A) {
                    this.f1759r.initFeature(5);
                }
                view = r0;
            } else {
                view = null;
            }
            if (view == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
            }
            if (this.f1759r == null) {
                this.f1765x = (TextView) view.findViewById(C0364g.title);
            }
            ViewUtils.makeOptionalFitsSystemWindows(view);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(C0364g.action_bar_activity_content);
            while (viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                viewGroup.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            this.b.setContentView(view);
            viewGroup.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout) viewGroup).setForeground(null);
            }
            contentFrameLayout.setAttachListener(new av(this));
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void m3535s() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1764w.findViewById(16908290);
        contentFrameLayout.setDecorPadding(this.f1763v.getPaddingLeft(), this.f1763v.getPaddingTop(), this.f1763v.getPaddingRight(), this.f1763v.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0369l.Theme);
        obtainStyledAttributes.getValue(C0369l.Theme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0369l.Theme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0369l.Theme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0369l.Theme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0369l.Theme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0369l.Theme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0369l.Theme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0369l.Theme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0369l.Theme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0369l.Theme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void m3536t() {
        if (this.f1758q != null) {
            this.f1758q.m2805b();
        }
    }

    private void m3537u() {
        if (this.f1762u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void m3538v() {
        if (this.f1759r != null) {
            this.f1759r.dismissPopups();
        }
        if (this.f1756o != null) {
            this.f1763v.removeCallbacks(this.f1757p);
            if (this.f1756o.isShowing()) {
                try {
                    this.f1756o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f1756o = null;
        }
        m3536t();
        PanelFeatureState a = m3502a(0, false);
        if (a != null && a.f1718j != null) {
            a.f1718j.close();
        }
    }

    C0378b m3539a(C0376c c0376c) {
        C0378b c0378b;
        m3536t();
        if (this.f1754m != null) {
            this.f1754m.m3768c();
        }
        C0376c baVar = new ba(this, c0376c);
        if (this.e == null || m3498m()) {
            c0378b = null;
        } else {
            try {
                c0378b = this.e.m3590a(baVar);
            } catch (AbstractMethodError e) {
                c0378b = null;
            }
        }
        if (c0378b != null) {
            this.f1754m = c0378b;
        } else {
            if (this.f1755n == null) {
                if (this.k) {
                    Context c0429e;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.a.getTheme();
                    theme.resolveAttribute(C0359b.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        c0429e = new C0429e(this.a, 0);
                        c0429e.getTheme().setTo(newTheme);
                    } else {
                        c0429e = this.a;
                    }
                    this.f1755n = new ActionBarContextView(c0429e);
                    this.f1756o = new PopupWindow(c0429e, null, C0359b.actionModePopupWindowStyle);
                    ax.m3237a(this.f1756o, 2);
                    this.f1756o.setContentView(this.f1755n);
                    this.f1756o.setWidth(-1);
                    c0429e.getTheme().resolveAttribute(C0359b.actionBarSize, typedValue, true);
                    this.f1755n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c0429e.getResources().getDisplayMetrics()));
                    this.f1756o.setHeight(-2);
                    this.f1757p = new aw(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f1764w.findViewById(C0364g.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m3496k()));
                        this.f1755n = (ActionBarContextView) viewStubCompat.inflate();
                    }
                }
            }
            if (this.f1755n != null) {
                m3536t();
                this.f1755n.killMode();
                C0378b c0430f = new C0430f(this.f1755n.getContext(), this.f1755n, baVar, this.f1756o == null);
                if (c0376c.m3646a(c0430f, c0430f.m3765b())) {
                    c0430f.m3769d();
                    this.f1755n.initForMode(c0430f);
                    this.f1754m = c0430f;
                    cb.m2413c(this.f1755n, 0.0f);
                    this.f1758q = cb.m2442s(this.f1755n).m2798a(1.0f);
                    this.f1758q.m2800a(new ay(this));
                    if (this.f1756o != null) {
                        this.b.getDecorView().post(this.f1757p);
                    }
                } else {
                    this.f1754m = null;
                }
            }
        }
        if (!(this.f1754m == null || this.e == null)) {
            this.e.m3591a(this.f1754m);
        }
        return this.f1754m;
    }

    public final View m3540a(View view, String str, Context context, AttributeSet attributeSet) {
        View b = m3552b(view, str, context, attributeSet);
        return b != null ? b : m3559c(view, str, context, attributeSet);
    }

    public void m3541a(int i) {
        m3533q();
        ViewGroup viewGroup = (ViewGroup) this.f1764w.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    void m3542a(int i, Menu menu) {
        if (i == C1317h.Theme_spinnerStyle) {
            C0370a a = m3482a();
            if (a != null) {
                a.m3588f(false);
            }
        } else if (i == 0) {
            PanelFeatureState a2 = m3502a(i, true);
            if (a2.f1723o) {
                m3507a(a2, false);
            }
        }
    }

    public void m3543a(Configuration configuration) {
        if (this.h && this.f1762u) {
            C0370a a = m3482a();
            if (a != null) {
                a.m3571a(configuration);
            }
        }
    }

    public void m3544a(Bundle bundle) {
        this.f1763v = (ViewGroup) this.b.getDecorView();
        if ((this.c instanceof Activity) && az.m1122b((Activity) this.c) != null) {
            C0370a j = m3495j();
            if (j == null) {
                this.f1750I = true;
            } else {
                j.m3584d(true);
            }
        }
    }

    public void m3545a(Toolbar toolbar) {
        if (!(this.c instanceof Activity)) {
            return;
        }
        if (m3482a() instanceof by) {
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
        this.g = null;
        C0370a brVar = new br(toolbar, ((Activity) this.a).getTitle(), this.d);
        this.f = brVar;
        this.b.setCallback(brVar.m3710f());
        brVar.m3707d();
    }

    public void m3546a(View view) {
        m3533q();
        ViewGroup viewGroup = (ViewGroup) this.f1764w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void m3547a(View view, LayoutParams layoutParams) {
        m3533q();
        ViewGroup viewGroup = (ViewGroup) this.f1764w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void m3548a(ViewGroup viewGroup) {
    }

    boolean m3549a(int i, KeyEvent keyEvent) {
        C0370a a = m3482a();
        if (a != null && a.m3575a(i, keyEvent)) {
            return true;
        }
        if (this.f1745D == null || !m3515a(this.f1745D, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f1745D == null) {
                PanelFeatureState a2 = m3502a(0, true);
                m3521b(a2, keyEvent);
                boolean a3 = m3515a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f1721m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.f1745D == null) {
            return true;
        } else {
            this.f1745D.f1722n = true;
            return true;
        }
    }

    boolean m3550a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? m3561c(keyCode, keyEvent) : m3557b(keyCode, keyEvent);
    }

    public C0378b m3551b(C0376c c0376c) {
        if (c0376c == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f1754m != null) {
            this.f1754m.m3768c();
        }
        C0376c baVar = new ba(this, c0376c);
        C0370a a = m3482a();
        if (a != null) {
            this.f1754m = a.m3568a(baVar);
            if (!(this.f1754m == null || this.e == null)) {
                this.e.m3591a(this.f1754m);
            }
        }
        if (this.f1754m == null) {
            this.f1754m = m3539a(baVar);
        }
        return this.f1754m;
    }

    View m3552b(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    public void m3553b(Bundle bundle) {
        m3533q();
    }

    public void m3554b(View view, LayoutParams layoutParams) {
        m3533q();
        ((ViewGroup) this.f1764w.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void m3555b(CharSequence charSequence) {
        if (this.f1759r != null) {
            this.f1759r.setWindowTitle(charSequence);
        } else if (m3495j() != null) {
            m3495j().m3582c(charSequence);
        } else if (this.f1765x != null) {
            this.f1765x.setText(charSequence);
        }
    }

    public boolean m3556b(int i) {
        int g = m3532g(i);
        if (this.l && g == C1317h.Theme_spinnerStyle) {
            return false;
        }
        if (this.h && g == 1) {
            this.h = false;
        }
        switch (g) {
            case VideoSize.CIF /*1*/:
                m3537u();
                this.l = true;
                return true;
            case VideoSize.HVGA /*2*/:
                m3537u();
                this.f1767z = true;
                return true;
            case Version.API05_ECLAIR_20 /*5*/:
                m3537u();
                this.f1742A = true;
                return true;
            case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                m3537u();
                this.j = true;
                return true;
            case C1317h.Theme_spinnerStyle /*108*/:
                m3537u();
                this.h = true;
                return true;
            case C1317h.Theme_switchStyle /*109*/:
                m3537u();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(g);
        }
    }

    boolean m3557b(int i, KeyEvent keyEvent) {
        switch (i) {
            case Version.API04_DONUT_16 /*4*/:
                boolean z = this.f1746E;
                this.f1746E = false;
                PanelFeatureState a = m3502a(0, false);
                if (a == null || !a.f1723o) {
                    if (m3566p()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    m3507a(a, true);
                    return true;
                }
                break;
            case C1317h.Theme_colorPrimary /*82*/:
                m3530e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean m3558b(int i, Menu menu) {
        if (i != C1317h.Theme_spinnerStyle) {
            return false;
        }
        C0370a a = m3482a();
        if (a == null) {
            return true;
        }
        a.m3588f(true);
        return true;
    }

    public View m3559c(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = VERSION.SDK_INT < 21;
        if (this.f1753L == null) {
            this.f1753L = new bg();
        }
        boolean z2 = z && this.f1762u && m3517a((ViewParent) view);
        return this.f1753L.m3662a(view, str, context, attributeSet, z2, z, true);
    }

    public void m3560c() {
        C0370a a = m3482a();
        if (a != null) {
            a.m3586e(false);
        }
    }

    boolean m3561c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case Version.API04_DONUT_16 /*4*/:
                if ((keyEvent.getFlags() & 128) == 0) {
                    z = false;
                }
                this.f1746E = z;
                break;
            case C1317h.Theme_colorPrimary /*82*/:
                m3528d(0, keyEvent);
                return true;
        }
        if (VERSION.SDK_INT < 11) {
            m3549a(i, keyEvent);
        }
        return false;
    }

    public void m3562d() {
        C0370a a = m3482a();
        if (a != null) {
            a.m3586e(true);
        }
    }

    public void m3563e() {
        C0370a a = m3482a();
        if (a == null || !a.m3585d()) {
            m3526d(0);
        }
    }

    public void m3564h() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            ah.m2224a(from, this);
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void m3565i() {
        m3533q();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new by((Activity) this.c, this.i);
            } else if (this.c instanceof Dialog) {
                this.f = new by((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.m3584d(this.f1750I);
            }
        }
    }

    public boolean onMenuItemSelected(C0049i c0049i, MenuItem menuItem) {
        Callback n = m3499n();
        if (!(n == null || m3498m())) {
            PanelFeatureState a = m3504a(c0049i.m136p());
            if (a != null) {
                return n.onMenuItemSelected(a.f1709a, menuItem);
            }
        }
        return false;
    }

    public void onMenuModeChange(C0049i c0049i) {
        m3513a(c0049i, true);
    }

    boolean m3566p() {
        if (this.f1754m != null) {
            this.f1754m.m3768c();
            return true;
        }
        C0370a a = m3482a();
        return a != null && a.m3587e();
    }
}
