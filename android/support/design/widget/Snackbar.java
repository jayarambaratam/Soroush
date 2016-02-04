package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.design.C0038b;
import android.support.design.C0041e;
import android.support.design.C0043g;
import android.support.design.C0044h;
import android.support.design.C0070k;
import android.support.v4.view.cb;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class Snackbar {
    private static final Handler f369a;
    private final ViewGroup f370b;
    private final Context f371c;
    private final SnackbarLayout f372d;
    private int f373e;
    private bk f374f;
    private final bp f375g;

    public class SnackbarLayout extends LinearLayout {
        private TextView f363a;
        private Button f364b;
        private int f365c;
        private int f366d;
        private bm f367e;
        private bl f368f;

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.SnackbarLayout);
            this.f365c = obtainStyledAttributes.getDimensionPixelSize(C0070k.SnackbarLayout_android_maxWidth, -1);
            this.f366d = obtainStyledAttributes.getDimensionPixelSize(C0070k.SnackbarLayout_maxActionInlineWidth, -1);
            if (obtainStyledAttributes.hasValue(C0070k.SnackbarLayout_elevation)) {
                cb.m2432j(this, (float) obtainStyledAttributes.getDimensionPixelSize(C0070k.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(C0044h.design_layout_snackbar_include, this);
            cb.m2419d((View) this, 1);
        }

        private static void m372a(View view, int i, int i2) {
            if (cb.m2382A(view)) {
                cb.m2409b(view, cb.m2436m(view), i, cb.m2437n(view), i2);
            } else {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
            }
        }

        private boolean m373a(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.f363a.getPaddingTop() == i2 && this.f363a.getPaddingBottom() == i3) {
                return z;
            }
            m372a(this.f363a, i2, i3);
            return true;
        }

        void m374a(int i, int i2) {
            cb.m2413c(this.f363a, 0.0f);
            cb.m2442s(this.f363a).m2798a(1.0f).m2799a((long) i2).m2804b((long) i).m2807c();
            if (this.f364b.getVisibility() == 0) {
                cb.m2413c(this.f364b, 0.0f);
                cb.m2442s(this.f364b).m2798a(1.0f).m2799a((long) i2).m2804b((long) i).m2807c();
            }
        }

        void m375b(int i, int i2) {
            cb.m2413c(this.f363a, 1.0f);
            cb.m2442s(this.f363a).m2798a(0.0f).m2799a((long) i2).m2804b((long) i).m2807c();
            if (this.f364b.getVisibility() == 0) {
                cb.m2413c(this.f364b, 1.0f);
                cb.m2442s(this.f364b).m2798a(0.0f).m2799a((long) i2).m2804b((long) i).m2807c();
            }
        }

        Button getActionView() {
            return this.f364b;
        }

        TextView getMessageView() {
            return this.f363a;
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f368f != null) {
                this.f368f.m567a(this);
            }
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f368f != null) {
                this.f368f.m568b(this);
            }
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.f363a = (TextView) findViewById(C0043g.snackbar_text);
            this.f364b = (Button) findViewById(C0043g.snackbar_action);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z && this.f367e != null) {
                this.f367e.m571a(this, i, i2, i3, i4);
            }
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f365c > 0 && getMeasuredWidth() > this.f365c) {
                i = MeasureSpec.makeMeasureSpec(this.f365c, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(C0041e.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0041e.design_snackbar_padding_vertical);
            int i3 = this.f363a.getLayout().getLineCount() > 1 ? 1 : 0;
            if (i3 == 0 || this.f366d <= 0 || this.f364b.getMeasuredWidth() <= this.f366d) {
                if (i3 == 0) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (m373a(0, dimensionPixelSize, dimensionPixelSize)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            } else {
                if (m373a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize != 0) {
                super.onMeasure(i, i2);
            }
        }

        void setOnAttachStateChangeListener(bl blVar) {
            this.f368f = blVar;
        }

        void setOnLayoutChangeListener(bm bmVar) {
            this.f367e = bmVar;
        }
    }

    static {
        f369a = new Handler(Looper.getMainLooper(), new ay());
    }

    private Snackbar(ViewGroup viewGroup) {
        this.f375g = new bb(this);
        this.f370b = viewGroup;
        this.f371c = viewGroup.getContext();
        cm.m677a(this.f371c);
        this.f372d = (SnackbarLayout) LayoutInflater.from(this.f371c).inflate(C0044h.design_layout_snackbar, this.f370b, false);
    }

    public static Snackbar m376a(View view, int i, int i2) {
        return m377a(view, view.getResources().getText(i), i2);
    }

    public static Snackbar m377a(View view, CharSequence charSequence, int i) {
        Snackbar snackbar = new Snackbar(m379a(view));
        snackbar.m393a(charSequence);
        snackbar.m391a(i);
        return snackbar;
    }

    private static ViewGroup m379a(View view) {
        ViewGroup viewGroup = null;
        View view2 = view;
        while (!(view2 instanceof CoordinatorLayout)) {
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    return (ViewGroup) view2;
                }
                viewGroup = (ViewGroup) view2;
            }
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                    continue;
                } else {
                    view2 = null;
                    continue;
                }
            }
            if (view2 == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view2;
    }

    private void m384c(int i) {
        bn.m578a().m588a(this.f375g, i);
    }

    private void m387d(int i) {
        if (VERSION.SDK_INT >= 14) {
            cb.m2442s(this.f372d).m2806c((float) this.f372d.getHeight()).m2802a(C0072a.f429b).m2799a(250).m2800a(new bi(this, i)).m2807c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f372d.getContext(), C0038b.design_snackbar_out);
        loadAnimation.setInterpolator(C0072a.f429b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new az(this, i));
        this.f372d.startAnimation(loadAnimation);
    }

    private void m388e() {
        if (VERSION.SDK_INT >= 14) {
            cb.m2408b(this.f372d, (float) this.f372d.getHeight());
            cb.m2442s(this.f372d).m2806c(0.0f).m2802a(C0072a.f429b).m2799a(250).m2800a(new bg(this)).m2807c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f372d.getContext(), C0038b.design_snackbar_in);
        loadAnimation.setInterpolator(C0072a.f429b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new bh(this));
        this.f372d.startAnimation(loadAnimation);
    }

    private void m389e(int i) {
        bn.m578a().m587a(this.f375g);
        if (this.f374f != null) {
            this.f374f.m577a(this, i);
        }
        ViewParent parent = this.f372d.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f372d);
        }
    }

    private boolean m390f() {
        LayoutParams layoutParams = this.f372d.getLayoutParams();
        if (layoutParams instanceof C0095u) {
            C0071r b = ((C0095u) layoutParams).m831b();
            if (b instanceof SwipeDismissBehavior) {
                return ((SwipeDismissBehavior) b).m411a() != 0;
            }
        }
        return false;
    }

    public Snackbar m391a(int i) {
        this.f373e = i;
        return this;
    }

    public Snackbar m392a(int i, OnClickListener onClickListener) {
        return m394a(this.f371c.getText(i), onClickListener);
    }

    public Snackbar m393a(CharSequence charSequence) {
        this.f372d.getMessageView().setText(charSequence);
        return this;
    }

    public Snackbar m394a(CharSequence charSequence, OnClickListener onClickListener) {
        TextView actionView = this.f372d.getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
        } else {
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new ba(this, onClickListener));
        }
        return this;
    }

    public void m395a() {
        bn.m578a().m586a(this.f373e, this.f375g);
    }

    final void m396b(int i) {
        if (this.f372d.getVisibility() != 0 || m390f()) {
            m389e(i);
        } else {
            m387d(i);
        }
    }

    public boolean m397b() {
        return bn.m578a().m592e(this.f375g);
    }

    final void m398c() {
        if (this.f372d.getParent() == null) {
            LayoutParams layoutParams = this.f372d.getLayoutParams();
            if (layoutParams instanceof C0095u) {
                C0071r bjVar = new bj(this);
                bjVar.m412a(0.1f);
                bjVar.m417b(0.6f);
                bjVar.m413a(0);
                bjVar.m414a(new bc(this));
                ((C0095u) layoutParams).m827a(bjVar);
            }
            this.f370b.addView(this.f372d);
        }
        this.f372d.setOnAttachStateChangeListener(new bd(this));
        if (cb.m2385D(this.f372d)) {
            m388e();
        } else {
            this.f372d.setOnLayoutChangeListener(new bf(this));
        }
    }
}
