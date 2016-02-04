package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p013c.p014a.C0177a;
import android.support.v4.widget.C0340g;
import android.support.v7.p009c.p010a.C0406a;
import android.support.v7.p019a.C0369l;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList;
    private Mode mButtonTintMode;
    private boolean mHasButtonTint;
    private boolean mHasButtonTintMode;
    private boolean mSkipNextApply;
    private final TintManager mTintManager;
    private final CompoundButton mView;

    interface DirectSetButtonDrawableInterface {
        void setButtonDrawable(Drawable drawable);
    }

    AppCompatCompoundButtonHelper(CompoundButton compoundButton, TintManager tintManager) {
        this.mButtonTintList = null;
        this.mButtonTintMode = null;
        this.mHasButtonTint = false;
        this.mHasButtonTintMode = false;
        this.mView = compoundButton;
        this.mTintManager = tintManager;
    }

    void applyButtonTint() {
        Drawable a = C0340g.m3416a(this.mView);
        if (a == null) {
            return;
        }
        if (this.mHasButtonTint || this.mHasButtonTintMode) {
            a = C0177a.m1549c(a).mutate();
            if (this.mHasButtonTint) {
                C0177a.m1544a(a, this.mButtonTintList);
            }
            if (this.mHasButtonTintMode) {
                C0177a.m1545a(a, this.mButtonTintMode);
            }
            if (a.isStateful()) {
                a.setState(this.mView.getDrawableState());
            }
            this.mView.setButtonDrawable(a);
        }
    }

    int getCompoundPaddingLeft(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = C0340g.m3416a(this.mView);
        return a != null ? i + a.getIntrinsicWidth() : i;
    }

    ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    void loadFromAttributes(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, C0369l.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0369l.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(C0369l.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.mView.setButtonDrawable(this.mTintManager.getDrawable(resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(C0369l.CompoundButton_buttonTint)) {
                C0340g.m3417a(this.mView, obtainStyledAttributes.getColorStateList(C0369l.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C0369l.CompoundButton_buttonTintMode)) {
                C0340g.m3418a(this.mView, C0406a.m3888a(obtainStyledAttributes.getInt(C0369l.CompoundButton_buttonTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
            return;
        }
        this.mSkipNextApply = true;
        applyButtonTint();
    }

    void setSupportButtonTintList(ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    void setSupportButtonTintMode(Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }
}
