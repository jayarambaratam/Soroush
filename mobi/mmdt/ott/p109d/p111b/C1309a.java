package mobi.mmdt.ott.p109d.p111b;

import android.content.Context;
import android.content.SharedPreferences;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;

/* renamed from: mobi.mmdt.ott.d.b.a */
public class C1309a {
    private static C1309a f4566a;
    private SharedPreferences f4567b;
    private Context f4568c;

    private C1309a(Context context) {
        this.f4568c = context;
        this.f4567b = context.getSharedPreferences("mobi.mmdt.ott.model.pref.PrefKeys.KEY_MAIN_PREF_1", 0);
    }

    public static C1309a m6934a(Context context) {
        if (f4566a == null) {
            f4566a = new C1309a(context);
        }
        return f4566a;
    }

    public static String m6935f(String str) {
        return str.startsWith("0") ? str : "0" + str;
    }

    public void m6936A() {
        this.f4567b.edit().clear().apply();
    }

    public String m6937a() {
        return this.f4567b.getString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_SETTING_LANGUAGE", "en-us");
    }

    public void m6938a(int i) {
        this.f4567b.edit().putInt("mobi.mmdt.ott.model.pref.KEY_VIRTUAL_KEYBOARD_HEIGHT_PORTRAIT", i).apply();
    }

    public void m6939a(String str) {
        this.f4567b.edit().putString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_SETTING_LANGUAGE", str).apply();
    }

    public void m6940a(C1312d c1312d) {
        this.f4567b.edit().putInt("mobi.mmdt.ott.model.pref.KEY_VIBRATE_MODE", c1312d.ordinal()).apply();
    }

    public void m6941a(boolean z) {
        this.f4567b.edit().putBoolean("mobi.mmdt.ott.model.pref.PrefKeys.KEY_IS_EXITED", z).apply();
    }

    public String m6942b() {
        return this.f4567b.getString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_PROFILE_USER_NAME", C1310b.f4569a);
    }

    public void m6943b(int i) {
        this.f4567b.edit().putInt("mobi.mmdt.ott.model.pref.KEY_VIRTUAL_KEYBOARD_HEIGHT_LANDSCAPE", i).apply();
    }

    public void m6944b(String str) {
        this.f4567b.edit().putString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_PROFILE_USER_NAME", str).apply();
    }

    public void m6945b(boolean z) {
        this.f4567b.edit().putBoolean("mobi.mmdt.ott.model.pref.PrefKeys.KEY_IS_CHANGES_SYNCED", z).apply();
    }

    public int m6946c() {
        return this.f4567b.getInt("mobi.mmdt.ott.model.pref.KEY_VIRTUAL_KEYBOARD_HEIGHT_PORTRAIT", -1);
    }

    public void m6947c(int i) {
        this.f4567b.edit().putInt("mobi.mmdt.ott.model.pref.PrefKeys.KEY_OBSOLETE_VERSION", i).apply();
    }

    public void m6948c(String str) {
        this.f4567b.edit().putString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_PROFILE_COUNTRY_CODE", str).apply();
    }

    public void m6949c(boolean z) {
        this.f4567b.edit().putBoolean("mobi.mmdt.ott.model.pref.PrefKeys.KEY_CONTACTS_SYNCED", z).apply();
    }

    public int m6950d() {
        return this.f4567b.getInt("mobi.mmdt.ott.model.pref.KEY_VIRTUAL_KEYBOARD_HEIGHT_LANDSCAPE", -1);
    }

    public void m6951d(int i) {
        this.f4567b.edit().putInt("mobi.mmdt.ott.model.pref.KEY_FONT_SIZE", i).apply();
    }

    public void m6952d(String str) {
        this.f4567b.edit().putString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_PROFILE_PHONE_NUMBER", str).apply();
    }

    public void m6953d(boolean z) {
        this.f4567b.edit().putBoolean("mobi.mmdt.ott.model.pref.PrefKeys.KEY_TIME_SYNCED", z).apply();
    }

    public String m6954e() {
        return this.f4567b.getString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_PROFILE_COUNTRY_CODE", C1310b.f4570b);
    }

    public void m6955e(String str) {
        this.f4567b.edit().putString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_PROFILE_PIN_CODE", str).apply();
    }

    public void m6956e(boolean z) {
        this.f4567b.edit().putBoolean("mobi.mmdt.ott.model.pref.KEY_IS_AUTO_DOWNLOAD_WIFI_IMAGE", z).apply();
    }

    public String m6957f() {
        return this.f4567b.getString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_PROFILE_PHONE_NUMBER", C1310b.f4571c);
    }

    public void m6958f(boolean z) {
        this.f4567b.edit().putBoolean("mobi.mmdt.ott.model.pref.KEY_IS_AUTO_DOWNLOAD_MOBILE_IMAGE", z).apply();
    }

    public String m6959g() {
        return this.f4567b.getString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_PROFILE_PIN_CODE", C1310b.f4572d);
    }

    public void m6960g(boolean z) {
        this.f4567b.edit().putBoolean("mobi.mmdt.ott.model.pref.KEY_IS_AUTO_DOWNLOAD_WIFI_VIDEO", z).apply();
    }

