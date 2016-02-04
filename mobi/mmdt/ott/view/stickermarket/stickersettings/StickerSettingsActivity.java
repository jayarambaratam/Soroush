package mobi.mmdt.ott.view.stickermarket.stickersettings;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.p180c.C1685b;

public class StickerSettingsActivity extends C1685b implements C2596b {
    private ViewGroup f8312i;

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8487a(bundle, true);
        setContentView(2130968625);
        m3618a((Toolbar) findViewById(2131689633));
        m8492e(getString(2131230789));
        this.f8312i = (ViewGroup) findViewById(2131689631);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
