package mobi.mmdt.ott.view.settings.mainsettings.network;

import java.util.List;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.settings.C2522b;
import mobi.mmdt.ott.view.settings.p248b.C2518b;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.network.d */
public class C2539d extends C2522b {
    protected void m10896a(List<C1722f> list) {
        boolean s = C1309a.m6934a(getActivity()).m6976s();
        boolean u = C1309a.m6934a(getActivity()).m6978u();
        boolean w = C1309a.m6934a(getActivity()).m6980w();
        String str = BuildConfig.FLAVOR;
        if (s) {
            str = str + getString(2131230777);
        }
        if (s && u) {
            str = str + ", ";
        }
        if (u) {
            str = str + getString(2131230791);
        }
        if ((s || u) && w) {
            str = str + ", ";
        }
        if (w) {
            str = str + getString(2131230766);
        }
        if (str.isEmpty()) {
            str = getString(2131230896);
        }
        u = C1309a.m6934a(getActivity()).m6975r();
        w = C1309a.m6934a(getActivity()).m6977t();
        boolean v = C1309a.m6934a(getActivity()).m6979v();
        String str2 = BuildConfig.FLAVOR;
        if (u) {
            str2 = str2 + getString(2131230777);
        }
        if (u && w) {
            str2 = str2 + ", ";
        }
        if (w) {
            str2 = str2 + getString(2131230791);
        }
        if ((u || w) && v) {
            str2 = str2 + ", ";
        }
        if (v) {
            str2 = str2 + getString(2131230766);
        }
        if (str2.isEmpty()) {
            str2 = getString(2131230896);
        }
        list.clear();
        list.add(new C2518b(getString(2131230968), str, 2002, 0));
        list.add(new C2518b(getString(2131230970), str2, 2003, 1));
    }
}
