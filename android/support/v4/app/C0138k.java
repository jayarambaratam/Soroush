package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.app.k */
final class C0138k implements Creator<BackStackState> {
    C0138k() {
    }

    public BackStackState m1293a(Parcel parcel) {
        return new BackStackState(parcel);
    }

    public BackStackState[] m1294a(int i) {
        return new BackStackState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1293a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1294a(i);
    }
}
