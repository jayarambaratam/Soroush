package mobi.mmdt.ott.view.main;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p171e.C1610d;
import mobi.mmdt.ott.view.p178a.aj;

/* renamed from: mobi.mmdt.ott.view.main.d */
class C2383d implements LoaderCallbacks<Cursor> {
    final /* synthetic */ MainActivity f7848a;

    C2383d(MainActivity mainActivity) {
        this.f7848a = mainActivity;
    }

    public void m10580a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToFirst()) {
            C1610d c1610d = new C1610d(cursor);
            String e = c1610d.m8189e();
            CharSequence b = c1610d.m8186b();
            String d = c1610d.m8188d();
            this.f7848a.v.setBackgroundColor(C1111c.m6402b(this.f7848a.getApplicationContext(), e));
            this.f7848a.v.setName(b);
            this.f7848a.v.setTextColor(this.f7848a.getResources().getColor(2131624091));
            if (b != null) {
                this.f7848a.w.setText(b);
            }
            this.f7848a.x.setText(e);
            this.f7848a.v.setImageBitmap(null);
            if (d == null || d.isEmpty()) {
                C0872i.m5267a(this.f7848a.v);
                return;
            }
            C0872i.m5265a(this.f7848a.m8494q()).m5329a(aj.m8474a(d)).m4409a(C0652e.ALL).m4417a(this.f7848a.v);
            C0872i.m5265a(this.f7848a.m8494q()).m5329a(aj.m8474a(d)).m5047j().m4306a(C0652e.SOURCE).m4328c().m4305a(160, 160).m4285a(new C2384e(this, this.f7848a.y));
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1607a.m8165c(this.f7848a.getApplicationContext(), C1309a.m6934a(this.f7848a.getApplicationContext()).m6942b());
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m10580a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
