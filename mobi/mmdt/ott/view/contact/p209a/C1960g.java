package mobi.mmdt.ott.view.contact.p209a;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.view.components.p180c.C1685b;

/* renamed from: mobi.mmdt.ott.view.contact.a.g */
public abstract class C1960g extends C1685b implements C1959f {
    protected RelativeLayout f6290i;
    protected boolean f6291j;
    private C1944a f6292k;
    private EditText f6293l;

    public void m9285a(String str) {
    }

    protected LinkedHashMap<String, Boolean> m9286l() {
        return MyApplication.m6445a().f4171b;
    }

    protected void m9287m() {
        ((MyApplication) getApplication()).f4171b.clear();
    }

    protected ArrayList<String> m9288n() {
        return this.f6292k.m9244b();
    }

    public void onBackPressed() {
        setResult(0);
        m9287m();
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8487a(bundle, true);
        setContentView(2130968606);
        m3618a((Toolbar) findViewById(2131689633));
        this.f6290i = (RelativeLayout) findViewById(2131689631);
        this.f6293l = (EditText) findViewById(2131689647);
        if (this.f6292k == null) {
            this.f6292k = new C1944a();
        }
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            if (bundle.containsKey("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION")) {
                bundle2.putInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION", bundle.getInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION"));
            }
            if (bundle.containsKey("KEY_SEARCH_FILTER")) {
                CharSequence string = bundle.getString("KEY_SEARCH_FILTER");
                bundle2.putString("KEY_SEARCH_FILTER", string);
                this.f6293l.setText(string);
            }
        }
        bundle2.putInt("KEY_MAXIMUM_CONTACT_SELECTION", 99);
        bundle2.putBoolean("KEY_MULTIPLE_CONTACT_SELECTION", true);
        this.f6292k.setArguments(bundle2);
        if (!this.f6292k.isDetached()) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.replace(2131689637, this.f6292k);
            beginTransaction.setTransition(4099);
            beginTransaction.commit();
        }
        this.f6293l.addTextChangedListener(new C1961h(this));
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION", this.f6292k.m9247c());
        bundle.putString("KEY_SEARCH_FILTER", this.f6293l.getText().toString());
    }
}
