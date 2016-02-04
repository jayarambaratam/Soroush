package android.support.design.widget;

import android.support.v4.view.C0077a;
import android.support.v4.view.p017a.C0284g;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class cl extends C0077a {
    final /* synthetic */ TextInputLayout f561a;

    private cl(TextInputLayout textInputLayout) {
        this.f561a = textInputLayout;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0284g c0284g) {
        super.onInitializeAccessibilityNodeInfo(view, c0284g);
        c0284g.m1955b(TextInputLayout.class.getSimpleName());
        CharSequence i = this.f561a.f425q.m814i();
        if (!TextUtils.isEmpty(i)) {
            c0284g.m1960c(i);
        }
        if (this.f561a.f409a != null) {
            c0284g.m1965d(this.f561a.f409a);
        }
        i = this.f561a.f414f != null ? this.f561a.f414f.getText() : null;
        if (!TextUtils.isEmpty(i)) {
            c0284g.m1980j(true);
            c0284g.m1969e(i);
        }
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        CharSequence i = this.f561a.f425q.m814i();
        if (!TextUtils.isEmpty(i)) {
            accessibilityEvent.getText().add(i);
        }
    }
}
