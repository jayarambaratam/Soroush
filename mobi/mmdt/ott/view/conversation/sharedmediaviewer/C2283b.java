package mobi.mmdt.ott.view.conversation.sharedmediaviewer;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import mobi.mmdt.ott.provider.p169c.C1583c;

/* renamed from: mobi.mmdt.ott.view.conversation.sharedmediaviewer.b */
class C2283b implements LoaderCallbacks<Cursor> {
    final /* synthetic */ C2279a f7528a;

    C2283b(C2279a c2279a) {
        this.f7528a = c2279a;
    }

    public void m10290a(Loader<Cursor> loader, Cursor cursor) {
        if (this.f7528a.f7513b != null) {
            this.f7528a.f7513b.m8748c(cursor);
            this.f7528a.f7519h.setVisibility(8);
            this.f7528a.f7515d.m10269a(cursor.getCount());
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1583c.m7999j(this.f7528a.getActivity(), this.f7528a.f7518g);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m10290a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        if (this.f7528a.f7513b != null) {
            this.f7528a.f7513b.m8748c(null);
        }
    }
}
