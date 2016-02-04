package android.support.v4.app;

import android.app.Notification;

class bs implements bp {
    bs() {
    }

    public Notification m1193a(bm bmVar, bn bnVar) {
        Notification notification = bmVar.f883B;
        notification.setLatestEventInfo(bmVar.f885a, bmVar.f886b, bmVar.f887c, bmVar.f888d);
        if (bmVar.f894j > 0) {
            notification.flags |= 128;
        }
        return notification;
    }
}
