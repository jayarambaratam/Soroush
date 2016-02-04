package mobi.mmdt.ott.view.conversation.activities;

import android.annotation.SuppressLint;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.af;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import com.cocosw.bottomsheet.C1003l;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.view.p085a.C1123a;
import mobi.mmdt.ott.C1317h;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1335a;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1338d;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1339e;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1340f;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1341g;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1342h;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1343i;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1344j;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1345k;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1346l;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1347m;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1348n;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1350b;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1353e;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1357i;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1358j;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1359k;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1360l;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1361m;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1392z;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.ag;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.ai;
import mobi.mmdt.ott.logic.p112a.p125d.p126a.C1394a;
import mobi.mmdt.ott.p089b.C1162g;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.provider.p170d.C1605j;
import mobi.mmdt.ott.provider.p172f.C1619f;
import mobi.mmdt.ott.provider.p175i.C1635a;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2186f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2160g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2169f;
import mobi.mmdt.ott.view.p178a.C1659a;

public class ChannelConversationActivity extends C1992a {
    private C1619f f6379p;
    private String f6380q;
    private String f6381r;
    private boolean f6382s;
    private MenuItem f6383t;
    private MenuItem f6384u;
    private boolean f6385v;
    private boolean f6386w;
    private Button f6387x;
    private LoaderCallbacks<Cursor> f6388y;
    private OnClickListener f6389z;

    public ChannelConversationActivity() {
        this.f6379p = C1619f.NONE;
        this.f6388y = new bw(this);
        this.f6389z = new ah(this);
    }

    private void m9477H() {
        runOnUiThread(new ay(this));
    }

    private void m9478I() {
        C1494c.m7540b(new C1360l(getApplicationContext(), this.f6380q, 20, 0));
    }

    private void m9479J() {
        C1494c.m7540b(new C1358j(getApplicationContext(), this.f6380q, !this.f6385v));
    }

    private void m9480K() {
        C1494c.m7539a(new C1357i(getApplicationContext(), this.f6380q));
    }

    private void m9481L() {
        af afVar = new af(this, 2131427471);
        afVar.m3610b(getString(2131230804));
        afVar.m3607a(getString(2131230771), this.f6389z);
        afVar.m3611b(getString(2131230813), null);
        afVar.m3612c();
    }

    private void m9490d(C1722f c1722f) {
        m9496h(((C2152a) c1722f).m9844f());
    }

    private void m9496h(String str) {
        C1494c.m7540b(new C1359k(getApplicationContext(), str));
    }

    private void m9498i(String str) {
        C1494c.m7540b(new C1353e(getApplicationContext(), str, 0, 20));
    }

    private void m9499j(String str) {
        runOnUiThread(new cd(this, str));
    }

    public void m9516F() {
    }

    public C1619f m9517G() {
        return this.f6379p;
    }

