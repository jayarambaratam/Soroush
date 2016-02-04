package mobi.mmdt.ott.view.conversation.activities;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import java.util.ArrayList;
import mobi.mmdt.ott.provider.p172f.C1619f;
import mobi.mmdt.ott.provider.p177k.C1647b;
import mobi.mmdt.ott.provider.p177k.C1652g;
import mobi.mmdt.ott.view.p178a.ah;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

class cz implements LoaderCallbacks<Cursor> {
    final /* synthetic */ GroupConversationActivity f6503a;

    cz(GroupConversationActivity groupConversationActivity) {
        this.f6503a = groupConversationActivity;
    }

    public void m9620a(Loader<Cursor> loader, Cursor cursor) {
        C1652g c1652g = C1652g.GONE;
        ArrayList arrayList = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                int i = cursor.getInt(cursor.getColumnIndex("userinchatstates_state"));
                arrayList.add(ah.m8470b(cursor.getString(cursor.getColumnIndex("members_nick_name")), cursor.getString(cursor.getColumnIndex("members_user_id"))));
                c1652g = C1652g.values()[i];
            } while (cursor.moveToNext());
        }
        if (this.f6503a.f6390p == C1619f.NONE) {
            this.f6503a.m9430f(null);
            return;
        }
        switch (cv.f6499a[c1652g.ordinal()]) {
            case VideoSize.CIF /*1*/:
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6503a.m9430f(this.f6503a.f6397w);
            case Version.API04_DONUT_16 /*4*/:
                if (arrayList.size() == 1) {
                    this.f6503a.m9430f(((String) arrayList.get(0)) + " " + this.f6503a.getString(2131230874));
                } else if (arrayList.size() > 1) {
                    this.f6503a.m9430f(arrayList.size() + " " + this.f6503a.getString(2131230963));
                }
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6503a.m9430f(this.f6503a.f6397w);
            default:
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1647b.m8382a(this.f6503a.getApplicationContext(), this.f6503a.f6391q, this.f6503a.f6392r);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m9620a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
