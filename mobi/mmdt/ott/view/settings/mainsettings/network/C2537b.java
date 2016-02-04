package mobi.mmdt.ott.view.settings.mainsettings.network;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import mobi.mmdt.ott.p109d.p111b.C1309a;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.network.b */
class C2537b implements OnClickListener {
    final /* synthetic */ CheckBox f8159a;
    final /* synthetic */ CheckBox f8160b;
    final /* synthetic */ CheckBox f8161c;
    final /* synthetic */ NetworkSettingsListActivity f8162d;

    C2537b(NetworkSettingsListActivity networkSettingsListActivity, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3) {
        this.f8162d = networkSettingsListActivity;
        this.f8159a = checkBox;
        this.f8160b = checkBox2;
        this.f8161c = checkBox3;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C1309a.m6934a(this.f8162d.getApplicationContext()).m6956e(this.f8159a.isChecked());
        C1309a.m6934a(this.f8162d.getApplicationContext()).m6960g(this.f8160b.isChecked());
        C1309a.m6934a(this.f8162d.getApplicationContext()).m6964i(this.f8161c.isChecked());
        this.f8162d.m10841l();
    }
}
