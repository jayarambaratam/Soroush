package mobi.mmdt.ott.view.components.mediaselector.p205a;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.p032a.p033a.C0872i;
import mobi.mmdt.ott.view.components.mediaselector.p206b.C1896c;
import mobi.mmdt.ott.view.components.mediaselector.photoselection.C1909a;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.a.b */
public class C1890b extends C1712b {
    private Activity f6069a;
    private ImageView f6070b;
    private ImageView f6071c;
    private FrameLayout f6072d;
    private FrameLayout f6073e;
    private C1909a f6074f;
    private CheckBox f6075g;
    private boolean f6076h;

    public C1890b(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1909a c1909a) {
        super(layoutInflater, viewGroup, 2130968777, c1790i);
        this.f6076h = false;
        this.f6069a = activity;
        this.f6070b = (ImageView) this.itemView.findViewById(2131689732);
        this.f6071c = (ImageView) this.itemView.findViewById(2131689914);
        this.f6072d = (FrameLayout) this.itemView.findViewById(2131689696);
        this.f6073e = (FrameLayout) this.itemView.findViewById(2131689730);
        this.f6075g = (CheckBox) this.itemView.findViewById(2131689915);
        LayoutParams layoutParams = (LayoutParams) this.f6070b.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6071c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        GridLayoutManager.LayoutParams layoutParams2 = (GridLayoutManager.LayoutParams) this.f6072d.getLayoutParams();
        layoutParams2.height = i2;
        layoutParams2.width = i;
        this.f6074f = c1909a;
        this.f6075g.setOnCheckedChangeListener(new C1891c(this));
    }

    protected void m9060a(C1722f c1722f) {
        C1896c c1896c = (C1896c) c1722f;
        this.f6070b.setImageBitmap(null);
        if (c1896c.m9071b() != null) {
            C0872i.m5265a(this.f6069a).m5329a(c1896c.m9071b()).m4405a().m4406a(0.25f).m4417a(this.f6070b);
        }
        this.f6076h = true;
        this.f6075g.setChecked(c1896c.m9072c());
        this.f6076h = false;
        if (this.f6074f == null || !this.f6074f.m9123a()) {
            this.f6075g.setVisibility(8);
            this.f6071c.setVisibility(8);
            return;
        }
        this.f6075g.setVisibility(0);
        this.f6071c.setVisibility(0);
    }
}
