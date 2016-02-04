package mobi.mmdt.ott.view.settings.forceupdate;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.components.p180c.C1797a;
import p000a.p001a.p002a.C0002c;

public class ForceUpdateActivity extends C1685b implements C2524c {
    protected RelativeLayout f8135i;
    private ForceUpdateFragment f8136j;

    public void m10861l() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + getApplicationContext().getPackageName()));
        startActivity(intent);
        C0002c.m2a().m17c(new C1797a());
        finish();
        overridePendingTransition(0, 0);
    }

    public void m10862m() {
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
        setContentView(2130968612);
        m3618a((Toolbar) findViewById(2131689633));
        m8491e(2131230847);
        this.f8135i = (RelativeLayout) findViewById(2131689631);
        this.f8136j = (ForceUpdateFragment) getFragmentManager().findFragmentById(2131689658);
        if (this.f8136j != null && !this.f8136j.isDetached()) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.detach(this.f8136j);
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
}
