package com.felipecsl.asymmetricgridview.library;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* renamed from: com.felipecsl.asymmetricgridview.library.o */
public class C1054o {
    public static int m6244a(Context context) {
        return context == null ? 0 : C1054o.m6246b(context).widthPixels;
    }

    public static int m6245a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static DisplayMetrics m6246b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
}
