package com.nineoldandroids.view.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy extends Animation {
    public static final boolean NEEDS_PROXY;
    private static final WeakHashMap<View, AnimatorProxy> PROXIES;
    private final RectF mAfter;
    private float mAlpha;
    private final RectF mBefore;
    private final Camera mCamera;
    private boolean mHasPivot;
    private float mPivotX;
    private float mPivotY;
    private float mRotationX;
    private float mRotationY;
    private float mRotationZ;
    private float mScaleX;
    private float mScaleY;
    private final Matrix mTempMatrix;
    private float mTranslationX;
    private float mTranslationY;
    private final WeakReference<View> mView;

    static {
        NEEDS_PROXY = Integer.valueOf(VERSION.SDK).intValue() < 11;
        PROXIES = new WeakHashMap();
    }

    private AnimatorProxy(View view) {
        this.mCamera = new Camera();
        this.mAlpha = 1.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mBefore = new RectF();
        this.mAfter = new RectF();
        this.mTempMatrix = new Matrix();
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.mView = new WeakReference(view);
    }

    private void computeRect(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.mTempMatrix;
        matrix.reset();
        transformMatrix(matrix, view);
        this.mTempMatrix.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        if (rectF.right < rectF.left) {
            float f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            f = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f;
        }
    }

    private void invalidateAfterUpdate() {
        View view = (View) this.mView.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.mAfter;
            computeRect(rectF, view);
            rectF.union(this.mBefore);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    private void prepareForUpdate() {
        View view = (View) this.mView.get();
        if (view != null) {
            computeRect(this.mBefore, view);
        }
    }

    private void transformMatrix(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z = this.mHasPivot;
        float f = z ? this.mPivotX : width / 2.0f;
        float f2 = z ? this.mPivotY : height / 2.0f;
        float f3 = this.mRotationX;
        float f4 = this.mRotationY;
        float f5 = this.mRotationZ;
        if (!(f3 == 0.0f && f4 == 0.0f && f5 == 0.0f)) {
            Camera camera = this.mCamera;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        f3 = this.mScaleX;
        f4 = this.mScaleY;
        if (!(f3 == 1.0f && f4 == 1.0f)) {
            matrix.postScale(f3, f4);
            matrix.postTranslate((-(f / width)) * ((f3 * width) - width), (-(f2 / height)) * ((f4 * height) - height));
        }
        matrix.postTranslate(this.mTranslationX, this.mTranslationY);
    }

    public static AnimatorProxy wrap(View view) {
        Animation animation = (AnimatorProxy) PROXIES.get(view);
        if (animation != null && animation == view.getAnimation()) {
            return animation;
        }
        AnimatorProxy animatorProxy = new AnimatorProxy(view);
        PROXIES.put(view, animatorProxy);
        return animatorProxy;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        View view = (View) this.mView.get();
        if (view != null) {
            transformation.setAlpha(this.mAlpha);
            transformMatrix(transformation.getMatrix(), view);
        }
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getPivotX() {
        return this.mPivotX;
    }

    public float getPivotY() {
        return this.mPivotY;
    }

    public float getRotation() {
        return this.mRotationZ;
    }

    public float getRotationX() {
        return this.mRotationX;
    }

    public float getRotationY() {
        return this.mRotationY;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public int getScrollX() {
        View view = (View) this.mView.get();
        return view == null ? 0 : view.getScrollX();
    }

    public int getScrollY() {
        View view = (View) this.mView.get();
        return view == null ? 0 : view.getScrollY();
    }

    public float getTranslationX() {
        return this.mTranslationX;
    }

    public float getTranslationY() {
        return this.mTranslationY;
    }

    public float getX() {
        View view = (View) this.mView.get();
        return view == null ? 0.0f : ((float) view.getLeft()) + this.mTranslationX;
    }

    public float getY() {
        View view = (View) this.mView.get();
        return view == null ? 0.0f : ((float) view.getTop()) + this.mTranslationY;
    }

    public void setAlpha(float f) {
        if (this.mAlpha != f) {
            this.mAlpha = f;
            View view = (View) this.mView.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void setPivotX(float f) {
        if (!this.mHasPivot || this.mPivotX != f) {
            prepareForUpdate();
            this.mHasPivot = true;
            this.mPivotX = f;
            invalidateAfterUpdate();
        }
    }

    public void setPivotY(float f) {
        if (!this.mHasPivot || this.mPivotY != f) {
            prepareForUpdate();
            this.mHasPivot = true;
            this.mPivotY = f;
            invalidateAfterUpdate();
        }
    }

    public void setRotation(float f) {
        if (this.mRotationZ != f) {
            prepareForUpdate();
            this.mRotationZ = f;
            invalidateAfterUpdate();
        }
    }

    public void setRotationX(float f) {
        if (this.mRotationX != f) {
            prepareForUpdate();
            this.mRotationX = f;
            invalidateAfterUpdate();
        }
    }

    public void setRotationY(float f) {
        if (this.mRotationY != f) {
            prepareForUpdate();
            this.mRotationY = f;
            invalidateAfterUpdate();
        }
    }

    public void setScaleX(float f) {
        if (this.mScaleX != f) {
            prepareForUpdate();
            this.mScaleX = f;
            invalidateAfterUpdate();
        }
    }

    public void setScaleY(float f) {
        if (this.mScaleY != f) {
            prepareForUpdate();
            this.mScaleY = f;
            invalidateAfterUpdate();
        }
    }

    public void setScrollX(int i) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.scrollTo(i, view.getScrollY());
        }
    }

    public void setScrollY(int i) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i);
        }
    }

    public void setTranslationX(float f) {
        if (this.mTranslationX != f) {
            prepareForUpdate();
            this.mTranslationX = f;
            invalidateAfterUpdate();
        }
    }

    public void setTranslationY(float f) {
        if (this.mTranslationY != f) {
            prepareForUpdate();
            this.mTranslationY = f;
            invalidateAfterUpdate();
        }
    }

    public void setX(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            setTranslationX(f - ((float) view.getLeft()));
        }
    }

    public void setY(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            setTranslationY(f - ((float) view.getTop()));
        }
    }
}
