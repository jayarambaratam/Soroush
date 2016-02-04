package mobi.mmdt.ott.view.conversation.groupinfo;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mobi.mmdt.ott.provider.p172f.C1614a;
import mobi.mmdt.ott.provider.p172f.C1616c;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.components.p181b.p197a.C1783a;

public class aw extends Fragment implements LoaderCallbacks<Cursor>, C1790i {
    private RecyclerView f7452a;
    private ax f7453b;
    private ay f7454c;
    private int f7455d;
    private LinearLayoutManager f7456e;
    private String f7457f;

    public aw() {
        this.f7455d = 0;
    }

    public void m10258a(Loader<Cursor> loader, Cursor cursor) {
        if (this.f7453b != null) {
            this.f7453b.m8748c(cursor);
        }
    }

    public void m10259a(View view, int i) {
        this.f7454c.m10182g(((C1616c) this.f7453b.m8746b(i)).m8235a());
    }

    public void m10260b(View view, int i) {
        C1616c c1616c = (C1616c) this.f7453b.m8746b(i);
        this.f7454c.m10181a(c1616c.m8235a(), c1616c.m8237c(), c1616c.m8236b());
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f7454c = (ay) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnGroupMembersListFragmentInteractionListener");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null && getArguments().containsKey("KEY_GROUP_ID")) {
            this.f7457f = getArguments().getString("KEY_GROUP_ID");
        }
        this.f7453b = new ax(this, getActivity());
        getLoaderManager().initLoader(17, null, this);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1614a.m8229a(getActivity(), this.f7457f);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968732, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.f7452a != null) {
            this.f7452a.setItemAnimator(null);
            this.f7452a.setAdapter(null);
            this.f7452a = null;
        }
        this.f7453b = null;
        super.onDestroyView();
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m10258a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        if (this.f7453b != null) {
            this.f7453b.m8748c(null);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f7452a = (RecyclerView) getView().findViewById(2131689797);
        this.f7452a.setHasFixedSize(false);
        this.f7452a.setNestedScrollingEnabled(false);
        this.f7452a.setAdapter(this.f7453b);
        this.f7456e = new C1783a(getActivity());
        this.f7452a.setLayoutManager(this.f7456e);
        this.f7452a.scrollToPosition(this.f7455d);
    }
}
