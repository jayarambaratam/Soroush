package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ax;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import mobi.mmdt.ott.view.components.p180c.C1685b;

public class CountrySelectionActivity extends C1685b implements OnQueryTextListener, C2451d {
    private C2452a f7970i;

    public void m10673a(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("KEY_COUNTRY_NAME_SELECTED", str);
        intent.putExtra("KEY_COUNTRY_CODE_SELECTED", str2);
        setResult(-1, intent);
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    public void onBackPressed() {
        setResult(0, new Intent());
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8487a(bundle, true);
        setContentView(2130968608);
        m3618a((Toolbar) findViewById(2131689633));
        m8491e(2131230828);
        this.f7970i = new C2452a();
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(2131689637, this.f7970i);
        beginTransaction.setTransition(4099);
        beginTransaction.commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755044, menu);
        ((SearchView) ax.m2245a(menu.findItem(2131689998))).setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public boolean onQueryTextChange(String str) {
        this.f7970i.m10680a(str);
        return false;
    }

    public boolean onQueryTextSubmit(String str) {
        return false;
    }
}
