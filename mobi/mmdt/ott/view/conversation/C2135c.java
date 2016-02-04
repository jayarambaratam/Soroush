package mobi.mmdt.ott.view.conversation;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRadioButton;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import mobi.mmdt.componentsutils.C1118e;
import mobi.mmdt.ott.view.conversation.p213a.C1982b;

/* renamed from: mobi.mmdt.ott.view.conversation.c */
public class C2135c {
    public static CheckBox m9791a(Context context, String str, String str2, boolean z, C1982b c1982b) {
        CheckBox appCompatCheckBox = new AppCompatCheckBox(new ContextThemeWrapper(context, 2131427707));
        appCompatCheckBox.setTextSize(0, context.getResources().getDimension(2131361883));
        appCompatCheckBox.setTextColor(context.getResources().getColor(C1118e.textColorPrimary));
        appCompatCheckBox.setOnCheckedChangeListener(new C2193d(str, str2, c1982b, z));
        return appCompatCheckBox;
    }

    public static EditText m9792a(Context context, String str, int i, int i2) {
        EditText appCompatEditText = new AppCompatEditText(new ContextThemeWrapper(context, 2131427707));
        appCompatEditText.setTextColor(context.getResources().getColor(C1118e.textColorPrimary));
        appCompatEditText.setTextSize(0, context.getResources().getDimension(2131361883));
        appCompatEditText.setLayoutParams(new LayoutParams(-1, -2));
        appCompatEditText.setFilters(new InputFilter[]{new LengthFilter(i)});
        appCompatEditText.addTextChangedListener(new C2236f(str, i2));
        return appCompatEditText;
    }

    public static String m9793a(String str, int i) {
        return "EDIT_TEXT_" + str + "_" + i;
    }

    public static String m9794a(String str, String str2) {
        return "CHECK_BOX_" + str + "_" + str2;
    }

    public static RadioButton m9795b(Context context, String str, String str2, boolean z, C1982b c1982b) {
        RadioButton appCompatRadioButton = new AppCompatRadioButton(new ContextThemeWrapper(context, 2131427707));
        appCompatRadioButton.setTextSize(0, context.getResources().getDimension(2131361883));
        appCompatRadioButton.setTextColor(context.getResources().getColor(C1118e.textColorPrimary));
        appCompatRadioButton.setOnCheckedChangeListener(new C2194e(str, str2, c1982b, z));
        return appCompatRadioButton;
    }

    public static String m9796b(String str, String str2) {
        return "RADIO_BUTTON_" + str + "_" + str2;
    }
}
