package com.cocosw.bottomsheet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* renamed from: com.cocosw.bottomsheet.k */
class C1002k implements OnDismissListener {
    final /* synthetic */ C0993c f3796a;

    C1002k(C0993c c0993c) {
        this.f3796a = c0993c;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f3796a.f3785u != null) {
            this.f3796a.f3785u.onDismiss(dialogInterface);
        }
        if (this.f3796a.f3779o != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            this.f3796a.m6090f();
        }
    }
}
