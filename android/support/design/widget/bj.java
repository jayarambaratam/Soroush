package android.support.design.widget;

import android.support.design.widget.Snackbar.SnackbarLayout;
import android.view.MotionEvent;
import android.view.View;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

final class bj extends SwipeDismissBehavior<SnackbarLayout> {
    final /* synthetic */ Snackbar f499a;

    bj(Snackbar snackbar) {
        this.f499a = snackbar;
    }

    public boolean m573a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
        if (coordinatorLayout.m339a((View) snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            switch (motionEvent.getActionMasked()) {
                case VideoSize.QCIF /*0*/:
                    bn.m578a().m590c(this.f499a.f375g);
                    break;
                case VideoSize.CIF /*1*/:
                case Version.API03_CUPCAKE_15 /*3*/:
                    bn.m578a().m591d(this.f499a.f375g);
                    break;
            }
        }
        return super.m415a(coordinatorLayout, (View) snackbarLayout, motionEvent);
    }

    public boolean m575a(View view) {
        return view instanceof SnackbarLayout;
    }
}
