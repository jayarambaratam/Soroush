package android.support.v4.media;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.e */
final class C0245e implements Creator<MediaDescriptionCompat> {
    C0245e() {
    }

    public MediaDescriptionCompat m1749a(Parcel parcel) {
        return VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(null) : MediaDescriptionCompat.m1743a(C0247g.m1760a(parcel));
    }

    public MediaDescriptionCompat[] m1750a(int i) {
        return new MediaDescriptionCompat[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1749a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1750a(i);
    }
}
