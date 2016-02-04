package com.p077d.p078a;

import android.util.TypedValue;
import android.view.View;

/* renamed from: com.d.a.i */
class C1025i {
    static int m6158a(int i, View view) {
        return (int) TypedValue.applyDimension(1, (float) i, view.getResources().getDisplayMetrics());
    }
}
