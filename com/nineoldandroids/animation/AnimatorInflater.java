package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import org.xmlpull.v1.XmlPullParser;

public class AnimatorInflater {
    private static final int[] Animator;
    private static final int[] AnimatorSet;
    private static final int AnimatorSet_ordering = 0;
    private static final int Animator_duration = 1;
    private static final int Animator_interpolator = 0;
    private static final int Animator_repeatCount = 3;
    private static final int Animator_repeatMode = 4;
    private static final int Animator_startOffset = 2;
    private static final int Animator_valueFrom = 5;
    private static final int Animator_valueTo = 6;
    private static final int Animator_valueType = 7;
    private static final int[] PropertyAnimator;
    private static final int PropertyAnimator_propertyName = 0;
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_FLOAT = 0;

    static {
        int[] iArr = new int[Animator_duration];
        iArr[Animator_interpolator] = 16843490;
        AnimatorSet = iArr;
        iArr = new int[Animator_duration];
        iArr[Animator_interpolator] = 16843489;
        PropertyAnimator = iArr;
        Animator = new int[]{16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};
    }

    private static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser) {
        return createAnimatorFromXml(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, Animator_interpolator);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.nineoldandroids.animation.Animator createAnimatorFromXml(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, com.nineoldandroids.animation.AnimatorSet r12, int r13) {
        /*
        r3 = 0;
        r5 = 0;
        r6 = r10.getDepth();
        r2 = r3;
        r1 = r3;
    L_0x0008:
        r0 = r10.next();
        r4 = 3;
        if (r0 != r4) goto L_0x0015;
    L_0x000f:
        r4 = r10.getDepth();
        if (r4 <= r6) goto L_0x0093;
    L_0x0015:
        r4 = 1;
        if (r0 == r4) goto L_0x0093;
    L_0x0018:
        r4 = 2;
        if (r0 != r4) goto L_0x0008;
    L_0x001b:
        r0 = r10.getName();
        r1 = "objectAnimator";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0039;
    L_0x0027:
        r1 = loadObjectAnimator(r9, r11);
    L_0x002b:
        if (r12 == 0) goto L_0x00c0;
    L_0x002d:
        if (r2 != 0) goto L_0x00bd;
    L_0x002f:
        r0 = new java.util.ArrayList;
        r0.<init>();
    L_0x0034:
        r0.add(r1);
    L_0x0037:
        r2 = r0;
        goto L_0x0008;
    L_0x0039:
        r1 = "animator";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0046;
    L_0x0041:
        r1 = loadAnimator(r9, r11, r3);
        goto L_0x002b;
    L_0x0046:
        r1 = "set";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0076;
    L_0x004e:
        r1 = new com.nineoldandroids.animation.AnimatorSet;
        r1.<init>();
        r0 = AnimatorSet;
        r7 = r9.obtainStyledAttributes(r11, r0);
        r0 = new android.util.TypedValue;
        r0.<init>();
        r7.getValue(r5, r0);
        r4 = r0.type;
        r8 = 16;
        if (r4 != r8) goto L_0x0074;
    L_0x0067:
        r0 = r0.data;
        r4 = r0;
    L_0x006a:
        r0 = r1;
        r0 = (com.nineoldandroids.animation.AnimatorSet) r0;
        createAnimatorFromXml(r9, r10, r11, r0, r4);
        r7.recycle();
        goto L_0x002b;
    L_0x0074:
        r4 = r5;
        goto L_0x006a;
    L_0x0076:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unknown animator name: ";
        r1 = r1.append(r2);
        r2 = r10.getName();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0093:
        if (r12 == 0) goto L_0x00b8;
    L_0x0095:
        if (r2 == 0) goto L_0x00b8;
    L_0x0097:
        r0 = r2.size();
        r3 = new com.nineoldandroids.animation.Animator[r0];
        r4 = r2.iterator();
    L_0x00a1:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x00b3;
    L_0x00a7:
        r0 = r4.next();
        r0 = (com.nineoldandroids.animation.Animator) r0;
        r2 = r5 + 1;
        r3[r5] = r0;
        r5 = r2;
        goto L_0x00a1;
    L_0x00b3:
        if (r13 != 0) goto L_0x00b9;
    L_0x00b5:
        r12.playTogether(r3);
    L_0x00b8:
        return r1;
    L_0x00b9:
        r12.playSequentially(r3);
        goto L_0x00b8;
    L_0x00bd:
        r0 = r2;
        goto L_0x0034;
    L_0x00c0:
        r0 = r2;
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.animation.AnimatorInflater.createAnimatorFromXml(android.content.Context, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, com.nineoldandroids.animation.AnimatorSet, int):com.nineoldandroids.animation.Animator");
    }

    public static Animator loadAnimator(Context context, int i) {
        NotFoundException notFoundException;
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = context.getResources().getAnimation(i);
            Animator createAnimatorFromXml = createAnimatorFromXml(context, xmlResourceParser);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            return createAnimatorFromXml;
        } catch (Throwable e) {
            notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (Throwable e2) {
            notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e2);
            throw notFoundException;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static ValueAnimator loadAnimator(Context context, AttributeSet attributeSet, ValueAnimator valueAnimator) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Animator);
        long j = (long) obtainStyledAttributes.getInt(Animator_duration, Animator_interpolator);
        long j2 = (long) obtainStyledAttributes.getInt(Animator_startOffset, Animator_interpolator);
        int i = obtainStyledAttributes.getInt(Animator_valueType, Animator_interpolator);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        Object obj = i == 0 ? Animator_duration : null;
        TypedValue peekValue = obtainStyledAttributes.peekValue(Animator_valueFrom);
        Object obj2 = peekValue != null ? Animator_duration : Animator_interpolator;
        int i2 = obj2 != null ? peekValue.type : Animator_interpolator;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(Animator_valueTo);
        Object obj3 = peekValue2 != null ? Animator_duration : Animator_interpolator;
        int i3 = obj3 != null ? peekValue2.type : Animator_interpolator;
        if ((obj2 != null && i2 >= 28 && i2 <= 31) || (obj3 != null && i3 >= 28 && i3 <= 31)) {
            obj = null;
            valueAnimator.setEvaluator(new ArgbEvaluator());
        }
        if (obj != null) {
            if (obj2 != null) {
                float dimension = i2 == Animator_valueFrom ? obtainStyledAttributes.getDimension(Animator_valueFrom, 0.0f) : obtainStyledAttributes.getFloat(Animator_valueFrom, 0.0f);
                if (obj3 != null) {
                    float dimension2 = i3 == Animator_valueFrom ? obtainStyledAttributes.getDimension(Animator_valueTo, 0.0f) : obtainStyledAttributes.getFloat(Animator_valueTo, 0.0f);
                    float[] fArr = new float[Animator_startOffset];
                    fArr[Animator_interpolator] = dimension;
                    fArr[Animator_duration] = dimension2;
                    valueAnimator.setFloatValues(fArr);
                } else {
                    float[] fArr2 = new float[Animator_duration];
                    fArr2[Animator_interpolator] = dimension;
                    valueAnimator.setFloatValues(fArr2);
                }
            } else {
                float[] fArr3 = new float[Animator_duration];
                fArr3[Animator_interpolator] = i3 == Animator_valueFrom ? obtainStyledAttributes.getDimension(Animator_valueTo, 0.0f) : obtainStyledAttributes.getFloat(Animator_valueTo, 0.0f);
                valueAnimator.setFloatValues(fArr3);
            }
        } else if (obj2 != null) {
            i2 = i2 == Animator_valueFrom ? (int) obtainStyledAttributes.getDimension(Animator_valueFrom, 0.0f) : (i2 < 28 || i2 > 31) ? obtainStyledAttributes.getInt(Animator_valueFrom, Animator_interpolator) : obtainStyledAttributes.getColor(Animator_valueFrom, Animator_interpolator);
            if (obj3 != null) {
                i = i3 == Animator_valueFrom ? (int) obtainStyledAttributes.getDimension(Animator_valueTo, 0.0f) : (i3 < 28 || i3 > 31) ? obtainStyledAttributes.getInt(Animator_valueTo, Animator_interpolator) : obtainStyledAttributes.getColor(Animator_valueTo, Animator_interpolator);
                int[] iArr = new int[Animator_startOffset];
                iArr[Animator_interpolator] = i2;
                iArr[Animator_duration] = i;
                valueAnimator.setIntValues(iArr);
            } else {
                int[] iArr2 = new int[Animator_duration];
                iArr2[Animator_interpolator] = i2;
                valueAnimator.setIntValues(iArr2);
            }
        } else if (obj3 != null) {
            i = i3 == Animator_valueFrom ? (int) obtainStyledAttributes.getDimension(Animator_valueTo, 0.0f) : (i3 < 28 || i3 > 31) ? obtainStyledAttributes.getInt(Animator_valueTo, Animator_interpolator) : obtainStyledAttributes.getColor(Animator_valueTo, Animator_interpolator);
            int[] iArr3 = new int[Animator_duration];
            iArr3[Animator_interpolator] = i;
            valueAnimator.setIntValues(iArr3);
        }
        valueAnimator.setDuration(j);
        valueAnimator.setStartDelay(j2);
        if (obtainStyledAttributes.hasValue(Animator_repeatCount)) {
            valueAnimator.setRepeatCount(obtainStyledAttributes.getInt(Animator_repeatCount, Animator_interpolator));
        }
        if (obtainStyledAttributes.hasValue(Animator_repeatMode)) {
            valueAnimator.setRepeatMode(obtainStyledAttributes.getInt(Animator_repeatMode, Animator_duration));
        }
        i = obtainStyledAttributes.getResourceId(Animator_interpolator, Animator_interpolator);
        if (i > 0) {
            valueAnimator.setInterpolator(AnimationUtils.loadInterpolator(context, i));
        }
        obtainStyledAttributes.recycle();
        return valueAnimator;
    }

    private static ObjectAnimator loadObjectAnimator(Context context, AttributeSet attributeSet) {
        ValueAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, attributeSet, objectAnimator);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, PropertyAnimator);
        objectAnimator.setPropertyName(obtainStyledAttributes.getString(Animator_interpolator));
        obtainStyledAttributes.recycle();
        return objectAnimator;
    }
}
