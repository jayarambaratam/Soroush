package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

class ViewPropertyAnimatorHC extends ViewPropertyAnimator {
    private static final int ALPHA = 512;
    private static final int NONE = 0;
    private static final int ROTATION = 16;
    private static final int ROTATION_X = 32;
    private static final int ROTATION_Y = 64;
    private static final int SCALE_X = 4;
    private static final int SCALE_Y = 8;
    private static final int TRANSFORM_MASK = 511;
    private static final int TRANSLATION_X = 1;
    private static final int TRANSLATION_Y = 2;
    private static final int f4096X = 128;
    private static final int f4097Y = 256;
    private Runnable mAnimationStarter;
    private AnimatorEventListener mAnimatorEventListener;
    private HashMap<Animator, PropertyBundle> mAnimatorMap;
    private long mDuration;
    private boolean mDurationSet;
    private Interpolator mInterpolator;
    private boolean mInterpolatorSet;
    private AnimatorListener mListener;
    ArrayList<NameValuesHolder> mPendingAnimations;
    private long mStartDelay;
    private boolean mStartDelaySet;
    private final WeakReference<View> mView;

    /* renamed from: com.nineoldandroids.view.ViewPropertyAnimatorHC.1 */
    class C10891 implements Runnable {
        C10891() {
        }

        public void run() {
            ViewPropertyAnimatorHC.this.startAnimation();
        }
    }

    class AnimatorEventListener implements AnimatorListener, AnimatorUpdateListener {
        private AnimatorEventListener() {
        }

