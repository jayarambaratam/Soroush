package mobi.mmdt.ott.view.components.mediaviewer.p207a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import mobi.mmdt.ott.view.components.mediaviewer.p208b.C1926c;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.components.mediaviewer.a.d */
public class C1921d extends C1918a {
    private TextView f6172a;
    private TextView f6173b;
    private ImageView f6174c;
    private ImageButton f6175d;
    private Activity f6176e;

    public C1921d(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(c1790i, layoutInflater, viewGroup, 2130968780);
        this.f6176e = activity;
        this.f6175d = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6174c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6172a = (TextView) this.itemView.findViewById(2131689731);
        this.f6173b = (TextView) this.itemView.findViewById(2131689916);
        this.f6175d.setOnClickListener(new C1922e(this));
    }

    protected void m9183a(C1722f c1722f) {
        C1926c c1926c = (C1926c) c1722f;
        if (c1926c.m9194b() == null || c1926c.m9194b().isEmpty()) {
            this.f6172a.setVisibility(8);
        } else {
            this.f6172a.setText(c1926c.m9194b());
            this.f6172a.setVisibility(0);
        }
        this.f6173b.setText(c1926c.m9196d() + ", " + c1926c.m9195c());
        C0872i.m5265a(this.f6176e).m5329a(c1926c.m9188a()).m4406a(0.25f).m4417a(this.f6174c);
    }
}
