package mobi.mmdt.ott.view.components;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.Behavior;
import android.support.design.widget.C0095u;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.af;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.cocosw.bottomsheet.C1003l;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.components.squarecrop.SquareCropActivity;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.components.a */
public abstract class C1711a extends C1685b {
    protected CoordinatorLayout f5617i;
    protected NestedScrollView f5618j;
    protected CollapsingToolbarLayout f5619k;
    protected FloatingActionButton f5620l;
    protected String f5621m;
    protected boolean f5622n;
    private Toolbar f5623o;
    private ImageView f5624p;
    private RoundAvatarImageView f5625q;
    private TextView f5626r;
    private TextView f5627s;
    private ViewStub f5628t;
    private AppBarLayout f5629u;
    private boolean f5630v;

    public C1711a() {
        this.f5630v = false;
    }

    private void m8551r() {
        int i = 2131755022;
        int i2 = 3;
        if (this.f5621m == null) {
            i = 2131755023;
            i2 = 2;
        }
        new C1003l(this).m6120a(i).m6121a(new C1816g(this)).m6124c(i2).m6119a().show();
    }

    private void m8552s() {
        af afVar = new af(this, 2131427471);
        afVar.m3610b((CharSequence) "Are you sure to remove profile photo?");
        afVar.m3611b("CANCEL", null);
        afVar.m3607a((CharSequence) "REMOVE", new C1817h(this));
        afVar.m3612c();
    }

    private void m8553t() {
        Intent intent = new Intent(this, SquareCropActivity.class);
        intent.putExtra("KEY_IMAGE_SELECTOR", 1002);
        startActivityForResult(intent, 1002);
    }

    private void m8554u() {
        Intent intent = new Intent(this, SquareCropActivity.class);
        intent.putExtra("KEY_IMAGE_SELECTOR", 1001);
        startActivityForResult(intent, 1001);
    }

    private void m8555v() {
        LayoutParams layoutParams = ((AppBarLayout) findViewById(2131689660)).getLayoutParams();
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (getResources().getConfiguration().orientation == 1) {
            layoutParams.height = (int) (((double) point.x) * 0.75d);
            m8565d(0);
            return;
        }
        layoutParams.height = (int) (((double) point.y) * 0.5d);
    }

    protected void m8556a(int i) {
        this.f5628t.setLayoutResource(i);
        this.f5628t.inflate();
    }

    public void m8557a(Bundle bundle, boolean z) {
        super.m8487a(bundle, z);
        setContentView(2130968614);
        this.f5623o = (Toolbar) findViewById(2131689633);
        m3618a(this.f5623o);
        m8489a(getWindow(), getResources().getColor(2131623982));
        this.f5628t = (ViewStub) findViewById(2131689668);
        this.f5619k = (CollapsingToolbarLayout) findViewById(2131689663);
        this.f5618j = (NestedScrollView) findViewById(2131689667);
        this.f5626r = (TextView) findViewById(2131689479);
        this.f5627s = (TextView) findViewById(2131689666);
        this.f5625q = (RoundAvatarImageView) findViewById(2131689478);
        this.f5624p = (ImageView) findViewById(2131689664);
        this.f5617i = (CoordinatorLayout) findViewById(2131689659);
        this.f5629u = (AppBarLayout) findViewById(2131689660);
        this.f5620l = (FloatingActionButton) findViewById(2131689669);
        m8555v();
        this.f5620l.setOnClickListener(new C1796b(this));
        this.f5625q.setTextColor(-1);
        this.f5625q.setOnClickListener(new C1798c(this));
        if (bundle != null) {
            if (bundle.containsKey("KEY_CROPPED_IMAGE_ADDRESS")) {
                this.f5621m = bundle.getString("KEY_CROPPED_IMAGE_ADDRESS");
            }
            if (bundle.containsKey("KEY_IS_IMAGE_CHANGED")) {
                this.f5622n = bundle.getBoolean("KEY_IS_IMAGE_CHANGED");
            }
        }
        if (this.f5621m != null) {
            C0872i.m5265a(m8494q()).m5329a(this.f5621m).m4407a(2130838595).m4406a(0.25f).m4417a(this.f5625q);
        }
        this.f5619k.setTitle(BuildConfig.FLAVOR);
        setTitle(BuildConfig.FLAVOR);
    }

    protected void m8558a(OnClickListener onClickListener) {
        this.f5620l.setOnClickListener(onClickListener);
    }

    protected void m8559a(String str) {
        this.f5626r.setText(str);
    }

    protected void m8560b(int i) {
        this.f5620l.setImageResource(i);
    }

    protected void m8561b(String str) {
        if (str == null || str.isEmpty()) {
            this.f5627s.setText(BuildConfig.FLAVOR);
            this.f5627s.setVisibility(8);
            return;
        }
        this.f5627s.setText(str);
        this.f5627s.setVisibility(0);
    }

    protected abstract void m8562b(boolean z);

    protected void m8563c(int i) {
        this.f5625q.setBackgroundColor(i);
    }

    protected void m8564c(String str) {
        int a = (int) C1111c.m6388a(m8494q(), 36.0f);
        C0872i.m5265a(m8494q()).m5329a(str).m5047j().m4304a(m8567l()).m4306a(C0652e.SOURCE).m4328c().m4305a(a, a).m4285a(new C1799d(this, this.f5625q));
    }

    public void m8565d(int i) {
        Behavior behavior = (Behavior) ((C0095u) this.f5629u.getLayoutParams()).m831b();
        if (behavior != null) {
            behavior.m252a(i);
            behavior.m247a(this.f5617i, this.f5629u, null, 0, 1, new int[2]);
        }
    }

    protected void m8566d(String str) {
        if (str == null) {
            this.f5624p.setImageBitmap(null);
        } else {
            C0872i.m5265a(m8494q()).m5329a(str).m5047j().m4306a(C0652e.SOURCE).m4328c().m4305a(160, 160).m4285a(new C1801f(this, this.f5624p));
        }
    }

    protected abstract int m8567l();

    protected abstract void m8568m();

    protected void m8569n() {
        C0872i.m5265a(m8494q()).m5328a(Integer.valueOf(m8567l())).m4417a(this.f5625q);
    }

    protected String m8570o() {
        return this.f5626r.getText().toString();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1001:
                if (i2 == -1) {
                    this.f5622n = true;
                    m8562b(this.f5622n);
                    this.f5621m = intent.getStringExtra("KEY_SQUARE_IMAGE_FILE_PATH");
                    m8564c(this.f5621m);
                    this.f5630v = false;
                    m8566d(this.f5621m);
                }
            case 1002:
                if (i2 == -1) {
                    this.f5622n = true;
                    m8562b(this.f5622n);
                    this.f5621m = intent.getStringExtra("KEY_SQUARE_IMAGE_FILE_PATH");
                    m8564c(this.f5621m);
                    this.f5630v = false;
                    m8566d(this.f5621m);
                }
            default:
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
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
        if (this.f5621m != null) {
            bundle.putString("KEY_CROPPED_IMAGE_ADDRESS", this.f5621m);
        }
        bundle.putBoolean("KEY_IS_IMAGE_CHANGED", this.f5622n);
    }

    protected String m8571p() {
        return this.f5627s.getText().toString();
    }
}
