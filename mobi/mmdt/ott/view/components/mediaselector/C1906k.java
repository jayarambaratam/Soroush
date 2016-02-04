package mobi.mmdt.ott.view.components.mediaselector;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.mediaselector.p205a.C1889a;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1721e;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.k */
public class C1906k extends C1721e {
    final /* synthetic */ C1904i f6109a;

    public C1906k(C1904i c1904i, Context context) {
        this.f6109a = c1904i;
        super(context);
    }

    public C1712b m9108a(ViewGroup viewGroup, int i) {
        return new C1889a(this.f6109a.m979c(), null, m8654a(), viewGroup, this.f6109a.ae, this.f6109a.af);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m9108a(viewGroup, i);
    }
}
