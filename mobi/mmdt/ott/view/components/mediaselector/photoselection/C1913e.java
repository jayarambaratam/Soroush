package mobi.mmdt.ott.view.components.mediaselector.photoselection;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.mediaselector.p205a.C1890b;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1721e;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.photoselection.e */
public class C1913e extends C1721e {
    final /* synthetic */ C1911c f6137a;

    public C1913e(C1911c c1911c, Context context) {
        this.f6137a = c1911c;
        super(context);
    }

    public C1712b m9142a(ViewGroup viewGroup, int i) {
        return new C1890b(this.f6137a.getActivity(), this.f6137a, m8654a(), viewGroup, this.f6137a.f6126e, this.f6137a.f6127f, this.f6137a);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m9142a(viewGroup, i);
    }
}
