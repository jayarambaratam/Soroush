package mobi.mmdt.ott.provider.p170d;

import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
import mobi.mmdt.ott.provider.p167a.C1569c;

/* renamed from: mobi.mmdt.ott.provider.d.g */
public class C1602g extends C1569c<C1602g> {
    public ArrayList<Uri> m8137a(Context context, ContentValues[] contentValuesArr) {
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("mobi.mmdt.ott.provider");
        ContentProvider localContentProvider = acquireContentProviderClient.getLocalContentProvider();
        ArrayList<Uri> arrayList = new ArrayList();
        for (ContentValues insert : contentValuesArr) {
            arrayList.add(localContentProvider.insert(m7917f(), insert));
        }
        acquireContentProviderClient.release();
        return arrayList;
    }

    public C1601f m8138a(Context context, String[] strArr) {
        Cursor query = context.getContentResolver().query(m7917f(), strArr, m7914c(), m7915d(), m7916e());
        return query == null ? null : new C1601f(query);
    }

    public C1602g m8139a(String... strArr) {
        m7908a("files_file_uri", (Object[]) strArr);
        return this;
    }

    public C1602g m8140a(C1603h... c1603hArr) {
        m7908a("files_audio_state", (Object[]) c1603hArr);
        return this;
    }

    public C1602g m8141a(C1604i... c1604iArr) {
        m7908a("files_download_state", (Object[]) c1604iArr);
        return this;
    }

    public C1601f m8142b(Context context) {
        return m8138a(context, null);
    }

    public C1602g m8143b(long... jArr) {
        m7908a("files._id", m7911a(jArr));
        return this;
    }

    protected Uri m8144g() {
        return C1599d.f5376a;
    }
}
