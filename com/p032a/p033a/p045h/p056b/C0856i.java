package com.p032a.p033a.p045h.p056b;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;

/* renamed from: com.a.a.h.b.i */
public class C0856i extends C0742b {
    private C0742b f2969a;
    private C0857j f2970b;
    private boolean f2971c;

    public C0856i(C0742b c0742b, int i) {
        this(new C0857j(c0742b.getConstantState(), i), c0742b, null);
    }

    C0856i(C0857j c0857j, C0742b c0742b, Resources resources) {
        this.f2970b = c0857j;
        if (c0742b != null) {
            this.f2969a = c0742b;
        } else if (resources != null) {
            this.f2969a = (C0742b) c0857j.f2972a.newDrawable(resources);
        } else {
            this.f2969a = (C0742b) c0857j.f2972a.newDrawable();
        }
    }

    public void m5172a(int i) {
        this.f2969a.m4841a(i);
    }

    public boolean m5173a() {
        return this.f2969a.m4842a();
    }

    public void clearColorFilter() {
        this.f2969a.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        this.f2969a.draw(canvas);
    }

    @TargetApi(19)
    public int getAlpha() {
        return this.f2969a.getAlpha();
    }

    @TargetApi(11)
    public Callback getCallback() {
        return this.f2969a.getCallback();
    }

    public int getChangingConfigurations() {
        return this.f2969a.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        return this.f2970b;
    }

    public Drawable getCurrent() {
        return this.f2969a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f2970b.f2973b;
    }

    public int getIntrinsicWidth() {
        return this.f2970b.f2973b;
    }

    public int getMinimumHeight() {
        return this.f2969a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f2969a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f2969a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f2969a.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.f2969a.invalidateSelf();
    }

    public boolean isRunning() {
        return this.f2969a.isRunning();
    }

    public Drawable mutate() {
        if (!this.f2971c && super.mutate() == this) {
            this.f2969a = (C0742b) this.f2969a.mutate();
            this.f2970b = new C0857j(this.f2970b);
            this.f2971c = true;
        }
        return this;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.f2969a.scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f2969a.setAlpha(i);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f2969a.setBounds(i, i2, i3, i4);
    }

    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.f2969a.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f2969a.setChangingConfigurations(i);
    }

    public void setColorFilter(int i, Mode mode) {
        this.f2969a.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2969a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f2969a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f2969a.setFilterBitmap(z);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.f2969a.setVisible(z, z2);
    }

    public void start() {
        this.f2969a.start();
    }

    public void stop() {
        this.f2969a.stop();
    }

    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f2969a.unscheduleSelf(runnable);
    }
}
