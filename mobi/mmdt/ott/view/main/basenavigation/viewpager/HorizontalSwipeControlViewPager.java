package mobi.mmdt.ott.view.main.basenavigation.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import java.lang.reflect.Field;

public class HorizontalSwipeControlViewPager extends ViewPager {
    private boolean f7661a;

    public HorizontalSwipeControlViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7661a = true;
        try {
            Field declaredField = ViewPager.class.getDeclaredField("m");
            declaredField.setAccessible(true);
            Field declaredField2 = ViewPager.class.getDeclaredField("d");
            declaredField2.setAccessible(true);
            declaredField.set(this, new C2326a(getContext(), (Interpolator) declaredField2.get(null)));
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e2) {
        } catch (IllegalAccessException e3) {
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f7661a ? super.onInterceptTouchEvent(motionEvent) : false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f7661a ? super.onTouchEvent(motionEvent) : false;
    }

    public void setPagingEnabled(boolean z) {
        this.f7661a = z;
    }
}
