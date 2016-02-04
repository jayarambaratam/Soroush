package android.support.v4.p012b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.os.C0262c;

/* renamed from: android.support.v4.b.c */
public class C0158c {
    private static final C0159d f1079a;

    static {
        if (VERSION.SDK_INT >= 16) {
            f1079a = new C0161f();
        } else {
            f1079a = new C0160e();
        }
    }

    public static Cursor m1514a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, C0262c c0262c) {
        return f1079a.m1515a(contentResolver, uri, strArr, str, strArr2, str2, c0262c);
    }
}
