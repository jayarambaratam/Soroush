package mobi.mmdt.ott.view.main.p236b;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cocosw.bottomsheet.C1003l;
import com.p077d.p078a.C1018b;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.main.basenavigation.ab;
import mobi.mmdt.ott.view.main.p236b.p242b.C2300b;
import mobi.mmdt.ott.view.p178a.C1659a;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.main.b.a */
public class C2298a extends ab implements LoaderCallbacks<Cursor>, C1790i {
    private ViewGroup f7593b;
    private RecyclerView f7594c;
    private C2303d f7595d;
    private C2287e f7596e;
    private boolean f7597f;
    private int f7598g;
    private String f7599h;
    private long f7600i;
    private long f7601j;

    private C2298a(Activity activity, C2287e c2287e) {
        super(activity);
        this.f7597f = true;
        this.f7600i = 0;
        this.f7601j = 0;
        this.f7596e = c2287e;
        this.a = LayoutInflater.from(activity).inflate(2130968716, null, false);
        this.f7599h = C1309a.m6934a(m10381b()).m6942b();
        m10400a();
    }

    public static C2298a m10399a(Activity activity, C2287e c2287e) {
        return new C2298a(activity, c2287e);
    }

    private void m10400a() {
        this.f7595d = new C2303d(this, m10381b());
        Bundle bundle = new Bundle();
        bundle.putString("searchPattern", BuildConfig.FLAVOR);
        m10381b().getLoaderManager().initLoader(7, bundle, this);
        this.f7598g = C1111c.m6389a(m10381b());
        this.f7593b = (ViewGroup) this.a.findViewById(2131689631);
        this.f7594c = (RecyclerView) this.a.findViewById(2131689797);
        this.f7594c.setHasFixedSize(true);
        this.f7594c.setAdapter(this.f7595d);
        m10407a(this.f7594c);
        C1018b c1018b = new C1018b(m10381b(), this.f7594c, true);
        this.f7594c.addOnScrollListener(new C2301b(this));
    }

    public void m10406a(Loader<Cursor> loader, Cursor cursor) {
        if (this.f7595d != null) {
            this.f7595d.m8748c(cursor);
        }
    }

    public void m10407a(RecyclerView recyclerView) {
        int i = 0;
        if (recyclerView.getLayoutManager() != null) {
            i = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(m10381b()));
        recyclerView.scrollToPosition(i);
    }

    public void m10408a(View view, int i) {
        C1659a.m8433a(m10381b(), ((C2300b) this.f7595d.m8752a(i)).m10416f(), true, false);
    }

    public void m10409a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("searchPattern", str);
        m10381b().getLoaderManager().restartLoader(7, bundle, this);
    }

    public void m10410b(View view, int i) {
        Cursor b = this.f7595d.m8745b();
        b.moveToFirst();
        b.move(i);
        String string = b.getString(b.getColumnIndex("members_user_id"));
        new C1003l(m10381b()).m6123b(C1111c.m6402b(m10381b(), string)).m6122a(b.getString(b.getColumnIndex("members_local_name"))).m6120a(2131755009).m6121a(new C2302c(this, string)).m6119a().show();
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1607a.m8160b(m10381b(), bundle.getString("searchPattern"));
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m10406a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        if (this.f7595d != null) {
            this.f7595d.m8748c(null);
        }
    }
}
