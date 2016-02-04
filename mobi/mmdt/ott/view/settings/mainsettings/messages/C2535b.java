package mobi.mmdt.ott.view.settings.mainsettings.messages;

import java.util.List;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.settings.C2522b;
import mobi.mmdt.ott.view.settings.p248b.C2518b;
import mobi.mmdt.ott.view.settings.p248b.C2520d;
import mobi.mmdt.ott.view.settings.p248b.C2521e;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.messages.b */
public class C2535b extends C2522b {
    protected void m10887a(List<C1722f> list) {
        int z = C1309a.m6934a(getActivity()).m6983z();
        boolean x = C1309a.m6934a(getActivity()).m6981x();
        list.clear();
        list.add(new C2518b(getString(2131230886), BuildConfig.FLAVOR + z, 2006, 0));
        list.add(new C2520d(getString(2131230946), 1005, 1));
        list.add(new C2521e(getString(2131230919), x, 4001, 2));
    }
}
