package mobi.mmdt.ott.view.channel.p182a;

import android.app.Activity;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;
import com.p032a.p033a.p045h.C0866h;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1118e;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.view.channel.aj;
import mobi.mmdt.ott.view.channel.p183b.C1725c;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.channel.a.c */
public class C1715c extends C1712b {
    private Activity f5655a;
    private ImageView f5656b;
    private TextView f5657c;
    private TextView f5658d;
    private TextView f5659e;
    private AppCompatButton f5660f;
    private AppCompatButton f5661g;
    private ProgressWheel f5662h;
    private aj f5663i;
    private C0866h<String, C0742b> f5664j;

    public C1715c(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, aj ajVar) {
        super(layoutInflater, viewGroup, 2130968640, c1790i);
        this.f5664j = new C1718f(this);
        this.f5655a = activity;
        this.f5663i = ajVar;
        this.f5656b = (ImageView) this.itemView.findViewById(2131689706);
        this.f5657c = (TextView) this.itemView.findViewById(2131689707);
        this.f5658d = (TextView) this.itemView.findViewById(2131689708);
        this.f5659e = (TextView) this.itemView.findViewById(2131689709);
        this.f5660f = (AppCompatButton) this.itemView.findViewById(2131689711);
        this.f5661g = (AppCompatButton) this.itemView.findViewById(2131689656);
        this.f5662h = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f5660f.setOnClickListener(new C1716d(this));
        this.f5661g.setOnClickListener(new C1717e(this));
    }

    protected void m8630a(C1722f c1722f) {
        C1725c c1725c = (C1725c) c1722f;
        this.f5657c.setText(c1725c.m8669e());
        this.f5658d.setText(C1111c.m6407c(c1725c.m8666b()));
        this.f5659e.setText(c1725c.m8664a());
        if (c1725c.m8670f()) {
            this.f5661g.setText(this.f5655a.getString(2131230845));
            this.f5661g.setTextColor(this.f5655a.getResources().getColor(2131624021));
            this.f5661g.setEnabled(false);
        } else {
            this.f5661g.setText(this.f5655a.getString(2131230844));
            this.f5661g.setTextColor(this.f5655a.getResources().getColor(C1118e.textColorPrimary));
            this.f5661g.setEnabled(true);
        }
        C0872i.m5265a(this.f5655a).m5329a(mobi.mmdt.ott.view.p178a.aj.m8474a(c1725c.m8667c())).m4413a(this.f5664j).m4406a(0.25f).m4417a(this.f5656b);
    }
}
