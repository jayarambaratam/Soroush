package mobi.mmdt.ott.view.registeration.activationcode;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1429a;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1430b;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1433e;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1434f;
import mobi.mmdt.ott.view.components.p180c.C1685b;

public class ActivationCodeActivity extends C1685b implements ag {
    private String f7880i;
    private String f7881j;
    private String f7882k;
    private ActivationCodeFragment f7883l;
    private ViewGroup f7884m;
    private BroadcastReceiver f7885n;

    public ActivationCodeActivity() {
        this.f7885n = new C2406a(this);
    }

    private void m10598n() {
        m10599o();
    }

    private void m10599o() {
        runOnUiThread(new C2409d(this));
    }

    private void m10600p() {
        runOnUiThread(new C2413h(this));
    }

    public void m10601l() {
        new Handler().postDelayed(new C2408c(this), 10);
    }

    public void m10602m() {
        m10600p();
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8487a(bundle, false);
        setContentView(2130968602);
        m3618a((Toolbar) findViewById(2131689633));
        m8491e(2131230792);
        this.f7884m = (ViewGroup) findViewById(2131689635);
        this.f7883l = (ActivationCodeFragment) getFragmentManager().findFragmentById(2131689636);
        if (!(this.f7883l == null || this.f7883l.isDetached())) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.detach(this.f7883l);
            beginTransaction.commit();
        }
        if (getIntent() != null && getIntent().getExtras().containsKey("KEY_COUNTRY_CODE") && getIntent().getExtras().containsKey("KEY_PHONE_NUMBER")) {
            this.f7880i = getIntent().getExtras().getString("KEY_COUNTRY_NAME");
            this.f7881j = getIntent().getExtras().getString("KEY_COUNTRY_CODE");
            this.f7882k = getIntent().getExtras().getString("KEY_PHONE_NUMBER");
            if (this.f7881j != null && !this.f7881j.isEmpty() && this.f7882k != null && !this.f7882k.isEmpty()) {
                this.f7883l.m10617a(this.f7881j + " " + this.f7882k);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755045, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(C1429a c1429a) {
        runOnUiThread(new C2423r(this));
    }

    public void onEvent(C1430b c1430b) {
        runOnUiThread(new C2426u(this, c1430b));
    }

    public void onEvent(C1433e c1433e) {
        runOnUiThread(new C2419n(this));
    }

    public void onEvent(C1434f c1434f) {
        runOnUiThread(new C2416k(this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != 2131689999) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            m10598n();
            return true;
        }
    }

    public void onPause() {
        unregisterReceiver(this.f7885n);
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        intentFilter.setPriority(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        registerReceiver(this.f7885n, intentFilter);
    }
}
