package mobi.mmdt.ott.view.channel;

import android.annotation.SuppressLint;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.af;
import android.support.v7.p019a.C0363f;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1344j;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1345k;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1357i;
import mobi.mmdt.ott.view.components.C1711a;
import mobi.mmdt.ott.view.p178a.C1659a;

public class ChannelInfoActivity extends C1711a {
    private OnClickListener f5631A;
    private TextInputLayout f5632o;
    private TextView f5633p;
    private EditText f5634q;
    private EditText f5635r;
    private String f5636s;
    private Button f5637t;
    private boolean f5638u;
    private boolean f5639v;
    private String f5640w;
    private String f5641x;
    private String f5642y;
    private LoaderCallbacks<Cursor> f5643z;

    public ChannelInfoActivity() {
        this.f5643z = new C1730f(this);
        this.f5631A = new C1732h(this);
    }

    private void m8597r() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131689635);
        this.f5633p = (TextView) findViewById(2131689827);
        this.f5637t = (Button) findViewById(2131689832);
        this.f5632o = (TextInputLayout) findViewById(2131689830);
        this.f5634q = (EditText) findViewById(2131689831);
        this.f5635r = (EditText) findViewById(2131689828);
        m8560b((int) C0363f.abc_ic_menu_share_mtrl_alpha);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.height = (int) (((float) (point.y - (C1111c.m6401b(getApplicationContext()) + C1111c.m6406c(getApplicationContext())))) + C1111c.m6388a(getApplicationContext(), 8.0f));
        if (getResources().getConfiguration().orientation == 2) {
            layoutParams.width = (int) (((double) point.x) * 0.75d);
        }
        this.f5634q.setEnabled(false);
        this.f5635r.requestFocus();
        if (this.f5639v) {
            this.f5637t.setVisibility(0);
        } else {
            this.f5637t.setVisibility(8);
        }
        this.f5637t.setOnClickListener(new C1719a(this));
        new Thread(new C1726b(this)).start();
    }

    private void m8598s() {
        C1494c.m7539a(new C1357i(m8494q(), this.f5636s));
    }

    private void m8599t() {
        af afVar = new af(this, 2131427471);
        afVar.m3610b(getString(2131230804));
        afVar.m3607a(getString(2131230771), this.f5631A);
        afVar.m3611b(getString(2131230813), null);
        afVar.m3612c();
    }

    protected void m8600b(boolean z) {
    }

    protected int m8601l() {
        return 2130838594;
    }

    protected void m8602m() {
        if (this.f5641x != null) {
            C1659a.m8457k(m8494q(), this.f5641x, this.f5642y);
        }
    }

    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8557a(bundle, true);
        m8556a(2130968712);
        this.f5636s = getIntent().getExtras().getString("KEY_CHANNEL_ID");
        this.f5639v = getIntent().getBooleanExtra("KEY_IS_FOLLOWED", false);
        m8597r();
        m8563c(C1111c.m6402b(getApplicationContext(), this.f5636s));
        m8569n();
        m8566d(null);
        if (bundle != null) {
            if (bundle.containsKey("KEY_CHANNEL_NAME")) {
                m8559a(bundle.getString("KEY_CHANNEL_NAME"));
            }
            if (bundle.containsKey("KEY_CHANNEL_DESCRIPTIONS")) {
                this.f5634q.setText(bundle.getString("KEY_CHANNEL_DESCRIPTIONS"));
            }
            if (bundle.containsKey("KEY_CHANNEL_FOLLOWERS")) {
                m8561b(bundle.getString("KEY_CHANNEL_FOLLOWERS"));
            }
            if (bundle.containsKey("KEY_CHANNEL_LINK")) {
                this.f5640w = bundle.getString("KEY_CHANNEL_LINK");
            }
        }
        if (this.m != null) {
            m8564c(this.m);
            m8566d(this.m);
        }
        getLoaderManager().initLoader(5, null, this.f5643z);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f5639v) {
            getMenuInflater().inflate(2131755041, menu);
        }
        return true;
    }

    public void onEvent(C1344j c1344j) {
        runOnUiThread(new C1737m(this));
    }

    public void onEvent(C1345k c1345k) {
        runOnUiThread(new C1735k(this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131689962) {
            this.f5638u = true;
            m8599t();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String o = m8570o();
        if (!o.isEmpty()) {
            bundle.putString("KEY_CHANNEL_NAME", o);
        }
        o = this.f5634q.getText().toString();
        if (!o.isEmpty()) {
            bundle.putString("KEY_CHANNEL_DESCRIPTIONS", o);
        }
        o = m8571p();
        if (!o.isEmpty()) {
            bundle.putString("KEY_CHANNEL_FOLLOWERS", o);
        }
        o = this.f5640w;
        if (!o.isEmpty()) {
            bundle.putString("KEY_CHANNEL_LINK", o);
        }
    }
}
