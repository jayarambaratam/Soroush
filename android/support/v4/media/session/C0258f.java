package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.session.f */
final class C0258f implements Creator<PlaybackStateCompat> {
    C0258f() {
    }

    public PlaybackStateCompat m1793a(Parcel parcel) {
        return new PlaybackStateCompat(null);
    }

    public PlaybackStateCompat[] m1794a(int i) {
        return new PlaybackStateCompat[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1793a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1794a(i);
    }
}
