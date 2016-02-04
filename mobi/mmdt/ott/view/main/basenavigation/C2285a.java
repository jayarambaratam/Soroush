package mobi.mmdt.ott.view.main.basenavigation;

import android.app.SearchManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.au;
import android.support.v4.view.dz;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.C0380e;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.p086a.C1136d;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.main.MainActivity;
import mobi.mmdt.ott.view.main.basenavigation.viewpager.HorizontalSwipeControlViewPager;
import mobi.mmdt.ott.view.main.basenavigation.viewpager.VerticalSwipeControlViewPager;
import org.apache.http.myHttp.HttpStatus;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.a */
public abstract class C2285a extends C1685b implements au, aa {
    protected ac f7530A;
    protected Map<Integer, String> f7531B;
    private DrawerLayout f7532C;
    private NavigationView f7533D;
    private Toolbar f7534E;
    private SearchView f7535F;
    private FloatingActionButton f7536G;
    private ac f7537H;
    private MenuItem f7538I;
    private dz f7539J;
    private HorizontalSwipeControlViewPager f7540i;
    protected List<View> f7541j;
    protected List<View> f7542k;
    protected C2320q f7543l;
    protected C2321r f7544m;
    protected VerticalSwipeControlViewPager f7545n;
    protected C0380e f7546o;
    protected CoordinatorLayout f7547p;
    protected ab f7548q;
    protected ab f7549r;
    protected ab f7550s;
    protected ab f7551t;
    protected ab f7552u;
    protected RoundAvatarImageView f7553v;
    protected TextView f7554w;
    protected TextView f7555x;
    protected ImageView f7556y;
    protected boolean f7557z;

    public C2285a() {
        this.f7541j = new ArrayList();
        this.f7542k = new ArrayList();
        this.f7557z = true;
        this.f7537H = ac.CENTER;
        this.f7530A = ac.CENTER;
        this.f7531B = new HashMap();
        this.f7539J = new C2318o(this);
    }

    private void m10301b(ac acVar) {
        switch (C2309f.f7624a[acVar.ordinal()]) {
            case VideoSize.CIF /*1*/:
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                if (this.f7538I != null) {
                    this.f7538I.setVisible(true);
                }
            case Version.API04_DONUT_16 /*4*/:
            case Version.API05_ECLAIR_20 /*5*/:
                if (this.f7538I != null) {
                    this.f7538I.setVisible(false);
                }
            default:
        }
    }

    private void m10302b(boolean z) {
        if (this.f7540i != null) {
            this.f7540i.setPagingEnabled(z);
        }
        this.f7557z = z;
        this.f7546o.m3807a(this.f7557z);
        this.f7546o.m3800a();
    }

