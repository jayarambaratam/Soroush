package mobi.mmdt.ott.view.conversation.activities;

class aa implements Runnable {
    final /* synthetic */ BulkMessageConversationActivity f6408a;

    aa(BulkMessageConversationActivity bulkMessageConversationActivity) {
        this.f6408a = bulkMessageConversationActivity;
    }

    public void run() {
        this.f6408a.finish();
        this.f6408a.overridePendingTransition(2131034126, 2131034130);
    }
}
