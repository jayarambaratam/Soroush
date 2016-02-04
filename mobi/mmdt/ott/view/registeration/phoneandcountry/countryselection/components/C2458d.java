package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import mobi.mmdt.componentsutils.C1119f;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.d */
class C2458d extends ViewHolder {
    private TextView f8001a;
    private TextView f8002b;

    C2458d(View view) {
        super(view);
        this.f8001a = (TextView) view.findViewById(2131689910);
        this.f8002b = (TextView) view.findViewById(C1119f.text2);
    }

    public void m10730a(String str, String str2) {
        this.f8001a.setText(str);
        this.f8002b.setText(str2);
    }

    public String toString() {
        return this.f8001a.getText().toString() + "_" + this.f8002b.getText().toString();
    }
}
