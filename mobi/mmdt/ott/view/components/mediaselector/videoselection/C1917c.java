package mobi.mmdt.ott.view.components.mediaselector.videoselection;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.mediaselector.p205a.C1892d;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1721e;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.videoselection.c */
public class C1917c extends C1721e {
    final /* synthetic */ C1915a f6150a;

    public C1917c(C1915a c1915a, Context context) {
        this.f6150a = c1915a;
        super(context);
    }

    public C1712b m9152a(ViewGroup viewGroup, int i) {
        return new C1892d(this.f6150a.getActivity(), this.f6150a, m8654a(), viewGroup, this.f6150a.f6143e, this.f6150a.f6144f);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m9152a(viewGroup, i);
    }
}
