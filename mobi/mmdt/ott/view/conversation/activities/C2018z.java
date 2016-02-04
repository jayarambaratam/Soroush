package mobi.mmdt.ott.view.conversation.activities;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.z */
class C2018z implements Runnable {
    final /* synthetic */ BulkMessageConversationActivity f6560a;

    C2018z(BulkMessageConversationActivity bulkMessageConversationActivity) {
        this.f6560a = bulkMessageConversationActivity;
    }

    public void run() {
        this.f6560a.finish();
        this.f6560a.overridePendingTransition(2131034126, 2131034130);
    }
}
