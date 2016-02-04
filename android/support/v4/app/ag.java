package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ag implements Creator<FragmentManagerState> {
    ag() {
    }

    public FragmentManagerState m1024a(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }

    public FragmentManagerState[] m1025a(int i) {
        return new FragmentManagerState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1024a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1025a(i);
    }
}
