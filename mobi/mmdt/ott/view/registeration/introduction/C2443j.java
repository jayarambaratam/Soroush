package mobi.mmdt.ott.view.registeration.introduction;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import mobi.mmdt.ott.p109d.p111b.C1309a;

/* renamed from: mobi.mmdt.ott.view.registeration.introduction.j */
public class C2443j extends Fragment {
    private C2432l f7950a;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f7950a = (C2432l) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement ILanguageFragmentCallback" + ".");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130968736, viewGroup, false);
        RadioGroup radioGroup = (RadioGroup) viewGroup2.findViewById(2131689869);
        RadioButton radioButton = (RadioButton) viewGroup2.findViewById(2131689871);
        RadioButton radioButton2 = (RadioButton) viewGroup2.findViewById(2131689872);
        if (C1309a.m6934a(getActivity()).m6937a().equals("en-us")) {
            radioButton.setChecked(true);
        } else {
            radioButton2.setChecked(true);
        }
        radioGroup.setOnCheckedChangeListener(new C2444k(this));
        return viewGroup2;
    }
}