    private void m10306c(ac acVar) {
        switch (C2309f.f7624a[acVar.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f7537H = ac.TOP;
                m10314a(this.f7536G, ac.TOP);
                m10313a((int) HttpStatus.SC_MULTIPLE_CHOICES);
                m8492e(m10312a(ac.TOP));
                this.f7532C.setDrawerLockMode(1);
                m10301b(ac.TOP);
            case VideoSize.HVGA /*2*/:
                this.f7537H = ac.BOTTOM;
                m10314a(this.f7536G, ac.BOTTOM);
                m10313a((int) HttpStatus.SC_MULTIPLE_CHOICES);
                m8492e(m10312a(ac.BOTTOM));
                this.f7532C.setDrawerLockMode(1);
                m10301b(ac.BOTTOM);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f7537H = ac.CENTER;
                m10314a(this.f7536G, ac.CENTER);
                m10317b((int) HttpStatus.SC_MULTIPLE_CHOICES);
                m8492e(m10312a(ac.CENTER));
                this.f7532C.setDrawerLockMode(0);
                m10301b(ac.CENTER);
            default:
        }
    }

    private void m10308m() {
        m8492e(m10312a(this.f7537H));
        if (this.f7537H == ac.CENTER) {
            m10314a(this.f7536G, ac.CENTER);
        } else if (this.f7537H == ac.TOP) {
            this.f7540i.setPagingEnabled(false);
        } else if (this.f7537H == ac.BOTTOM) {
            this.f7540i.setPagingEnabled(false);
        } else if (this.f7537H == ac.LEFT) {
            m10314a(this.f7536G, ac.LEFT);
        } else if (this.f7537H == ac.RIGHT) {
            m10314a(this.f7536G, ac.RIGHT);
        }
    }

    private void m10309n() {
        this.f7547p = (CoordinatorLayout) findViewById(2131689659);
        this.f7536G = (FloatingActionButton) findViewById(2131689681);
        this.f7532C = (DrawerLayout) findViewById(2131689679);
        this.f7533D = (NavigationView) findViewById(2131689680);
        View b = this.f7533D.m371b(2130968781);
        this.f7556y = (ImageView) b.findViewById(2131689918);
        this.f7554w = (TextView) b.findViewById(2131689921);
        this.f7555x = (TextView) b.findViewById(2131689922);
        this.f7553v = (RoundAvatarImageView) b.findViewById(2131689920);
        this.f7546o = new C0380e(this, this.f7532C, 2131230837, 2131230836);
        this.f7546o.m3809b(2130838526);
        this.f7532C.setDrawerListener(this.f7546o);
        this.f7533D.setNavigationItemSelectedListener(this);
        b.setOnClickListener(new C2305b(this));
    }

    private void m10310p() {
        this.f7545n = (VerticalSwipeControlViewPager) LayoutInflater.from(m8494q()).inflate(2130968756, null, false);
        this.f7542k.add(this.f7548q.m10382c());
        this.f7542k.add(this.f7545n);
        this.f7542k.add(this.f7549r.m10382c());
        this.f7541j.add(this.f7551t.m10382c());
        this.f7541j.add(this.f7550s.m10382c());
        this.f7541j.add(this.f7552u.m10382c());
        this.f7544m = new C2321r(this);
        this.f7545n.setAdapter(this.f7544m);
        this.f7545n.setCurrentItem(1);
        this.f7545n.setOnPageChangeListener(new C2310g(this));
        this.f7543l = new C2320q(this);
        this.f7540i = (HorizontalSwipeControlViewPager) findViewById(2131689672);
        this.f7540i.setAdapter(this.f7543l);
        this.f7540i.setOffscreenPageLimit(3);
        if (this.f7537H == ac.LEFT) {
            this.f7540i.setCurrentItem(0);
            m10313a((int) HttpStatus.SC_MULTIPLE_CHOICES);
            this.f7557z = false;
            this.f7546o.m3807a(this.f7557z);
            this.f7546o.m3800a();
        } else if (this.f7537H == ac.RIGHT) {
            this.f7540i.setCurrentItem(2);
            m10313a((int) HttpStatus.SC_MULTIPLE_CHOICES);
            this.f7557z = false;
            this.f7546o.m3807a(this.f7557z);
            this.f7546o.m3800a();
        } else {
            this.f7540i.setCurrentItem(1);
        }
        this.f7540i.setOnPageChangeListener(this.f7539J);
        m10311r();
    }

    private void m10311r() {
        if (this.f7530A != ac.CENTER) {
            MainActivity.f7558i = false;
            switch (C2309f.f7624a[this.f7530A.ordinal()]) {
                case VideoSize.CIF /*1*/:
                    this.f7545n.post(new C2319p(this));
                case VideoSize.HVGA /*2*/:
                    this.f7545n.post(new C2306c(this));
                case Version.API03_CUPCAKE_15 /*3*/:
                    this.f7540i.post(new C2308e(this));
                case Version.API04_DONUT_16 /*4*/:
                    this.f7540i.post(new C2307d(this));
                default:
            }
        }
    }

    public String m10312a(ac acVar) {
        return (String) this.f7531B.get(Integer.valueOf(acVar.ordinal()));
    }

    protected void m10313a(int i) {
        new Handler().postDelayed(new C2314k(this), (long) i);
    }

    protected abstract void m10314a(FloatingActionButton floatingActionButton, ac acVar);

    public void m10315a(ac acVar, boolean z) {
        switch (C2309f.f7624a[acVar.ordinal()]) {
            case VideoSize.CIF /*1*/:
                if (this.f7537H == ac.LEFT || this.f7537H == ac.RIGHT) {
                    this.f7540i.m1849a(1, z);
                }
                this.f7545n.m10483a(0, z);
            case VideoSize.HVGA /*2*/:
                if (this.f7537H == ac.LEFT || this.f7537H == ac.RIGHT) {
                    this.f7540i.m1849a(1, z);
                }
                this.f7545n.m10483a(2, z);
            case Version.API03_CUPCAKE_15 /*3*/:
                if (this.f7537H == ac.TOP || this.f7537H == ac.BOTTOM) {
                    this.f7545n.m10483a(1, z);
                }
                this.f7540i.m1849a(2, z);
            case Version.API04_DONUT_16 /*4*/:
                if (this.f7537H == ac.TOP || this.f7537H == ac.BOTTOM) {
                    this.f7545n.m10483a(1, z);
                }
                this.f7540i.m1849a(0, z);
            case Version.API05_ECLAIR_20 /*5*/:
                if (this.f7537H == ac.TOP || this.f7537H == ac.BOTTOM) {
                    this.f7545n.m10483a(1, z);
                }
                if (this.f7537H == ac.LEFT || this.f7537H == ac.RIGHT) {
                    this.f7540i.m1849a(1, z);
                }
            default:
        }
    }

    public boolean m10316a(MenuItem menuItem) {
        this.f7532C.m2991i(this.f7533D);
        m10318b(menuItem);
        return true;
    }

    protected void m10317b(int i) {
        new Handler().postDelayed(new C2316m(this), (long) i);
    }

    public abstract void m10318b(MenuItem menuItem);

    protected abstract void m10319l();

    protected void m10320o() {
        this.f7532C.m2991i(this.f7533D);
    }

    public void onBackPressed() {
        if (this.f7535F != null && !this.f7535F.isIconified()) {
            this.f7535F.setIconified(true);
        } else if (this.f7557z) {
            if (this.f7532C == null || !this.f7532C.m2992j(this.f7533D)) {
                super.onBackPressed();
            } else {
                this.f7532C.m2991i(this.f7533D);
            }
        } else if (this.f7540i != null && this.f7540i.getCurrentItem() != 1) {
            this.f7540i.m1849a(1, true);
        } else if (this.f7545n != null) {
            this.f7545n.m10483a(1, true);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f7546o.m3802a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968617);
        this.f7534E = (Toolbar) findViewById(2131689633);
        m3618a(this.f7534E);
        m10309n();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755049, menu);
        this.f7538I = menu.findItem(2131689998);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        if (this.f7538I != null) {
            this.f7535F = (SearchView) this.f7538I.getActionView();
        }
        if (this.f7535F != null) {
            this.f7535F.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        }
        this.f7535F.setOnSearchClickListener(new C2311h(this));
        this.f7535F.setOnCloseListener(new C2312i(this));
        this.f7535F.setImeOptions(this.f7535F.getImeOptions() | 268435456);
        this.f7535F.setOnQueryTextListener(new C2313j(this));
        m10301b(this.f7537H);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (!this.f7557z) {
                onBackPressed();
            } else if (this.f7532C.m2992j(this.f7533D)) {
                this.f7532C.m2991i(this.f7533D);
            } else {
                this.f7532C.m2990h(this.f7533D);
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m8491e((int) C1136d.app_name);
        this.f7546o.m3800a();
        m10310p();
        if (bundle != null && bundle.getBoolean("BaseNavigationActivity_KEY_IS_RECREATED_VIEWS", true)) {
            m10308m();
        }
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null && bundle.containsKey("BaseNavigationActivity_KEY_CURRENT_PAGING_LOCATION")) {
            this.f7537H = ac.values()[bundle.getInt("BaseNavigationActivity_KEY_CURRENT_PAGING_LOCATION")];
            this.f7530A = this.f7537H;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("BaseNavigationActivity_KEY_CURRENT_PAGING_LOCATION", this.f7537H.ordinal());
        bundle.putBoolean("BaseNavigationActivity_KEY_IS_RECREATED_VIEWS", true);
    }
}
