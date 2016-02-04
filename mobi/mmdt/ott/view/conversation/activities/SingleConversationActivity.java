package mobi.mmdt.ott.view.conversation.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.af;
import android.view.Menu;
import android.view.MenuItem;
import com.cocosw.bottomsheet.C1003l;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.p079a.C1107a;
import mobi.mmdt.componentsutils.view.p085a.C1123a;
import mobi.mmdt.ott.C1317h;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1389w;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1391y;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1392z;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.ag;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.ai;
import mobi.mmdt.ott.logic.p112a.p125d.p126a.C1394a;
import mobi.mmdt.ott.p089b.C1162g;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.provider.p170d.C1605j;
import mobi.mmdt.ott.provider.p175i.C1635a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2186f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2160g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2169f;
import mobi.mmdt.ott.view.p178a.C1659a;

public class SingleConversationActivity extends C1992a {
    private String f6401p;
    private String f6402q;
    private String f6403r;
    private boolean f6404s;
    private LoaderCallbacks<Cursor> f6405t;
    private LoaderCallbacks<Cursor> f6406u;
    private OnClickListener f6407v;

    public SingleConversationActivity() {
        this.f6405t = new dl(this);
        this.f6406u = new dm(this);
        this.f6407v = new dh(this);
    }

    private void m9585G() {
        runOnUiThread(new df(this));
    }

    private void m9586H() {
        af afVar = new af(this, 2131427471);
        afVar.m3610b(getString(2131230801));
        afVar.m3607a(getString(2131230760), this.f6407v);
        afVar.m3611b(getString(2131230813), null);
        afVar.m3612c();
    }

    public void m9593F() {
        if (this.f6404s) {
            C1494c.m7539a(new mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.af(getApplicationContext(), this.f6401p));
        }
    }

    protected void m9594a(int i, int i2, int i3, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6401p);
        C1494c.m7539a(new ag(getApplicationContext(), arrayList, str, i, i2, i3, this.f6401p, C1595o.SINGLE, str2));
    }

    public void m9595a(int i, String str) {
        this.j.m9649d();
        m9399E();
    }

    protected void m9596a(String str) {
        C1494c.m7539a(new C1389w(getApplicationContext(), str, this.f6401p, false));
    }

    public void m9597a(String str, int i, boolean z, boolean z2) {
    }

    protected void m9598a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6401p);
        C1494c.m7539a(new ai(getApplicationContext(), arrayList, str, this.f6401p, C1595o.SINGLE, str2));
    }

    protected void m9599a(String str, String str2, C1605j c1605j) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6401p);
        C1494c.m7539a(new C1392z(getApplicationContext(), arrayList, str2, str, c1605j, this.f6401p, C1595o.SINGLE));
    }

    protected void m9600a(String str, String str2, C1605j c1605j, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6401p);
        C1494c.m7539a(new C1392z(getApplicationContext(), arrayList, str2, str, c1605j, this.f6401p, C1595o.SINGLE, str3));
    }

    public void m9601a(String str, String str2, String[] strArr, String str3) {
    }

    public void m9602a(C1162g c1162g) {
        C1494c.m7539a(new C1391y(getApplicationContext(), this.f6401p, c1162g, false));
    }

    protected void m9603b(int i, int i2, int i3, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6401p);
        C1494c.m7539a(new ag(getApplicationContext(), arrayList, str, i, i2, i3, this.f6401p, C1595o.SINGLE));
    }

    public void m9604b(String str, String str2) {
    }

    protected void m9605b(C2152a c2152a) {
        new C1003l(this).m6120a(2131755038).m6121a(new dn(this, c2152a)).m6119a().show();
    }

    protected void m9606c(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6401p);
        C1494c.m7539a(new ai(getApplicationContext(), arrayList, str, this.f6401p, C1595o.SINGLE));
    }

    protected void m9607c(C2152a c2152a) {
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
        int i = (str == null || C1635a.m8337a(getApplicationContext(), str)) ? 2131755036 : 2131755037;
        new C1003l(this).m6120a(i).m6121a(new C1996do(this, c2152a)).m6119a().show();
    }

    protected void m9608d(C2152a c2152a) {
        new C1003l(this).m6120a(2131755034).m6121a(new dp(this, c2152a)).m6119a().show();
    }

    protected void m9609e(C2152a c2152a) {
        new C1003l(this).m6120a(2131755039).m6121a(new dq(this, c2152a)).m6119a().show();
    }

    protected void m9610f(C2152a c2152a) {
        new C1003l(this).m6120a(2131755033).m6121a(new dr(this, c2152a)).m6119a().show();
    }

    public void m9611g(String str) {
    }

    protected void m9612g(C2152a c2152a) {
        new C1003l(this).m6120a(2131755035).m6121a(new ds(this, c2152a)).m6119a().show();
    }

    protected void m9613h(C2152a c2152a) {
    }

    public int m9614m() {
        return this.o > 0 ? this.o + 30 : 50;
    }

    public int m9615n() {
        return 30;
    }

    public int m9616o() {
        return 10;
    }

    @SuppressLint({"MissingSuperCall"})
    protected void onCreate(Bundle bundle) {
        if (!(getIntent() == null || getIntent().getExtras() == null || !getIntent().getExtras().containsKey("KEY_PEER_PARTY"))) {
            this.f6401p = getIntent().getStringExtra("KEY_PEER_PARTY");
        }
        super.m9406a(bundle, this.f6401p);
        this.f6402q = C1309a.m6934a(getApplicationContext()).m6942b();
        C1494c.m7539a(new mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.af(getApplicationContext(), this.f6401p));
        m9602a(C1162g.ACTIVE);
        getLoaderManager().initLoader(24, null, this.f6405t);
        getLoaderManager().initLoader(25, null, this.f6406u);
        m9585G();
        m9441p();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755053, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(C1394a c1394a) {
        C1123a.m6432a(m8494q()).m6437a();
        finish();
        overridePendingTransition(2131034126, 2131034130);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131689966) {
            m9586H();
            return true;
        }
        if (itemId == 2131689995) {
            if (C1107a.m6377b(getApplicationContext())) {
                C1659a.m8445c(this, this.f6401p);
            } else {
                Snackbar.m377a(this.k, getString(2131230821), -1).m395a();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onPause() {
        super.onPause();
        this.f6404s = false;
        MyApplication.m6445a().f4177h = null;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        this.f6404s = true;
        MyApplication.m6445a().f4177h = this.f6401p;
    }

    protected void m9617y() {
        C1659a.m8449d((Activity) this, this.f6401p, false);
    }
}
