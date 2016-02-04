package com.p032a.p033a.p061i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.p032a.p033a.p037d.C0667c;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.a.a.i.a */
public final class C0869a {
    private static final ConcurrentHashMap<String, C0667c> f3037a;

    static {
        f3037a = new ConcurrentHashMap();
    }

    public static C0667c m5257a(Context context) {
        String packageName = context.getPackageName();
        C0667c c0667c = (C0667c) f3037a.get(packageName);
        if (c0667c != null) {
            return c0667c;
        }
        C0667c b = C0869a.m5258b(context);
        c0667c = (C0667c) f3037a.putIfAbsent(packageName, b);
        return c0667c == null ? b : c0667c;
    }

    private static C0667c m5258b(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return new C0871c(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
    }
}
