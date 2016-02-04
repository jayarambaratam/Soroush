package mobi.mmdt.ott.view.settings.mainsettings.privacy;

import android.support.v7.app.af;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import mobi.mmdt.ott.view.settings.C2516a;
import mobi.mmdt.ott.view.settings.C2522b;

public class PrivacySettingsListActivity extends C2516a {
    private void m10903o() {
        af afVar = new af(this, 2131427471);
        afVar.m3606a((CharSequence) "Show last online to others");
        View inflate = getLayoutInflater().inflate(2130968699, null);
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(2131689763);
        RadioButton radioButton = (RadioButton) inflate.findViewById(2131689765);
        ((RadioButton) inflate.findViewById(2131689764)).setText(getString(2131230900));
        radioButton.setText(getString(2131230899));
        afVar.m3609b(inflate);
        afVar.m3611b(getString(2131230814), null);
        afVar.m3607a(getString(2131230921), new C2544a(this, radioGroup));
        afVar.m3612c();
    }

    private void m10904p() {
        af afVar = new af(this, 2131427471);
        afVar.m3606a((CharSequence) "Send message seen report");
        View inflate = getLayoutInflater().inflate(2130968699, null);
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(2131689763);
        RadioButton radioButton = (RadioButton) inflate.findViewById(2131689765);
        ((RadioButton) inflate.findViewById(2131689764)).setText(getString(2131230900));
        radioButton.setText(getString(2131230899));
        afVar.m3609b(inflate);
        afVar.m3611b(getString(2131230814), null);
        afVar.m3607a(getString(2131230921), new C2545b(this, radioGroup));
        afVar.m3612c();
    }

    private void m10905r() {
    }

    public void m10906a(int i) {
        switch (i) {
            case 2007:
                m10905r();
            case 3001:
                m10903o();
            case 3002:
                m10904p();
            default:
        }
    }

    protected String m10907m() {
        return getString(2131230909);
    }

    protected C2522b m10908n() {
        return new C2546c();
    }
}
