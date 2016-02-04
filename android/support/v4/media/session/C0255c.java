package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.session.c */
final class C0255c implements Creator<ResultReceiverWrapper> {
    C0255c() {
    }

    public ResultReceiverWrapper m1787a(Parcel parcel) {
        return new ResultReceiverWrapper(parcel);
    }

    public ResultReceiverWrapper[] m1788a(int i) {
        return new ResultReceiverWrapper[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1787a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1788a(i);
    }
}
