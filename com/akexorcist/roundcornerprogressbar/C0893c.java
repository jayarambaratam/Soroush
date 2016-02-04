package com.akexorcist.roundcornerprogressbar;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.akexorcist.roundcornerprogressbar.c */
final class C0893c implements Creator<SavedState> {
    C0893c() {
    }

    public SavedState m5391a(Parcel parcel) {
        return new SavedState(null);
    }

    public SavedState[] m5392a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5391a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5392a(i);
    }
}
