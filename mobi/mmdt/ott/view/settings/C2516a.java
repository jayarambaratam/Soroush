package mobi.mmdt.ott.view.settings;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.p180c.C1685b;

/* renamed from: mobi.mmdt.ott.view.settings.a */
public abstract class C2516a extends C1685b implements C2515d {
    protected ViewGroup f8119i;
    private C2522b f8120j;

    protected abstract void m10839a(int i);

    public void m10840b(int i) {
        m10839a(i);
    }

    protected void m10841l() {
        this.f8120j.m10854a();
    }

    protected abstract String m10842m();

    protected abstract C2522b m10843n();

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968626);
        this.f8119i = (ViewGroup) findViewById(2131689635);
        m3618a((Toolbar) findViewById(2131689633));
        m8492e(m10842m());
        if (this.f8120j == null) {
            this.f8120j = m10843n();
        }
        if (!this.f8120j.isDetached()) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.replace(2131689637, this.f8120j);
            beginTransaction.setTransition(4099);
            beginTransaction.commit();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
