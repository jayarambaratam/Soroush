package mobi.mmdt.ott.view.stickermarket;

import android.annotation.SuppressLint;
import android.app.LoaderManager.LoaderCallbacks;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;
import com.p032a.p033a.p045h.C0866h;
import com.p065c.p066a.p067a.C0950c;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1457c;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1458d;
import mobi.mmdt.ott.logic.p112a.p149i.p151b.C1469g;
import mobi.mmdt.ott.logic.p112a.p149i.p151b.C1470h;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import net.frakbot.glowpadbackport.BuildConfig;

public class StickerDetailsActivity extends C1685b {
    private OnClickListener f8222A;
    private int f8223i;
    private FloatingActionButton f8224j;
    private ProgressWheel f8225k;
    private ProgressWheel f8226l;
    private RoundAvatarImageView f8227m;
    private ImageView f8228n;
    private TextView f8229o;
    private TextView f8230p;
    private TextView f8231q;
    private TextView f8232r;
    private ViewGroup f8233s;
    private ViewGroup f8234t;
    private boolean f8235u;
    private C0950c f8236v;
    private C0866h<String, C0742b> f8237w;
    private LoaderCallbacks<Cursor> f8238x;
    private OnClickListener f8239y;
    private OnClickListener f8240z;

    public StickerDetailsActivity() {
        this.f8237w = new C2579c(this);
        this.f8238x = new C2580d(this);
        this.f8239y = new C2582f(this);
        this.f8240z = new C2583g(this);
        this.f8222A = new C2584h(this);
    }

    private void m10944a(double d) {
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = point.x;
        this.f8228n.setLayoutParams(new LayoutParams(i, (int) (((double) i) * d)));
    }

    private void m10965l() {
        C0950c c1469g = new C1469g(getApplicationContext(), this.f8223i + BuildConfig.FLAVOR);
        this.f8236v = c1469g;
        C1494c.m7540b(c1469g);
    }

    private void m10968m() {
        C0950c c1470h = new C1470h(getApplicationContext(), this.f8223i);
        this.f8236v = c1470h;
        C1494c.m7540b(c1470h);
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8487a(bundle, true);
        setContentView(2130968624);
        m3618a((Toolbar) findViewById(2131689689));
        m8491e(2131230945);
        this.f8223i = getIntent().getIntExtra("StickerDetailsActivity.KEY_PACKAGE_ID", -1);
        String stringExtra = getIntent().getStringExtra("StickerDetailsActivity.KEY_PACKAGE_NAME");
        CharSequence stringExtra2 = getIntent().getStringExtra("StickerDetailsActivity.KEY_DOWNLOAD_COUNT");
        String stringExtra3 = getIntent().getStringExtra("StickerDetailsActivity.KEY_PRICE");
        if (!(stringExtra == null || stringExtra.isEmpty())) {
            m8492e(stringExtra);
        }
        this.f8224j = (FloatingActionButton) findViewById(2131689681);
        this.f8225k = (ProgressWheel) findViewById(2131689955);
        this.f8226l = (ProgressWheel) findViewById(2131689750);
        this.f8227m = (RoundAvatarImageView) findViewById(2131689954);
        this.f8228n = (ImageView) findViewById(2131689751);
        this.f8229o = (TextView) findViewById(2131689890);
        this.f8230p = (TextView) findViewById(2131689891);
        this.f8231q = (TextView) findViewById(2131689892);
        this.f8232r = (TextView) findViewById(2131689753);
        this.f8233s = (ViewGroup) findViewById(2131689752);
        this.f8234t = (ViewGroup) findViewById(2131689631);
        if (!(stringExtra3 == null || stringExtra3.isEmpty())) {
            CharSequence charSequence;
            double parseDouble = Double.parseDouble(stringExtra3);
            TextView textView = this.f8229o;
            if (parseDouble == 0.0d) {
                charSequence = "Free";
            } else {
                Object obj = stringExtra3;
            }
            textView.setText(charSequence);
        }
        if (!(stringExtra2 == null || stringExtra2.isEmpty())) {
            this.f8230p.setText(stringExtra2);
        }
        this.f8227m.setTextColor(-1);
        m8493f(null);
        this.f8224j.setOnClickListener(this.f8239y);
        this.f8224j.setImageResource(2130838502);
        getLoaderManager().initLoader(26, null, this.f8238x);
        m10965l();
    }

    public void onEvent(C1457c c1457c) {
        runOnUiThread(new C2586j(this, new C2585i(this)));
    }

    public void onEvent(C1458d c1458d) {
        if (this.f8234t != null) {
            runOnUiThread(new C2588l(this, c1458d));
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
