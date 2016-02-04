package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.p063b.p064a.cn;
import java.util.ArrayList;
import java.util.List;
import mobi.mmdt.ott.view.components.p181b.C1720l;
import mobi.mmdt.ott.view.components.p181b.C1791j;
import mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2455a;
import mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2456b;
import mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2457c;
import mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.LayoutManager;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.a */
public class C2452a extends Fragment implements C1720l {
    private C2451d f7971a;
    private View f7972b;
    private FrameLayout f7973c;
    private RecyclerView f7974d;
    private C2455a f7975e;
    private final ArrayList<C2456b> f7976f;

    public C2452a() {
        this.f7976f = new ArrayList();
    }

    private List<C2456b> m10675a(List<C2456b> list) {
        List<C2456b> arrayList = new ArrayList();
        CharSequence charSequence = BuildConfig.FLAVOR;
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            int i5;
            CharSequence charSequence2;
            CharSequence substring = ((C2456b) list.get(i4)).f7997e.substring(0, 1);
            if (TextUtils.equals(charSequence, substring)) {
                i5 = i2;
                charSequence2 = charSequence;
            } else {
                i = 0;
                i3 = i4 + i2;
                i5 = i2 + 1;
                arrayList.add(new C2456b(substring, BuildConfig.FLAVOR, true, 0, i3, -1));
                charSequence2 = substring;
            }
            arrayList.add(new C2456b(((C2456b) list.get(i4)).f7997e, ((C2456b) list.get(i4)).f7998f, false, i, i3, i4));
            i4++;
            i2 = i5;
            charSequence = charSequence2;
        }
        return arrayList;
    }

    private List<C2456b> m10676a(List<C2456b> list, String str) {
        String toLowerCase = str.toLowerCase();
        List<C2456b> arrayList = new ArrayList();
        for (C2456b c2456b : list) {
            for (String startsWith : c2456b.f7997e.toLowerCase().split(" ")) {
                if (startsWith.startsWith(toLowerCase)) {
                    arrayList.add(c2456b);
                    break;
                }
            }
        }
        return arrayList;
    }

    private void m10677a() {
        this.f7973c = (FrameLayout) this.f7972b.findViewById(2131689844);
        this.f7974d = (RecyclerView) this.f7972b.findViewById(2131689797);
        this.f7974d.setLayoutManager(new LayoutManager(getActivity()));
        this.f7975e = new C2455a(getActivity(), this.f7974d);
        for (int i = 0; i < C2457c.f7999a.length; i++) {
            this.f7976f.add(new C2456b(C2457c.f7999a[i], C2457c.f8000b[i], false, 0, 0, 0));
        }
        this.f7975e.m10725a(m10675a(this.f7976f));
        this.f7974d.addOnItemTouchListener(new C1791j(getActivity(), this.f7974d, this));
        this.f7975e.m10727a(false);
        this.f7975e.m10728b(16);
        this.f7974d.setAdapter(this.f7975e);
        this.f7973c.setAlpha(0.0f);
        m10678b();
    }

    private void m10678b() {
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = getResources().getConfiguration().orientation == 1 ? (point.x * 50) / 100 : (point.y * 50) / 100;
        View cnVar = new cn(getActivity());
        cnVar.setImageAsset("svg_no_country_found.svg");
        this.f7973c.addView(cnVar);
        cnVar.setLayoutParams(new LayoutParams(i, i));
    }

    public void m10679a(View view, int i) {
        if (this.f7975e.m10723a(i).f7995c != -1) {
            this.f7971a.m10672a(this.f7975e.m10723a(i).f7997e, this.f7975e.m10723a(i).f7998f);
        }
    }

    public void m10680a(String str) {
        List a = m10676a(this.f7976f, str);
        this.f7975e.m10725a(m10675a(a));
        if (a.isEmpty()) {
            new Handler().postDelayed(new C2453b(this), 50);
        } else {
            new Handler().postDelayed(new C2454c(this), 50);
        }
    }

    public void m10681b(View view, int i) {
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f7971a = (C2451d) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement ICountrySelectionFragmentCallback" + ".");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f7972b = layoutInflater.inflate(2130968720, viewGroup, false);
        return this.f7972b;
    }

    public void onViewCreated(View view, Bundle bundle) {
        m10677a();
    }
}
