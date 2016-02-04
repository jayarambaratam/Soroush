package mobi.mmdt.ott.view.main;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.p019a.C0363f;
import android.view.MenuItem;
import com.cocosw.bottomsheet.C1003l;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.logic.p157e.p159b.C1510a;
import mobi.mmdt.ott.logic.p157e.p159b.C1511b;
import mobi.mmdt.ott.p086a.C1136d;
import mobi.mmdt.ott.view.main.basenavigation.C2285a;
import mobi.mmdt.ott.view.main.basenavigation.C2322s;
import mobi.mmdt.ott.view.main.basenavigation.aa;
import mobi.mmdt.ott.view.main.basenavigation.ac;
import mobi.mmdt.ott.view.main.p235a.C2286d;
import mobi.mmdt.ott.view.main.p235a.C2291a;
import mobi.mmdt.ott.view.main.p236b.C2287e;
import mobi.mmdt.ott.view.main.p236b.C2298a;
import mobi.mmdt.ott.view.main.p237c.C2288q;
import mobi.mmdt.ott.view.main.p237c.C2347a;
import mobi.mmdt.ott.view.main.p238d.C2289m;
import mobi.mmdt.ott.view.main.p238d.C2369a;
import mobi.mmdt.ott.view.p178a.C1659a;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class MainActivity extends C2285a implements C2286d, C2287e, C2288q, C2289m {
    public static boolean f7558i;
    private LoaderCallbacks<Cursor> f7559C;
    private boolean f7560D;

    static {
        f7558i = false;
    }

    public MainActivity() {
        this.f7559C = new C2383d(this);
        this.f7560D = false;
    }

    private void m10345p() {
        new Handler().postDelayed(new C2391l(this), 10);
    }

    private void m10349r() {
        new Handler().postDelayed(new C2392m(this), 10);
    }

    private void m10351s() {
        new Handler().postDelayed(new C2393n(this), 10);
    }

    private void m10353t() {
        new Handler().postDelayed(new C2394o(this), 10);
    }

    private void m10354u() {
        this.B.clear();
        this.B.put(Integer.valueOf(ac.CENTER.ordinal()), getString(C1136d.app_name));
        this.B.put(Integer.valueOf(ac.TOP.ordinal()), getString(2131230825));
        this.B.put(Integer.valueOf(ac.BOTTOM.ordinal()), getString(2131230915));
        this.B.put(Integer.valueOf(ac.LEFT.ordinal()), getString(2131230812));
        this.B.put(Integer.valueOf(ac.RIGHT.ordinal()), getString(2131230823));
        this.r = C2298a.m10399a((Activity) this, (C2287e) this);
        this.q = C2291a.m10383a((Activity) this, (C2286d) this);
        this.t = C2347a.m10507a((Activity) this, (C2288q) this);
        this.u = C2369a.m10550a((Activity) this, (C2289m) this);
        this.s = C2322s.m10436a((Activity) this, (aa) this);
    }

    private void m10355v() {
        new C1003l(this).m6120a(2131755032).m6121a(new C2366c(this)).m6119a().show();
    }

    protected void m10356a(FloatingActionButton floatingActionButton, ac acVar) {
        switch (C2387h.f7854a[acVar.ordinal()]) {
            case VideoSize.CIF /*1*/:
                floatingActionButton.setOnClickListener(new C2296a(this));
                floatingActionButton.setImageResource(2130838498);
            case VideoSize.HVGA /*2*/:
                floatingActionButton.setOnClickListener(new C2388i(this));
                floatingActionButton.setImageResource(2130838506);
            case Version.API03_CUPCAKE_15 /*3*/:
                floatingActionButton.setOnClickListener(null);
            case Version.API04_DONUT_16 /*4*/:
                floatingActionButton.setOnClickListener(null);
                floatingActionButton.setImageResource(C0363f.abc_btn_rating_star_on_mtrl_alpha);
            case Version.API05_ECLAIR_20 /*5*/:
                floatingActionButton.setOnClickListener(new C2389j(this));
                floatingActionButton.setImageResource(2130838580);
            default:
        }
    }

    public void m10357b(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131689967:
                m10345p();
            case 2131689968:
                m10349r();
            case 2131689969:
                m10353t();
            case 2131689970:
                C1659a.m8444c(m8494q());
            case 2131689971:
                new Handler().postDelayed(new C2304b(this), 10);
            case 2131689972:
                new Handler().postDelayed(new C2396q(this), 10);
            case 2131689973:
                new Handler().postDelayed(new C2395p(this), 10);
            default:
        }
    }

    protected void m10358l() {
        m10320o();
        C1659a.m8427a(m8494q());
    }

    public void m10359m() {
        m10313a(50);
    }

    public void m10360n() {
        m10317b(50);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f7558i = false;
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            if (getIntent().getExtras().getBoolean("KEY_ANIMATION_START", false)) {
                getIntent().removeExtra("KEY_ANIMATION_START");
                f7558i = true;
            } else {
                if (getIntent().getExtras().containsKey("KEY_PAGE_START")) {
                    this.A = ac.values()[getIntent().getExtras().getInt("KEY_PAGE_START")];
                }
                if (getIntent().getExtras().containsKey("KEY_START_SINGLE_PARTY")) {
                    C1659a.m8432a(m8494q(), getIntent().getStringExtra("KEY_START_SINGLE_PARTY"), false);
                    getIntent().removeExtra("KEY_START_SINGLE_PARTY");
                } else if (getIntent().getExtras().containsKey("KEY_START_GROUP_PARTY")) {
                    C1659a.m8441b(m8494q(), getIntent().getStringExtra("KEY_START_GROUP_PARTY"), false);
                    getIntent().removeExtra("KEY_START_GROUP_PARTY");
                } else if (getIntent().getExtras().containsKey("KEY_START_CHANNEL_PARTY")) {
                    C1659a.m8447c(m8494q(), getIntent().getStringExtra("KEY_START_CHANNEL_PARTY"), false);
                    getIntent().removeExtra("KEY_START_CHANNEL_PARTY");
                }
                getIntent().removeExtra("KEY_PAGE_START");
            }
        }
        getLoaderManager().initLoader(18, null, this.f7559C);
        if (!C1113a.m6422a(getApplicationContext())) {
            C1659a.m8442b(getApplicationContext());
            finish();
        }
    }

    public void onEvent(C1510a c1510a) {
        if (m8494q() != null && this.s != null) {
            runOnUiThread(new C2386g(this, c1510a));
        }
    }

    public void onEvent(C1511b c1511b) {
        if (m8494q() != null && this.s != null) {
            runOnUiThread(new C2385f(this, c1511b));
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && intent.getExtras() != null) {
            if (intent.getExtras().containsKey("KEY_PAGE_START")) {
                m10315a(ac.values()[intent.getExtras().getInt("KEY_PAGE_START")], false);
            }
            if (intent.getExtras().containsKey("KEY_START_SINGLE_PARTY")) {
                C1659a.m8432a(m8494q(), intent.getStringExtra("KEY_START_SINGLE_PARTY"), false);
                intent.removeExtra("KEY_START_SINGLE_PARTY");
            } else if (intent.getExtras().containsKey("KEY_START_GROUP_PARTY")) {
                C1659a.m8441b(m8494q(), intent.getStringExtra("KEY_START_GROUP_PARTY"), false);
                intent.removeExtra("KEY_START_GROUP_PARTY");
            } else if (intent.getExtras().containsKey("KEY_START_CHANNEL_PARTY")) {
                C1659a.m8447c(m8494q(), intent.getStringExtra("KEY_START_CHANNEL_PARTY"), false);
                intent.removeExtra("KEY_START_CHANNEL_PARTY");
            }
            intent.removeExtra("KEY_PAGE_START");
        }
    }

    protected void onPause() {
        super.onPause();
        f7558i = false;
    }

    public void onPostCreate(Bundle bundle) {
        m10354u();
        super.onPostCreate(bundle);
    }
}
