package mobi.mmdt.ott.view.conversation.p215c.p216a;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p095c.C1303d;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1591k;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p215c.C2025a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;
import org.json.JSONObject;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a */
public abstract class C2026a extends C2025a {
    protected Activity f6603a;
    protected ViewStub f6604b;
    private TextView f6605c;
    private TextView f6606d;
    private TextView f6607e;
    private ImageView f6608f;

    public C2026a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        super(c1790i, layoutInflater, viewGroup, i);
        this.f6603a = activity;
        this.f6605c = (TextView) this.itemView.findViewById(2131689716);
        this.f6604b = (ViewStub) this.itemView.findViewById(2131689721);
        this.f6604b.inflate();
        this.f6606d = (TextView) this.itemView.findViewById(2131689735);
        this.f6607e = (TextView) this.itemView.findViewById(2131689736);
        this.f6608f = (ImageView) this.itemView.findViewById(2131689734);
    }

    protected void m9659a(C2152a c2152a) {
        Uri uri = null;
        super.m9658a(c2152a);
        this.f6605c.setText(c2152a.m9848l());
        if (getItemViewType() == 92 || c2152a.m9850n() == null) {
            this.f6604b.setVisibility(8);
            return;
        }
        C1591k p = C1583c.m8005p(this.f6603a, c2152a.m9850n());
        if (p != null) {
            this.f6604b.setVisibility(0);
            this.f6606d.setText(p.m8068e());
            this.f6607e.setText(p.m8065b());
            this.f6608f.setImageBitmap(null);
            switch (C2079b.f6815a[p.m8066c().ordinal()]) {
                case VideoSize.CIF /*1*/:
                    this.f6608f.setVisibility(8);
                    return;
                case VideoSize.HVGA /*2*/:
                    this.f6608f.setBackgroundColor(0);
                    this.f6608f.setVisibility(0);
                    if (p.m8064a() != null) {
                        uri = Uri.parse(p.m8064a());
                    } else if (p.m8067d() != null) {
                        uri = Uri.parse(p.m8067d());
                    }
                    C0872i.m5265a(this.f6603a).m5327a(uri).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6608f);
                    return;
                case Version.API03_CUPCAKE_15 /*3*/:
                    this.f6608f.setBackgroundColor(0);
                    this.f6608f.setVisibility(0);
                    if (p.m8064a() != null) {
                        uri = Uri.parse(p.m8064a());
                    } else if (p.m8067d() != null) {
                        uri = Uri.parse(p.m8067d());
                    }
                    C0872i.m5265a(this.f6603a).m5327a(uri).m4405a().m4407a(2130838589).m4406a(0.25f).m4417a(this.f6608f);
                    return;
                case Version.API04_DONUT_16 /*4*/:
                    this.f6608f.setBackgroundColor(0);
                    this.f6608f.setVisibility(0);
                    if (p.m8064a() != null) {
                        uri = Uri.parse(p.m8064a());
                    } else if (p.m8067d() != null) {
                        uri = Uri.parse(p.m8067d());
                    }
                    C0872i.m5265a(this.f6603a).m5327a(uri).m4418b().m4406a(0.25f).m4417a(this.f6608f);
                    return;
                case Version.API05_ECLAIR_20 /*5*/:
                    this.f6608f.setBackgroundColor(this.f6603a.getResources().getColor(2131624017));
                    this.f6608f.setVisibility(0);
                    C0872i.m5265a(this.f6603a).m5328a(Integer.valueOf(2130838508)).m4405a().m4406a(0.25f).m4417a(this.f6608f);
                    return;
                case Version.API06_ECLAIR_201 /*6*/:
                    this.f6608f.setBackgroundColor(this.f6603a.getResources().getColor(2131624017));
                    this.f6608f.setVisibility(0);
                    C0872i.m5265a(this.f6603a).m5328a(Integer.valueOf(2130838574)).m4405a().m4406a(0.25f).m4417a(this.f6608f);
                    return;
                case Version.API07_ECLAIR_21 /*7*/:
                    this.f6608f.setVisibility(8);
                    try {
                        this.f6607e.setText(C1303d.m6879a(new JSONObject(p.m8065b())).m6631a());
                        return;
                    } catch (Throwable e) {
                        C1104b.m6367b(this, "Error in parsing poll data.", e);
                        return;
                    }
                default:
                    return;
            }
        }
        this.f6604b.setVisibility(8);
    }
}
