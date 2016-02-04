package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p007d.p008a.C0199b;
import android.support.v4.view.C0319n;
import android.support.v4.view.bc;
import android.support.v7.widget.TintManager;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import net.frakbot.glowpadbackport.BuildConfig;
import org.apache.http.myHttp.protocol.HTTP;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: android.support.v7.view.menu.m */
public final class C0448m implements C0199b {
    private static String f2177w;
    private static String f2178x;
    private static String f2179y;
    private static String f2180z;
    private final int f2181a;
    private final int f2182b;
    private final int f2183c;
    private final int f2184d;
    private CharSequence f2185e;
    private CharSequence f2186f;
    private Intent f2187g;
    private char f2188h;
    private char f2189i;
    private Drawable f2190j;
    private int f2191k;
    private C0049i f2192l;
    private ad f2193m;
    private Runnable f2194n;
    private OnMenuItemClickListener f2195o;
    private int f2196p;
    private int f2197q;
    private View f2198r;
    private C0319n f2199s;
    private bc f2200t;
    private boolean f2201u;
    private ContextMenuInfo f2202v;

    C0448m(C0049i c0049i, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f2191k = 0;
        this.f2196p = 16;
        this.f2197q = 0;
        this.f2201u = false;
        this.f2192l = c0049i;
        this.f2181a = i2;
        this.f2182b = i;
        this.f2183c = i3;
        this.f2184d = i4;
        this.f2185e = charSequence;
        this.f2197q = i5;
    }

