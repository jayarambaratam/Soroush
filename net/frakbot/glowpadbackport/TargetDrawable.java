package net.frakbot.glowpadbackport;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import java.lang.reflect.Method;

public class TargetDrawable {
    private static final boolean DEBUG = false;
    public static final int[] STATE_ACTIVE;
    public static final int[] STATE_FOCUSED;
    public static final int[] STATE_INACTIVE;
    private static final String TAG = "TargetDrawable";
    static Method mGetStateCount;
    static Method mGetStateDrawable;
    static Method mGetStateDrawableIndex;
    private float mAlpha;
    private Drawable mDrawable;
    private boolean mEnabled;
    private float mPositionX;
    private float mPositionY;
    private final int mResourceId;
    private float mScaleX;
    private float mScaleY;
    private float mTranslationX;
    private float mTranslationY;

    class DrawableWithAlpha extends Drawable {
        private float mAlpha;
        private Drawable mRealDrawable;

        public DrawableWithAlpha(Drawable drawable) {
            this.mAlpha = 1.0f;
            this.mRealDrawable = drawable;
        }

        public void draw(Canvas canvas) {
            this.mRealDrawable.setAlpha(Math.round(this.mAlpha * 255.0f));
            this.mRealDrawable.draw(canvas);
        }

        public int getAlpha() {
            return this.mRealDrawable.getAlpha();
        }

        public int getAlphaFloat() {
            return (int) (this.mAlpha * 255.0f);
        }

        public int getOpacity() {
            return this.mRealDrawable.getOpacity();
        }

        public void setAlpha(int i) {
            this.mRealDrawable.setAlpha(i);
        }

        public void setAlphaFloat(float f) {
            this.mAlpha = f;
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.mRealDrawable.setColorFilter(colorFilter);
        }
    }

    static {
        STATE_ACTIVE = new int[]{16842910, 16842914};
        STATE_INACTIVE = new int[]{16842910, -16842914};
        STATE_FOCUSED = new int[]{16842910, -16842914, 16842908};
        try {
            mGetStateCount = StateListDrawable.class.getDeclaredMethod("getStateCount", new Class[0]);
            mGetStateCount.setAccessible(true);
        } catch (Throwable e) {
            Log.e(TAG, "Couldn't access the StateListDrawable#getStateCount() method. Some stuff might break!", e);
        }
        try {
            mGetStateDrawable = StateListDrawable.class.getDeclaredMethod("getStateDrawable", new Class[]{Integer.TYPE});
            mGetStateDrawable.setAccessible(true);
        } catch (Throwable e2) {
            Log.e(TAG, "Couldn't access the StateListDrawable#getStateDrawable(int) method. Some stuff might break!", e2);
        }
        try {
            mGetStateDrawableIndex = StateListDrawable.class.getDeclaredMethod("getStateDrawableIndex", new Class[]{int[].class});
            mGetStateDrawableIndex.setAccessible(true);
        } catch (Throwable e22) {
            Log.e(TAG, "Couldn't access the StateListDrawable#mGetStateDrawableIndex(int[]) method. Some stuff might break!", e22);
        }
    }

    public TargetDrawable(Resources resources, int i) {
        this.mTranslationX = 0.0f;
        this.mTranslationY = 0.0f;
        this.mPositionX = 0.0f;
        this.mPositionY = 0.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mAlpha = 1.0f;
        this.mEnabled = true;
        this.mResourceId = i;
        setDrawable(resources, i);
    }

    public TargetDrawable(TargetDrawable targetDrawable) {
        this.mTranslationX = 0.0f;
        this.mTranslationY = 0.0f;
        this.mPositionX = 0.0f;
        this.mPositionY = 0.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mAlpha = 1.0f;
        this.mEnabled = true;
        this.mResourceId = targetDrawable.mResourceId;
        this.mDrawable = targetDrawable.mDrawable != null ? targetDrawable.mDrawable.mutate() : null;
        resizeDrawables();
        setState(STATE_INACTIVE);
    }

