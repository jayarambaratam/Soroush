package p025b.p026a.p027a.p028a.p029a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import p025b.p026a.p027a.p028a.p030b.C0548a;

/* renamed from: b.a.a.a.a.a */
public class C0541a implements C0540e {
    protected C0545f f2284a;
    float f2285b;
    float f2286c;
    final float f2287d;
    final float f2288e;
    private VelocityTracker f2289f;
    private boolean f2290g;

    public C0541a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2288e = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2287d = (float) viewConfiguration.getScaledTouchSlop();
    }

    float m4139a(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    public void m4140a(C0545f c0545f) {
        this.f2284a = c0545f;
    }

    public boolean m4141a() {
        return false;
    }

    float m4142b(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    public boolean m4143b() {
        return this.f2290g;
    }

    public boolean m4144c(MotionEvent motionEvent) {
        boolean z = false;
        float yVelocity;
        switch (motionEvent.getAction()) {
            case VideoSize.QCIF /*0*/:
                this.f2289f = VelocityTracker.obtain();
                if (this.f2289f != null) {
                    this.f2289f.addMovement(motionEvent);
                } else {
                    C0548a.m4159a().m4161b("CupcakeGestureDetector", "Velocity tracker is null");
                }
                this.f2285b = m4139a(motionEvent);
                this.f2286c = m4142b(motionEvent);
                this.f2290g = false;
                break;
            case VideoSize.CIF /*1*/:
                if (this.f2290g && this.f2289f != null) {
                    this.f2285b = m4139a(motionEvent);
                    this.f2286c = m4142b(motionEvent);
                    this.f2289f.addMovement(motionEvent);
                    this.f2289f.computeCurrentVelocity(1000);
                    float xVelocity = this.f2289f.getXVelocity();
                    yVelocity = this.f2289f.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f2288e) {
                        this.f2284a.m4152a(this.f2285b, this.f2286c, -xVelocity, -yVelocity);
                    }
                }
                if (this.f2289f != null) {
                    this.f2289f.recycle();
                    this.f2289f = null;
                    break;
                }
                break;
            case VideoSize.HVGA /*2*/:
                yVelocity = m4139a(motionEvent);
                float b = m4142b(motionEvent);
                float f = yVelocity - this.f2285b;
                float f2 = b - this.f2286c;
                if (!this.f2290g) {
                    if (Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.f2287d)) {
                        z = true;
                    }
                    this.f2290g = z;
                }
                if (this.f2290g) {
                    this.f2284a.m4150a(f, f2);
                    this.f2285b = yVelocity;
                    this.f2286c = b;
                    if (this.f2289f != null) {
                        this.f2289f.addMovement(motionEvent);
                        break;
                    }
                }
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                if (this.f2289f != null) {
                    this.f2289f.recycle();
                    this.f2289f = null;
                    break;
                }
                break;
        }
        return true;
    }
}
