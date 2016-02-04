package mobi.mmdt.ott.view.contact.p209a.p211b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.contact.p209a.C1943i;
import mobi.mmdt.ott.view.contact.p209a.p212c.C1953b;
import mobi.mmdt.ott.view.p178a.aj;

/* renamed from: mobi.mmdt.ott.view.contact.a.b.a */
public class C1945a extends C1712b {
    private Activity f6244a;
    private RoundAvatarImageView f6245b;
    private TextView f6246c;
    private TextView f6247d;
    private CheckBox f6248e;
    private FrameLayout f6249f;
    private View f6250g;
    private C1943i f6251h;
    private boolean f6252i;

    public C1945a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, C1943i c1943i) {
        super(layoutInflater, viewGroup, 2130968767, c1790i);
        this.f6252i = false;
        this.f6244a = activity;
        this.f6251h = c1943i;
        this.f6250g = this.itemView.findViewById(2131689710);
        this.f6245b = (RoundAvatarImageView) this.itemView.findViewById(2131689706);
        this.f6246c = (TextView) this.itemView.findViewById(2131689707);
        this.f6247d = (TextView) this.itemView.findViewById(2131689708);
        this.f6248e = (CheckBox) this.itemView.findViewById(2131689776);
        this.f6249f = (FrameLayout) this.itemView.findViewById(2131689635);
        this.f6249f.setOnTouchListener(new C1946b(this));
        this.f6248e.setOnCheckedChangeListener(new C1947c(this));
    }

    protected void m9251a(C1722f c1722f) {
        C1953b c1953b = (C1953b) c1722f;
        this.f6246c.setText(c1953b.m9263e());
        TextView textView = this.f6247d;
        CharSequence string = (c1953b.m9262d() == null || c1953b.m9262d().isEmpty()) ? this.f6244a.getString(2131230860) : c1953b.m9262d();
        textView.setText(string);
        this.f6245b.setImageBitmap(null);
        if (c1953b.m9257a() != null) {
            C0872i.m5265a(this.f6244a).m5329a(aj.m8474a(c1953b.m9257a())).m4409a(C0652e.ALL).m4406a(0.25f).m4417a(this.f6245b);
        } else if (c1953b.m9259b() != null) {
            C0872i.m5265a(this.f6244a).m5327a(c1953b.m9259b()).m4406a(0.25f).m4417a(this.f6245b);
        } else {
            C0872i.m5267a(this.f6245b);
        }
        this.f6245b.setName(c1953b.m9263e());
        this.f6245b.setBackgroundColor(c1953b.m9264f());
        this.f6248e.setEnabled(c1953b.m9267k());
        this.f6252i = true;
        this.f6248e.setChecked(c1953b.m9265i());
        this.f6252i = false;
    }
}
