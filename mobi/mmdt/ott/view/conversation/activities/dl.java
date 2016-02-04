package mobi.mmdt.ott.view.conversation.activities;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import mobi.mmdt.ott.provider.p177k.C1647b;
import mobi.mmdt.ott.provider.p177k.C1652g;
import org.linphone.mediastream.Version;

class dl implements LoaderCallbacks<Cursor> {
    final /* synthetic */ SingleConversationActivity f6521a;

    dl(SingleConversationActivity singleConversationActivity) {
        this.f6521a = singleConversationActivity;
    }

    public void m9621a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToFirst()) {
            C1652g c1652g = C1652g.GONE;
            if (cursor != null && cursor.getCount() > 0) {
                c1652g = C1652g.values()[cursor.getInt(cursor.getColumnIndex("userinchatstates_state"))];
            }
            switch (dk.f6520a[c1652g.ordinal()]) {
                case Version.API03_CUPCAKE_15 /*3*/:
                    this.f6521a.m9430f(this.f6521a.f6403r);
                case Version.API04_DONUT_16 /*4*/:
                    this.f6521a.m9430f(this.f6521a.getString(2131230957));
                case Version.API05_ECLAIR_20 /*5*/:
                    this.f6521a.m9430f(this.f6521a.f6403r);
                default:
            }
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1647b.m8381a(this.f6521a.getApplicationContext(), this.f6521a.f6401p);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m9621a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
