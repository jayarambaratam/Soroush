package mobi.mmdt.ott.view.components.mediaviewer;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

/* renamed from: mobi.mmdt.ott.view.components.mediaviewer.d */
class C1929d implements OnLayoutChangeListener {
    final /* synthetic */ MediaViewerActivity f6196a;

    C1929d(MediaViewerActivity mediaViewerActivity) {
        this.f6196a = mediaViewerActivity;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        View childAt;
        if (this.f6196a.f6158l.getChildCount() >= 3) {
            if (this.f6196a.f6158l.getChildAt(0) != null) {
                childAt = this.f6196a.f6158l.getChildAt(0);
                childAt.setScaleY(0.7f);
                childAt.setScaleX(0.7f);
            }
            if (this.f6196a.f6158l.getChildAt(2) != null) {
                childAt = this.f6196a.f6158l.getChildAt(2);
                childAt.setScaleY(0.7f);
                childAt.setScaleX(0.7f);
            }
        } else if (this.f6196a.f6158l.getChildAt(1) == null) {
        } else {
            if (this.f6196a.f6158l.getCurrentPosition() == 0) {
                childAt = this.f6196a.f6158l.getChildAt(1);
                childAt.setScaleY(0.7f);
                childAt.setScaleX(0.7f);
                return;
            }
            childAt = this.f6196a.f6158l.getChildAt(0);
            childAt.setScaleY(0.7f);
            childAt.setScaleX(0.7f);
        }
    }
}
