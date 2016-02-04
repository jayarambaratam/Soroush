package com.p032a.p033a.p037d.p038a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

/* renamed from: com.a.a.d.a.l */
public class C0597l extends C0590j<InputStream> {
    public C0597l(Context context, Uri uri) {
        super(context, uri);
    }

    protected InputStream m4480a(Uri uri, ContentResolver contentResolver) {
        return contentResolver.openInputStream(uri);
    }

    protected void m4481a(InputStream inputStream) {
        inputStream.close();
    }

    protected /* synthetic */ Object m4483b(Uri uri, ContentResolver contentResolver) {
        return m4480a(uri, contentResolver);
    }
}
