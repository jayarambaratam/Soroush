package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.support.v4.p016f.C0223a;
import android.support.v4.view.cb;
import android.support.v7.p019a.C0369l;
import android.support.v7.view.C0429e;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

class bg {
    private static final Class<?>[] f1796a;
    private static final int[] f1797b;
    private static final Map<String, Constructor<? extends View>> f1798c;
    private final Object[] f1799d;

    static {
        f1796a = new Class[]{Context.class, AttributeSet.class};
        f1797b = new int[]{16843375};
        f1798c = new C0223a();
    }

    bg() {
        this.f1799d = new Object[2];
    }

    private static Context m3658a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0369l.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(C0369l.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0) {
            resourceId = obtainStyledAttributes.getResourceId(C0369l.View_theme, 0);
            if (resourceId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        return i != 0 ? ((context instanceof C0429e) && ((C0429e) context).m3965a() == i) ? context : new C0429e(context, i) : context;
    }

    private View m3659a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f1799d[0] = context;
            this.f1799d[1] = attributeSet;
            View a;
            if (-1 == str.indexOf(46)) {
                a = m3660a(context, str, "android.widget.");
                return a;
            }
            a = m3660a(context, str, null);
            this.f1799d[0] = null;
            this.f1799d[1] = null;
            return a;
        } catch (Exception e) {
            return null;
        } finally {
            this.f1799d[0] = null;
            this.f1799d[1] = null;
        }
    }

    private View m3660a(Context context, String str, String str2) {
        Constructor constructor = (Constructor) f1798c.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f1796a);
                f1798c.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f1799d);
    }

    private void m3661a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (cb.m2388G(view) && (context instanceof ContextWrapper)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1797b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new bh(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final View m3662a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3) {
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = m3658a(context2, attributeSet, z2, z3);
        }
        View view2 = null;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    obj = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    obj = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    obj = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    obj = null;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    obj = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    obj = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    obj = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    obj = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    obj = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    obj = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    obj = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    obj = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case VideoSize.QCIF /*0*/:
                view2 = new AppCompatTextView(context2, attributeSet);
                break;
            case VideoSize.CIF /*1*/:
                view2 = new AppCompatImageView(context2, attributeSet);
                break;
            case VideoSize.HVGA /*2*/:
                view2 = new AppCompatButton(context2, attributeSet);
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                view2 = new AppCompatEditText(context2, attributeSet);
                break;
            case Version.API04_DONUT_16 /*4*/:
                view2 = new AppCompatSpinner(context2, attributeSet);
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                view2 = new AppCompatImageButton(context2, attributeSet);
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                view2 = new AppCompatCheckBox(context2, attributeSet);
                break;
            case Version.API07_ECLAIR_21 /*7*/:
                view2 = new AppCompatRadioButton(context2, attributeSet);
                break;
            case Version.API08_FROYO_22 /*8*/:
                view2 = new AppCompatCheckedTextView(context2, attributeSet);
                break;
            case Version.API09_GINGERBREAD_23 /*9*/:
                view2 = new AppCompatAutoCompleteTextView(context2, attributeSet);
                break;
            case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                view2 = new AppCompatMultiAutoCompleteTextView(context2, attributeSet);
                break;
            case Version.API11_HONEYCOMB_30 /*11*/:
                view2 = new AppCompatRatingBar(context2, attributeSet);
                break;
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
                view2 = new AppCompatSeekBar(context2, attributeSet);
                break;
        }
        View a = (view2 != null || context == context2) ? view2 : m3659a(context2, str, attributeSet);
        if (a != null) {
            m3661a(a, attributeSet);
        }
        return a;
    }
}
