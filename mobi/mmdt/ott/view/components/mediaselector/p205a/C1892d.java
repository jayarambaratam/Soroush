package mobi.mmdt.ott.view.components.mediaselector.p205a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.p032a.p033a.C0872i;
import mobi.mmdt.ott.view.components.mediaselector.p206b.C1897d;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.a.d */
public class C1892d extends C1712b {
    private Activity f6078a;
    private ImageView f6079b;

    public C1892d(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2) {
        super(layoutInflater, viewGroup, 2130968778, c1790i);
        this.f6078a = activity;
        this.f6079b = (ImageView) this.itemView.findViewById(2131689732);
        LayoutParams layoutParams = (LayoutParams) this.f6079b.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
    }

    protected void m9061a(C1722f c1722f) {
        C1897d c1897d = (C1897d) c1722f;
        this.f6079b.setImageBitmap(null);
        if (c1897d.m9075b() != null) {
            C0872i.m5265a(this.f6078a).m5329a(c1897d.m9075b()).m4405a().m4406a(0.25f).m4417a(this.f6079b);
        }
    }
}
