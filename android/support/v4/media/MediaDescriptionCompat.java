package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR;
    private final String f1175a;
    private final CharSequence f1176b;
    private final CharSequence f1177c;
    private final CharSequence f1178d;
    private final Bitmap f1179e;
    private final Uri f1180f;
    private final Bundle f1181g;
    private final Uri f1182h;
    private Object f1183i;

    static {
        CREATOR = new C0245e();
    }

    private MediaDescriptionCompat(Parcel parcel) {
        this.f1175a = parcel.readString();
        this.f1176b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1177c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1178d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1179e = (Bitmap) parcel.readParcelable(null);
        this.f1180f = (Uri) parcel.readParcelable(null);
        this.f1181g = parcel.readBundle();
        this.f1182h = (Uri) parcel.readParcelable(null);
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f1175a = str;
        this.f1176b = charSequence;
        this.f1177c = charSequence2;
        this.f1178d = charSequence3;
        this.f1179e = bitmap;
        this.f1180f = uri;
        this.f1181g = bundle;
        this.f1182h = uri2;
    }

    public static MediaDescriptionCompat m1743a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        C0246f c0246f = new C0246f();
        c0246f.m1756a(C0247g.m1761a(obj));
        c0246f.m1755a(C0247g.m1763b(obj));
        c0246f.m1758b(C0247g.m1764c(obj));
        c0246f.m1759c(C0247g.m1765d(obj));
        c0246f.m1752a(C0247g.m1766e(obj));
        c0246f.m1753a(C0247g.m1767f(obj));
        c0246f.m1754a(C0247g.m1768g(obj));
        if (VERSION.SDK_INT >= 23) {
            c0246f.m1757b(C0249i.m1778h(obj));
        }
        MediaDescriptionCompat a = c0246f.m1751a();
        a.f1183i = obj;
        return a;
    }

    public Object m1744a() {
        if (this.f1183i != null || VERSION.SDK_INT < 21) {
            return this.f1183i;
        }
        Object a = C0248h.m1769a();
        C0248h.m1775a(a, this.f1175a);
        C0248h.m1774a(a, this.f1176b);
        C0248h.m1776b(a, this.f1177c);
        C0248h.m1777c(a, this.f1178d);
        C0248h.m1771a(a, this.f1179e);
        C0248h.m1772a(a, this.f1180f);
        C0248h.m1773a(a, this.f1181g);
        if (VERSION.SDK_INT >= 23) {
            C0250j.m1779b(a, this.f1182h);
        }
        this.f1183i = C0248h.m1770a(a);
        return this.f1183i;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f1176b + ", " + this.f1177c + ", " + this.f1178d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.f1175a);
            TextUtils.writeToParcel(this.f1176b, parcel, i);
            TextUtils.writeToParcel(this.f1177c, parcel, i);
            TextUtils.writeToParcel(this.f1178d, parcel, i);
            parcel.writeParcelable(this.f1179e, i);
            parcel.writeParcelable(this.f1180f, i);
            parcel.writeBundle(this.f1181g);
            return;
        }
        C0247g.m1762a(m1744a(), parcel, i);
    }
}
