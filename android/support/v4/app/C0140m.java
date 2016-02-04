package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v4.app.m */
abstract class C0140m extends C0139l {
    C0140m() {
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = m1295a(view, str, context, attributeSet);
        return (a != null || VERSION.SDK_INT < 11) ? a : super.onCreateView(view, str, context, attributeSet);
    }
}
