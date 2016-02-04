package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/* renamed from: android.support.v7.app.w */
public class C0397w {
    public int f1958A;
    public boolean f1959B;
    public boolean[] f1960C;
    public boolean f1961D;
    public boolean f1962E;
    public int f1963F;
    public OnMultiChoiceClickListener f1964G;
    public Cursor f1965H;
    public String f1966I;
    public String f1967J;
    public OnItemSelectedListener f1968K;
    public ab f1969L;
    public boolean f1970M;
    public final Context f1971a;
    public final LayoutInflater f1972b;
    public int f1973c;
    public Drawable f1974d;
    public int f1975e;
    public CharSequence f1976f;
    public View f1977g;
    public CharSequence f1978h;
    public CharSequence f1979i;
    public OnClickListener f1980j;
    public CharSequence f1981k;
    public OnClickListener f1982l;
    public CharSequence f1983m;
    public OnClickListener f1984n;
    public boolean f1985o;
    public OnCancelListener f1986p;
    public OnDismissListener f1987q;
    public OnKeyListener f1988r;
    public CharSequence[] f1989s;
    public ListAdapter f1990t;
    public OnClickListener f1991u;
    public int f1992v;
    public View f1993w;
    public int f1994x;
    public int f1995y;
    public int f1996z;

    public C0397w(Context context) {
        this.f1973c = 0;
        this.f1975e = 0;
        this.f1959B = false;
        this.f1963F = -1;
        this.f1970M = true;
        this.f1971a = context;
        this.f1985o = true;
        this.f1972b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    private void m3886b(C0391q c0391q) {
        ListAdapter simpleCursorAdapter;
        ListView listView = (ListView) this.f1972b.inflate(c0391q.f1912H, null);
        if (!this.f1961D) {
            int m = this.f1962E ? c0391q.f1914J : c0391q.f1915K;
            simpleCursorAdapter = this.f1965H != null ? new SimpleCursorAdapter(this.f1971a, m, this.f1965H, new String[]{this.f1966I}, new int[]{16908308}) : this.f1990t != null ? this.f1990t : new ad(this.f1971a, m, 16908308, this.f1989s);
        } else if (this.f1965H == null) {
            simpleCursorAdapter = new C0398x(this, this.f1971a, c0391q.f1913I, 16908308, this.f1989s, listView);
        } else {
            Object c0399y = new C0399y(this, this.f1971a, this.f1965H, false, listView, c0391q);
        }
        if (this.f1969L != null) {
            this.f1969L.m3589a(listView);
        }
        c0391q.f1908D = simpleCursorAdapter;
        c0391q.f1909E = this.f1963F;
        if (this.f1991u != null) {
            listView.setOnItemClickListener(new C0400z(this, c0391q));
        } else if (this.f1964G != null) {
            listView.setOnItemClickListener(new aa(this, listView, c0391q));
        }
        if (this.f1968K != null) {
            listView.setOnItemSelectedListener(this.f1968K);
        }
        if (this.f1962E) {
            listView.setChoiceMode(1);
        } else if (this.f1961D) {
            listView.setChoiceMode(2);
        }
        c0391q.f1924f = listView;
    }

    public void m3887a(C0391q c0391q) {
        if (this.f1977g != null) {
            c0391q.m3880b(this.f1977g);
        } else {
            if (this.f1976f != null) {
                c0391q.m3877a(this.f1976f);
            }
            if (this.f1974d != null) {
                c0391q.m3875a(this.f1974d);
            }
            if (this.f1973c != 0) {
                c0391q.m3879b(this.f1973c);
            }
            if (this.f1975e != 0) {
                c0391q.m3879b(c0391q.m3883c(this.f1975e));
            }
        }
        if (this.f1978h != null) {
            c0391q.m3881b(this.f1978h);
        }
        if (this.f1979i != null) {
            c0391q.m3874a(-1, this.f1979i, this.f1980j, null);
        }
        if (this.f1981k != null) {
            c0391q.m3874a(-2, this.f1981k, this.f1982l, null);
        }
        if (this.f1983m != null) {
            c0391q.m3874a(-3, this.f1983m, this.f1984n, null);
        }
        if (!(this.f1989s == null && this.f1965H == null && this.f1990t == null)) {
            m3886b(c0391q);
        }
        if (this.f1993w != null) {
            if (this.f1959B) {
                c0391q.m3876a(this.f1993w, this.f1994x, this.f1995y, this.f1996z, this.f1958A);
                return;
            }
            c0391q.m3884c(this.f1993w);
        } else if (this.f1992v != 0) {
            c0391q.m3873a(this.f1992v);
        }
    }
}
