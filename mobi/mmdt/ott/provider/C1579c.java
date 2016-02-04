package mobi.mmdt.ott.provider;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;

/* renamed from: mobi.mmdt.ott.provider.c */
public abstract class C1579c extends CursorLoader implements C1578b {
    public C1579c(Context context, Uri uri, Uri... uriArr) {
        super(context);
        setUri(uri);
        C1571a c1571a = new C1571a(context, this, uriArr);
    }

    protected abstract Cursor m7955a();

    public void m7956a(boolean z) {
        onContentChanged();
    }

    public Cursor loadInBackground() {
        return m7955a();
    }
}
