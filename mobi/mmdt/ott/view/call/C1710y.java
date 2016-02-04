package mobi.mmdt.ott.view.call;

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

/* renamed from: mobi.mmdt.ott.view.call.y */
class C1710y implements LoaderCallbacks<Cursor> {
    final /* synthetic */ C1707v f5616a;

    C1710y(C1707v c1707v) {
        this.f5616a = c1707v;
    }

    public void m8540a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToFirst()) {
            C1610d c1610d = new C1610d(cursor);
            if (c1610d.m8189e().equals(this.f5616a.f5609g)) {
                String e = c1610d.m8189e();
                String k = c1610d.m8195k();
                String b = c1610d.m8186b();
                c1610d.m8187c();
                String d = c1610d.m8188d();
                String m = c1610d.m8197m();
                String str = BuildConfig.FLAVOR;
                Object a = c1610d.m8192h() ? ah.m8469a(k, c1610d.m8190f()) : ah.m8470b(b, e);
                this.f5616a.f5606d.setText(a);
                if (d != null && !d.isEmpty()) {
                    this.f5616a.m8537b(aj.m8474a(d));
                } else if (!(m == null || m.isEmpty())) {
                    this.f5616a.m8537b(m);
                }
                this.f5616a.f5608f.setName(a);
                this.f5616a.f5608f.setBackgroundColor(C1111c.m6402b(this.f5616a.getActivity(), e));
            }
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1607a.m8165c(this.f5616a.getActivity(), this.f5616a.f5609g);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m8540a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
