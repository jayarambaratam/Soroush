package mobi.mmdt.ott.view.components.p181b;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: mobi.mmdt.ott.view.components.b.j */
public class C1791j implements OnItemTouchListener {
    private C1720l f5780a;
    private GestureDetector f5781b;

    public C1791j(Context context, RecyclerView recyclerView, C1720l c1720l) {
        this.f5780a = c1720l;
        this.f5781b = new GestureDetector(context, new C1792k(this, recyclerView));
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (findChildViewUnder != null && this.f5780a != null && this.f5781b.onTouchEvent(motionEvent) && recyclerView.getChildPosition(findChildViewUnder) > -1) {
            this.f5780a.m8637a(findChildViewUnder, recyclerView.getChildPosition(findChildViewUnder));
        }
        return false;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }
}
