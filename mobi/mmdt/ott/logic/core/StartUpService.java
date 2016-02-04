package mobi.mmdt.ott.logic.core;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import mobi.mmdt.componentsutils.p079a.C1107a;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.notifications.notifsData.NewUpdateNotificationService;
import mobi.mmdt.ott.logic.p160f.C1521a;
import mobi.mmdt.ott.p089b.C1165j;
import mobi.mmdt.ott.p109d.p111b.C1309a;

public class StartUpService extends IntentService {
    private C1309a f5038a;

    public StartUpService() {
        super("StartUpService");
    }

    private void m7542a() {
        try {
            if (!this.f5038a.m6971n() && !this.f5038a.m6970m() && this.f5038a.m6973p() && C1107a.m6377b(getApplicationContext())) {
                C1495a.m7555a(getApplicationContext()).m7569a();
            }
        } catch (Throwable e) {
            C1104b.m6363a(this, "Could not get application version!", e);
        }
    }

    public static void m7543a(Context context) {
        Intent intent = new Intent(context, StartUpService.class);
        intent.setAction("mobi.mmdt.ott.logic.action.ACTION_ON_BOOT");
        context.startService(intent);
    }

    public static void m7544a(Context context, C1165j c1165j) {
        Intent intent = new Intent(context, StartUpService.class);
        intent.setAction("mobi.mmdt.ott.logic.action.ACTION_ON_CHAT_CONNECTION_STATE_CHANGED");
        intent.putExtra("mobi.mmdt.ott.logic.action.ACTION_ON_CHAT_CONNECTION_STATE_CHANGED", c1165j);
        context.startService(intent);
    }

    private void m7545a(C1165j c1165j) {
        C1495a.m7555a(getApplicationContext()).m7570a(c1165j);
    }

    private void m7546b() {
        try {
            if (!this.f5038a.m6971n() && !this.f5038a.m6970m() && this.f5038a.m6973p() && C1107a.m6377b(getApplicationContext())) {
                C1495a.m7555a(getApplicationContext()).m7569a();
            }
        } catch (Throwable e) {
            C1104b.m6363a(this, "Could not get application version!", e);
        }
    }

    public static void m7547b(Context context) {
        Intent intent = new Intent(context, StartUpService.class);
        intent.setAction("mobi.mmdt.ott.logic.action.ACTION_ON_SCREEN_TURNED_ON");
        context.startService(intent);
    }

    private void m7548c() {
        C1495a.m7555a(getApplicationContext()).m7572c();
    }

    public static void m7549c(Context context) {
        Intent intent = new Intent(context, StartUpService.class);
        intent.setAction("mobi.mmdt.ott.logic.action.ACTION_ON_APPLICATION_STARTED");
        context.startService(intent);
    }

    private void m7550d() {
        try {
            if (this.f5038a.m6971n() || this.f5038a.m6970m() || !this.f5038a.m6973p() || !C1107a.m6377b(getApplicationContext())) {
                C1495a.m7555a(getApplicationContext()).m7571b();
            } else {
                C1495a.m7555a(getApplicationContext()).m7569a();
            }
        } catch (Throwable e) {
            C1104b.m6363a(this, "Could not get application version!", e);
        }
    }

    public static void m7551d(Context context) {
        Intent intent = new Intent(context, StartUpService.class);
        intent.setAction("mobi.mmdt.ott.logic.action.CONNECTIVITY_CHANGED");
        context.startService(intent);
    }

    private void m7552e() {
        C1495a.m7555a(getApplicationContext()).m7571b();
    }

    public static void m7553e(Context context) {
        Intent intent = new Intent(context, StartUpService.class);
        intent.setAction("mobi.mmdt.ott.logic.action.ACTION_ON_EXIT");
        context.startService(intent);
    }

    public static void m7554f(Context context) {
        Intent intent = new Intent(context, StartUpService.class);
        intent.setAction("mobi.mmdt.ott.logic.action.ACTION_ON_APPLICATION_STARTED");
        context.startService(intent);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void onHandleIntent(Intent intent) {
        this.f5038a = C1309a.m6934a(getApplicationContext());
        C1521a.m7668a(getApplicationContext());
        if (intent != null) {
            String action = intent.getAction();
            if ("mobi.mmdt.ott.logic.action.ACTION_ON_BOOT".equals(action)) {
                startService(new Intent(getApplicationContext(), NewUpdateNotificationService.class));
                m7546b();
            } else if ("mobi.mmdt.ott.logic.action.ACTION_ON_SCREEN_TURNED_ON".equals(action)) {
                m7548c();
            } else if ("mobi.mmdt.ott.logic.action.ACTION_ON_APPLICATION_STARTED".equals(action)) {
                m7542a();
                startService(new Intent(getApplicationContext(), NewUpdateNotificationService.class));
            } else if ("mobi.mmdt.ott.logic.action.CONNECTIVITY_CHANGED".equals(action)) {
                m7550d();
            } else if ("mobi.mmdt.ott.logic.action.ACTION_ON_EXIT".equals(action)) {
                m7552e();
            } else if ("mobi.mmdt.ott.logic.action.ACTION_ON_CHAT_CONNECTION_STATE_CHANGED".equals(action)) {
                m7545a((C1165j) intent.getSerializableExtra("mobi.mmdt.ott.logic.action.ACTION_ON_CHAT_CONNECTION_STATE_CHANGED"));
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Thread thread = new Thread(new C1501g(this, intent));
        thread.setPriority(1);
        thread.start();
        return 1;
    }

    public void onTaskRemoved(Intent intent) {
        m7549c(getApplicationContext());
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
