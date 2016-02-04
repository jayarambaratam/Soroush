package mobi.mmdt.ott.view.conversation.emojisticker.sticker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;

public class StickerItemViewModel implements AsymmetricItem {
    public static final Creator<StickerItemViewModel> CREATOR;
    private int f7305a;
    private int f7306b;
    private int f7307c;
    private int f7308d;
    private int f7309e;
    private int f7310f;
    private int f7311g;
    private String f7312h;
    private String f7313i;
    private String f7314j;

    static {
        CREATOR = new C2229i();
    }

    public StickerItemViewModel(int i, int i2, int i3, String str, int i4, int i5, int i6, int i7, String str2, String str3) {
        this.f7311g = i;
        this.f7305a = i3;
        this.f7306b = i4;
        this.f7307c = i5;
        this.f7308d = i6;
        this.f7309e = i7;
        this.f7310f = i2;
        this.f7312h = str;
        this.f7313i = str2;
        this.f7314j = str3;
    }

    public StickerItemViewModel(Parcel parcel) {
        m10100a(parcel);
    }

    private void m10100a(Parcel parcel) {
        this.f7305a = parcel.readInt() + 1;
        this.f7306b = parcel.readInt();
        this.f7307c = parcel.readInt();
        this.f7308d = parcel.readInt();
        this.f7309e = parcel.readInt();
        this.f7310f = parcel.readInt();
        this.f7311g = parcel.readInt();
        this.f7312h = parcel.readString();
        this.f7313i = parcel.readString();
        this.f7314j = parcel.readString();
    }

    public int m10101a() {
        return m10103c();
    }

    public int m10102b() {
        return m10106f();
    }

    public int m10103c() {
        return this.f7307c;
    }

    public int m10104d() {
        return this.f7305a;
    }

    public int describeContents() {
        return 0;
    }

    public String m10105e() {
        return this.f7314j;
    }

    public int m10106f() {
        return this.f7306b;
    }

    public int m10107g() {
        return this.f7310f;
    }

    public int m10108h() {
        return m10104d() - 1;
    }

    public int m10109i() {
        return this.f7311g;
    }

    public String m10110j() {
        return this.f7312h;
    }

    public String toString() {
        return String.format("%s: %sx%s", new Object[]{Integer.valueOf(m10108h()), Integer.valueOf(m10102b()), Integer.valueOf(m10101a())});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7305a - 1);
        parcel.writeInt(this.f7306b);
        parcel.writeInt(this.f7307c);
        parcel.writeInt(this.f7308d);
        parcel.writeInt(this.f7309e);
        parcel.writeInt(this.f7310f);
        parcel.writeInt(this.f7311g);
        parcel.writeString(this.f7312h);
        parcel.writeString(this.f7313i);
        parcel.writeString(this.f7314j);
    }
}
