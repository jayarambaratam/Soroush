package mobi.mmdt.ott.view.main.basenavigation.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import java.lang.reflect.Field;

public class VerticalSwipeControlViewPager extends VerticalViewPager {
    private boolean f7711a;

    public VerticalSwipeControlViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7711a = true;
        try {
            Field declaredField = VerticalViewPager.class.getDeclaredField("m");
            declaredField.setAccessible(true);
            Field declaredField2 = VerticalViewPager.class.getDeclaredField("d");
            declaredField2.setAccessible(true);
            declaredField.set(this, new C2327b(getContext(), (Interpolator) declaredField2.get(null)));
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e2) {
        } catch (IllegalAccessException e3) {
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f7711a ? super.onInterceptTouchEvent(motionEvent) : false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f7711a ? super.onTouchEvent(motionEvent) : false;
    }
}
