package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.widget.DrawerLayout.SavedState;

final class ab implements Creator<SavedState> {
    ab() {
    }

    public SavedState m3111a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m3112a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m3111a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m3112a(i);
    }
}
