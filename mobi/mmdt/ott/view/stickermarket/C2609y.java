package mobi.mmdt.ott.view.stickermarket;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1721e;
import mobi.mmdt.ott.view.stickermarket.p249a.C2570a;
import mobi.mmdt.ott.view.stickermarket.p249a.C2572c;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.view.stickermarket.y */
public class C2609y extends C1721e {
    final /* synthetic */ C2594r f8342a;

    public C2609y(C2594r c2594r, Context context) {
        this.f8342a = c2594r;
        super(context);
    }

    public C1712b m11059a(ViewGroup viewGroup, int i) {
        switch (i) {
            case VideoSize.CIF /*1*/:
                return new C2572c(this.f8342a.getActivity(), this.f8342a, m8654a(), viewGroup);
            case VideoSize.HVGA /*2*/:
                return new C2570a(this.f8342a.getActivity(), this.f8342a, m8654a(), viewGroup);
            default:
                return null;
        }
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m11059a(viewGroup, i);
    }
}
