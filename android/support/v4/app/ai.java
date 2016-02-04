package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ai implements Creator<FragmentState> {
    ai() {
    }

    public FragmentState m1037a(Parcel parcel) {
        return new FragmentState(parcel);
    }

    public FragmentState[] m1038a(int i) {
        return new FragmentState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1037a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1038a(i);
    }
}
