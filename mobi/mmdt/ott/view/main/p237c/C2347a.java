package mobi.mmdt.ott.view.main.p237c;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.af;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cocosw.bottomsheet.C1003l;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1401e;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1402f;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p131b.C1410h;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.main.basenavigation.ab;
import mobi.mmdt.ott.view.main.p237c.p244b.C2348a;
import mobi.mmdt.ott.view.p178a.C1659a;
import mobi.mmdt.ott.view.p178a.ah;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.view.main.c.a */
public class C2347a extends ab implements LoaderCallbacks<Cursor>, C1790i {
    private ViewGroup f7754b;
    private RecyclerView f7755c;
    private C2365p f7756d;
    private C2288q f7757e;
    private boolean f7758f;
    private int f7759g;
    private boolean f7760h;
    private String f7761i;

    private C2347a(Activity activity, C2288q c2288q) {
        super(activity);
        this.f7758f = true;
        C0002c.m2a().m14a((Object) this);
        this.f7757e = c2288q;
        this.a = LayoutInflater.from(activity).inflate(2130968719, null, false);
        m10508a();
    }

    public static C2347a m10507a(Activity activity, C2288q c2288q) {
        return new C2347a(activity, c2288q);
    }

    private void m10508a() {
        this.f7759g = C1111c.m6389a(m10381b());
        this.f7754b = (ViewGroup) this.a.findViewById(2131689631);
        this.f7755c = (RecyclerView) this.a.findViewById(2131689797);
        this.f7756d = new C2365p(this, m10381b());
        this.f7761i = C1309a.m6934a(m10381b()).m6942b();
        Bundle bundle = new Bundle();
        bundle.putString("searchPattern", BuildConfig.FLAVOR);
        m10381b().getLoaderManager().initLoader(8, bundle, this);
        this.f7755c.setHasFixedSize(true);
        this.f7755c.setAdapter(this.f7756d);
        m10523a(this.f7755c);
        this.f7755c.addOnScrollListener(new C2351b(this));
    }

    private void m10513b(String str) {
        af afVar = new af(m10381b(), 2131427471);
        afVar.m3610b(m10381b().getString(2131230801));
        afVar.m3607a(m10381b().getString(2131230760), new C2353d(this, str));
        afVar.m3611b(m10381b().getString(2131230813), null);
        afVar.m3612c();
    }

    private void m10517c(String str) {
        CharSequence string;
        af afVar = new af(m10381b(), 2131427471);
        if (this.f7760h) {
            afVar.m3610b(m10381b().getString(2131230805));
            string = m10381b().getString(2131230771);
        } else {
            afVar.m3610b(m10381b().getString(2131230806));
            string = m10381b().getString(2131230772);
        }
        afVar.m3607a(string, new C2356g(this, str));
        afVar.m3611b(m10381b().getString(2131230813), null);
        afVar.m3612c();
    }

    private void m10520d(String str) {
        C1494c.m7539a(new C1410h(m10381b(), str, this.f7760h));
    }

    public void m10522a(Loader<Cursor> loader, Cursor cursor) {
        if (this.f7756d != null) {
            this.f7756d.m8748c(cursor);
        }
    }

    public void m10523a(RecyclerView recyclerView) {
        int i = 0;
        if (recyclerView.getLayoutManager() != null) {
            i = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(m10381b()));
        recyclerView.scrollToPosition(i);
    }

    public void m10524a(View view, int i) {
        C2348a c2348a = (C2348a) this.f7756d.m8752a(i);
        switch (C2364o.f7800a[c2348a.m10527a().ordinal()]) {
            case VideoSize.CIF /*1*/:
                C1659a.m8432a(m10381b(), c2348a.m10528b(), false);
            case VideoSize.HVGA /*2*/:
                C1659a.m8441b(m10381b(), c2348a.m10528b(), false);
            default:
        }
    }

    public void m10525a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("searchPattern", str);
        m10381b().getLoaderManager().restartLoader(8, bundle, this);
    }

    public void m10526b(View view, int i) {
        int i2;
        CharSequence string;
        Cursor b = this.f7756d.m8745b();
        b.moveToFirst();
        b.move(i);
        String str = BuildConfig.FLAVOR;
        String string2 = b.getString(b.getColumnIndex("conversations_party"));
        switch (C2364o.f7800a[C1595o.values()[b.getInt(b.getColumnIndex("conversations_group_type"))].ordinal()]) {
            case VideoSize.CIF /*1*/:
                Object a = (b.getInt(b.getColumnIndex("members_is_local_user")) != 0 ? 1 : null) != null ? ah.m8469a(b.getString(b.getColumnIndex("members_local_name")), b.getString(b.getColumnIndex("members_local_phone_number"))) : ah.m8470b(b.getString(b.getColumnIndex("members_nick_name")), b.getString(b.getColumnIndex("members_user_id")));
                i2 = 2131755011;
                break;
            case VideoSize.HVGA /*2*/:
                string = b.getString(b.getColumnIndex("PrivateGroups_name"));
                i2 = 2131755010;
                break;
            default:
                string = str;
                i2 = 2131755011;
                break;
        }
        new C1003l(m10381b()).m6122a(string).m6120a(i2).m6121a(new C2352c(this, string2)).m6119a().show();
    }

    protected void finalize() {
        super.finalize();
        C0002c.m2a().m16b(this);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1583c.m8000k(m10381b(), bundle.getString("searchPattern"));
    }

    public void onEvent(C1401e c1401e) {
        if (m10381b() != null) {
            m10381b().runOnUiThread(new C2361l(this));
        }
    }

    public void onEvent(C1402f c1402f) {
        if (m10381b() != null) {
            m10381b().runOnUiThread(new C2359j(this));
        }
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m10522a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        if (this.f7756d != null) {
            this.f7756d.m8748c(null);
        }
    }
}
