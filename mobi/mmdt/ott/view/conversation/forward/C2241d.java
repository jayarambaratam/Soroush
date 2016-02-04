package mobi.mmdt.ott.view.conversation.forward;

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
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.main.p237c.p244b.C2348a;

/* renamed from: mobi.mmdt.ott.view.conversation.forward.d */
public class C2241d extends Fragment implements LoaderCallbacks<Cursor>, C1790i {
    private ViewGroup f7373a;
    private RecyclerView f7374b;
    private C2243f f7375c;
    private C2237j f7376d;
    private String f7377e;

    public void m10156a(Loader<Cursor> loader, Cursor cursor) {
        if (this.f7375c != null) {
            this.f7375c.m8748c(cursor);
        }
    }

    public void m10157a(RecyclerView recyclerView) {
        int i = 0;
        if (recyclerView.getLayoutManager() != null) {
            i = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.scrollToPosition(i);
    }

    public void m10158a(View view, int i) {
        C2348a c2348a = (C2348a) this.f7375c.m8752a(i);
        boolean z = false;
        if (c2348a.m8659g() == 2) {
            z = true;
        }
        this.f7376d.m10137a(c2348a.m10528b(), z);
    }

    public void m10159b(View view, int i) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f7376d = (C2237j) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IForwardInteractionListener");
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1583c.m7993f(getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968729, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.f7374b != null) {
            this.f7374b.setItemAnimator(null);
            this.f7374b.setAdapter(null);
            this.f7374b = null;
        }
        this.f7375c = null;
        super.onDestroyView();
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m10156a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        if (this.f7375c != null) {
            this.f7375c.m8748c(null);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f7373a = (ViewGroup) getView().findViewById(2131689631);
        this.f7374b = (RecyclerView) getView().findViewById(2131689797);
        this.f7375c = new C2243f(this, getActivity());
        this.f7377e = C1309a.m6934a(getActivity()).m6942b();
        getLoaderManager().initLoader(12, null, this);
        this.f7374b.setHasFixedSize(true);
        this.f7374b.setAdapter(this.f7375c);
        m10157a(this.f7374b);
    }
}
