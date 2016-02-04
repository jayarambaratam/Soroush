package mobi.mmdt.ott.view.conversation.activities;

class ab implements Runnable {
    final /* synthetic */ BulkMessageConversationActivity f6409a;

    ab(BulkMessageConversationActivity bulkMessageConversationActivity) {
        this.f6409a = bulkMessageConversationActivity;
    }

    public void run() {
        this.f6409a.finish();
        this.f6409a.overridePendingTransition(2131034126, 2131034130);
    }
}
