package mobi.mmdt.ott.view.components.imageslider;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.v4.view.bt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;
import mobi.mmdt.ott.C1317h;
import mobi.mmdt.ott.view.components.imageslider.Indicators.C1820b;
import mobi.mmdt.ott.view.components.imageslider.Indicators.PagerIndicator;
import mobi.mmdt.ott.view.components.imageslider.Tricks.C1818k;
import mobi.mmdt.ott.view.components.imageslider.Tricks.C1823a;
import mobi.mmdt.ott.view.components.imageslider.Tricks.C1824b;
import mobi.mmdt.ott.view.components.imageslider.Tricks.InfiniteViewPager;
import mobi.mmdt.ott.view.components.imageslider.Tricks.ViewPagerEx;
import mobi.mmdt.ott.view.components.imageslider.p200a.C1837a;
import mobi.mmdt.ott.view.components.imageslider.p201b.C1840a;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1847c;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1848a;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1849b;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1850d;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1851e;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1852f;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1853g;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1854h;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1855i;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1856j;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1857k;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1858l;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1859m;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1860n;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1861o;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1862p;
import mobi.mmdt.ott.view.components.imageslider.p202c.C1863q;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class SliderLayout extends RelativeLayout {
    private InfiniteViewPager f5874a;
    private C1839a f5875b;
    private PagerIndicator f5876c;
    private Timer f5877d;
    private TimerTask f5878e;
    private Timer f5879f;
    private TimerTask f5880g;
    private boolean f5881h;
    private boolean f5882i;
    private boolean f5883j;
    private long f5884k;
    private C1820b f5885l;
    private C1847c f5886m;
    private C1837a f5887n;
    private Handler f5888o;

    public SliderLayout(Context context) {
        this(context, null);
    }

    public SliderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772408);
    }

    public SliderLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.f5882i = true;
        this.f5884k = 4000;
        this.f5885l = C1820b.Visible;
        this.f5888o = new C1864c(this);
        LayoutInflater.from(context).inflate(2130968806, this, true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1317h.SliderLayout, i, 0);
        int integer = obtainStyledAttributes.getInteger(3, 1100);
        int i3 = obtainStyledAttributes.getInt(2, C1869h.Default.ordinal());
        this.f5883j = obtainStyledAttributes.getBoolean(1, true);
        int i4 = obtainStyledAttributes.getInt(0, 0);
        C1820b[] values = C1820b.values();
        int length = values.length;
        while (i2 < length) {
            C1820b c1820b = values[i2];
            if (c1820b.ordinal() == i4) {
                this.f5885l = c1820b;
                break;
            }
            i2++;
        }
        this.f5875b = new C1839a(context);
        bt c1824b = new C1824b(this.f5875b);
        this.f5874a = (InfiniteViewPager) findViewById(2131689947);
        this.f5874a.setAdapter(c1824b);
        this.f5874a.setOnTouchListener(new C1846b(this));
        obtainStyledAttributes.recycle();
        setPresetIndicator(C1868g.Center_Bottom);
        setPresetTransformer(i3);
        m8852a(integer, null);
        setIndicatorVisibility(this.f5885l);
        if (this.f5883j) {
            m8851a();
        }
    }

    private void m8849c() {
        if (this.f5881h) {
            this.f5877d.cancel();
            this.f5878e.cancel();
            this.f5881h = false;
        } else if (this.f5879f != null && this.f5880g != null) {
            m8850d();
        }
    }

    private void m8850d() {
        if (this.f5882i && this.f5883j && !this.f5881h) {
            if (!(this.f5880g == null || this.f5879f == null)) {
                this.f5879f.cancel();
                this.f5880g.cancel();
            }
            this.f5879f = new Timer();
            this.f5880g = new C1866e(this);
            this.f5879f.schedule(this.f5880g, 6000);
        }
    }

    private C1839a getRealAdapter() {
        bt adapter = this.f5874a.getAdapter();
        return adapter != null ? ((C1824b) adapter).m8911d() : null;
    }

    private C1824b getWrapperAdapter() {
        bt adapter = this.f5874a.getAdapter();
        return adapter != null ? (C1824b) adapter : null;
    }

    public void m8851a() {
        m8854a(this.f5884k, this.f5884k, this.f5882i);
    }

    public void m8852a(int i, Interpolator interpolator) {
        try {
            Field declaredField = ViewPagerEx.class.getDeclaredField("m");
            declaredField.setAccessible(true);
            declaredField.set(this.f5874a, new C1823a(this.f5874a.getContext(), interpolator, i));
        } catch (Exception e) {
        }
    }

    public void m8853a(int i, boolean z) {
        if (getRealAdapter() == null) {
            throw new IllegalStateException("You did not set a slider adapter");
        } else if (i >= getRealAdapter().m8935b()) {
            throw new IllegalStateException("Item position is not exist");
        } else {
            this.f5874a.m8888a((i - (this.f5874a.getCurrentItem() % getRealAdapter().m8935b())) + this.f5874a.getCurrentItem(), z);
        }
    }

    public void m8854a(long j, long j2, boolean z) {
        if (this.f5877d != null) {
            this.f5877d.cancel();
        }
        if (this.f5878e != null) {
            this.f5878e.cancel();
        }
        if (this.f5880g != null) {
            this.f5880g.cancel();
        }
        if (this.f5879f != null) {
            this.f5879f.cancel();
        }
        this.f5884k = j2;
        this.f5877d = new Timer();
        this.f5882i = z;
        this.f5878e = new C1865d(this);
        this.f5877d.schedule(this.f5878e, j, this.f5884k);
        this.f5881h = true;
        this.f5883j = true;
    }

    public void m8855a(C1818k c1818k) {
        if (c1818k != null) {
            this.f5874a.m8891a(c1818k);
        }
    }

    public <T extends C1840a> void m8856a(T t) {
        this.f5875b.m8932a((C1840a) t);
    }

    public void m8857a(boolean z) {
        if (getRealAdapter() == null) {
            throw new IllegalStateException("You did not set a slider adapter");
        }
        this.f5874a.m8888a(this.f5874a.getCurrentItem() + 1, z);
    }

    public void m8858a(boolean z, C1847c c1847c) {
        this.f5886m = c1847c;
        this.f5886m.m8956a(this.f5887n);
        this.f5874a.m8892a(z, this.f5886m);
    }

    public void m8859b() {
        if (this.f5878e != null) {
            this.f5878e.cancel();
        }
        if (this.f5877d != null) {
            this.f5877d.cancel();
        }
        if (this.f5879f != null) {
            this.f5879f.cancel();
        }
        if (this.f5880g != null) {
            this.f5880g.cancel();
        }
        this.f5883j = false;
        this.f5881h = false;
    }

    public int getCurrentPosition() {
        if (getRealAdapter() != null) {
            return this.f5874a.getCurrentItem() % getRealAdapter().m8935b();
        }
        throw new IllegalStateException("You did not set a slider adapter");
    }

    public C1840a getCurrentSlider() {
        if (getRealAdapter() == null) {
            throw new IllegalStateException("You did not set a slider adapter");
        }
        return getRealAdapter().m8930a(this.f5874a.getCurrentItem() % getRealAdapter().m8935b());
    }

    public C1820b getIndicatorVisibility() {
        return this.f5876c == null ? this.f5876c.getIndicatorVisibility() : C1820b.Invisible;
    }

    public PagerIndicator getPagerIndicator() {
        return this.f5876c;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case VideoSize.QCIF /*0*/:
                m8849c();
                break;
        }
        return false;
    }

    public void setCurrentPosition(int i) {
        m8853a(i, true);
    }

    public void setCustomAnimation(C1837a c1837a) {
        this.f5887n = c1837a;
        if (this.f5886m != null) {
            this.f5886m.m8956a(this.f5887n);
        }
    }

    public void setCustomIndicator(PagerIndicator pagerIndicator) {
        if (this.f5876c != null) {
            this.f5876c.m8838a();
        }
        this.f5876c = pagerIndicator;
        this.f5876c.setIndicatorVisibility(this.f5885l);
        this.f5876c.setViewPager(this.f5874a);
        this.f5876c.m8843b();
    }

    public void setDuration(long j) {
        if (j >= 500) {
            this.f5884k = j;
            if (this.f5883j && this.f5881h) {
                m8851a();
            }
        }
    }

    public void setIndicatorVisibility(C1820b c1820b) {
        if (this.f5876c != null) {
            this.f5876c.setIndicatorVisibility(c1820b);
        }
    }

    public void setPresetIndicator(C1868g c1868g) {
        setCustomIndicator((PagerIndicator) findViewById(c1868g.m8990a()));
    }

    public void setPresetTransformer(int i) {
        for (C1869h c1869h : C1869h.values()) {
            if (c1869h.ordinal() == i) {
                setPresetTransformer(c1869h);
                return;
            }
        }
    }

    public void setPresetTransformer(String str) {
        for (C1869h c1869h : C1869h.values()) {
            if (c1869h.m8991a(str)) {
                setPresetTransformer(c1869h);
                return;
            }
        }
    }

    public void setPresetTransformer(C1869h c1869h) {
        C1847c c1847c = null;
        switch (C1867f.f5988a[c1869h.ordinal()]) {
            case VideoSize.CIF /*1*/:
                c1847c = new C1851e();
                break;
            case VideoSize.HVGA /*2*/:
                c1847c = new C1848a();
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                c1847c = new C1849b();
                break;
            case Version.API04_DONUT_16 /*4*/:
                c1847c = new C1850d();
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                c1847c = new C1852f();
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                c1847c = new C1853g();
                break;
            case Version.API07_ECLAIR_21 /*7*/:
                c1847c = new C1854h();
                break;
            case Version.API08_FROYO_22 /*8*/:
                c1847c = new C1855i();
                break;
            case Version.API09_GINGERBREAD_23 /*9*/:
                c1847c = new C1856j();
                break;
            case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                c1847c = new C1857k();
                break;
            case Version.API11_HONEYCOMB_30 /*11*/:
                c1847c = new C1858l();
                break;
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
                c1847c = new C1859m();
                break;
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
                c1847c = new C1860n();
                break;
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
                c1847c = new C1861o();
                break;
            case Version.API15_ICE_CREAM_SANDWICH_403 /*15*/:
                c1847c = new C1862p();
                break;
            case Version.API16_JELLY_BEAN_41 /*16*/:
                c1847c = new C1863q();
                break;
        }
        m8858a(true, c1847c);
    }
}
