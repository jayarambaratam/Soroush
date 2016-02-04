package mobi.mmdt.ott.view.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.mmdt.ott.view.contact.p209a.C1960g;
import mobi.mmdt.ott.view.p178a.C1659a;

public class NewBulkMessageContactSelectionListActivity extends C1960g {
    private void m10361o() {
        ArrayList n = m9288n();
        if (this.j) {
            m9287m();
            Intent intent = new Intent();
            intent.putExtra("KEY_PEER_PARTIES_ARRAYLIST", n);
            setResult(-1, intent);
            finish();
            overridePendingTransition(2131034126, 2131034130);
        } else if (n.size() > 0) {
            m9287m();
            C1659a.m8434a((Activity) this, n, true);
        } else {
            Snackbar.m377a(this.i, (CharSequence) "No contacts selected!", -1).m395a();
        }
    }

    public void onCreate(Bundle bundle) {
        if (m9286l().isEmpty() && getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().containsKey("KEY_CHECKED_USERNAME_ARRAYLIST")) {
            ArrayList stringArrayList = getIntent().getExtras().getStringArrayList("KEY_CHECKED_USERNAME_ARRAYLIST");
            if (stringArrayList != null) {
                this.j = true;
                Iterator it = stringArrayList.iterator();
                while (it.hasNext()) {
                    m9286l().put((String) it.next(), Boolean.valueOf(true));
                }
            }
        }
        super.onCreate(bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755045, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131689999) {
            return super.onOptionsItemSelected(menuItem);
        }
        m10361o();
        return true;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m8492e(getString(2131230889));
    }
}
