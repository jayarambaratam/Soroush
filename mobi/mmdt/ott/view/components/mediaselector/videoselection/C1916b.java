package mobi.mmdt.ott.view.components.mediaselector.videoselection;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore.Video.Media;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mobi.mmdt.ott.view.components.mediaselector.p206b.C1897d;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.videoselection.b */
class C1916b implements LoaderCallbacks<Cursor> {
    final /* synthetic */ C1915a f6148a;
    private final String[] f6149b;

    C1916b(C1915a c1915a) {
        this.f6148a = c1915a;
        this.f6149b = new String[]{"_data", "_display_name", "datetaken", "_id"};
    }

    public void m9151a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null) {
            int count = cursor.getCount();
            List arrayList = new ArrayList();
            if (count > 0) {
                cursor.moveToFirst();
                int i = 0;
                do {
                    String string = cursor.getString(cursor.getColumnIndexOrThrow(this.f6149b[0]));
                    if (new File(string).getParentFile().getAbsolutePath().equals(this.f6148a.f6145g)) {
                        arrayList.add(new C1897d(i, cursor.getString(cursor.getColumnIndexOrThrow(this.f6149b[1])), string, string, cursor.getLong(cursor.getColumnIndexOrThrow(this.f6149b[2]))));
                        i++;
                    }
                } while (cursor.moveToNext());
                this.f6148a.f6140b.m8656a(arrayList);
            }
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this.f6148a.getActivity(), Media.EXTERNAL_CONTENT_URI, this.f6149b, this.f6149b[0] + " like '%" + this.f6148a.f6145g + "%'", null, this.f6149b[2] + " DESC");
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m9151a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
