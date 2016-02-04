package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class aw implements Creator<SavedState> {
    aw() {
    }

    public SavedState m3235a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m3236a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3235a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3236a(i);
    }
}
