package com.felipecsl.asymmetricgridview.library.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView.SavedState;

/* renamed from: com.felipecsl.asymmetricgridview.library.widget.c */
final class C1057c implements Creator<SavedState> {
    C1057c() {
    }

    public SavedState m6267a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m6268a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6267a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6268a(i);
    }
}
