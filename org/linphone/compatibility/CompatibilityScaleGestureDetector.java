package org.linphone.compatibility;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

@TargetApi(8)
public class CompatibilityScaleGestureDetector extends SimpleOnScaleGestureListener {
    private ScaleGestureDetector detector;
    private CompatibilityScaleGestureListener listener;

    public CompatibilityScaleGestureDetector(Context context) {
        this.detector = new ScaleGestureDetector(context, this);
    }

    public void destroy() {
        this.listener = null;
        this.detector = null;
    }

    public float getScaleFactor() {
        return this.detector.getScaleFactor();
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        return this.listener == null ? false : this.listener.onScale(this);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.detector.onTouchEvent(motionEvent);
    }

    public void setOnScaleListener(CompatibilityScaleGestureListener compatibilityScaleGestureListener) {
        this.listener = compatibilityScaleGestureListener;
    }
}
