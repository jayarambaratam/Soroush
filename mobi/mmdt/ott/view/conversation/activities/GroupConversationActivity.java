package mobi.mmdt.ott.view.conversation.activities;

import android.annotation.SuppressLint;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.af;
import android.view.Menu;
import android.view.MenuItem;
import com.cocosw.bottomsheet.C1003l;
import java.util.ArrayList;
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
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1401e;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1402f;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p131b.C1410h;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p131b.C1411i;
import mobi.mmdt.ott.p089b.C1162g;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.provider.p170d.C1605j;
import mobi.mmdt.ott.provider.p172f.C1619f;
import mobi.mmdt.ott.provider.p175i.C1635a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2186f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2160g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2169f;
import mobi.mmdt.ott.view.p178a.C1659a;

public class GroupConversationActivity extends C1992a {
    private C1619f f6390p;
    private String f6391q;
    private String f6392r;
    private boolean f6393s;
    private boolean f6394t;
    private MenuItem f6395u;
    private boolean f6396v;
    private String f6397w;
    private LoaderCallbacks<Cursor> f6398x;
    private LoaderCallbacks<Cursor> f6399y;
    private OnClickListener f6400z;

    public GroupConversationActivity() {
        this.f6390p = C1619f.NONE;
        this.f6398x = new cx(this);
        this.f6399y = new cz(this);
        this.f6400z = new cl(this);
    }

    private void m9542G() {
        C1494c.m7540b(new C1411i(getApplicationContext(), this.f6391q, !this.f6396v));
    }

    private void m9543H() {
        new Handler().postDelayed(new cw(this), 50);
    }

    private void m9544I() {
        C1494c.m7539a(new C1410h(getApplicationContext(), this.f6391q, this.f6394t));
    }

    private void m9545J() {
        af afVar = new af(this, 2131427471);
        if (this.f6394t) {
            afVar.m3610b(getString(2131230805));
            afVar.m3607a(getString(2131230771), this.f6400z);
        } else {
            afVar.m3610b(getString(2131230806));
            afVar.m3607a(getString(2131230772), this.f6400z);
        }
        afVar.m3611b(getString(2131230813), null);
        afVar.m3612c();
    }

    public void m9560F() {
        if (!this.f6393s) {
        }
    }

    protected void m9561a(int i, int i2, int i3, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6391q);
        C1494c.m7539a(new ag(getApplicationContext(), arrayList, str, i, i2, i3, this.f6391q, C1595o.GROUP, str2));
    }

    public void m9562a(int i, String str) {
        this.j.m9649d();
        m9399E();
    }

    protected void m9563a(String str) {
        C1494c.m7539a(new C1389w(getApplicationContext(), str, this.f6391q, true));
    }

    public void m9564a(String str, int i, boolean z, boolean z2) {
    }

    protected void m9565a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6391q);
        C1494c.m7539a(new ai(getApplicationContext(), arrayList, str, this.f6391q, C1595o.GROUP, str2));
    }

    protected void m9566a(String str, String str2, C1605j c1605j) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6391q);
        C1494c.m7539a(new C1392z(getApplicationContext(), arrayList, str2, str, c1605j, this.f6391q, C1595o.GROUP));
    }

    protected void m9567a(String str, String str2, C1605j c1605j, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6391q);
        C1494c.m7539a(new C1392z(getApplicationContext(), arrayList, str2, str, c1605j, this.f6391q, C1595o.GROUP, str3));
    }

    public void m9568a(String str, String str2, String[] strArr, String str3) {
    }

    public void m9569a(C1162g c1162g) {
        C1494c.m7539a(new C1391y(getApplicationContext(), this.f6391q, c1162g, true));
    }

    protected void m9570b(int i, int i2, int i3, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6391q);
        C1494c.m7539a(new ag(getApplicationContext(), arrayList, str, i, i2, i3, this.f6391q, C1595o.GROUP));
    }

    public void m9571b(String str, String str2) {
    }

    protected void m9572b(C2152a c2152a) {
        new C1003l(this).m6120a(2131755029).m6121a(new da(this, c2152a)).m6119a().show();
    }

    protected void m9573c(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f6391q);
        C1494c.m7539a(new ai(getApplicationContext(), arrayList, str, this.f6391q, C1595o.GROUP));
    }

    protected void m9574c(C2152a c2152a) {
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
        int i = (str == null || C1635a.m8337a(getApplicationContext(), str)) ? 2131755027 : 2131755028;
        new C1003l(this).m6120a(i).m6121a(new db(this, c2152a)).m6119a().show();
    }

    protected void m9575d(C2152a c2152a) {
        new C1003l(this).m6120a(2131755025).m6121a(new dc(this, c2152a)).m6119a().show();
    }

    protected void m9576e(C2152a c2152a) {
        new C1003l(this).m6120a(2131755030).m6121a(new dd(this, c2152a)).m6119a().show();
    }

    protected void m9577f(C2152a c2152a) {
        new C1003l(this).m6120a(2131755024).m6121a(new de(this, c2152a)).m6119a().show();
    }

    public void m9578g(String str) {
        C1659a.m8433a(m8494q(), str, false, false);
    }

    protected void m9579g(C2152a c2152a) {
        new C1003l(this).m6120a(2131755026).m6121a(new ck(this, c2152a)).m6119a().show();
    }

    protected void m9580h(C2152a c2152a) {
    }

    public int m9581m() {
        return this.o > 0 ? this.o + 30 : 50;
    }

    public int m9582n() {
        return 30;
    }

    public int m9583o() {
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
        if (!(getIntent() == null || getIntent().getExtras() == null || !getIntent().getExtras().containsKey("KEY_PARTY"))) {
            this.f6391q = getIntent().getStringExtra("KEY_PARTY");
        }
        super.m9406a(bundle, this.f6391q);
        this.f6392r = C1309a.m6934a(getApplicationContext()).m6942b();
        m9569a(C1162g.ACTIVE);
        getLoaderManager().initLoader(14, null, this.f6399y);
        getLoaderManager().initLoader(15, null, this.f6398x);
        m9441p();
        m9543H();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755046, menu);
        this.f6395u = menu.findItem(2131689994);
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(C1394a c1394a) {
        C1123a.m6432a(m8494q()).m6437a();
        finish();
        overridePendingTransition(2131034126, 2131034130);
    }

    public void onEvent(C1401e c1401e) {
        runOnUiThread(new cr(this));
    }

    public void onEvent(C1402f c1402f) {
        runOnUiThread(new co(this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131689965) {
            this.f6394t = false;
            m9545J();
        } else if (itemId == 2131689994) {
            m9542G();
        } else if (itemId != 2131690000 && itemId == 2131689962) {
            this.f6394t = true;
            m9545J();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onPause() {
        super.onPause();
        this.f6393s = false;
        MyApplication.m6445a().f4177h = null;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        this.f6393s = true;
        MyApplication.m6445a().f4177h = this.f6391q;
    }

    protected void m9584y() {
        if (this.f6390p != C1619f.NONE) {
            new Handler().postDelayed(new cj(this), 10);
        }
    }
}
