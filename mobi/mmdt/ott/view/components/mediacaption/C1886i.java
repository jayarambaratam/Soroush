package mobi.mmdt.ott.view.components.mediacaption;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.p032a.p033a.C0872i;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.components.mediacaption.i */
public class C1886i extends Fragment {
    private View aa;
    private EditText ab;

    public static C1886i m9043a(int i, String str, String str2) {
        C1886i c1886i = new C1886i();
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_SECTION_NUMBER", i);
        bundle.putString("ARG_SECTION_PATH", str);
        bundle.putString("ARG_SECTION_CAPTION", str2);
        c1886i.m974b(bundle);
        return c1886i;
    }

    public String m9044J() {
        return (this.ab == null || this.ab.getText() == null) ? null : this.ab.getText().toString();
    }

    public View m9045a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aa = layoutInflater.inflate(2130968710, viewGroup, false);
        ImageView imageView = (ImageView) this.aa.findViewById(2131689670);
        this.ab = (EditText) this.aa.findViewById(2131689799);
        String string = m972b().getString("ARG_SECTION_PATH");
        this.ab.setFilters(new InputFilter[]{new LengthFilter(256)});
        C0872i.m5266a(m979c()).m5329a(string).m4406a(0.25f).m4417a(imageView);
        CharSequence string2 = m972b().getString("ARG_SECTION_CAPTION");
        if (string2 != null) {
            this.ab.setText(string2);
        } else {
            this.ab.setText(BuildConfig.FLAVOR);
        }
        return this.aa;
    }

    public void m9046a(String str) {
        if (this.ab != null) {
            this.ab.setText(str);
        }
    }
}
