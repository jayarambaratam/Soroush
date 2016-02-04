package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat.Token;

/* renamed from: android.support.v4.media.session.d */
final class C0256d implements Creator<Token> {
    C0256d() {
    }

    public Token m1789a(Parcel parcel) {
        return new Token(VERSION.SDK_INT >= 21 ? parcel.readParcelable(null) : parcel.readStrongBinder());
    }

    public Token[] m1790a(int i) {
        return new Token[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1789a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1790a(i);
    }
}
