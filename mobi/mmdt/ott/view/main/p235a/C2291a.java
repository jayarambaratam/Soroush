package mobi.mmdt.ott.view.main.p235a;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.main.basenavigation.ab;

/* renamed from: mobi.mmdt.ott.view.main.a.a */
public class C2291a extends ab implements C1790i {
    private RecyclerView f7574b;
    private C2295c f7575c;
    private C2286d f7576d;
    private boolean f7577e;
    private int f7578f;

    private C2291a(Activity activity, C2286d c2286d) {
        super(activity);
        this.f7577e = true;
        this.f7576d = c2286d;
        this.a = LayoutInflater.from(activity).inflate(2130968709, null, false);
        m10384a();
    }

    public static C2291a m10383a(Activity activity, C2286d c2286d) {
        return new C2291a(activity, c2286d);
    }

    private void m10384a() {
        this.f7578f = C1111c.m6389a(m10381b());
        this.f7574b = (RecyclerView) this.a.findViewById(2131689797);
        this.f7575c = new C2295c(this, m10381b());
        this.f7574b.setHasFixedSize(true);
        this.f7574b.setAdapter(this.f7575c);
        m10389a(this.f7574b);
        this.f7574b.addOnScrollListener(new C2294b(this));
    }

    public void m10389a(RecyclerView recyclerView) {
        int i = 0;
        if (recyclerView.getLayoutManager() != null) {
            i = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(m10381b()));
        recyclerView.scrollToPosition(i);
    }

    public void m10390a(View view, int i) {
        Snackbar.m377a(view, "Click on item " + i, 0).m394a((CharSequence) "DONE", null).m395a();
    }

    public void m10391a(String str) {
    }

    public void m10392b(View view, int i) {
        Toast.makeText(m10381b(), "Long click on item " + i, 0).show();
    }
}
