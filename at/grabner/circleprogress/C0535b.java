package at.grabner.circleprogress;

import android.animation.TimeInterpolator;
import android.os.Handler;
import android.os.Message;
import android.view.animation.DecelerateInterpolator;
import java.lang.ref.WeakReference;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: at.grabner.circleprogress.b */
class C0535b extends Handler {
    private final WeakReference<CircleProgressView> f2266a;
    private float f2267b;
    private long f2268c;
    private long f2269d;
    private TimeInterpolator f2270e;
    private double f2271f;

    C0535b(CircleProgressView circleProgressView) {
        super(circleProgressView.getContext().getMainLooper());
        this.f2270e = new DecelerateInterpolator();
        this.f2266a = new WeakReference(circleProgressView);
    }

    private void m4128a(Message message, CircleProgressView circleProgressView) {
        circleProgressView.f2240c = ((float[]) message.obj)[0];
        circleProgressView.f2239b = ((float[]) message.obj)[1];
        this.f2268c = System.currentTimeMillis();
        circleProgressView.aa = C0537d.ANIMATING;
        circleProgressView.f2237W.sendEmptyMessageDelayed(C0536c.TICK.ordinal(), (long) circleProgressView.f2235U);
    }

    private void m4129a(CircleProgressView circleProgressView) {
        circleProgressView.aa = C0537d.END_SPINNING;
        m4132b(circleProgressView);
        circleProgressView.f2237W.sendEmptyMessageDelayed(C0536c.TICK.ordinal(), (long) circleProgressView.f2235U);
    }

    private void m4130a(CircleProgressView circleProgressView, Message message) {
        circleProgressView.aa = C0537d.END_SPINNING_START_ANIMATING;
        circleProgressView.f2240c = 0.0f;
        circleProgressView.f2239b = ((float[]) message.obj)[1];
        this.f2269d = System.currentTimeMillis();
        this.f2267b = circleProgressView.f2242e;
        circleProgressView.f2237W.sendEmptyMessageDelayed(C0536c.TICK.ordinal(), (long) circleProgressView.f2235U);
    }

    private void m4131b(Message message, CircleProgressView circleProgressView) {
        circleProgressView.f2240c = circleProgressView.f2239b;
        circleProgressView.f2238a = circleProgressView.f2239b = ((float[]) message.obj)[0];
        circleProgressView.aa = C0537d.IDLE;
        circleProgressView.invalidate();
    }

    private void m4132b(CircleProgressView circleProgressView) {
        this.f2271f = (double) (((circleProgressView.f2242e / circleProgressView.f2233S) * ((float) circleProgressView.f2235U)) * 2.0f);
        this.f2269d = System.currentTimeMillis();
        this.f2267b = circleProgressView.f2242e;
    }

    private void m4133c(CircleProgressView circleProgressView) {
        circleProgressView.aa = C0537d.SPINNING;
        circleProgressView.f2242e = (360.0f / circleProgressView.f2241d) * circleProgressView.f2238a;
        circleProgressView.f2244g = (360.0f / circleProgressView.f2241d) * circleProgressView.f2238a;
        this.f2269d = System.currentTimeMillis();
        this.f2267b = circleProgressView.f2242e;
        this.f2271f = (double) (((circleProgressView.f2243f / circleProgressView.f2233S) * ((float) circleProgressView.f2235U)) * 2.0f);
        circleProgressView.f2237W.sendEmptyMessageDelayed(C0536c.TICK.ordinal(), (long) circleProgressView.f2235U);
    }

    private boolean m4134d(CircleProgressView circleProgressView) {
        float currentTimeMillis = (float) (((double) (System.currentTimeMillis() - this.f2268c)) / circleProgressView.f2234T);
        if (currentTimeMillis > 1.0f) {
            currentTimeMillis = 1.0f;
        }
        circleProgressView.f2238a = (circleProgressView.ab.getInterpolation(currentTimeMillis) * (circleProgressView.f2239b - circleProgressView.f2240c)) + circleProgressView.f2240c;
        return currentTimeMillis >= 1.0f;
    }

