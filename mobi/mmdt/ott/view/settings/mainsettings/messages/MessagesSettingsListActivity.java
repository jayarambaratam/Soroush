package mobi.mmdt.ott.view.settings.mainsettings.messages;

import android.support.v7.app.af;
import android.view.View;
import android.widget.NumberPicker;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.p178a.C1659a;
import mobi.mmdt.ott.view.settings.C2516a;
import mobi.mmdt.ott.view.settings.C2522b;

public class MessagesSettingsListActivity extends C2516a {
    private void m10882o() {
        C1659a.m8438b(m8494q());
    }

    private void m10883p() {
        af afVar = new af(this, 2131427471);
        afVar.m3606a(getString(2131230886));
        View inflate = getLayoutInflater().inflate(2130968695, null);
        NumberPicker numberPicker = (NumberPicker) inflate.findViewById(2131689766);
        numberPicker.setMinValue(12);
        numberPicker.setMaxValue(24);
        numberPicker.setValue(C1309a.m6934a(getApplicationContext()).m6983z());
        afVar.m3609b(inflate);
        afVar.m3611b(getString(2131230813), null);
        afVar.m3607a(getString(2131230936), new C2534a(this, numberPicker));
        afVar.m3612c();
    }

    public void m10884a(int i) {
        switch (i) {
            case 1005:
                m10882o();
            case 2006:
                m10883p();
            default:
        }
    }

    protected String m10885m() {
        return getString(2131230885);
    }

    protected C2522b m10886n() {
        return new C2535b();
    }
}
