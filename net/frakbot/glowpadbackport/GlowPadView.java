package net.frakbot.glowpadbackport;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityManager;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.ArrayList;
import mobi.mmdt.ott.C1317h;
import net.frakbot.glowpadbackport.util.Const;
import net.frakbot.glowpadbackport.util.TimeInterpolator;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.linphone.mediastream.Version;

public class GlowPadView extends View {
    private static final boolean DEBUG = false;
    private static final int HIDE_ANIMATION_DELAY = 200;
    private static final int HIDE_ANIMATION_DURATION = 200;
    private static final int INITIAL_SHOW_HANDLE_DURATION = 200;
    private static final int RETURN_TO_HOME_DELAY = 1200;
    private static final int RETURN_TO_HOME_DURATION = 200;
    private static final int REVEAL_GLOW_DELAY = 0;
    private static final int REVEAL_GLOW_DURATION = 0;
    private static final float RING_SCALE_COLLAPSED = 0.5f;
    private static final float RING_SCALE_EXPANDED = 1.0f;
    private static final int SHOW_ANIMATION_DELAY = 50;
    private static final int SHOW_ANIMATION_DURATION = 200;
    private static final float SNAP_MARGIN_DEFAULT = 20.0f;
    private static final int STATE_FINISH = 5;
    private static final int STATE_FIRST_TOUCH = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_SNAP = 4;
    private static final int STATE_START = 1;
    private static final int STATE_TRACKING = 3;
    private static final String TAG = "GlowPadView";
    private static final float TAP_RADIUS_SCALE_ACCESSIBILITY_ENABLED = 1.3f;
    private static final float TARGET_SCALE_COLLAPSED = 0.8f;
    private static final float TARGET_SCALE_EXPANDED = 1.0f;
    private static final int WAVE_ANIMATION_DURATION = 1350;
    private int mActiveTarget;
    private boolean mAllowScaling;
    private boolean mAlwaysTrackFinger;
    private boolean mAnimatingTargets;
    private Tweener mBackgroundAnimator;
    private ArrayList<String> mDirectionDescriptions;
    private int mDirectionDescriptionsResourceId;
    private boolean mDragging;
    private int mFeedbackCount;
    private float mFirstItemOffset;
    private AnimationBundle mGlowAnimations;
    private float mGlowRadius;
    private int mGrabbedState;
    private int mGravity;
    private TargetDrawable mHandleDrawable;
    private int mHorizontalInset;
    private boolean mInitialLayout;
    private float mInnerRadius;
    private boolean mMagneticTargets;
    private int mMaxTargetHeight;
    private int mMaxTargetWidth;
    private int mNewTargetResources;
    private OnTriggerListener mOnTriggerListener;
    private float mOuterRadius;
    private TargetDrawable mOuterRing;
    private PointCloud mPointCloud;
    private int mPointerId;
    private AnimatorListener mResetListener;
    private AnimatorListener mResetListenerWithPing;
    private float mRingScaleFactor;
    private float mSnapMargin;
    private AnimationBundle mTargetAnimations;
    private ArrayList<String> mTargetDescriptions;
    private int mTargetDescriptionsResourceId;
    private ArrayList<TargetDrawable> mTargetDrawables;
    private int mTargetResourceId;
    private AnimatorListener mTargetUpdateListener;
    private AnimatorUpdateListener mUpdateListener;
    private int mVerticalInset;
    private int mVibrationDuration;
    private Vibrator mVibrator;
    private AnimationBundle mWaveAnimations;
    private float mWaveCenterX;
    private float mWaveCenterY;

    public interface OnTriggerListener {
        public static final int CENTER_HANDLE = 1;
        public static final int NO_HANDLE = 0;

        void onFinishFinalAnimation();

        void onGrabbed(View view, int i);

        void onGrabbedStateChange(View view, int i);

        void onReleased(View view, int i);

        void onTrigger(View view, int i);
    }

    /* renamed from: net.frakbot.glowpadbackport.GlowPadView.1 */
    class C26271 extends AnimatorListenerAdapter {
        C26271() {
        }

        public void onAnimationEnd(Animator animator) {
            GlowPadView.this.switchToState(GlowPadView.STATE_IDLE, GlowPadView.this.mWaveCenterX, GlowPadView.this.mWaveCenterY);
            GlowPadView.this.dispatchOnFinishFinalAnimation();
        }
    }

    /* renamed from: net.frakbot.glowpadbackport.GlowPadView.2 */
    class C26282 extends AnimatorListenerAdapter {
        C26282() {
        }

        public void onAnimationEnd(Animator animator) {
            GlowPadView.this.ping();
            GlowPadView.this.switchToState(GlowPadView.STATE_IDLE, GlowPadView.this.mWaveCenterX, GlowPadView.this.mWaveCenterY);
            GlowPadView.this.dispatchOnFinishFinalAnimation();
        }
    }

