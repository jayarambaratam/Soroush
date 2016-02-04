package android.support.v4.app;

import android.app.Notification;

class bt extends bs {
    bt() {
    }

    public Notification m1198a(bm bmVar, bn bnVar) {
        Notification notification = bmVar.f883B;
        notification.setLatestEventInfo(bmVar.f885a, bmVar.f886b, bmVar.f887c, bmVar.f888d);
        notification = cg.m1209a(notification, bmVar.f885a, bmVar.f886b, bmVar.f887c, bmVar.f888d, bmVar.f889e);
        if (bmVar.f894j > 0) {
            notification.flags |= 128;
        }
        return notification;
    }
}
