package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.app.p */
class C0390p {
    public Method f1902a;
    public Method f1903b;
    public ImageView f1904c;

    C0390p(Activity activity) {
        try {
            this.f1902a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
            this.f1903b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
        } catch (NoSuchMethodException e) {
            View findViewById = activity.findViewById(16908332);
            if (findViewById != null) {
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                if (viewGroup.getChildCount() == 2) {
                    View childAt = viewGroup.getChildAt(0);
                    findViewById = viewGroup.getChildAt(1);
                    if (childAt.getId() != 16908332) {
                        findViewById = childAt;
                    }
                    if (findViewById instanceof ImageView) {
                        this.f1904c = (ImageView) findViewById;
                    }
                }
            }
        }
    }
}
