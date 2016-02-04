package mobi.mmdt.ott.view.components.fileselector;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileFilter;
import java.util.LinkedHashMap;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.view.components.fileselector.p199b.C1807a;
import mobi.mmdt.ott.view.components.fileselector.p199b.C1808b;
import mobi.mmdt.ott.view.components.fileselector.p199b.C1809c;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.components.fileselector.b */
public class C1811b extends Fragment implements C1790i, C1810h {
    private RelativeLayout f5822a;
    private TextView f5823b;
    private RecyclerView f5824c;
    private C1815f f5825d;
    private LinearLayoutManager f5826e;
    private C1802g f5827f;
    private FileFilter f5828g;
    private String f5829h;
    private boolean f5830i;
    private int f5831j;
    private int f5832k;
    private int f5833l;

    public C1811b() {
        this.f5831j = 0;
        this.f5832k = 1;
        this.f5833l = 10;
    }

    private void m8807c(C1808b c1808b) {
        c1808b.m8790a(true);
        if (m8810e().size() >= this.f5833l) {
            c1808b.m8790a(false);
            Toast.makeText(getActivity(), "Can not share more than " + this.f5833l + " files!", 0).show();
        } else if (!m8810e().containsKey(c1808b.m8793c())) {
            m8810e().put(c1808b.m8793c(), Boolean.valueOf(true));
        }
        m8817c();
        this.f5827f.m8766l();
        this.f5825d.notifyDataSetChanged();
    }

    private void m8809d(C1808b c1808b) {
        c1808b.m8790a(false);
        if (m8810e().size() > 0 && m8810e().containsKey(c1808b.m8793c())) {
            m8810e().remove(c1808b.m8793c());
        }
        this.f5827f.m8766l();
        this.f5825d.notifyDataSetChanged();
    }

    private LinkedHashMap<String, Boolean> m8810e() {
        return ((MyApplication) getActivity().getApplication()).f4173d;
    }

    public int m8811a() {
        return this.f5826e.findFirstCompletelyVisibleItemPosition();
    }

    public void m8812a(View view, int i) {
        C1807a c1807a = (C1807a) this.f5825d.m8655a(i);
        if (c1807a.m8659g() == 1) {
            C1808b c1808b = (C1808b) c1807a;
            if (this.f5832k == 1) {
                if (!this.f5830i) {
                    this.f5827f.m8764a(c1808b.m8793c());
                } else if (c1808b.m8794d()) {
                    m8809d(c1808b);
                } else {
                    m8807c(c1808b);
                }
            } else if (this.f5832k == 2) {
                this.f5827f.m8764a(c1808b.m8793c());
            }
        } else if (c1807a.m8659g() == 2) {
            this.f5827f.m8765b(((C1809c) c1807a).m8799c());
        }
    }

    public void m8813a(C1808b c1808b) {
        m8807c(c1808b);
    }

    public void m8814b(View view, int i) {
        if (this.f5832k == 1) {
            C1807a c1807a = (C1807a) this.f5825d.m8655a(i);
            if (c1807a.m8659g() == 1) {
                C1808b c1808b = (C1808b) c1807a;
                if (c1808b.m8794d()) {
                    m8809d(c1808b);
                } else {
                    m8807c(c1808b);
                }
            }
        }
    }

    public void m8815b(C1808b c1808b) {
        m8809d(c1808b);
    }

    public boolean m8816b() {
        return this.f5830i;
    }

    public void m8817c() {
        if (!this.f5830i) {
            this.f5830i = true;
            if (this.f5825d != null) {
                this.f5825d.notifyDataSetChanged();
            }
        }
    }

    public void m8818d() {
        this.f5830i = false;
        if (this.f5825d != null) {
            this.f5825d.notifyDataSetChanged();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        new C1814e(this).execute(new Object[]{this.f5829h});
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f5827f = (C1802g) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFileSelectorFragmentInteractionListener");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            if (getArguments().containsKey("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION")) {
                this.f5831j = getArguments().getInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION");
            }
            if (getArguments().containsKey("EXTRA_MAX_PHOTO_SELECT_COUNT")) {
                this.f5833l = getArguments().getInt("EXTRA_MAX_PHOTO_SELECT_COUNT");
            }
            if (getArguments().containsKey("EXTRA_SELECT_MODE")) {
                this.f5832k = getArguments().getInt("EXTRA_SELECT_MODE");
            }
        }
        this.f5828g = new C1812c(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968726, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.f5824c != null) {
            this.f5824c.setItemAnimator(null);
            this.f5824c.setAdapter(null);
            this.f5824c = null;
        }
        this.f5825d = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (m8810e().size() > 0) {
            this.f5830i = true;
        }
        if (getArguments() != null && getArguments().containsKey("KEY_FOLDER_PATH")) {
            this.f5829h = getArguments().getString("KEY_FOLDER_PATH");
        }
        if (this.f5829h == null) {
            this.f5829h = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay().getSize(new Point());
        this.f5822a = (RelativeLayout) getView().findViewById(2131689852);
        this.f5823b = (TextView) getView().findViewById(2131689853);
        this.f5826e = new LinearLayoutManager(getActivity());
        this.f5824c = (RecyclerView) getView().findViewById(2131689797);
        this.f5825d = new C1815f(this, getActivity());
        this.f5824c.setHasFixedSize(true);
        this.f5824c.setAdapter(this.f5825d);
        this.f5824c.setLayoutManager(this.f5826e);
        this.f5824c.scrollToPosition(this.f5831j);
        this.f5822a.setOnClickListener(new C1813d(this));
        this.f5823b.setText(this.f5829h);
    }
}
