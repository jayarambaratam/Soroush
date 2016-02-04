package at.grabner.circleprogress;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import net.frakbot.glowpadbackport.BuildConfig;

public class CircleProgressView extends View {
    private int f2215A;
    private int f2216B;
    private int[] f2217C;
    private Cap f2218D;
    private Cap f2219E;
    private Paint f2220F;
    private Paint f2221G;
    private Paint f2222H;
    private Paint f2223I;
    private Paint f2224J;
    private Paint f2225K;
    private Paint f2226L;
    private RectF f2227M;
    private RectF f2228N;
    private RectF f2229O;
    private RectF f2230P;
    private RectF f2231Q;
    private RectF f2232R;
    private float f2233S;
    private double f2234T;
    private int f2235U;
    private boolean f2236V;
    private Handler f2237W;
    private float f2238a;
    private C0537d aa;
    private TimeInterpolator ab;
    private String ac;
    private String ad;
    private int ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private float aj;
    private float f2239b;
    private float f2240c;
    private float f2241d;
    private float f2242e;
    private float f2243f;
    private float f2244g;
    private int f2245h;
    private int f2246i;
    private int f2247j;
    private int f2248k;
    private int f2249l;
    private int f2250m;
    private int f2251n;
    private float f2252o;
    private float f2253p;
    private float f2254q;
    private int f2255r;
    private int f2256s;
    private int f2257t;
    private int f2258u;
    private final int f2259v;
    private int f2260w;
    private int f2261x;
    private int f2262y;
    private int f2263z;

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2238a = 15.0f;
        this.f2239b = 0.0f;
        this.f2240c = 0.0f;
        this.f2241d = 100.0f;
        this.f2242e = 0.0f;
        this.f2243f = 42.0f;
        this.f2244g = 0.0f;
        this.f2245h = 0;
        this.f2246i = 0;
        this.f2247j = 100;
        this.f2248k = 80;
        this.f2249l = 40;
        this.f2250m = 40;
        this.f2251n = 20;
        this.f2252o = 1.0f;
        this.f2253p = 1.0f;
        this.f2254q = 1.0f;
        this.f2255r = 0;
        this.f2256s = 0;
        this.f2257t = 0;
        this.f2258u = 0;
        this.f2259v = -16738680;
        this.f2260w = -1442840576;
        this.f2261x = -16738680;
        this.f2262y = 0;
        this.f2263z = -1434201911;
        this.f2215A = -16777216;
        this.f2216B = -16777216;
        this.f2217C = new int[]{-16738680, -16738680};
        this.f2218D = Cap.BUTT;
        this.f2219E = Cap.BUTT;
        this.f2220F = new Paint();
        this.f2221G = new Paint();
        this.f2222H = new Paint();
        this.f2223I = new Paint();
        this.f2224J = new Paint();
        this.f2225K = new Paint();
        this.f2226L = new Paint();
        this.f2227M = new RectF();
        this.f2228N = new RectF();
        this.f2229O = new RectF();
        this.f2230P = new RectF();
        this.f2231Q = new RectF();
        this.f2232R = new RectF();
        this.f2233S = 2.8f;
        this.f2234T = 900.0d;
        this.f2235U = 15;
        this.f2237W = new C0535b(this);
        this.aa = C0537d.IDLE;
        this.ab = new AccelerateDecelerateInterpolator();
        this.ac = BuildConfig.FLAVOR;
        this.ad = BuildConfig.FLAVOR;
        this.ah = true;
        this.ai = false;
        this.aj = 0.3f;
        m4099a(context.obtainStyledAttributes(attributeSet, C0539f.CircleProgressView));
    }

    private static float m4095a(String str, Paint paint, RectF rectF) {
        Matrix matrix = new Matrix();
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        matrix.setRectToRect(new RectF(rect), rectF, ScaleToFit.CENTER);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return paint.getTextSize() * fArr[0];
    }

    private RectF m4096a(RectF rectF) {
        float f;
        float f2 = 1.0f;
        float width = (rectF.width() - ((float) ((((double) ((rectF.width() - ((float) Math.max(this.f2249l, this.f2250m))) - (this.f2252o * 2.0f))) / 2.0d) * Math.sqrt(2.0d)))) / 2.0f;
        if (m4126a()) {
            f = 0.77f;
            f2 = 1.33f;
        } else {
            f = 1.0f;
        }
        return new RectF(rectF.left + (width * f), rectF.top + (width * f2), rectF.right - (f * width), rectF.bottom - (f2 * width));
    }

    private void m4099a(TypedArray typedArray) {
        setBarWidth((int) typedArray.getDimension(C0539f.CircleProgressView_barWidth, (float) this.f2249l));
        setRimWidth((int) typedArray.getDimension(C0539f.CircleProgressView_rimWidth, (float) this.f2250m));
        setSpinSpeed((float) ((int) typedArray.getDimension(C0539f.CircleProgressView_spinSpeed, this.f2233S)));
        if (typedArray.hasValue(C0539f.CircleProgressView_barColor) && typedArray.hasValue(C0539f.CircleProgressView_barColor1) && typedArray.hasValue(C0539f.CircleProgressView_barColor2) && typedArray.hasValue(C0539f.CircleProgressView_barColor3)) {
            this.f2217C = new int[]{typedArray.getColor(C0539f.CircleProgressView_barColor, -16738680), typedArray.getColor(C0539f.CircleProgressView_barColor1, -16738680), typedArray.getColor(C0539f.CircleProgressView_barColor2, -16738680), typedArray.getColor(C0539f.CircleProgressView_barColor3, -16738680)};
        } else if (typedArray.hasValue(C0539f.CircleProgressView_barColor) && typedArray.hasValue(C0539f.CircleProgressView_barColor1) && typedArray.hasValue(C0539f.CircleProgressView_barColor2)) {
            this.f2217C = new int[]{typedArray.getColor(C0539f.CircleProgressView_barColor, -16738680), typedArray.getColor(C0539f.CircleProgressView_barColor1, -16738680), typedArray.getColor(C0539f.CircleProgressView_barColor2, -16738680)};
        } else if (typedArray.hasValue(C0539f.CircleProgressView_barColor) && typedArray.hasValue(C0539f.CircleProgressView_barColor1)) {
            this.f2217C = new int[]{typedArray.getColor(C0539f.CircleProgressView_barColor, -16738680), typedArray.getColor(C0539f.CircleProgressView_barColor1, -16738680)};
        } else {
            this.f2217C = new int[]{typedArray.getColor(C0539f.CircleProgressView_barColor, -16738680), typedArray.getColor(C0539f.CircleProgressView_barColor, -16738680)};
        }
        setSpinBarColor(typedArray.getColor(C0539f.CircleProgressView_spinColor, this.f2261x));
        float dimension = typedArray.getDimension(C0539f.CircleProgressView_spinBarLength, this.f2243f);
        this.f2243f = dimension;
        setSpinningBarLength(dimension);
        setTextSize((int) typedArray.getDimension(C0539f.CircleProgressView_textSize, -1.0f));
        setTextColor(typedArray.getColor(C0539f.CircleProgressView_textColor, -1));
        setUnitColor(typedArray.getColor(C0539f.CircleProgressView_unitColor, -1));
        setText(typedArray.getString(C0539f.CircleProgressView_text));
        setRimColor(typedArray.getColor(C0539f.CircleProgressView_rimColor, this.f2263z));
        setFillColor(typedArray.getColor(C0539f.CircleProgressView_fillColor, this.f2262y));
        setContourColor(typedArray.getColor(C0539f.CircleProgressView_contourColor, this.f2260w));
        setContourSize(typedArray.getDimension(C0539f.CircleProgressView_contourSize, this.f2252o));
        setMaxValue(typedArray.getDimension(C0539f.CircleProgressView_maxValue, this.f2241d));
        setUnit(typedArray.getString(C0539f.CircleProgressView_unit));
        setShowUnit(typedArray.getBoolean(C0539f.CircleProgressView_showUnit, this.ai));
        setTextScale(typedArray.getDimension(C0539f.CircleProgressView_textScale, this.f2253p));
        setUnitScale(typedArray.getDimension(C0539f.CircleProgressView_unitScale, this.f2254q));
        typedArray.recycle();
    }

    private void m4100a(Canvas canvas) {
        if (this.f2242e < 0.0f) {
            this.f2242e = 1.0f;
        }
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f2227M, (this.f2244g - 90.0f) - this.f2242e, this.f2242e, false, this.f2221G);
    }

    private void m4101a(Canvas canvas, float f) {
        boolean z = false;
        canvas.drawArc(this.f2227M, -90.0f, f, false, this.f2220F);
        this.f2224J.setSubpixelText(true);
        this.f2224J.setLinearText(true);
        this.f2224J.setTypeface(Typeface.MONOSPACE);
        if (this.f2215A == -1) {
            this.f2224J.setColor(m4124a((double) this.f2238a));
        }
        String str = this.ac;
        if (this.af) {
            str = this.ah ? String.valueOf((int) ((100.0f / this.f2241d) * this.f2238a)) : String.valueOf((int) this.f2238a);
        }
        if (!this.ag) {
            this.f2229O = m4105b(str, this.f2224J, this.f2227M);
        } else if (this.ae != str.length()) {
            this.ae = str.length();
            if (this.ae == 1) {
                this.f2228N = new RectF(this.f2228N.left + (this.f2228N.width() * 0.1f), this.f2228N.top, this.f2228N.right - (this.f2228N.width() * 0.1f), this.f2228N.bottom);
            } else {
                this.f2228N = m4096a(this.f2227M);
            }
            RectF rectF = this.f2228N;
            if (this.ai) {
                rectF = new RectF(this.f2228N.left, this.f2228N.top, this.f2228N.right - ((this.f2228N.width() * this.aj) * 1.03f), this.f2228N.bottom);
            }
            this.f2224J.setTextSize(m4095a(str, this.f2224J, rectF) * this.f2253p);
            this.f2229O = m4105b(str, this.f2224J, rectF);
            z = true;
        }
        canvas.drawText(str, this.f2229O.left - (this.f2224J.getTextSize() * 0.09f), this.f2229O.bottom, this.f2224J);
        if (this.ai) {
            if (this.f2216B == -1) {
                this.f2225K.setColor(m4124a((double) this.f2238a));
            }
            if (z) {
                this.f2230P = new RectF(this.f2228N.left + ((this.f2228N.width() * (1.0f - this.aj)) * 1.03f), this.f2228N.top, this.f2228N.right, this.f2228N.bottom);
                this.f2225K.setTextSize(m4095a(this.ad, this.f2225K, this.f2230P) * this.f2254q);
                this.f2230P = m4105b(this.ad, this.f2225K, this.f2230P);
                this.f2230P.offset(0.0f, this.f2229O.top - this.f2230P.top);
            }
            canvas.drawText(this.ad, this.f2230P.left, this.f2230P.bottom, this.f2225K);
        }
    }

    static /* synthetic */ float m4104b(CircleProgressView circleProgressView, float f) {
        float f2 = circleProgressView.f2244g + f;
        circleProgressView.f2244g = f2;
        return f2;
    }

    private RectF m4105b(String str, Paint paint, RectF rectF) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        RectF rectF2 = new RectF();
        rectF2.left = rectF.left + ((rectF.width() - ((float) rect.width())) / 2.0f);
        rectF2.top = rectF.top + ((rectF.height() - ((float) rect.height())) / 2.0f);
        rectF2.right = rectF2.left + ((float) rect.width());
        rectF2.bottom = ((float) rect.height()) + rectF2.top;
        return rectF2;
    }

    private void m4108c() {
        int min = Math.min(this.f2246i, this.f2245h);
        int i = this.f2246i - min;
        min = this.f2245h - min;
        min = getWidth();
        this.f2227M = new RectF((float) (this.f2257t + (this.f2249l / 2)), (float) (this.f2255r + (this.f2249l / 2)), (float) ((min - this.f2258u) - (this.f2249l / 2)), (float) ((getHeight() - this.f2256s) - (this.f2249l / 2)));
        this.f2228N = m4096a(this.f2227M);
        this.f2232R = new RectF((this.f2227M.left + (((float) this.f2250m) / 2.0f)) + (this.f2252o / 2.0f), (this.f2227M.top + (((float) this.f2250m) / 2.0f)) + (this.f2252o / 2.0f), (this.f2227M.right - (((float) this.f2250m) / 2.0f)) - (this.f2252o / 2.0f), (this.f2227M.bottom - (((float) this.f2250m) / 2.0f)) - (this.f2252o / 2.0f));
        this.f2231Q = new RectF((this.f2227M.left - (((float) this.f2250m) / 2.0f)) - (this.f2252o / 2.0f), (this.f2227M.top - (((float) this.f2250m) / 2.0f)) - (this.f2252o / 2.0f), (this.f2227M.right + (((float) this.f2250m) / 2.0f)) + (this.f2252o / 2.0f), (this.f2227M.bottom + (((float) this.f2250m) / 2.0f)) + (this.f2252o / 2.0f));
        this.f2247j = ((min - this.f2258u) - this.f2249l) / 2;
        this.f2248k = (this.f2247j - this.f2249l) + 1;
    }

    static /* synthetic */ float m4113f(CircleProgressView circleProgressView, float f) {
        float f2 = circleProgressView.f2242e - f;
        circleProgressView.f2242e = f2;
        return f2;
    }

    public int m4124a(double d) {
        int maxValue = (int) (((1.0d / getMaxValue()) * d) * ((double) this.f2217C.length));
        int[] iArr = this.f2217C;
        if (maxValue >= this.f2217C.length) {
            maxValue = this.f2217C.length - 1;
        }
        return iArr[maxValue];
    }

    public void m4125a(float f, long j) {
        this.f2234T = (double) j;
        Message message = new Message();
        message.what = C0536c.SET_VALUE_ANIMATED.ordinal();
        message.obj = new float[]{this.f2238a, f};
        this.f2237W.sendMessage(message);
    }

    public boolean m4126a() {
        return this.ai;
    }

    public void m4127b() {
        this.f2220F.setShader(new SweepGradient(this.f2227M.centerX(), this.f2227M.centerY(), this.f2217C, null));
        Matrix matrix = new Matrix();
        this.f2220F.getShader().getLocalMatrix(matrix);
        matrix.postTranslate(-this.f2227M.centerX(), -this.f2227M.centerY());
        matrix.postRotate(-90.0f);
        matrix.postTranslate(this.f2227M.centerX(), this.f2227M.centerY());
        this.f2220F.getShader().setLocalMatrix(matrix);
        this.f2220F.setAntiAlias(true);
        this.f2220F.setStrokeCap(this.f2218D);
        this.f2220F.setStyle(Style.STROKE);
        this.f2220F.setStrokeWidth((float) this.f2249l);
        this.f2221G.setAntiAlias(true);
        this.f2221G.setStrokeCap(this.f2219E);
        this.f2221G.setStyle(Style.STROKE);
        this.f2221G.setStrokeWidth((float) this.f2249l);
        this.f2221G.setColor(this.f2261x);
        this.f2223I.setColor(this.f2263z);
        this.f2223I.setAntiAlias(true);
        this.f2223I.setStyle(Style.STROKE);
        this.f2223I.setStrokeWidth((float) this.f2250m);
        this.f2222H.setColor(this.f2262y);
        this.f2222H.setAntiAlias(true);
        this.f2222H.setStyle(Style.FILL);
        this.f2224J.setColor(this.f2215A);
        this.f2224J.setStyle(Style.FILL);
        this.f2224J.setAntiAlias(true);
        this.f2224J.setTextSize((float) getTextSize());
        this.f2225K.setColor(this.f2216B);
        this.f2225K.setStyle(Style.FILL);
        this.f2225K.setAntiAlias(true);
        this.f2225K.setTextSize((float) getTextSize());
        this.f2226L.setColor(this.f2260w);
        this.f2226L.setAntiAlias(true);
        this.f2226L.setStyle(Style.STROKE);
        this.f2226L.setStrokeWidth(this.f2252o);
    }

    public int[] getBarColors() {
        return this.f2217C;
    }

    public Cap getBarStrokeCap() {
        return this.f2218D;
    }

    public int getBarWidth() {
        return this.f2249l;
    }

    public int getCircleRadius() {
        return this.f2248k;
    }

    public int getContourColor() {
        return this.f2260w;
    }

    public float getContourSize() {
        return this.f2252o;
    }

    public int getDelayMillis() {
        return this.f2235U;
    }

    public int getFillColor() {
        return this.f2262y;
    }

    public double getMaxValue() {
        return (double) this.f2241d;
    }

    public int getPaddingBottom() {
        return this.f2256s;
    }

    public int getPaddingLeft() {
        return this.f2257t;
    }

    public int getPaddingRight() {
        return this.f2258u;
    }

    public int getPaddingTop() {
        return this.f2255r;
    }

    public int getRimColor() {
        return this.f2263z;
    }

    public Shader getRimShader() {
        return this.f2223I.getShader();
    }

    public int getRimWidth() {
        return this.f2250m;
    }

    public float getSpinSpeed() {
        return this.f2233S;
    }

    public Cap getSpinnerStrokeCap() {
        return this.f2219E;
    }

    public int getTextColor() {
        return this.f2215A;
    }

    public float getTextScale() {
        return this.f2253p;
    }

    public int getTextSize() {
        return this.f2251n;
    }

    public String getUnit() {
        return this.ad;
    }

    public float getUnitScale() {
        return this.f2254q;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (360.0f / this.f2241d) * this.f2238a;
        canvas.drawArc(this.f2227M, 360.0f, 360.0f, false, this.f2222H);
        if (this.f2250m > 0) {
            canvas.drawArc(this.f2227M, 360.0f, 360.0f, false, this.f2223I);
        }
        if (this.f2252o > 0.0f) {
            canvas.drawArc(this.f2231Q, 360.0f, 360.0f, false, this.f2226L);
            canvas.drawArc(this.f2232R, 360.0f, 360.0f, false, this.f2226L);
        }
        if (this.aa == C0537d.SPINNING || this.aa == C0537d.END_SPINNING) {
            m4100a(canvas);
        } else if (this.aa == C0537d.END_SPINNING_START_ANIMATING) {
            m4100a(canvas);
            if (this.f2236V) {
                m4101a(canvas, f);
            }
        } else {
            m4101a(canvas, f);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        measuredWidth = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        if (paddingLeft <= measuredWidth) {
            measuredWidth = paddingLeft;
        }
        setMeasuredDimension((getPaddingLeft() + measuredWidth) + getPaddingRight(), (measuredWidth + getPaddingTop()) + getPaddingBottom());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2246i = i;
        this.f2245h = i2;
        m4108c();
        m4127b();
        invalidate();
    }

    public void setBarColor(int... iArr) {
        if (iArr.length == 1) {
            this.f2217C = new int[]{iArr[0], iArr[0]};
            return;
        }
        this.f2217C = iArr;
    }

    public void setBarStrokeCap(Cap cap) {
        this.f2218D = cap;
    }

    public void setBarWidth(int i) {
        this.f2249l = i;
    }

    public void setContourColor(int i) {
        this.f2260w = i;
    }

    public void setContourSize(float f) {
        this.f2252o = f;
    }

    public void setDelayMillis(int i) {
        this.f2235U = i;
    }

    public void setFillColor(int i) {
        this.f2262y = i;
    }

    public void setMaxValue(float f) {
        this.f2241d = f;
    }

    public void setPaddingBottom(int i) {
        this.f2256s = i;
    }

    public void setPaddingLeft(int i) {
        this.f2257t = i;
    }

    public void setPaddingRight(int i) {
        this.f2258u = i;
    }

    public void setPaddingTop(int i) {
        this.f2255r = i;
    }

    public void setRimColor(int i) {
        this.f2263z = i;
    }

    public void setRimShader(Shader shader) {
        this.f2223I.setShader(shader);
    }

    public void setRimWidth(int i) {
        this.f2250m = i;
    }

    public void setShowPercentAsAutoValue(boolean z) {
        this.ah = z;
    }

    public void setShowUnit(boolean z) {
        this.ai = z;
        this.ae = 0;
        invalidate();
        this.f2228N = m4096a(this.f2227M);
    }

    public void setSpinBarColor(int i) {
        this.f2261x = i;
    }

    public void setSpinSpeed(float f) {
        this.f2233S = f;
    }

    public void setSpinnerStrokeCap(Cap cap) {
        this.f2219E = cap;
    }

    public void setSpinningBarLength(float f) {
        this.f2243f = f;
        this.f2242e = f;
    }

    public void setText(String str) {
        if (str == null || str.isEmpty()) {
            this.ac = BuildConfig.FLAVOR;
            this.af = true;
        } else {
            this.ac = str;
            this.af = false;
        }
        invalidate();
    }

    public void setTextColor(int i) {
        this.f2215A = i;
    }

    public void setTextScale(float f) {
        this.f2253p = f;
    }

    public void setTextSize(int i) {
        if (i > 0) {
            this.f2251n = i;
            this.ag = false;
            return;
        }
        this.ag = true;
    }

    public void setUnit(String str) {
        if (str == null) {
            this.ad = BuildConfig.FLAVOR;
        } else {
            this.ad = str;
        }
        invalidate();
    }

    public void setUnitColor(int i) {
        this.f2216B = i;
    }

    public void setUnitScale(float f) {
        this.f2254q = f;
    }

    public void setValue(float f) {
        Message message = new Message();
        message.what = C0536c.SET_VALUE.ordinal();
        message.obj = new float[]{f, f};
        this.f2237W.sendMessage(message);
    }

    public void setValueAnimated(float f) {
        this.f2234T = 1200.0d;
        Message message = new Message();
        message.what = C0536c.SET_VALUE_ANIMATED.ordinal();
        message.obj = new float[]{this.f2238a, f};
        this.f2237W.sendMessage(message);
    }
}
