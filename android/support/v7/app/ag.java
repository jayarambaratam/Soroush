package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.C0126a;
import android.support.v4.app.C0145q;
import android.support.v4.app.az;
import android.support.v4.app.db;
import android.support.v4.app.dc;
import android.support.v7.view.C0376c;
import android.support.v7.view.C0378b;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class ag extends C0145q implements dc, ah, C0371h {
    private ai f1776i;

    public Intent m3614a() {
        return az.m1119a(this);
    }

    public C0378b m3615a(C0376c c0376c) {
        return null;
    }

    public void m3616a(db dbVar) {
        dbVar.m1243a((Activity) this);
    }

    public void m3617a(C0378b c0378b) {
    }

    public void m3618a(Toolbar toolbar) {
        m3628k().m3468a(toolbar);
    }

    public boolean m3619a(Intent intent) {
        return az.m1121a((Activity) this, intent);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m3628k().m3474b(view, layoutParams);
    }

    public C0372g m3620b() {
        return m3628k().m3480g();
    }

    public void m3621b(Intent intent) {
        az.m1124b((Activity) this, intent);
    }

    public void m3622b(db dbVar) {
    }

    public void m3623b(C0378b c0378b) {
    }

    public void m3624d() {
        m3628k().m3478e();
    }

    public MenuInflater getMenuInflater() {
        return m3628k().m3472b();
    }

    public C0370a m3625h() {
        return m3628k().m3464a();
    }

    public boolean m3626i() {
        Intent a = m3614a();
        if (a == null) {
            return false;
        }
        if (m3619a(a)) {
            db a2 = db.m1242a((Context) this);
            m3616a(a2);
            m3622b(a2);
            a2.m1246a();
            try {
                C0126a.m1021a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            m3621b(a);
        }
        return true;
    }

    public void invalidateOptionsMenu() {
        m3628k().m3478e();
    }

    @Deprecated
    public void m3627j() {
    }

    public ai m3628k() {
        if (this.f1776i == null) {
            this.f1776i = ai.m3461a((Activity) this, (ah) this);
        }
        return this.f1776i;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3628k().m3466a(configuration);
    }

    public void onContentChanged() {
        m3627j();
    }

    protected void onCreate(Bundle bundle) {
        m3628k().m3481h();
        m3628k().m3467a(bundle);
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        m3628k().m3479f();
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0370a h = m3625h();
        return (menuItem.getItemId() != 16908332 || h == null || (h.m3567a() & 4) == 0) ? false : m3626i();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m3628k().m3473b(bundle);
    }

    protected void onPostResume() {
        super.onPostResume();
        m3628k().m3477d();
    }

    protected void onStop() {
        super.onStop();
        m3628k().m3476c();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m3628k().m3471a(charSequence);
    }

    public void setContentView(int i) {
        m3628k().m3465a(i);
    }

    public void setContentView(View view) {
        m3628k().m3469a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m3628k().m3470a(view, layoutParams);
    }
}
