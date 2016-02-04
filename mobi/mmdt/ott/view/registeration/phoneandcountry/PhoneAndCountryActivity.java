package mobi.mmdt.ott.view.registeration.phoneandcountry;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1431c;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1432d;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1435g;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1436h;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p143b.C1437a;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2457c;

public class PhoneAndCountryActivity extends C1685b implements C2447q {
    private PhoneAndCountryFragment f7954i;
    private ViewGroup f7955j;

    private void m10659m() {
        m10661o();
    }

    private void m10660n() {
        C1494c.m7539a(new C1437a(getApplicationContext()));
    }

    private void m10661o() {
        if (this.f7954i.m10669b() != null && this.f7954i.m10671d() != null) {
            new Handler().postDelayed(new C2449b(this), 50);
            new Handler().postDelayed(new C2450c(this), 100);
        }
    }

    public void m10662l() {
        new Handler().postDelayed(new C2448a(this), 100);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 114) {
            if (i2 == -1) {
                this.f7954i.m10668a(intent.getStringExtra("KEY_COUNTRY_NAME_SELECTED"), intent.getStringExtra("KEY_COUNTRY_CODE_SELECTED"));
            }
            if (i2 != 0) {
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8487a(bundle, false);
        setContentView(2130968623);
        m3618a((Toolbar) findViewById(2131689633));
        m8491e(2131230903);
        this.f7955j = (ViewGroup) findViewById(2131689635);
        this.f7954i = (PhoneAndCountryFragment) getFragmentManager().findFragmentById(2131689686);
        if (!(this.f7954i == null || this.f7954i.isDetached())) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.detach(this.f7954i);
            beginTransaction.commit();
        }
        if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().containsKey("KEY_COUNTRY_NAME") && getIntent().getExtras().containsKey("KEY_COUNTRY_CODE") && getIntent().getExtras().containsKey("KEY_PHONE_NUMBER")) {
            String string = getIntent().getExtras().getString("KEY_COUNTRY_NAME");
            String string2 = getIntent().getExtras().getString("KEY_COUNTRY_CODE");
            String string3 = getIntent().getExtras().getString("KEY_PHONE_NUMBER");
            if (string != null && !string.isEmpty() && string2 != null && !string2.isEmpty() && string3 != null && !string3.isEmpty()) {
                this.f7954i.m10668a(string, string2);
                this.f7954i.m10667a(string3);
                return;
            }
            return;
        }
        m10660n();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755045, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(C1431c c1431c) {
        String str = "+" + c1431c.m7346a();
        String a = C2457c.m10729a(str);
        if (this.f7954i != null) {
            runOnUiThread(new C2482k(this, a, str));
        }
    }

    public void onEvent(C1432d c1432d) {
        runOnUiThread(new C2483l(this));
    }

    public void onEvent(C1435g c1435g) {
        runOnUiThread(new C2475d(this));
    }

    public void onEvent(C1436h c1436h) {
        runOnUiThread(new C2478g(this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != 2131689999) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            m10659m();
            return true;
        }
    }
}
