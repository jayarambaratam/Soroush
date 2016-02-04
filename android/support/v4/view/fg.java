package android.support.v4.view;

import android.view.WindowInsets;

class fg extends ff {
    private final WindowInsets f1389a;

    fg(WindowInsets windowInsets) {
        this.f1389a = windowInsets;
    }

    public int m2904a() {
        return this.f1389a.getSystemWindowInsetLeft();
    }

    public ff m2905a(int i, int i2, int i3, int i4) {
        return new fg(this.f1389a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    public int m2906b() {
        return this.f1389a.getSystemWindowInsetTop();
    }

    public int m2907c() {
        return this.f1389a.getSystemWindowInsetRight();
    }

    public int m2908d() {
        return this.f1389a.getSystemWindowInsetBottom();
    }

    public boolean m2909e() {
        return this.f1389a.isConsumed();
    }

    public ff m2910f() {
        return new fg(this.f1389a.consumeSystemWindowInsets());
    }

    WindowInsets m2911g() {
        return this.f1389a;
    }
}
