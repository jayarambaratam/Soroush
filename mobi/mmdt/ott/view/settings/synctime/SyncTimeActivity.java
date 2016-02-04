package mobi.mmdt.ott.view.settings.synctime;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.components.p180c.C1797a;
import p000a.p001a.p002a.C0002c;

public class SyncTimeActivity extends C1685b implements C2562c {
    protected RelativeLayout f8200i;
    private SyncTimeFragment f8201j;

    public void m10928l() {
        startActivity(new Intent("android.settings.DATE_SETTINGS"));
    }

    public void m10929m() {
        C0002c.m2a().m17c(new C1797a());
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public void onBackPressed() {
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8487a(bundle, false);
        setContentView(2130968633);
        m3618a((Toolbar) findViewById(2131689633));
        m8491e(2131230949);
        this.f8200i = (RelativeLayout) findViewById(2131689631);
        this.f8201j = (SyncTimeFragment) getFragmentManager().findFragmentById(2131689695);
        if (this.f8201j != null && !this.f8201j.isDetached()) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.detach(this.f8201j);
            beginTransaction.commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    protected void onResume() {
        super.onResume();
        if (C1113a.m6422a(getApplicationContext())) {
            C1309a.m6934a(getApplicationContext()).m6953d(true);
            finish();
            overridePendingTransition(2131034125, 2131034129);
        }
    }
}
