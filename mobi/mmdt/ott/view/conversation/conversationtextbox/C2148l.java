package mobi.mmdt.ott.view.conversation.conversationtextbox;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p191g.C1773c;

/* renamed from: mobi.mmdt.ott.view.conversation.conversationtextbox.l */
class C2148l implements Runnable {
    final /* synthetic */ ConversationTextBoxFragment f7012a;

    C2148l(ConversationTextBoxFragment conversationTextBoxFragment) {
        this.f7012a = conversationTextBoxFragment;
    }

    public void run() {
        this.f7012a.f6990n.setText("00:00");
        C1753a.m8688a(new C1773c()).m8701a(200).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7012a.f6988l);
    }
}
