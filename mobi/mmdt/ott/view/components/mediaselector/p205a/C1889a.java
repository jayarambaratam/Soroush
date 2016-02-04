package mobi.mmdt.ott.view.components.mediaselector.p205a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import mobi.mmdt.ott.view.components.mediaselector.p206b.C1895b;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.a.a */
public class C1889a extends C1712b {
    private Activity f6064a;
    private ImageView f6065b;
    private ImageView f6066c;
    private TextView f6067d;
    private TextView f6068e;

    public C1889a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2) {
        super(layoutInflater, viewGroup, 2130968776, c1790i);
        this.f6064a = activity;
        this.f6066c = (ImageView) this.itemView.findViewById(2131689733);
        this.f6065b = (ImageView) this.itemView.findViewById(2131689732);
        this.f6067d = (TextView) this.itemView.findViewById(2131689912);
        this.f6068e = (TextView) this.itemView.findViewById(2131689913);
        this.f6068e.setShadowLayer(15.0f, 0.0f, 0.0f, -16777216);
        this.f6067d.setShadowLayer(15.0f, 0.0f, 0.0f, -16777216);
        LayoutParams layoutParams = (LayoutParams) this.f6065b.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6066c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
    }

    protected void m9057a(C1722f c1722f) {
        C1895b c1895b = (C1895b) c1722f;
        this.f6068e.setText(c1895b.m9064b());
        this.f6067d.setText(c1895b.m9063a());
        this.f6065b.setImageBitmap(null);
        if (c1895b.m9066d() != null) {
            C0872i.m5265a(this.f6064a).m5329a(c1895b.m9066d()).m4405a().m4406a(0.25f).m4417a(this.f6065b);
        }
    }
}
