package mobi.mmdt.ott.view.components.mediaselector;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.mediaselector.p205a.C1889a;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1721e;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.g */
public class C1903g extends C1721e {
    final /* synthetic */ C1901e f6106a;

    public C1903g(C1901e c1901e, Context context) {
        this.f6106a = c1901e;
        super(context);
    }

    public C1712b m9093a(ViewGroup viewGroup, int i) {
        return new C1889a(this.f6106a.m979c(), null, m8654a(), viewGroup, this.f6106a.ae, this.f6106a.af);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m9093a(viewGroup, i);
    }
}
