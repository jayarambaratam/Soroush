package mobi.mmdt.ott.view.components;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.p032a.p033a.C0872i;

/* renamed from: mobi.mmdt.ott.view.components.h */
class C1817h implements OnClickListener {
    final /* synthetic */ C1711a f5839a;

    C1817h(C1711a c1711a) {
        this.f5839a = c1711a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5839a.f5622n = true;
        this.f5839a.m8562b(this.f5839a.f5622n);
        this.f5839a.f5621m = null;
        C0872i.m5265a(this.f5839a.m8494q()).m5329a(this.f5839a.f5621m).m4407a(this.f5839a.m8567l()).m4406a(0.25f).m4417a(this.f5839a.f5625q);
    }
}
