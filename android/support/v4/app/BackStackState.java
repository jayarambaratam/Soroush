package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR;
    final int[] f714a;
    final int f715b;
    final int f716c;
    final String f717d;
    final int f718e;
    final int f719f;
    final CharSequence f720g;
    final int f721h;
    final CharSequence f722i;
    final ArrayList<String> f723j;
    final ArrayList<String> f724k;

    static {
        CREATOR = new C0138k();
    }

    public BackStackState(Parcel parcel) {
        this.f714a = parcel.createIntArray();
        this.f715b = parcel.readInt();
        this.f716c = parcel.readInt();
        this.f717d = parcel.readString();
        this.f718e = parcel.readInt();
        this.f719f = parcel.readInt();
        this.f720g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f721h = parcel.readInt();
        this.f722i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f723j = parcel.createStringArrayList();
        this.f724k = parcel.createStringArrayList();
    }

    public BackStackState(C0132e c0132e) {
        int i = 0;
        for (C0136i c0136i = c0132e.f939c; c0136i != null; c0136i = c0136i.f974a) {
            if (c0136i.f982i != null) {
                i += c0136i.f982i.size();
            }
        }
        this.f714a = new int[(i + (c0132e.f941e * 7))];
        if (c0132e.f948l) {
            i = 0;
            for (C0136i c0136i2 = c0132e.f939c; c0136i2 != null; c0136i2 = c0136i2.f974a) {
                int i2 = i + 1;
                this.f714a[i] = c0136i2.f976c;
                int i3 = i2 + 1;
                this.f714a[i2] = c0136i2.f977d != null ? c0136i2.f977d.f758g : -1;
                int i4 = i3 + 1;
                this.f714a[i3] = c0136i2.f978e;
                i2 = i4 + 1;
                this.f714a[i4] = c0136i2.f979f;
                i4 = i2 + 1;
                this.f714a[i2] = c0136i2.f980g;
                i2 = i4 + 1;
                this.f714a[i4] = c0136i2.f981h;
                if (c0136i2.f982i != null) {
                    int size = c0136i2.f982i.size();
                    i4 = i2 + 1;
                    this.f714a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f714a[i4] = ((Fragment) c0136i2.f982i.get(i2)).f758g;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f714a[i2] = 0;
                }
            }
            this.f715b = c0132e.f946j;
            this.f716c = c0132e.f947k;
            this.f717d = c0132e.f950n;
            this.f718e = c0132e.f952p;
            this.f719f = c0132e.f953q;
            this.f720g = c0132e.f954r;
            this.f721h = c0132e.f955s;
            this.f722i = c0132e.f956t;
            this.f723j = c0132e.f957u;
            this.f724k = c0132e.f958v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0132e m940a(C0153z c0153z) {
        C0132e c0132e = new C0132e(c0153z);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f714a.length) {
            C0136i c0136i = new C0136i();
            int i3 = i2 + 1;
            c0136i.f976c = this.f714a[i2];
            if (C0153z.f1017a) {
                Log.v("FragmentManager", "Instantiate " + c0132e + " op #" + i + " base fragment #" + this.f714a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f714a[i3];
            if (i2 >= 0) {
                c0136i.f977d = (Fragment) c0153z.f1023f.get(i2);
            } else {
                c0136i.f977d = null;
            }
            i3 = i4 + 1;
            c0136i.f978e = this.f714a[i4];
            i4 = i3 + 1;
            c0136i.f979f = this.f714a[i3];
            i3 = i4 + 1;
            c0136i.f980g = this.f714a[i4];
            int i5 = i3 + 1;
            c0136i.f981h = this.f714a[i3];
            i4 = i5 + 1;
            int i6 = this.f714a[i5];
            if (i6 > 0) {
                c0136i.f982i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (C0153z.f1017a) {
                        Log.v("FragmentManager", "Instantiate " + c0132e + " set remove fragment #" + this.f714a[i4]);
                    }
                    i5 = i4 + 1;
                    c0136i.f982i.add((Fragment) c0153z.f1023f.get(this.f714a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            c0132e.m1284a(c0136i);
            i++;
            i2 = i4;
        }
        c0132e.f946j = this.f715b;
        c0132e.f947k = this.f716c;
        c0132e.f950n = this.f717d;
        c0132e.f952p = this.f718e;
        c0132e.f948l = true;
        c0132e.f953q = this.f719f;
        c0132e.f954r = this.f720g;
        c0132e.f955s = this.f721h;
        c0132e.f956t = this.f722i;
        c0132e.f957u = this.f723j;
        c0132e.f958v = this.f724k;
        c0132e.m1283a(1);
        return c0132e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f714a);
        parcel.writeInt(this.f715b);
        parcel.writeInt(this.f716c);
        parcel.writeString(this.f717d);
        parcel.writeInt(this.f718e);
        parcel.writeInt(this.f719f);
        TextUtils.writeToParcel(this.f720g, parcel, 0);
        parcel.writeInt(this.f721h);
        TextUtils.writeToParcel(this.f722i, parcel, 0);
        parcel.writeStringList(this.f723j);
        parcel.writeStringList(this.f724k);
    }
}
