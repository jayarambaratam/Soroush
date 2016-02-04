package mobi.mmdt.ott.view.components.fileselector;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.fileselector.p198a.C1803a;
import mobi.mmdt.ott.view.components.fileselector.p198a.C1805c;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1721e;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.view.components.fileselector.f */
public class C1815f extends C1721e {
    final /* synthetic */ C1811b f5837a;

    public C1815f(C1811b c1811b, Context context) {
        this.f5837a = c1811b;
        super(context);
    }

    public C1712b m8822a(ViewGroup viewGroup, int i) {
        switch (i) {
            case VideoSize.CIF /*1*/:
                return new C1803a(this.f5837a.getActivity(), this.f5837a, m8654a(), viewGroup, this.f5837a);
            case VideoSize.HVGA /*2*/:
                return new C1805c(this.f5837a.getActivity(), this.f5837a, m8654a(), viewGroup);
            default:
                return null;
        }
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m8822a(viewGroup, i);
    }
}
