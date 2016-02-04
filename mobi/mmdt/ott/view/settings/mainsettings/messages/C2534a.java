package mobi.mmdt.ott.view.settings.mainsettings.messages;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.NumberPicker;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.p109d.p111b.C1309a;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.messages.a */
class C2534a implements OnClickListener {
    final /* synthetic */ NumberPicker f8153a;
    final /* synthetic */ MessagesSettingsListActivity f8154b;

    C2534a(MessagesSettingsListActivity messagesSettingsListActivity, NumberPicker numberPicker) {
        this.f8154b = messagesSettingsListActivity;
        this.f8153a = numberPicker;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C1309a.m6934a(this.f8154b.getApplicationContext()).m6951d(this.f8153a.getValue());
        C1490b.m7516a(this.f8154b.getApplicationContext()).m7525c();
        this.f8154b.m10841l();
    }
}
