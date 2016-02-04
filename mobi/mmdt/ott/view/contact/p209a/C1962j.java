package mobi.mmdt.ott.view.contact.p209a;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;
import mobi.mmdt.ott.view.components.p180c.C1685b;

/* renamed from: mobi.mmdt.ott.view.contact.a.j */
public abstract class C1962j extends C1685b implements C1959f {
    protected RelativeLayout f6295i;
    private C1944a f6296j;
    private EditText f6297k;

    public void m9290a(String str) {
        m9291b(str);
    }

    protected abstract void m9291b(String str);

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8487a(bundle, true);
        setContentView(2130968606);
        m3618a((Toolbar) findViewById(2131689633));
        m8492e("Start conversation with");
        this.f6295i = (RelativeLayout) findViewById(2131689631);
        this.f6297k = (EditText) findViewById(2131689647);
        if (this.f6296j == null) {
            this.f6296j = new C1944a();
        }
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            if (bundle.containsKey("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION")) {
                bundle2.putInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION", bundle.getInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION"));
            }
            if (bundle.containsKey("KEY_SEARCH_FILTER")) {
                CharSequence string = bundle.getString("KEY_SEARCH_FILTER");
                bundle2.putString("KEY_SEARCH_FILTER", string);
                this.f6297k.setText(string);
            }
        }
        bundle2.putBoolean("KEY_MULTIPLE_CONTACT_SELECTION", false);
        this.f6296j.setArguments(bundle2);
        if (!this.f6296j.isDetached()) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.replace(2131689637, this.f6296j);
            beginTransaction.setTransition(4099);
            beginTransaction.commit();
        }
        this.f6297k.addTextChangedListener(new C1963k(this));
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
        bundle.putInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION", this.f6296j.m9247c());
        bundle.putString("KEY_SEARCH_FILTER", this.f6297k.getText().toString());
    }
}
