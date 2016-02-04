package mobi.mmdt.ott.view.main.p238d;

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
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1344j;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1345k;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1357i;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.main.basenavigation.ab;
import mobi.mmdt.ott.view.main.p238d.p246b.C2370a;
import mobi.mmdt.ott.view.p178a.C1659a;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.view.main.d.a */
public class C2369a extends ab implements LoaderCallbacks<Cursor>, C1790i {
    private ViewGroup f7814b;
    private RecyclerView f7815c;
    private C2382l f7816d;
    private C2289m f7817e;
    private boolean f7818f;
    private int f7819g;
    private boolean f7820h;
    private String f7821i;

    private C2369a(Activity activity, C2289m c2289m) {
        super(activity);
        this.f7818f = true;
        C0002c.m2a().m14a((Object) this);
        this.f7817e = c2289m;
        this.a = LayoutInflater.from(activity).inflate(2130968745, null, false);
        m10551a();
    }

    public static C2369a m10550a(Activity activity, C2289m c2289m) {
        return new C2369a(activity, c2289m);
    }

    private void m10551a() {
        this.f7819g = C1111c.m6389a(m10381b());
        this.f7814b = (ViewGroup) this.a.findViewById(2131689631);
        this.f7815c = (RecyclerView) this.a.findViewById(2131689797);
        this.f7816d = new C2382l(this, m10381b());
        this.f7821i = C1309a.m6934a(m10381b()).m6942b();
        Bundle bundle = new Bundle();
        bundle.putString("searchPattern", BuildConfig.FLAVOR);
        m10381b().getLoaderManager().initLoader(22, bundle, this);
        this.f7815c.setHasFixedSize(true);
        this.f7815c.setAdapter(this.f7816d);
        m10563a(this.f7815c);
        this.f7815c.addOnScrollListener(new C2372b(this));
    }

    private void m10556b(String str) {
        af afVar = new af(m10381b(), 2131427471);
        afVar.m3610b(m10381b().getString(2131230804));
        afVar.m3607a(m10381b().getString(2131230771), new C2374d(this, str));
        afVar.m3611b(m10381b().getString(2131230813), null);
        afVar.m3612c();
    }

    private void m10560c(String str) {
        C1494c.m7539a(new C1357i(m10381b(), str));
    }

    public void m10562a(Loader<Cursor> loader, Cursor cursor) {
        if (this.f7816d != null) {
            this.f7816d.m8748c(cursor);
        }
    }

    public void m10563a(RecyclerView recyclerView) {
        int i = 0;
        if (recyclerView.getLayoutManager() != null) {
            i = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(m10381b()));
        recyclerView.scrollToPosition(i);
    }

    public void m10564a(View view, int i) {
        C2370a c2370a = (C2370a) this.f7816d.m8752a(i);
        switch (C2381k.f7845a[c2370a.m10567a().ordinal()]) {
            case VideoSize.CIF /*1*/:
                C1659a.m8447c(m10381b(), c2370a.m10568b(), false);
            default:
        }
    }

    public void m10565a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("searchPattern", str);
        m10381b().getLoaderManager().restartLoader(22, bundle, this);
    }

    public void m10566b(View view, int i) {
        Cursor b = this.f7816d.m8745b();
        b.moveToFirst();
        b.move(i);
        CharSequence charSequence = BuildConfig.FLAVOR;
        String string = b.getString(b.getColumnIndex("conversations_party"));
        switch (C2381k.f7845a[C1595o.values()[b.getInt(b.getColumnIndex("conversations_group_type"))].ordinal()]) {
            case VideoSize.CIF /*1*/:
                charSequence = b.getString(b.getColumnIndex("CHANNELS_name"));
                break;
        }
        new C1003l(m10381b()).m6122a(charSequence).m6120a(2131755008).m6121a(new C2373c(this, string)).m6119a().show();
    }

    protected void finalize() {
        super.finalize();
        C0002c.m2a().m16b(this);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1583c.m8001l(m10381b(), bundle.getString("searchPattern"));
    }

    public void onEvent(C1344j c1344j) {
        if (m10381b() != null) {
            m10381b().runOnUiThread(new C2379i(this));
        }
    }

    public void onEvent(C1345k c1345k) {
        if (m10381b() != null) {
            m10381b().runOnUiThread(new C2377g(this));
        }
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m10562a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        if (this.f7816d != null) {
            this.f7816d.m8748c(null);
        }
    }
}
