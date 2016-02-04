package mobi.mmdt.ott.view.channel;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1342h;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1343i;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1345k;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.p178a.C1659a;

public class ExploreChannelsActivity extends C1685b implements ai {
    private ViewGroup f5644i;
    private ad f5645j;
    private Stack<String> f5646k;

    public ExploreChannelsActivity() {
        this.f5646k = new Stack();
    }

    private void m8609b(String str, boolean z) {
        this.f5645j = ad.m8640a(str);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        if (z) {
            beginTransaction.setCustomAnimations(2131099651, 2131099649);
        } else {
            beginTransaction.setCustomAnimations(2131099648, 2131099650);
        }
        beginTransaction.replace(2131689637, this.f5645j);
        beginTransaction.commit();
    }

    public void m8613a(String str) {
        C1659a.m8447c(m8494q(), str, false);
    }

    public void m8614a(String str, String str2) {
        this.f5646k.add(str);
        MyApplication.m6445a().f4176g.clear();
        m8609b(str2, false);
    }

    public void m8615a(String str, boolean z) {
        runOnUiThread(new C1741q(this, str));
    }

    public void m8616l() {
        runOnUiThread(new C1744t(this));
    }

    public void onBackPressed() {
        MyApplication.m6445a().f4176g.clear();
        if (this.f5646k == null || this.f5646k.isEmpty()) {
            super.onBackPressed();
            overridePendingTransition(2131034126, 2131034130);
            return;
        }
        m8609b((String) this.f5646k.pop(), true);
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8487a(bundle, true);
        setContentView(2130968610);
        m3618a((Toolbar) findViewById(2131689633));
        m8492e(getString(2131230841));
        this.f5644i = (ViewGroup) findViewById(2131689635);
        if (bundle != null && bundle.containsKey("KEY_CATEGORIES_ARRAYLIST")) {
            ArrayList stringArrayList = bundle.getStringArrayList("KEY_CATEGORIES_ARRAYLIST");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                Iterator it = stringArrayList.iterator();
                while (it.hasNext()) {
                    this.f5646k.push((String) it.next());
                }
            }
        }
        String str = null;
        if (this.f5646k.size() > 0) {
            str = (String) this.f5646k.peek();
        }
        this.f5645j = ad.m8640a(str);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(2131689637, this.f5645j);
        beginTransaction.setTransition(4099);
        beginTransaction.commit();
    }

    public void onEvent(C1342h c1342h) {
        runOnUiThread(new C1747w(this));
    }

    public void onEvent(C1343i c1343i) {
        runOnUiThread(new C1750z(this, c1343i));
    }

    public void onEvent(C1345k c1345k) {
        runOnUiThread(new ab(this, c1345k));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f5646k.size(); i++) {
            arrayList.add(this.f5646k.get(i));
        }
        bundle.putStringArrayList("KEY_CATEGORIES_ARRAYLIST", arrayList);
    }
}
