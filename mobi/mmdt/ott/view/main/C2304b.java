package mobi.mmdt.ott.view.main;

import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.main.b */
class C2304b implements Runnable {
    final /* synthetic */ MainActivity f7613a;

    C2304b(MainActivity mainActivity) {
        this.f7613a = mainActivity;
    }

    public void run() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setType("vnd.android-dir/mms-sms");
        intent.putExtra("sms_body", this.f7613a.getString(2131230873));
        this.f7613a.startActivity(intent);
        this.f7613a.overridePendingTransition(2131034125, 2131034129);
    }
}
