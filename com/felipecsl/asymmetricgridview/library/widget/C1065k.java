package com.felipecsl.asymmetricgridview.library.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.felipecsl.asymmetricgridview.library.widget.k */
final class C1065k implements Creator<RowInfo> {
    C1065k() {
    }

    public RowInfo m6299a(Parcel parcel) {
        return new RowInfo(parcel);
    }

    public RowInfo[] m6300a(int i) {
        return new RowInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6299a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6300a(i);
    }
}
