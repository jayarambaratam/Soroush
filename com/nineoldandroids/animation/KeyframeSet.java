package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

class KeyframeSet {
    TypeEvaluator mEvaluator;
    Keyframe mFirstKeyframe;
    Interpolator mInterpolator;
    ArrayList<Keyframe> mKeyframes;
    Keyframe mLastKeyframe;
    int mNumKeyframes;

    public KeyframeSet(Keyframe... keyframeArr) {
        this.mNumKeyframes = keyframeArr.length;
        this.mKeyframes = new ArrayList();
        this.mKeyframes.addAll(Arrays.asList(keyframeArr));
        this.mFirstKeyframe = (Keyframe) this.mKeyframes.get(0);
        this.mLastKeyframe = (Keyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
        this.mInterpolator = this.mLastKeyframe.getInterpolator();
    }

    public static KeyframeSet ofFloat(float... fArr) {
        int i = 1;
        int length = fArr.length;
        FloatKeyframe[] floatKeyframeArr = new FloatKeyframe[Math.max(length, 2)];
        if (length == 1) {
            floatKeyframeArr[0] = (FloatKeyframe) Keyframe.ofFloat(0.0f);
            floatKeyframeArr[1] = (FloatKeyframe) Keyframe.ofFloat(1.0f, fArr[0]);
        } else {
            floatKeyframeArr[0] = (FloatKeyframe) Keyframe.ofFloat(0.0f, fArr[0]);
            while (i < length) {
                floatKeyframeArr[i] = (FloatKeyframe) Keyframe.ofFloat(((float) i) / ((float) (length - 1)), fArr[i]);
                i++;
            }
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public static KeyframeSet ofInt(int... iArr) {
        int i = 1;
        int length = iArr.length;
        IntKeyframe[] intKeyframeArr = new IntKeyframe[Math.max(length, 2)];
        if (length == 1) {
            intKeyframeArr[0] = (IntKeyframe) Keyframe.ofInt(0.0f);
            intKeyframeArr[1] = (IntKeyframe) Keyframe.ofInt(1.0f, iArr[0]);
        } else {
            intKeyframeArr[0] = (IntKeyframe) Keyframe.ofInt(0.0f, iArr[0]);
            while (i < length) {
                intKeyframeArr[i] = (IntKeyframe) Keyframe.ofInt(((float) i) / ((float) (length - 1)), iArr[i]);
                i++;
            }
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public static KeyframeSet ofKeyframe(Keyframe... keyframeArr) {
        int i = 0;
        int length = keyframeArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (keyframeArr[i5] instanceof FloatKeyframe) {
                i4 = 1;
            } else if (keyframeArr[i5] instanceof IntKeyframe) {
                i3 = 1;
            } else {
                i2 = 1;
            }
        }
        if (i4 != 0 && i3 == 0 && r0 == 0) {
            FloatKeyframe[] floatKeyframeArr = new FloatKeyframe[length];
            while (i < length) {
                floatKeyframeArr[i] = (FloatKeyframe) keyframeArr[i];
                i++;
            }
            return new FloatKeyframeSet(floatKeyframeArr);
        } else if (i3 == 0 || i4 != 0 || r0 != 0) {
            return new KeyframeSet(keyframeArr);
        } else {
            IntKeyframe[] intKeyframeArr = new IntKeyframe[length];
            for (int i6 = 0; i6 < length; i6++) {
                intKeyframeArr[i6] = (IntKeyframe) keyframeArr[i6];
            }
            return new IntKeyframeSet(intKeyframeArr);
        }
    }

    public static KeyframeSet ofObject(Object... objArr) {
        int i = 1;
        int length = objArr.length;
        Keyframe[] keyframeArr = new ObjectKeyframe[Math.max(length, 2)];
        if (length == 1) {
            keyframeArr[0] = (ObjectKeyframe) Keyframe.ofObject(0.0f);
            keyframeArr[1] = (ObjectKeyframe) Keyframe.ofObject(1.0f, objArr[0]);
        } else {
            keyframeArr[0] = (ObjectKeyframe) Keyframe.ofObject(0.0f, objArr[0]);
            while (i < length) {
                keyframeArr[i] = (ObjectKeyframe) Keyframe.ofObject(((float) i) / ((float) (length - 1)), objArr[i]);
                i++;
            }
        }
        return new KeyframeSet(keyframeArr);
    }

    public KeyframeSet clone() {
        ArrayList arrayList = this.mKeyframes;
        int size = this.mKeyframes.size();
        Keyframe[] keyframeArr = new Keyframe[size];
        for (int i = 0; i < size; i++) {
            keyframeArr[i] = ((Keyframe) arrayList.get(i)).clone();
        }
        return new KeyframeSet(keyframeArr);
    }

    public Object getValue(float f) {
        if (this.mNumKeyframes == 2) {
            if (this.mInterpolator != null) {
                f = this.mInterpolator.getInterpolation(f);
            }
            return this.mEvaluator.evaluate(f, this.mFirstKeyframe.getValue(), this.mLastKeyframe.getValue());
        } else if (f <= 0.0f) {
            r0 = (Keyframe) this.mKeyframes.get(1);
            r1 = r0.getInterpolator();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r1 = this.mFirstKeyframe.getFraction();
            return this.mEvaluator.evaluate((f - r1) / (r0.getFraction() - r1), this.mFirstKeyframe.getValue(), r0.getValue());
        } else if (f >= 1.0f) {
            r0 = (Keyframe) this.mKeyframes.get(this.mNumKeyframes - 2);
            r1 = this.mLastKeyframe.getInterpolator();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r1 = r0.getFraction();
            return this.mEvaluator.evaluate((f - r1) / (this.mLastKeyframe.getFraction() - r1), r0.getValue(), this.mLastKeyframe.getValue());
        } else {
            Keyframe keyframe = this.mFirstKeyframe;
            int i = 1;
            while (i < this.mNumKeyframes) {
                r0 = (Keyframe) this.mKeyframes.get(i);
                if (f < r0.getFraction()) {
                    r1 = r0.getInterpolator();
                    if (r1 != null) {
                        f = r1.getInterpolation(f);
                    }
                    r1 = keyframe.getFraction();
                    return this.mEvaluator.evaluate((f - r1) / (r0.getFraction() - r1), keyframe.getValue(), r0.getValue());
                }
                i++;
                keyframe = r0;
            }
            return this.mLastKeyframe.getValue();
        }
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        this.mEvaluator = typeEvaluator;
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (i < this.mNumKeyframes) {
            String str2 = str + ((Keyframe) this.mKeyframes.get(i)).getValue() + "  ";
            i++;
            str = str2;
        }
        return str;
    }
}
