package net.frakbot.glowpadbackport;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import net.frakbot.glowpadbackport.util.TimeInterpolator;
import org.jivesoftware.smackx.delay.packet.DelayInformation;

class Tweener {
    private static final boolean DEBUG = false;
    private static final String TAG = "Tweener";
    private static AnimatorListener mCleanupListener;
    private static HashMap<Object, Tweener> sTweens;
    ObjectAnimator animator;

    /* renamed from: net.frakbot.glowpadbackport.Tweener.1 */
    final class C26331 extends AnimatorListenerAdapter {
        C26331() {
        }

        public void onAnimationCancel(Animator animator) {
            Tweener.remove(animator);
        }

        public void onAnimationEnd(Animator animator) {
            Tweener.remove(animator);
        }
    }

    static {
        sTweens = new HashMap();
        mCleanupListener = new C26331();
    }

    public Tweener(ObjectAnimator objectAnimator) {
        this.animator = objectAnimator;
    }

    private static void remove(Animator animator) {
        Iterator it = sTweens.entrySet().iterator();
        while (it.hasNext()) {
            if (((Tweener) ((Entry) it.next()).getValue()).animator == animator) {
                it.remove();
                return;
            }
        }
    }

    private static void replace(ArrayList<PropertyValuesHolder> arrayList, Object... objArr) {
        for (Object obj : objArr) {
            Tweener tweener = (Tweener) sTweens.get(obj);
            if (tweener != null) {
                tweener.animator.cancel();
                if (arrayList != null) {
                    tweener.animator.setValues((PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[arrayList.size()]));
                } else {
                    sTweens.remove(tweener);
                }
            }
        }
    }

    public static void reset() {
        sTweens.clear();
    }

    public static Tweener to(Object obj, long j, Object... objArr) {
        ObjectAnimator ofPropertyValuesHolder;
        Tweener tweener;
        long j2 = 0;
        AnimatorUpdateListener animatorUpdateListener = null;
        AnimatorListener animatorListener = null;
        Interpolator interpolator = null;
        ArrayList arrayList = new ArrayList(objArr.length / 2);
        int i = 0;
        while (i < objArr.length) {
            if (objArr[i] instanceof String) {
                TimeInterpolator timeInterpolator;
                AnimatorListener animatorListener2;
                AnimatorUpdateListener animatorUpdateListener2;
                long j3;
                String str = (String) objArr[i];
                Object obj2 = objArr[i + 1];
                if ("simultaneousTween".equals(str)) {
                    timeInterpolator = interpolator;
                    animatorListener2 = animatorListener;
                    animatorUpdateListener2 = animatorUpdateListener;
                    j3 = j2;
                } else if ("ease".equals(str)) {
                    timeInterpolator = (TimeInterpolator) obj2;
                    animatorListener2 = animatorListener;
                    animatorUpdateListener2 = animatorUpdateListener;
                    j3 = j2;
                } else if ("onUpdate".equals(str) || "onUpdateListener".equals(str)) {
                    r2 = interpolator;
                    animatorUpdateListener2 = (AnimatorUpdateListener) obj2;
                    animatorListener2 = animatorListener;
                    j3 = j2;
                } else if ("onComplete".equals(str) || "onCompleteListener".equals(str)) {
                    animatorListener2 = (AnimatorListener) obj2;
                    r2 = interpolator;
                    animatorUpdateListener2 = animatorUpdateListener;
                    j3 = j2;
                } else if (DelayInformation.ELEMENT.equals(str)) {
                    animatorUpdateListener2 = animatorUpdateListener;
                    AnimatorListener animatorListener3 = animatorListener;
                    j3 = ((Number) obj2).longValue();
                    r2 = interpolator;
                    animatorListener2 = animatorListener3;
                } else if ("syncWith".equals(str)) {
                    r2 = interpolator;
                    animatorListener2 = animatorListener;
                    animatorUpdateListener2 = animatorUpdateListener;
                    j3 = j2;
                } else if (obj2 instanceof float[]) {
                    arrayList.add(PropertyValuesHolder.ofFloat(str, ((float[]) obj2)[0], ((float[]) obj2)[1]));
                    r2 = interpolator;
                    animatorListener2 = animatorListener;
                    animatorUpdateListener2 = animatorUpdateListener;
                    j3 = j2;
                } else if (obj2 instanceof int[]) {
                    arrayList.add(PropertyValuesHolder.ofInt(str, ((int[]) obj2)[0], ((int[]) obj2)[1]));
                    r2 = interpolator;
                    animatorListener2 = animatorListener;
                    animatorUpdateListener2 = animatorUpdateListener;
                    j3 = j2;
                } else if (obj2 instanceof Number) {
                    arrayList.add(PropertyValuesHolder.ofFloat(str, ((Number) obj2).floatValue()));
                    r2 = interpolator;
                    animatorListener2 = animatorListener;
                    animatorUpdateListener2 = animatorUpdateListener;
                    j3 = j2;
                } else {
                    throw new IllegalArgumentException("Bad argument for key \"" + str + "\" with value " + obj2.getClass());
                }
                i += 2;
                j2 = j3;
                animatorListener = animatorListener2;
                animatorUpdateListener = animatorUpdateListener2;
                Object obj3 = timeInterpolator;
            } else {
                throw new IllegalArgumentException("Key must be a string: " + objArr[i]);
            }
        }
        Tweener tweener2 = (Tweener) sTweens.get(obj);
        if (tweener2 == null) {
            ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[arrayList.size()]));
            tweener = new Tweener(ofPropertyValuesHolder);
            sTweens.put(obj, tweener);
        } else {
            ObjectAnimator objectAnimator = ((Tweener) sTweens.get(obj)).animator;
            replace(arrayList, obj);
            ObjectAnimator objectAnimator2 = objectAnimator;
            tweener = tweener2;
            ofPropertyValuesHolder = objectAnimator2;
        }
        if (interpolator != null) {
            ofPropertyValuesHolder.setInterpolator(interpolator);
        }
        ofPropertyValuesHolder.setStartDelay(j2);
        ofPropertyValuesHolder.setDuration(j);
        if (animatorUpdateListener != null) {
            ofPropertyValuesHolder.removeAllUpdateListeners();
            ofPropertyValuesHolder.addUpdateListener(animatorUpdateListener);
        }
        if (animatorListener != null) {
            ofPropertyValuesHolder.removeAllListeners();
            ofPropertyValuesHolder.addListener(animatorListener);
        }
        ofPropertyValuesHolder.addListener(mCleanupListener);
        return tweener;
    }

    Tweener from(Object obj, long j, Object... objArr) {
        return to(obj, j, objArr);
    }
}
