package mobi.mmdt.ott.view.conversation.conversationtextbox;

/* renamed from: mobi.mmdt.ott.view.conversation.conversationtextbox.n */
class C2150n implements Runnable {
    final /* synthetic */ ConversationTextBoxFragment f7014a;

    C2150n(ConversationTextBoxFragment conversationTextBoxFragment) {
        this.f7014a = conversationTextBoxFragment;
    }

    public void run() {
        this.f7014a.f6991o.rightMargin = 0;
        this.f7014a.f6989m.setLayoutParams(this.f7014a.f6991o);
    }
}
