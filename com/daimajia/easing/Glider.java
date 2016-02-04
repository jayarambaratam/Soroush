package com.daimajia.easing;

import com.daimajia.easing.BaseEasingMethod.EasingListener;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.nineoldandroids.animation.TypeEvaluator;
import com.nineoldandroids.animation.ValueAnimator;

public class Glider {
    public static PropertyValuesHolder glide(Skill skill, float f, PropertyValuesHolder propertyValuesHolder) {
        propertyValuesHolder.setEvaluator(skill.getMethod(f));
        return propertyValuesHolder;
    }

    public static ValueAnimator glide(Skill skill, float f, ValueAnimator valueAnimator) {
        return glide(skill, f, valueAnimator, null);
    }

    public static ValueAnimator glide(Skill skill, float f, ValueAnimator valueAnimator, EasingListener... easingListenerArr) {
        TypeEvaluator method = skill.getMethod(f);
        if (easingListenerArr != null) {
            method.addEasingListeners(easingListenerArr);
        }
        valueAnimator.setEvaluator(method);
        return valueAnimator;
    }
}
