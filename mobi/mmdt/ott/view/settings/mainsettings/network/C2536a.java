package mobi.mmdt.ott.view.settings.mainsettings.network;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import mobi.mmdt.ott.p109d.p111b.C1309a;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.network.a */
class C2536a implements OnClickListener {
    final /* synthetic */ CheckBox f8155a;
    final /* synthetic */ CheckBox f8156b;
    final /* synthetic */ CheckBox f8157c;
    final /* synthetic */ NetworkSettingsListActivity f8158d;

    C2536a(NetworkSettingsListActivity networkSettingsListActivity, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3) {
        this.f8158d = networkSettingsListActivity;
        this.f8155a = checkBox;
        this.f8156b = checkBox2;
        this.f8157c = checkBox3;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C1309a.m6934a(this.f8158d.getApplicationContext()).m6958f(this.f8155a.isChecked());
        C1309a.m6934a(this.f8158d.getApplicationContext()).m6962h(this.f8156b.isChecked());
        C1309a.m6934a(this.f8158d.getApplicationContext()).m6966j(this.f8157c.isChecked());
        this.f8158d.m10841l();
    }
}
