package mobi.mmdt.ott.view.components.mediaselector;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.aw;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.view.components.mediaselector.p206b.C1895b;
import mobi.mmdt.ott.view.components.p181b.C1720l;
import mobi.mmdt.ott.view.components.p181b.C1791j;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.i */
public class C1904i extends Fragment implements C1720l {
    private RecyclerView aa;
    private C1906k ab;
    private GridLayoutManager ac;
    private C1888l ad;
    private int ae;
    private int af;
    private aw<Cursor> ag;

    public C1904i() {
        this.ag = new C1905j(this);
    }

    public View m9097a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968738, viewGroup, false);
    }

    public void m9098a(Activity activity) {
        super.m958a(activity);
        try {
            this.ad = (C1888l) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnMediaSelectorVideoInteractionListener");
        }
    }

    public void m9099a(View view, int i) {
        C1895b c1895b = (C1895b) this.ab.m8655a(i);
        this.ad.m9048b(c1895b.m9065c(), c1895b.m9064b());
    }

    public void m9100a(View view, Bundle bundle) {
        int i;
        super.m967a(view, bundle);
        Display defaultDisplay = ((WindowManager) m979c().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (m984d().getConfiguration().orientation == 1) {
            this.ae = point.x / 2;
            this.af = this.ae;
            i = 2;
        } else {
            this.ae = point.x / 4;
            this.af = this.ae;
            i = 4;
        }
        this.ac = new GridLayoutManager(m979c(), i);
        this.aa = (RecyclerView) m996i().findViewById(2131689797);
        this.aa.addItemDecoration(new C1893a((int) C1111c.m6388a(m979c(), 2.0f), i));
        this.ab = new C1906k(this, m979c());
        this.aa.addOnItemTouchListener(new C1791j(m979c(), this.aa, this));
        this.aa.setHasFixedSize(true);
        this.aa.setAdapter(this.ab);
        this.aa.setLayoutManager(this.ac);
    }

    public void m9101b(View view, int i) {
    }

    public void m9102e(Bundle bundle) {
        super.m989e(bundle);
        m979c().m1312g().m1087a(2, null, this.ag);
    }

    public void m9103n() {
        if (this.aa != null) {
            this.aa.setItemAnimator(null);
            this.aa.setAdapter(null);
            this.aa = null;
        }
        this.ab = null;
        super.m1003n();
    }
}
