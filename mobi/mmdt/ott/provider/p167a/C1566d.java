package mobi.mmdt.ott.provider.p167a;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: mobi.mmdt.ott.provider.a.d */
public abstract class C1566d extends ContentProvider {
    protected SQLiteOpenHelper f5248a;

    public static Uri m7881a(Uri uri, boolean z) {
        return uri.buildUpon().appendQueryParameter("QUERY_NOTIFY", String.valueOf(z)).build();
    }

    private String[] m7882a(String[] strArr, String str, String str2) {
        if (strArr == null) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str2)) {
                strArr2[i] = str + "." + str2 + " AS " + "_id";
            } else {
                strArr2[i] = strArr[i];
            }
        }
        return strArr2;
    }

    public static Uri m7883c(Uri uri, String str) {
        return uri.buildUpon().appendQueryParameter("QUERY_GROUP_BY", str).build();
    }

    public static Uri m7884d(Uri uri, String str) {
        return uri.buildUpon().appendQueryParameter("QUERY_HAVING", str).build();
    }

    public static Uri m7885e(Uri uri, String str) {
        return uri.buildUpon().appendQueryParameter("QUERY_LIMIT", str).build();
    }

    public Cursor m7886a(Uri uri, String str) {
        Cursor rawQuery = this.f5248a.getReadableDatabase().rawQuery(str, null);
        rawQuery.setNotificationUri(getContext().getContentResolver(), uri);
        return rawQuery;
    }

    protected abstract SQLiteOpenHelper m7887a();

    protected abstract C1570e m7888a(Uri uri, String str, String[] strArr);

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        HashSet hashSet = new HashSet(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashSet.add(((ContentProviderOperation) it.next()).getUri());
        }
        SQLiteDatabase writableDatabase = this.f5248a.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[arrayList.size()];
            Iterator it2 = arrayList.iterator();
            int i = 0;
            while (it2.hasNext()) {
                ContentProviderOperation contentProviderOperation = (ContentProviderOperation) it2.next();
                contentProviderResultArr[i] = contentProviderOperation.apply(this, contentProviderResultArr, i);
                if (contentProviderOperation.isYieldAllowed()) {
                    writableDatabase.yieldIfContendedSafely();
                }
                i++;
            }
            writableDatabase.setTransactionSuccessful();
            it = hashSet.iterator();
            while (it.hasNext()) {
                getContext().getContentResolver().notifyChange((Uri) it.next(), null);
            }
            return contentProviderResultArr;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public void m7889b(Uri uri, String str) {
        this.f5248a.getReadableDatabase().execSQL(str);
        getContext().getContentResolver().notifyChange(uri, null);
    }

    protected abstract boolean m7890b();

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        int i = 0;
        String lastPathSegment = uri.getLastPathSegment();
        SQLiteDatabase writableDatabase = this.f5248a.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            for (ContentValues insert : contentValuesArr) {
                long insert2 = writableDatabase.insert(lastPathSegment, null, insert);
                writableDatabase.yieldIfContendedSafely();
                if (insert2 != -1) {
                    i++;
                }
            }
            writableDatabase.setTransactionSuccessful();
            if (i != 0) {
                String queryParameter = uri.getQueryParameter("QUERY_NOTIFY");
                if (queryParameter == null || "true".equals(queryParameter)) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
            }
            return i;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        C1570e a = m7888a(uri, str, null);
        int delete = this.f5248a.getWritableDatabase().delete(a.f5259a, a.f5262d, strArr);
        if (delete != 0) {
            String queryParameter = uri.getQueryParameter("QUERY_NOTIFY");
            if (queryParameter == null || "true".equals(queryParameter)) {
                getContext().getContentResolver().notifyChange(uri, null);
            }
        }
        return delete;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        long insertOrThrow = this.f5248a.getWritableDatabase().insertOrThrow(uri.getLastPathSegment(), null, contentValues);
        if (insertOrThrow == -1) {
            return null;
        }
        String queryParameter = uri.getQueryParameter("QUERY_NOTIFY");
        if (queryParameter == null || "true".equals(queryParameter)) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return uri.buildUpon().appendEncodedPath(String.valueOf(insertOrThrow)).build();
    }

    public final boolean onCreate() {
        if (m7890b()) {
            try {
                Field declaredField = Class.forName("android.database.sqlite.SQLiteDebug").getDeclaredField("DEBUG_SQL_STATEMENTS");
                declaredField.setAccessible(true);
                declaredField.set(null, Boolean.valueOf(true));
            } catch (Throwable th) {
                if (m7890b()) {
                    Log.w(getClass().getSimpleName(), "Could not enable SQLiteDebug logging", th);
                }
            }
        }
        this.f5248a = m7887a();
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String queryParameter = uri.getQueryParameter("QUERY_GROUP_BY");
        String queryParameter2 = uri.getQueryParameter("QUERY_HAVING");
        String queryParameter3 = uri.getQueryParameter("QUERY_LIMIT");
        C1570e a = m7888a(uri, str, strArr);
        Cursor query = this.f5248a.getReadableDatabase().query(a.f5260b, m7882a(strArr, a.f5259a, a.f5261c), a.f5262d, strArr2, queryParameter, queryParameter2, str2 == null ? a.f5263e : str2, queryParameter3);
        query.setNotificationUri(getContext().getContentResolver(), uri);
        return query;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C1570e a = m7888a(uri, str, null);
        int update = this.f5248a.getWritableDatabase().update(a.f5259a, contentValues, a.f5262d, strArr);
        if (update != 0) {
            String queryParameter = uri.getQueryParameter("QUERY_NOTIFY");
            if (queryParameter == null || "true".equals(queryParameter)) {
                getContext().getContentResolver().notifyChange(uri, null);
            }
        }
        return update;
    }
}
