package mobi.mmdt.ott.view.settings.mainsettings.notifications;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.RadioGroup;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.p109d.p111b.C1312d;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.notifications.a */
class C2540a implements OnClickListener {
    final /* synthetic */ RadioGroup f8164a;
    final /* synthetic */ NotificationsSettingsListActivity f8165b;

    C2540a(NotificationsSettingsListActivity notificationsSettingsListActivity, RadioGroup radioGroup) {
        this.f8165b = notificationsSettingsListActivity;
        this.f8164a = radioGroup;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C1312d c1312d;
        switch (this.f8164a.getCheckedRadioButtonId()) {
            case 2131689764:
                c1312d = C1312d.DISABLE;
                break;
            case 2131689765:
                c1312d = C1312d.DEFAULT;
                break;
            case 2131689771:
                c1312d = C1312d.SHORT;
                break;
            case 2131689772:
                c1312d = C1312d.LONG;
                break;
            default:
                c1312d = C1312d.DEFAULT;
                break;
        }
        C1309a.m6934a(this.f8165b.getApplicationContext()).m6940a(c1312d);
        this.f8165b.m10841l();
    }
}