    public void handleMessage(Message message) {
        CircleProgressView circleProgressView = (CircleProgressView) this.f2266a.get();
        if (circleProgressView != null) {
            C0536c c0536c = C0536c.values()[message.what];
            if (c0536c == C0536c.TICK) {
                removeMessages(C0536c.TICK.ordinal());
            }
            float currentTimeMillis;
            switch (C0534a.f2265b[circleProgressView.aa.ordinal()]) {
                case VideoSize.CIF /*1*/:
                    switch (C0534a.f2264a[c0536c.ordinal()]) {
                        case VideoSize.CIF /*1*/:
                            m4133c(circleProgressView);
                        case VideoSize.HVGA /*2*/:
                        case Version.API03_CUPCAKE_15 /*3*/:
                            m4131b(message, circleProgressView);
                        case Version.API04_DONUT_16 /*4*/:
                            m4128a(message, circleProgressView);
                        case Version.API05_ECLAIR_20 /*5*/:
                            removeMessages(C0536c.TICK.ordinal());
                        default:
                    }
                case VideoSize.HVGA /*2*/:
                    switch (C0534a.f2264a[c0536c.ordinal()]) {
                        case VideoSize.CIF /*1*/:
                        case VideoSize.HVGA /*2*/:
                            m4129a(circleProgressView);
                        case Version.API03_CUPCAKE_15 /*3*/:
                            m4131b(message, circleProgressView);
                        case Version.API04_DONUT_16 /*4*/:
                            m4130a(circleProgressView, message);
                        case Version.API05_ECLAIR_20 /*5*/:
                            float b = circleProgressView.f2242e - circleProgressView.f2243f;
                            currentTimeMillis = (float) (((double) (System.currentTimeMillis() - this.f2269d)) / this.f2271f);
                            if (currentTimeMillis > 1.0f) {
                                currentTimeMillis = 1.0f;
                            }
                            currentTimeMillis = this.f2270e.getInterpolation(currentTimeMillis);
                            if (Math.abs(b) < 1.0f) {
                                circleProgressView.f2242e = circleProgressView.f2243f;
                            } else if (circleProgressView.f2242e < circleProgressView.f2243f) {
                                circleProgressView.f2242e = (currentTimeMillis * (circleProgressView.f2243f - this.f2267b)) + this.f2267b;
                            } else {
                                circleProgressView.f2242e = this.f2267b - (currentTimeMillis * (this.f2267b - circleProgressView.f2243f));
                            }
                            CircleProgressView.m4104b(circleProgressView, circleProgressView.f2233S);
                            if (circleProgressView.f2244g > 360.0f) {
                                circleProgressView.f2244g = 0.0f;
                            }
                            circleProgressView.f2237W.sendEmptyMessageDelayed(C0536c.TICK.ordinal(), (long) circleProgressView.f2235U);
                            circleProgressView.invalidate();
                        default:
                    }
                case Version.API03_CUPCAKE_15 /*3*/:
                    switch (C0534a.f2264a[c0536c.ordinal()]) {
                        case VideoSize.CIF /*1*/:
                            circleProgressView.aa = C0537d.SPINNING;
                            circleProgressView.f2237W.sendEmptyMessageDelayed(C0536c.TICK.ordinal(), (long) circleProgressView.f2235U);
                        case VideoSize.HVGA /*2*/:
                        case Version.API03_CUPCAKE_15 /*3*/:
                            m4131b(message, circleProgressView);
                        case Version.API04_DONUT_16 /*4*/:
                            m4130a(circleProgressView, message);
                        case Version.API05_ECLAIR_20 /*5*/:
                            currentTimeMillis = (float) (((double) (System.currentTimeMillis() - this.f2269d)) / this.f2271f);
                            if (currentTimeMillis > 1.0f) {
                                currentTimeMillis = 1.0f;
                            }
                            circleProgressView.f2242e = (1.0f - this.f2270e.getInterpolation(currentTimeMillis)) * this.f2267b;
                            CircleProgressView.m4104b(circleProgressView, circleProgressView.f2233S);
                            if (circleProgressView.f2242e < 0.01f) {
                                circleProgressView.aa = C0537d.IDLE;
                            }
                            circleProgressView.f2237W.sendEmptyMessageDelayed(C0536c.TICK.ordinal(), (long) circleProgressView.f2235U);
                            circleProgressView.invalidate();
                        default:
                    }
                case Version.API04_DONUT_16 /*4*/:
                    switch (C0534a.f2264a[c0536c.ordinal()]) {
                        case VideoSize.CIF /*1*/:
                            circleProgressView.f2236V = false;
                            m4133c(circleProgressView);
                        case VideoSize.HVGA /*2*/:
                        case Version.API03_CUPCAKE_15 /*3*/:
                            circleProgressView.f2236V = false;
                            m4131b(message, circleProgressView);
                        case Version.API04_DONUT_16 /*4*/:
                            circleProgressView.f2240c = 0.0f;
                            circleProgressView.f2239b = ((float[]) message.obj)[1];
                            circleProgressView.f2237W.sendEmptyMessageDelayed(C0536c.TICK.ordinal(), (long) circleProgressView.f2235U);
                        case Version.API05_ECLAIR_20 /*5*/:
                            if (circleProgressView.f2242e > circleProgressView.f2243f && !circleProgressView.f2236V) {
                                currentTimeMillis = (float) (((double) (System.currentTimeMillis() - this.f2269d)) / this.f2271f);
                                if (currentTimeMillis > 1.0f) {
                                    currentTimeMillis = 1.0f;
                                }
                                circleProgressView.f2242e = (1.0f - this.f2270e.getInterpolation(currentTimeMillis)) * this.f2267b;
                            }
                            CircleProgressView.m4104b(circleProgressView, circleProgressView.f2233S);
                            if (circleProgressView.f2244g > 360.0f && !circleProgressView.f2236V) {
                                this.f2268c = System.currentTimeMillis();
                                circleProgressView.f2236V = true;
                                m4132b(circleProgressView);
                            }
                            if (circleProgressView.f2236V) {
                                circleProgressView.f2244g = 360.0f;
                                CircleProgressView.m4113f(circleProgressView, circleProgressView.f2233S);
                                m4134d(circleProgressView);
                                currentTimeMillis = (float) (((double) (System.currentTimeMillis() - this.f2269d)) / this.f2271f);
                                if (currentTimeMillis > 1.0f) {
                                    currentTimeMillis = 1.0f;
                                }
                                circleProgressView.f2242e = (1.0f - this.f2270e.getInterpolation(currentTimeMillis)) * this.f2267b;
                            }
                            if (((double) circleProgressView.f2242e) < 0.1d) {
                                circleProgressView.aa = C0537d.ANIMATING;
                                circleProgressView.invalidate();
                                circleProgressView.f2236V = false;
                                circleProgressView.f2242e = circleProgressView.f2243f;
                            } else {
                                circleProgressView.invalidate();
                            }
                            circleProgressView.f2237W.sendEmptyMessageDelayed(C0536c.TICK.ordinal(), (long) circleProgressView.f2235U);
                        default:
                    }
                case Version.API05_ECLAIR_20 /*5*/:
                    switch (C0534a.f2264a[c0536c.ordinal()]) {
                        case VideoSize.CIF /*1*/:
                            m4133c(circleProgressView);
                        case VideoSize.HVGA /*2*/:
                        case Version.API03_CUPCAKE_15 /*3*/:
                            m4131b(message, circleProgressView);
                        case Version.API04_DONUT_16 /*4*/:
                            this.f2268c = System.currentTimeMillis();
                            circleProgressView.f2240c = circleProgressView.f2238a;
                            circleProgressView.f2239b = ((float[]) message.obj)[1];
                        case Version.API05_ECLAIR_20 /*5*/:
                            if (m4134d(circleProgressView)) {
                                circleProgressView.aa = C0537d.IDLE;
                                circleProgressView.f2238a = circleProgressView.f2239b;
                            }
                            circleProgressView.f2237W.sendEmptyMessageDelayed(C0536c.TICK.ordinal(), (long) circleProgressView.f2235U);
                            circleProgressView.invalidate();
                        default:
                    }
                default:
            }
        }
    }
}
