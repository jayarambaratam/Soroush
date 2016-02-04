package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class al implements Creator<SavedState> {
    al() {
    }

    public SavedState m1048a(Parcel parcel) {
        return new SavedState(null);
    }

    public SavedState[] m1049a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1048a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1049a(i);
    }
}
