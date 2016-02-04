package mobi.mmdt.ott.view.conversation.groupinfo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p133a.C1413b;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p134b.C1417a;
import mobi.mmdt.ott.logic.p115d.C1321a;
import mobi.mmdt.ott.provider.p172f.C1619f;
import mobi.mmdt.ott.view.contact.p209a.C1960g;

public class AddParticipantsGroupContactSelectionListActivity extends C1960g {
    private String f7389k;
    private boolean f7390l;

    private void m10170a(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((String) it.next());
            arrayList3.add(C1619f.MEMBER);
        }
        C1494c.m7540b(new C1417a(getApplicationContext(), this.f7389k, arrayList2, arrayList3, false));
    }

    private void m10180o() {
        if (!this.f7390l) {
            this.f7390l = true;
            runOnUiThread(new C2249a(this));
        }
    }

    public void onCreate(Bundle bundle) {
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            if (m9286l().isEmpty() && getIntent().getExtras().containsKey("KEY_CHECKED_USERNAME_ARRAYLIST")) {
                ArrayList stringArrayList = getIntent().getExtras().getStringArrayList("KEY_CHECKED_USERNAME_ARRAYLIST");
                if (stringArrayList != null) {
                    this.j = true;
                    Iterator it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        m9286l().put((String) it.next(), Boolean.valueOf(false));
                    }
                }
            }
            if (getIntent().getExtras().containsKey("KEY_GROUP_ID")) {
                this.f7389k = getIntent().getExtras().getString("KEY_GROUP_ID");
            }
        }
        super.onCreate(bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755045, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(C1413b c1413b) {
        runOnUiThread(new C2252c(this));
    }

    public void onEvent(C1321a c1321a) {
        runOnUiThread(new C2255f(this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131689999) {
            return super.onOptionsItemSelected(menuItem);
        }
        m10180o();
        return true;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m8492e(getString(2131230747));
    }
}
