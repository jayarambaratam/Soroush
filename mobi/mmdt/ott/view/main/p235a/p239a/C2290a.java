package mobi.mmdt.ott.view.main.p235a.p239a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.main.p235a.p240b.C2293b;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.view.main.a.a.a */
public class C2290a extends C1712b {
    private Activity f7566a;
    private RoundAvatarImageView f7567b;
    private ImageView f7568c;
    private TextView f7569d;
    private TextView f7570e;
    private View f7571f;

    public C2290a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968766, c1790i);
        this.f7566a = activity;
        this.f7571f = this.itemView.findViewById(2131689710);
        this.f7567b = (RoundAvatarImageView) this.itemView.findViewById(2131689706);
        this.f7568c = (ImageView) this.itemView.findViewById(2131689795);
        this.f7569d = (TextView) this.itemView.findViewById(2131689707);
        this.f7570e = (TextView) this.itemView.findViewById(2131689709);
    }

    protected void m10379a(C1722f c1722f) {
        C2293b c2293b = (C2293b) c1722f;
        this.f7569d.setText(c2293b.m10394b());
        this.f7570e.setText(c2293b.m10395c());
        this.f7567b.setImageBitmap(null);
        if (c2293b.m10393a() != -1) {
            C0872i.m5265a(this.f7566a).m5328a(Integer.valueOf(c2293b.m10393a())).m4406a(0.25f).m4417a(this.f7567b);
        }
        this.f7567b.setName(c2293b.m10394b());
        this.f7567b.setBackgroundColor(c2293b.m10396d());
        switch (c2293b.m8660h() % 3) {
            case VideoSize.QCIF /*0*/:
                C0872i.m5265a(this.f7566a).m5328a(Integer.valueOf(2130838493)).m4406a(0.25f).m4417a(this.f7568c);
                break;
            case VideoSize.CIF /*1*/:
                C0872i.m5265a(this.f7566a).m5328a(Integer.valueOf(2130838492)).m4406a(0.25f).m4417a(this.f7568c);
                break;
            case VideoSize.HVGA /*2*/:
                C0872i.m5265a(this.f7566a).m5328a(Integer.valueOf(2130838494)).m4406a(0.25f).m4417a(this.f7568c);
                break;
        }
        if (c2293b.m8660h() == 0) {
            this.f7571f.setVisibility(4);
        } else {
            this.f7571f.setVisibility(0);
        }
    }
}
