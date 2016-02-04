package android.support.v4.p012b;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;

/* renamed from: android.support.v4.b.h */
public class C0125h {
    public static final Drawable m1018a(Context context, int i) {
        return VERSION.SDK_INT >= 21 ? C0163i.m1520a(context, i) : context.getResources().getDrawable(i);
    }

    public static boolean m1019a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            C0166l.m1523a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0165k.m1522a(context, intentArr);
            return true;
        }
    }

    public static final int m1020b(Context context, int i) {
        return VERSION.SDK_INT >= 23 ? C0164j.m1521a(context, i) : context.getResources().getColor(i);
    }
}
