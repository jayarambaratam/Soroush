package com.p032a.p033a.p059f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.a.a.f.b */
public final class C0829b {
    private final Context f2935a;

    public C0829b(Context context) {
        this.f2935a = context;
    }

    private static C0828a m5104a(String str) {
        try {
            Object newInstance;
            try {
                newInstance = Class.forName(str).newInstance();
                if (newInstance instanceof C0828a) {
                    return (C0828a) newInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (Throwable e) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + newInstance, e);
            } catch (Throwable e2) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + newInstance, e2);
            }
        } catch (Throwable e3) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e3);
        }
    }

    public List<C0828a> m5105a() {
        List<C0828a> arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f2935a.getPackageManager().getApplicationInfo(this.f2935a.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                for (String str : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(C0829b.m5104a(str));
                    }
                }
            }
            return arrayList;
        } catch (Throwable e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }
}
