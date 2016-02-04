package mobi.mmdt.ott.view.components.mediaselector;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore.Video.Media;
import android.support.v4.app.aw;
import android.support.v4.p012b.C0154t;
import android.support.v4.p012b.C0167m;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import mobi.mmdt.ott.view.components.mediaselector.p206b.C1895b;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.j */
class C1905j implements aw<Cursor> {
    final /* synthetic */ C1904i f6107a;
    private final String[] f6108b;

    C1905j(C1904i c1904i) {
        this.f6107a = c1904i;
        this.f6108b = new String[]{"_data", "_display_name", "datetaken", "_id"};
    }

    public C0154t<Cursor> m9104a(int i, Bundle bundle) {
        return new C0167m(this.f6107a.m979c(), Media.EXTERNAL_CONTENT_URI, this.f6108b, null, null, this.f6108b[2] + " DESC");
    }

    public void m9105a(C0154t<Cursor> c0154t) {
    }

    public void m9106a(C0154t<Cursor> c0154t, Cursor cursor) {
        int i = 0;
        if (cursor != null) {
            int count = cursor.getCount();
            List arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            if (count > 0) {
                cursor.moveToFirst();
                do {
                    long j = cursor.getLong(cursor.getColumnIndexOrThrow(this.f6108b[2]));
                    String string = cursor.getString(cursor.getColumnIndexOrThrow(this.f6108b[0]));
                    File parentFile = new File(string).getParentFile();
                    String absolutePath = parentFile.getAbsolutePath();
                    if (hashMap.containsKey(absolutePath)) {
                        C1907m c1907m = (C1907m) hashMap.get(absolutePath);
                        c1907m.f6113d++;
                    } else {
                        C1907m c1907m2 = new C1907m();
                        c1907m2.f6113d = 1;
                        c1907m2.f6110a = parentFile.getName();
                        c1907m2.f6111b = absolutePath;
                        c1907m2.f6112c = string;
                        c1907m2.f6114e = j;
                        hashMap.put(absolutePath, c1907m2);
                    }
                } while (cursor.moveToNext());
                for (Entry value : hashMap.entrySet()) {
                    C1907m c1907m3 = (C1907m) value.getValue();
                    arrayList.add(new C1895b(i, c1907m3.f6110a, c1907m3.f6111b, c1907m3.f6112c, c1907m3.f6113d + BuildConfig.FLAVOR, c1907m3.f6114e));
                    i++;
                }
                Collections.sort(arrayList);
                this.f6107a.ab.m8656a(arrayList);
            }
        }
    }
}
