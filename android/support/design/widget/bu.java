package android.support.design.widget;

import android.support.v4.view.cb;
import android.support.v4.widget.cw;
import android.view.View;

class bu extends cw {
    final /* synthetic */ SwipeDismissBehavior f516a;
    private int f517b;

    bu(SwipeDismissBehavior swipeDismissBehavior) {
        this.f516a = swipeDismissBehavior;
    }

    private boolean m620a(View view, float f) {
        if (f != 0.0f) {
            boolean z = cb.m2428h(view) == 1;
            return this.f516a.f381f == 2 ? true : this.f516a.f381f == 0 ? z ? f < 0.0f : f > 0.0f : this.f516a.f381f == 1 ? z ? f > 0.0f : f < 0.0f : false;
        } else {
            return Math.abs(view.getLeft() - this.f517b) >= Math.round(((float) view.getWidth()) * this.f516a.f382g);
        }
    }

    public int m621a(View view) {
        return view.getWidth();
    }

    public int m622a(View view, int i, int i2) {
        int width;
        int i3;
        Object obj = cb.m2428h(view) == 1 ? 1 : null;
        if (this.f516a.f381f == 0) {
            if (obj != null) {
                width = this.f517b - view.getWidth();
                i3 = this.f517b;
            } else {
                width = this.f517b;
                i3 = this.f517b + view.getWidth();
            }
        } else if (this.f516a.f381f != 1) {
            width = this.f517b - view.getWidth();
            i3 = this.f517b + view.getWidth();
        } else if (obj != null) {
            width = this.f517b;
            i3 = this.f517b + view.getWidth();
        } else {
            width = this.f517b - view.getWidth();
            i3 = this.f517b;
        }
        return SwipeDismissBehavior.m404b(width, i, i3);
    }

    public void m623a(int i) {
        if (this.f516a.f377b != null) {
            this.f516a.f377b.m563a(i);
        }
    }

    public void m624a(View view, float f, float f2) {
        int width = view.getWidth();
        boolean z = false;
        if (m620a(view, f)) {
            width = view.getLeft() < this.f517b ? this.f517b - width : this.f517b + width;
            z = true;
        } else {
            width = this.f517b;
        }
        if (this.f516a.f376a.m3394a(width, view.getTop())) {
            cb.m2402a(view, new bw(this.f516a, view, z));
        } else if (z && this.f516a.f377b != null) {
            this.f516a.f377b.m564a(view);
        }
    }

    public void m625a(View view, int i, int i2, int i3, int i4) {
        float width = ((float) this.f517b) + (((float) view.getWidth()) * this.f516a.f383h);
        float width2 = ((float) this.f517b) + (((float) view.getWidth()) * this.f516a.f384i);
        if (((float) i) <= width) {
            cb.m2413c(view, 1.0f);
        } else if (((float) i) >= width2) {
            cb.m2413c(view, 0.0f);
        } else {
            cb.m2413c(view, SwipeDismissBehavior.m406c(0.0f, 1.0f - SwipeDismissBehavior.m399a(width, width2, (float) i), 1.0f));
        }
    }

    public boolean m626a(View view, int i) {
        return this.f516a.m416a(view);
    }

    public int m627b(View view, int i, int i2) {
        return view.getTop();
    }

    public void m628b(View view, int i) {
        this.f517b = view.getLeft();
    }
}
