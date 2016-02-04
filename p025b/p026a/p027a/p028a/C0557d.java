package p025b.p026a.p027a.p028a;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;
import org.apache.http.myHttp.HttpStatus;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import p025b.p026a.p027a.p028a.p029a.C0540e;
import p025b.p026a.p027a.p028a.p029a.C0545f;
import p025b.p026a.p027a.p028a.p029a.C0546g;
import p025b.p026a.p027a.p028a.p030b.C0548a;

/* renamed from: b.a.a.a.d */
public class C0557d implements OnTouchListener, OnGlobalLayoutListener, C0545f, C0556c {
    static final Interpolator f2300a;
    private static final boolean f2301c;
    private int f2302A;
    private boolean f2303B;
    private ScaleType f2304C;
    int f2305b;
    private float f2306d;
    private float f2307e;
    private float f2308f;
    private boolean f2309g;
    private boolean f2310h;
    private WeakReference<ImageView> f2311i;
    private GestureDetector f2312j;
    private C0540e f2313k;
    private final Matrix f2314l;
    private final Matrix f2315m;
    private final Matrix f2316n;
    private final RectF f2317o;
    private final float[] f2318p;
    private C0562i f2319q;
    private C0563j f2320r;
    private C0565l f2321s;
    private OnLongClickListener f2322t;
    private C0564k f2323u;
    private int f2324v;
    private int f2325w;
    private int f2326x;
    private int f2327y;
    private C0561h f2328z;

    static {
        f2301c = Log.isLoggable("PhotoViewAttacher", 3);
        f2300a = new AccelerateDecelerateInterpolator();
    }

    public C0557d(ImageView imageView) {
        this(imageView, true);
    }

