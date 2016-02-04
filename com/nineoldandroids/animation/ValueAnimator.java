package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.frakbot.glowpadbackport.BuildConfig;

public class ValueAnimator extends Animator {
    static final int ANIMATION_FRAME = 1;
    static final int ANIMATION_START = 0;
    private static final long DEFAULT_FRAME_DELAY = 10;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    static final int RUNNING = 1;
    static final int SEEKED = 2;
    static final int STOPPED = 0;
    private static ThreadLocal<AnimationHandler> sAnimationHandler;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations;
    private static final Interpolator sDefaultInterpolator;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims;
    private static final TypeEvaluator sFloatEvaluator;
    private static long sFrameDelay;
    private static final TypeEvaluator sIntEvaluator;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations;
    private static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims;
    private float mCurrentFraction;
    private int mCurrentIteration;
    private long mDelayStartTime;
    private long mDuration;
    boolean mInitialized;
    private Interpolator mInterpolator;
    private boolean mPlayingBackwards;
    int mPlayingState;
    private int mRepeatCount;
    private int mRepeatMode;
    private boolean mRunning;
    long mSeekTime;
    private long mStartDelay;
    long mStartTime;
    private boolean mStarted;
    private boolean mStartedDelay;
    private ArrayList<AnimatorUpdateListener> mUpdateListeners;
    PropertyValuesHolder[] mValues;
    HashMap<String, PropertyValuesHolder> mValuesMap;

    /* renamed from: com.nineoldandroids.animation.ValueAnimator.1 */
    final class C10841 extends ThreadLocal<ArrayList<ValueAnimator>> {
        C10841() {
        }

        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    }

    /* renamed from: com.nineoldandroids.animation.ValueAnimator.2 */
    final class C10852 extends ThreadLocal<ArrayList<ValueAnimator>> {
        C10852() {
        }

        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    }

    /* renamed from: com.nineoldandroids.animation.ValueAnimator.3 */
    final class C10863 extends ThreadLocal<ArrayList<ValueAnimator>> {
        C10863() {
        }

        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    }

    /* renamed from: com.nineoldandroids.animation.ValueAnimator.4 */
    final class C10874 extends ThreadLocal<ArrayList<ValueAnimator>> {
        C10874() {
        }

        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    }

    /* renamed from: com.nineoldandroids.animation.ValueAnimator.5 */
    final class C10885 extends ThreadLocal<ArrayList<ValueAnimator>> {
        C10885() {
        }

        protected ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    }

    class AnimationHandler extends Handler {
        private AnimationHandler() {
        }

