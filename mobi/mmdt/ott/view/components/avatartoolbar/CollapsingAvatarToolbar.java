package mobi.mmdt.ott.view.components.avatartoolbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.C0083h;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import mobi.mmdt.ott.C1317h;

public class CollapsingAvatarToolbar extends LinearLayout implements C0083h {
    private View f5751a;
    private TextView f5752b;
    private float f5753c;
    private float f5754d;
    private float f5755e;
    private float f5756f;
    private float f5757g;
    private float f5758h;
    private boolean f5759i;
    private Toolbar f5760j;
    private AppBarLayout f5761k;
    private float f5762l;
    private float f5763m;
    private float f5764n;
    private C1782a f5765o;

    public CollapsingAvatarToolbar(Context context) {
        this(context, null);
        m8724a();
    }

    public CollapsingAvatarToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5759i = false;
        m8724a();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1317h.CollapsingAvatarToolbar, 0, 0);
        try {
            this.f5753c = obtainStyledAttributes.getDimension(0, -1.0f);
            this.f5754d = obtainStyledAttributes.getDimension(1, -1.0f);
            this.f5756f = obtainStyledAttributes.getDimension(2, -1.0f);
            this.f5755e = obtainStyledAttributes.getDimension(3, -1.0f);
            this.f5757g = obtainStyledAttributes.getDimension(4, -1.0f);
            this.f5758h = obtainStyledAttributes.getDimension(5, -1.0f);
            Resources resources = getResources();
            if (this.f5753c < 0.0f) {
                this.f5753c = resources.getDimension(2131361897);
            }
            if (this.f5754d < 0.0f) {
                this.f5754d = resources.getDimension(2131361900);
            }
            if (this.f5756f < 0.0f) {
                this.f5756f = resources.getDimension(2131361896);
            }
            if (this.f5755e < 0.0f) {
                this.f5755e = resources.getDimension(2131361899);
            }
            if (this.f5757g < 0.0f) {
                this.f5757g = resources.getDimension(2131361898);
            }
            if (this.f5758h < 0.0f) {
                this.f5758h = resources.getDimension(2131361901);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m8724a() {
        setOrientation(0);
    }

    private void m8725a(float f) {
        if (this.f5765o != null) {
            this.f5765o.m8735a(f);
        }
    }

    private void m8726a(float f, int i) {
        float f2 = 1.0f - f;
        float f3 = (float) (((double) this.f5762l) + (((double) ((this.f5763m - this.f5762l) * f2)) * 1.5d));
        float f4 = (float) (((double) this.f5754d) + (((double) ((this.f5753c - this.f5754d) * f)) * 0.75d));
        setContainerOffset(((float) (-i)) + (((float) this.f5760j.getHeight()) * f2));
        setContainerHeight((int) f3);
        setPadding((int) f4);
        setAvatarSize((int) ((float) ((((double) (f2 * (this.f5755e - this.f5756f))) * 1.5d) + ((double) this.f5756f))));
    }

    private AppBarLayout m8727b() {
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            return (AppBarLayout) parent;
        }
        if (parent.getParent() instanceof AppBarLayout) {
            return (AppBarLayout) parent.getParent();
        }
        throw new IllegalStateException("Must be inside an AppBarLayout");
    }

    private void m8728c() {
        m8733h();
        m8726a(1.0f, 0);
    }

    private void m8729d() {
        this.f5761k = m8727b();
        this.f5760j = m8732g();
        this.f5751a = m8730e();
        this.f5752b = m8731f();
    }

    private View m8730e() {
        View findViewById = findViewById(2131689478);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalStateException("View with id ta_avatar not found");
    }

    private TextView m8731f() {
        TextView textView = (TextView) findViewById(2131689479);
        if (textView != null) {
            return textView;
        }
        throw new IllegalStateException("TextView with id ta_title not found");
    }

    private Toolbar m8732g() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof Toolbar) {
                return (Toolbar) childAt;
            }
        }
        throw new IllegalStateException("No toolbar found as sibling");
    }

    private void m8733h() {
        this.f5762l = (float) this.f5760j.getHeight();
        this.f5763m = (float) (this.f5761k.getHeight() - this.f5760j.getHeight());
        this.f5764n = this.f5763m;
    }

    private void setAvatarSize(int i) {
        this.f5751a.getLayoutParams().height = i;
        this.f5751a.getLayoutParams().width = i;
    }

    private void setContainerHeight(int i) {
        getLayoutParams().height = i;
    }

    private void setContainerOffset(float f) {
        setTranslationY(f);
    }

    private void setPadding(int i) {
        setPadding(i, 0, 0, 0);
    }

    private void setTextSize(float f) {
        this.f5752b.setTextSize(0, f);
    }

    public void m8734a(AppBarLayout appBarLayout, int i) {
        if (!this.f5759i) {
            m8733h();
            this.f5759i = true;
        }
        float f = ((float) (-i)) / this.f5764n;
        m8726a(f, i);
        m8725a(f);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m8729d();
        if (isInEditMode()) {
            m8728c();
        } else {
            this.f5761k.m295a((C0083h) this);
        }
    }

    public void setCollapseChangedListener(C1782a c1782a) {
        this.f5765o = c1782a;
    }
}
