package mobi.mmdt.ott.view.conversation.groupinfo;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.af;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.cocosw.bottomsheet.C1003l;
import com.p065c.p066a.p067a.C0950c;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1399c;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1400d;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1401e;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1402f;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p133a.C1412a;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p133a.C1414c;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p133a.C1416e;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p134b.C1417a;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p172f.C1619f;
import mobi.mmdt.ott.view.components.C1711a;
import mobi.mmdt.ott.view.p178a.C1659a;
import net.frakbot.glowpadbackport.BuildConfig;

public class GroupInfoActivity extends C1711a implements ay {
    private MenuItem f7391A;
    private MenuItem f7392B;
    private Button f7393C;
    private C0950c f7394D;
    private boolean f7395E;
    private String f7396F;
    private C1619f f7397G;
    private String f7398H;
    private String f7399I;
    private LoaderCallbacks<Cursor> f7400J;
    private OnClickListener f7401K;
    private OnClickListener f7402L;
    private OnClickListener f7403M;
    private EditText f7404o;
    private TextView f7405p;
    private TextInputLayout f7406q;
    private TextInputLayout f7407r;
    private EditText f7408s;
    private EditText f7409t;
    private View f7410u;
    private LinearLayout f7411v;
    private TextView f7412w;
    private aw f7413x;
    private String f7414y;
    private boolean f7415z;

    public GroupInfoActivity() {
        this.f7415z = false;
        this.f7397G = C1619f.NONE;
        this.f7400J = new an(this);
        this.f7401K = new aq(this);
        this.f7402L = new ar(this);
        this.f7403M = new C2264o(this);
    }

    private void m10202a(String str, String str2) {
        new Handler().postDelayed(new C2263n(this, str, str2), 50);
    }

    private void m10203a(String str, C1619f c1619f) {
        af afVar = new af(this, 2131427471);
        afVar.m3606a(getString(2131230923));
        View inflate = getLayoutInflater().inflate(2130968700, null);
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(2131689763);
        RadioButton radioButton = (RadioButton) inflate.findViewById(2131689764);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(2131689765);
        radioButton.setText(getString(2131230852));
        radioButton2.setText(getString(2131230855));
        if (c1619f == C1619f.ADMIN) {
            radioButton.setChecked(true);
        } else {
            radioButton2.setChecked(true);
        }
        afVar.m3609b(inflate);
        afVar.m3611b(getString(2131230814), null);
        afVar.m3607a(getString(2131230753), new C2268s(this, radioGroup, str, c1619f));
        afVar.m3612c();
    }

    private void m10204a(String str, C1619f c1619f, C1619f c1619f2) {
        new Handler().postDelayed(new C2269t(this, str, c1619f, c1619f2), 50);
    }

    private void m10223h(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(str);
        arrayList2.add(C1619f.NONE);
        C0950c c1417a = new C1417a(getApplicationContext(), this.f7414y, arrayList, arrayList2, true);
        this.f7394D = c1417a;
        C1494c.m7540b(c1417a);
    }

