package mobi.mmdt.ott.view.settings.mainsettings;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.design.widget.Snackbar;
import android.widget.RadioGroup;
import mobi.mmdt.ott.MyApplication;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.b */
class C2528b implements OnClickListener {
    final /* synthetic */ RadioGroup f8147a;
    final /* synthetic */ MainSettingsListActivity f8148b;

    C2528b(MainSettingsListActivity mainSettingsListActivity, RadioGroup radioGroup) {
        this.f8148b = mainSettingsListActivity;
        this.f8147a = radioGroup;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        String str = "en-us";
        switch (this.f8147a.getCheckedRadioButtonId()) {
            case 2131689764:
                str = "en-us";
                break;
            case 2131689765:
                str = "fa";
                break;
        }
        MyApplication.m6445a().m6456b(str);
        this.f8148b.m10841l();
        Snackbar.m376a(this.f8148b.i, 2131230925, 0).m395a();
    }
}