    public String m6961h() {
        return C1104b.f4137a ? this.f4567b.getString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_DEBUG_HTTP_WEBSERVICE_ADDRESS", "http://debug.wslb.soroush-hamrah.ir/") : this.f4567b.getString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_HTTP_WEBSERVICE_ADDRESS", "http://wslb.soroush-hamrah.ir/");
    }

    public void m6962h(boolean z) {
        this.f4567b.edit().putBoolean("mobi.mmdt.ott.model.pref.KEY_IS_AUTO_DOWNLOAD_MOBILE_VIDEO", z).apply();
    }

    public String m6963i() {
        return C1104b.f4137a ? this.f4567b.getString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_DEBUG_HTTPS_WEBSERVICE_ADDRESS", "https://debug.wslb.soroush-hamrah.ir/") : this.f4567b.getString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_HTTPS_WEBSERVICE_ADDRESS", "https://wslb.soroush-hamrah.ir/");
    }

    public void m6964i(boolean z) {
        this.f4567b.edit().putBoolean("mobi.mmdt.ott.model.pref.KEY_IS_AUTO_DOWNLOAD_WIFI_FILE", z).apply();
    }

    public String m6965j() {
        return C1104b.f4137a ? this.f4567b.getString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_DEBUG_HTTP_WEBSERVICE_STICKER_ADDRESS", "http://debug.ws.stickers.soroush-hamrah.ir/") : this.f4567b.getString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_HTTP_WEBSERVICE_STICKER_ADDRESS", "http://ws.stickers.soroush-hamrah.ir/");
    }

    public void m6966j(boolean z) {
        this.f4567b.edit().putBoolean("mobi.mmdt.ott.model.pref.KEY_IS_AUTO_DOWNLOAD_MOBILE_FILE", z).apply();
    }

    public String m6967k() {
        return C1104b.f4137a ? this.f4567b.getString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_DEBUG_HTTPS_FILES_WEBSERVICE_ADDRESS", "https://debug.fs.soroush-hamrah.ir/") : this.f4567b.getString("mobi.mmdt.ott.model.pref.PrefKeys.KEY_HTTPS_FILES_WEBSERVICE_ADDRESS", "https://fs.soroush-hamrah.ir/");
    }

    public void m6968k(boolean z) {
        this.f4567b.edit().putBoolean("mobi.mmdt.ott.model.pref.KEY_IS_DEFAULT_SAVE_TO_GALLERY", z).apply();
    }

    public int m6969l() {
        return this.f4567b.getInt("mobi.mmdt.ott.model.pref.PrefKeys.KEY_OBSOLETE_VERSION", -1);
    }

    public boolean m6970m() {
        return this.f4568c.getPackageManager().getPackageInfo(this.f4568c.getPackageName(), 0).versionCode <= m6969l();
    }

    public boolean m6971n() {
        return this.f4567b.getBoolean("mobi.mmdt.ott.model.pref.PrefKeys.KEY_IS_EXITED", false);
    }

    public boolean m6972o() {
        return this.f4567b.getBoolean("mobi.mmdt.ott.model.pref.PrefKeys.KEY_IS_CHANGES_SYNCED", false);
    }

    public boolean m6973p() {
        return (m6942b() == null || m6959g() == null) ? false : true;
    }

    public boolean m6974q() {
        return this.f4567b.getBoolean("mobi.mmdt.ott.model.pref.PrefKeys.KEY_CONTACTS_SYNCED", false);
    }

    public boolean m6975r() {
        return this.f4567b.getBoolean("mobi.mmdt.ott.model.pref.KEY_IS_AUTO_DOWNLOAD_WIFI_IMAGE", true);
    }

    public boolean m6976s() {
        return this.f4567b.getBoolean("mobi.mmdt.ott.model.pref.KEY_IS_AUTO_DOWNLOAD_MOBILE_IMAGE", true);
    }

    public boolean m6977t() {
        return this.f4567b.getBoolean("mobi.mmdt.ott.model.pref.KEY_IS_AUTO_DOWNLOAD_WIFI_VIDEO", false);
    }

    public boolean m6978u() {
        return this.f4567b.getBoolean("mobi.mmdt.ott.model.pref.KEY_IS_AUTO_DOWNLOAD_MOBILE_VIDEO", false);
    }

    public boolean m6979v() {
        return this.f4567b.getBoolean("mobi.mmdt.ott.model.pref.KEY_IS_AUTO_DOWNLOAD_WIFI_FILE", false);
    }

    public boolean m6980w() {
        return this.f4567b.getBoolean("mobi.mmdt.ott.model.pref.KEY_IS_AUTO_DOWNLOAD_MOBILE_FILE", false);
    }

    public boolean m6981x() {
        return this.f4567b.getBoolean("mobi.mmdt.ott.model.pref.KEY_IS_DEFAULT_SAVE_TO_GALLERY", false);
    }

    public C1312d m6982y() {
        return C1312d.values()[this.f4567b.getInt("mobi.mmdt.ott.model.pref.KEY_VIBRATE_MODE", C1310b.f4573e.ordinal())];
    }

    public int m6983z() {
        return this.f4567b.getInt("mobi.mmdt.ott.model.pref.KEY_FONT_SIZE", 16);
    }
}
