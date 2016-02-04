package mobi.mmdt.ott.view.components.p181b;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: mobi.mmdt.ott.view.components.b.k */
class C1792k extends SimpleOnGestureListener {
    final /* synthetic */ RecyclerView f5782a;
    final /* synthetic */ C1791j f5783b;

    C1792k(C1791j c1791j, RecyclerView recyclerView) {
        this.f5783b = c1791j;
        this.f5782a = recyclerView;
    }

    public void onLongPress(MotionEvent motionEvent) {
        View findChildViewUnder = this.f5782a.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (findChildViewUnder != null && this.f5783b.f5780a != null && this.f5782a.getChildPosition(findChildViewUnder) > -1) {
            this.f5783b.f5780a.m8638b(findChildViewUnder, this.f5782a.getChildPosition(findChildViewUnder));
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }
}
