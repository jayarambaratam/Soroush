package mobi.mmdt.ott.view.stickermarket.p249a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;
import com.p032a.p033a.p045h.C0866h;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.stickermarket.p250b.C2576b;

/* renamed from: mobi.mmdt.ott.view.stickermarket.a.a */
public class C2570a extends C1712b {
    private Activity f8253a;
    private ImageView f8254b;
    private TextView f8255c;
    private TextView f8256d;
    private ProgressWheel f8257e;
    private View f8258f;
    private C0866h<String, C0742b> f8259g;

    public C2570a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968815, c1790i);
        this.f8259g = new C2571b(this);
        this.f8253a = activity;
        this.f8258f = this.itemView.findViewById(2131689710);
        this.f8254b = (ImageView) this.itemView.findViewById(2131689706);
        this.f8255c = (TextView) this.itemView.findViewById(2131689707);
        this.f8256d = (TextView) this.itemView.findViewById(2131689708);
        this.f8257e = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
    }

    protected void m10999a(C1722f c1722f) {
        C2576b c2576b = (C2576b) c1722f;
        this.f8255c.setText(c2576b.m11010a());
        this.f8256d.setText(c2576b.m11011b());
        C0872i.m5265a(this.f8253a).m5329a(c2576b.m11013d()).m4413a(this.f8259g).m4406a(0.25f).m4417a(this.f8254b);
        if (c2576b.m8660h() == 0) {
            this.f8258f.setVisibility(4);
        } else {
            this.f8258f.setVisibility(0);
        }
    }
}
