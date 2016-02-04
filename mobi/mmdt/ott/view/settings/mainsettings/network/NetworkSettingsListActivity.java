package mobi.mmdt.ott.view.settings.mainsettings.network;

import android.support.v7.app.af;
import android.view.View;
import android.widget.CheckBox;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.settings.C2516a;
import mobi.mmdt.ott.view.settings.C2522b;

public class NetworkSettingsListActivity extends C2516a {
    private void m10890o() {
        af afVar = new af(this, 2131427471);
        afVar.m3606a(getString(2131230968));
        View inflate = getLayoutInflater().inflate(2130968696, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(2131689767);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(2131689768);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(2131689769);
        checkBox.setText(getString(2131230777));
        checkBox2.setText(getString(2131230791));
        checkBox3.setText(getString(2131230766));
        boolean s = C1309a.m6934a(getApplicationContext()).m6976s();
        boolean u = C1309a.m6934a(getApplicationContext()).m6978u();
        boolean w = C1309a.m6934a(getApplicationContext()).m6980w();
        checkBox.setChecked(s);
        checkBox2.setChecked(u);
        checkBox3.setChecked(w);
        afVar.m3609b(inflate);
        afVar.m3611b(getString(2131230813), null);
        afVar.m3607a(getString(2131230921), new C2536a(this, checkBox, checkBox2, checkBox3));
        afVar.m3612c();
    }

    private void m10891p() {
        af afVar = new af(this, 2131427471);
        afVar.m3606a(getString(2131230970));
        View inflate = getLayoutInflater().inflate(2130968696, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(2131689767);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(2131689768);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(2131689769);
        checkBox.setText(getString(2131230777));
        checkBox2.setText(getString(2131230791));
        checkBox3.setText(getString(2131230766));
        boolean r = C1309a.m6934a(getApplicationContext()).m6975r();
        boolean t = C1309a.m6934a(getApplicationContext()).m6977t();
        boolean v = C1309a.m6934a(getApplicationContext()).m6979v();
        checkBox.setChecked(r);
        checkBox2.setChecked(t);
        checkBox3.setChecked(v);
        afVar.m3609b(inflate);
        afVar.m3611b(getString(2131230814), null);
        afVar.m3607a(getString(2131230921), new C2537b(this, checkBox, checkBox2, checkBox3));
        afVar.m3612c();
    }

    private void m10892r() {
        af afVar = new af(this, 2131427471);
        afVar.m3606a(getString(2131230969));
        View inflate = getLayoutInflater().inflate(2130968696, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(2131689768);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(2131689769);
        ((CheckBox) inflate.findViewById(2131689767)).setText(getString(2131230777));
        checkBox.setText(getString(2131230791));
        checkBox2.setText(getString(2131230766));
        afVar.m3609b(inflate);
        afVar.m3611b(getString(2131230814), null);
        afVar.m3607a(getString(2131230921), new C2538c(this));
        afVar.m3612c();
    }

    public void m10893a(int i) {
        switch (i) {
            case 2002:
                m10890o();
            case 2003:
                m10891p();
            case 2004:
                m10892r();
            default:
        }
    }

    protected String m10894m() {
        return getString(2131230888);
    }

    protected C2522b m10895n() {
        return new C2539d();
    }
}
