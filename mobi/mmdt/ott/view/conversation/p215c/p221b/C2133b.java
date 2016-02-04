package mobi.mmdt.ott.view.conversation.p215c.p221b;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p222d.p228b.C2191b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.b.b */
public class C2133b extends C2132a {
    private ImageView f6976a;

    public C2133b(C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(c1790i, layoutInflater, viewGroup, 2130968641);
        this.f6976a = (ImageView) this.itemView.findViewById(2131689714);
    }

    protected void m9789a(C1722f c1722f) {
        C2191b c2191b = (C2191b) c1722f;
        super.m9788a(c2191b);
        switch (c2191b.m10031k()) {
            case VideoSize.CIF /*1*/:
                this.f6976a.setImageResource(2130838493);
            case VideoSize.HVGA /*2*/:
                this.f6976a.setImageResource(2130838494);
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6976a.setImageResource(2130838492);
            default:
        }
    }
}
