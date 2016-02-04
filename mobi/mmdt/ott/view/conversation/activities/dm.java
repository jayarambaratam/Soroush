package mobi.mmdt.ott.view.conversation.activities;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p171e.C1610d;
import mobi.mmdt.ott.view.p178a.ah;
import mobi.mmdt.ott.view.p178a.aj;
import net.frakbot.glowpadbackport.BuildConfig;

class dm implements LoaderCallbacks<Cursor> {
    final /* synthetic */ SingleConversationActivity f6522a;

    dm(SingleConversationActivity singleConversationActivity) {
        this.f6522a = singleConversationActivity;
    }

    public void m9622a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToFirst()) {
            C1610d c1610d = new C1610d(cursor);
            String k = c1610d.m8195k();
            String b = c1610d.m8186b();
            String e = c1610d.m8189e();
            String d = c1610d.m8188d();
            String m = c1610d.m8197m();
            long longValue = c1610d.m8191g().longValue();
            String a = c1610d.m8192h() ? ah.m8469a(k, c1610d.m8190f()) : ah.m8470b(b, e);
            this.f6522a.m9428e(a);
            if (longValue != -1) {
                k = C1111c.m6411d(this.f6522a.getApplicationContext(), longValue);
                this.f6522a.f6403r = k;
                this.f6522a.m9430f(k);
            } else {
                this.f6522a.m9430f(BuildConfig.FLAVOR);
            }
            this.f6522a.m.setName(a);
            this.f6522a.m.setBackgroundColor(C1111c.m6402b(this.f6522a.getApplicationContext(), e));
            if (d != null && !d.isEmpty()) {
                C0872i.m5265a(this.f6522a.m8494q()).m5329a(aj.m8474a(d)).m4409a(C0652e.ALL).m4406a(0.25f).m4417a(this.f6522a.m);
            } else if (m == null || m.isEmpty()) {
                C0872i.m5267a(this.f6522a.m);
            } else {
                C0872i.m5265a(this.f6522a.m8494q()).m5329a(m).m4406a(0.25f).m4417a(this.f6522a.m);
            }
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1607a.m8165c(this.f6522a.getApplicationContext(), this.f6522a.f6401p);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m9622a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
