package mobi.mmdt.ott.view.conversation.emojisticker.viewpagerindicator;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.ViewPager;
import android.support.v4.view.dz;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.p032a.p033a.C0872i;
import mobi.mmdt.componentsutils.p079a.C1111c;

public class IconPageIndicator extends HorizontalScrollView implements C2230g {
    private final LinearLayout f7336a;
    private ViewPager f7337b;
    private dz f7338c;
    private Runnable f7339d;
    private int f7340e;
    private int f7341f;
    private LayoutInflater f7342g;

    public IconPageIndicator(Context context) {
        this(context, null);
    }

    public IconPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setHorizontalScrollBarEnabled(false);
        this.f7342g = LayoutInflater.from(getContext());
        this.f7336a = new LinearLayout(context);
        addView(this.f7336a, new LayoutParams(-1, -1, 3));
        Point f = C1111c.m6414f(context);
        if (context.getResources().getConfiguration().orientation == 1) {
            this.f7341f = f.x / 8;
        } else {
            this.f7341f = f.x / 8;
        }
    }

    private void m10126c(int i) {
        View childAt = this.f7336a.getChildAt(i);
        if (this.f7339d != null) {
            removeCallbacks(this.f7339d);
        }
        this.f7339d = new C2234d(this, childAt);
        post(this.f7339d);
    }

    public void m10127a() {
        this.f7336a.removeAllViews();
        C2219f c2219f = (C2219f) this.f7337b.getAdapter();
        int b = c2219f.m10093b();
        for (int i = 0; i < b; i++) {
            C2231a a = c2219f.m10092a(i);
            View inflate = this.f7342g.inflate(2130968820, null, false);
            ImageView imageView = (ImageButton) inflate.findViewById(2131689960);
            inflate.findViewById(2131689959).getLayoutParams().width = this.f7341f;
            imageView.getLayoutParams().width = this.f7341f;
            if (a.m10132b() == 1) {
                imageView.setImageResource(((C2232b) a).m10133c());
            } else {
                C0872i.m5270b(getContext()).m5329a(((C2233c) a).m10135c()).m4406a(0.25f).m4417a(imageView);
            }
            imageView.setOnClickListener(new C2235e(this, a));
            this.f7336a.addView(inflate);
        }
        if (this.f7340e > b) {
            this.f7340e = b - 1;
        }
        setCurrentItem(this.f7340e);
        requestLayout();
    }

    public void m10128a(int i) {
        if (this.f7338c != null) {
            this.f7338c.m663a(i);
        }
    }

    public void m10129a(int i, float f, int i2) {
        if (this.f7338c != null) {
            this.f7338c.m664a(i, f, i2);
        }
    }

    public void m10130b(int i) {
        setCurrentItem(i);
        if (this.f7338c != null) {
            this.f7338c.m665b(i);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f7339d != null) {
            post(this.f7339d);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f7339d != null) {
            removeCallbacks(this.f7339d);
        }
    }

    public void setCurrentItem(int i) {
        if (this.f7337b == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f7340e = i;
        this.f7337b.setCurrentItem(i);
        int childCount = this.f7336a.getChildCount();
        C2219f c2219f = (C2219f) this.f7337b.getAdapter();
        for (int i2 = 0; i2 < childCount; i2++) {
            int i3;
            View childAt = this.f7336a.getChildAt(i2);
            C2231a a = c2219f.m10092a(i2);
            View findViewById = childAt.findViewById(2131689959);
            ImageView imageView = (ImageButton) childAt.findViewById(2131689960);
            if (i2 == i) {
                findViewById.setVisibility(0);
                if (a.m10132b() == 1) {
                    imageView.setImageResource(((C2232b) a).m10134d());
                    i3 = 1;
                } else {
                    C0872i.m5270b(getContext()).m5329a(((C2233c) a).m10136d()).m4406a(0.25f).m4417a(imageView);
                    i3 = 1;
                }
            } else {
                findViewById.setVisibility(8);
                if (a.m10132b() == 1) {
                    imageView.setImageResource(((C2232b) a).m10133c());
                    i3 = 0;
                } else {
                    C0872i.m5270b(getContext()).m5329a(((C2233c) a).m10135c()).m4406a(0.25f).m4417a(imageView);
                    i3 = 0;
                }
            }
            if (i3 != 0) {
                m10126c(i);
            }
        }
    }

    public void setOnPageChangeListener(dz dzVar) {
        this.f7338c = dzVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f7337b != viewPager) {
            if (this.f7337b != null) {
                this.f7337b.m1852a((dz) this);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f7337b = viewPager;
            viewPager.m1852a((dz) this);
            m10127a();
        }
    }
}
