package net.frakbot.glowpadbackport.util;

import android.view.animation.Interpolator;

public interface TimeInterpolator extends Interpolator {
    float getInterpolation(float f);
}
