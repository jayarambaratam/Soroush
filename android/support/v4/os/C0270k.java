package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.os.k */
class C0270k<T> implements Creator<T> {
    final C0065l<T> f1227a;

    public C0270k(C0065l<T> c0065l) {
        this.f1227a = c0065l;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f1227a.m187b(parcel, null);
    }

    public T[] newArray(int i) {
        return this.f1227a.m188b(i);
    }
}
