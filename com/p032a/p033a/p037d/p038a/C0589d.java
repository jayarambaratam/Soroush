package com.p032a.p033a.p037d.p038a;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;

/* renamed from: com.a.a.d.a.d */
public class C0589d extends C0587a<ParcelFileDescriptor> {
    public C0589d(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    protected /* synthetic */ Object m4453a(AssetManager assetManager, String str) {
        return m4456b(assetManager, str);
    }

    protected void m4454a(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }

    protected ParcelFileDescriptor m4456b(AssetManager assetManager, String str) {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