        public void onAnimationCancel(Animator animator) {
            if (ViewPropertyAnimatorHC.this.mListener != null) {
                ViewPropertyAnimatorHC.this.mListener.onAnimationCancel(animator);
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (ViewPropertyAnimatorHC.this.mListener != null) {
                ViewPropertyAnimatorHC.this.mListener.onAnimationEnd(animator);
            }
            ViewPropertyAnimatorHC.this.mAnimatorMap.remove(animator);
            if (ViewPropertyAnimatorHC.this.mAnimatorMap.isEmpty()) {
                ViewPropertyAnimatorHC.this.mListener = null;
            }
        }

        public void onAnimationRepeat(Animator animator) {
            if (ViewPropertyAnimatorHC.this.mListener != null) {
                ViewPropertyAnimatorHC.this.mListener.onAnimationRepeat(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (ViewPropertyAnimatorHC.this.mListener != null) {
                ViewPropertyAnimatorHC.this.mListener.onAnimationStart(animator);
            }
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            PropertyBundle propertyBundle = (PropertyBundle) ViewPropertyAnimatorHC.this.mAnimatorMap.get(valueAnimator);
            if ((propertyBundle.mPropertyMask & ViewPropertyAnimatorHC.TRANSFORM_MASK) != 0) {
                View view = (View) ViewPropertyAnimatorHC.this.mView.get();
                if (view != null) {
                    view.invalidate();
                }
            }
            ArrayList arrayList = propertyBundle.mNameValuesHolder;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = ViewPropertyAnimatorHC.NONE; i < size; i += ViewPropertyAnimatorHC.TRANSLATION_X) {
                    NameValuesHolder nameValuesHolder = (NameValuesHolder) arrayList.get(i);
                    ViewPropertyAnimatorHC.this.setValue(nameValuesHolder.mNameConstant, nameValuesHolder.mFromValue + (nameValuesHolder.mDeltaValue * animatedFraction));
                }
            }
            View view2 = (View) ViewPropertyAnimatorHC.this.mView.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    class NameValuesHolder {
        float mDeltaValue;
        float mFromValue;
        int mNameConstant;

        NameValuesHolder(int i, float f, float f2) {
            this.mNameConstant = i;
            this.mFromValue = f;
            this.mDeltaValue = f2;
        }
    }

    class PropertyBundle {
        ArrayList<NameValuesHolder> mNameValuesHolder;
        int mPropertyMask;

        PropertyBundle(int i, ArrayList<NameValuesHolder> arrayList) {
            this.mPropertyMask = i;
            this.mNameValuesHolder = arrayList;
        }

        boolean cancel(int i) {
            if (!((this.mPropertyMask & i) == 0 || this.mNameValuesHolder == null)) {
                int size = this.mNameValuesHolder.size();
                for (int i2 = ViewPropertyAnimatorHC.NONE; i2 < size; i2 += ViewPropertyAnimatorHC.TRANSLATION_X) {
                    if (((NameValuesHolder) this.mNameValuesHolder.get(i2)).mNameConstant == i) {
                        this.mNameValuesHolder.remove(i2);
                        this.mPropertyMask &= i ^ -1;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    ViewPropertyAnimatorHC(View view) {
        this.mDurationSet = false;
        this.mStartDelay = 0;
        this.mStartDelaySet = false;
        this.mInterpolatorSet = false;
        this.mListener = null;
        this.mAnimatorEventListener = new AnimatorEventListener();
        this.mPendingAnimations = new ArrayList();
        this.mAnimationStarter = new C10891();
        this.mAnimatorMap = new HashMap();
        this.mView = new WeakReference(view);
    }

    private void animateProperty(int i, float f) {
        float value = getValue(i);
        animatePropertyBy(i, value, f - value);
    }

    private void animatePropertyBy(int i, float f) {
        animatePropertyBy(i, getValue(i), f);
    }

    private void animatePropertyBy(int i, float f, float f2) {
        if (this.mAnimatorMap.size() > 0) {
            for (Animator animator : this.mAnimatorMap.keySet()) {
                PropertyBundle propertyBundle = (PropertyBundle) this.mAnimatorMap.get(animator);
                if (propertyBundle.cancel(i) && propertyBundle.mPropertyMask == 0) {
                    break;
                }
            }
            Animator animator2 = null;
            if (animator2 != null) {
                animator2.cancel();
            }
        }
        this.mPendingAnimations.add(new NameValuesHolder(i, f, f2));
        View view = (View) this.mView.get();
        if (view != null) {
            view.removeCallbacks(this.mAnimationStarter);
            view.post(this.mAnimationStarter);
        }
    }

    private float getValue(int i) {
        View view = (View) this.mView.get();
        if (view != null) {
            switch (i) {
                case TRANSLATION_X /*1*/:
                    return view.getTranslationX();
                case TRANSLATION_Y /*2*/:
                    return view.getTranslationY();
                case SCALE_X /*4*/:
                    return view.getScaleX();
                case SCALE_Y /*8*/:
                    return view.getScaleY();
                case ROTATION /*16*/:
                    return view.getRotation();
                case ROTATION_X /*32*/:
                    return view.getRotationX();
                case ROTATION_Y /*64*/:
                    return view.getRotationY();
                case f4096X /*128*/:
                    return view.getX();
                case f4097Y /*256*/:
                    return view.getY();
                case ALPHA /*512*/:
                    return view.getAlpha();
            }
        }
        return 0.0f;
    }

    private void setValue(int i, float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            switch (i) {
                case TRANSLATION_X /*1*/:
                    view.setTranslationX(f);
                case TRANSLATION_Y /*2*/:
                    view.setTranslationY(f);
                case SCALE_X /*4*/:
                    view.setScaleX(f);
                case SCALE_Y /*8*/:
                    view.setScaleY(f);
                case ROTATION /*16*/:
                    view.setRotation(f);
                case ROTATION_X /*32*/:
                    view.setRotationX(f);
                case ROTATION_Y /*64*/:
                    view.setRotationY(f);
                case f4096X /*128*/:
                    view.setX(f);
                case f4097Y /*256*/:
                    view.setY(f);
                case ALPHA /*512*/:
                    view.setAlpha(f);
                default:
            }
        }
    }

    private void startAnimation() {
        float[] fArr = new float[TRANSLATION_X];
        fArr[NONE] = 1.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ArrayList arrayList = (ArrayList) this.mPendingAnimations.clone();
        this.mPendingAnimations.clear();
        int i = NONE;
        for (int i2 = NONE; i2 < arrayList.size(); i2 += TRANSLATION_X) {
            i |= ((NameValuesHolder) arrayList.get(i2)).mNameConstant;
        }
        this.mAnimatorMap.put(ofFloat, new PropertyBundle(i, arrayList));
        ofFloat.addUpdateListener(this.mAnimatorEventListener);
        ofFloat.addListener(this.mAnimatorEventListener);
        if (this.mStartDelaySet) {
            ofFloat.setStartDelay(this.mStartDelay);
        }
        if (this.mDurationSet) {
            ofFloat.setDuration(this.mDuration);
        }
        if (this.mInterpolatorSet) {
            ofFloat.setInterpolator(this.mInterpolator);
        }
        ofFloat.start();
    }

    public ViewPropertyAnimator alpha(float f) {
        animateProperty(ALPHA, f);
        return this;
    }

    public ViewPropertyAnimator alphaBy(float f) {
        animatePropertyBy(ALPHA, f);
        return this;
    }

    public void cancel() {
        if (this.mAnimatorMap.size() > 0) {
            for (Animator cancel : ((HashMap) this.mAnimatorMap.clone()).keySet()) {
                cancel.cancel();
            }
        }
        this.mPendingAnimations.clear();
        View view = (View) this.mView.get();
        if (view != null) {
            view.removeCallbacks(this.mAnimationStarter);
        }
    }

    public long getDuration() {
        return this.mDurationSet ? this.mDuration : new ValueAnimator().getDuration();
    }

    public long getStartDelay() {
        return this.mStartDelaySet ? this.mStartDelay : 0;
    }

    public ViewPropertyAnimator rotation(float f) {
        animateProperty(ROTATION, f);
        return this;
    }

    public ViewPropertyAnimator rotationBy(float f) {
        animatePropertyBy(ROTATION, f);
        return this;
    }

    public ViewPropertyAnimator rotationX(float f) {
        animateProperty(ROTATION_X, f);
        return this;
    }

    public ViewPropertyAnimator rotationXBy(float f) {
        animatePropertyBy(ROTATION_X, f);
        return this;
    }

    public ViewPropertyAnimator rotationY(float f) {
        animateProperty(ROTATION_Y, f);
        return this;
    }

    public ViewPropertyAnimator rotationYBy(float f) {
        animatePropertyBy(ROTATION_Y, f);
        return this;
    }

    public ViewPropertyAnimator scaleX(float f) {
        animateProperty(SCALE_X, f);
        return this;
    }

    public ViewPropertyAnimator scaleXBy(float f) {
        animatePropertyBy(SCALE_X, f);
        return this;
    }

    public ViewPropertyAnimator scaleY(float f) {
        animateProperty(SCALE_Y, f);
        return this;
    }

    public ViewPropertyAnimator scaleYBy(float f) {
        animatePropertyBy(SCALE_Y, f);
        return this;
    }

    public ViewPropertyAnimator setDuration(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.mDurationSet = true;
        this.mDuration = j;
        return this;
    }

    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        this.mInterpolatorSet = true;
        this.mInterpolator = interpolator;
        return this;
    }

    public ViewPropertyAnimator setListener(AnimatorListener animatorListener) {
        this.mListener = animatorListener;
        return this;
    }

    public ViewPropertyAnimator setStartDelay(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.mStartDelaySet = true;
        this.mStartDelay = j;
        return this;
    }

    public void start() {
        startAnimation();
    }

    public ViewPropertyAnimator translationX(float f) {
        animateProperty(TRANSLATION_X, f);
        return this;
    }

    public ViewPropertyAnimator translationXBy(float f) {
        animatePropertyBy(TRANSLATION_X, f);
        return this;
    }

    public ViewPropertyAnimator translationY(float f) {
        animateProperty(TRANSLATION_Y, f);
        return this;
    }

    public ViewPropertyAnimator translationYBy(float f) {
        animatePropertyBy(TRANSLATION_Y, f);
        return this;
    }

    public ViewPropertyAnimator m6339x(float f) {
        animateProperty(f4096X, f);
        return this;
    }

    public ViewPropertyAnimator xBy(float f) {
        animatePropertyBy(f4096X, f);
        return this;
    }

    public ViewPropertyAnimator m6340y(float f) {
        animateProperty(f4097Y, f);
        return this;
    }

    public ViewPropertyAnimator yBy(float f) {
        animatePropertyBy(f4097Y, f);
        return this;
    }
}
