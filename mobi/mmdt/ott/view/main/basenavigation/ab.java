package mobi.mmdt.ott.view.main.basenavigation;

import android.app.Activity;
import android.view.View;

public abstract class ab {
    protected View f7572a;
    private Activity f7573b;

    public ab(Activity activity) {
        this.f7573b = activity;
    }

    public abstract void m10380a(String str);

    public Activity m10381b() {
        return this.f7573b;
    }

    public View m10382c() {
        return this.f7572a;
    }
}
