package com.felipecsl.asymmetricgridview.library;

import android.os.Handler;
import android.os.Message;
import org.linphone.core.VideoSize;

/* renamed from: com.felipecsl.asymmetricgridview.library.h */
class C1048h extends Handler {
    private C1048h() {
    }

    public void handleMessage(Message message) {
        C1047g c1047g = (C1047g) message.obj;
        switch (message.what) {
            case VideoSize.CIF /*1*/:
                c1047g.f3937a.m6230e(c1047g.f3938b[0]);
            case VideoSize.HVGA /*2*/:
                c1047g.f3937a.m6238b(c1047g.f3938b);
            default:
        }
    }
}
