package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* renamed from: android.support.v4.os.m */
class C0271m<T> implements ClassLoaderCreator<T> {
    private final C0065l<T> f1228a;

    public C0271m(C0065l<T> c0065l) {
        this.f1228a = c0065l;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f1228a.m187b(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f1228a.m187b(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f1228a.m188b(i);
    }
}
