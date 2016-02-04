package android.support.v13.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v13.app.k */
final class C0111k implements Creator<SavedState> {
    C0111k() {
    }

    public SavedState m891a(Parcel parcel) {
        return new SavedState(null);
    }

    public SavedState[] m892a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m891a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m892a(i);
    }
}
