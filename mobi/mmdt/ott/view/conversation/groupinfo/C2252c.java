package mobi.mmdt.ott.view.conversation.groupinfo;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.c */
class C2252c implements Runnable {
    final /* synthetic */ AddParticipantsGroupContactSelectionListActivity f7468a;

    C2252c(AddParticipantsGroupContactSelectionListActivity addParticipantsGroupContactSelectionListActivity) {
        this.f7468a = addParticipantsGroupContactSelectionListActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2253d(this), 50);
        new Handler().postDelayed(new C2254e(this), 100);
    }
}
