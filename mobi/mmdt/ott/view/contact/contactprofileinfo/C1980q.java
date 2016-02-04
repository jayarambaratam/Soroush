package mobi.mmdt.ott.view.contact.contactprofileinfo;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p171e.C1610d;
import mobi.mmdt.ott.view.p178a.ah;
import mobi.mmdt.ott.view.p178a.aj;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.contact.contactprofileinfo.q */
class C1980q implements LoaderCallbacks<Cursor> {
    final /* synthetic */ ContactProfileInfoActivity f6335a;

    C1980q(ContactProfileInfoActivity contactProfileInfoActivity) {
        this.f6335a = contactProfileInfoActivity;
    }

    public void m9334a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToFirst()) {
            C1610d c1610d = new C1610d(cursor);
            String e = c1610d.m8189e();
            if (e.equals(this.f6335a.f6315x)) {
                String k = c1610d.m8195k();
                String b = c1610d.m8186b();
                CharSequence l = c1610d.m8196l();
                String c = c1610d.m8187c();
                String d = c1610d.m8188d();
                String m = c1610d.m8197m();
                Long g = c1610d.m8191g();
                if (g == null) {
                    g = Long.valueOf(0);
                }
                e = this.f6335a.f6300B ? ah.m8469a(k, c1610d.m8190f()) : ah.m8470b(b, e);
                this.f6335a.f6314w = e;
                this.f6335a.f6302D = e;
                if (this.f6335a.f6314w != null && !this.f6335a.f6314w.isEmpty()) {
                    this.f6335a.m8559a(this.f6335a.f6314w);
                } else if (k == null || k.isEmpty()) {
                    this.f6335a.m8559a("Contact Name");
                } else {
                    this.f6335a.m8559a(k);
                }
                if (g.longValue() != -1) {
                    this.f6335a.m8561b(C1111c.m6411d(this.f6335a.getApplicationContext(), g.longValue()));
                } else {
                    this.f6335a.m8561b(BuildConfig.FLAVOR);
                }
                if (l == null || l.isEmpty()) {
                    this.f6335a.f6309r.setText(BuildConfig.FLAVOR);
                    this.f6335a.f6306o.setVisibility(8);
                } else {
                    this.f6335a.f6309r.setText(l);
                    this.f6335a.f6306o.setVisibility(0);
                }
                this.f6335a.f6301C = c;
                if (d != null && !d.isEmpty()) {
                    this.f6335a.m8564c(aj.m8474a(d));
                    this.f6335a.m8566d(aj.m8474a(d));
                } else if (m == null || m.isEmpty()) {
                    this.f6335a.f6301C = null;
                    this.f6335a.m8569n();
                    this.f6335a.m8566d(null);
                } else {
                    this.f6335a.f6301C = m;
                    this.f6335a.m8564c(m);
                    this.f6335a.m8566d(m);
                }
                if (c1610d.m8192h()) {
                    this.f6335a.f6310s.setText(c1610d.m8190f());
                    this.f6335a.f6307p.setVisibility(0);
                    this.f6335a.f6310s.setVisibility(0);
                    return;
                }
                this.f6335a.f6307p.setVisibility(8);
                this.f6335a.f6310s.setVisibility(8);
            }
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1607a.m8165c(this.f6335a.getApplicationContext(), this.f6335a.f6315x);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m9334a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
