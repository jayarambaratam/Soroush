package mobi.mmdt.ott.view.registeration.phoneandcountry;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.k */
class C2482k implements Runnable {
    final /* synthetic */ String f8059a;
    final /* synthetic */ String f8060b;
    final /* synthetic */ PhoneAndCountryActivity f8061c;

    C2482k(PhoneAndCountryActivity phoneAndCountryActivity, String str, String str2) {
        this.f8061c = phoneAndCountryActivity;
        this.f8059a = str;
        this.f8060b = str2;
    }

    public void run() {
        if (!this.f8061c.f7954i.m10670c()) {
            this.f8061c.f7954i.m10668a(this.f8059a, this.f8060b);
        }
    }
}
