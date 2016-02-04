package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR;
    public int f1203a;
    public int f1204b;
    public int f1205c;
    public int f1206d;
    public int f1207e;

    static {
        CREATOR = new C0257e();
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f1203a = parcel.readInt();
        this.f1205c = parcel.readInt();
        this.f1206d = parcel.readInt();
        this.f1207e = parcel.readInt();
        this.f1204b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1203a);
        parcel.writeInt(this.f1205c);
        parcel.writeInt(this.f1206d);
        parcel.writeInt(this.f1207e);
        parcel.writeInt(this.f1204b);
    }
}