    private void m10235r() {
        ViewGroup viewGroup = (ViewGroup) findViewById(2131689635);
        this.f7412w = (TextView) findViewById(2131689827);
        this.f7393C = (Button) findViewById(2131689865);
        this.f7406q = (TextInputLayout) findViewById(2131689859);
        this.f7408s = (EditText) findViewById(2131689860);
        this.f7407r = (TextInputLayout) findViewById(2131689861);
        this.f7404o = (EditText) findViewById(2131689862);
        this.f7405p = (TextView) findViewById(2131689864);
        this.f7409t = (EditText) findViewById(2131689828);
        this.f7410u = findViewById(2131689829);
        this.f7411v = (LinearLayout) findViewById(2131689858);
        this.f7408s.setFilters(new InputFilter[]{new LengthFilter(128)});
        this.f7404o.setFilters(new InputFilter[]{new LengthFilter(128)});
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        LayoutParams layoutParams = viewGroup.getLayoutParams();
        layoutParams.height = (int) (((float) (point.y - (C1111c.m6401b(getApplicationContext()) + C1111c.m6406c(getApplicationContext())))) + C1111c.m6388a(getApplicationContext(), 8.0f));
        if (getResources().getConfiguration().orientation == 2) {
            layoutParams.width = (int) (((double) point.x) * 0.75d);
        }
        this.f7408s.setText(BuildConfig.FLAVOR);
        this.f7404o.setText(BuildConfig.FLAVOR);
        this.f7409t.requestFocus();
        this.f7406q.setVisibility(8);
        this.f7407r.setVisibility(8);
        this.f7411v.setVisibility(8);
        this.f7410u.setVisibility(8);
        this.f7405p.setText("participants");
        this.f7393C.setOnClickListener(new C2259j(this));
        new Thread(new C2274y(this)).start();
    }

    private void m10237s() {
        this.f7408s.addTextChangedListener(new ao(this));
        this.f7404o.addTextChangedListener(new ap(this));
    }

    private void m10240t() {
        new Thread(new at(this)).start();
    }

    private void m10242u() {
        String obj = this.f7404o.getText().toString();
        String obj2 = this.f7408s.getText().toString();
        if (obj2.trim().isEmpty()) {
            this.f7406q.setErrorEnabled(true);
            this.f7406q.setError(getString(2131230858));
            new Handler().postDelayed(new C2260k(this), 100);
            return;
        }
        this.f7406q.setErrorEnabled(false);
        runOnUiThread(new av(this));
        m10202a(obj2, obj);
    }

    private void m10244v() {
        new Handler().postDelayed(new C2261l(this), 50);
    }

    private void m10246w() {
        new Handler().postDelayed(new C2262m(this), 50);
    }

    private void m10247x() {
        af afVar = new af(this, 2131427471);
        if (this.f7395E) {
            afVar.m3610b(getString(2131230805));
            afVar.m3607a(getString(2131230771), this.f7403M);
        } else {
            afVar.m3610b(getString(2131230806));
            afVar.m3607a(getString(2131230772), this.f7403M);
        }
        afVar.m3611b(getString(2131230813), null);
        afVar.m3612c();
    }

    public void m10251a(String str, boolean z, C1619f c1619f) {
        new C1003l(this).m6120a(2131755031).m6121a(new C2267r(this, str, z, c1619f)).m6119a().show();
    }

    protected void m10252b(boolean z) {
        if (this.f7392B != null) {
            this.f7392B.setVisible(true);
        }
    }

    public void m10253g(String str) {
        C1659a.m8433a(m8494q(), str, false, false);
    }

    protected int m10254l() {
        return 2130838598;
    }

    protected void m10255m() {
        if (this.f7398H != null) {
            C1659a.m8457k(m8494q(), this.f7398H, this.f7399I);
        }
    }

