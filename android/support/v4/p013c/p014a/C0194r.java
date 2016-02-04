package android.support.v4.p013c.p014a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* renamed from: android.support.v4.c.a.r */
class C0194r extends Drawable implements Callback, C0193q {
    static final Mode f1097a;
    Drawable f1098b;
    private ColorStateList f1099c;
    private Mode f1100d;
    private int f1101e;
    private Mode f1102f;
    private boolean f1103g;

    static {
        f1097a = Mode.SRC_IN;
    }

    C0194r(Drawable drawable) {
        this.f1100d = f1097a;
        m1614a(drawable);
    }

    private boolean m1612a(int[] iArr) {
        if (this.f1099c == null || this.f1100d == null) {
            this.f1103g = false;
            clearColorFilter();
        } else {
            int colorForState = this.f1099c.getColorForState(iArr, this.f1099c.getDefaultColor());
            Mode mode = this.f1100d;
            if (!(this.f1103g && colorForState == this.f1101e && mode == this.f1102f)) {
                setColorFilter(colorForState, mode);
                this.f1101e = colorForState;
                this.f1102f = mode;
                this.f1103g = true;
                return true;
            }
        }
        return false;
    }

    public Drawable m1613a() {
        return this.f1098b;
    }

    public void m1614a(Drawable drawable) {
        if (this.f1098b != null) {
            this.f1098b.setCallback(null);
        }
        this.f1098b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        this.f1098b.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f1098b.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f1098b.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f1098b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f1098b.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f1098b.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f1098b.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f1098b.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f1098b.getPadding(rect);
    }

    public int[] getState() {
        return this.f1098b.getState();
    }

    public Region getTransparentRegion() {
        return this.f1098b.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        return (this.f1099c != null && this.f1099c.isStateful()) || this.f1098b.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.f1098b;
        Drawable mutate = drawable.mutate();
        if (mutate != drawable) {
            m1614a(mutate);
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        this.f1098b.setBounds(rect);
    }

    protected boolean onLevelChange(int i) {
        return this.f1098b.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f1098b.setAlpha(i);
    }

    public void setChangingConfigurations(int i) {
        this.f1098b.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1098b.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f1098b.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1098b.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return m1612a(iArr) || this.f1098b.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1099c = colorStateList;
        m1612a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f1100d = mode;
        m1612a(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1098b.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
