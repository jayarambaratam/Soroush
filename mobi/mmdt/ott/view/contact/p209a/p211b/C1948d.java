package mobi.mmdt.ott.view.contact.p209a.p211b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.contact.p209a.p210a.C1942a;
import mobi.mmdt.ott.view.contact.p209a.p212c.C1954c;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.view.contact.a.b.d */
public class C1948d extends C1712b {
    private Activity f6255a;
    private TextView f6256b;

    public C1948d(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968768, c1790i);
        this.f6255a = activity;
        C0002c.m2a().m14a((Object) this);
        this.f6256b = (TextView) this.itemView.findViewById(2131689908);
    }

    protected void m9254a(C1722f c1722f) {
        C1954c c1954c = (C1954c) c1722f;
        this.f6256b.setText(c1954c.m9270b() + "/" + c1954c.m9268a() + "  " + this.f6255a.getString(2131230824));
    }

    protected void finalize() {
        super.finalize();
        C0002c.m2a().m16b(this);
    }

    public void onEvent(C1942a c1942a) {
        if (this.f6255a != null) {
            this.f6255a.runOnUiThread(new C1949e(this, c1942a));
        }
    }
}
