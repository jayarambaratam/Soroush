package mobi.mmdt.ott.view.channel;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.channel.p182a.C1713a;
import mobi.mmdt.ott.view.channel.p182a.C1715c;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1721e;
import org.linphone.core.VideoSize;

public class ah extends C1721e {
    final /* synthetic */ ad f5689a;

    public ah(ad adVar, Context context) {
        this.f5689a = adVar;
        super(context);
    }

    public C1712b m8658a(ViewGroup viewGroup, int i) {
        switch (i) {
            case VideoSize.CIF /*1*/:
                return new C1715c(this.f5689a.getActivity(), null, m8654a(), viewGroup, this.f5689a);
            case VideoSize.HVGA /*2*/:
                return new C1713a(this.f5689a.getActivity(), null, m8654a(), viewGroup);
            default:
                return null;
        }
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m8658a(viewGroup, i);
    }
}
