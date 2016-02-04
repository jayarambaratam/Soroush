package com.akexorcist.roundcornerprogressbar;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.akexorcist.roundcornerprogressbar.k */
final class C0904k implements Creator<SavedState> {
    C0904k() {
    }

    public SavedState m5396a(Parcel parcel) {
        return new SavedState(null);
    }

    public SavedState[] m5397a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5396a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5397a(i);
    }
}
