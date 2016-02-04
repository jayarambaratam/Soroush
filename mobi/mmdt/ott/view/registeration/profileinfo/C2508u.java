package mobi.mmdt.ott.view.registeration.profileinfo;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p171e.C1610d;
import mobi.mmdt.ott.view.p178a.aj;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.registeration.profileinfo.u */
class C2508u implements LoaderCallbacks<Cursor> {
    final /* synthetic */ ProfileInfoActivity f8102a;

    C2508u(ProfileInfoActivity profileInfoActivity) {
        this.f8102a = profileInfoActivity;
    }

    public void m10831a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToFirst()) {
            C1610d c1610d = new C1610d(cursor);
            String b = c1610d.m8186b();
            String l = c1610d.m8196l();
            String c = c1610d.m8187c();
            String d = c1610d.m8188d();
            this.f8102a.f8079x = b;
            this.f8102a.f8080y = l;
            this.f8102a.f8081z = c;
            this.f8102a.f8067A = d;
            if (!(this.f8102a.f8079x == null || this.f8102a.f8079x.isEmpty() || !this.f8102a.f8074s.getText().toString().isEmpty())) {
                this.f8102a.f8074s.setText(this.f8102a.f8079x);
            }
            if (!(this.f8102a.f8080y == null || this.f8102a.f8080y.isEmpty() || !this.f8102a.f8075t.getText().toString().isEmpty())) {
                this.f8102a.f8075t.setText(this.f8102a.f8080y);
            }
            if (this.f8102a.m != null && !this.f8102a.m.isEmpty()) {
                return;
            }
            if (d == null || d.isEmpty()) {
                this.f8102a.m8569n();
                this.f8102a.m8566d(null);
                return;
            }
            this.f8102a.m = BuildConfig.FLAVOR;
            this.f8102a.m8564c(aj.m8474a(d));
            this.f8102a.m8566d(aj.m8474a(d));
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1607a.m8165c(this.f8102a.getApplicationContext(), C1309a.m6934a(this.f8102a.getApplicationContext()).m6942b());
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m10831a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
