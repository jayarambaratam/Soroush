package com.akexorcist.roundcornerprogressbar.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.akexorcist.roundcornerprogressbar.common.c */
final class C0896c implements Creator<SavedState> {
    C0896c() {
    }

    public SavedState m5394a(Parcel parcel) {
        return new SavedState(null);
    }

    public SavedState[] m5395a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5394a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5395a(i);
    }
}
