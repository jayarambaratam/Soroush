package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: android.support.v4.view.s */
class C0324s implements C0323r {
    private static final int f1393e;
    private static final int f1394f;
    private static final int f1395g;
    private int f1396a;
    private int f1397b;
    private int f1398c;
    private int f1399d;
    private final Handler f1400h;
    private final OnGestureListener f1401i;
    private OnDoubleTapListener f1402j;
    private boolean f1403k;
    private boolean f1404l;
    private boolean f1405m;
    private boolean f1406n;
    private boolean f1407o;
    private MotionEvent f1408p;
    private MotionEvent f1409q;
    private boolean f1410r;
    private float f1411s;
    private float f1412t;
    private float f1413u;
    private float f1414v;
    private boolean f1415w;
    private VelocityTracker f1416x;

    static {
        f1393e = ViewConfiguration.getLongPressTimeout();
        f1394f = ViewConfiguration.getTapTimeout();
        f1395g = ViewConfiguration.getDoubleTapTimeout();
    }

    public C0324s(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (handler != null) {
            this.f1400h = new C0325t(this, handler);
        } else {
            this.f1400h = new C0325t(this);
        }
        this.f1401i = onGestureListener;
        if (onGestureListener instanceof OnDoubleTapListener) {
            m2938a((OnDoubleTapListener) onGestureListener);
        }
        m2929a(context);
    }

    private void m2928a() {
        this.f1400h.removeMessages(1);
        this.f1400h.removeMessages(2);
        this.f1400h.removeMessages(3);
        this.f1416x.recycle();
        this.f1416x = null;
        this.f1410r = false;
        this.f1403k = false;
        this.f1406n = false;
        this.f1407o = false;
        this.f1404l = false;
        if (this.f1405m) {
            this.f1405m = false;
        }
    }

