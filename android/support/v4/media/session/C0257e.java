package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.session.e */
final class C0257e implements Creator<ParcelableVolumeInfo> {
    C0257e() {
    }

    public ParcelableVolumeInfo m1791a(Parcel parcel) {
        return new ParcelableVolumeInfo(parcel);
    }

    public ParcelableVolumeInfo[] m1792a(int i) {
        return new ParcelableVolumeInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1791a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1792a(i);
    }
}
