package com.p032a.p033a.p037d.p038a;

import android.content.res.AssetManager;
import java.io.InputStream;

/* renamed from: com.a.a.d.a.k */
public class C0596k extends C0587a<InputStream> {
    public C0596k(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    protected /* synthetic */ Object m4476a(AssetManager assetManager, String str) {
        return m4479b(assetManager, str);
    }

    protected void m4477a(InputStream inputStream) {
        inputStream.close();
    }

    protected InputStream m4479b(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}
