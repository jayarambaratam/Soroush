package mobi.mmdt.ott.view.components.mediaselector.videoselection;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager.LoaderCallbacks;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.view.components.mediaselector.C1893a;
import mobi.mmdt.ott.view.components.mediaselector.p206b.C1897d;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.videoselection.a */
public class C1915a extends Fragment implements C1790i {
    private RecyclerView f6139a;
    private C1917c f6140b;
    private GridLayoutManager f6141c;
    private C1914d f6142d;
    private int f6143e;
    private int f6144f;
    private String f6145g;
    private String f6146h;
    private LoaderCallbacks<Cursor> f6147i;

    public C1915a() {
        this.f6147i = new C1916b(this);
    }

    public void m9149a(View view, int i) {
        this.f6142d.m9143a(((C1897d) this.f6140b.m8655a(i)).m9074a());
    }

    public void m9150b(View view, int i) {
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().getLoaderManager().initLoader(29, null, this.f6147i);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f6142d = (C1914d) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnVideoSelectorFragmentInteractionListener");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968740, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.f6139a != null) {
            this.f6139a.setItemAnimator(null);
            this.f6139a.setAdapter(null);
            this.f6139a = null;
        }
        this.f6140b = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i;
        super.onViewCreated(view, bundle);
        this.f6145g = getArguments().getString("KEY_FOLDER_PATH");
        this.f6146h = getArguments().getString("KEY_FOLDER_NAME");
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (getResources().getConfiguration().orientation == 1) {
            this.f6143e = point.x / 3;
            this.f6144f = this.f6143e;
            i = 3;
        } else {
            this.f6143e = point.x / 5;
            this.f6144f = this.f6143e;
            i = 5;
        }
        this.f6141c = new GridLayoutManager(getActivity(), i);
        this.f6139a = (RecyclerView) getView().findViewById(2131689797);
        this.f6139a.addItemDecoration(new C1893a((int) C1111c.m6388a(getActivity(), 2.0f), i));
        this.f6140b = new C1917c(this, getActivity());
        this.f6139a.setHasFixedSize(true);
        this.f6139a.setAdapter(this.f6140b);
        this.f6139a.setLayoutManager(this.f6141c);
    }
}
