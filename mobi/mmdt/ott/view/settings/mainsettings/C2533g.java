package mobi.mmdt.ott.view.settings.mainsettings;

import java.util.List;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.settings.C2522b;
import mobi.mmdt.ott.view.settings.p248b.C2518b;
import mobi.mmdt.ott.view.settings.p248b.C2520d;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.g */
public class C2533g extends C2522b {
    protected void m10880a(List<C1722f> list) {
        String string = C1309a.m6934a(getActivity()).m6937a().equals("fa") ? getString(2131230842) : getString(2131230838);
        list.clear();
        list.add(new C2520d(getString(2131230910), 1001, 0));
        list.add(new C2518b(getString(2131230877), string, 2001, 1));
        list.add(new C2520d(getString(2131230888), 1002, 2));
        list.add(new C2520d(getString(2131230898), 1003, 3));
        list.add(new C2520d(getString(2131230885), 1004, 4));
    }
}
