package mobi.mmdt.ott.view.registeration.profileinfo;

import android.annotation.SuppressLint;
import android.app.LoaderManager.LoaderCallbacks;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.RelativeLayout;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p144c.p145a.C1441a;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p144c.p145a.C1442b;
import mobi.mmdt.ott.logic.p112a.p147h.p148a.C1448c;
import mobi.mmdt.ott.logic.p112a.p147h.p148a.C1449d;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.components.C1711a;
import net.frakbot.glowpadbackport.BuildConfig;

public class ProfileInfoActivity extends C1711a {
    private String f8067A;
    private boolean f8068B;
    private LoaderCallbacks<Cursor> f8069C;
    protected int f8070o;
    protected boolean f8071p;
    protected boolean f8072q;
    protected boolean f8073r;
    protected EditText f8074s;
    protected EditText f8075t;
    protected EditText f8076u;
    protected boolean f8077v;
    private TextInputLayout f8078w;
    private String f8079x;
    private String f8080y;
    private String f8081z;

    public ProfileInfoActivity() {
        this.f8070o = 2130968743;
        this.f8071p = false;
        this.f8072q = false;
        this.f8073r = false;
        this.f8068B = false;
        this.f8069C = new C2508u(this);
    }

    private void m10824s() {
        this.f8078w = (TextInputLayout) findViewById(2131689882);
        this.f8074s = (EditText) findViewById(2131689883);
        this.f8075t = (EditText) findViewById(2131689835);
        this.f8076u = (EditText) findViewById(2131689837);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131689635);
        this.f8074s.setFilters(new InputFilter[]{new LengthFilter(128)});
        this.f8075t.setFilters(new InputFilter[]{new LengthFilter(256)});
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.height = (int) (((float) (point.y - (C1111c.m6401b(getApplicationContext()) + C1111c.m6406c(getApplicationContext())))) + C1111c.m6388a(getApplicationContext(), 10.0f));
        if (getResources().getConfiguration().orientation == 2) {
            layoutParams.width = (int) (((double) point.x) * 0.75d);
        }
        String b = C1309a.m6934a(getApplicationContext()).m6942b();
        this.f8076u.setText(b);
        m8563c(C1111c.m6402b(getApplicationContext(), b));
    }

    private void m10825t() {
        runOnUiThread(new C2489b(this));
    }

    private void m10826u() {
        runOnUiThread(new C2492e(this));
    }

    protected void m10827b(boolean z) {
    }

    protected int m10828l() {
        return 2130838595;
    }

    protected void m10829m() {
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8557a(bundle, this.f8071p);
        m8556a(this.f8070o);
        this.f8079x = BuildConfig.FLAVOR;
        m8559a(getString(2131230911));
        m8563c(C1111c.m6402b(getApplicationContext(), C1309a.m6934a(getApplicationContext()).m6942b()));
        if (bundle != null) {
            if (bundle.containsKey("KEY_IS_PROFILE_FETCHED")) {
                this.f8068B = bundle.getBoolean("KEY_IS_PROFILE_FETCHED");
            }
            if (bundle.containsKey("KEY_AVATAR_URL")) {
                this.f8081z = bundle.getString("KEY_AVATAR_URL");
            }
            if (bundle.containsKey("KEY_AVATAR_THUMBNAIL_URL")) {
                this.f8067A = bundle.getString("KEY_AVATAR_THUMBNAIL_URL");
            }
            if (bundle.containsKey("KEY_MOTTO")) {
                this.f8080y = bundle.getString("KEY_MOTTO");
            }
            if (bundle.containsKey("KEY_CONTACT_NAME")) {
                this.f8079x = bundle.getString("KEY_CONTACT_NAME");
            }
            if (bundle.containsKey("KEY_IS_PROFILE_NAME_EDITABLE")) {
                this.f8072q = bundle.getBoolean("KEY_IS_PROFILE_NAME_EDITABLE");
            }
            if (bundle.containsKey("KEY_IS_PROFILE_STATUS_EDITABLE")) {
                this.f8073r = bundle.getBoolean("KEY_IS_PROFILE_STATUS_EDITABLE");
            }
        }
        m10824s();
        getLoaderManager().initLoader(21, null, this.f8069C);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755045, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(C1441a c1441a) {
        runOnUiThread(new C2504q(this));
    }

    public void onEvent(C1442b c1442b) {
        runOnUiThread(new C2501n(this));
    }

    public void onEvent(C1448c c1448c) {
        this.f8068B = false;
        runOnUiThread(new C2497j(this));
    }

    public void onEvent(C1449d c1449d) {
        this.f8068B = true;
        runOnUiThread(new C2495h(this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131689999) {
            return super.onOptionsItemSelected(menuItem);
        }
        m10830r();
        return true;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (!this.f8068B) {
            m10825t();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("KEY_IS_PROFILE_FETCHED", this.f8068B);
        bundle.putString("KEY_AVATAR_URL", this.f8081z);
        bundle.putString("KEY_AVATAR_THUMBNAIL_URL", this.f8067A);
        bundle.putString("KEY_MOTTO", this.f8080y);
        bundle.putString("KEY_CONTACT_NAME", this.f8079x);
        bundle.putBoolean("KEY_IS_PROFILE_NAME_EDITABLE", this.f8074s.isEnabled());
        bundle.putBoolean("KEY_IS_PROFILE_STATUS_EDITABLE", this.f8075t.isEnabled());
    }

    protected void m10830r() {
        if (this.f8074s.getText() == null || this.f8074s.getText().toString().trim().isEmpty()) {
            this.f8078w.setErrorEnabled(true);
            this.f8078w.setError(getString(2131230913));
            new Handler().postDelayed(new C2488a(this), 100);
            return;
        }
        this.f8078w.setErrorEnabled(false);
        m10826u();
    }
}
