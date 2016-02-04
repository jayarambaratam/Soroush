package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.design.C0042f;
import android.support.design.C0045i;
import android.support.design.C0069j;
import android.support.design.C0070k;
import android.support.v4.view.cb;
import android.support.v4.widget.Space;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.TintManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import org.apache.http.myHttp.HttpStatus;

public class TextInputLayout extends LinearLayout {
    private EditText f409a;
    private CharSequence f410b;
    private Paint f411c;
    private LinearLayout f412d;
    private boolean f413e;
    private TextView f414f;
    private int f415g;
    private boolean f416h;
    private boolean f417i;
    private TextView f418j;
    private int f419k;
    private int f420l;
    private int f421m;
    private boolean f422n;
    private ColorStateList f423o;
    private ColorStateList f424p;
    private final C0086k f425q;
    private boolean f426r;
    private cn f427s;

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f425q = new C0086k(this);
        cm.m677a(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f425q.m795a(C0072a.f429b);
        this.f425q.m802b(new AccelerateInterpolator());
        this.f425q.m807d(8388659);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.TextInputLayout, i, C0069j.Widget_Design_TextInputLayout);
        setHint(obtainStyledAttributes.getText(C0070k.TextInputLayout_android_hint));
        this.f426r = obtainStyledAttributes.getBoolean(C0070k.TextInputLayout_hintAnimationEnabled, true);
        if (obtainStyledAttributes.hasValue(C0070k.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C0070k.TextInputLayout_android_textColorHint);
            this.f424p = colorStateList;
            this.f423o = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(C0070k.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(C0070k.TextInputLayout_hintTextAppearance, 0));
        }
        this.f415g = obtainStyledAttributes.getResourceId(C0070k.TextInputLayout_errorTextAppearance, 0);
        boolean z = obtainStyledAttributes.getBoolean(C0070k.TextInputLayout_errorEnabled, false);
        boolean z2 = obtainStyledAttributes.getBoolean(C0070k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(obtainStyledAttributes.getInt(C0070k.TextInputLayout_counterMaxLength, -1));
        this.f420l = obtainStyledAttributes.getResourceId(C0070k.TextInputLayout_counterTextAppearance, 0);
        this.f421m = obtainStyledAttributes.getResourceId(C0070k.TextInputLayout_counterOverflowTextAppearance, 0);
        obtainStyledAttributes.recycle();
        setErrorEnabled(z);
        setCounterEnabled(z2);
        if (cb.m2420e(this) == 0) {
            cb.m2414c((View) this, 1);
        }
        cb.m2400a((View) this, new cl());
    }

    private LayoutParams m459a(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? (LayoutParams) layoutParams : new LayoutParams(layoutParams);
        if (this.f411c == null) {
            this.f411c = new Paint();
        }
        this.f411c.setTypeface(this.f425q.m806d());
        this.f411c.setTextSize(this.f425q.m812g());
        layoutParams2.topMargin = (int) (-this.f411c.ascent());
        return layoutParams2;
    }

    private void m460a() {
        cb.m2409b(this.f412d, cb.m2436m(this.f409a), 0, cb.m2437n(this.f409a), this.f409a.getPaddingBottom());
    }

    private void m461a(float f) {
        if (this.f425q.m810f() != f) {
            if (this.f427s == null) {
                this.f427s = dk.m755a();
                this.f427s.m684a(C0072a.f428a);
                this.f427s.m680a((int) HttpStatus.SC_OK);
                this.f427s.m683a(new ck(this));
            }
            this.f427s.m679a(this.f425q.m810f(), f);
            this.f427s.m678a();
        }
    }

