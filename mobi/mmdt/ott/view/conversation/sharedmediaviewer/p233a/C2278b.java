package mobi.mmdt.ott.view.conversation.sharedmediaviewer.p233a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.p032a.p033a.C0872i;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.sharedmediaviewer.p234b.C2282c;

/* renamed from: mobi.mmdt.ott.view.conversation.sharedmediaviewer.a.b */
public class C2278b extends C1712b {
    private Activity f7510a;
    private ImageView f7511b;

    public C2278b(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2) {
        super(layoutInflater, viewGroup, 2130968805, c1790i);
        this.f7510a = activity;
        this.f7511b = (ImageView) this.itemView.findViewById(2131689732);
        LayoutParams layoutParams = (LayoutParams) this.f7511b.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
    }

    protected void m10276a(C1722f c1722f) {
        C2282c c2282c = (C2282c) c1722f;
        this.f7511b.setImageBitmap(null);
        if (c2282c.m10288a() != null) {
            C0872i.m5265a(this.f7510a).m5329a(c2282c.m10288a()).m4405a().m4406a(0.25f).m4417a(this.f7511b);
        } else {
            C0872i.m5267a(this.f7511b);
        }
    }
}
