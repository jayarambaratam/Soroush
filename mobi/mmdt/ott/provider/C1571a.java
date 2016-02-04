package mobi.mmdt.ott.provider;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;

/* renamed from: mobi.mmdt.ott.provider.a */
public class C1571a extends ContentObserver {
    private C1578b f5264a;

    public C1571a(Context context, C1578b c1578b, Uri... uriArr) {
        super(null);
        this.f5264a = c1578b;
        for (Uri registerContentObserver : uriArr) {
            context.getContentResolver().registerContentObserver(registerContentObserver, false, this);
        }
    }

    public void onChange(boolean z) {
        super.onChange(z);
        this.f5264a.m7954a(z);
    }
}
