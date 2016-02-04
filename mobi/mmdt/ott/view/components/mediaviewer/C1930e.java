package mobi.mmdt.ott.view.components.mediaviewer;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* renamed from: mobi.mmdt.ott.view.components.mediaviewer.e */
class C1930e implements Runnable {
    final /* synthetic */ Cursor f6197a;
    final /* synthetic */ MediaViewerActivity f6198b;

    C1930e(MediaViewerActivity mediaViewerActivity, Cursor cursor) {
        this.f6198b = mediaViewerActivity;
        this.f6197a = cursor;
    }

    public void run() {
        this.f6198b.f6165s = true;
        List arrayList = new ArrayList();
        int i = 0;
        if (this.f6197a.moveToFirst()) {
            do {
                arrayList.add(this.f6198b.m9160a(this.f6197a, this.f6197a.getPosition()));
                if (this.f6197a.getString(this.f6197a.getColumnIndex("files_file_uri")).equals(this.f6198b.f6163q)) {
                    i = this.f6197a.getPosition();
                }
            } while (this.f6197a.moveToNext());
        }
        this.f6198b.f6164r = i;
        this.f6198b.runOnUiThread(new C1931f(this, arrayList));
    }
}
