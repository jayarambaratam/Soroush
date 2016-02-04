package android.support.v7.app;

import android.app.Notification.MediaStyle;
import android.media.session.MediaSession.Token;
import android.support.v4.app.bg;

class bp {
    public static void m3674a(bg bgVar, int[] iArr, Object obj) {
        MediaStyle mediaStyle = new MediaStyle(bgVar.m1145a());
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        if (obj != null) {
            mediaStyle.setMediaSession((Token) obj);
        }
    }
}
