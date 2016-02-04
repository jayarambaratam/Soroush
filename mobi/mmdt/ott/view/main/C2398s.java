package mobi.mmdt.ott.view.main;

import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.main.s */
class C2398s implements Runnable {
    final /* synthetic */ String f7865a;
    final /* synthetic */ String f7866b;
    final /* synthetic */ NewGroupActivity f7867c;

    C2398s(NewGroupActivity newGroupActivity, String str, String str2) {
        this.f7867c = newGroupActivity;
        this.f7865a = str;
        this.f7866b = str2;
    }

    public void run() {
        Intent intent = new Intent(this.f7867c.getApplicationContext(), NewGroupContactSelectionListActivity.class);
        intent.putExtra("KEY_GROUP_NAME", this.f7865a);
        intent.putExtra("KEY_GROUP_MOTTO", this.f7866b);
        intent.putExtra("KEY_GROUP_IMAGE", this.f7867c.m);
        this.f7867c.startActivity(intent);
        this.f7867c.overridePendingTransition(2131034125, 2131034129);
        this.f7867c.finish();
    }
}
