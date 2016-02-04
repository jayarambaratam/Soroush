package com.felipecsl.asymmetricgridview.library.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

@TargetApi(11)
/* renamed from: com.felipecsl.asymmetricgridview.library.widget.i */
public class C1061i extends LinearLayout {
    private final C1055a f3994a;

    public C1061i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3994a = C1055a.f3972a ? C1055a.m6258a((View) this) : null;
    }

    public float getAlpha() {
        return C1055a.f3972a ? this.f3994a.m6263a() : super.getAlpha();
    }

    public float getTranslationX() {
        return C1055a.f3972a ? this.f3994a.m6265b() : super.getTranslationX();
    }

    public void setAlpha(float f) {
        if (C1055a.f3972a) {
            this.f3994a.m6264a(f);
        } else {
            super.setAlpha(f);
        }
    }

    public void setTranslationX(float f) {
        if (C1055a.f3972a) {
            this.f3994a.m6266b(f);
        } else {
            super.setTranslationX(f);
        }
    }

    public void setVisibility(int i) {
        if (this.f3994a != null) {
            if (i == 8) {
                clearAnimation();
            } else if (i == 0) {
                setAnimation(this.f3994a);
            }
        }
        super.setVisibility(i);
    }
}
