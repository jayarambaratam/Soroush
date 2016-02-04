package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.p095c.C1303d;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ah;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.aj;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bn;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.C2135c;
import mobi.mmdt.ott.view.conversation.p213a.C1981a;
import mobi.mmdt.ott.view.conversation.p213a.C1982b;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2154a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2158e;
import net.frakbot.glowpadbackport.BuildConfig;
import org.json.JSONObject;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.q */
public class C2043q extends C2027a {
    private TextView f6715d;
    private LinearLayout f6716e;
    private Button f6717f;
    private Button f6718g;
    private boolean f6719h;
    private int f6720i;

    public C2043q(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, C1981a c1981a) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968658, c1981a);
        this.f6715d = (TextView) this.itemView.findViewById(2131689740);
        this.f6716e = (LinearLayout) this.itemView.findViewById(2131689742);
        this.f6717f = (Button) this.itemView.findViewById(2131689743);
        this.f6718g = (Button) this.itemView.findViewById(2131689744);
        this.f6720i = i;
        this.f6715d.setOnLongClickListener(new C2044r(this));
        this.f6715d.setOnTouchListener(new C2050x(this));
    }

    private void m9694a(C2158e c2158e, Bundle bundle, aj ajVar, boolean z) {
        this.f6717f.setEnabled(ajVar.m6632b());
        if (z) {
            bn b = C1303d.m6882b(new JSONObject(c2158e.m9872r()));
            String a = b.m6694a();
            if (a == null) {
                a = BuildConfig.FLAVOR;
            }
            bundle.putString(C2135c.m9793a(c2158e.m9844f(), 1), a);
            if (b.m6695b() != null) {
                for (String a2 : b.m6695b()) {
                    bundle.putBoolean(C2135c.m9794a(c2158e.m9844f(), a2), true);
                }
            }
        }
        String g = ajVar.m6637g();
        ah[] d = ajVar.m6634d();
        CheckBox[] checkBoxArr = new CheckBox[d.length];
        View view = null;
        if (ajVar.m6636f()) {
            View a3 = C2135c.m9792a(this.a, c2158e.m9844f(), ajVar.m6633c(), 1);
            a3.setMinWidth(this.f6720i);
            a3.setText(bundle.getString(C2135c.m9793a(c2158e.m9844f(), 1), BuildConfig.FLAVOR));
            a3.setEnabled(!z);
            a3.setOnFocusChangeListener(new C2051y(this, c2158e));
            view = a3;
        }
        C1982b c2052z = new C2052z(this, c2158e, view);
        Object obj = null;
        for (int i = 0; i < d.length; i++) {
            boolean a4 = d[i].m6627a();
            String b2 = d[i].m6628b();
            CharSequence c = d[i].m6629c();
            d[i].m6630d();
            View a5 = C2135c.m9791a(this.a, c2158e.m9844f(), b2, a4, c2052z);
            a5.setText(c);
            this.f6716e.addView(a5);
            boolean z2 = bundle.getBoolean(C2135c.m9794a(c2158e.m9844f(), b2), false);
            obj = (a4 && z2) ? 1 : null;
            a5.setChecked(z2);
            a5.setEnabled(!z);
            checkBoxArr[i] = a5;
        }
        if (ajVar.m6636f()) {
            view.setVisibility(obj != null ? 0 : 8);
            this.f6716e.addView(view);
        }
        this.f6717f.setOnClickListener(new ab(this, d, bundle, c2158e, g));
        this.f6718g.setOnClickListener(new ac(this, c2158e, g));
        this.f6717f.setVisibility(z ? 8 : 0);
    }

    private void m9695a(C2158e c2158e, boolean z) {
        Bundle a = MyApplication.m6445a().m6450a(c2158e.m9844f());
        this.f6716e.removeAllViews();
        aj a2 = C1303d.m6879a(new JSONObject(c2158e.m9871q()));
        switch (C2049w.f6735b[a2.m6635e().ordinal()]) {
            case VideoSize.CIF /*1*/:
                m9694a(c2158e, a, a2, z);
                break;
            case VideoSize.HVGA /*2*/:
                m9698b(c2158e, a, a2, z);
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                m9699c(c2158e, a, a2, z);
                break;
        }
        this.f6715d.setText(a2.m6631a());
    }

    private void m9698b(C2158e c2158e, Bundle bundle, aj ajVar, boolean z) {
        this.f6717f.setEnabled(ajVar.m6632b());
        if (z) {
            bn b = C1303d.m6882b(new JSONObject(c2158e.m9872r()));
            String a = b.m6694a();
            if (a == null) {
                a = BuildConfig.FLAVOR;
            }
            bundle.putString(C2135c.m9793a(c2158e.m9844f(), 1), a);
            if (b.m6695b() != null) {
                for (String b2 : b.m6695b()) {
                    bundle.putBoolean(C2135c.m9796b(c2158e.m9844f(), b2), true);
                }
            }
        }
        String g = ajVar.m6637g();
        ah[] d = ajVar.m6634d();
        RadioButton[] radioButtonArr = new RadioButton[d.length];
        View view = null;
        if (ajVar.m6636f()) {
            View a2 = C2135c.m9792a(this.a, c2158e.m9844f(), ajVar.m6633c(), 1);
            a2.setMinWidth(this.f6720i);
            a2.setEnabled(!z);
            a2.setText(bundle.getString(C2135c.m9793a(c2158e.m9844f(), 1), BuildConfig.FLAVOR));
            a2.setOnFocusChangeListener(new ad(this, c2158e));
            view = a2;
        }
        C1982b aeVar = new ae(this, c2158e, view);
        Object obj = null;
        View radioGroup = new RadioGroup(this.a);
        for (int i = 0; i < d.length; i++) {
            boolean a3 = d[i].m6627a();
            String b3 = d[i].m6628b();
            CharSequence c = d[i].m6629c();
            d[i].m6630d();
            View b4 = C2135c.m9795b(this.a, c2158e.m9844f(), b3, a3, aeVar);
            b4.setText(c);
            radioGroup.addView(b4);
            boolean z2 = bundle.getBoolean(C2135c.m9796b(c2158e.m9844f(), b3), false);
            obj = (a3 && z2) ? 1 : null;
            b4.setChecked(z2);
            b4.setEnabled(!z);
            radioButtonArr[i] = b4;
        }
        this.f6716e.addView(radioGroup);
        if (ajVar.m6636f()) {
            view.setVisibility(obj != null ? 0 : 8);
            this.f6716e.addView(view);
        }
        this.f6717f.setOnClickListener(new ag(this, d, bundle, c2158e, g));
        this.f6718g.setOnClickListener(new C2045s(this, c2158e, g));
        this.f6717f.setVisibility(z ? 8 : 0);
    }

    private void m9699c(C2158e c2158e, Bundle bundle, aj ajVar, boolean z) {
        int i = 0;
        this.f6717f.setEnabled(ajVar.m6632b());
        if (z) {
            String a = C1303d.m6882b(new JSONObject(c2158e.m9872r())).m6694a();
            if (a == null) {
                a = BuildConfig.FLAVOR;
            }
            bundle.putString(C2135c.m9793a(c2158e.m9844f(), 1), a);
        }
        String g = ajVar.m6637g();
        if (ajVar.m6636f()) {
            View a2 = C2135c.m9792a(this.a, c2158e.m9844f(), ajVar.m6633c(), 1);
            a2.setMinWidth(this.f6720i);
            a2.setEnabled(!z);
            a2.setText(bundle.getString(C2135c.m9793a(c2158e.m9844f(), 1), BuildConfig.FLAVOR));
            a2.setOnFocusChangeListener(new C2046t(this, c2158e));
            this.f6716e.addView(a2);
        }
        this.f6717f.setOnClickListener(new C2047u(this, bundle, c2158e, g));
        this.f6718g.setOnClickListener(new C2048v(this, c2158e, g));
        Button button = this.f6717f;
        if (z) {
            i = 8;
        }
        button.setVisibility(i);
    }

    protected void m9700a(C1722f c1722f) {
        C2158e c2158e = (C2158e) c1722f;
        super.m9664a((C2154a) c2158e);
        String r = c2158e.m9872r();
        boolean z = (r == null || r.isEmpty()) ? false : true;
        try {
            m9695a(c2158e, z);
        } catch (Throwable e) {
            C1104b.m6367b(this, "Error in parsing poll data.", e);
        }
        switch (C2049w.f6734a[c2158e.m9849m().ordinal()]) {
        }
    }
}
