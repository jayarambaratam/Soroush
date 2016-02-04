package com.p032a.p033a.p037d.p038a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import org.jivesoftware.smack.sm.packet.StreamManagement.AckRequest;

/* renamed from: com.a.a.d.a.e */
public class C0591e extends C0590j<ParcelFileDescriptor> {
    public C0591e(Context context, Uri uri) {
        super(context, uri);
    }

    protected ParcelFileDescriptor m4463a(Uri uri, ContentResolver contentResolver) {
        return contentResolver.openAssetFileDescriptor(uri, AckRequest.ELEMENT).getParcelFileDescriptor();
    }

    protected void m4464a(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }

    protected /* synthetic */ Object m4466b(Uri uri, ContentResolver contentResolver) {
        return m4463a(uri, contentResolver);
    }
}