        public void handleMessage(Message message) {
            ArrayList arrayList;
            Object obj;
            ArrayList arrayList2;
            int size;
            int i;
            ValueAnimator valueAnimator;
            ArrayList arrayList3 = (ArrayList) ValueAnimator.sAnimations.get();
            ArrayList arrayList4 = (ArrayList) ValueAnimator.sDelayedAnims.get();
            switch (message.what) {
                case ValueAnimator.ANIMATION_START /*0*/:
                    arrayList = (ArrayList) ValueAnimator.sPendingAnimations.get();
                    obj = (arrayList3.size() > 0 || arrayList4.size() > 0) ? ValueAnimator.ANIMATION_START : ValueAnimator.RUNNING;
                    while (arrayList.size() > 0) {
                        arrayList2 = (ArrayList) arrayList.clone();
                        arrayList.clear();
                        size = arrayList2.size();
                        for (i = ValueAnimator.ANIMATION_START; i < size; i += ValueAnimator.RUNNING) {
                            valueAnimator = (ValueAnimator) arrayList2.get(i);
                            if (valueAnimator.mStartDelay == 0) {
                                valueAnimator.startAnimation();
                            } else {
                                arrayList4.add(valueAnimator);
                            }
                        }
                    }
                    break;
                case ValueAnimator.RUNNING /*1*/:
                    obj = ValueAnimator.RUNNING;
                    break;
                default:
                    return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            arrayList = (ArrayList) ValueAnimator.sReadyAnims.get();
            arrayList2 = (ArrayList) ValueAnimator.sEndingAnims.get();
            size = arrayList4.size();
            for (i = ValueAnimator.ANIMATION_START; i < size; i += ValueAnimator.RUNNING) {
                valueAnimator = (ValueAnimator) arrayList4.get(i);
                if (valueAnimator.delayedAnimationFrame(currentAnimationTimeMillis)) {
                    arrayList.add(valueAnimator);
                }
            }
            size = arrayList.size();
            if (size > 0) {
                for (i = ValueAnimator.ANIMATION_START; i < size; i += ValueAnimator.RUNNING) {
                    valueAnimator = (ValueAnimator) arrayList.get(i);
                    valueAnimator.startAnimation();
                    valueAnimator.mRunning = true;
                    arrayList4.remove(valueAnimator);
                }
                arrayList.clear();
            }
            i = arrayList3.size();
            int i2 = ValueAnimator.ANIMATION_START;
            while (i2 < i) {
                int i3;
                ValueAnimator valueAnimator2 = (ValueAnimator) arrayList3.get(i2);
                if (valueAnimator2.animationFrame(currentAnimationTimeMillis)) {
                    arrayList2.add(valueAnimator2);
                }
                if (arrayList3.size() == i) {
                    i3 = i2 + ValueAnimator.RUNNING;
                    i2 = i;
                } else {
                    i += ValueAnimator.INFINITE;
                    arrayList2.remove(valueAnimator2);
                    i3 = i2;
                    i2 = i;
                }
                i = i2;
                i2 = i3;
            }
            if (arrayList2.size() > 0) {
                for (i2 = ValueAnimator.ANIMATION_START; i2 < arrayList2.size(); i2 += ValueAnimator.RUNNING) {
                    ((ValueAnimator) arrayList2.get(i2)).endAnimation();
                }
                arrayList2.clear();
            }
            if (obj == null) {
                return;
            }
            if (!arrayList3.isEmpty() || !arrayList4.isEmpty()) {
                sendEmptyMessageDelayed(ValueAnimator.RUNNING, Math.max(0, ValueAnimator.sFrameDelay - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    public interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimator valueAnimator);
    }

    static {
        sAnimationHandler = new ThreadLocal();
        sAnimations = new C10841();
        sPendingAnimations = new C10852();
        sDelayedAnims = new C10863();
        sEndingAnims = new C10874();
        sReadyAnims = new C10885();
        sDefaultInterpolator = new AccelerateDecelerateInterpolator();
        sIntEvaluator = new IntEvaluator();
        sFloatEvaluator = new FloatEvaluator();
        sFrameDelay = DEFAULT_FRAME_DELAY;
    }

    public ValueAnimator() {
        this.mSeekTime = -1;
        this.mPlayingBackwards = false;
        this.mCurrentIteration = ANIMATION_START;
        this.mCurrentFraction = 0.0f;
        this.mStartedDelay = false;
        this.mPlayingState = ANIMATION_START;
        this.mRunning = false;
        this.mStarted = false;
        this.mInitialized = false;
        this.mDuration = 300;
        this.mStartDelay = 0;
        this.mRepeatCount = ANIMATION_START;
        this.mRepeatMode = RUNNING;
        this.mInterpolator = sDefaultInterpolator;
        this.mUpdateListeners = null;
    }

    public static void clearAllAnimations() {
        ((ArrayList) sAnimations.get()).clear();
        ((ArrayList) sPendingAnimations.get()).clear();
        ((ArrayList) sDelayedAnims.get()).clear();
    }

    private boolean delayedAnimationFrame(long j) {
        if (this.mStartedDelay) {
            long j2 = j - this.mDelayStartTime;
            if (j2 > this.mStartDelay) {
                this.mStartTime = j - (j2 - this.mStartDelay);
                this.mPlayingState = RUNNING;
                return true;
            }
        }
        this.mStartedDelay = true;
        this.mDelayStartTime = j;
        return false;
    }

    private void endAnimation() {
        ((ArrayList) sAnimations.get()).remove(this);
        ((ArrayList) sPendingAnimations.get()).remove(this);
        ((ArrayList) sDelayedAnims.get()).remove(this);
        this.mPlayingState = ANIMATION_START;
        if (this.mRunning && this.mListeners != null) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size = arrayList.size();
            for (int i = ANIMATION_START; i < size; i += RUNNING) {
                ((AnimatorListener) arrayList.get(i)).onAnimationEnd(this);
            }
        }
        this.mRunning = false;
        this.mStarted = false;
    }

    public static int getCurrentAnimationsCount() {
        return ((ArrayList) sAnimations.get()).size();
    }

    public static long getFrameDelay() {
        return sFrameDelay;
    }

    public static ValueAnimator ofFloat(float... fArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(fArr);
        return valueAnimator;
    }

    public static ValueAnimator ofInt(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        return valueAnimator;
    }

    public static ValueAnimator ofObject(TypeEvaluator typeEvaluator, Object... objArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setObjectValues(objArr);
        valueAnimator.setEvaluator(typeEvaluator);
        return valueAnimator;
    }

    public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... propertyValuesHolderArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(propertyValuesHolderArr);
        return valueAnimator;
    }

    public static void setFrameDelay(long j) {
        sFrameDelay = j;
    }

    private void start(boolean z) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.mPlayingBackwards = z;
        this.mCurrentIteration = ANIMATION_START;
        this.mPlayingState = ANIMATION_START;
        this.mStarted = true;
        this.mStartedDelay = false;
        ((ArrayList) sPendingAnimations.get()).add(this);
        if (this.mStartDelay == 0) {
            setCurrentPlayTime(getCurrentPlayTime());
            this.mPlayingState = ANIMATION_START;
            this.mRunning = true;
            if (this.mListeners != null) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = ANIMATION_START; i < size; i += RUNNING) {
                    ((AnimatorListener) arrayList.get(i)).onAnimationStart(this);
                }
            }
        }
        AnimationHandler animationHandler = (AnimationHandler) sAnimationHandler.get();
        if (animationHandler == null) {
            animationHandler = new AnimationHandler();
            sAnimationHandler.set(animationHandler);
        }
        animationHandler.sendEmptyMessage(ANIMATION_START);
    }

    private void startAnimation() {
        initAnimation();
        ((ArrayList) sAnimations.get()).add(this);
        if (this.mStartDelay > 0 && this.mListeners != null) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size = arrayList.size();
            for (int i = ANIMATION_START; i < size; i += RUNNING) {
                ((AnimatorListener) arrayList.get(i)).onAnimationStart(this);
            }
        }
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        if (this.mUpdateListeners == null) {
            this.mUpdateListeners = new ArrayList();
        }
        this.mUpdateListeners.add(animatorUpdateListener);
    }

    void animateValue(float f) {
        int i;
        float interpolation = this.mInterpolator.getInterpolation(f);
        this.mCurrentFraction = interpolation;
        int length = this.mValues.length;
        for (i = ANIMATION_START; i < length; i += RUNNING) {
            this.mValues[i].calculateValue(interpolation);
        }
        if (this.mUpdateListeners != null) {
            int size = this.mUpdateListeners.size();
            for (i = ANIMATION_START; i < size; i += RUNNING) {
                ((AnimatorUpdateListener) this.mUpdateListeners.get(i)).onAnimationUpdate(this);
            }
        }
    }

    boolean animationFrame(long j) {
        boolean z = false;
        if (this.mPlayingState == 0) {
            this.mPlayingState = RUNNING;
            if (this.mSeekTime < 0) {
                this.mStartTime = j;
            } else {
                this.mStartTime = j - this.mSeekTime;
                this.mSeekTime = -1;
            }
        }
        switch (this.mPlayingState) {
            case RUNNING /*1*/:
            case SEEKED /*2*/:
                float f;
                float f2 = this.mDuration > 0 ? ((float) (j - this.mStartTime)) / ((float) this.mDuration) : 1.0f;
                if (f2 < 1.0f) {
                    f = f2;
                } else if (this.mCurrentIteration < this.mRepeatCount || this.mRepeatCount == INFINITE) {
                    if (this.mListeners != null) {
                        int size = this.mListeners.size();
                        for (int i = ANIMATION_START; i < size; i += RUNNING) {
                            ((AnimatorListener) this.mListeners.get(i)).onAnimationRepeat(this);
                        }
                    }
                    if (this.mRepeatMode == SEEKED) {
                        this.mPlayingBackwards = !this.mPlayingBackwards;
                    }
                    this.mCurrentIteration += (int) f2;
                    f = f2 % 1.0f;
                    this.mStartTime += this.mDuration;
                } else {
                    f = Math.min(f2, 1.0f);
                    z = RUNNING;
                }
                if (this.mPlayingBackwards) {
                    f = 1.0f - f;
                }
                animateValue(f);
                break;
        }
        return z;
    }

    public void cancel() {
        if (this.mPlayingState != 0 || ((ArrayList) sPendingAnimations.get()).contains(this) || ((ArrayList) sDelayedAnims.get()).contains(this)) {
            if (this.mRunning && this.mListeners != null) {
                Iterator it = ((ArrayList) this.mListeners.clone()).iterator();
                while (it.hasNext()) {
                    ((AnimatorListener) it.next()).onAnimationCancel(this);
                }
            }
            endAnimation();
        }
    }

    public ValueAnimator clone() {
        int i = ANIMATION_START;
        ValueAnimator valueAnimator = (ValueAnimator) super.clone();
        if (this.mUpdateListeners != null) {
            ArrayList arrayList = this.mUpdateListeners;
            valueAnimator.mUpdateListeners = new ArrayList();
            int size = arrayList.size();
            for (int i2 = ANIMATION_START; i2 < size; i2 += RUNNING) {
                valueAnimator.mUpdateListeners.add(arrayList.get(i2));
            }
        }
        valueAnimator.mSeekTime = -1;
        valueAnimator.mPlayingBackwards = false;
        valueAnimator.mCurrentIteration = ANIMATION_START;
        valueAnimator.mInitialized = false;
        valueAnimator.mPlayingState = ANIMATION_START;
        valueAnimator.mStartedDelay = false;
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr != null) {
            int length = propertyValuesHolderArr.length;
            valueAnimator.mValues = new PropertyValuesHolder[length];
            valueAnimator.mValuesMap = new HashMap(length);
            while (i < length) {
                PropertyValuesHolder clone = propertyValuesHolderArr[i].clone();
                valueAnimator.mValues[i] = clone;
                valueAnimator.mValuesMap.put(clone.getPropertyName(), clone);
                i += RUNNING;
            }
        }
        return valueAnimator;
    }

    public void end() {
        if (!((ArrayList) sAnimations.get()).contains(this) && !((ArrayList) sPendingAnimations.get()).contains(this)) {
            this.mStartedDelay = false;
            startAnimation();
        } else if (!this.mInitialized) {
            initAnimation();
        }
        if (this.mRepeatCount <= 0 || (this.mRepeatCount & RUNNING) != RUNNING) {
            animateValue(1.0f);
        } else {
            animateValue(0.0f);
        }
        endAnimation();
    }

    public float getAnimatedFraction() {
        return this.mCurrentFraction;
    }

    public Object getAnimatedValue() {
        return (this.mValues == null || this.mValues.length <= 0) ? null : this.mValues[ANIMATION_START].getAnimatedValue();
    }

    public Object getAnimatedValue(String str) {
        PropertyValuesHolder propertyValuesHolder = (PropertyValuesHolder) this.mValuesMap.get(str);
        return propertyValuesHolder != null ? propertyValuesHolder.getAnimatedValue() : null;
    }

    public long getCurrentPlayTime() {
        return (!this.mInitialized || this.mPlayingState == 0) ? 0 : AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public PropertyValuesHolder[] getValues() {
        return this.mValues;
    }

    void initAnimation() {
        if (!this.mInitialized) {
            int length = this.mValues.length;
            for (int i = ANIMATION_START; i < length; i += RUNNING) {
                this.mValues[i].init();
            }
            this.mInitialized = true;
        }
    }

    public boolean isRunning() {
        return this.mPlayingState == RUNNING || this.mRunning;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void removeAllUpdateListeners() {
        if (this.mUpdateListeners != null) {
            this.mUpdateListeners.clear();
            this.mUpdateListeners = null;
        }
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        if (this.mUpdateListeners != null) {
            this.mUpdateListeners.remove(animatorUpdateListener);
            if (this.mUpdateListeners.size() == 0) {
                this.mUpdateListeners = null;
            }
        }
    }

    public void reverse() {
        this.mPlayingBackwards = !this.mPlayingBackwards;
        if (this.mPlayingState == RUNNING) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = currentAnimationTimeMillis - (this.mDuration - (currentAnimationTimeMillis - this.mStartTime));
            return;
        }
        start(true);
    }

    public void setCurrentPlayTime(long j) {
        initAnimation();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.mPlayingState != RUNNING) {
            this.mSeekTime = j;
            this.mPlayingState = SEEKED;
        }
        this.mStartTime = currentAnimationTimeMillis - j;
        animationFrame(currentAnimationTimeMillis);
    }

    public ValueAnimator setDuration(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.mDuration = j;
        return this;
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        if (typeEvaluator != null && this.mValues != null && this.mValues.length > 0) {
            this.mValues[ANIMATION_START].setEvaluator(typeEvaluator);
        }
    }

    public void setFloatValues(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            if (this.mValues == null || this.mValues.length == 0) {
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[RUNNING];
                propertyValuesHolderArr[ANIMATION_START] = PropertyValuesHolder.ofFloat(BuildConfig.FLAVOR, fArr);
                setValues(propertyValuesHolderArr);
            } else {
                this.mValues[ANIMATION_START].setFloatValues(fArr);
            }
            this.mInitialized = false;
        }
    }

    public void setIntValues(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            if (this.mValues == null || this.mValues.length == 0) {
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[RUNNING];
                propertyValuesHolderArr[ANIMATION_START] = PropertyValuesHolder.ofInt(BuildConfig.FLAVOR, iArr);
                setValues(propertyValuesHolderArr);
            } else {
                this.mValues[ANIMATION_START].setIntValues(iArr);
            }
            this.mInitialized = false;
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        if (interpolator != null) {
            this.mInterpolator = interpolator;
        } else {
            this.mInterpolator = new LinearInterpolator();
        }
    }

    public void setObjectValues(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            if (this.mValues == null || this.mValues.length == 0) {
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[RUNNING];
                propertyValuesHolderArr[ANIMATION_START] = PropertyValuesHolder.ofObject(BuildConfig.FLAVOR, (TypeEvaluator) null, objArr);
                setValues(propertyValuesHolderArr);
            } else {
                this.mValues[ANIMATION_START].setObjectValues(objArr);
            }
            this.mInitialized = false;
        }
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
    }

    public void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    public void setValues(PropertyValuesHolder... propertyValuesHolderArr) {
        int length = propertyValuesHolderArr.length;
        this.mValues = propertyValuesHolderArr;
        this.mValuesMap = new HashMap(length);
        for (int i = ANIMATION_START; i < length; i += RUNNING) {
            PropertyValuesHolder propertyValuesHolder = propertyValuesHolderArr[i];
            this.mValuesMap.put(propertyValuesHolder.getPropertyName(), propertyValuesHolder);
        }
        this.mInitialized = false;
    }

    public void start() {
        start(false);
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.mValues != null) {
            for (int i = ANIMATION_START; i < this.mValues.length; i += RUNNING) {
                str = str + "\n    " + this.mValues[i].toString();
            }
        }
        return str;
    }
}
