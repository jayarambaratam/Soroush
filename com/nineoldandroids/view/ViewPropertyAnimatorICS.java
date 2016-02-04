package com.nineoldandroids.view;

import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.lang.ref.WeakReference;

class ViewPropertyAnimatorICS extends ViewPropertyAnimator {
    private static final long RETURN_WHEN_NULL = -1;
    private final WeakReference<ViewPropertyAnimator> mNative;

    /* renamed from: com.nineoldandroids.view.ViewPropertyAnimatorICS.1 */
    class C10901 implements AnimatorListener {
        final /* synthetic */ Animator.AnimatorListener val$listener;

        C10901(Animator.AnimatorListener animatorListener) {
            this.val$listener = animatorListener;
        }

        public void onAnimationCancel(android.animation.Animator animator) {
            this.val$listener.onAnimationCancel(null);
        }

        public void onAnimationEnd(android.animation.Animator animator) {
            this.val$listener.onAnimationEnd(null);
        }

        public void onAnimationRepeat(android.animation.Animator animator) {
            this.val$listener.onAnimationRepeat(null);
        }

        public void onAnimationStart(android.animation.Animator animator) {
            this.val$listener.onAnimationStart(null);
        }
    }

    ViewPropertyAnimatorICS(View view) {
        this.mNative = new WeakReference(view.animate());
    }

    public ViewPropertyAnimator alpha(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f);
        }
        return this;
    }

    public ViewPropertyAnimator alphaBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f);
        }
        return this;
    }

    public void cancel() {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public long getDuration() {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        return viewPropertyAnimator != null ? viewPropertyAnimator.getDuration() : RETURN_WHEN_NULL;
    }

    public long getStartDelay() {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        return viewPropertyAnimator != null ? viewPropertyAnimator.getStartDelay() : RETURN_WHEN_NULL;
    }

    public ViewPropertyAnimator rotation(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f);
        }
        return this;
    }

    public ViewPropertyAnimator rotationBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator rotationX(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f);
        }
        return this;
    }

    public ViewPropertyAnimator rotationXBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator rotationY(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f);
        }
        return this;
    }

    public ViewPropertyAnimator rotationYBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator scaleX(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f);
        }
        return this;
    }

    public ViewPropertyAnimator scaleXBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator scaleY(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f);
        }
        return this;
    }

    public ViewPropertyAnimator scaleYBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator setDuration(long j) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j);
        }
        return this;
    }

    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    public ViewPropertyAnimator setListener(Animator.AnimatorListener animatorListener) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            if (animatorListener == null) {
                viewPropertyAnimator.setListener(null);
            } else {
                viewPropertyAnimator.setListener(new C10901(animatorListener));
            }
        }
        return this;
    }

    public ViewPropertyAnimator setStartDelay(long j) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j);
        }
        return this;
    }

    public void start() {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    public ViewPropertyAnimator translationX(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f);
        }
        return this;
    }

    public ViewPropertyAnimator translationXBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator translationY(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f);
        }
        return this;
    }

    public ViewPropertyAnimator translationYBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator m6341x(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f);
        }
        return this;
    }

    public ViewPropertyAnimator xBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f);
        }
        return this;
    }

    public ViewPropertyAnimator m6342y(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f);
        }
        return this;
    }

    public ViewPropertyAnimator yBy(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f);
        }
        return this;
    }
}
