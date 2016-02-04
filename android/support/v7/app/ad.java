package android.support.v7.app;

import android.content.Context;
import android.widget.ArrayAdapter;

class ad extends ArrayAdapter<CharSequence> {
    public ad(Context context, int i, int i2, CharSequence[] charSequenceArr) {
        super(context, i, i2, charSequenceArr);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }
}
