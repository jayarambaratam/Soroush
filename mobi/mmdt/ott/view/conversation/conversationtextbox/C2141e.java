package mobi.mmdt.ott.view.conversation.conversationtextbox;

import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.conversation.conversationtextbox.e */
class C2141e implements Runnable {
    final /* synthetic */ ConversationTextBoxFragment f7001a;

    C2141e(ConversationTextBoxFragment conversationTextBoxFragment) {
        this.f7001a = conversationTextBoxFragment;
    }

    public void run() {
        this.f7001a.f6979c.setText(BuildConfig.FLAVOR);
    }
}
