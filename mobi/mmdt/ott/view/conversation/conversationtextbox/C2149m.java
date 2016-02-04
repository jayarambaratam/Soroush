package mobi.mmdt.ott.view.conversation.conversationtextbox;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p191g.C1776f;

/* renamed from: mobi.mmdt.ott.view.conversation.conversationtextbox.m */
class C2149m implements Runnable {
    final /* synthetic */ ConversationTextBoxFragment f7013a;

    C2149m(ConversationTextBoxFragment conversationTextBoxFragment) {
        this.f7013a = conversationTextBoxFragment;
    }

    public void run() {
        C1753a.m8688a(new C1776f()).m8701a(200).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7013a.f6988l);
    }
}
