package mobi.mmdt.ott.view.components.mediaviewer.p207a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.ott.view.components.mediaviewer.p208b.C1925b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import p025b.p026a.p027a.p028a.C0557d;

/* renamed from: mobi.mmdt.ott.view.components.mediaviewer.a.b */
public class C1919b extends C1918a {
    private Activity f6166a;
    private TextView f6167b;
    private TextView f6168c;
    private ImageView f6169d;
    private C0557d f6170e;

    public C1919b(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(c1790i, layoutInflater, viewGroup, 2130968779);
        this.f6166a = activity;
        this.f6169d = (ImageView) this.itemView.findViewById(2131689732);
        this.f6167b = (TextView) this.itemView.findViewById(2131689731);
        this.f6168c = (TextView) this.itemView.findViewById(2131689916);
    }

    protected void m9177a(C1722f c1722f) {
        C1925b c1925b = (C1925b) c1722f;
        if (c1925b.m9190c() == null || c1925b.m9190c().isEmpty()) {
            this.f6167b.setVisibility(8);
        } else {
            this.f6167b.setText(c1925b.m9190c());
            this.f6167b.setVisibility(0);
        }
        this.f6168c.setText(c1925b.m9189b() + ", " + c1925b.m9191d());
        C0872i.m5265a(this.f6166a).m5329a(c1925b.m9188a()).m4409a(C0652e.SOURCE).m4413a(new C1920c(this)).m4417a(this.f6169d);
    }
}
