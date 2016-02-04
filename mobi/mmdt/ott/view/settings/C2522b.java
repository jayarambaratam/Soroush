package mobi.mmdt.ott.view.settings;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import jp.wasabeef.recyclerview.animators.adapters.SlideInRightAnimationAdapter;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.settings.b */
public abstract class C2522b extends Fragment implements C1790i {
    private RecyclerView f8129a;
    private C2523c f8130b;
    private C2515d f8131c;
    private LinearLayoutManager f8132d;
    private List<C1722f> f8133e;

    public C2522b() {
        this.f8133e = new ArrayList();
    }

    private void m10853b() {
        this.f8130b = new C2523c(this, getActivity());
        this.f8130b.m8656a(this.f8133e);
        this.f8129a.setAdapter(this.f8130b);
    }

    public final void m10854a() {
        m10856a(this.f8133e);
        m10853b();
    }

    public void m10855a(View view, int i) {
        this.f8131c.m10838b(this.f8130b.m8655a(i).m8659g());
    }

    protected abstract void m10856a(List<C1722f> list);

    public void m10857b(View view, int i) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f8131c = (C2515d) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnSettingsListFragmentInteractionListener");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968747, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.f8129a != null) {
            this.f8129a.setItemAnimator(null);
            this.f8129a.setAdapter(null);
            this.f8129a = null;
        }
        this.f8130b = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f8129a = (RecyclerView) getView().findViewById(2131689797);
        Adapter slideInRightAnimationAdapter = new SlideInRightAnimationAdapter(this.f8130b);
        slideInRightAnimationAdapter.setFirstOnly(true);
        this.f8129a.setAdapter(slideInRightAnimationAdapter);
        this.f8129a.setHasFixedSize(true);
        this.f8132d = new LinearLayoutManager(getActivity());
        this.f8129a.setLayoutManager(this.f8132d);
        m10854a();
    }
}
