package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.C0044h;
import android.support.v4.view.cb;
import android.support.v4.widget.ci;
import android.support.v7.app.C0379d;
import android.support.v7.widget.TintManager;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

class cf extends LinearLayout implements OnLongClickListener {
    final /* synthetic */ TabLayout f548a;
    private final cd f549b;
    private TextView f550c;
    private ImageView f551d;
    private View f552e;
    private TextView f553f;
    private ImageView f554g;
    private int f555h;

    public cf(TabLayout tabLayout, Context context, cd cdVar) {
        this.f548a = tabLayout;
        super(context);
        this.f555h = 2;
        this.f549b = cdVar;
        if (tabLayout.f397l != 0) {
            setBackgroundDrawable(TintManager.getDrawable(context, tabLayout.f397l));
        }
        cb.m2409b(this, tabLayout.f389d, tabLayout.f390e, tabLayout.f391f, tabLayout.f392g);
        setGravity(17);
        setOrientation(1);
        m671a();
    }

    private float m669a(Layout layout, int i, float f) {
        return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
    }

    private void m670a(cd cdVar, TextView textView, ImageView imageView) {
        Drawable b = cdVar.m658b();
        CharSequence d = cdVar.m660d();
        if (imageView != null) {
            if (b != null) {
                imageView.setImageDrawable(b);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
            imageView.setContentDescription(cdVar.m662f());
        }
        boolean z = !TextUtils.isEmpty(d);
        if (textView != null) {
            if (z) {
                textView.setText(d);
                textView.setContentDescription(cdVar.m662f());
                textView.setVisibility(0);
                setVisibility(0);
            } else {
                textView.setVisibility(8);
                textView.setText(null);
            }
        }
        if (imageView != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
            int b2 = (z && imageView.getVisibility() == 0) ? this.f548a.m437d(8) : 0;
            if (b2 != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = b2;
                imageView.requestLayout();
            }
        }
        if (z || TextUtils.isEmpty(cdVar.m662f())) {
            setOnLongClickListener(null);
            setLongClickable(false);
            return;
        }
        setOnLongClickListener(this);
    }

    final void m671a() {
        cd cdVar = this.f549b;
        View a = cdVar.m656a();
        if (a != null) {
            cf parent = a.getParent();
            if (parent != this) {
                if (parent != null) {
                    parent.removeView(a);
                }
                addView(a);
            }
            this.f552e = a;
            if (this.f550c != null) {
                this.f550c.setVisibility(8);
            }
            if (this.f551d != null) {
                this.f551d.setVisibility(8);
                this.f551d.setImageDrawable(null);
            }
            this.f553f = (TextView) a.findViewById(16908308);
            if (this.f553f != null) {
                this.f555h = ci.m3355a(this.f553f);
            }
            this.f554g = (ImageView) a.findViewById(16908294);
        } else {
            if (this.f552e != null) {
                removeView(this.f552e);
                this.f552e = null;
            }
            this.f553f = null;
            this.f554g = null;
        }
        if (this.f552e == null) {
            if (this.f551d == null) {
                ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(C0044h.design_layout_tab_icon, this, false);
                addView(imageView, 0);
                this.f551d = imageView;
            }
            if (this.f550c == null) {
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(C0044h.design_layout_tab_text, this, false);
                addView(textView);
                this.f550c = textView;
                this.f555h = ci.m3355a(this.f550c);
            }
            this.f550c.setTextAppearance(getContext(), this.f548a.f393h);
            if (this.f548a.f394i != null) {
                this.f550c.setTextColor(this.f548a.f394i);
            }
            m670a(cdVar, this.f550c, this.f551d);
        } else if (this.f553f != null || this.f554g != null) {
            m670a(cdVar, this.f553f, this.f554g);
        }
    }

    public cd m672b() {
        return this.f549b;
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(C0379d.class.getName());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(C0379d.class.getName());
    }

    public boolean onLongClick(View view) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = context.getResources().getDisplayMetrics().widthPixels;
        Toast makeText = Toast.makeText(context, this.f549b.m662f(), 0);
        makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
        makeText.show();
        return true;
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int f = this.f548a.getTabMaxWidth();
        if (f > 0 && (mode == 0 || size > f)) {
            i = MeasureSpec.makeMeasureSpec(this.f548a.f398m, mode);
        }
        super.onMeasure(i, i2);
        if (this.f550c != null) {
            getResources();
            float h = this.f548a.f395j;
            size = this.f555h;
            if (this.f551d != null && this.f551d.getVisibility() == 0) {
                size = 1;
            } else if (this.f550c != null && this.f550c.getLineCount() > 1) {
                h = this.f548a.f396k;
            }
            float textSize = this.f550c.getTextSize();
            int lineCount = this.f550c.getLineCount();
            int a = ci.m3355a(this.f550c);
            if (h != textSize || (a >= 0 && size != a)) {
                if (this.f548a.f404s == 1 && h > textSize && lineCount == 1) {
                    Layout layout = this.f550c.getLayout();
                    if (layout == null || m669a(layout, 0, h) > ((float) layout.getWidth())) {
                        i3 = 0;
                    }
                }
                if (i3 != 0) {
                    this.f550c.setTextSize(0, h);
                    this.f550c.setMaxLines(size);
                    super.onMeasure(i, i2);
                }
            }
        }
    }

    public void setSelected(boolean z) {
        Object obj = isSelected() != z ? 1 : null;
        super.setSelected(z);
        if (obj != null && z) {
            sendAccessibilityEvent(4);
            if (this.f550c != null) {
                this.f550c.setSelected(z);
            }
            if (this.f551d != null) {
                this.f551d.setSelected(z);
            }
        }
    }
}
