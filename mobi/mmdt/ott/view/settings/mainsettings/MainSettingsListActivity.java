package mobi.mmdt.ott.view.settings.mainsettings;

import android.os.Handler;
import android.support.v7.app.af;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.p178a.C1659a;
import mobi.mmdt.ott.view.settings.C2516a;
import mobi.mmdt.ott.view.settings.C2522b;

public class MainSettingsListActivity extends C2516a {
    private void m10868o() {
    }

    private void m10869p() {
        af afVar = new af(this, 2131427471);
        afVar.m3606a(getString(2131230803));
        afVar.m3610b((CharSequence) "Exit descriptions...");
        afVar.m3611b(getString(2131230814), null);
        afVar.m3607a(getString(2131230840), new C2527a(this));
        afVar.m3612c();
    }

    private void m10870r() {
        af afVar = new af(this, 2131427471);
        afVar.m3606a(getString(2131230922));
        View inflate = getLayoutInflater().inflate(2130968694, null);
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(2131689763);
        RadioButton radioButton = (RadioButton) inflate.findViewById(2131689764);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(2131689765);
        radioButton.setText(getString(2131230838));
        radioButton2.setText(getString(2131230842));
        if (C1309a.m6934a(getApplicationContext()).m6937a().equals("fa")) {
            radioButton2.setChecked(true);
        } else {
            radioButton.setChecked(true);
        }
        afVar.m3609b(inflate);
        afVar.m3611b(getString(2131230814), null);
        afVar.m3607a(getString(2131230921), new C2528b(this, radioGroup));
        afVar.m3612c();
    }

    private void m10871s() {
    }

    private void m10872t() {
        new Handler().postDelayed(new C2529c(this), 10);
    }

    private void m10873u() {
        C1659a.m8427a(m8494q());
    }

    private void m10874v() {
        new Handler().postDelayed(new C2530d(this), 10);
    }

    private void m10875w() {
        new Handler().postDelayed(new C2531e(this), 10);
    }

    private void m10876x() {
        new Handler().postDelayed(new C2532f(this), 10);
    }

    public void m10877a(int i) {
        switch (i) {
            case 1001:
                m10873u();
            case 1002:
                m10876x();
            case 1003:
                m10872t();
            case 1004:
                m10874v();
            case 1006:
                m10868o();
            case 1007:
                m10875w();
            case 1008:
                m10871s();
            case 1009:
                m10869p();
            case 2001:
                m10870r();
            default:
        }
    }

    protected String m10878m() {
        return getString(2131230937);
    }

    protected C2522b m10879n() {
        return new C2533g();
    }
}
