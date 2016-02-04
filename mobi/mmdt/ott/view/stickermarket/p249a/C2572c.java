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
import mobi.mmdt.ott.view.stickermarket.p250b.C2577c;

/* renamed from: mobi.mmdt.ott.view.stickermarket.a.c */
public class C2572c extends C1712b {
    private Activity f8261a;
    private ImageView f8262b;
    private TextView f8263c;
    private TextView f8264d;
    private TextView f8265e;
    private ProgressWheel f8266f;
    private View f8267g;
    private C0866h<String, C0742b> f8268h;

    public C2572c(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968818, c1790i);
        this.f8268h = new C2573d(this);
        this.f8261a = activity;
        this.f8267g = this.itemView.findViewById(2131689710);
        this.f8262b = (ImageView) this.itemView.findViewById(2131689706);
        this.f8263c = (TextView) this.itemView.findViewById(2131689707);
        this.f8264d = (TextView) this.itemView.findViewById(2131689708);
        this.f8265e = (TextView) this.itemView.findViewById(2131689709);
        this.f8266f = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
    }

    protected void m11005a(C1722f c1722f) {
        C2577c c2577c = (C2577c) c1722f;
        this.f8263c.setText(c2577c.m11014a());
        CharSequence c = c2577c.m11016c();
        double parseDouble = Double.parseDouble(c);
        TextView textView = this.f8264d;
        if (parseDouble == 0.0d) {
            c = "Free";
        }
        textView.setText(c);
        this.f8265e.setText(c2577c.m11015b());
        C0872i.m5265a(this.f8261a).m5329a(c2577c.m11018e()).m4413a(this.f8268h).m4406a(0.25f).m4417a(this.f8262b);
        if (c2577c.m8660h() == 0) {
            this.f8267g.setVisibility(4);
        } else {
            this.f8267g.setVisibility(0);
        }
    }
}
