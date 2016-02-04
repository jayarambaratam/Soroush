package mobi.mmdt.ott.view.components.mediaselector.photoselection;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mobi.mmdt.ott.view.components.mediaselector.p206b.C1896c;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.photoselection.d */
class C1912d implements LoaderCallbacks<Cursor> {
    final /* synthetic */ C1911c f6135a;
    private final String[] f6136b;

    C1912d(C1911c c1911c) {
        this.f6135a = c1911c;
        this.f6136b = new String[]{"_data", "_display_name", "datetaken", "_id"};
    }

    public void m9141a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null) {
            int count = cursor.getCount();
            List arrayList = new ArrayList();
            if (count > 0) {
                cursor.moveToFirst();
                int i = 0;
                do {
                    String string = cursor.getString(cursor.getColumnIndexOrThrow(this.f6136b[0]));
                    if (new File(string).getParentFile().getAbsolutePath().equals(this.f6135a.f6128g)) {
                        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(this.f6136b[1]));
                        long j = cursor.getLong(cursor.getColumnIndexOrThrow(this.f6136b[2]));
                        boolean z = this.f6135a.m9132e().containsKey(string) && ((Boolean) this.f6135a.m9132e().get(string)).booleanValue();
                        arrayList.add(new C1896c(i, string2, string, string, j, z));
                        i++;
                    }
                } while (cursor.moveToNext());
                this.f6135a.f6123b.m8656a(arrayList);
            }
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this.f6135a.getActivity(), Media.EXTERNAL_CONTENT_URI, this.f6136b, this.f6136b[0] + " like '%" + this.f6135a.f6128g + "%'", null, this.f6136b[2] + " DESC");
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m9141a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
