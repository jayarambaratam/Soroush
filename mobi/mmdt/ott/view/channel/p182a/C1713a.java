package mobi.mmdt.ott.view.channel.p182a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;
import com.p032a.p033a.p045h.C0866h;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.ott.view.channel.p183b.C1724b;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.p178a.aj;

/* renamed from: mobi.mmdt.ott.view.channel.a.a */
public class C1713a extends C1712b {
    private Activity f5649a;
    private ImageView f5650b;
    private TextView f5651c;
    private ProgressWheel f5652d;
    private C0866h<String, C0742b> f5653e;

    public C1713a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968639, c1790i);
        this.f5653e = new C1714b(this);
        this.f5649a = activity;
        this.f5650b = (ImageView) this.itemView.findViewById(2131689706);
        this.f5651c = (TextView) this.itemView.findViewById(2131689707);
        this.f5652d = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
    }

    protected void m8623a(C1722f c1722f) {
        C1724b c1724b = (C1724b) c1722f;
        this.f5651c.setText(c1724b.m8663c());
        C0872i.m5265a(this.f5649a).m5329a(aj.m8474a(c1724b.m8661a())).m4413a(this.f5653e).m4406a(0.25f).m4417a(this.f5650b);
    }
}
