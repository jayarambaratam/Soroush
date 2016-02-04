package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

/* renamed from: android.support.v4.media.f */
public final class C0246f {
    private String f1191a;
    private CharSequence f1192b;
    private CharSequence f1193c;
    private CharSequence f1194d;
    private Bitmap f1195e;
    private Uri f1196f;
    private Bundle f1197g;
    private Uri f1198h;

    public MediaDescriptionCompat m1751a() {
        return new MediaDescriptionCompat(this.f1192b, this.f1193c, this.f1194d, this.f1195e, this.f1196f, this.f1197g, this.f1198h, null);
    }

    public C0246f m1752a(Bitmap bitmap) {
        this.f1195e = bitmap;
        return this;
    }

    public C0246f m1753a(Uri uri) {
        this.f1196f = uri;
        return this;
    }

    public C0246f m1754a(Bundle bundle) {
        this.f1197g = bundle;
        return this;
    }

    public C0246f m1755a(CharSequence charSequence) {
        this.f1192b = charSequence;
        return this;
    }

    public C0246f m1756a(String str) {
        this.f1191a = str;
        return this;
    }

    public C0246f m1757b(Uri uri) {
        this.f1198h = uri;
        return this;
    }

    public C0246f m1758b(CharSequence charSequence) {
        this.f1193c = charSequence;
        return this;
    }

    public C0246f m1759c(CharSequence charSequence) {
        this.f1194d = charSequence;
        return this;
    }
}
