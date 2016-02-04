package mobi.mmdt.ott.view.registeration.introduction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.bt;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.registeration.phoneandcountry.PhoneAndCountryActivity;
import org.linphone.core.VideoSize;

public class IntroductionActivity extends C1685b implements C2432l, C2433o {
    boolean f7932i;
    private ViewPager f7933j;
    private bt f7934k;
    private LinearLayout f7935l;
    private Button f7936m;
    private Button f7937n;
    private ImageButton f7938o;
    private C2441h f7939p;
    private C2442i f7940q;
    private C2443j f7941r;
    private C2445m f7942s;

    public IntroductionActivity() {
        this.f7932i = true;
    }

    private void m10626b(int i) {
        if (i < 4) {
            for (int i2 = 0; i2 < 4; i2++) {
                ImageView imageView = (ImageView) this.f7935l.getChildAt(i2);
                if (i2 == i) {
                    imageView.setColorFilter(getResources().getColor(2131624086));
                } else {
                    imageView.setColorFilter(getResources().getColor(17170445));
                }
            }
        }
    }

    private void m10635l() {
        this.f7933j = (ViewPager) findViewById(2131689672);
        this.f7934k = new C2440g(this, getFragmentManager());
        this.f7933j.setAdapter(this.f7934k);
        this.f7933j.setOffscreenPageLimit(5);
        this.f7933j.m1853a(true, new C2439f(this));
        this.f7933j.m1852a(new C2437d(this));
        m10637n();
    }

    private void m10636m() {
        this.f7941r = new C2443j();
        this.f7939p = new C2441h();
        this.f7940q = new C2442i();
        this.f7942s = new C2445m();
    }

    private void m10637n() {
        this.f7935l = (LinearLayout) LinearLayout.class.cast(findViewById(2131689675));
        int i = (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f);
        for (int i2 = 0; i2 < 4; i2++) {
            View imageView = new ImageView(this);
            imageView.setImageResource(2130838585);
            imageView.setLayoutParams(new LayoutParams(-2, -2));
            imageView.setAdjustViewBounds(true);
            imageView.setPadding(i, 0, i, 0);
            this.f7935l.addView(imageView);
        }
        m10626b(0);
    }

    private void m10638o() {
        finish();
        overridePendingTransition(2131034125, 2131034129);
    }

    private void m10639p() {
        startActivity(new Intent(getApplicationContext(), PhoneAndCountryActivity.class));
    }

    public void m10640a(int i) {
        String str = "en-us";
        switch (i) {
            case VideoSize.CIF /*1*/:
                str = "fa";
                break;
            case VideoSize.HVGA /*2*/:
                str = "en-us";
                break;
        }
        MyApplication.m6445a().m6456b(str);
        Intent intent = getIntent();
        new Handler().postDelayed(new C2438e(this), 300);
        startActivity(intent);
        switch (i) {
            case VideoSize.CIF /*1*/:
                overridePendingTransition(2131034127, 2131034131);
            case VideoSize.HVGA /*2*/:
                overridePendingTransition(2131034124, 2131034128);
            default:
        }
    }

    public void m10641b(boolean z) {
        if (z) {
            this.f7937n.setEnabled(true);
        } else {
            this.f7937n.setEnabled(false);
        }
    }

    public void onBackPressed() {
        if (this.f7933j.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            this.f7933j.setCurrentItem(this.f7933j.getCurrentItem() - 1);
        }
    }

    @SuppressLint({"MissingSuperCall"})
    protected void onCreate(Bundle bundle) {
        super.m8487a(bundle, false);
        getWindow().setFlags(67108864, 67108864);
        setContentView(2130968616);
        m3618a((Toolbar) findViewById(2131689633));
        m3625h().m3576b();
        m10636m();
        this.f7936m = (Button) Button.class.cast(findViewById(2131689674));
        this.f7936m.setOnClickListener(new C2434a(this));
        this.f7938o = (ImageButton) ImageButton.class.cast(findViewById(2131689677));
        this.f7938o.setOnClickListener(new C2435b(this));
        this.f7937n = (Button) Button.class.cast(findViewById(2131689676));
        this.f7937n.setOnClickListener(new C2436c(this));
        this.f7937n.setEnabled(false);
        m10635l();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f7933j != null) {
            this.f7933j.m1858b();
        }
    }
}
