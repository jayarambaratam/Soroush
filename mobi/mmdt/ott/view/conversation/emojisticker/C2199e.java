package mobi.mmdt.ott.view.conversation.emojisticker;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import mobi.mmdt.ott.provider.p175i.C1635a;
import mobi.mmdt.ott.provider.p175i.C1638d;
import mobi.mmdt.ott.view.conversation.emojisticker.sticker.C2221a;
import mobi.mmdt.ott.view.conversation.emojisticker.sticker.C2222b;
import mobi.mmdt.ott.view.conversation.emojisticker.viewpagerindicator.C2232b;
import mobi.mmdt.ott.view.conversation.emojisticker.viewpagerindicator.C2233c;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.e */
class C2199e implements LoaderCallbacks<Cursor> {
    final /* synthetic */ C2197c f7247a;

    C2199e(C2197c c2197c) {
        this.f7247a = c2197c;
    }

    public void m10057a(Loader<Cursor> loader, Cursor cursor) {
        if (this.f7247a.f7237h != null) {
            C1638d c1638d = new C1638d(cursor);
            String str = BuildConfig.FLAVOR;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (c1638d.moveToFirst()) {
                do {
                    int d = c1638d.m8360d();
                    String g = c1638d.m8363g();
                    if (!c1638d.m8362f()) {
                        linkedHashMap.put(Integer.valueOf(d), g);
                        str = str + d + "_";
                    }
                } while (c1638d.moveToNext());
            }
            String str2 = str;
            if (this.f7247a.f7241l.isEmpty() || !this.f7247a.f7241l.equals(str2)) {
                this.f7247a.f7232c.clear();
                this.f7247a.f7233d.clear();
                this.f7247a.f7238i.removeAllViews();
                this.f7247a.f7232c.addAll(this.f7247a.f7230a);
                this.f7247a.f7233d.addAll(this.f7247a.f7231b);
                int size = this.f7247a.f7232c.size();
                if (linkedHashMap.size() > 0) {
                    int i = size;
                    for (Entry entry : linkedHashMap.entrySet()) {
                        this.f7247a.f7232c.add(C2222b.m10115a(this.f7247a.f7235f, ((Integer) entry.getKey()).intValue()));
                        this.f7247a.f7233d.add(new C2233c(i, ((Integer) entry.getKey()).intValue(), (String) entry.getValue(), (String) entry.getValue()));
                        i++;
                    }
                } else {
                    this.f7247a.f7232c.add(C2221a.m10111a(this.f7247a.f7235f));
                    this.f7247a.f7233d.add(new C2232b(size, 7, 2130838452, 2130838453));
                }
                Iterator it = this.f7247a.f7232c.iterator();
                while (it.hasNext()) {
                    ((C2195a) it.next()).m10033a(this.f7247a);
                }
                this.f7247a.f7237h.m878c();
                this.f7247a.f7240k.m10124a();
                this.f7247a.f7238i.setCurrentItem(0);
            }
            this.f7247a.f7241l = str2;
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1635a.m8335a(this.f7247a.f7235f);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m10057a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