    private void m462a(int i) {
        boolean z = this.f422n;
        if (this.f419k == -1) {
            this.f418j.setText(String.valueOf(i));
            this.f422n = false;
        } else {
            this.f422n = i > this.f419k;
            if (z != this.f422n) {
                this.f418j.setTextAppearance(getContext(), this.f422n ? this.f421m : this.f420l);
            }
            this.f418j.setText(getContext().getString(C0045i.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.f419k)}));
        }
        if (this.f409a != null && z != this.f422n) {
            m467a(false);
            m471b();
        }
    }

    private void m465a(TextView textView) {
        if (this.f412d != null) {
            this.f412d.removeView(textView);
            if (this.f412d.getChildCount() == 0) {
                this.f412d.setVisibility(8);
            }
        }
    }

    private void m466a(TextView textView, int i) {
        if (this.f412d == null) {
            this.f412d = new LinearLayout(getContext());
            this.f412d.setOrientation(0);
            addView(this.f412d, -1, -2);
            this.f412d.addView(new Space(getContext()), new LayoutParams(0, 0, 1.0f));
            if (this.f409a != null) {
                m460a();
            }
        }
        this.f412d.setVisibility(0);
        this.f412d.addView(textView, i);
    }

    private void m467a(boolean z) {
        Object obj = 1;
        Object obj2 = (this.f409a == null || TextUtils.isEmpty(this.f409a.getText())) ? null : 1;
        boolean a = m469a(getDrawableState(), 16842908);
        if (TextUtils.isEmpty(getError())) {
            obj = null;
        }
        if (this.f423o != null) {
            this.f425q.m799b(this.f423o.getDefaultColor());
        }
        if (this.f422n && this.f418j != null) {
            this.f425q.m791a(this.f418j.getCurrentTextColor());
        } else if (obj != null && this.f414f != null) {
            this.f425q.m791a(this.f414f.getCurrentTextColor());
        } else if (a && this.f424p != null) {
            this.f425q.m791a(this.f424p.getDefaultColor());
        } else if (this.f423o != null) {
            this.f425q.m791a(this.f423o.getDefaultColor());
        }
        if (obj2 == null && !a && obj == null) {
            m474c(z);
        } else {
            m472b(z);
        }
    }

    private static boolean m469a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void m471b() {
        if (this.f416h && this.f414f != null) {
            cb.m2397a(this.f409a, ColorStateList.valueOf(this.f414f.getCurrentTextColor()));
        } else if (!this.f422n || this.f418j == null) {
            cb.m2397a(this.f409a, TintManager.get(getContext()).getTintList(C0042f.abc_edit_text_material));
        } else {
            cb.m2397a(this.f409a, ColorStateList.valueOf(this.f418j.getCurrentTextColor()));
        }
    }

    private void m472b(boolean z) {
        if (this.f427s != null && this.f427s.m685b()) {
            this.f427s.m688e();
        }
        if (z && this.f426r) {
            m461a(1.0f);
        } else {
            this.f425q.m798b(1.0f);
        }
    }

    private void m474c(boolean z) {
        if (this.f427s != null && this.f427s.m685b()) {
            this.f427s.m688e();
        }
        if (z && this.f426r) {
            m461a(0.0f);
        } else {
            this.f425q.m798b(0.0f);
        }
    }

    private void setEditText(EditText editText) {
        if (this.f409a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        this.f409a = editText;
        this.f425q.m805c(this.f409a.getTypeface());
        this.f425q.m790a(this.f409a.getTextSize());
        this.f425q.m804c(this.f409a.getGravity());
        this.f409a.addTextChangedListener(new ch(this));
        if (this.f423o == null) {
            this.f423o = this.f409a.getHintTextColors();
        }
        if (TextUtils.isEmpty(this.f410b)) {
            setHint(this.f409a.getHint());
            this.f409a.setHint(null);
        }
        if (this.f418j != null) {
            m462a(this.f409a.getText().length());
        }
        if (this.f412d != null) {
            m460a();
        }
        m467a(false);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            setEditText((EditText) view);
            super.addView(view, 0, m459a(layoutParams));
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.f425q.m793a(canvas);
    }

    public int getCounterMaxLength() {
        return this.f419k;
    }

    public EditText getEditText() {
        return this.f409a;
    }

    public CharSequence getError() {
        return (this.f413e && this.f414f != null && this.f414f.getVisibility() == 0) ? this.f414f.getText() : null;
    }

    public CharSequence getHint() {
        return this.f410b;
    }

    public Typeface getTypeface() {
        return this.f425q.m806d();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f409a != null) {
            int left = this.f409a.getLeft() + this.f409a.getCompoundPaddingLeft();
            int right = this.f409a.getRight() - this.f409a.getCompoundPaddingRight();
            this.f425q.m792a(left, this.f409a.getTop() + this.f409a.getCompoundPaddingTop(), right, this.f409a.getBottom() - this.f409a.getCompoundPaddingBottom());
            this.f425q.m800b(left, getPaddingTop(), right, (i4 - i2) - getPaddingBottom());
            this.f425q.m813h();
        }
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        m467a(cb.m2385D(this));
    }

    public void setCounterEnabled(boolean z) {
        if (this.f417i != z) {
            if (z) {
                this.f418j = new TextView(getContext());
                this.f418j.setMaxLines(1);
                this.f418j.setTextAppearance(getContext(), this.f420l);
                cb.m2419d(this.f418j, 1);
                m466a(this.f418j, -1);
                if (this.f409a == null) {
                    m462a(0);
                } else {
                    m462a(this.f409a.getText().length());
                }
            } else {
                m465a(this.f418j);
                this.f418j = null;
            }
            this.f417i = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f419k != i) {
            if (i > 0) {
                this.f419k = i;
            } else {
                this.f419k = -1;
            }
            if (this.f417i) {
                m462a(this.f409a == null ? 0 : this.f409a.getText().length());
            }
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f413e) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            cb.m2413c(this.f414f, 0.0f);
            this.f414f.setText(charSequence);
            cb.m2442s(this.f414f).m2798a(1.0f).m2799a(200).m2802a(C0072a.f429b).m2800a(new ci(this)).m2807c();
            this.f416h = true;
            m471b();
            m467a(true);
        } else if (this.f414f.getVisibility() == 0) {
            cb.m2442s(this.f414f).m2798a(0.0f).m2799a(200).m2802a(C0072a.f429b).m2800a(new cj(this)).m2807c();
            this.f416h = false;
            m471b();
        }
    }

    public void setErrorEnabled(boolean z) {
        if (this.f413e != z) {
            if (this.f414f != null) {
                cb.m2442s(this.f414f).m2805b();
            }
            if (z) {
                this.f414f = new TextView(getContext());
                this.f414f.setTextAppearance(getContext(), this.f415g);
                this.f414f.setVisibility(4);
                cb.m2419d(this.f414f, 1);
                m466a(this.f414f, 0);
            } else {
                this.f416h = false;
                m471b();
                m465a(this.f414f);
                this.f414f = null;
            }
            this.f413e = z;
        }
    }

    public void setHint(CharSequence charSequence) {
        this.f410b = charSequence;
        this.f425q.m796a(charSequence);
        sendAccessibilityEvent(ItemAnimator.FLAG_MOVED);
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f426r = z;
    }

    public void setHintTextAppearance(int i) {
        this.f425q.m809e(i);
        this.f424p = ColorStateList.valueOf(this.f425q.m815j());
        if (this.f409a != null) {
            m467a(false);
            this.f409a.setLayoutParams(m459a(this.f409a.getLayoutParams()));
            this.f409a.requestLayout();
        }
    }

    public void setTypeface(Typeface typeface) {
        this.f425q.m805c(typeface);
    }
}
