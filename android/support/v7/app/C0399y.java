package android.support.v7.app;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

/* renamed from: android.support.v7.app.y */
class C0399y extends CursorAdapter {
    final /* synthetic */ ListView f1999a;
    final /* synthetic */ C0391q f2000b;
    final /* synthetic */ C0397w f2001c;
    private final int f2002d;
    private final int f2003e;

    C0399y(C0397w c0397w, Context context, Cursor cursor, boolean z, ListView listView, C0391q c0391q) {
        this.f2001c = c0397w;
        this.f1999a = listView;
        this.f2000b = c0391q;
        super(context, cursor, z);
        Cursor cursor2 = getCursor();
        this.f2002d = cursor2.getColumnIndexOrThrow(this.f2001c.f1966I);
        this.f2003e = cursor2.getColumnIndexOrThrow(this.f2001c.f1967J);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f2002d));
        this.f1999a.setItemChecked(cursor.getPosition(), cursor.getInt(this.f2003e) == 1);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2001c.f1972b.inflate(this.f2000b.f1913I, viewGroup, false);
    }
}
