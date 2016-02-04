package mobi.mmdt.ott.view.conversation.groupinfo;

import android.os.Handler;
import mobi.mmdt.componentsutils.view.p085a.C1123a;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.a */
class C2249a implements Runnable {
    final /* synthetic */ AddParticipantsGroupContactSelectionListActivity f7424a;

    C2249a(AddParticipantsGroupContactSelectionListActivity addParticipantsGroupContactSelectionListActivity) {
        this.f7424a = addParticipantsGroupContactSelectionListActivity;
    }

    public void run() {
        C1123a.m6432a(this.f7424a.m8494q()).m6439a(false);
        new Handler().postDelayed(new C2251b(this), 100);
    }
}
