package com.astuetz;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.astuetz.e */
final class C0912e implements Creator<SavedState> {
    C0912e() {
    }

    public SavedState m5414a(Parcel parcel) {
        return new SavedState(null);
    }

    public SavedState[] m5415a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5414a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5415a(i);
    }
}
