package mobi.mmdt.ott.view.components.p181b;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* renamed from: mobi.mmdt.ott.view.components.b.g */
class C1789g extends Filter {
    C1784h f5779a;

    C1789g(C1784h c1784h) {
        this.f5779a = c1784h;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f5779a.m8738a((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f5779a.m8737a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor b = this.f5779a.m8739b();
        if (filterResults.values != null && filterResults.values != b) {
            this.f5779a.m8740b((Cursor) filterResults.values);
        }
    }
}
