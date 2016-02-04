package p025b.p026a.p027a.p028a;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import p025b.p026a.p027a.p028a.p030b.C0548a;
import p025b.p026a.p027a.p028a.p031c.C0552d;

/* renamed from: b.a.a.a.h */
class C0561h implements Runnable {
    final /* synthetic */ C0557d f2337a;
    private final C0552d f2338b;
    private int f2339c;
    private int f2340d;

    public C0561h(C0557d c0557d, Context context) {
        this.f2337a = c0557d;
        this.f2338b = C0552d.m4165a(context);
    }

    public void m4221a() {
        if (C0557d.f2301c) {
            C0548a.m4159a().m4160a("PhotoViewAttacher", "Cancel Fling");
        }
        this.f2338b.m4167a(true);
    }

    public void m4222a(int i, int i2, int i3, int i4) {
        RectF b = this.f2337a.m4210b();
        if (b != null) {
            int round;
            int i5;
            int round2;
            int i6;
            int round3 = Math.round(-b.left);
            if (((float) i) < b.width()) {
                round = Math.round(b.width() - ((float) i));
                i5 = 0;
            } else {
                round = round3;
                i5 = round3;
            }
            int round4 = Math.round(-b.top);
            if (((float) i2) < b.height()) {
                round2 = Math.round(b.height() - ((float) i2));
                i6 = 0;
            } else {
                round2 = round4;
                i6 = round4;
            }
            this.f2339c = round3;
            this.f2340d = round4;
            if (C0557d.f2301c) {
                C0548a.m4159a().m4160a("PhotoViewAttacher", "fling. StartX:" + round3 + " StartY:" + round4 + " MaxX:" + round + " MaxY:" + round2);
            }
            if (round3 != round || round4 != round2) {
                this.f2338b.m4166a(round3, round4, i3, i4, i5, round, i6, round2, 0, 0);
            }
        }
    }

    public void run() {
        if (!this.f2338b.m4169b()) {
            View c = this.f2337a.m4211c();
            if (c != null && this.f2338b.m4168a()) {
                int c2 = this.f2338b.m4170c();
                int d = this.f2338b.m4171d();
                if (C0557d.f2301c) {
                    C0548a.m4159a().m4160a("PhotoViewAttacher", "fling run(). CurrentX:" + this.f2339c + " CurrentY:" + this.f2340d + " NewX:" + c2 + " NewY:" + d);
                }
                this.f2337a.f2316n.postTranslate((float) (this.f2339c - c2), (float) (this.f2340d - d));
                this.f2337a.m4193b(this.f2337a.m4219k());
                this.f2339c = c2;
                this.f2340d = d;
                C0547a.m4155a(c, this);
            }
        }
    }
}
