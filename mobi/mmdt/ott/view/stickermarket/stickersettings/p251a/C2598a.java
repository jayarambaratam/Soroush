package mobi.mmdt.ott.view.stickermarket.stickersettings.p251a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
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
import mobi.mmdt.ott.view.stickermarket.stickersettings.C2597a;
import mobi.mmdt.ott.view.stickermarket.stickersettings.p252b.C2603b;

/* renamed from: mobi.mmdt.ott.view.stickermarket.stickersettings.a.a */
public class C2598a extends C1712b {
    private C2597a f8318a;
    private Activity f8319b;
    private ImageView f8320c;
    private CheckBox f8321d;
    private FrameLayout f8322e;
    private TextView f8323f;
    private ProgressWheel f8324g;
    private View f8325h;
    private boolean f8326i;
    private C0866h<String, C0742b> f8327j;

    public C2598a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, C2597a c2597a) {
        super(layoutInflater, viewGroup, 2130968819, c1790i);
        this.f8326i = false;
        this.f8327j = new C2601d(this);
        this.f8319b = activity;
        this.f8318a = c2597a;
        this.f8325h = this.itemView.findViewById(2131689710);
        this.f8322e = (FrameLayout) this.itemView.findViewById(2131689635);
        this.f8320c = (ImageView) this.itemView.findViewById(2131689706);
        this.f8321d = (CheckBox) this.itemView.findViewById(2131689776);
        this.f8323f = (TextView) this.itemView.findViewById(2131689707);
        this.f8324g = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f8322e.setOnTouchListener(new C2599b(this));
        this.f8321d.setOnCheckedChangeListener(new C2600c(this));
    }

    protected void m11048a(C1722f c1722f) {
        boolean z = true;
        C2603b c2603b = (C2603b) c1722f;
        this.f8323f.setText(c2603b.m11053a());
        C0872i.m5265a(this.f8319b).m5329a(c2603b.m11055c()).m4413a(this.f8327j).m4406a(0.25f).m4417a(this.f8320c);
        if (c2603b.m8660h() == 0) {
            this.f8325h.setVisibility(4);
        } else {
            this.f8325h.setVisibility(0);
        }
        this.f8326i = true;
        CheckBox checkBox = this.f8321d;
        if (c2603b.m11056d()) {
            z = false;
        }
        checkBox.setChecked(z);
        this.f8326i = false;
    }
}
