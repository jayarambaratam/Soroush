package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public class ci {
    static final cn f1661a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 18) {
            f1661a = new cl();
        } else if (i >= 17) {
            f1661a = new ck();
        } else if (i >= 16) {
            f1661a = new cm();
        } else {
            f1661a = new cj();
        }
    }

    public static int m3355a(TextView textView) {
        return f1661a.m3357a(textView);
    }

    public static void m3356a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f1661a.m3358a(textView, drawable, drawable2, drawable3, drawable4);
    }
}
