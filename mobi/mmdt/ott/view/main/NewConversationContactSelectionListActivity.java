package mobi.mmdt.ott.view.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import mobi.mmdt.ott.view.contact.p209a.C1962j;
import mobi.mmdt.ott.view.p178a.C1659a;

public class NewConversationContactSelectionListActivity extends C1962j {
    protected void m10362b(String str) {
        C1659a.m8432a((Activity) this, str, true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m8492e(getString(2131230943));
    }
}
