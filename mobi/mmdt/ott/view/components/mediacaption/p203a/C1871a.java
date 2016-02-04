package mobi.mmdt.ott.view.components.mediacaption.p203a;

import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.components.mediacaption.a.a */
public class C1871a extends C1712b {
    private ImageView f6030a;
    private FrameLayout f6031b;

    public C1871a(C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2) {
        super(layoutInflater, viewGroup, 2130968758, c1790i);
        this.f6030a = (ImageView) this.itemView.findViewById(2131689732);
        this.f6031b = (FrameLayout) this.itemView.findViewById(2131689696);
        LayoutParams layoutParams = (LayoutParams) this.f6030a.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        GridLayoutManager.LayoutParams layoutParams2 = (GridLayoutManager.LayoutParams) this.f6031b.getLayoutParams();
        layoutParams2.height = i2;
        layoutParams2.width = i;
    }

    protected void m9014a(C1722f c1722f) {
    }
}
