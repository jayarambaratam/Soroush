package android.support.design.widget;

import android.graphics.drawable.Drawable;

class aa implements ax {
    final /* synthetic */ FloatingActionButton f431a;

    aa(FloatingActionButton floatingActionButton) {
        this.f431a = floatingActionButton;
    }

    public float m481a() {
        return ((float) this.f431a.getSizeDimension()) / 2.0f;
    }

    public void m482a(int i, int i2, int i3, int i4) {
        this.f431a.f353g.set(i, i2, i3, i4);
        this.f431a.setPadding(this.f431a.f352f + i, this.f431a.f352f + i2, this.f431a.f352f + i3, this.f431a.f352f + i4);
    }

    public void m483a(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }
}
