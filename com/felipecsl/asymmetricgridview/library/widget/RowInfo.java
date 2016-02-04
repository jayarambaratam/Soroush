package com.felipecsl.asymmetricgridview.library.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;
import java.util.ArrayList;
import java.util.List;

class RowInfo<T extends AsymmetricItem> implements Parcelable {
    public static final Creator<RowInfo> CREATOR;
    private final List<T> f3966a;
    private final int f3967b;
    private final float f3968c;

    static {
        CREATOR = new C1065k();
    }

    public RowInfo(int i, List<T> list, float f) {
        this.f3967b = i;
        this.f3966a = list;
        this.f3968c = f;
    }

    public RowInfo(Parcel parcel) {
        this.f3967b = parcel.readInt();
        this.f3968c = parcel.readFloat();
        int readInt = parcel.readInt();
        this.f3966a = new ArrayList();
        ClassLoader classLoader = AsymmetricItem.class.getClassLoader();
        for (int i = 0; i < readInt; i++) {
            this.f3966a.add((AsymmetricItem) parcel.readParcelable(classLoader));
        }
    }

    public List<T> m6252a() {
        return this.f3966a;
    }

    public int m6253b() {
        return this.f3967b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3967b);
        parcel.writeFloat(this.f3968c);
        parcel.writeInt(this.f3966a.size());
        for (int i2 = 0; i2 < this.f3966a.size(); i2++) {
            parcel.writeParcelable((Parcelable) this.f3966a.get(i2), 0);
        }
    }
}