    public C0199b m4057a(int i) {
        Context e = this.f2192l.m125e();
        m4060a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public C0199b m4058a(bc bcVar) {
        this.f2200t = bcVar;
        return this;
    }

    public C0199b m4059a(C0319n c0319n) {
        if (this.f2199s != null) {
            this.f2199s.reset();
        }
        this.f2198r = null;
        this.f2199s = c0319n;
        this.f2192l.m107a(true);
        if (this.f2199s != null) {
            this.f2199s.setVisibilityListener(new C0449n(this));
        }
        return this;
    }

    public C0199b m4060a(View view) {
        this.f2198r = view;
        this.f2199s = null;
        if (view != null && view.getId() == -1 && this.f2181a > 0) {
            view.setId(this.f2181a);
        }
        this.f2192l.m113b(this);
        return this;
    }

    public C0319n m4061a() {
        return this.f2199s;
    }

    CharSequence m4062a(aa aaVar) {
        return (aaVar == null || !aaVar.m76b()) ? getTitle() : getTitleCondensed();
    }

    public void m4063a(ad adVar) {
        this.f2193m = adVar;
        adVar.setHeaderTitle(getTitle());
    }

    void m4064a(ContextMenuInfo contextMenuInfo) {
        this.f2202v = contextMenuInfo;
    }

    public void m4065a(boolean z) {
        this.f2196p = (z ? 4 : 0) | (this.f2196p & -5);
    }

    public C0199b m4066b(int i) {
        setShowAsAction(i);
        return this;
    }

    void m4067b(boolean z) {
        int i = this.f2196p;
        this.f2196p = (z ? 2 : 0) | (this.f2196p & -3);
        if (i != this.f2196p) {
            this.f2192l.m107a(false);
        }
    }

    public boolean m4068b() {
        if ((this.f2195o != null && this.f2195o.onMenuItemClick(this)) || this.f2192l.m108a(this.f2192l.m136p(), (MenuItem) this)) {
            return true;
        }
        if (this.f2194n != null) {
            this.f2194n.run();
            return true;
        }
        if (this.f2187g != null) {
            try {
                this.f2192l.m125e().startActivity(this.f2187g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.f2199s != null && this.f2199s.onPerformDefaultAction();
    }

    public int m4069c() {
        return this.f2184d;
    }

    boolean m4070c(boolean z) {
        int i = this.f2196p;
        this.f2196p = (z ? 0 : 8) | (this.f2196p & -9);
        return i != this.f2196p;
    }

    public boolean collapseActionView() {
        return (this.f2197q & 8) == 0 ? false : this.f2198r == null ? true : (this.f2200t == null || this.f2200t.m2302b(this)) ? this.f2192l.m124d(this) : false;
    }

    char m4071d() {
        return this.f2192l.m116b() ? this.f2189i : this.f2188h;
    }

    public void m4072d(boolean z) {
        if (z) {
            this.f2196p |= 32;
        } else {
            this.f2196p &= -33;
        }
    }

    String m4073e() {
        char d = m4071d();
        if (d == '\u0000') {
            return BuildConfig.FLAVOR;
        }
        StringBuilder stringBuilder = new StringBuilder(f2177w);
        switch (d) {
            case Version.API08_FROYO_22 /*8*/:
                stringBuilder.append(f2179y);
                break;
            case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                stringBuilder.append(f2178x);
                break;
            case HTTP.SP /*32*/:
                stringBuilder.append(f2180z);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    public void m4074e(boolean z) {
        this.f2201u = z;
        this.f2192l.m107a(false);
    }

    public boolean expandActionView() {
        return !m4083n() ? false : (this.f2200t == null || this.f2200t.m2301a(this)) ? this.f2192l.m121c(this) : false;
    }

    boolean m4075f() {
        return this.f2192l.m120c() && m4071d() != '\u0000';
    }

    public boolean m4076g() {
        return (this.f2196p & 4) != 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        if (this.f2198r != null) {
            return this.f2198r;
        }
        if (this.f2199s == null) {
            return null;
        }
        this.f2198r = this.f2199s.onCreateActionView(this);
        return this.f2198r;
    }

    public char getAlphabeticShortcut() {
        return this.f2189i;
    }

    public int getGroupId() {
        return this.f2182b;
    }

    public Drawable getIcon() {
        if (this.f2190j != null) {
            return this.f2190j;
        }
        if (this.f2191k == 0) {
            return null;
        }
        Drawable drawable = TintManager.getDrawable(this.f2192l.m125e(), this.f2191k);
        this.f2191k = 0;
        this.f2190j = drawable;
        return drawable;
    }

    public Intent getIntent() {
        return this.f2187g;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f2181a;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f2202v;
    }

    public char getNumericShortcut() {
        return this.f2188h;
    }

    public int getOrder() {
        return this.f2183c;
    }

    public SubMenu getSubMenu() {
        return this.f2193m;
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f2185e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2186f != null ? this.f2186f : this.f2185e;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public void m4077h() {
        this.f2192l.m113b(this);
    }

    public boolean hasSubMenu() {
        return this.f2193m != null;
    }

    public boolean m4078i() {
        return this.f2192l.m137q();
    }

    public boolean isActionViewExpanded() {
        return this.f2201u;
    }

    public boolean isCheckable() {
        return (this.f2196p & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f2196p & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f2196p & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f2199s == null || !this.f2199s.overridesItemVisibility()) ? (this.f2196p & 8) == 0 : (this.f2196p & 8) == 0 && this.f2199s.isVisible();
    }

    public boolean m4079j() {
        return (this.f2196p & 32) == 32;
    }

    public boolean m4080k() {
        return (this.f2197q & 1) == 1;
    }

    public boolean m4081l() {
        return (this.f2197q & 2) == 2;
    }

    public boolean m4082m() {
        return (this.f2197q & 4) == 4;
    }

    public boolean m4083n() {
        if ((this.f2197q & 8) == 0) {
            return false;
        }
        if (this.f2198r == null && this.f2199s != null) {
            this.f2198r = this.f2199s.onCreateActionView(this);
        }
        return this.f2198r != null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m4057a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m4060a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f2189i != c) {
            this.f2189i = Character.toLowerCase(c);
            this.f2192l.m107a(false);
        }
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f2196p;
        this.f2196p = (z ? 1 : 0) | (this.f2196p & -2);
        if (i != this.f2196p) {
            this.f2192l.m107a(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f2196p & 4) != 0) {
            this.f2192l.m105a((MenuItem) this);
        } else {
            m4067b(z);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f2196p |= 16;
        } else {
            this.f2196p &= -17;
        }
        this.f2192l.m107a(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f2190j = null;
        this.f2191k = i;
        this.f2192l.m107a(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f2191k = 0;
        this.f2190j = drawable;
        this.f2192l.m107a(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f2187g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f2188h != c) {
            this.f2188h = c;
            this.f2192l.m107a(false);
        }
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2195o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f2188h = c;
        this.f2189i = Character.toLowerCase(c2);
        this.f2192l.m107a(false);
        return this;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case VideoSize.QCIF /*0*/:
            case VideoSize.CIF /*1*/:
            case VideoSize.HVGA /*2*/:
                this.f2197q = i;
                this.f2192l.m113b(this);
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m4066b(i);
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f2192l.m125e().getString(i));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f2185e = charSequence;
        this.f2192l.m107a(false);
        if (this.f2193m != null) {
            this.f2193m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2186f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f2185e;
        }
        this.f2192l.m107a(false);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        if (m4070c(z)) {
            this.f2192l.m102a(this);
        }
        return this;
    }

    public String toString() {
        return this.f2185e != null ? this.f2185e.toString() : null;
    }
}
