package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.os.ResultReceiver;

class MediaBrowserCompat$MediaBrowserImplBase$3 extends ResultReceiver {
    final /* synthetic */ C0242b f1171a;
    final /* synthetic */ String f1172b;

    protected void m1742a(int i, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("media_item")) {
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable instanceof MediaItem) {
                this.a.m1745a((MediaItem) parcelable);
                return;
            } else {
                this.a.m1746a(this.b);
                return;
            }
        }
        this.a.m1746a(this.b);
    }
}
