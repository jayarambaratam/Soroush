package mobi.mmdt.ott.view.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.view.p085a.C1123a;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1397a;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1398b;
import mobi.mmdt.ott.view.contact.p209a.C1960g;

public class NewGroupContactSelectionListActivity extends C1960g {
    private boolean f7565k;

    private void m10371a(String str, String str2, String str3, ArrayList<String> arrayList) {
        runOnUiThread(new C2399t(this, str, str2, str3, arrayList));
    }

    private void m10378o() {
        if (!this.f7565k) {
            this.f7565k = true;
            C1123a.m6432a(m8494q()).m6439a(false);
            m10371a(getIntent().getExtras().getString("KEY_GROUP_NAME"), getIntent().getExtras().getString("KEY_GROUP_MOTTO"), getIntent().getExtras().getString("KEY_GROUP_IMAGE"), m9288n());
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755045, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(C1397a c1397a) {
        runOnUiThread(new C2404y(this));
    }

    public void onEvent(C1398b c1398b) {
        runOnUiThread(new C2401v(this, c1398b));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131689999) {
            return super.onOptionsItemSelected(menuItem);
        }
        m10378o();
        return true;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m8492e("New Group Chat");
        if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().containsKey("KEY_GROUP_NAME")) {
            m8493f(getIntent().getExtras().getString("KEY_GROUP_NAME"));
        }
    }
}
