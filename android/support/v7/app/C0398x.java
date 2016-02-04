package android.support.v7.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/* renamed from: android.support.v7.app.x */
class C0398x extends ArrayAdapter<CharSequence> {
    final /* synthetic */ ListView f1997a;
    final /* synthetic */ C0397w f1998b;

    C0398x(C0397w c0397w, Context context, int i, int i2, CharSequence[] charSequenceArr, ListView listView) {
        this.f1998b = c0397w;
        this.f1997a = listView;
        super(context, i, i2, charSequenceArr);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (this.f1998b.f1960C != null && this.f1998b.f1960C[i]) {
            this.f1997a.setItemChecked(i, true);
        }
        return view2;
    }
}