    public void onBackPressed() {
        if (this.f7415z || this.n) {
            af afVar = new af(this, 2131427471);
            afVar.m3606a(getString(2131230918));
            afVar.m3610b(getString(2131230807));
            afVar.m3607a(getString(2131230917), this.f7401K);
            afVar.m3611b(getString(2131230813), this.f7402L);
            afVar.m3612c();
            return;
        }
        setResult(0);
        super.onBackPressed();
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8557a(bundle, true);
        m8556a(2130968731);
        this.f7414y = getIntent().getExtras().getString("KEY_GROUP_ID");
        this.f7396F = C1309a.m6934a(getApplicationContext()).m6942b();
        m10235r();
        m8563c(C1111c.m6402b(getApplicationContext(), this.f7414y));
        m8569n();
        m8566d(null);
        if (bundle != null) {
            if (bundle.containsKey("KEY_GROUP_NAME")) {
                Object string = bundle.getString("KEY_GROUP_NAME");
                this.f7408s.setText(string);
                m8559a((String) string);
            }
            if (bundle.containsKey("KEY_GROUP_MOTTO")) {
                this.f7404o.setText(bundle.getString("KEY_GROUP_MOTTO"));
            }
            if (bundle.containsKey("KEY_IS_CHANGE_OCCURRED") && bundle.getBoolean("KEY_IS_CHANGE_OCCURRED")) {
                this.f7415z = true;
            } else {
                this.f7415z = false;
            }
        }
        if (this.m != null) {
            m8564c(this.m);
            m8566d(this.m);
        }
        if (this.f7413x == null) {
            this.f7413x = new aw();
            Bundle bundle2 = new Bundle();
            bundle2.putString("KEY_GROUP_ID", this.f7414y);
            this.f7413x.setArguments(bundle2);
        }
        if (!this.f7413x.isDetached()) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.replace(2131689637, this.f7413x);
            beginTransaction.setTransition(4099);
            beginTransaction.commit();
        }
        getLoaderManager().initLoader(16, null, this.f7400J);
        m10246w();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755047, menu);
        this.f7391A = menu.findItem(2131690001);
        this.f7392B = menu.findItem(2131689999);
        if (this.f7415z || this.n) {
            this.f7392B.setVisible(true);
        } else {
            this.f7392B.setVisible(false);
        }
        if (this.f7415z) {
            this.f7391A.setVisible(false);
        }
        if (this.f7415z) {
            this.f7406q.setVisibility(0);
            this.f7411v.setVisibility(0);
            this.f7410u.setVisibility(0);
        } else {
            this.f7406q.setVisibility(8);
        }
        this.f7408s.setEnabled(this.f7415z);
        this.f7404o.setEnabled(this.f7415z);
        return true;
    }

    public void onEvent(C1399c c1399c) {
        runOnUiThread(new ag(this));
    }

    public void onEvent(C1400d c1400d) {
        runOnUiThread(new C2270u(this));
    }

    public void onEvent(C1401e c1401e) {
        runOnUiThread(new ak(this));
    }

    public void onEvent(C1402f c1402f) {
        runOnUiThread(new C2272w(this));
    }

    public void onEvent(C1412a c1412a) {
        runOnUiThread(new ae(this, c1412a));
    }

    public void onEvent(C1414c c1414c) {
        runOnUiThread(new ac(this, c1414c));
    }

    public void onEvent(C1416e c1416e) {
        runOnUiThread(new aj(this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 2131689999) {
            if (this.f7415z || this.n) {
                af afVar = new af(this, 2131427471);
                afVar.m3606a(getString(2131230918));
                afVar.m3610b(getString(2131230807));
                afVar.m3607a(getString(2131230917), this.f7401K);
                afVar.m3611b(getString(2131230813), this.f7402L);
                afVar.m3612c();
            } else {
                super.onBackPressed();
            }
        } else if (itemId == 2131690001) {
            this.f7391A.setVisible(false);
            this.f7392B.setVisible(true);
            this.f7408s.setEnabled(true);
            this.f7404o.setEnabled(true);
            this.f7407r.setVisibility(0);
            this.f7406q.setVisibility(0);
            this.f7411v.setVisibility(0);
            this.f7410u.setVisibility(0);
            this.f7408s.requestFocus();
        } else if (itemId == 2131689965) {
            this.f7395E = false;
            m10247x();
        } else if (itemId == 2131689962) {
            this.f7395E = true;
            m10247x();
        } else if (itemId == 2131690000) {
            m10240t();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String obj = this.f7408s.getText().toString();
        if (!obj.isEmpty()) {
            bundle.putString("KEY_GROUP_NAME", obj);
        }
        obj = this.f7404o.getText().toString();
        if (!obj.isEmpty()) {
            bundle.putString("KEY_GROUP_MOTTO", obj);
        }
        bundle.putBoolean("KEY_IS_CHANGE_OCCURRED", this.f7415z);
    }
}
