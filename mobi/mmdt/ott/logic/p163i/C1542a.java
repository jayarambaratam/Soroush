package mobi.mmdt.ott.logic.p163i;

import android.content.Context;
import android.database.ContentObserver;
import mobi.mmdt.ott.logic.C1502d;

/* renamed from: mobi.mmdt.ott.logic.i.a */
public class C1542a extends ContentObserver {
    private Context f5195a;

    public C1542a(Context context) {
        super(null);
        this.f5195a = context;
        C1502d.m7573a(this.f5195a);
    }

    public void onChange(boolean z) {
        super.onChange(z);
        C1502d.m7573a(this.f5195a);
    }
}
