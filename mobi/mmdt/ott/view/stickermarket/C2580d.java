package mobi.mmdt.ott.view.stickermarket;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import mobi.mmdt.ott.provider.p175i.C1635a;
import mobi.mmdt.ott.provider.p175i.C1638d;

/* renamed from: mobi.mmdt.ott.view.stickermarket.d */
class C2580d implements LoaderCallbacks<Cursor> {
    final /* synthetic */ StickerDetailsActivity f8284a;

    C2580d(StickerDetailsActivity stickerDetailsActivity) {
        this.f8284a = stickerDetailsActivity;
    }

    public void m11023a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null) {
            C1638d c1638d = new C1638d(cursor);
            if (c1638d.moveToFirst() && this.f8284a.f8234t != null) {
                this.f8284a.runOnUiThread(new C2581e(this, c1638d));
            }
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1635a.m8340b(this.f8284a.getApplicationContext(), this.f8284a.f8223i);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m11023a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
