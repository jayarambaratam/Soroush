package mobi.mmdt.ott.view.components.mediacaption;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.view.components.mediacaption.p204b.C1878b;
import mobi.mmdt.ott.view.components.mediacaption.p204b.C1879c;
import mobi.mmdt.ott.view.components.mediaselector.C1893a;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.components.mediacaption.a */
public class C1876a extends Fragment implements C1790i, C1875j {
    private RecyclerView f6040a;
    private C1881d f6041b;
    private GridLayoutManager f6042c;
    private C1870c f6043d;
    private int f6044e;
    private int f6045f;
    private int f6046g;

    public C1876a() {
        this.f6046g = 10;
    }

    public void m9023a() {
        if (this.f6041b != null) {
            this.f6041b.notifyDataSetChanged();
        }
    }

    public void m9024a(View view, int i) {
        if (this.f6041b.m8655a(i).m8659g() == 2) {
            this.f6043d.e_();
        }
    }

    public void m9025a(C1879c c1879c) {
        this.f6041b.m9034a(c1879c);
        new Handler().postDelayed(new C1880b(this), 500);
    }

    public void m9026b(View view, int i) {
    }

    public void m9027b(C1879c c1879c) {
        this.f6043d.m8992a(c1879c);
    }

    public void m9028c(C1879c c1879c) {
        this.f6043d.m8993b(c1879c);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getArguments() != null && getArguments().containsKey("KEY_RESULT_ARRAYLIST_OF_PATH")) {
            ArrayList stringArrayList = getArguments().getStringArrayList("KEY_RESULT_ARRAYLIST_OF_PATH");
            List arrayList = new ArrayList();
            for (int i = 0; i < stringArrayList.size(); i++) {
                String str = (String) stringArrayList.get(i);
                String l = ((MediaCaptionActivity) getActivity()).m9013l();
                boolean z = l != null && l.equals(str);
                arrayList.add(new C1879c(i, str, str, z));
            }
            if (stringArrayList.size() < this.f6046g) {
                arrayList.add(new C1878b(stringArrayList.size()));
            }
            this.f6041b.m8656a(arrayList);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f6043d = (C1870c) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnImageCaptionPhotosGridFragmentInteractionListener");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null && getArguments().containsKey("EXTRA_MAX_PHOTO_SELECT_COUNT")) {
            this.f6046g = getArguments().getInt("EXTRA_MAX_PHOTO_SELECT_COUNT");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968733, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.f6040a != null) {
            this.f6040a.setItemAnimator(null);
            this.f6040a.setAdapter(null);
            this.f6040a = null;
        }
        this.f6041b = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i;
        super.onViewCreated(view, bundle);
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (getResources().getConfiguration().orientation == 1) {
            this.f6044e = point.x / 5;
            this.f6045f = this.f6044e;
            i = 5;
        } else {
            this.f6044e = point.x / 10;
            this.f6045f = this.f6044e;
            i = 10;
        }
        this.f6042c = new GridLayoutManager(getActivity(), i);
        this.f6040a = (RecyclerView) getView().findViewById(2131689797);
        this.f6040a.addItemDecoration(new C1893a((int) C1111c.m6388a(getActivity(), 2.0f), i));
        this.f6041b = new C1881d(this, getActivity());
        this.f6040a.setHasFixedSize(true);
        this.f6040a.setAdapter(this.f6041b);
        this.f6040a.setLayoutManager(this.f6042c);
    }
}