    /* renamed from: net.frakbot.glowpadbackport.GlowPadView.3 */
    class C26293 implements AnimatorUpdateListener {
        C26293() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            GlowPadView.this.invalidate();
        }
    }

    /* renamed from: net.frakbot.glowpadbackport.GlowPadView.4 */
    class C26304 extends AnimatorListenerAdapter {
        C26304() {
        }

        public void onAnimationEnd(Animator animator) {
            if (GlowPadView.this.mNewTargetResources != 0) {
                GlowPadView.this.internalSetTargetResources(GlowPadView.this.mNewTargetResources);
                GlowPadView.this.mNewTargetResources = GlowPadView.STATE_IDLE;
                GlowPadView.this.hideTargets(GlowPadView.DEBUG, GlowPadView.DEBUG);
            }
            GlowPadView.this.mAnimatingTargets = GlowPadView.DEBUG;
        }
    }

    /* renamed from: net.frakbot.glowpadbackport.GlowPadView.5 */
    class C26315 extends AnimatorListenerAdapter {
        C26315() {
        }

        public void onAnimationEnd(Animator animator) {
            GlowPadView.this.mPointCloud.waveManager.setRadius(0.0f);
            GlowPadView.this.mPointCloud.waveManager.setAlpha(0.0f);
        }
    }

    class AnimationBundle extends ArrayList<Tweener> {
        private static final long serialVersionUID = -6319262269245852568L;
        private boolean mSuspended;

        private AnimationBundle() {
        }

        public void cancel() {
            int size = size();
            for (int i = GlowPadView.STATE_IDLE; i < size; i += GlowPadView.STATE_START) {
                ((Tweener) get(i)).animator.cancel();
            }
            clear();
        }

        public void setSuspended(boolean z) {
            this.mSuspended = z;
        }

        public void start() {
            if (!this.mSuspended) {
                int size = size();
                for (int i = GlowPadView.STATE_IDLE; i < size; i += GlowPadView.STATE_START) {
                    ((Tweener) get(i)).animator.start();
                }
            }
        }

        public void stop() {
            int size = size();
            for (int i = GlowPadView.STATE_IDLE; i < size; i += GlowPadView.STATE_START) {
                ((Tweener) get(i)).animator.end();
            }
            clear();
        }
    }

    public GlowPadView(Context context) {
        this(context, null);
    }

    public GlowPadView(Context context, AttributeSet attributeSet) {
        boolean z = DEBUG;
        super(context, attributeSet);
        this.mTargetDrawables = new ArrayList();
        this.mWaveAnimations = new AnimationBundle();
        this.mTargetAnimations = new AnimationBundle();
        this.mGlowAnimations = new AnimationBundle();
        this.mFeedbackCount = STATE_TRACKING;
        this.mVibrationDuration = STATE_IDLE;
        this.mActiveTarget = -1;
        this.mRingScaleFactor = TARGET_SCALE_EXPANDED;
        this.mOuterRadius = 0.0f;
        this.mSnapMargin = 0.0f;
        this.mFirstItemOffset = 0.0f;
        this.mMagneticTargets = DEBUG;
        this.mResetListener = new C26271();
        this.mResetListenerWithPing = new C26282();
        this.mUpdateListener = new C26293();
        this.mTargetUpdateListener = new C26304();
        this.mGravity = 48;
        this.mInitialLayout = true;
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2632R.styleable.GlowPadView);
        this.mInnerRadius = obtainStyledAttributes.getDimension(C2632R.styleable.GlowPadView_innerRadius, this.mInnerRadius);
        this.mOuterRadius = obtainStyledAttributes.getDimension(C2632R.styleable.GlowPadView_outerRadius, this.mOuterRadius);
        this.mSnapMargin = obtainStyledAttributes.getDimension(C2632R.styleable.GlowPadView_snapMargin, this.mSnapMargin);
        this.mFirstItemOffset = (float) Math.toRadians((double) obtainStyledAttributes.getFloat(C2632R.styleable.GlowPadView_firstItemOffset, (float) Math.toDegrees((double) this.mFirstItemOffset)));
        this.mVibrationDuration = obtainStyledAttributes.getInt(C2632R.styleable.GlowPadView_vibrationDuration, this.mVibrationDuration);
        this.mFeedbackCount = obtainStyledAttributes.getInt(C2632R.styleable.GlowPadView_feedbackCount, this.mFeedbackCount);
        this.mAllowScaling = obtainStyledAttributes.getBoolean(C2632R.styleable.GlowPadView_allowScaling, DEBUG);
        TypedValue peekValue = obtainStyledAttributes.peekValue(C2632R.styleable.GlowPadView_handleDrawable);
        this.mHandleDrawable = new TargetDrawable(resources, peekValue != null ? peekValue.resourceId : STATE_IDLE);
        this.mHandleDrawable.setState(TargetDrawable.STATE_INACTIVE);
        this.mOuterRing = new TargetDrawable(resources, getResourceId(obtainStyledAttributes, C2632R.styleable.GlowPadView_outerRingDrawable));
        this.mAlwaysTrackFinger = obtainStyledAttributes.getBoolean(C2632R.styleable.GlowPadView_alwaysTrackFinger, DEBUG);
        this.mMagneticTargets = obtainStyledAttributes.getBoolean(C2632R.styleable.GlowPadView_magneticTargets, this.mMagneticTargets);
        int resourceId = getResourceId(obtainStyledAttributes, C2632R.styleable.GlowPadView_pointDrawable);
        Drawable drawable = resourceId != 0 ? resources.getDrawable(resourceId) : null;
        this.mGlowRadius = obtainStyledAttributes.getDimension(C2632R.styleable.GlowPadView_glowRadius, 0.0f);
        TypedValue typedValue = new TypedValue();
        if (obtainStyledAttributes.getValue(C2632R.styleable.GlowPadView_targetDrawables, typedValue)) {
            internalSetTargetResources(typedValue.resourceId);
        }
        if (this.mTargetDrawables == null || this.mTargetDrawables.size() == 0) {
            throw new IllegalStateException("Must specify at least one target drawable");
        }
        if (obtainStyledAttributes.getValue(C2632R.styleable.GlowPadView_targetDescriptions, typedValue)) {
            int i = typedValue.resourceId;
            if (i == 0) {
                throw new IllegalStateException("Must specify target descriptions");
            }
            setTargetDescriptionsResourceId(i);
        }
        if (obtainStyledAttributes.getValue(C2632R.styleable.GlowPadView_directionDescriptions, typedValue)) {
            int i2 = typedValue.resourceId;
            if (i2 == 0) {
                throw new IllegalStateException("Must specify direction descriptions");
            }
            setDirectionDescriptionsResourceId(i2);
        }
        this.mGravity = obtainStyledAttributes.getInt(C2632R.styleable.GlowPadView_gravity, 48);
        obtainStyledAttributes.recycle();
        if (this.mVibrationDuration > 0) {
            z = true;
        }
        setVibrateEnabled(z);
        assignDefaultsIfNeeded();
        this.mPointCloud = new PointCloud(drawable);
        this.mPointCloud.makePointCloud(this.mInnerRadius, this.mOuterRadius);
        this.mPointCloud.glowManager.setRadius(this.mGlowRadius);
    }

    @TargetApi(16)
    private void announceTargets() {
        StringBuilder stringBuilder = new StringBuilder();
        int size = this.mTargetDrawables.size();
        for (int i = STATE_IDLE; i < size; i += STATE_START) {
            CharSequence targetDescription = getTargetDescription(i);
            Object directionDescription = getDirectionDescription(i);
            if (!(TextUtils.isEmpty(targetDescription) || TextUtils.isEmpty(directionDescription))) {
                Object[] objArr = new Object[STATE_START];
                objArr[STATE_IDLE] = targetDescription;
                stringBuilder.append(String.format(directionDescription, objArr));
            }
        }
        if (Const.IS_JB && stringBuilder.length() > 0) {
            announceForAccessibility(stringBuilder.toString());
        }
    }

    private void assignDefaultsIfNeeded() {
        if (this.mOuterRadius == 0.0f) {
            this.mOuterRadius = ((float) Math.max(this.mOuterRing.getWidth(), this.mOuterRing.getHeight())) / 2.0f;
        }
        if (this.mSnapMargin == 0.0f) {
            this.mSnapMargin = TypedValue.applyDimension(STATE_START, SNAP_MARGIN_DEFAULT, getContext().getResources().getDisplayMetrics());
        }
        if (this.mInnerRadius == 0.0f) {
            this.mInnerRadius = ((float) this.mHandleDrawable.getWidth()) / 10.0f;
        }
    }

    @TargetApi(17)
    private void computeInsets(int i, int i2) {
        int i3 = this.mGravity;
        if (Const.IS_JB_MR1) {
            i3 = Gravity.getAbsoluteGravity(this.mGravity, getLayoutDirection());
        }
        switch (i3 & 7) {
            case STATE_TRACKING /*3*/:
                this.mHorizontalInset = STATE_IDLE;
                break;
            case STATE_FINISH /*5*/:
                this.mHorizontalInset = i;
                break;
            default:
                this.mHorizontalInset = i / STATE_FIRST_TOUCH;
                break;
        }
        switch (i3 & 112) {
            case C1317h.Theme_homeAsUpIndicator /*48*/:
                this.mVerticalInset = STATE_IDLE;
            case C1317h.Theme_panelMenuListTheme /*80*/:
                this.mVerticalInset = i2;
            default:
                this.mVerticalInset = i2 / STATE_FIRST_TOUCH;
        }
    }

    @TargetApi(17)
    private float computeScaleFactor(int i, int i2, int i3, int i4) {
        float f = TARGET_SCALE_EXPANDED;
        if (!this.mAllowScaling) {
            return TARGET_SCALE_EXPANDED;
        }
        int absoluteGravity;
        float f2;
        int i5 = this.mGravity;
        if (Const.IS_JB_MR1) {
            absoluteGravity = Gravity.getAbsoluteGravity(this.mGravity, getLayoutDirection());
        } else {
            absoluteGravity = i5;
        }
        switch (absoluteGravity & 7) {
            case STATE_TRACKING /*3*/:
            case STATE_FINISH /*5*/:
                f2 = TARGET_SCALE_EXPANDED;
                break;
            default:
                if (i <= i3) {
                    f2 = TARGET_SCALE_EXPANDED;
                    break;
                }
                f2 = ((((float) i3) * TARGET_SCALE_EXPANDED) - ((float) this.mMaxTargetWidth)) / ((float) (i - this.mMaxTargetWidth));
                break;
        }
        switch (absoluteGravity & 112) {
            case C1317h.Theme_homeAsUpIndicator /*48*/:
            case C1317h.Theme_panelMenuListTheme /*80*/:
                break;
            default:
                if (i2 > i4) {
                    f = ((TARGET_SCALE_EXPANDED * ((float) i4)) - ((float) this.mMaxTargetHeight)) / ((float) (i2 - this.mMaxTargetHeight));
                    break;
                }
                break;
        }
        return Math.min(f2, f);
    }

    private void deactivateTargets() {
        int size = this.mTargetDrawables.size();
        for (int i = STATE_IDLE; i < size; i += STATE_START) {
            ((TargetDrawable) this.mTargetDrawables.get(i)).setState(TargetDrawable.STATE_INACTIVE);
        }
        this.mActiveTarget = -1;
    }

    private void dispatchOnFinishFinalAnimation() {
        if (this.mOnTriggerListener != null) {
            this.mOnTriggerListener.onFinishFinalAnimation();
        }
    }

    private void dispatchTriggerEvent(int i) {
        vibrate();
        if (this.mOnTriggerListener != null) {
            this.mOnTriggerListener.onTrigger(this, i);
        }
    }

    private float dist2(float f, float f2) {
        return (f * f) + (f2 * f2);
    }

    private void doFinish() {
        int i = this.mActiveTarget;
        if (i != -1 ? true : DEBUG) {
            highlightSelected(i);
            hideGlow(SHOW_ANIMATION_DURATION, RETURN_TO_HOME_DELAY, 0.0f, this.mResetListener);
            dispatchTriggerEvent(i);
            if (!this.mAlwaysTrackFinger) {
                this.mTargetAnimations.stop();
            }
        } else {
            hideGlow(SHOW_ANIMATION_DURATION, STATE_IDLE, 0.0f, this.mResetListenerWithPing);
            hideTargets(true, DEBUG);
        }
        setGrabbedState(STATE_IDLE);
    }

    private void dump() {
        Log.v(TAG, "Outer Radius = " + this.mOuterRadius);
        Log.v(TAG, "SnapMargin = " + this.mSnapMargin);
        Log.v(TAG, "FeedbackCount = " + this.mFeedbackCount);
        Log.v(TAG, "VibrationDuration = " + this.mVibrationDuration);
        Log.v(TAG, "GlowRadius = " + this.mGlowRadius);
        Log.v(TAG, "WaveCenterX = " + this.mWaveCenterX);
        Log.v(TAG, "WaveCenterY = " + this.mWaveCenterY);
    }

    private float getAngle(float f, int i) {
        return this.mFirstItemOffset + (((float) i) * f);
    }

    private String getDirectionDescription(int i) {
        if (this.mDirectionDescriptions == null || this.mDirectionDescriptions.isEmpty()) {
            this.mDirectionDescriptions = loadDescriptions(this.mDirectionDescriptionsResourceId);
            if (this.mTargetDrawables.size() != this.mDirectionDescriptions.size()) {
                Log.w(TAG, "The number of target drawables must be equal to the number of direction descriptions.");
                return null;
            }
        }
        return (String) this.mDirectionDescriptions.get(i);
    }

    private int getResourceId(TypedArray typedArray, int i) {
        TypedValue peekValue = typedArray.peekValue(i);
        return peekValue == null ? STATE_IDLE : peekValue.resourceId;
    }

    private float getRingHeight() {
        return this.mRingScaleFactor * Math.max((float) this.mOuterRing.getHeight(), 2.0f * this.mOuterRadius);
    }

    private float getRingWidth() {
        return this.mRingScaleFactor * Math.max((float) this.mOuterRing.getWidth(), 2.0f * this.mOuterRadius);
    }

    private float getScaledGlowRadiusSquared() {
        return square(((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled() ? TAP_RADIUS_SCALE_ACCESSIBILITY_ENABLED * this.mGlowRadius : this.mGlowRadius);
    }

    private float getSliceAngle() {
        return (float) (-6.283185307179586d / ((double) this.mTargetDrawables.size()));
    }

    private String getTargetDescription(int i) {
        if (this.mTargetDescriptions == null || this.mTargetDescriptions.isEmpty()) {
            this.mTargetDescriptions = loadDescriptions(this.mTargetDescriptionsResourceId);
            if (this.mTargetDrawables.size() != this.mTargetDescriptions.size()) {
                Log.w(TAG, "The number of target drawables must be equal to the number of target descriptions.");
                return null;
            }
        }
        return (String) this.mTargetDescriptions.get(i);
    }

    @TargetApi(8)
    private void handleCancel(MotionEvent motionEvent) {
        this.mActiveTarget = -1;
        if (Const.IS_FROYO) {
            int actionIndex = motionEvent.getActionIndex();
            if (actionIndex == -1) {
                actionIndex = STATE_IDLE;
            }
            switchToState(STATE_FINISH, motionEvent.getX(actionIndex), motionEvent.getY(actionIndex));
            return;
        }
        switchToState(STATE_FINISH, motionEvent.getX(), motionEvent.getY());
    }

    @TargetApi(8)
    private void handleDown(MotionEvent motionEvent) {
        float x;
        float y;
        int actionIndex = Const.IS_FROYO ? motionEvent.getActionIndex() : STATE_IDLE;
        if (Const.IS_FROYO) {
            x = motionEvent.getX(actionIndex);
            y = motionEvent.getY(actionIndex);
        } else {
            x = motionEvent.getX();
            y = motionEvent.getY();
        }
        switchToState(STATE_START, x, y);
        if (trySwitchToFirstTouchState(x, y)) {
            if (Const.IS_ECLAIR) {
                this.mPointerId = motionEvent.getPointerId(actionIndex);
            }
            updateGlowPosition(x, y);
            return;
        }
        this.mDragging = DEBUG;
    }

    @TargetApi(16)
    private void handleMove(MotionEvent motionEvent) {
        int i = -1;
        int historySize = motionEvent.getHistorySize();
        ArrayList arrayList = this.mTargetDrawables;
        int size = arrayList.size();
        float f = 0.0f;
        int i2 = STATE_IDLE;
        if (Const.IS_ECLAIR) {
            i2 = motionEvent.findPointerIndex(this.mPointerId);
            if (i2 == -1) {
                return;
            }
        }
        int i3 = i2;
        int i4 = STATE_IDLE;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i4 < historySize + STATE_START) {
            int i5;
            if (Const.IS_FROYO) {
                f3 = i4 < historySize ? motionEvent.getHistoricalX(i3, i4) : motionEvent.getX(i3);
                f2 = i4 < historySize ? motionEvent.getHistoricalY(i3, i4) : motionEvent.getY(i3);
            } else {
                f3 = i4 < historySize ? motionEvent.getHistoricalX(i4) : motionEvent.getX();
                f2 = i4 < historySize ? motionEvent.getHistoricalY(i4) : motionEvent.getY();
            }
            float f4 = f3 - this.mWaveCenterX;
            float f5 = f2 - this.mWaveCenterY;
            float sqrt = (float) Math.sqrt((double) dist2(f4, f5));
            sqrt = sqrt > this.mOuterRadius ? this.mOuterRadius / sqrt : TARGET_SCALE_EXPANDED;
            float f6 = f4 * sqrt;
            float f7 = f5 * sqrt;
            double atan2 = Math.atan2((double) (-f5), (double) f4);
            if (!this.mDragging) {
                trySwitchToFirstTouchState(f3, f2);
            }
            if (this.mDragging) {
                f2 = (this.mRingScaleFactor * this.mOuterRadius) - this.mSnapMargin;
                float f8 = f2 * f2;
                int i6 = STATE_IDLE;
                f3 = f;
                i5 = i;
                while (i6 < size) {
                    int i7;
                    double d = ((double) this.mFirstItemOffset) + ((((((double) i6) - 0.5d) * 2.0d) * 3.141592653589793d) / ((double) size));
                    double d2 = ((double) this.mFirstItemOffset) + ((((((double) i6) + 0.5d) * 2.0d) * 3.141592653589793d) / ((double) size));
                    if (((TargetDrawable) arrayList.get(i6)).isEnabled()) {
                        Object obj = ((atan2 <= d || atan2 > d2) && ((6.283185307179586d + atan2 <= d || 6.283185307179586d + atan2 > d2) && (atan2 - 6.283185307179586d <= d || atan2 - 6.283185307179586d > d2))) ? null : STATE_START;
                        if (obj != null && dist2(f4, f5) > f8) {
                            f2 = (float) (-atan2);
                            i7 = i6;
                            i6 += STATE_START;
                            i5 = i7;
                            f3 = f2;
                        }
                    }
                    f2 = f3;
                    i7 = i5;
                    i6 += STATE_START;
                    i5 = i7;
                    f3 = f2;
                }
            } else {
                f3 = f;
                i5 = i;
            }
            i4 += STATE_START;
            i = i5;
            f2 = f7;
            f = f3;
            f3 = f6;
        }
        if (this.mDragging) {
            if (i != -1) {
                switchToState(STATE_SNAP, f3, f2);
                updateGlowPosition(f3, f2);
            } else {
                switchToState(STATE_TRACKING, f3, f2);
                updateGlowPosition(f3, f2);
            }
            if (this.mActiveTarget != i) {
                TargetDrawable targetDrawable;
                if (this.mActiveTarget != -1) {
                    targetDrawable = (TargetDrawable) arrayList.get(this.mActiveTarget);
                    if (targetDrawable.hasState(TargetDrawable.STATE_FOCUSED)) {
                        targetDrawable.setState(TargetDrawable.STATE_INACTIVE);
                    }
                    if (this.mMagneticTargets) {
                        updateTargetPosition(this.mActiveTarget, this.mWaveCenterX, this.mWaveCenterY);
                    }
                }
                if (i != -1) {
                    targetDrawable = (TargetDrawable) arrayList.get(i);
                    if (targetDrawable.hasState(TargetDrawable.STATE_FOCUSED)) {
                        targetDrawable.setState(TargetDrawable.STATE_FOCUSED);
                    }
                    if (this.mMagneticTargets) {
                        updateTargetPosition(i, this.mWaveCenterX, this.mWaveCenterY, f);
                    }
                    if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
                        CharSequence targetDescription = getTargetDescription(i);
                        if (Const.IS_JB) {
                            announceForAccessibility(targetDescription);
                        }
                    }
                }
            }
            this.mActiveTarget = i;
        }
    }

    @TargetApi(8)
    private void handleUp(MotionEvent motionEvent) {
        if (Const.IS_FROYO) {
            int actionIndex = motionEvent.getActionIndex();
            if (motionEvent.getPointerId(actionIndex) == this.mPointerId) {
                switchToState(STATE_FINISH, motionEvent.getX(actionIndex), motionEvent.getY(actionIndex));
                return;
            }
            return;
        }
        switchToState(STATE_FINISH, motionEvent.getX(), motionEvent.getY());
    }

    private void hideGlow(int i, int i2, float f, AnimatorListener animatorListener) {
        this.mGlowAnimations.cancel();
        this.mGlowAnimations.add(Tweener.to(this.mPointCloud.glowManager, (long) i, "ease", Quart.easeOut, DelayInformation.ELEMENT, Integer.valueOf(i2), "alpha", Float.valueOf(f), DataForm.ELEMENT, Float.valueOf(0.0f), "y", Float.valueOf(0.0f), "onUpdate", this.mUpdateListener, "onComplete", animatorListener));
        this.mGlowAnimations.start();
    }

    private void hideTargets(boolean z, boolean z2) {
        this.mTargetAnimations.cancel();
        this.mAnimatingTargets = z;
        int i = z ? SHOW_ANIMATION_DURATION : STATE_IDLE;
        int i2 = z ? SHOW_ANIMATION_DURATION : STATE_IDLE;
        float f = z2 ? TARGET_SCALE_EXPANDED : TARGET_SCALE_COLLAPSED;
        int size = this.mTargetDrawables.size();
        TimeInterpolator timeInterpolator = Cubic.easeOut;
        for (int i3 = STATE_IDLE; i3 < size; i3 += STATE_START) {
            TargetDrawable targetDrawable = (TargetDrawable) this.mTargetDrawables.get(i3);
            targetDrawable.setState(TargetDrawable.STATE_INACTIVE);
            this.mTargetAnimations.add(Tweener.to(targetDrawable, (long) i, "ease", timeInterpolator, "alpha", Float.valueOf(0.0f), "scaleX", Float.valueOf(f), "scaleY", Float.valueOf(f), DelayInformation.ELEMENT, Integer.valueOf(i2), "onUpdate", this.mUpdateListener));
        }
        float f2 = (z2 ? TARGET_SCALE_EXPANDED : RING_SCALE_COLLAPSED) * this.mRingScaleFactor;
        this.mTargetAnimations.add(Tweener.to(this.mOuterRing, (long) i, "ease", timeInterpolator, "alpha", Float.valueOf(0.0f), "scaleX", Float.valueOf(f2), "scaleY", Float.valueOf(f2), DelayInformation.ELEMENT, Integer.valueOf(i2), "onUpdate", this.mUpdateListener, "onComplete", this.mTargetUpdateListener));
        this.mTargetAnimations.start();
    }

    private void hideUnselected(int i) {
        for (int i2 = STATE_IDLE; i2 < this.mTargetDrawables.size(); i2 += STATE_START) {
            if (i2 != i) {
                ((TargetDrawable) this.mTargetDrawables.get(i2)).setAlpha(0.0f);
            }
        }
    }

    private void highlightSelected(int i) {
        ((TargetDrawable) this.mTargetDrawables.get(i)).setState(TargetDrawable.STATE_ACTIVE);
        hideUnselected(i);
    }

    private void internalSetTargetResources(int i) {
        ArrayList loadDrawableArray = loadDrawableArray(i);
        this.mTargetDrawables = loadDrawableArray;
        this.mTargetResourceId = i;
        int width = this.mHandleDrawable.getWidth();
        int height = this.mHandleDrawable.getHeight();
        int size = loadDrawableArray.size();
        int i2 = width;
        width = height;
        for (height = STATE_IDLE; height < size; height += STATE_START) {
            TargetDrawable targetDrawable = (TargetDrawable) loadDrawableArray.get(height);
            i2 = Math.max(i2, targetDrawable.getWidth());
            width = Math.max(width, targetDrawable.getHeight());
        }
        if (this.mMaxTargetWidth == i2 && this.mMaxTargetHeight == width) {
            updateTargetPositions(this.mWaveCenterX, this.mWaveCenterY);
            updatePointCloudPosition(this.mWaveCenterX, this.mWaveCenterY);
            return;
        }
        this.mMaxTargetWidth = i2;
        this.mMaxTargetHeight = width;
        requestLayout();
    }

    private ArrayList<String> loadDescriptions(int i) {
        int i2 = STATE_IDLE;
        if (i == 0) {
            return new ArrayList(STATE_IDLE);
        }
        Context context = getContext();
        TypedArray obtainTypedArray = context != null ? context.getResources().obtainTypedArray(i) : null;
        if (obtainTypedArray == null) {
            return new ArrayList(STATE_IDLE);
        }
        int length = obtainTypedArray.length();
        ArrayList<String> arrayList = new ArrayList(length);
        while (i2 < length) {
            arrayList.add(obtainTypedArray.getString(i2));
            i2 += STATE_START;
        }
        obtainTypedArray.recycle();
        return arrayList;
    }

    private ArrayList<TargetDrawable> loadDrawableArray(int i) {
        Resources resources = getContext().getResources();
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        int length = obtainTypedArray.length();
        ArrayList<TargetDrawable> arrayList = new ArrayList(length);
        for (int i2 = STATE_IDLE; i2 < length; i2 += STATE_START) {
            TypedValue peekValue = obtainTypedArray.peekValue(i2);
            arrayList.add(new TargetDrawable(resources, peekValue != null ? peekValue.resourceId : STATE_IDLE));
        }
        obtainTypedArray.recycle();
        return arrayList;
    }

    private boolean replaceTargetDrawables(Resources resources, int i, int i2) {
        boolean z = DEBUG;
        if (!(i == 0 || i2 == 0)) {
            ArrayList arrayList = this.mTargetDrawables;
            int size = arrayList.size();
            int i3 = STATE_IDLE;
            while (i3 < size) {
                boolean z2;
                TargetDrawable targetDrawable = (TargetDrawable) arrayList.get(i3);
                if (targetDrawable == null || targetDrawable.getResourceId() != i) {
                    z2 = z;
                } else {
                    targetDrawable.setDrawable(resources, i2);
                    z2 = true;
                }
                i3 += STATE_START;
                z = z2;
            }
            if (z) {
                requestLayout();
            }
        }
        return z;
    }

    private int resolveMeasured(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        switch (MeasureSpec.getMode(i)) {
            case RtlSpacingHelper.UNDEFINED /*-2147483648*/:
                return Math.min(size, i2);
            case STATE_IDLE /*0*/:
                return i2;
            default:
                return size;
        }
    }

    private void setGrabbedState(int i) {
        if (i != this.mGrabbedState) {
            if (i != 0) {
                vibrate();
            }
            this.mGrabbedState = i;
            if (this.mOnTriggerListener != null) {
                if (i == 0) {
                    this.mOnTriggerListener.onReleased(this, STATE_START);
                } else {
                    this.mOnTriggerListener.onGrabbed(this, STATE_START);
                }
                this.mOnTriggerListener.onGrabbedStateChange(this, i);
            }
        }
    }

    private void showGlow(int i, int i2, float f, AnimatorListener animatorListener) {
        this.mGlowAnimations.cancel();
        this.mGlowAnimations.add(Tweener.to(this.mPointCloud.glowManager, (long) i, "ease", Cubic.easeIn, DelayInformation.ELEMENT, Integer.valueOf(i2), "alpha", Float.valueOf(f), "onUpdate", this.mUpdateListener, "onComplete", animatorListener));
        this.mGlowAnimations.start();
    }

    private void showTargets(boolean z) {
        this.mTargetAnimations.stop();
        this.mAnimatingTargets = z;
        int i = z ? SHOW_ANIMATION_DELAY : STATE_IDLE;
        int i2 = z ? SHOW_ANIMATION_DURATION : STATE_IDLE;
        int size = this.mTargetDrawables.size();
        for (int i3 = STATE_IDLE; i3 < size; i3 += STATE_START) {
            TargetDrawable targetDrawable = (TargetDrawable) this.mTargetDrawables.get(i3);
            targetDrawable.setState(TargetDrawable.STATE_INACTIVE);
            this.mTargetAnimations.add(Tweener.to(targetDrawable, (long) i2, "ease", Cubic.easeOut, "alpha", Float.valueOf(TARGET_SCALE_EXPANDED), "scaleX", Float.valueOf(TARGET_SCALE_EXPANDED), "scaleY", Float.valueOf(TARGET_SCALE_EXPANDED), DelayInformation.ELEMENT, Integer.valueOf(i), "onUpdate", this.mUpdateListener));
        }
        float f = this.mRingScaleFactor * TARGET_SCALE_EXPANDED;
        this.mTargetAnimations.add(Tweener.to(this.mOuterRing, (long) i2, "ease", Cubic.easeOut, "alpha", Float.valueOf(TARGET_SCALE_EXPANDED), "scaleX", Float.valueOf(f), "scaleY", Float.valueOf(f), DelayInformation.ELEMENT, Integer.valueOf(i), "onUpdate", this.mUpdateListener, "onComplete", this.mTargetUpdateListener));
        this.mTargetAnimations.start();
    }

    private float square(float f) {
        return f * f;
    }

    private void startBackgroundAnimation(int i, float f) {
        Drawable background = getBackground();
        if (this.mAlwaysTrackFinger && background != null) {
            if (this.mBackgroundAnimator != null) {
                this.mBackgroundAnimator.animator.cancel();
            }
            this.mBackgroundAnimator = Tweener.to(background, (long) i, "ease", Cubic.easeIn, "alpha", Integer.valueOf((int) (255.0f * f)), DelayInformation.ELEMENT, Integer.valueOf(SHOW_ANIMATION_DELAY));
            this.mBackgroundAnimator.animator.start();
        }
    }

    private void startWaveAnimation() {
        this.mWaveAnimations.cancel();
        this.mPointCloud.waveManager.setAlpha(TARGET_SCALE_EXPANDED);
        this.mPointCloud.waveManager.setRadius(((float) this.mHandleDrawable.getWidth()) / 2.0f);
        this.mWaveAnimations.add(Tweener.to(this.mPointCloud.waveManager, 1350, "ease", Quad.easeOut, DelayInformation.ELEMENT, Integer.valueOf(STATE_IDLE), "radius", Float.valueOf(this.mOuterRadius * 2.0f), "onUpdate", this.mUpdateListener, "onComplete", new C26315()));
        this.mWaveAnimations.start();
    }

    private void stopAndHideWaveAnimation() {
        this.mWaveAnimations.cancel();
        this.mPointCloud.waveManager.setAlpha(0.0f);
    }

    private void switchToState(int i, float f, float f2) {
        switch (i) {
            case STATE_IDLE /*0*/:
                deactivateTargets();
                hideGlow(STATE_IDLE, STATE_IDLE, 0.0f, null);
                startBackgroundAnimation(STATE_IDLE, 0.0f);
                this.mHandleDrawable.setState(TargetDrawable.STATE_INACTIVE);
                this.mHandleDrawable.setAlpha(TARGET_SCALE_EXPANDED);
            case STATE_START /*1*/:
                startBackgroundAnimation(STATE_IDLE, 0.0f);
            case STATE_FIRST_TOUCH /*2*/:
                this.mHandleDrawable.setAlpha(0.0f);
                deactivateTargets();
                showTargets(true);
                startBackgroundAnimation(SHOW_ANIMATION_DURATION, TARGET_SCALE_EXPANDED);
                setGrabbedState(STATE_START);
                if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
                    announceTargets();
                }
            case STATE_TRACKING /*3*/:
                this.mHandleDrawable.setAlpha(0.0f);
                showGlow(STATE_IDLE, STATE_IDLE, TARGET_SCALE_EXPANDED, null);
            case STATE_SNAP /*4*/:
                this.mHandleDrawable.setAlpha(0.0f);
                showGlow(STATE_IDLE, STATE_IDLE, 0.0f, null);
            case STATE_FINISH /*5*/:
                doFinish();
            default:
        }
    }

    private boolean trySwitchToFirstTouchState(float f, float f2) {
        float f3 = f - this.mWaveCenterX;
        float f4 = f2 - this.mWaveCenterY;
        if (!this.mAlwaysTrackFinger && dist2(f3, f4) > getScaledGlowRadiusSquared()) {
            return DEBUG;
        }
        switchToState(STATE_FIRST_TOUCH, f, f2);
        updateGlowPosition(f3, f4);
        this.mDragging = true;
        return true;
    }

    private void updateGlowPosition(float f, float f2) {
        float y = (f2 - this.mOuterRing.getY()) * (TARGET_SCALE_EXPANDED / this.mRingScaleFactor);
        this.mPointCloud.glowManager.setX(((f - this.mOuterRing.getX()) * (TARGET_SCALE_EXPANDED / this.mRingScaleFactor)) + this.mOuterRing.getX());
        this.mPointCloud.glowManager.setY(y + this.mOuterRing.getY());
    }

    private void updatePointCloudPosition(float f, float f2) {
        this.mPointCloud.setCenter(f, f2);
    }

    private void updateTargetPosition(int i, float f, float f2) {
        updateTargetPosition(i, f, f2, getAngle(getSliceAngle(), i));
    }

    private void updateTargetPosition(int i, float f, float f2, float f3) {
        float ringWidth = getRingWidth() / 2.0f;
        float ringHeight = getRingHeight() / 2.0f;
        if (i >= 0) {
            TargetDrawable targetDrawable = (TargetDrawable) this.mTargetDrawables.get(i);
            targetDrawable.setPositionX(f);
            targetDrawable.setPositionY(f2);
            targetDrawable.setX(ringWidth * ((float) Math.cos((double) f3)));
            targetDrawable.setY(((float) Math.sin((double) f3)) * ringHeight);
        }
    }

    private void updateTargetPositions(float f, float f2) {
        updateTargetPositions(f, f2, DEBUG);
    }

    private void updateTargetPositions(float f, float f2, boolean z) {
        int size = this.mTargetDrawables.size();
        float sliceAngle = getSliceAngle();
        int i = STATE_IDLE;
        while (i < size) {
            if (!z || i != this.mActiveTarget) {
                updateTargetPosition(i, f, f2, getAngle(sliceAngle, i));
            }
            i += STATE_START;
        }
    }

    private void vibrate() {
        int i = STATE_START;
        if (System.getInt(getContext().getContentResolver(), "haptic_feedback_enabled", STATE_START) == 0) {
            i = STATE_IDLE;
        }
        if (this.mVibrator != null && r0 != 0) {
            this.mVibrator.vibrate((long) this.mVibrationDuration);
        }
    }

    public int getDirectionDescriptionsResourceId() {
        return this.mDirectionDescriptionsResourceId;
    }

    public int getPointsMultiplier() {
        return this.mPointCloud.getPointsMultiplier();
    }

    public int getResourceIdForTarget(int i) {
        TargetDrawable targetDrawable = (TargetDrawable) this.mTargetDrawables.get(i);
        return targetDrawable == null ? STATE_IDLE : targetDrawable.getResourceId();
    }

    protected int getScaledSuggestedMinimumHeight() {
        return (int) ((this.mRingScaleFactor * Math.max((float) this.mOuterRing.getHeight(), 2.0f * this.mOuterRadius)) + ((float) this.mMaxTargetHeight));
    }

    protected int getScaledSuggestedMinimumWidth() {
        return (int) ((this.mRingScaleFactor * Math.max((float) this.mOuterRing.getWidth(), 2.0f * this.mOuterRadius)) + ((float) this.mMaxTargetWidth));
    }

    protected int getSuggestedMinimumHeight() {
        return (int) (Math.max((float) this.mOuterRing.getHeight(), 2.0f * this.mOuterRadius) + ((float) this.mMaxTargetHeight));
    }

    protected int getSuggestedMinimumWidth() {
        return (int) (Math.max((float) this.mOuterRing.getWidth(), 2.0f * this.mOuterRadius) + ((float) this.mMaxTargetWidth));
    }

    public int getTargetDescriptionsResourceId() {
        return this.mTargetDescriptionsResourceId;
    }

    public int getTargetPosition(int i) {
        for (int i2 = STATE_IDLE; i2 < this.mTargetDrawables.size(); i2 += STATE_START) {
            if (((TargetDrawable) this.mTargetDrawables.get(i2)).getResourceId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int getTargetResourceId() {
        return this.mTargetResourceId;
    }

    protected void onDraw(Canvas canvas) {
        this.mPointCloud.draw(canvas);
        this.mOuterRing.draw(canvas);
        int size = this.mTargetDrawables.size();
        for (int i = STATE_IDLE; i < size; i += STATE_START) {
            TargetDrawable targetDrawable = (TargetDrawable) this.mTargetDrawables.get(i);
            if (targetDrawable != null) {
                targetDrawable.draw(canvas);
            }
        }
        this.mHandleDrawable.draw(canvas);
    }

    @TargetApi(14)
    public boolean onHoverEvent(MotionEvent motionEvent) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (Const.IS_ICS && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            switch (action) {
                case Version.API07_ECLAIR_21 /*7*/:
                    motionEvent.setAction(STATE_FIRST_TOUCH);
                    break;
                case Version.API09_GINGERBREAD_23 /*9*/:
                    motionEvent.setAction(STATE_IDLE);
                    break;
                case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                    motionEvent.setAction(STATE_START);
                    break;
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
            super.onHoverEvent(motionEvent);
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        float ringWidth = getRingWidth();
        float max = (Math.max((float) i5, ringWidth + ((float) this.mMaxTargetWidth)) / 2.0f) + ((float) this.mHorizontalInset);
        ringWidth = (float) this.mVerticalInset;
        float max2 = (Math.max((float) i6, getRingHeight() + ((float) this.mMaxTargetHeight)) / 2.0f) + ringWidth;
        if (this.mInitialLayout) {
            stopAndHideWaveAnimation();
            hideTargets(DEBUG, DEBUG);
            this.mInitialLayout = DEBUG;
        }
        this.mOuterRing.setPositionX(max);
        this.mOuterRing.setPositionY(max2);
        this.mPointCloud.setScale(this.mRingScaleFactor);
        this.mHandleDrawable.setPositionX(max);
        this.mHandleDrawable.setPositionY(max2);
        updateTargetPositions(max, max2);
        updatePointCloudPosition(max, max2);
        updateGlowPosition(max, max2);
        this.mWaveCenterX = max;
        this.mWaveCenterY = max2;
    }

    protected void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int resolveMeasured = resolveMeasured(i, suggestedMinimumWidth);
        int resolveMeasured2 = resolveMeasured(i2, suggestedMinimumHeight);
        this.mRingScaleFactor = computeScaleFactor(suggestedMinimumWidth, suggestedMinimumHeight, resolveMeasured, resolveMeasured2);
        computeInsets(resolveMeasured - getScaledSuggestedMinimumWidth(), resolveMeasured2 - getScaledSuggestedMinimumHeight());
        setMeasuredDimension(resolveMeasured, resolveMeasured2);
    }

    @TargetApi(8)
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        switch (Const.IS_FROYO ? motionEvent.getActionMasked() : motionEvent.getAction()) {
            case STATE_IDLE /*0*/:
            case STATE_FINISH /*5*/:
                handleDown(motionEvent);
                handleMove(motionEvent);
                z = STATE_START;
                break;
            case STATE_START /*1*/:
            case Version.API06_ECLAIR_201 /*6*/:
                handleMove(motionEvent);
                handleUp(motionEvent);
                z = STATE_START;
                break;
            case STATE_FIRST_TOUCH /*2*/:
                handleMove(motionEvent);
                z = STATE_START;
                break;
            case STATE_TRACKING /*3*/:
                handleMove(motionEvent);
                handleCancel(motionEvent);
                z = STATE_START;
                break;
            default:
                z = DEBUG;
                break;
        }
        invalidate();
        return (z || super.onTouchEvent(motionEvent)) ? true : DEBUG;
    }

    public void ping() {
        if (this.mFeedbackCount > 0) {
            AnimationBundle animationBundle = this.mWaveAnimations;
            int i = (animationBundle.size() <= 0 || !((Tweener) animationBundle.get(STATE_IDLE)).animator.isRunning() || ((Tweener) animationBundle.get(STATE_IDLE)).animator.getCurrentPlayTime() >= 675) ? STATE_START : STATE_IDLE;
            if (i != 0) {
                startWaveAnimation();
            }
        }
    }

    public boolean replaceTargetDrawablesIfPresent(ComponentName componentName, String str, int i) {
        boolean z = DEBUG;
        if (i != 0) {
            Context context = getContext();
            if (componentName != null) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    Bundle bundle = packageManager.getActivityInfo(componentName, 128).metaData;
                    if (bundle != null) {
                        int i2 = bundle.getInt(str);
                        if (i2 != 0) {
                            z = replaceTargetDrawables(packageManager.getResourcesForActivity(componentName), i, i2);
                        }
                    }
                } catch (Throwable e) {
                    Log.w(TAG, "Failed to swap drawable; " + componentName.flattenToShortString() + " not found", e);
                } catch (Throwable e2) {
                    Log.w(TAG, "Failed to swap drawable from " + componentName.flattenToShortString(), e2);
                }
            }
            if (!z) {
                replaceTargetDrawables(context.getResources(), i, i);
            }
        }
        return z;
    }

    public void reset(boolean z) {
        this.mGlowAnimations.stop();
        this.mTargetAnimations.stop();
        startBackgroundAnimation(STATE_IDLE, 0.0f);
        stopAndHideWaveAnimation();
        hideTargets(z, DEBUG);
        hideGlow(STATE_IDLE, STATE_IDLE, 0.0f, null);
        Tweener.reset();
    }

    public void resumeAnimations() {
        this.mWaveAnimations.setSuspended(DEBUG);
        this.mTargetAnimations.setSuspended(DEBUG);
        this.mGlowAnimations.setSuspended(DEBUG);
        this.mWaveAnimations.start();
        this.mTargetAnimations.start();
        this.mGlowAnimations.start();
    }

    public void setDirectionDescriptionsResourceId(int i) {
        this.mDirectionDescriptionsResourceId = i;
        if (this.mDirectionDescriptions != null) {
            this.mDirectionDescriptions.clear();
        }
    }

    public void setEnableTarget(int i, boolean z) {
        for (int i2 = STATE_IDLE; i2 < this.mTargetDrawables.size(); i2 += STATE_START) {
            TargetDrawable targetDrawable = (TargetDrawable) this.mTargetDrawables.get(i2);
            if (targetDrawable.getResourceId() == i) {
                targetDrawable.setEnabled(z);
                return;
            }
        }
    }

    public void setOnTriggerListener(OnTriggerListener onTriggerListener) {
        this.mOnTriggerListener = onTriggerListener;
    }

    public void setPointsMultiplier(int i) {
        this.mPointCloud.setPointsMultiplier(i);
    }

    public void setTargetDescriptionsResourceId(int i) {
        this.mTargetDescriptionsResourceId = i;
        if (this.mTargetDescriptions != null) {
            this.mTargetDescriptions.clear();
        }
    }

    public void setTargetResources(int i) {
        if (this.mAnimatingTargets) {
            this.mNewTargetResources = i;
        } else {
            internalSetTargetResources(i);
        }
    }

    public void setVibrateEnabled(boolean z) {
        if (z && this.mVibrator == null) {
            this.mVibrator = (Vibrator) getContext().getSystemService("vibrator");
        } else {
            this.mVibrator = null;
        }
    }

    public void suspendAnimations() {
        this.mWaveAnimations.setSuspended(true);
        this.mTargetAnimations.setSuspended(true);
        this.mGlowAnimations.setSuspended(true);
    }
}
