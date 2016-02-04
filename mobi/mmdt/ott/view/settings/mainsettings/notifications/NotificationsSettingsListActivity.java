package mobi.mmdt.ott.view.settings.mainsettings.notifications;

import android.support.v7.app.af;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.settings.C2516a;
import mobi.mmdt.ott.view.settings.C2522b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class NotificationsSettingsListActivity extends C2516a {
    private void m10898o() {
        af afVar = new af(this, 2131427471);
        afVar.m3606a(getString(2131230965));
        View inflate = getLayoutInflater().inflate(2130968698, null);
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(2131689763);
        RadioButton radioButton = (RadioButton) inflate.findViewById(2131689764);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(2131689765);
        RadioButton radioButton3 = (RadioButton) inflate.findViewById(2131689771);
        RadioButton radioButton4 = (RadioButton) inflate.findViewById(2131689772);
        radioButton.setText(getString(2131230762));
        radioButton2.setText(getString(2131230759));
        radioButton3.setText(getString(2131230786));
        radioButton4.setText(getString(2131230773));
        switch (C2541b.f8166a[C1309a.m6934a(m8494q()).m6982y().ordinal()]) {
            case VideoSize.CIF /*1*/:
                radioButton.setChecked(true);
                break;
            case VideoSize.HVGA /*2*/:
                radioButton2.setChecked(true);
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                radioButton3.setChecked(true);
                break;
            case Version.API04_DONUT_16 /*4*/:
                radioButton4.setChecked(true);
                break;
            default:
                radioButton2.setChecked(true);
                break;
        }
        afVar.m3609b(inflate);
        afVar.m3611b(getString(2131230813), null);
        afVar.m3607a(getString(2131230921), new C2540a(this, radioGroup));
        afVar.m3612c();
    }

    public void m10899a(int i) {
        switch (i) {
            case 2005:
                m10898o();
            default:
        }
    }

    protected String m10900m() {
        return getString(2131230898);
    }

    protected C2522b m10901n() {
        return new C2542c();
    }
}
