package mobi.mmdt.ott.view.registeration.introduction;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* renamed from: mobi.mmdt.ott.view.registeration.introduction.m */
public class C2445m extends Fragment {
    private C2433o f7952a;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f7952a = (C2433o) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement ILanguageFragmentCallback" + ".");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130968755, viewGroup, false);
        TextView textView = (TextView) viewGroup2.findViewById(2131689868);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(Html.fromHtml(getActivity().getString(2131230866)));
        ((AppCompatCheckBox) viewGroup2.findViewById(2131689897)).setOnCheckedChangeListener(new C2446n(this));
        return viewGroup2;
    }
}
