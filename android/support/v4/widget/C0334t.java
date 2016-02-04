package android.support.v4.widget;

import android.database.Cursor;

/* renamed from: android.support.v4.widget.t */
interface C0334t {
    void changeCursor(Cursor cursor);

    CharSequence convertToString(Cursor cursor);

    Cursor getCursor();

    Cursor runQueryOnBackgroundThread(CharSequence charSequence);
}
