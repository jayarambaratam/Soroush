package mobi.mmdt.ott.view.conversation.sharedmediaviewer.p233a;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.p032a.p033a.C0872i;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.sharedmediaviewer.p234b.C2281b;

/* renamed from: mobi.mmdt.ott.view.conversation.sharedmediaviewer.a.a */
public class C2277a extends C1712b {
    private Activity f7507a;
    private ImageView f7508b;
    private FrameLayout f7509c;

    public C2277a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2) {
        super(layoutInflater, viewGroup, 2130968804, c1790i);
        this.f7507a = activity;
        this.f7508b = (ImageView) this.itemView.findViewById(2131689732);
        this.f7509c = (FrameLayout) this.itemView.findViewById(2131689696);
        LayoutParams layoutParams = (LayoutParams) this.f7508b.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        GridLayoutManager.LayoutParams layoutParams2 = (GridLayoutManager.LayoutParams) this.f7509c.getLayoutParams();
        layoutParams2.height = i2;
        layoutParams2.width = i;
    }

    protected void m10275a(C1722f c1722f) {
        C2281b c2281b = (C2281b) c1722f;
        this.f7508b.setImageBitmap(null);
        if (c2281b.m10286a() != null) {
            C0872i.m5265a(this.f7507a).m5329a(c2281b.m10286a()).m4405a().m4406a(0.25f).m4417a(this.f7508b);
        } else {
            C0872i.m5267a(this.f7508b);
        }
    }
}
