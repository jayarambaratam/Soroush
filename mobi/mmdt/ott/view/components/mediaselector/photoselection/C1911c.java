package mobi.mmdt.ott.view.components.mediaselector.photoselection;

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
import android.widget.Toast;
import java.util.LinkedHashMap;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.view.components.mediaselector.C1893a;
import mobi.mmdt.ott.view.components.mediaselector.p206b.C1896c;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.photoselection.c */
public class C1911c extends Fragment implements C1790i, C1909a {
    private RecyclerView f6122a;
    private C1913e f6123b;
    private GridLayoutManager f6124c;
    private C1908f f6125d;
    private int f6126e;
    private int f6127f;
    private String f6128g;
    private String f6129h;
    private boolean f6130i;
    private int f6131j;
    private int f6132k;
    private int f6133l;
    private LoaderCallbacks<Cursor> f6134m;

    public C1911c() {
        this.f6131j = 0;
        this.f6132k = 2;
        this.f6133l = 10;
        this.f6134m = new C1912d(this);
    }

    private void m9128c(C1896c c1896c) {
        c1896c.m9070a(true);
        if (m9132e().size() >= this.f6133l) {
            c1896c.m9070a(false);
            Toast.makeText(getActivity(), "Can not share more than " + this.f6133l + " photos!", 0).show();
        } else if (!m9132e().containsKey(c1896c.m9069a())) {
            m9132e().put(c1896c.m9069a(), Boolean.valueOf(true));
        }
        m9139c();
        this.f6125d.m9110l();
        this.f6123b.notifyDataSetChanged();
    }

    private void m9130d(C1896c c1896c) {
        c1896c.m9070a(false);
        if (m9132e().size() > 0 && m9132e().containsKey(c1896c.m9069a())) {
            m9132e().remove(c1896c.m9069a());
        }
        this.f6125d.m9110l();
        this.f6123b.notifyDataSetChanged();
    }

    private LinkedHashMap<String, Boolean> m9132e() {
        return ((MyApplication) getActivity().getApplication()).f4172c;
    }

    public void m9133a(View view, int i) {
        C1896c c1896c = (C1896c) this.f6123b.m8655a(i);
        if (this.f6132k == 1 || this.f6132k == 3) {
            if (!this.f6130i) {
                this.f6125d.m9109a(c1896c.m9069a());
            } else if (c1896c.m9072c()) {
                m9130d(c1896c);
            } else {
                m9128c(c1896c);
            }
        } else if (this.f6132k == 2) {
            this.f6125d.m9109a(c1896c.m9069a());
        }
    }

    public void m9134a(C1896c c1896c) {
        m9128c(c1896c);
    }

    public boolean m9135a() {
        return this.f6130i;
    }

    public int m9136b() {
        return this.f6124c.findFirstCompletelyVisibleItemPosition();
    }

    public void m9137b(View view, int i) {
        if (this.f6132k == 1) {
            C1896c c1896c = (C1896c) this.f6123b.m8655a(i);
            if (c1896c.m9072c()) {
                m9130d(c1896c);
            } else {
                m9128c(c1896c);
            }
        }
    }

    public void m9138b(C1896c c1896c) {
        m9130d(c1896c);
    }

    public void m9139c() {
        if (!this.f6130i) {
            this.f6130i = true;
            if (this.f6123b != null) {
                this.f6123b.notifyDataSetChanged();
            }
        }
    }

    public void m9140d() {
        this.f6130i = false;
        if (this.f6123b != null) {
            this.f6123b.notifyDataSetChanged();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().getLoaderManager().initLoader(20, null, this.f6134m);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f6125d = (C1908f) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnPhotoSelectorFragmentInteractionListener");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            if (getArguments().containsKey("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION")) {
                this.f6131j = getArguments().getInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION");
            }
            if (getArguments().containsKey("EXTRA_MAX_PHOTO_SELECT_COUNT")) {
                this.f6133l = getArguments().getInt("EXTRA_MAX_PHOTO_SELECT_COUNT");
            }
            if (getArguments().containsKey("EXTRA_SELECT_MODE")) {
                this.f6132k = getArguments().getInt("EXTRA_SELECT_MODE");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968739, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.f6122a != null) {
            this.f6122a.setItemAnimator(null);
            this.f6122a.setAdapter(null);
            this.f6122a = null;
        }
        this.f6123b = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i;
        super.onViewCreated(view, bundle);
        if (m9132e().size() > 0) {
            this.f6130i = true;
        }
        this.f6128g = getArguments().getString("KEY_FOLDER_PATH");
        this.f6129h = getArguments().getString("KEY_FOLDER_NAME");
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (getResources().getConfiguration().orientation == 1) {
            this.f6126e = point.x / 3;
            this.f6127f = this.f6126e;
            i = 3;
        } else {
            this.f6126e = point.x / 5;
            this.f6127f = this.f6126e;
            i = 5;
        }
        this.f6124c = new GridLayoutManager(getActivity(), i);
        this.f6122a = (RecyclerView) getView().findViewById(2131689797);
        this.f6122a.addItemDecoration(new C1893a((int) C1111c.m6388a(getActivity(), 2.0f), i));
        this.f6123b = new C1913e(this, getActivity());
        this.f6122a.setHasFixedSize(true);
        this.f6122a.setAdapter(this.f6123b);
        this.f6122a.setLayoutManager(this.f6124c);
        this.f6122a.scrollToPosition(this.f6131j);
    }
}
