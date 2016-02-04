package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment.SavedState;

/* renamed from: android.support.v4.app.p */
final class C0144p implements Creator<SavedState> {
    C0144p() {
    }

    public SavedState m1300a(Parcel parcel) {
        return new SavedState(parcel, null);
    }

    public SavedState[] m1301a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1300a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1301a(i);
    }
}