    private void resizeDrawables() {
        if (this.mDrawable instanceof StateListDrawable) {
            int i;
            StateListDrawable stateListDrawable = (StateListDrawable) this.mDrawable;
            Integer valueOf = Integer.valueOf(0);
            try {
                valueOf = (Integer) mGetStateCount.invoke(stateListDrawable, new Object[0]);
            } catch (Throwable e) {
                Log.w(TAG, "StateListDrawable#getStateCount() call failed!", e);
            }
            int i2 = 0;
            int i3 = 0;
            for (i = 0; i < valueOf.intValue(); i++) {
                try {
                    Drawable drawable = (Drawable) mGetStateDrawable.invoke(stateListDrawable, new Object[]{Integer.valueOf(i)});
                    i3 = Math.max(i3, drawable.getIntrinsicWidth());
                    i2 = Math.max(i2, drawable.getIntrinsicHeight());
                } catch (Throwable e2) {
                    Log.w(TAG, "StateListDrawable#getStateDrawable(int) call failed!", e2);
                }
            }
            stateListDrawable.setBounds(0, 0, i3, i2);
            for (i = 0; i < valueOf.intValue(); i++) {
                try {
                    ((Drawable) mGetStateDrawable.invoke(stateListDrawable, new Object[]{Integer.valueOf(i)})).setBounds(0, 0, i3, i2);
                } catch (Throwable e22) {
                    Log.w(TAG, "StateListDrawable#getStateDrawable(int) call failed!", e22);
                }
            }
        } else if (this.mDrawable != null) {
            this.mDrawable.setBounds(0, 0, this.mDrawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
        }
    }

    public void draw(Canvas canvas) {
        if (this.mDrawable != null && this.mEnabled) {
            canvas.save(1);
            canvas.scale(this.mScaleX, this.mScaleY, this.mPositionX, this.mPositionY);
            canvas.translate(this.mTranslationX + this.mPositionX, this.mTranslationY + this.mPositionY);
            canvas.translate(((float) getWidth()) * -0.5f, ((float) getHeight()) * -0.5f);
            this.mDrawable.setAlpha(Math.round(this.mAlpha * 255.0f));
            this.mDrawable.draw(canvas);
            canvas.restore();
        }
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public int getHeight() {
        return this.mDrawable != null ? this.mDrawable.getIntrinsicHeight() : 0;
    }

    public float getPositionX() {
        return this.mPositionX;
    }

    public float getPositionY() {
        return this.mPositionY;
    }

    public int getResourceId() {
        return this.mResourceId;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public int getWidth() {
        return this.mDrawable != null ? this.mDrawable.getIntrinsicWidth() : 0;
    }

    public float getX() {
        return this.mTranslationX;
    }

    public float getY() {
        return this.mTranslationY;
    }

    public boolean hasState(int[] iArr) {
        if (this.mDrawable instanceof StateListDrawable) {
            try {
                return ((Integer) mGetStateDrawableIndex.invoke((StateListDrawable) this.mDrawable, new Object[]{iArr})).intValue() != -1 ? true : DEBUG;
            } catch (Throwable e) {
                Log.w(TAG, "StateListDrawable#getStateDrawableIndex(int[]) call failed!", e);
            }
        }
        return DEBUG;
    }

    public boolean isActive() {
        if (!(this.mDrawable instanceof StateListDrawable)) {
            return DEBUG;
        }
        int[] state = ((StateListDrawable) this.mDrawable).getState();
        for (int i : state) {
            if (i == 16842908) {
                return true;
            }
        }
        return DEBUG;
    }

    public boolean isEnabled() {
        return (this.mDrawable == null || !this.mEnabled) ? DEBUG : true;
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
    }

    public void setDrawable(Resources resources, int i) {
        Drawable drawable = null;
        Drawable drawable2 = i == 0 ? null : resources.getDrawable(i);
        if (drawable2 != null) {
            drawable = drawable2.mutate();
        }
        this.mDrawable = drawable;
        resizeDrawables();
        setState(STATE_INACTIVE);
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public void setPositionX(float f) {
        this.mPositionX = f;
    }

    public void setPositionY(float f) {
        this.mPositionY = f;
    }

    public void setScaleX(float f) {
        this.mScaleX = f;
    }

    public void setScaleY(float f) {
        this.mScaleY = f;
    }

    public void setState(int[] iArr) {
        if (this.mDrawable instanceof StateListDrawable) {
            ((StateListDrawable) this.mDrawable).setState(iArr);
        }
    }

    public void setX(float f) {
        this.mTranslationX = f;
    }

    public void setY(float f) {
        this.mTranslationY = f;
    }
}
