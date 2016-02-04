package mobi.mmdt.ott.view.conversation.activities;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.provider.p172f.C1619f;
import mobi.mmdt.ott.provider.p173g.C1622c;
import mobi.mmdt.ott.provider.p173g.C1625f;
import mobi.mmdt.ott.view.p178a.aj;

class cx implements LoaderCallbacks<Cursor> {
    final /* synthetic */ GroupConversationActivity f6501a;

    cx(GroupConversationActivity groupConversationActivity) {
        this.f6501a = groupConversationActivity;
    }

    public void m9619a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToFirst()) {
            C1625f c1625f = new C1625f(cursor);
            if (this.f6501a.f6391q.equals(c1625f.m8270b())) {
                this.f6501a.f6390p = c1625f.m8276h();
                this.f6501a.m.setName(c1625f.m8271c());
                this.f6501a.m.setBackgroundColor(C1111c.m6402b(this.f6501a.getApplicationContext(), this.f6501a.f6391q));
                this.f6501a.m9428e(c1625f.m8271c());
                String str = "member";
                int d = C1622c.m8257d(this.f6501a.getApplicationContext(), c1625f.m8270b());
                if (d > 1) {
                    str = "members";
                }
                this.f6501a.f6397w = d + " " + str;
                this.f6501a.m9430f(this.f6501a.f6397w);
                str = c1625f.m8273e();
                if (str == null || str.isEmpty()) {
                    C0872i.m5270b(this.f6501a.getApplicationContext()).m5328a(Integer.valueOf(2130838598)).m4406a(0.25f).m4417a(this.f6501a.m);
                } else {
                    C0872i.m5265a(this.f6501a.m8494q()).m5329a(aj.m8474a(str)).m4407a(2130838598).m4409a(C0652e.ALL).m4417a(this.f6501a.m);
                }
                if (this.f6501a.f6390p == C1619f.VISITOR || this.f6501a.f6390p == C1619f.NONE) {
                    this.f6501a.l.setVisibility(8);
                } else {
                    this.f6501a.l.setVisibility(0);
                }
                if (this.f6501a.f6390p == C1619f.NONE) {
                    this.f6501a.m9430f(null);
                }
                this.f6501a.f6396v = c1625f.m8275g();
                new Handler().postDelayed(new cy(this), 500);
            }
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1622c.m8256c(this.f6501a.getApplicationContext(), this.f6501a.f6391q);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m9619a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
