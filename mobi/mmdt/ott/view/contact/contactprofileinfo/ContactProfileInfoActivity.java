package mobi.mmdt.ott.view.contact.contactprofileinfo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.af;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import mobi.mmdt.componentsutils.p079a.C1107a;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.view.components.C1711a;
import mobi.mmdt.ott.view.p178a.C1659a;
import net.frakbot.glowpadbackport.BuildConfig;

public class ContactProfileInfoActivity extends C1711a {
    private boolean f6299A;
    private boolean f6300B;
    private String f6301C;
    private String f6302D;
    private OnClickListener f6303E;
    private OnClickListener f6304F;
    private LoaderCallbacks<Cursor> f6305G;
    private TextInputLayout f6306o;
    private TextInputLayout f6307p;
    private TextView f6308q;
    private EditText f6309r;
    private EditText f6310s;
    private MenuItem f6311t;
    private MenuItem f6312u;
    private MenuItem f6313v;
    private String f6314w;
    private String f6315x;
    private boolean f6316y;
    private boolean f6317z;

    public ContactProfileInfoActivity() {
        this.f6314w = BuildConfig.FLAVOR;
        this.f6315x = BuildConfig.FLAVOR;
        this.f6303E = new C1972i(this);
        this.f6304F = new C1976m(this);
        this.f6305G = new C1980q(this);
    }

    private void m9322r() {
        runOnUiThread(new C1965b(this));
    }

    private void m9325s() {
        this.f6308q = (TextView) findViewById(2131689827);
        this.f6306o = (TextInputLayout) findViewById(2131689834);
        this.f6307p = (TextInputLayout) findViewById(2131689836);
        this.f6309r = (EditText) findViewById(2131689835);
        this.f6310s = (EditText) findViewById(2131689837);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131689635);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.height = (int) (((float) (point.y - (C1111c.m6401b(getApplicationContext()) + C1111c.m6406c(getApplicationContext())))) + C1111c.m6388a(getApplicationContext(), 8.0f));
        if (getResources().getConfiguration().orientation == 2) {
            layoutParams.width = (int) (((double) point.x) * 0.75d);
        }
        this.f6307p.setVisibility(8);
        this.f6310s.setVisibility(8);
        this.f6309r.setEnabled(false);
        this.f6310s.setEnabled(false);
        findViewById(2131689833).setVisibility(this.f6317z ? 0 : 8);
        new Thread(new C1967d(this)).start();
    }

    private void m9327t() {
        C1659a.m8432a((Activity) this, this.f6315x, true);
    }

    private void m9328u() {
        if (C1107a.m6377b(getApplicationContext())) {
            C1659a.m8445c(this, this.f6315x);
        } else {
            Snackbar.m377a(this.i, getString(2131230821), -1).m395a();
        }
    }

    private void m9329v() {
        af afVar = new af(this, 2131427471);
        afVar.m3606a(getString(2131230750) + " " + this.f6314w);
        afVar.m3610b(String.format(getString(2131230799), new Object[]{this.f6314w}));
        afVar.m3607a(getString(2131230750), this.f6303E);
        afVar.m3611b(getString(2131230813), null);
        afVar.m3612c();
    }

    private void m9330w() {
        af afVar = new af(this, 2131427471);
        afVar.m3606a(getString(2131230790) + " " + this.f6314w);
        afVar.m3610b(String.format(getString(2131230808), new Object[]{this.f6314w}));
        afVar.m3607a(getString(2131230790), this.f6304F);
        afVar.m3611b(getString(2131230813), null);
        afVar.m3612c();
    }

    protected void m9331b(boolean z) {
    }

    protected int m9332l() {
        return 2130838595;
    }

    protected void m9333m() {
        if (this.f6301C != null) {
            C1659a.m8457k(m8494q(), this.f6301C, this.f6302D);
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8557a(bundle, true);
        m8556a(2130968715);
        this.f6316y = true;
        m8560b(2130838495);
        m8558a(new C1964a(this));
        m9325s();
        if (getIntent().getExtras().containsKey("KEY_IS_NOT_SHOW_START_CHAT_BOOLEAN")) {
            this.f6299A = getIntent().getExtras().getBoolean("KEY_IS_NOT_SHOW_START_CHAT_BOOLEAN");
        }
        if (getIntent().getExtras().containsKey("KEY_SHOW_LOCAL_INFO_BOOLEAN")) {
            this.f6300B = getIntent().getExtras().getBoolean("KEY_SHOW_LOCAL_INFO_BOOLEAN");
        }
        this.f6315x = getIntent().getExtras().getString("KEY_CONTACT_USER_ID_STRING");
        m8563c(C1111c.m6402b(getApplicationContext(), this.f6315x));
        getLoaderManager().initLoader(6, null, this.f6305G);
        m9322r();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755042, menu);
        this.f6312u = menu.findItem(2131689996);
        this.f6313v = menu.findItem(2131689997);
        this.f6311t = menu.findItem(2131689995);
        if (this.f6317z) {
            this.f6313v.setVisible(true);
            this.f6312u.setVisible(false);
        } else {
            this.f6313v.setVisible(false);
            this.f6312u.setVisible(true);
        }
        this.f6313v.setVisible(false);
        this.f6312u.setVisible(false);
        if (this.f6299A) {
            this.f6311t.setVisible(false);
            m8560b(2130838507);
            m8558a(new C1971h(this));
        } else {
            this.f6311t.setVisible(true);
        }
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f6316y = false;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131689995) {
            m9328u();
            return true;
        } else if (itemId == 2131689996) {
            m9329v();
            return true;
        } else if (itemId != 2131689997) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            m9330w();
            return true;
        }
    }

    protected void onResume() {
        super.onResume();
    }
}
