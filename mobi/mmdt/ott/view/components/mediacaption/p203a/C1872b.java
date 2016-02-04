package mobi.mmdt.ott.view.components.mediacaption.p203a;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.p032a.p033a.C0872i;
import mobi.mmdt.ott.view.components.mediacaption.C1875j;
import mobi.mmdt.ott.view.components.mediacaption.p204b.C1879c;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.components.mediacaption.a.b */
public class C1872b extends C1712b {
    private Activity f6032a;
    private ImageView f6033b;
    private ImageButton f6034c;
    private FrameLayout f6035d;
    private FrameLayout f6036e;
    private C1875j f6037f;

    public C1872b(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1875j c1875j) {
        super(layoutInflater, viewGroup, 2130968759, c1790i);
        this.f6032a = activity;
        this.f6033b = (ImageView) this.itemView.findViewById(2131689732);
        this.f6034c = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6035d = (FrameLayout) this.itemView.findViewById(2131689696);
        this.f6036e = (FrameLayout) this.itemView.findViewById(2131689900);
        LayoutParams layoutParams = (LayoutParams) this.f6033b.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        GridLayoutManager.LayoutParams layoutParams2 = (GridLayoutManager.LayoutParams) this.f6035d.getLayoutParams();
        layoutParams2.height = i2;
        layoutParams2.width = i;
        this.f6037f = c1875j;
        this.f6034c.setOnClickListener(new C1873c(this));
        this.f6033b.setOnClickListener(new C1874d(this));
    }

    protected void m9016a(C1722f c1722f) {
        C1879c c1879c = (C1879c) c1722f;
        this.f6033b.setImageBitmap(null);
        if (c1879c.m9029a() != null) {
            C0872i.m5265a(this.f6032a).m5329a(c1879c.m9029a()).m4405a().m4406a(0.25f).m4417a(this.f6033b);
        }
        if (c1879c.m9031b()) {
            this.f6036e.setVisibility(0);
        } else {
            this.f6036e.setVisibility(8);
        }
    }
}
