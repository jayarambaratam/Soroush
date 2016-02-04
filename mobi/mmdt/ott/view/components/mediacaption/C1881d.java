package mobi.mmdt.ott.view.components.mediacaption;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.mediacaption.p203a.C1871a;
import mobi.mmdt.ott.view.components.mediacaption.p203a.C1872b;
import mobi.mmdt.ott.view.components.mediacaption.p204b.C1878b;
import mobi.mmdt.ott.view.components.mediacaption.p204b.C1879c;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1721e;

/* renamed from: mobi.mmdt.ott.view.components.mediacaption.d */
class C1881d extends C1721e {
    final /* synthetic */ C1876a f6051a;

    public C1881d(C1876a c1876a, Context context) {
        this.f6051a = c1876a;
        super(context);
    }

    public C1712b m9032a(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new C1872b(this.f6051a.getActivity(), this.f6051a, m8654a(), viewGroup, this.f6051a.f6044e, this.f6051a.f6045f, this.f6051a);
        } else if (i != 2) {
            return null;
        } else {
            return new C1871a(this.f6051a, m8654a(), viewGroup, this.f6051a.f6044e, this.f6051a.f6045f);
        }
    }

    public void m9033a(C1712b c1712b, int i) {
        if (c1712b.getItemViewType() == 1) {
            C1879c c1879c = (C1879c) this.b.get(i);
            String l = ((MediaCaptionActivity) this.f6051a.getActivity()).m9013l();
            if (l == null || !c1879c.m9029a().equals(l)) {
                c1879c.m9030a(false);
            } else {
                c1879c.m9030a(true);
            }
        }
        super.m8657a(c1712b, i);
    }

    public void m9034a(C1879c c1879c) {
        int i = 0;
        while (i < this.b.size()) {
            if ((this.b.get(i) instanceof C1879c) && ((C1879c) this.b.get(i)).m9029a().equals(c1879c.m9029a())) {
                break;
            }
            i++;
        }
        i = 0;
        this.b.remove(i);
        notifyItemRemoved(i);
        if (this.b.size() < this.f6051a.f6046g && !(this.b.get(this.b.size() - 1) instanceof C1878b)) {
            int size = this.b.size();
            this.b.add(new C1878b(size));
            notifyItemInserted(size);
        }
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        m9033a((C1712b) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m9032a(viewGroup, i);
    }
}
