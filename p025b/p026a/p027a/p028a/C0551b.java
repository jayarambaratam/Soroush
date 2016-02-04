package p025b.p026a.p027a.p028a;

import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: b.a.a.a.b */
public class C0551b implements OnDoubleTapListener {
    private C0557d f2296a;

    public C0551b(C0557d c0557d) {
        m4164a(c0557d);
    }

    public void m4164a(C0557d c0557d) {
        this.f2296a = c0557d;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f2296a == null) {
            return false;
        }
        try {
            float g = this.f2296a.m4215g();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (g < this.f2296a.m4213e()) {
                this.f2296a.m4208a(this.f2296a.m4213e(), x, y, true);
                return true;
            } else if (g < this.f2296a.m4213e() || g >= this.f2296a.m4214f()) {
                this.f2296a.m4208a(this.f2296a.m4212d(), x, y, true);
                return true;
            } else {
                this.f2296a.m4208a(this.f2296a.m4214f(), x, y, true);
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.f2296a == null) {
            return false;
        }
        View c = this.f2296a.m4211c();
        if (this.f2296a.m4216h() != null) {
            RectF b = this.f2296a.m4210b();
            if (b != null) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (b.contains(x, y)) {
                    this.f2296a.m4216h().m4224a(c, (x - b.left) / b.width(), (y - b.top) / b.height());
                    return true;
                }
            }
        }
        if (this.f2296a.m4217i() == null) {
            return false;
        }
        this.f2296a.m4217i().m4226a(c, motionEvent.getX(), motionEvent.getY());
        return false;
    }
}
