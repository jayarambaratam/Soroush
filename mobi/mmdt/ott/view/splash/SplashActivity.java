package mobi.mmdt.ott.view.splash;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import java.util.List;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.conversation.forward.ForwardActivity;
import mobi.mmdt.ott.view.main.MainActivity;
import mobi.mmdt.ott.view.p178a.ac;
import net.frakbot.glowpadbackport.BuildConfig;
import org.apache.http.myHttp.protocol.HTTP;

public class SplashActivity extends C1685b {
    private SplashFragment f8211i;
    private boolean f8212j;

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        boolean m;
        super.onCreate(bundle);
        this.f8212j = true;
        setContentView(2130968628);
        m3618a((Toolbar) findViewById(2131689633));
        m3625h().m3576b();
        this.f8211i = (SplashFragment) getFragmentManager().findFragmentById(2131689691);
        if (!(this.f8211i == null || this.f8211i.isDetached())) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.detach(this.f8211i);
            beginTransaction.commit();
        }
        ac.m8459a(getApplicationContext());
        try {
            m = C1309a.m6934a(getApplicationContext()).m6970m();
        } catch (NameNotFoundException e) {
            C1104b.m6362a((Object) SplashActivity.class, e.getMessage());
            m = false;
        }
        if (!m) {
            C1309a.m6934a(getApplicationContext()).m6941a(false);
            if (!C1309a.m6934a(getApplicationContext()).m6973p()) {
                new Handler().postDelayed(new C2567c(this), 1000);
            } else if (C1607a.m8152a(getApplicationContext(), C1309a.m6934a(getApplicationContext()).m6942b()) == null) {
                C1309a.m6934a(getApplicationContext()).m6936A();
                new Handler().postDelayed(new C2565a(this), 1000);
            } else {
                Uri data = getIntent().getData();
                String action = getIntent().getAction();
                String type = getIntent().getType();
                if ("android.intent.action.SEND".equals(action) && type != null && getIntent().getExtras() != null) {
                    Intent intent = new Intent(getApplicationContext(), ForwardActivity.class);
                    intent.setType(getIntent().getType());
                    intent.setAction(getIntent().getAction());
                    intent.putExtras(getIntent().getExtras());
                    startActivity(intent);
                    finish();
                    overridePendingTransition(2131034125, 2131034129);
                } else if (!"android.intent.action.VIEW".equals(action) || data == null) {
                    new Handler().postDelayed(new C2566b(this), 1000);
                } else {
                    type = data.getScheme();
                    String host = data.getHost();
                    List pathSegments = data.getPathSegments();
                    Intent intent2;
                    if (type.equals("https") && host.equals("soroush-app.me") && pathSegments.size() == 2 && ((String) pathSegments.get(0)).equals("channel")) {
                        action = (String) pathSegments.get(1);
                        intent2 = new Intent(getApplicationContext(), MainActivity.class);
                        intent2.putExtra("KEY_PAGE_START", mobi.mmdt.ott.view.main.basenavigation.ac.BOTTOM.ordinal());
                        intent2.putExtra("KEY_START_CHANNEL_PARTY", action);
                        startActivity(intent2);
                        finish();
                        overridePendingTransition(2131034125, 2131034129);
                    } else if (type.equals("soroush") && host.equals("channel") && pathSegments.size() == 1) {
                        action = (String) pathSegments.get(0);
                        intent2 = new Intent(getApplicationContext(), MainActivity.class);
                        intent2.putExtra("KEY_PAGE_START", mobi.mmdt.ott.view.main.basenavigation.ac.BOTTOM.ordinal());
                        intent2.putExtra("KEY_START_CHANNEL_PARTY", action);
                        startActivity(intent2);
                        finish();
                    } else if (type.equals("soroush") && host.equals("share")) {
                        action = data.getEncodedSchemeSpecificPart();
                        int indexOf = action.indexOf("share?");
                        if (indexOf != -1) {
                            action = action.substring(indexOf).replaceFirst("share\\?", BuildConfig.FLAVOR);
                            intent2 = new Intent(getApplicationContext(), ForwardActivity.class);
                            intent2.setType(HTTP.PLAIN_TEXT_TYPE);
                            intent2.setAction("android.intent.action.SEND");
                            intent2.putExtra("android.intent.extra.TEXT", action);
                            startActivity(intent2);
                            finish();
                            overridePendingTransition(2131034125, 2131034129);
                        }
                    }
                }
            }
            MyApplication.m6445a().m6451a(getFragmentManager());
        }
        new Handler().postDelayed(new C2568d(this), 2000);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f8212j = false;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }
}
