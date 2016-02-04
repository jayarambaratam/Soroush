package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR;
    final String f781a;
    final int f782b;
    final boolean f783c;
    final int f784d;
    final int f785e;
    final String f786f;
    final boolean f787g;
    final boolean f788h;
    final Bundle f789i;
    Bundle f790j;
    Fragment f791k;

    static {
        CREATOR = new ai();
    }

    public FragmentState(Parcel parcel) {
        boolean z = true;
        this.f781a = parcel.readString();
        this.f782b = parcel.readInt();
        this.f783c = parcel.readInt() != 0;
        this.f784d = parcel.readInt();
        this.f785e = parcel.readInt();
        this.f786f = parcel.readString();
        this.f787g = parcel.readInt() != 0;
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.f788h = z;
        this.f789i = parcel.readBundle();
        this.f790j = parcel.readBundle();
    }

    public FragmentState(Fragment fragment) {
        this.f781a = fragment.getClass().getName();
        this.f782b = fragment.f758g;
        this.f783c = fragment.f767p;
        this.f784d = fragment.f775x;
        this.f785e = fragment.f776y;
        this.f786f = fragment.f777z;
        this.f787g = fragment.f729C;
        this.f788h = fragment.f728B;
        this.f789i = fragment.f760i;
    }

    public Fragment m1016a(C0147w c0147w, Fragment fragment) {
        if (this.f791k != null) {
            return this.f791k;
        }
        Context g = c0147w.m1328g();
        if (this.f789i != null) {
            this.f789i.setClassLoader(g.getClassLoader());
        }
        this.f791k = Fragment.m942a(g, this.f781a, this.f789i);
        if (this.f790j != null) {
            this.f790j.setClassLoader(g.getClassLoader());
            this.f791k.f756e = this.f790j;
        }
        this.f791k.m956a(this.f782b, fragment);
        this.f791k.f767p = this.f783c;
        this.f791k.f769r = true;
        this.f791k.f775x = this.f784d;
        this.f791k.f776y = this.f785e;
        this.f791k.f777z = this.f786f;
        this.f791k.f729C = this.f787g;
        this.f791k.f728B = this.f788h;
        this.f791k.f771t = c0147w.f1001d;
        if (C0153z.f1017a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f791k);
        }
        return this.f791k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f781a);
        parcel.writeInt(this.f782b);
        parcel.writeInt(this.f783c ? 1 : 0);
        parcel.writeInt(this.f784d);
        parcel.writeInt(this.f785e);
        parcel.writeString(this.f786f);
        parcel.writeInt(this.f787g ? 1 : 0);
        if (!this.f788h) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.f789i);
        parcel.writeBundle(this.f790j);
    }
}
