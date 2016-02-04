package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR;
    final boolean f1168c;
    final Handler f1169d;
    C0265f f1170e;

    static {
        CREATOR = new C0273o();
    }

    ResultReceiver(Parcel parcel) {
        this.f1168c = false;
        this.f1169d = null;
        this.f1170e = C0266g.m1807a(parcel.readStrongBinder());
    }

    protected void m1741a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f1170e == null) {
                this.f1170e = new C0274p(this);
            }
            parcel.writeStrongBinder(this.f1170e.asBinder());
        }
    }
}
