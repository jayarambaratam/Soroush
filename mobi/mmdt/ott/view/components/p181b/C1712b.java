package mobi.mmdt.ott.view.components.p181b;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/* renamed from: mobi.mmdt.ott.view.components.b.b */
public abstract class C1712b extends ViewHolder {
    private C1722f f5647a;
    private C1790i f5648b;

    public C1712b(LayoutInflater layoutInflater, ViewGroup viewGroup, int i, C1790i c1790i) {
        super(layoutInflater.inflate(i, viewGroup, false));
        this.f5648b = c1790i;
        if (this.f5648b != null) {
            this.itemView.setOnClickListener(new C1787c(this));
            this.itemView.setOnLongClickListener(new C1788d(this));
        }
    }

    public C1722f m8619a() {
        return this.f5647a;
    }

    protected abstract void m8620a(C1722f c1722f);

    public void m8621b(C1722f c1722f) {
        this.f5647a = c1722f;
        m8620a(c1722f);
    }
}
