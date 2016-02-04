package mobi.mmdt.ott.view.conversation.groupinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.RadioGroup;
import mobi.mmdt.ott.provider.p172f.C1619f;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.s */
class C2268s implements OnClickListener {
    final /* synthetic */ RadioGroup f7489a;
    final /* synthetic */ String f7490b;
    final /* synthetic */ C1619f f7491c;
    final /* synthetic */ GroupInfoActivity f7492d;

    C2268s(GroupInfoActivity groupInfoActivity, RadioGroup radioGroup, String str, C1619f c1619f) {
        this.f7492d = groupInfoActivity;
        this.f7489a = radioGroup;
        this.f7490b = str;
        this.f7491c = c1619f;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        int checkedRadioButtonId = this.f7489a.getCheckedRadioButtonId();
        C1619f c1619f = C1619f.MEMBER;
        switch (checkedRadioButtonId) {
            case 2131689764:
                c1619f = C1619f.ADMIN;
                break;
            case 2131689765:
                c1619f = C1619f.MEMBER;
                break;
        }
        this.f7492d.m10204a(this.f7490b, this.f7491c, c1619f);
    }
}
