package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p012b.C0125h;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class db implements Iterable<Intent> {
    private static final dd f934a;
    private final ArrayList<Intent> f935b;
    private final Context f936c;

    static {
        if (VERSION.SDK_INT >= 11) {
            f934a = new df();
        } else {
            f934a = new de();
        }
    }

    private db(Context context) {
        this.f935b = new ArrayList();
        this.f936c = context;
    }

    public static db m1242a(Context context) {
        return new db(context);
    }

    public db m1243a(Activity activity) {
        Intent intent = null;
        if (activity instanceof dc) {
            intent = ((dc) activity).m1248a();
        }
        Intent a = intent == null ? az.m1119a(activity) : intent;
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f936c.getPackageManager());
            }
            m1244a(component);
            m1245a(a);
        }
        return this;
    }

    public db m1244a(ComponentName componentName) {
        int size = this.f935b.size();
        try {
            Intent a = az.m1120a(this.f936c, componentName);
            while (a != null) {
                this.f935b.add(size, a);
                a = az.m1120a(this.f936c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public db m1245a(Intent intent) {
        this.f935b.add(intent);
        return this;
    }

    public void m1246a() {
        m1247a(null);
    }

    public void m1247a(Bundle bundle) {
        if (this.f935b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f935b.toArray(new Intent[this.f935b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!C0125h.m1019a(this.f936c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f936c.startActivity(intent);
        }
    }

    public Iterator<Intent> iterator() {
        return this.f935b.iterator();
    }
}
