package mobi.mmdt.componentsutils.view.p085a;

import android.app.Activity;
import android.app.Dialog;
import android.widget.TextView;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1118e;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.componentsutils.C1120g;
import mobi.mmdt.componentsutils.p079a.C1111c;

/* renamed from: mobi.mmdt.componentsutils.view.a.a */
public class C1123a {
    private static C1123a f4149e;
    private Activity f4150a;
    private Dialog f4151b;
    private TextView f4152c;
    private ProgressWheel f4153d;

    private C1123a(Activity activity) {
        this.f4150a = activity;
        this.f4151b = new Dialog(activity);
        this.f4151b.requestWindowFeature(1);
        this.f4151b.setContentView(C1120g.dialog_wait);
        this.f4152c = (TextView) this.f4151b.findViewById(C1119f.textView);
        this.f4153d = (ProgressWheel) this.f4151b.findViewById(C1119f.progress_wheel);
        this.f4151b.getWindow().setBackgroundDrawableResource(C1118e.transparent);
        this.f4151b.setOnDismissListener(new C1124b(this));
        this.f4153d.m6354c();
    }

    public static C1123a m6432a(Activity activity) {
        if (f4149e == null) {
            f4149e = new C1123a(activity);
        }
        return f4149e;
    }

    public void m6437a() {
        if (this.f4151b != null && this.f4151b.isShowing()) {
            this.f4150a.runOnUiThread(new C1127e(this));
        }
    }

    public void m6438a(int i, boolean z) {
        if (this.f4150a != null && !this.f4150a.isFinishing()) {
            C1111c.m6405b(this.f4150a);
            this.f4150a.runOnUiThread(new C1126d(this, i, z));
        }
    }

    public void m6439a(boolean z) {
        if (this.f4150a != null && !this.f4150a.isFinishing()) {
            C1111c.m6405b(this.f4150a);
            this.f4150a.runOnUiThread(new C1125c(this, z));
        }
    }
}
