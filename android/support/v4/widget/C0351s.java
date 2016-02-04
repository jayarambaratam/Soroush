package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* renamed from: android.support.v4.widget.s */
class C0351s extends Filter {
    C0334t f1702a;

    C0351s(C0334t c0334t) {
        this.f1702a = c0334t;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f1702a.convertToString((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.f1702a.runQueryOnBackgroundThread(charSequence);
        FilterResults filterResults = new FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor cursor = this.f1702a.getCursor();
        if (filterResults.values != null && filterResults.values != cursor) {
            this.f1702a.changeCursor((Cursor) filterResults.values);
        }
    }
}
