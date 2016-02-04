package mobi.mmdt.ott.view.settings.mainsettings.profile_info.deactivate_account;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import mobi.mmdt.ott.logic.p112a.p137g.p138a.p139a.C1425a;
import mobi.mmdt.ott.logic.p112a.p137g.p138a.p139a.C1426b;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.components.p180c.C1797a;
import p000a.p001a.p002a.C0002c;

public class DeactivateAccountActivity extends C1685b implements C2551j {
    protected RelativeLayout f8181i;
    private DeactivateAccountFragment f8182j;

    private void m10920n() {
        runOnUiThread(new C2552a(this));
    }

    public void m10921l() {
        m10920n();
    }

    public void m10922m() {
        onBackPressed();
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8487a(bundle, true);
        setContentView(2130968609);
        m3618a((Toolbar) findViewById(2131689633));
        m8491e(2131230830);
        this.f8181i = (RelativeLayout) findViewById(2131689631);
        this.f8182j = (DeactivateAccountFragment) getFragmentManager().findFragmentById(2131689657);
        if (this.f8182j != null && !this.f8182j.isDetached()) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.detach(this.f8182j);
            beginTransaction.commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(C1425a c1425a) {
        C0002c.m2a().m17c(new C1797a());
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public void onEvent(C1426b c1426b) {
        runOnUiThread(new C2555d(this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
