package android.support.design.widget;

import android.graphics.Outline;

/* renamed from: android.support.design.widget.j */
class C0085j extends C0084i {
    C0085j() {
    }

    public void getOutline(Outline outline) {
        copyBounds(this.b);
        outline.setOval(this.b);
    }
}
