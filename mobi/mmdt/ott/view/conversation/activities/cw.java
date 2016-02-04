package mobi.mmdt.ott.view.conversation.activities;

import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p131b.C1408f;

class cw implements Runnable {
    final /* synthetic */ GroupConversationActivity f6500a;

    cw(GroupConversationActivity groupConversationActivity) {
        this.f6500a = groupConversationActivity;
    }

    public void run() {
        C1494c.m7541c(new C1408f(this.f6500a.getApplicationContext(), this.f6500a.f6391q));
    }
}
