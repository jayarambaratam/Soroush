package com.p077d.p078a;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.d.a.c */
class C1019c implements OnTouchListener {
    final /* synthetic */ C1018b f3852a;

    C1019c(C1018b c1018b) {
        this.f3852a = c1018b;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f3852a.f3850m) {
            return false;
        }
        if (motionEvent.getAction() != 1) {
            this.f3852a.f3846i.scrollToPosition((int) (((float) this.f3852a.f3846i.getAdapter().getItemCount()) * (motionEvent.getY() / ((float) (this.f3852a.getHeight() - this.f3852a.f3840c.getHeight())))));
            this.f3852a.f3846i.onScrolled(0, 0);
            if (this.f3852a.f3847j != null && this.f3852a.f3847j.getVisibility() == 4) {
                this.f3852a.f3847j.setVisibility(0);
            }
            if (this.f3852a.f3849l) {
                this.f3852a.f3840c.setBackgroundColor(this.f3852a.f3838a);
            }
            this.f3852a.f3851n.f3856d = true;
            this.f3852a.m6146c();
            return true;
        }
        if (this.f3852a.f3847j != null && this.f3852a.f3847j.getVisibility() == 0) {
            if (VERSION.SDK_INT <= 12) {
                this.f3852a.f3847j.clearAnimation();
            }
            this.f3852a.f3847j.setVisibility(4);
        }
        if (this.f3852a.f3849l) {
            this.f3852a.f3840c.setBackgroundColor(this.f3852a.f3841d);
        }
        if (this.f3852a.f3845h) {
            this.f3852a.f3851n.f3855c = true;
            this.f3852a.f3851n.f3854b = System.currentTimeMillis() + ((long) this.f3852a.f3844g);
        }
        this.f3852a.f3851n.f3856d = false;
        return true;
    }
}
