package mobi.mmdt.ott.view.conversation.groupinfo;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import mobi.mmdt.ott.provider.p172f.C1614a;
import mobi.mmdt.ott.provider.p173g.C1622c;
import mobi.mmdt.ott.provider.p173g.C1625f;
import mobi.mmdt.ott.view.p178a.aj;
import net.frakbot.glowpadbackport.BuildConfig;

class an implements LoaderCallbacks<Cursor> {
    final /* synthetic */ GroupInfoActivity f7440a;

    an(GroupInfoActivity groupInfoActivity) {
        this.f7440a = groupInfoActivity;
    }

    public void m10257a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToFirst()) {
            C1625f c1625f = new C1625f(cursor);
            String str = "member";
            CharSequence charSequence = "Member";
            int c = C1614a.m8233c(this.f7440a.getApplicationContext(), c1625f.m8270b());
            if (c > 1) {
                str = "members";
                charSequence = "Members";
            }
            this.f7440a.f7397G = c1625f.m8276h();
            this.f7440a.f7405p.setText(charSequence);
            this.f7440a.m8561b(c + " " + str);
            this.f7440a.m8559a(c1625f.m8271c());
            this.f7440a.f7408s.setText(c1625f.m8271c());
            this.f7440a.f7399I = c1625f.m8271c();
            if (this.f7440a.f7415z || !(c1625f.m8274f() == null || c1625f.m8274f().isEmpty())) {
                this.f7440a.f7407r.setVisibility(0);
                this.f7440a.f7411v.setVisibility(0);
                this.f7440a.f7410u.setVisibility(0);
                this.f7440a.f7404o.setText(c1625f.m8274f());
            } else {
                this.f7440a.f7407r.setVisibility(8);
                this.f7440a.f7411v.setVisibility(8);
                this.f7440a.f7410u.setVisibility(8);
            }
            String e = c1625f.m8273e();
            this.f7440a.f7398H = c1625f.m8272d();
            if (this.f7440a.m == null || this.f7440a.m.isEmpty()) {
                if (e == null || e.isEmpty()) {
                    this.f7440a.f7398H = null;
                    this.f7440a.m8569n();
                    this.f7440a.m8566d(null);
                } else {
                    this.f7440a.m = BuildConfig.FLAVOR;
                    this.f7440a.m8564c(aj.m8474a(e));
                    this.f7440a.m8566d(aj.m8474a(e));
                }
            }
            this.f7440a.m10237s();
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1622c.m8256c(this.f7440a.getApplicationContext(), this.f7440a.f7414y);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m10257a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
