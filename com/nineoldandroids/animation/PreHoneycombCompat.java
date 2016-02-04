package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;
import org.jivesoftware.smackx.xdata.packet.DataForm;

final class PreHoneycombCompat {
    static Property<View, Float> ALPHA;
    static Property<View, Float> PIVOT_X;
    static Property<View, Float> PIVOT_Y;
    static Property<View, Float> ROTATION;
    static Property<View, Float> ROTATION_X;
    static Property<View, Float> ROTATION_Y;
    static Property<View, Float> SCALE_X;
    static Property<View, Float> SCALE_Y;
    static Property<View, Integer> SCROLL_X;
    static Property<View, Integer> SCROLL_Y;
    static Property<View, Float> TRANSLATION_X;
    static Property<View, Float> TRANSLATION_Y;
    static Property<View, Float> f4094X;
    static Property<View, Float> f4095Y;

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.10 */
    final class AnonymousClass10 extends FloatProperty<View> {
        AnonymousClass10(String str) {
            super(str);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleY());
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setScaleY(f);
        }
    }

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.11 */
    final class AnonymousClass11 extends IntProperty<View> {
        AnonymousClass11(String str) {
            super(str);
        }

        public Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollX());
        }

        public void setValue(View view, int i) {
            AnimatorProxy.wrap(view).setScrollX(i);
        }
    }

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.12 */
    final class AnonymousClass12 extends IntProperty<View> {
        AnonymousClass12(String str) {
            super(str);
        }

        public Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollY());
        }

        public void setValue(View view, int i) {
            AnimatorProxy.wrap(view).setScrollY(i);
        }
    }

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.13 */
    final class AnonymousClass13 extends FloatProperty<View> {
        AnonymousClass13(String str) {
            super(str);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getX());
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setX(f);
        }
    }

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.14 */
    final class AnonymousClass14 extends FloatProperty<View> {
        AnonymousClass14(String str) {
            super(str);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getY());
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setY(f);
        }
    }

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.1 */
    final class C10741 extends FloatProperty<View> {
        C10741(String str) {
            super(str);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getAlpha());
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setAlpha(f);
        }
    }

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.2 */
    final class C10752 extends FloatProperty<View> {
        C10752(String str) {
            super(str);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotX());
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setPivotX(f);
        }
    }

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.3 */
    final class C10763 extends FloatProperty<View> {
        C10763(String str) {
            super(str);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotY());
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setPivotY(f);
        }
    }

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.4 */
    final class C10774 extends FloatProperty<View> {
        C10774(String str) {
            super(str);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationX());
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setTranslationX(f);
        }
    }

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.5 */
    final class C10785 extends FloatProperty<View> {
        C10785(String str) {
            super(str);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationY());
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setTranslationY(f);
        }
    }

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.6 */
    final class C10796 extends FloatProperty<View> {
        C10796(String str) {
            super(str);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotation());
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setRotation(f);
        }
    }

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.7 */
    final class C10807 extends FloatProperty<View> {
        C10807(String str) {
            super(str);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationX());
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setRotationX(f);
        }
    }

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.8 */
    final class C10818 extends FloatProperty<View> {
        C10818(String str) {
            super(str);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationY());
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setRotationY(f);
        }
    }

    /* renamed from: com.nineoldandroids.animation.PreHoneycombCompat.9 */
    final class C10829 extends FloatProperty<View> {
        C10829(String str) {
            super(str);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleX());
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setScaleX(f);
        }
    }

    static {
        ALPHA = new C10741("alpha");
        PIVOT_X = new C10752("pivotX");
        PIVOT_Y = new C10763("pivotY");
        TRANSLATION_X = new C10774("translationX");
        TRANSLATION_Y = new C10785("translationY");
        ROTATION = new C10796("rotation");
        ROTATION_X = new C10807("rotationX");
        ROTATION_Y = new C10818("rotationY");
        SCALE_X = new C10829("scaleX");
        SCALE_Y = new AnonymousClass10("scaleY");
        SCROLL_X = new AnonymousClass11("scrollX");
        SCROLL_Y = new AnonymousClass12("scrollY");
        f4094X = new AnonymousClass13(DataForm.ELEMENT);
        f4095Y = new AnonymousClass14("y");
    }

    private PreHoneycombCompat() {
    }
}
