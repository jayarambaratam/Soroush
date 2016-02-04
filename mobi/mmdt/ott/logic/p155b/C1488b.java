package mobi.mmdt.ott.logic.p155b;

import android.content.Context;
import java.util.Timer;

/* renamed from: mobi.mmdt.ott.logic.b.b */
public class C1488b {
    private static C1488b f5011a;
    private Context f5012b;
    private Timer f5013c;
    private boolean f5014d;

    private C1488b(Context context) {
        this.f5014d = false;
        this.f5012b = context;
        this.f5013c = new Timer();
    }

    public static C1488b m7514a(Context context) {
        if (f5011a == null) {
            f5011a = new C1488b(context);
        }
        return f5011a;
    }

    public synchronized void m7515a() {
        if (!this.f5014d) {
            this.f5014d = true;
            this.f5013c.schedule(new C1489c(this), 60000, 60000);
        }
    }
}
