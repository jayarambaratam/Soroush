package android.support.v4.p012b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.os.C0262c;
import android.support.v4.os.C0268i;

/* renamed from: android.support.v4.b.f */
class C0161f extends C0160e {
    C0161f() {
    }

    public Cursor m1517a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, C0262c c0262c) {
        Object d;
        if (c0262c != null) {
            try {
                d = c0262c.m1802d();
            } catch (Exception e) {
                if (C0162g.m1519a(e)) {
                    throw new C0268i();
                }
                throw e;
            }
        }
        d = null;
        return C0162g.m1518a(contentResolver, uri, strArr, str, strArr2, str2, d);
    }
}
