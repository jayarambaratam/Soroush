package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.provider.p172f.C1619f;
import mobi.mmdt.ott.view.conversation.activities.ChannelConversationActivity;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2154a;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.b */
class C2028b implements OnClickListener {
    final /* synthetic */ C2027a f6678a;

    C2028b(C2027a c2027a) {
        this.f6678a = c2027a;
    }

    public void onClick(View view) {
        C2154a c2154a = (C2154a) this.f6678a.m8619a();
        if (((ChannelConversationActivity) this.f6678a.a).m9517G() != C1619f.NONE) {
            boolean z = !(c2154a.m9853o() != 0);
            this.f6678a.m9662a(z, true);
            new Handler().postDelayed(new C2029c(this, c2154a, z), 400);
            return;
        }
        new Handler().postDelayed(new C2030d(this, c2154a), 50);
    }
}
