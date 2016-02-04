package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.os.o */
final class C0273o implements Creator<ResultReceiver> {
    C0273o() {
    }

    public ResultReceiver m1811a(Parcel parcel) {
        return new ResultReceiver(parcel);
    }

    public ResultReceiver[] m1812a(int i) {
        return new ResultReceiver[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1811a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1812a(i);
    }
}
