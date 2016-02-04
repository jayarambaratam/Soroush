package com.cocosw.bottomsheet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

/* renamed from: com.cocosw.bottomsheet.e */
class C0996e implements OnShowListener {
    final /* synthetic */ C0993c f3787a;

    C0996e(C0993c c0993c) {
        this.f3787a = c0993c;
    }

    public void onShow(DialogInterface dialogInterface) {
        this.f3787a.f3770f.setAdapter(this.f3787a.f3771g);
        r1.f3770f.startLayoutAnimation();
        if (this.f3787a.f3772h.f3805i != null) {
            this.f3787a.f3778n.setVisibility(0);
            this.f3787a.f3778n.setImageDrawable(this.f3787a.f3772h.f3805i);
        } else if (this.f3787a.f3772h.f3806j != null) {
            this.f3787a.f3778n.setVisibility(0);
            this.f3787a.f3778n.setName(this.f3787a.f3772h.f3806j);
            this.f3787a.f3778n.setBackgroundColor(this.f3787a.f3772h.f3807k);
        } else {
            this.f3787a.f3778n.setVisibility(8);
        }
    }
}
