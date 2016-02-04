package mobi.mmdt.ott.view.stickermarket;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.p178a.C1659a;

public class StickerMarketActivity extends C1685b implements ab, C2569x {
    private C2593q f8241i;
    private ViewPager f8242j;
    private ViewGroup f8243k;
    private C2594r f8244l;
    private C2594r f8245m;
    private C2594r f8246n;
    private C2594r f8247o;
    private boolean f8248p;

    public void m10987a(int i, String str, String str2, String str3) {
        Intent intent = new Intent(getApplicationContext(), StickerDetailsActivity.class);
        intent.putExtra("StickerDetailsActivity.KEY_PACKAGE_ID", i);
        intent.putExtra("StickerDetailsActivity.KEY_PACKAGE_NAME", str);
        intent.putExtra("StickerDetailsActivity.KEY_DOWNLOAD_COUNT", str2);
        intent.putExtra("StickerDetailsActivity.KEY_PRICE", str3);
        startActivity(intent);
        overridePendingTransition(2131034125, 2131034129);
    }

    public void m10988a(String str, String str2) {
        Intent intent = new Intent(getApplicationContext(), StickerCategoryActivity.class);
        intent.putExtra("StickerCategoryActivity.KEY_CATEGORY_ID", str);
        intent.putExtra("StickerCategoryActivity.KEY_CATEGORY_NAME", str2);
        startActivity(intent);
        overridePendingTransition(2131034125, 2131034129);
    }

    public void m10989l() {
        Runnable c2591o = new C2591o(this);
        Snackbar a = Snackbar.m377a(this.f8243k, getString(2131230821), -2);
        a.m392a(2131230916, new C2592p(this, c2591o));
        if (!this.f8248p) {
            this.f8248p = true;
            a.m395a();
        }
    }

    public void m10990m() {
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8487a(bundle, true);
        setContentView(2130968630);
        m3618a((Toolbar) findViewById(2131689633));
        m8492e(getString(2131230945));
        this.f8241i = new C2593q(this, getFragmentManager());
        this.f8243k = (ViewGroup) findViewById(2131689631);
        this.f8242j = (ViewPager) findViewById(2131689672);
        this.f8242j.setAdapter(this.f8241i);
        this.f8242j.setOffscreenPageLimit(5);
        ((TabLayout) findViewById(2131689682)).setupWithViewPager(this.f8242j);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755054, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId == 2131690005) {
            C1659a.m8438b(m8494q());
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
