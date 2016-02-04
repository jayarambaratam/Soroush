package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.PlaybackStateCompat.CustomAction;

/* renamed from: android.support.v4.media.session.g */
final class C0259g implements Creator<CustomAction> {
    C0259g() {
    }

    public CustomAction m1795a(Parcel parcel) {
        return new CustomAction(null);
    }

    public CustomAction[] m1796a(int i) {
        return new CustomAction[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1795a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1796a(i);
    }
}
