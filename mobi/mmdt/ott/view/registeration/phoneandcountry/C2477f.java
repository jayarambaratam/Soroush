package mobi.mmdt.ott.view.registeration.phoneandcountry;

import android.content.Intent;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.registeration.activationcode.ActivationCodeActivity;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.f */
class C2477f implements Runnable {
    final /* synthetic */ C2475d f8054a;

    C2477f(C2475d c2475d) {
        this.f8054a = c2475d;
    }

    public void run() {
        String substring = C1309a.m6935f(this.f8054a.f8052a.f7954i.m10671d()).substring(1);
        Intent intent = new Intent(this.f8054a.f8052a.getApplicationContext(), ActivationCodeActivity.class);
        intent.putExtra("KEY_COUNTRY_NAME", this.f8054a.f8052a.f7954i.m10666a());
        intent.putExtra("KEY_COUNTRY_CODE", this.f8054a.f8052a.f7954i.m10669b());
        intent.putExtra("KEY_PHONE_NUMBER", substring);
        this.f8054a.f8052a.startActivity(intent);
        this.f8054a.f8052a.finish();
        this.f8054a.f8052a.overridePendingTransition(2131034125, 2131034129);
    }
}
