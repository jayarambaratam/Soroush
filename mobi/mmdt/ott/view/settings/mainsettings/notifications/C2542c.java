package mobi.mmdt.ott.view.settings.mainsettings.notifications;

import java.util.List;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.settings.C2522b;
import mobi.mmdt.ott.view.settings.p248b.C2518b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.notifications.c */
public class C2542c extends C2522b {
    protected void m10902a(List<C1722f> list) {
        String string;
        switch (C2543d.f8167a[C1309a.m6934a(getActivity()).m6982y().ordinal()]) {
            case VideoSize.CIF /*1*/:
                string = getString(2131230759);
                break;
            case VideoSize.HVGA /*2*/:
                string = getString(2131230762);
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                string = getString(2131230786);
                break;
            case Version.API04_DONUT_16 /*4*/:
                string = getString(2131230773);
                break;
            default:
                string = getString(2131230759);
                break;
        }
        list.clear();
        list.add(new C2518b(getString(2131230965), string, 2005, 0));
    }
}
