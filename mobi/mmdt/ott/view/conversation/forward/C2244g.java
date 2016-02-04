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

/* renamed from: mobi.mmdt.ott.view.conversation.forward.g */
public class C2244g extends Fragment implements LoaderCallbacks<Cursor>, C1790i {
    private ViewGroup f7381a;
    private RecyclerView f7382b;
    private C2246i f7383c;
    private C2237j f7384d;
    private String f7385e;

    public void m10163a(Loader<Cursor> loader, Cursor cursor) {
        if (this.f7383c != null) {
            this.f7383c.m8748c(cursor);
        }
    }

    public void m10164a(RecyclerView recyclerView) {
        int i = 0;
        if (recyclerView.getLayoutManager() != null) {
            i = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.scrollToPosition(i);
    }

    public void m10165a(View view, int i) {
        C2348a c2348a = (C2348a) this.f7383c.m8752a(i);
        boolean z = false;
        if (c2348a.m8659g() == 2) {
            z = true;
        }
        this.f7384d.m10137a(c2348a.m10528b(), z);
    }

    public void m10166b(View view, int i) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f7384d = (C2237j) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IForwardInteractionListener");
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1583c.m7991e(getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968730, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.f7382b != null) {
            this.f7382b.setItemAnimator(null);
            this.f7382b.setAdapter(null);
            this.f7382b = null;
        }
        this.f7383c = null;
        super.onDestroyView();
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m10163a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        if (this.f7383c != null) {
            this.f7383c.m8748c(null);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f7381a = (ViewGroup) getView().findViewById(2131689631);
        this.f7382b = (RecyclerView) getView().findViewById(2131689797);
        this.f7383c = new C2246i(this, getActivity());
        this.f7385e = C1309a.m6934a(getActivity()).m6942b();
        getLoaderManager().initLoader(13, null, this);
        this.f7382b.setHasFixedSize(true);
        this.f7382b.setAdapter(this.f7383c);
        m10164a(this.f7382b);
    }
}
