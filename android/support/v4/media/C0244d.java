package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaBrowserCompat.MediaItem;

/* renamed from: android.support.v4.media.d */
final class C0244d implements Creator<MediaItem> {
    C0244d() {
    }

    public MediaItem m1747a(Parcel parcel) {
        return new MediaItem(null);
    }

    public MediaItem[] m1748a(int i) {
        return new MediaItem[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1747a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1748a(i);
    }
}
