package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.k */
final class C0251k implements Creator<MediaMetadataCompat> {
    C0251k() {
    }

    public MediaMetadataCompat m1780a(Parcel parcel) {
        return new MediaMetadataCompat(null);
    }

    public MediaMetadataCompat[] m1781a(int i) {
        return new MediaMetadataCompat[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1780a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1781a(i);
    }
}
