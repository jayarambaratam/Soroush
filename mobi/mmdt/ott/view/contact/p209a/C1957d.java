package mobi.mmdt.ott.view.contact.p209a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1721e;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.contact.p209a.p211b.C1945a;
import mobi.mmdt.ott.view.contact.p209a.p211b.C1948d;
import mobi.mmdt.ott.view.contact.p209a.p211b.C1950f;
import mobi.mmdt.ott.view.contact.p209a.p212c.C1953b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.contact.a.d */
public class C1957d extends C1721e {
    final /* synthetic */ C1944a f6288a;

    public C1957d(C1944a c1944a, Context context) {
        this.f6288a = c1944a;
        super(context);
    }

    public C1712b m9277a(ViewGroup viewGroup, int i) {
        switch (i) {
            case VideoSize.CIF /*1*/:
                return new C1945a(this.f6288a.getActivity(), null, m8654a(), viewGroup, this.f6288a);
            case VideoSize.HVGA /*2*/:
                return new C1948d(this.f6288a.getActivity(), null, m8654a(), viewGroup);
            case Version.API03_CUPCAKE_15 /*3*/:
                return new C1950f(this.f6288a.getActivity(), null, m8654a(), viewGroup);
            default:
                return null;
        }
    }

    public void m9278a(int i, int i2) {
        C1953b c1953b = (C1953b) this.b.remove(i);
        if (i2 > this.b.size()) {
            i2--;
        }
        this.b.add(i2, c1953b);
        notifyItemMoved(i, i2);
    }

    public void m9279a(C1712b c1712b, int i) {
        C1722f c1722f = (C1722f) this.b.get(i);
        if (c1712b.getItemViewType() == 1) {
            C1953b c1953b = (C1953b) c1722f;
            boolean containsKey = this.f6288a.m9240a().containsKey(c1953b.m9266j());
            if (containsKey) {
                c1953b.m9260b(((Boolean) this.f6288a.m9240a().get(c1953b.m9266j())).booleanValue());
            } else {
                c1953b.m9260b(true);
            }
            c1953b.m9258a(containsKey);
        } else if (c1712b.getItemViewType() == 2) {
            this.f6288a.f6239f.m9269a(this.f6288a.m9240a().size());
        }
        super.m8657a(c1712b, i);
    }

    public int m9280b(int i) {
        int i2 = 0;
        while (i2 < this.b.size()) {
            if ((this.b.get(i2) instanceof C1953b) && ((C1953b) this.b.get(i2)).m9261c() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        m9279a((C1712b) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m9277a(viewGroup, i);
    }
}
