package com.pnikosis.materialishprogress;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.pnikosis.materialishprogress.c */
final class C1094c implements Creator<WheelSavedState> {
    C1094c() {
    }

    public WheelSavedState m6356a(Parcel parcel) {
        return new WheelSavedState(null);
    }

    public WheelSavedState[] m6357a(int i) {
        return new WheelSavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6356a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6357a(i);
    }
}