    protected void m9518a(int i, int i2, int i3, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6380q);
        C1494c.m7539a(new ag(getApplicationContext(), arrayList, str, i, i2, i3, this.f6380q, C1595o.CHANNEL, str2));
    }

    public void m9519a(int i, String str) {
        C1494c.m7540b(new C1350b(getApplicationContext(), this.f6380q, i + 20, str));
    }

    protected void m9520a(String str) {
    }

    public void m9521a(String str, int i, boolean z, boolean z2) {
        if (!z2) {
            Snackbar.m377a(this.k, getString(2131230744), -1).m395a();
        } else if (this.f6379p != C1619f.NONE) {
            C1494c.m7539a(new C1361m(getApplicationContext(), str, i, z));
        }
    }

    protected void m9522a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6380q);
        C1494c.m7539a(new ai(getApplicationContext(), arrayList, str, this.f6380q, C1595o.CHANNEL, str2));
    }

    protected void m9523a(String str, String str2, C1605j c1605j) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6380q);
        C1494c.m7539a(new C1392z(getApplicationContext(), arrayList, str2, str, c1605j, this.f6380q, C1595o.CHANNEL));
    }

    protected void m9524a(String str, String str2, C1605j c1605j, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6380q);
        C1494c.m7539a(new C1392z(getApplicationContext(), arrayList, str2, str, c1605j, this.f6380q, C1595o.CHANNEL, str3));
    }

    public void m9525a(String str, String str2, String[] strArr, String str3) {
        if (this.f6379p == C1619f.NONE) {
            Snackbar.m377a(this.k, getString(2131230975), -1).m395a();
        } else if (strArr.length > 0 || str3.length() > 0) {
            runOnUiThread(new ca(this, str, str2, strArr, str3));
        } else {
            Snackbar.m377a(this.k, getString(2131230974), -1).m395a();
        }
    }

    public void m9526a(C1162g c1162g) {
    }

    protected void m9527b(int i, int i2, int i3, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6380q);
        C1494c.m7539a(new ag(getApplicationContext(), arrayList, str, i, i2, i3, this.f6380q, C1595o.CHANNEL));
    }

    public void m9528b(String str, String str2) {
        m9499j(str2);
    }

    protected void m9529b(C2152a c2152a) {
        if (this.f6386w) {
            new C1003l(this).m6120a(2131755019).m6121a(new cg(this, c2152a)).m6119a().show();
        }
    }

    protected void m9530c(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6380q);
        C1494c.m7539a(new ai(getApplicationContext(), arrayList, str, this.f6380q, C1595o.CHANNEL));
    }

    protected void m9531c(C2152a c2152a) {
        if (this.f6386w) {
            String str = null;
            switch (c2152a.m8659g()) {
                case C1317h.Theme_editTextColor /*62*/:
                    str = ((C2169f) c2152a).m9923p();
                    break;
                case C1317h.Theme_editTextBackground /*63*/:
                    str = ((C2186f) c2152a).m10007p();
                    break;
                case C1317h.Theme_imageButtonStyle /*64*/:
                    str = ((C2160g) c2152a).m9879r();
                    break;
            }
            int i = (str == null || C1635a.m8337a(getApplicationContext(), str)) ? 2131755017 : 2131755018;
            new C1003l(this).m6120a(i).m6121a(new ch(this, c2152a)).m6119a().show();
        }
    }

    protected void m9532d(C2152a c2152a) {
        if (this.f6386w) {
            new C1003l(this).m6120a(2131755014).m6121a(new ci(this, c2152a)).m6119a().show();
        }
    }

    protected void m9533e(C2152a c2152a) {
        if (this.f6386w) {
            new C1003l(this).m6120a(2131755020).m6121a(new ad(this, c2152a)).m6119a().show();
        }
    }

    protected void m9534f(C2152a c2152a) {
        if (this.f6386w) {
            new C1003l(this).m6120a(2131755013).m6121a(new ae(this, c2152a)).m6119a().show();
        }
    }

    public void m9535g(String str) {
        C1659a.m8433a(m8494q(), str, false, false);
    }

    protected void m9536g(C2152a c2152a) {
        if (this.f6386w) {
            new C1003l(this).m6120a(2131755016).m6121a(new af(this, c2152a)).m6119a().show();
        }
    }

    protected void m9537h(C2152a c2152a) {
        if (this.f6386w) {
            new C1003l(this).m6120a(2131755015).m6121a(new ag(this, c2152a)).m6119a().show();
        }
    }

    public int m9538m() {
        return this.o > 0 ? this.o + 20 : 20;
    }

    public int m9539n() {
        return 20;
    }

    public int m9540o() {
        return 10;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 1479) {
            finish();
            overridePendingTransition(2131034126, 2131034130);
        }
    }

    @SuppressLint({"MissingSuperCall"})
    protected void onCreate(Bundle bundle) {
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.f6380q = getIntent().getStringExtra("KEY_PARTY");
        }
        super.m9406a(bundle, this.f6380q);
        this.f6381r = C1309a.m6934a(getApplicationContext()).m6942b();
        this.f6387x = (Button) findViewById(2131689656);
        getLoaderManager().initLoader(4, null, this.f6388y);
        this.f6387x.setVisibility(8);
        this.f6387x.setOnClickListener(new ac(this));
        m9478I();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755040, menu);
        this.f6383t = menu.findItem(2131689994);
        this.f6384u = menu.findItem(2131689962);
        this.f6383t.setVisible(this.f6386w);
        this.f6384u.setVisible(this.f6386w);
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy() {
        super.onDestroy();
        MyApplication.m6445a().m6454b();
    }

    public void onEvent(C1335a c1335a) {
        if (c1335a.m7024a()) {
            runOnUiThread(new bi(this));
        } else {
            C1494c.m7540b(new C1353e(getApplicationContext(), this.f6380q, c1335a.m7025b(), c1335a.m7026c(), 20));
        }
    }

    public void onEvent(C1338d c1338d) {
        runOnUiThread(new ar(this, c1338d));
    }

    public void onEvent(C1339e c1339e) {
        if (c1339e.m7029a()) {
            runOnUiThread(new av(this));
        } else {
            runOnUiThread(new aw(this));
        }
    }

    public void onEvent(C1340f c1340f) {
        runOnUiThread(new br(this));
    }

    public void onEvent(C1341g c1341g) {
        runOnUiThread(new bo(this, c1341g));
    }

    public void onEvent(C1342h c1342h) {
        runOnUiThread(new bb(this));
    }

    public void onEvent(C1343i c1343i) {
        runOnUiThread(new bf(this));
    }

    public void onEvent(C1344j c1344j) {
        runOnUiThread(new an(this));
    }

    public void onEvent(C1345k c1345k) {
        runOnUiThread(new ak(this));
    }

    public void onEvent(C1346l c1346l) {
        if (this.j != null) {
            runOnUiThread(new bh(this));
        }
    }

    public void onEvent(C1347m c1347m) {
        runOnUiThread(new bj(this, c1347m));
    }

    public void onEvent(C1348n c1348n) {
        runOnUiThread(new bm(this));
    }

    public void onEvent(C1394a c1394a) {
        C1123a.m6432a(m8494q()).m6437a();
        finish();
        overridePendingTransition(2131034126, 2131034130);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131689994) {
            m9479J();
        } else if (itemId == 2131689962) {
            m9481L();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onPause() {
        super.onPause();
        this.f6382s = false;
        MyApplication.m6445a().f4177h = null;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        this.f6382s = true;
        MyApplication.m6445a().f4177h = this.f6380q;
    }

    protected void m9541y() {
        new Handler().postDelayed(new bv(this), 10);
    }
}
