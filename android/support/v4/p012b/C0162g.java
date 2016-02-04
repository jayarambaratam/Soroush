package android.support.v4.p012b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

/* renamed from: android.support.v4.b.g */
class C0162g {
    public static Cursor m1518a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
        return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
    }

    static boolean m1519a(Exception exception) {
        return exception instanceof OperationCanceledException;
    }
}
