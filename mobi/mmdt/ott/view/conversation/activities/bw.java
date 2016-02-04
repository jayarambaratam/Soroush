package mobi.mmdt.ott.view.conversation.activities;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.provider.p168b.C1573b;
import mobi.mmdt.ott.provider.p168b.C1576e;
import mobi.mmdt.ott.provider.p172f.C1619f;
import mobi.mmdt.ott.view.p178a.aj;

class bw implements LoaderCallbacks<Cursor> {
    final /* synthetic */ ChannelConversationActivity f6464a;

    bw(ChannelConversationActivity channelConversationActivity) {
        this.f6464a = channelConversationActivity;
    }

    public void m9618a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToFirst()) {
            C1576e c1576e = new C1576e(cursor);
            if (this.f6464a.f6380q.equals(c1576e.m7938a())) {
                this.f6464a.f6379p = c1576e.m7946i();
                this.f6464a.m.setName(c1576e.m7939b());
                this.f6464a.m.setBackgroundColor(C1111c.m6402b(this.f6464a.getApplicationContext(), this.f6464a.f6380q));
                this.f6464a.m9428e(c1576e.m7939b());
                this.f6464a.m9430f(C1111c.m6407c(c1576e.m7944g()));
                String d = c1576e.m7941d();
                if (d == null || d.isEmpty()) {
                    C0872i.m5270b(this.f6464a.getApplicationContext()).m5328a(Integer.valueOf(2130838594)).m4406a(0.25f).m4417a(this.f6464a.m);
                } else {
                    C0872i.m5265a(this.f6464a.m8494q()).m5329a(aj.m8474a(d)).m4407a(2130838594).m4409a(C0652e.ALL).m4417a(this.f6464a.m);
                }
                if (this.f6464a.f6379p != C1619f.NONE) {
                    this.f6464a.f6386w = true;
                    this.f6464a.f6387x.setVisibility(8);
                } else {
                    this.f6464a.f6386w = false;
                    this.f6464a.f6387x.setVisibility(0);
                    this.f6464a.runOnUiThread(new bx(this));
                }
                if (this.f6464a.f6379p == C1619f.VISITOR || this.f6464a.f6379p == C1619f.NONE) {
                    this.f6464a.l.setVisibility(8);
                } else {
                    this.f6464a.l.setVisibility(0);
                }
                this.f6464a.f6385v = c1576e.m7945h();
                new Handler().postDelayed(new bz(this), 500);
            }
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1573b.m7926d(this.f6464a.getApplicationContext(), this.f6464a.f6380q);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m9618a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
