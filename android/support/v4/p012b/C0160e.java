package android.support.v4.p012b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.os.C0262c;

/* renamed from: android.support.v4.b.e */
class C0160e implements C0159d {
    C0160e() {
    }

    public Cursor m1516a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, C0262c c0262c) {
        if (c0262c != null) {
            c0262c.m1800b();
        }
        return contentResolver.query(uri, strArr, str, strArr2, str2);
    }
}
