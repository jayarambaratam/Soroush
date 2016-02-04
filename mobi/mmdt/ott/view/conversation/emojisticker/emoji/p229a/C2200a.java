package mobi.mmdt.ott.view.conversation.emojisticker.emoji.p229a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.emojisticker.C2202j;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.p230b.C2204a;
import mobi.mmdt.ott.view.p178a.p179a.C1656d;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.emoji.a.a */
public class C2200a extends C1712b {
    private Context f7248a;
    private ImageView f7249b;
    private FrameLayout f7250c;
    private C1656d f7251d;
    private C2202j f7252e;

    public C2200a(Context context, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1656d c1656d, C2202j c2202j) {
        super(layoutInflater, viewGroup, 2130968703, c1790i);
        this.f7248a = context;
        this.f7249b = (ImageView) this.itemView.findViewById(2131689732);
        this.f7250c = (FrameLayout) this.itemView.findViewById(2131689696);
        this.f7251d = c1656d;
        this.f7252e = c2202j;
        this.f7250c.setOnClickListener(new C2201b(this));
        LayoutParams layoutParams = (LayoutParams) this.f7249b.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
    }

    protected void m10059a(C1722f c1722f) {
        this.f7251d.m8416a(Integer.valueOf(((C2204a) c1722f).m10071a().m10088a()), this.f7249b);
    }
}
