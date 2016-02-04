package mobi.mmdt.ott.view.components.mediaselector;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.io.Serializable;
import java.util.ArrayList;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.view.components.p180c.C1685b;

public class MainMediaSelectorActivity extends C1685b implements C1887h, C1888l {
    private C1901e f6057i;
    private C1904i f6058j;
    private C1900d f6059k;
    private ViewPager f6060l;
    private int f6061m;
    private int f6062n;
    private String f6063o;

    public MainMediaSelectorActivity() {
        this.f6061m = 2;
        this.f6062n = 10;
        this.f6063o = "Gallery";
    }

    public void m9055a(String str, String str2) {
        new Handler().postDelayed(new C1898b(this, str2, str), 10);
    }

    public void m9056b(String str, String str2) {
        new Handler().postDelayed(new C1899c(this, str2, str), 10);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            Serializable stringArrayListExtra;
            Intent intent2;
            switch (i) {
                case 1818:
                    stringArrayListExtra = intent.getStringArrayListExtra("KEY_PHOTO_ARRAYLIST_OF_PATH_RESULT");
                    intent2 = new Intent();
                    intent2.putExtra("KEY_RESULT_ARRAYLIST_OF_PATH", stringArrayListExtra);
                    intent2.putExtra("KEY_RESULT_TYPE", 1);
                    setResult(-1, intent2);
                    finish();
                    overridePendingTransition(2131034126, 2131034130);
                case 1819:
                    stringArrayListExtra = new ArrayList();
                    stringArrayListExtra.add(intent.getStringExtra("KEY_VIDEO_PATH_RESULT"));
                    intent2 = new Intent();
                    intent2.putExtra("KEY_RESULT_ARRAYLIST_OF_PATH", stringArrayListExtra);
                    intent2.putExtra("KEY_RESULT_TYPE", 2);
                    setResult(-1, intent2);
                    finish();
                    overridePendingTransition(2131034126, 2131034130);
                default:
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    protected void onCreate(Bundle bundle) {
        super.m8487a(bundle, true);
        setContentView(2130968618);
        m3618a((Toolbar) findViewById(2131689633));
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            Bundle extras = getIntent().getExtras();
            if (extras.containsKey("EXTRA_SELECT_MODE")) {
                this.f6061m = extras.getInt("EXTRA_SELECT_MODE");
            }
            if (extras.containsKey("EXTRA_MAX_PHOTO_SELECT_COUNT")) {
                this.f6062n = extras.getInt("EXTRA_MAX_PHOTO_SELECT_COUNT");
            }
            if (extras.containsKey("EXTRA_SELECTOR_TITLE")) {
                this.f6063o = extras.getString("EXTRA_SELECTOR_TITLE");
            }
        }
        m8492e(this.f6063o);
        this.f6057i = new C1901e();
        this.f6058j = new C1904i();
        this.f6059k = new C1900d(this, m1311f());
        this.f6060l = (ViewPager) findViewById(2131689672);
        this.f6060l.setAdapter(this.f6059k);
        TabLayout tabLayout = (TabLayout) findViewById(2131689682);
        tabLayout.setupWithViewPager(this.f6060l);
        if (this.f6061m == 2 || this.f6061m == 3) {
            tabLayout.setVisibility(8);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        ((MyApplication) getApplication()).f4172c.clear();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
