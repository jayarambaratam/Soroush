package mobi.mmdt.ott.view.conversation.emojisticker.sticker;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import mobi.mmdt.ott.view.conversation.emojisticker.C2195a;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.sticker.a */
public class C2221a extends C2195a {
    private FrameLayout f7315b;
    private View f7316c;
    private Activity f7317d;

    private C2221a(Activity activity) {
        this.f7317d = activity;
        this.f7315b = new FrameLayout(this.f7317d);
        m10112b();
        this.f7315b.addView(this.f7316c);
    }

    public static C2221a m10111a(Activity activity) {
        return new C2221a(activity);
    }

    private void m10112b() {
        this.f7316c = this.f7317d.getLayoutInflater().inflate(2130968811, null, false);
    }

    public View m10113a() {
        return this.f7315b;
    }
}
