package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.l */
final class C0252l implements Creator<RatingCompat> {
    C0252l() {
    }

    public RatingCompat m1782a(Parcel parcel) {
        return new RatingCompat(parcel.readFloat(), null);
    }

    public RatingCompat[] m1783a(int i) {
        return new RatingCompat[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1782a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1783a(i);
    }
}
