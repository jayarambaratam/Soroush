package mobi.mmdt.ott.view.registeration.phoneandcountry;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import net.frakbot.glowpadbackport.BuildConfig;

public class PhoneAndCountryFragment extends Fragment {
    private C2447q f7956a;
    private View f7957b;
    private EditText f7958c;
    private EditText f7959d;
    private EditText f7960e;
    private TextInputLayout f7961f;
    private TextInputLayout f7962g;
    private TextInputLayout f7963h;
    private String f7964i;
    private String f7965j;
    private String f7966k;

    private void m10664e() {
        this.f7958c = (EditText) this.f7957b.findViewById(2131689875);
        this.f7959d = (EditText) this.f7957b.findViewById(2131689879);
        this.f7960e = (EditText) this.f7957b.findViewById(2131689881);
        this.f7961f = (TextInputLayout) this.f7957b.findViewById(2131689874);
        this.f7962g = (TextInputLayout) this.f7957b.findViewById(2131689878);
        this.f7963h = (TextInputLayout) this.f7957b.findViewById(2131689880);
        if (this.f7964i != null) {
            this.f7958c.setText(this.f7964i);
        }
        if (this.f7965j != null) {
            this.f7959d.setText(this.f7965j);
        }
        if (this.f7966k != null) {
            this.f7960e.setText(this.f7966k);
        }
        this.f7960e.setFilters(new InputFilter[]{new LengthFilter(16)});
        this.f7957b.findViewById(2131689876).setOnClickListener(new C2487p(this));
    }

    private boolean m10665f() {
        boolean z;
        if (this.f7958c != null) {
            String obj = this.f7958c.getText().toString();
            if (obj == null || obj.isEmpty() || obj.equals(getString(2131230883))) {
                this.f7961f.setErrorEnabled(true);
                this.f7961f.setError(getString(2131230976));
                z = false;
            } else {
                this.f7961f.setErrorEnabled(false);
                z = true;
            }
        } else {
            z = true;
        }
        if (this.f7960e == null) {
            return z;
        }
        String obj2 = this.f7960e.getText().toString();
        if (obj2 == null || obj2.isEmpty()) {
            this.f7963h.setErrorEnabled(true);
            this.f7963h.setError(getString(2131230977));
            return false;
        }
        this.f7963h.setErrorEnabled(false);
        return z;
    }

    public String m10666a() {
        return m10665f() ? this.f7958c.getText().toString() : null;
    }

    public void m10667a(String str) {
        this.f7960e.setText(str);
    }

    public void m10668a(String str, String str2) {
        CharSequence charSequence;
        CharSequence charSequence2;
        EditText editText = this.f7958c;
        if (str == null) {
            charSequence = BuildConfig.FLAVOR;
        }
        editText.setText(charSequence);
        editText = this.f7959d;
        if (str2 == null) {
            charSequence2 = BuildConfig.FLAVOR;
        }
        editText.setText(charSequence2);
        this.f7961f.setErrorEnabled(false);
    }

    public String m10669b() {
        return m10665f() ? this.f7959d.getText().toString() : null;
    }

    public boolean m10670c() {
        if (this.f7958c == null) {
            return false;
        }
        String obj = this.f7958c.getText().toString();
        return (obj == null || obj.isEmpty() || obj.equals(getString(2131230883))) ? false : true;
    }

    public String m10671d() {
        return m10665f() ? this.f7960e.getText().toString() : null;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f7956a = (C2447q) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IPhoneAndCountryFragmentCallback" + ".");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("KEY_COUNTRY_NAME")) {
                this.f7964i = bundle.getString("KEY_COUNTRY_NAME");
            }
            if (bundle.containsKey("KEY_COUNTRY_CODE")) {
                this.f7965j = bundle.getString("KEY_COUNTRY_CODE");
            }
            if (bundle.containsKey("KEY_PHONE_NUMBER")) {
                this.f7966k = bundle.getString("KEY_PHONE_NUMBER");
            }
        }
        this.f7957b = layoutInflater.inflate(2130968742, viewGroup, false);
        return this.f7957b;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("KEY_COUNTRY_NAME", this.f7958c.getText().toString());
        bundle.putString("KEY_COUNTRY_CODE", this.f7959d.getText().toString());
        bundle.putString("KEY_PHONE_NUMBER", this.f7960e.getText().toString());
    }

    public void onViewCreated(View view, Bundle bundle) {
        m10664e();
    }
}
