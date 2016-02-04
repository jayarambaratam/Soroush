package mobi.mmdt.ott.view.main;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.RelativeLayout;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.view.components.C1711a;

public class NewGroupActivity extends C1711a {
    private TextInputLayout f7561o;
    private EditText f7562p;
    private TextInputLayout f7563q;
    private EditText f7564r;

    private void m10364a(String str, String str2) {
        new Handler().postDelayed(new C2398s(this, str, str2), 10);
    }

    private void m10366r() {
        this.f7561o = (TextInputLayout) findViewById(2131689859);
        this.f7562p = (EditText) findViewById(2131689860);
        this.f7563q = (TextInputLayout) findViewById(2131689861);
        this.f7564r = (EditText) findViewById(2131689862);
        this.f7562p.requestFocus();
        this.f7562p.setFilters(new InputFilter[]{new LengthFilter(128)});
        this.f7564r.setFilters(new InputFilter[]{new LengthFilter(128)});
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131689635);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.height = (int) (((float) (point.y - (C1111c.m6401b(getApplicationContext()) + C1111c.m6406c(getApplicationContext())))) + C1111c.m6388a(getApplicationContext(), 8.0f));
        if (getResources().getConfiguration().orientation == 2) {
            layoutParams.width = (int) (((double) point.x) * 0.75d);
        }
    }

    protected void m10367b(boolean z) {
    }

    protected int m10368l() {
        return 2130838598;
    }

    protected void m10369m() {
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8557a(bundle, true);
        m8556a(2130968741);
        m10366r();
        m8559a(getString(2131230891));
        m8563c(C1111c.m6402b(getApplicationContext(), null));
        m8569n();
        m8566d(null);
        if (bundle != null) {
            if (bundle.containsKey("KEY_GROUP_NAME")) {
                this.f7562p.setText(bundle.getString("KEY_GROUP_NAME"));
            }
            if (bundle.containsKey("KEY_GROUP_MOTTO")) {
                this.f7564r.setText(bundle.getString("KEY_GROUP_MOTTO"));
            }
        }
        if (this.m != null) {
            m8564c(this.m);
            m8566d(this.m);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755045, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131689999) {
            String obj = this.f7562p.getText().toString();
            String obj2 = this.f7564r.getText().toString();
            if (obj.trim().isEmpty()) {
                this.f7561o.setErrorEnabled(true);
                this.f7561o.setError(getString(2131230858));
                new Handler().postDelayed(new C2397r(this), 100);
            } else {
                this.f7561o.setErrorEnabled(false);
                m10364a(obj, obj2);
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String obj = this.f7562p.getText().toString();
        if (!obj.isEmpty()) {
            bundle.putString("KEY_GROUP_NAME", obj);
        }
        obj = this.f7564r.getText().toString();
        if (!obj.isEmpty()) {
            bundle.putString("KEY_GROUP_MOTTO", obj);
        }
    }
}
