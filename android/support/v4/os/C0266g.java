package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.linphone.core.VideoSize;

/* renamed from: android.support.v4.os.g */
public abstract class C0266g extends Binder implements C0265f {
    public C0266g() {
        attachInterface(this, "android.support.v4.os.IResultReceiver");
    }

    public static C0265f m1807a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0265f)) ? new C0267h(iBinder) : (C0265f) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case VideoSize.CIF /*1*/:
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                m1806a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 1598968902:
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
