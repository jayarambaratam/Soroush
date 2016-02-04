package p025b.p026a.p027a.p028a.p029a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import p025b.p026a.p027a.p028a.C0547a;

@TargetApi(5)
/* renamed from: b.a.a.a.a.b */
public class C0542b extends C0541a {
    private int f2291f;
    private int f2292g;

    public C0542b(Context context) {
        super(context);
        this.f2291f = -1;
        this.f2292g = 0;
    }

    float m4145a(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f2292g);
        } catch (Exception e) {
            return motionEvent.getX();
        }
    }

    float m4146b(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f2292g);
        } catch (Exception e) {
            return motionEvent.getY();
        }
    }

    public boolean m4147c(MotionEvent motionEvent) {
        int i = 0;
        switch (motionEvent.getAction() & 255) {
            case VideoSize.QCIF /*0*/:
                this.f2291f = motionEvent.getPointerId(0);
                break;
            case VideoSize.CIF /*1*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f2291f = -1;
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                int a = C0547a.m4154a(motionEvent.getAction());
                if (motionEvent.getPointerId(a) == this.f2291f) {
                    a = a == 0 ? 1 : 0;
                    this.f2291f = motionEvent.getPointerId(a);
                    this.b = motionEvent.getX(a);
                    this.c = motionEvent.getY(a);
                    break;
                }
                break;
        }
        if (this.f2291f != -1) {
            i = this.f2291f;
        }
        this.f2292g = motionEvent.findPointerIndex(i);
        return super.m4144c(motionEvent);
    }
}
