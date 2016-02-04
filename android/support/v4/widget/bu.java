package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class bu implements Creator<SavedState> {
    bu() {
    }

    public SavedState m3335a(Parcel parcel) {
        return new SavedState(null);
    }

    public SavedState[] m3336a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3335a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3336a(i);
    }
}
