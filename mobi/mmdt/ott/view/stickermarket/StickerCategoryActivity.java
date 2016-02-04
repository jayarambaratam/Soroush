package mobi.mmdt.ott.view.stickermarket;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.p180c.C1685b;

public class StickerCategoryActivity extends C1685b implements C2569x {
    private C2594r f8217i;
    private ViewGroup f8218j;
    private String f8219k;
    private String f8220l;
    private boolean f8221m;

    public void m10940a(int i, String str, String str2, String str3) {
        Intent intent = new Intent(getApplicationContext(), StickerDetailsActivity.class);
        intent.putExtra("StickerDetailsActivity.KEY_PACKAGE_ID", i);
        intent.putExtra("StickerDetailsActivity.KEY_PACKAGE_NAME", str);
        intent.putExtra("StickerDetailsActivity.KEY_DOWNLOAD_COUNT", str2);
        intent.putExtra("StickerDetailsActivity.KEY_PRICE", str3);
        startActivity(intent);
        overridePendingTransition(2131034125, 2131034129);
    }

    public void m10941a(String str, String str2) {
    }

    public void m10942l() {
        Runnable c2574a = new C2574a(this);
        Snackbar a = Snackbar.m377a(this.f8218j, getString(2131230821), -2);
        a.m392a(2131230916, new C2578b(this, c2574a));
        if (!this.f8221m) {
            this.f8221m = true;
            a.m395a();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8487a(bundle, true);
        setContentView(2130968605);
        m3618a((Toolbar) findViewById(2131689633));
        this.f8219k = getIntent().getStringExtra("StickerCategoryActivity.KEY_CATEGORY_ID");
        this.f8220l = getIntent().getStringExtra("StickerCategoryActivity.KEY_CATEGORY_NAME");
        m8492e(this.f8220l);
        this.f8218j = (ViewGroup) findViewById(2131689631);
        this.f8217i = C2594r.m11029a(C2610z.LIST_TYPE_SPECIFIC_CATEGORY, this.f8219k);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(2131689637, this.f8217i);
        beginTransaction.setTransition(4099);
        beginTransaction.commit();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
