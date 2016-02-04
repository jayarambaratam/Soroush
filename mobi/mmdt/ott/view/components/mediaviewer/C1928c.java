package mobi.mmdt.ott.view.components.mediaviewer;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;

/* renamed from: mobi.mmdt.ott.view.components.mediaviewer.c */
class C1928c extends OnScrollListener {
    final /* synthetic */ MediaViewerActivity f6195a;

    C1928c(MediaViewerActivity mediaViewerActivity) {
        this.f6195a = mediaViewerActivity;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            int findFirstCompletelyVisibleItemPosition = this.f6195a.f6159m.findFirstCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition >= 0) {
                this.f6195a.f6164r = findFirstCompletelyVisibleItemPosition;
                this.f6195a.m8493f((this.f6195a.f6164r + 1) + " of " + this.f6195a.f6156j.getItemCount());
            }
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        int childCount = this.f6195a.f6158l.getChildCount();
        int width = (this.f6195a.f6158l.getWidth() - this.f6195a.f6158l.getChildAt(0).getWidth()) / 2;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            float f = 0.0f;
            if (childAt.getLeft() <= width) {
                f = childAt.getLeft() >= width - childAt.getWidth() ? (((float) (width - childAt.getLeft())) * 1.0f) / ((float) childAt.getWidth()) : 1.0f;
                childAt.setScaleY(1.0f - (f * 0.3f));
                childAt.setScaleX(1.0f - (f * 0.3f));
            } else {
                if (childAt.getLeft() <= recyclerView.getWidth() - width) {
                    f = (((float) ((recyclerView.getWidth() - width) - childAt.getLeft())) * 1.0f) / ((float) childAt.getWidth());
                }
                childAt.setScaleY((f * 0.3f) + 0.7f);
                childAt.setScaleX((f * 0.3f) + 0.7f);
            }
        }
    }
}
