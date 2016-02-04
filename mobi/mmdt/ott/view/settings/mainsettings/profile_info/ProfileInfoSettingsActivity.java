package mobi.mmdt.ott.view.settings.mainsettings.profile_info;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.af;
import android.view.Menu;
import android.view.MenuItem;
import mobi.mmdt.ott.view.registeration.profileinfo.ProfileInfoActivity;
import mobi.mmdt.ott.view.settings.mainsettings.profile_info.deactivate_account.DeactivateAccountActivity;

public class ProfileInfoSettingsActivity extends ProfileInfoActivity {
    private boolean f8172w;
    private OnClickListener f8173x;
    private OnClickListener f8174y;

    public ProfileInfoSettingsActivity() {
        this.f8172w = false;
        this.f8173x = new C2549c(this);
        this.f8174y = new C2550d(this);
    }

    private void m10913s() {
        this.s.addTextChangedListener(new C2547a(this));
        this.t.addTextChangedListener(new C2548b(this));
    }

    private void m10914t() {
        startActivity(new Intent(getApplicationContext(), DeactivateAccountActivity.class));
        overridePendingTransition(2131034125, 2131034129);
    }

    public void onBackPressed() {
        if (this.f8172w || this.n) {
            af afVar = new af(this, 2131427471);
            afVar.m3606a(getString(2131230918));
            afVar.m3610b(getString(2131230807));
            afVar.m3607a(getString(2131230917), this.f8173x);
            afVar.m3611b(getString(2131230813), this.f8174y);
            afVar.m3612c();
            return;
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        this.v = true;
        this.o = 2130968743;
        this.p = true;
        super.onCreate(bundle);
        if (bundle != null && bundle.containsKey("KEY_IS_CHANGE_OCCURRED") && bundle.getBoolean("KEY_IS_CHANGE_OCCURRED")) {
            this.f8172w = true;
        } else {
            this.f8172w = false;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755052, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131690004) {
            m10914t();
            return true;
        } else if (itemId != 2131689999) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            onBackPressed();
            return true;
        }
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m10913s();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("KEY_IS_CHANGE_OCCURRED", this.f8172w);
    }
}
