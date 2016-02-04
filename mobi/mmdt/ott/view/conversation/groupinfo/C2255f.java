package mobi.mmdt.ott.view.conversation.groupinfo;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.f */
class C2255f implements Runnable {
    final /* synthetic */ AddParticipantsGroupContactSelectionListActivity f7471a;

    C2255f(AddParticipantsGroupContactSelectionListActivity addParticipantsGroupContactSelectionListActivity) {
        this.f7471a = addParticipantsGroupContactSelectionListActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2256g(this), 50);
        new Handler().postDelayed(new C2257h(this), 100);
    }
}