    private void m2929a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        } else if (this.f1401i == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        } else {
            this.f1415w = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.f1398c = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1399d = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1396a = scaledTouchSlop * scaledTouchSlop;
            this.f1397b = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }
    }

    private boolean m2931a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (!this.f1407o || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) f1395g)) {
            return false;
        }
        int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        return (x * x) + (y * y) < this.f1397b;
    }

    private void m2933b() {
        this.f1400h.removeMessages(1);
        this.f1400h.removeMessages(2);
        this.f1400h.removeMessages(3);
        this.f1410r = false;
        this.f1406n = false;
        this.f1407o = false;
        this.f1404l = false;
        if (this.f1405m) {
            this.f1405m = false;
        }
    }

    private void m2934c() {
        this.f1400h.removeMessages(3);
        this.f1404l = false;
        this.f1405m = true;
        this.f1401i.onLongPress(this.f1408p);
    }

    public void m2938a(OnDoubleTapListener onDoubleTapListener) {
        this.f1402j = onDoubleTapListener;
    }

    public boolean m2939a(MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        if (this.f1416x == null) {
            this.f1416x = VelocityTracker.obtain();
        }
        this.f1416x.addMovement(motionEvent);
        boolean z = (action & 255) == 6;
        int b = z ? bf.m2311b(motionEvent) : -1;
        int c = bf.m2314c(motionEvent);
        float f = 0.0f;
        float f2 = 0.0f;
        for (i = 0; i < c; i++) {
            if (b != i) {
                f2 += bf.m2313c(motionEvent, i);
                f += bf.m2315d(motionEvent, i);
            }
        }
        b = z ? c - 1 : c;
        f2 /= (float) b;
        f /= (float) b;
        boolean hasMessages;
        float b2;
        float a;
        switch (action & 255) {
            case VideoSize.QCIF /*0*/:
                if (this.f1402j != null) {
                    hasMessages = this.f1400h.hasMessages(3);
                    if (hasMessages) {
                        this.f1400h.removeMessages(3);
                    }
                    if (this.f1408p == null || this.f1409q == null || !hasMessages || !m2931a(this.f1408p, this.f1409q, motionEvent)) {
                        this.f1400h.sendEmptyMessageDelayed(3, (long) f1395g);
                    } else {
                        this.f1410r = true;
                        b = (this.f1402j.onDoubleTap(this.f1408p) | 0) | this.f1402j.onDoubleTapEvent(motionEvent);
                        this.f1411s = f2;
                        this.f1413u = f2;
                        this.f1412t = f;
                        this.f1414v = f;
                        if (this.f1408p != null) {
                            this.f1408p.recycle();
                        }
                        this.f1408p = MotionEvent.obtain(motionEvent);
                        this.f1406n = true;
                        this.f1407o = true;
                        this.f1403k = true;
                        this.f1405m = false;
                        this.f1404l = false;
                        if (this.f1415w) {
                            this.f1400h.removeMessages(2);
                            this.f1400h.sendEmptyMessageAtTime(2, (this.f1408p.getDownTime() + ((long) f1394f)) + ((long) f1393e));
                        }
                        this.f1400h.sendEmptyMessageAtTime(1, this.f1408p.getDownTime() + ((long) f1394f));
                        return b | this.f1401i.onDown(motionEvent);
                    }
                }
                b = 0;
                this.f1411s = f2;
                this.f1413u = f2;
                this.f1412t = f;
                this.f1414v = f;
                if (this.f1408p != null) {
                    this.f1408p.recycle();
                }
                this.f1408p = MotionEvent.obtain(motionEvent);
                this.f1406n = true;
                this.f1407o = true;
                this.f1403k = true;
                this.f1405m = false;
                this.f1404l = false;
                if (this.f1415w) {
                    this.f1400h.removeMessages(2);
                    this.f1400h.sendEmptyMessageAtTime(2, (this.f1408p.getDownTime() + ((long) f1394f)) + ((long) f1393e));
                }
                this.f1400h.sendEmptyMessageAtTime(1, this.f1408p.getDownTime() + ((long) f1394f));
                return b | this.f1401i.onDown(motionEvent);
            case VideoSize.CIF /*1*/:
                this.f1403k = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.f1410r) {
                    hasMessages = this.f1402j.onDoubleTapEvent(motionEvent) | 0;
                } else if (this.f1405m) {
                    this.f1400h.removeMessages(3);
                    this.f1405m = false;
                    hasMessages = false;
                } else if (this.f1406n) {
                    hasMessages = this.f1401i.onSingleTapUp(motionEvent);
                    if (this.f1404l && this.f1402j != null) {
                        this.f1402j.onSingleTapConfirmed(motionEvent);
                    }
                } else {
                    VelocityTracker velocityTracker = this.f1416x;
                    int b3 = bf.m2312b(motionEvent, 0);
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1399d);
                    b2 = bw.m2359b(velocityTracker, b3);
                    a = bw.m2358a(velocityTracker, b3);
                    hasMessages = (Math.abs(b2) > ((float) this.f1398c) || Math.abs(a) > ((float) this.f1398c)) ? this.f1401i.onFling(this.f1408p, motionEvent, a, b2) : false;
                }
                if (this.f1409q != null) {
                    this.f1409q.recycle();
                }
                this.f1409q = obtain;
                if (this.f1416x != null) {
                    this.f1416x.recycle();
                    this.f1416x = null;
                }
                this.f1410r = false;
                this.f1404l = false;
                this.f1400h.removeMessages(1);
                this.f1400h.removeMessages(2);
                return hasMessages;
            case VideoSize.HVGA /*2*/:
                if (this.f1405m) {
                    return false;
                }
                a = this.f1411s - f2;
                b2 = this.f1412t - f;
                if (this.f1410r) {
                    return false | this.f1402j.onDoubleTapEvent(motionEvent);
                }
                if (this.f1406n) {
                    i = (int) (f2 - this.f1413u);
                    int i2 = (int) (f - this.f1414v);
                    i = (i * i) + (i2 * i2);
                    if (i > this.f1396a) {
                        hasMessages = this.f1401i.onScroll(this.f1408p, motionEvent, a, b2);
                        this.f1411s = f2;
                        this.f1412t = f;
                        this.f1406n = false;
                        this.f1400h.removeMessages(3);
                        this.f1400h.removeMessages(1);
                        this.f1400h.removeMessages(2);
                    } else {
                        hasMessages = false;
                    }
                    if (i > this.f1396a) {
                        this.f1407o = false;
                    }
                    return hasMessages;
                } else if (Math.abs(a) < 1.0f && Math.abs(b2) < 1.0f) {
                    return false;
                } else {
                    boolean onScroll = this.f1401i.onScroll(this.f1408p, motionEvent, a, b2);
                    this.f1411s = f2;
                    this.f1412t = f;
                    return onScroll;
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                m2928a();
                return false;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f1411s = f2;
                this.f1413u = f2;
                this.f1412t = f;
                this.f1414v = f;
                m2933b();
                return false;
            case Version.API06_ECLAIR_201 /*6*/:
                this.f1411s = f2;
                this.f1413u = f2;
                this.f1412t = f;
                this.f1414v = f;
                this.f1416x.computeCurrentVelocity(1000, (float) this.f1399d);
                int b4 = bf.m2311b(motionEvent);
                b = bf.m2312b(motionEvent, b4);
                f2 = bw.m2358a(this.f1416x, b);
                float b5 = bw.m2359b(this.f1416x, b);
                for (b = 0; b < c; b++) {
                    if (b != b4) {
                        int b6 = bf.m2312b(motionEvent, b);
                        if ((bw.m2359b(this.f1416x, b6) * b5) + (bw.m2358a(this.f1416x, b6) * f2) < 0.0f) {
                            this.f1416x.clear();
                            return false;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }
}
