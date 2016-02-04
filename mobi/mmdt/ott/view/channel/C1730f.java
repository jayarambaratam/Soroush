package mobi.mmdt.ott.view.channel;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.provider.p168b.C1573b;
import mobi.mmdt.ott.provider.p168b.C1576e;
import mobi.mmdt.ott.view.p178a.aj;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.channel.f */
class C1730f implements LoaderCallbacks<Cursor> {
    final /* synthetic */ ChannelInfoActivity f5707a;

    C1730f(ChannelInfoActivity channelInfoActivity) {
        this.f5707a = channelInfoActivity;
    }

    public void m8671a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToFirst()) {
            C1576e c1576e = new C1576e(cursor);
            String a = c1576e.m7938a();
            int g = c1576e.m7944g();
            this.f5707a.m8559a(c1576e.m7939b());
            this.f5707a.f5634q.setText(c1576e.m7942e());
            this.f5707a.m8561b(C1111c.m6407c(g));
            this.f5707a.f5640w = C1111c.m6397a(a);
            this.f5707a.l.setOnClickListener(new C1731g(this));
            a = c1576e.m7941d();
            this.f5707a.f5641x = c1576e.m7940c();
            this.f5707a.f5642y = c1576e.m7939b();
            if (a == null || a.isEmpty()) {
                this.f5707a.f5641x = null;
                this.f5707a.m8569n();
                this.f5707a.m8566d(null);
                return;
            }
            this.f5707a.m = BuildConfig.FLAVOR;
            this.f5707a.m8564c(aj.m8474a(a));
            this.f5707a.m8566d(aj.m8474a(a));
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1573b.m7926d(this.f5707a.getApplicationContext(), this.f5707a.f5636s);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m8671a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
