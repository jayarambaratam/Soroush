package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C0041e;
import android.support.design.C0069j;
import android.support.design.C0070k;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.cb;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageButton;
import java.util.List;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

@C0093s(a = Behavior.class)
public class FloatingActionButton extends ImageButton {
    private ColorStateList f347a;
    private Mode f348b;
    private int f349c;
    private int f350d;
    private int f351e;
    private int f352f;
    private final Rect f353g;
    private final al f354h;

    public class Behavior extends C0071r<FloatingActionButton> {
        private static final boolean f343a;
        private cn f344b;
        private float f345c;
        private Rect f346d;

        static {
            f343a = VERSION.SDK_INT >= 11;
        }

        private float m351a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            float f = 0.0f;
            List d = coordinatorLayout.m349d((View) floatingActionButton);
            int size = d.size();
            int i = 0;
            while (i < size) {
                View view = (View) d.get(i);
                float min = ((view instanceof SnackbarLayout) && coordinatorLayout.m340a((View) floatingActionButton, view)) ? Math.min(f, cb.m2439p(view) - ((float) view.getHeight())) : f;
                i++;
                f = min;
            }
            return f;
        }

        private boolean m352a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (((C0095u) floatingActionButton.getLayoutParams()).m825a() != appBarLayout.getId()) {
                return false;
            }
            if (this.f346d == null) {
                this.f346d = new Rect();
            }
            Rect rect = this.f346d;
            dc.m743b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m367b();
            } else {
                floatingActionButton.m366a();
            }
            return true;
        }

        private void m353b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            Rect a = floatingActionButton.f353g;
            if (a != null && a.centerX() > 0 && a.centerY() > 0) {
                C0095u c0095u = (C0095u) floatingActionButton.getLayoutParams();
                int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - c0095u.rightMargin ? a.right : floatingActionButton.getLeft() <= c0095u.leftMargin ? -a.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getBottom() - c0095u.bottomMargin) {
                    i = a.bottom;
                } else if (floatingActionButton.getTop() <= c0095u.topMargin) {
                    i = -a.top;
                }
                floatingActionButton.offsetTopAndBottom(i);
                floatingActionButton.offsetLeftAndRight(i2);
            }
        }

        private void m354c(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (floatingActionButton.getVisibility() == 0) {
                float a = m351a(coordinatorLayout, floatingActionButton);
                if (this.f345c != a) {
                    float p = cb.m2439p(floatingActionButton);
                    if (this.f344b != null && this.f344b.m685b()) {
                        this.f344b.m688e();
                    }
                    if (Math.abs(p - a) > ((float) floatingActionButton.getHeight()) * 0.667f) {
                        if (this.f344b == null) {
                            this.f344b = dk.m755a();
                            this.f344b.m684a(C0072a.f429b);
                            this.f344b.m683a(new ab(this, floatingActionButton));
                        }
                        this.f344b.m679a(p, a);
                        this.f344b.m678a();
                    } else {
                        cb.m2408b((View) floatingActionButton, a);
                    }
                    this.f345c = a;
                }
            }
        }

        public boolean m355a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List d = coordinatorLayout.m349d((View) floatingActionButton);
            int size = d.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) d.get(i2);
                if ((view instanceof AppBarLayout) && m352a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.m333a((View) floatingActionButton, i);
            m353b(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean m356a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return f343a && (view instanceof SnackbarLayout);
        }

        public boolean m358b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof SnackbarLayout) {
                m354c(coordinatorLayout, floatingActionButton, view);
            } else if (view instanceof AppBarLayout) {
                m352a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            }
            return false;
        }

        public /* synthetic */ boolean m359b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m356a(coordinatorLayout, (FloatingActionButton) view, view2);
        }

        public /* synthetic */ boolean m360c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m358b(coordinatorLayout, (FloatingActionButton) view, view2);
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        cm.m677a(context);
        this.f353g = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.FloatingActionButton, i, C0069j.Widget_Design_FloatingActionButton);
        this.f347a = obtainStyledAttributes.getColorStateList(C0070k.FloatingActionButton_backgroundTint);
        this.f348b = m362a(obtainStyledAttributes.getInt(C0070k.FloatingActionButton_backgroundTintMode, -1), null);
        this.f350d = obtainStyledAttributes.getColor(C0070k.FloatingActionButton_rippleColor, 0);
        this.f351e = obtainStyledAttributes.getInt(C0070k.FloatingActionButton_fabSize, 0);
        this.f349c = obtainStyledAttributes.getDimensionPixelSize(C0070k.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(C0070k.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(C0070k.FloatingActionButton_pressedTranslationZ, 0.0f);
        obtainStyledAttributes.recycle();
        ax aaVar = new aa(this);
        int i2 = VERSION.SDK_INT;
        if (i2 >= 21) {
            this.f354h = new ao(this, aaVar);
        } else if (i2 >= 12) {
            this.f354h = new ai(this, aaVar);
        } else {
            this.f354h = new ac(this, aaVar);
        }
        this.f352f = (getSizeDimension() - ((int) getResources().getDimension(C0041e.design_fab_content_size))) / 2;
        this.f354h.m492a(this.f347a, this.f348b, this.f350d, this.f349c);
        this.f354h.m489a(dimension);
        this.f354h.m496b(dimension2);
    }

    private static int m361a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case RtlSpacingHelper.UNDEFINED /*-2147483648*/:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    static Mode m362a(int i, Mode mode) {
        switch (i) {
            case Version.API03_CUPCAKE_15 /*3*/:
                return Mode.SRC_OVER;
            case Version.API05_ECLAIR_20 /*5*/:
                return Mode.SRC_IN;
            case Version.API09_GINGERBREAD_23 /*9*/:
                return Mode.SRC_ATOP;
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
                return Mode.MULTIPLY;
            case Version.API15_ICE_CREAM_SANDWICH_403 /*15*/:
                return Mode.SCREEN;
            default:
                return mode;
        }
    }

    public void m366a() {
        this.f354h.m497b(null);
    }

    public void m367b() {
        this.f354h.m494a(null);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f354h.m495a(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.f347a;
    }

    public Mode getBackgroundTintMode() {
        return this.f348b;
    }

    final int getSizeDimension() {
        switch (this.f351e) {
            case VideoSize.CIF /*1*/:
                return getResources().getDimensionPixelSize(C0041e.design_fab_size_mini);
            default:
                return getResources().getDimensionPixelSize(C0041e.design_fab_size_normal);
        }
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f354h.m488a();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f354h.m500d();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f354h.m501e();
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        sizeDimension = Math.min(m361a(sizeDimension, i), m361a(sizeDimension, i2));
        setMeasuredDimension((this.f353g.left + sizeDimension) + this.f353g.right, (sizeDimension + this.f353g.top) + this.f353g.bottom);
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f347a != colorStateList) {
            this.f347a = colorStateList;
            this.f354h.m491a(colorStateList);
        }
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.f348b != mode) {
            this.f348b = mode;
            this.f354h.m493a(mode);
        }
    }

    public void setRippleColor(int i) {
        if (this.f350d != i) {
            this.f350d = i;
            this.f354h.m490a(i);
        }
    }
}
