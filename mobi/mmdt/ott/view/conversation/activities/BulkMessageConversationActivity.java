package mobi.mmdt.ott.view.conversation.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.C0145q;
import android.view.Menu;
import android.view.MenuItem;
import com.p032a.p033a.C0872i;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1392z;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.ag;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.ai;
import mobi.mmdt.ott.logic.p112a.p125d.p126a.C1394a;
import mobi.mmdt.ott.p089b.C1162g;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.provider.p170d.C1605j;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;
import net.frakbot.glowpadbackport.BuildConfig;

public class BulkMessageConversationActivity extends C1992a {
    private ArrayList<String> f6377p;
    private String f6378q;

    public void m9452F() {
    }

    protected void m9453a(int i, int i2, int i3, String str, String str2) {
    }

    public void m9454a(int i, String str) {
    }

    protected void m9455a(String str) {
    }

    public void m9456a(String str, int i, boolean z, boolean z2) {
    }

    protected void m9457a(String str, String str2) {
    }

    protected void m9458a(String str, String str2, C1605j c1605j) {
        C1494c.m7539a(new C1392z(getApplicationContext(), this.f6377p, str2, str, c1605j, System.currentTimeMillis() + BuildConfig.FLAVOR, C1595o.SINGLE));
        new Handler().postDelayed(new ab(this), 1000);
    }

    protected void m9459a(String str, String str2, C1605j c1605j, String str3) {
    }

    public void m9460a(String str, String str2, String[] strArr, String str3) {
    }

    public void m9461a(C1162g c1162g) {
    }

    protected void m9462b(int i, int i2, int i3, String str) {
        C1494c.m7539a(new ag(getApplicationContext(), this.f6377p, str, i, i2, i3, System.currentTimeMillis() + BuildConfig.FLAVOR, C1595o.SINGLE));
        new Handler().postDelayed(new aa(this), 1000);
    }

    public void m9463b(String str, String str2) {
    }

    protected void m9464b(C2152a c2152a) {
    }

    protected void m9465c(String str) {
        C1494c.m7539a(new ai(getApplicationContext(), this.f6377p, str, System.currentTimeMillis() + BuildConfig.FLAVOR, C1595o.SINGLE));
        new Handler().postDelayed(new C2018z(this), 1000);
    }

    protected void m9466c(C2152a c2152a) {
    }

    protected void m9467d(C2152a c2152a) {
    }

    protected void m9468e(C2152a c2152a) {
    }

    protected void m9469f(C2152a c2152a) {
    }

    public void m9470g(String str) {
    }

    protected void m9471g(C2152a c2152a) {
    }

    protected void m9472h(C2152a c2152a) {
    }

    public int m9473m() {
        return 0;
    }

    public int m9474n() {
        return 0;
    }

    public int m9475o() {
        return 0;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1440 && i2 == -1) {
            this.f6377p = new ArrayList(intent.getStringArrayListExtra("KEY_PEER_PARTIES_ARRAYLIST"));
            m9430f(this.f6377p.size() + " participants");
        }
    }

    @SuppressLint({"MissingSuperCall"})
    protected void onCreate(Bundle bundle) {
        if (!(getIntent() == null || getIntent().getExtras() == null || !getIntent().getExtras().containsKey("KEY_PEER_PARTIES_ARRAYLIST"))) {
            this.f6377p = getIntent().getStringArrayListExtra("KEY_PEER_PARTIES_ARRAYLIST");
        }
        super.m9406a(bundle, "2");
        this.f6378q = C1309a.m6934a(getApplicationContext()).m6942b();
        m9428e("Bulk Message");
        m9430f(this.f6377p.size() + " recipients");
        this.m.setName("B");
        this.m.setBackgroundColor(C1111c.m6402b(getApplicationContext(), null));
        C0872i.m5266a((C0145q) this).m5328a(Integer.valueOf(2130838593)).m4406a(0.25f).m4417a(this.m);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(C1394a c1394a) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void m9476y() {
        new Handler().postDelayed(new C2017y(this), 10);
    }
}
