package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

class an implements Factory {
    final ar f1325a;

    an(ar arVar) {
        this.f1325a = arVar;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.f1325a.m1389a(null, str, context, attributeSet);
    }

    public String toString() {
        return getClass().getName() + "{" + this.f1325a + "}";
    }
}
