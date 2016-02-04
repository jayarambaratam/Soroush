package mobi.mmdt.ott.view.conversation.emojisticker.sticker;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import java.util.ArrayList;
import mobi.mmdt.ott.provider.p174h.C1629b;
import mobi.mmdt.ott.provider.p174h.C1632e;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.sticker.c */
class C2223c implements LoaderCallbacks<Cursor> {
    final /* synthetic */ C2222b f7324a;

    C2223c(C2222b c2222b) {
        this.f7324a = c2222b;
    }

    public void m10120a(Loader<Cursor> loader, Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null) {
            C1632e c1632e = new C1632e(cursor);
            if (c1632e.moveToFirst()) {
                do {
                    arrayList.add(new StickerItemViewModel(c1632e.m8316d(), c1632e.m8315c(), c1632e.m8314b(), c1632e.m8313a(), c1632e.m8322j(), c1632e.m8323k(), c1632e.m8320h(), c1632e.m8321i(), c1632e.m8317e(), c1632e.m8319g()));
                } while (c1632e.moveToNext());
            }
        }
        this.f7324a.f7321e.runOnUiThread(new C2224d(this, arrayList));
        this.f7324a.f7321e.getLoaderManager().destroyLoader(this.f7324a.f7320d);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1629b.m8291a(this.f7324a.f7321e, this.f7324a.f7320d);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m10120a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        this.f7324a.f7321e.runOnUiThread(new C2225e(this, new ArrayList()));
    }
}