    public C0557d(ImageView imageView, boolean z) {
        this.f2305b = HttpStatus.SC_OK;
        this.f2306d = 1.0f;
        this.f2307e = 1.75f;
        this.f2308f = 3.0f;
        this.f2309g = true;
        this.f2310h = false;
        this.f2314l = new Matrix();
        this.f2315m = new Matrix();
        this.f2316n = new Matrix();
        this.f2317o = new RectF();
        this.f2318p = new float[9];
        this.f2302A = 2;
        this.f2304C = ScaleType.FIT_CENTER;
        this.f2311i = new WeakReference(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        C0557d.m4194b(imageView);
        if (!imageView.isInEditMode()) {
            this.f2313k = C0546g.m4153a(imageView.getContext(), this);
            this.f2312j = new GestureDetector(imageView.getContext(), new C0558e(this));
            this.f2312j.setOnDoubleTapListener(new C0551b(this));
            m4209a(z);
        }
    }

    private float m4185a(Matrix matrix, int i) {
        matrix.getValues(this.f2318p);
        return this.f2318p[i];
    }

    private RectF m4186a(Matrix matrix) {
        ImageView c = m4211c();
        if (c != null) {
            Drawable drawable = c.getDrawable();
            if (drawable != null) {
                this.f2317o.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
                matrix.mapRect(this.f2317o);
                return this.f2317o;
            }
        }
        return null;
    }

    private void m4188a(Drawable drawable) {
        ImageView c = m4211c();
        if (c != null && drawable != null) {
            float c2 = (float) m4195c(c);
            float d = (float) m4196d(c);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.f2314l.reset();
            float f = c2 / ((float) intrinsicWidth);
            float f2 = d / ((float) intrinsicHeight);
            if (this.f2304C != ScaleType.CENTER) {
                if (this.f2304C != ScaleType.CENTER_CROP) {
                    if (this.f2304C != ScaleType.CENTER_INSIDE) {
                        RectF rectF = new RectF(0.0f, 0.0f, (float) intrinsicWidth, (float) intrinsicHeight);
                        RectF rectF2 = new RectF(0.0f, 0.0f, c2, d);
                        switch (C0559f.f2330a[this.f2304C.ordinal()]) {
                            case VideoSize.HVGA /*2*/:
                                this.f2314l.setRectToRect(rectF, rectF2, ScaleToFit.START);
                                break;
                            case Version.API03_CUPCAKE_15 /*3*/:
                                this.f2314l.setRectToRect(rectF, rectF2, ScaleToFit.END);
                                break;
                            case Version.API04_DONUT_16 /*4*/:
                                this.f2314l.setRectToRect(rectF, rectF2, ScaleToFit.CENTER);
                                break;
                            case Version.API05_ECLAIR_20 /*5*/:
                                this.f2314l.setRectToRect(rectF, rectF2, ScaleToFit.FILL);
                                break;
                            default:
                                break;
                        }
                    }
                    f = Math.min(1.0f, Math.min(f, f2));
                    this.f2314l.postScale(f, f);
                    this.f2314l.postTranslate((c2 - (((float) intrinsicWidth) * f)) / 2.0f, (d - (((float) intrinsicHeight) * f)) / 2.0f);
                } else {
                    f = Math.max(f, f2);
                    this.f2314l.postScale(f, f);
                    this.f2314l.postTranslate((c2 - (((float) intrinsicWidth) * f)) / 2.0f, (d - (((float) intrinsicHeight) * f)) / 2.0f);
                }
            } else {
                this.f2314l.postTranslate((c2 - ((float) intrinsicWidth)) / 2.0f, (d - ((float) intrinsicHeight)) / 2.0f);
            }
            m4202q();
        }
    }

    private static boolean m4190a(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private static void m4192b(float f, float f2, float f3) {
        if (f >= f2) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        } else if (f2 >= f3) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    private void m4193b(Matrix matrix) {
        ImageView c = m4211c();
        if (c != null) {
            m4200o();
            c.setImageMatrix(matrix);
            if (this.f2319q != null) {
                RectF a = m4186a(matrix);
                if (a != null) {
                    this.f2319q.m4223a(a);
                }
            }
        }
    }

    private static void m4194b(ImageView imageView) {
        if (imageView != null && !(imageView instanceof C0556c) && !ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ScaleType.MATRIX);
        }
    }

    private int m4195c(ImageView imageView) {
        return imageView == null ? 0 : (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private int m4196d(ImageView imageView) {
        return imageView == null ? 0 : (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private void m4198m() {
        if (this.f2328z != null) {
            this.f2328z.m4221a();
            this.f2328z = null;
        }
    }

    private void m4199n() {
        if (m4201p()) {
            m4193b(m4219k());
        }
    }

    private void m4200o() {
        ImageView c = m4211c();
        if (c != null && !(c instanceof C0556c) && !ScaleType.MATRIX.equals(c.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean m4201p() {
        float f = 0.0f;
        ImageView c = m4211c();
        if (c == null) {
            return false;
        }
        RectF a = m4186a(m4219k());
        if (a == null) {
            return false;
        }
        float height = a.height();
        float width = a.width();
        int d = m4196d(c);
        if (height <= ((float) d)) {
            switch (C0559f.f2330a[this.f2304C.ordinal()]) {
                case VideoSize.HVGA /*2*/:
                    height = -a.top;
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    height = (((float) d) - height) - a.top;
                    break;
                default:
                    height = ((((float) d) - height) / 2.0f) - a.top;
                    break;
            }
        }
        height = a.top > 0.0f ? -a.top : a.bottom < ((float) d) ? ((float) d) - a.bottom : 0.0f;
        int c2 = m4195c(c);
        if (width <= ((float) c2)) {
            switch (C0559f.f2330a[this.f2304C.ordinal()]) {
                case VideoSize.HVGA /*2*/:
                    f = -a.left;
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    f = (((float) c2) - width) - a.left;
                    break;
                default:
                    f = ((((float) c2) - width) / 2.0f) - a.left;
                    break;
            }
            this.f2302A = 2;
        } else if (a.left > 0.0f) {
            this.f2302A = 0;
            f = -a.left;
        } else if (a.right < ((float) c2)) {
            f = ((float) c2) - a.right;
            this.f2302A = 1;
        } else {
            this.f2302A = -1;
        }
        this.f2316n.postTranslate(f, height);
        return true;
    }

    private void m4202q() {
        this.f2316n.reset();
        m4193b(m4219k());
        m4201p();
    }

    public void m4203a() {
        if (this.f2311i != null) {
            ImageView imageView = (ImageView) this.f2311i.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                m4198m();
            }
            if (this.f2312j != null) {
                this.f2312j.setOnDoubleTapListener(null);
            }
            this.f2319q = null;
            this.f2320r = null;
            this.f2321s = null;
            this.f2311i = null;
        }
    }

    public void m4204a(float f) {
        C0557d.m4192b(this.f2306d, this.f2307e, f);
        this.f2308f = f;
    }

    public void m4205a(float f, float f2) {
        if (!this.f2313k.m4136a()) {
            if (f2301c) {
                C0548a.m4159a().m4160a("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[]{Float.valueOf(f), Float.valueOf(f2)}));
            }
            ImageView c = m4211c();
            this.f2316n.postTranslate(f, f2);
            m4199n();
            ViewParent parent = c.getParent();
            if (!this.f2309g || this.f2313k.m4136a() || this.f2310h) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((this.f2302A == 2 || ((this.f2302A == 0 && f >= 1.0f) || (this.f2302A == 1 && f <= -1.0f))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }
    }

    public void m4206a(float f, float f2, float f3) {
        if (f2301c) {
            C0548a.m4159a().m4160a("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}));
        }
        if (m4215g() < this.f2308f || f < 1.0f) {
            if (this.f2323u != null) {
                this.f2323u.m4225a(f, f2, f3);
            }
            this.f2316n.postScale(f, f, f2, f3);
            m4199n();
        }
    }

    public void m4207a(float f, float f2, float f3, float f4) {
        if (f2301c) {
            C0548a.m4159a().m4160a("PhotoViewAttacher", "onFling. sX: " + f + " sY: " + f2 + " Vx: " + f3 + " Vy: " + f4);
        }
        ImageView c = m4211c();
        this.f2328z = new C0561h(this, c.getContext());
        this.f2328z.m4222a(m4195c(c), m4196d(c), (int) f3, (int) f4);
        c.post(this.f2328z);
    }

    public void m4208a(float f, float f2, float f3, boolean z) {
        ImageView c = m4211c();
        if (c == null) {
            return;
        }
        if (f < this.f2306d || f > this.f2308f) {
            C0548a.m4159a().m4161b("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
        } else if (z) {
            c.post(new C0560g(this, m4215g(), f, f2, f3));
        } else {
            this.f2316n.setScale(f, f, f2, f3);
            m4199n();
        }
    }

    public void m4209a(boolean z) {
        this.f2303B = z;
        m4218j();
    }

    public RectF m4210b() {
        m4201p();
        return m4186a(m4219k());
    }

    public ImageView m4211c() {
        ImageView imageView = null;
        if (this.f2311i != null) {
            imageView = (ImageView) this.f2311i.get();
        }
        if (imageView == null) {
            m4203a();
            C0548a.m4159a().m4161b("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float m4212d() {
        return this.f2306d;
    }

    public float m4213e() {
        return this.f2307e;
    }

    public float m4214f() {
        return this.f2308f;
    }

    public float m4215g() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) m4185a(this.f2316n, 0), 2.0d)) + ((float) Math.pow((double) m4185a(this.f2316n, 3), 2.0d))));
    }

    public C0563j m4216h() {
        return this.f2320r;
    }

    public C0565l m4217i() {
        return this.f2321s;
    }

    public void m4218j() {
        ImageView c = m4211c();
        if (c == null) {
            return;
        }
        if (this.f2303B) {
            C0557d.m4194b(c);
            m4188a(c.getDrawable());
            return;
        }
        m4202q();
    }

    public Matrix m4219k() {
        this.f2315m.set(this.f2314l);
        this.f2315m.postConcat(this.f2316n);
        return this.f2315m;
    }

    public void onGlobalLayout() {
        ImageView c = m4211c();
        if (c == null) {
            return;
        }
        if (this.f2303B) {
            int top = c.getTop();
            int right = c.getRight();
            int bottom = c.getBottom();
            int left = c.getLeft();
            if (top != this.f2324v || bottom != this.f2326x || left != this.f2327y || right != this.f2325w) {
                m4188a(c.getDrawable());
                this.f2324v = top;
                this.f2325w = right;
                this.f2326x = bottom;
                this.f2327y = left;
                return;
            }
            return;
        }
        m4188a(c.getDrawable());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
        r8 = this;
        r6 = 0;
        r7 = 1;
        r0 = r8.f2303B;
        if (r0 == 0) goto L_0x009f;
    L_0x0006:
        r0 = r9;
        r0 = (android.widget.ImageView) r0;
        r0 = p025b.p026a.p027a.p028a.C0557d.m4190a(r0);
        if (r0 == 0) goto L_0x009f;
    L_0x000f:
        r0 = r9.getParent();
        r1 = r10.getAction();
        switch(r1) {
            case 0: goto L_0x005c;
            case 1: goto L_0x0072;
            case 2: goto L_0x001a;
            case 3: goto L_0x0072;
            default: goto L_0x001a;
        };
    L_0x001a:
        r0 = r6;
    L_0x001b:
        r1 = r8.f2313k;
        if (r1 == 0) goto L_0x004e;
    L_0x001f:
        r0 = r8.f2313k;
        r1 = r0.m4136a();
        r0 = r8.f2313k;
        r3 = r0.m4137b();
        r0 = r8.f2313k;
        r0 = r0.m4138c(r10);
        if (r1 != 0) goto L_0x009b;
    L_0x0033:
        r1 = r8.f2313k;
        r1 = r1.m4136a();
        if (r1 != 0) goto L_0x009b;
    L_0x003b:
        r2 = r7;
    L_0x003c:
        if (r3 != 0) goto L_0x009d;
    L_0x003e:
        r1 = r8.f2313k;
        r1 = r1.m4137b();
        if (r1 != 0) goto L_0x009d;
    L_0x0046:
        r1 = r7;
    L_0x0047:
        if (r2 == 0) goto L_0x004c;
    L_0x0049:
        if (r1 == 0) goto L_0x004c;
    L_0x004b:
        r6 = r7;
    L_0x004c:
        r8.f2310h = r6;
    L_0x004e:
        r1 = r8.f2312j;
        if (r1 == 0) goto L_0x005b;
    L_0x0052:
        r1 = r8.f2312j;
        r1 = r1.onTouchEvent(r10);
        if (r1 == 0) goto L_0x005b;
    L_0x005a:
        r0 = r7;
    L_0x005b:
        return r0;
    L_0x005c:
        if (r0 == 0) goto L_0x0066;
    L_0x005e:
        r0.requestDisallowInterceptTouchEvent(r7);
    L_0x0061:
        r8.m4198m();
        r0 = r6;
        goto L_0x001b;
    L_0x0066:
        r0 = p025b.p026a.p027a.p028a.p030b.C0548a.m4159a();
        r1 = "PhotoViewAttacher";
        r2 = "onTouch getParent() returned null";
        r0.m4161b(r1, r2);
        goto L_0x0061;
    L_0x0072:
        r0 = r8.m4215g();
        r1 = r8.f2306d;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x001a;
    L_0x007c:
        r1 = r8.m4210b();
        if (r1 == 0) goto L_0x001a;
    L_0x0082:
        r0 = new b.a.a.a.g;
        r2 = r8.m4215g();
        r3 = r8.f2306d;
        r4 = r1.centerX();
        r5 = r1.centerY();
        r1 = r8;
        r0.<init>(r1, r2, r3, r4, r5);
        r9.post(r0);
        r0 = r7;
        goto L_0x001b;
    L_0x009b:
        r2 = r6;
        goto L_0x003c;
    L_0x009d:
        r1 = r6;
        goto L_0x0047;
    L_0x009f:
        r0 = r6;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.a.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
