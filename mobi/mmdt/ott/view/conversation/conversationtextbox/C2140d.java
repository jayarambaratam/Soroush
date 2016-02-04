package mobi.mmdt.ott.view.conversation.conversationtextbox;

/* renamed from: mobi.mmdt.ott.view.conversation.conversationtextbox.d */
class C2140d implements Runnable {
    final /* synthetic */ String f6999a;
    final /* synthetic */ ConversationTextBoxFragment f7000b;

    C2140d(ConversationTextBoxFragment conversationTextBoxFragment, String str) {
        this.f7000b = conversationTextBoxFragment;
        this.f6999a = str;
    }

    public void run() {
        this.f7000b.f6979c.setText(this.f6999a);
    }
}
