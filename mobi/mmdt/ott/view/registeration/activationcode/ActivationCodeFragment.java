package mobi.mmdt.ott.view.registeration.activationcode;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import at.grabner.circleprogress.CircleProgressView;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import net.frakbot.glowpadbackport.BuildConfig;

public class ActivationCodeFragment extends Fragment {
    private int f7886a;
    private ag f7887b;
    private View f7888c;
    private ViewGroup f7889d;
    private TextInputLayout f7890e;
    private EditText f7891f;
    private TextView f7892g;
    private CircleProgressView f7893h;
    private RoundAvatarImageView f7894i;
    private boolean f7895j;
    private boolean f7896k;

    public ActivationCodeFragment() {
        this.f7886a = 61;
        this.f7895j = false;
        this.f7896k = false;
    }

    private void m10610d() {
        this.f7889d = (ViewGroup) this.f7888c.findViewById(2131689635);
        this.f7890e = (TextInputLayout) this.f7888c.findViewById(2131689788);
        this.f7891f = (EditText) this.f7888c.findViewById(2131689789);
        this.f7892g = (TextView) this.f7888c.findViewById(2131689793);
        this.f7894i = (RoundAvatarImageView) this.f7888c.findViewById(2131689791);
        this.f7894i.setBackgroundColor(getResources().getColor(2131623995));
        this.f7893h = (CircleProgressView) this.f7888c.findViewById(2131689792);
        this.f7891f.setFilters(new InputFilter[]{new LengthFilter(6)});
        m10612e();
        this.f7894i.setOnClickListener(new C2430y(this));
        this.f7888c.findViewById(2131689790).setOnClickListener(new C2431z(this));
    }

    private void m10612e() {
        this.f7893h.setRimColor(getResources().getColor(2131623994));
        this.f7893h.setBarColor(getResources().getColor(2131623993));
        this.f7893h.setMaxValue(61.0f);
        this.f7893h.m4127b();
        this.f7893h.setValue((float) this.f7886a);
        this.f7893h.setText(this.f7886a + BuildConfig.FLAVOR);
        if (this.f7886a != 1) {
            this.f7894i.setAlpha(0.0f);
            this.f7892g.setAlpha(0.0f);
            this.f7895j = true;
            new ac(this, (long) (this.f7886a * 1000), 1000).start();
            return;
        }
        this.f7893h.setAlpha(0.0f);
        this.f7894i.setAlpha(1.0f);
        this.f7892g.setAlpha(1.0f);
    }

    public String m10616a() {
        return (this.f7891f == null || this.f7891f.getText() == null || this.f7891f.getText().toString().isEmpty()) ? null : this.f7891f.getText().toString();
    }

    public void m10617a(String str) {
        if (this.f7890e != null && str != null && !str.isEmpty()) {
            this.f7890e.setErrorEnabled(true);
            this.f7890e.setError(getString(2131230793) + str + getString(2131230794));
        }
    }

    public void m10618b() {
        new Handler().postDelayed(new aa(this), 100);
        new Handler().postDelayed(new ab(this), 600);
    }

    public void m10619b(String str) {
        if (this.f7891f != null && str != null && !str.isEmpty()) {
            this.f7891f.setText(str);
            this.f7891f.requestFocus();
        }
    }

    public void m10620c() {
        new Handler().postDelayed(new af(this), 100);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f7887b = (ag) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IActivationCodeFragmentCallback" + ".");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null && bundle.containsKey("KEY_CURRENT_REMAINING_TIME")) {
            this.f7886a = bundle.getInt("KEY_CURRENT_REMAINING_TIME");
        }
        this.f7888c = layoutInflater.inflate(2130968707, viewGroup, false);
        return this.f7888c;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("KEY_CURRENT_REMAINING_TIME", this.f7886a);
    }

    public void onViewCreated(View view, Bundle bundle) {
        m10610d();
    }
}
