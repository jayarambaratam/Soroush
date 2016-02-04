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
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.main.p236b.p242b.C2300b;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.conversation.forward.b */
public class C2239b extends Fragment implements LoaderCallbacks<Cursor>, C1790i {
    private ViewGroup f7368a;
    private RecyclerView f7369b;
    private C2240c f7370c;
    private C2237j f7371d;

    public void m10149a(Loader<Cursor> loader, Cursor cursor) {
        if (this.f7370c != null) {
            this.f7370c.m8748c(cursor);
        }
    }

    public void m10150a(RecyclerView recyclerView) {
        int i = 0;
        if (recyclerView.getLayoutManager() != null) {
            i = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.scrollToPosition(i);
    }

    public void m10151a(View view, int i) {
        this.f7371d.m10137a(((C2300b) this.f7370c.m8752a(i)).m10416f(), false);
    }

    public void m10152b(View view, int i) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f7371d = (C2237j) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IForwardInteractionListener");
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1607a.m8160b(getActivity(), bundle.getString("searchPattern"));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968728, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.f7369b != null) {
            this.f7369b.setItemAnimator(null);
            this.f7369b.setAdapter(null);
            this.f7369b = null;
        }
        this.f7370c = null;
        super.onDestroyView();
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m10149a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        if (this.f7370c != null) {
            this.f7370c.m8748c(null);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f7368a = (ViewGroup) getView().findViewById(2131689631);
        this.f7369b = (RecyclerView) getView().findViewById(2131689797);
        this.f7370c = new C2240c(this, getActivity());
        Bundle bundle2 = new Bundle();
        bundle2.putString("searchPattern", BuildConfig.FLAVOR);
        getLoaderManager().initLoader(11, bundle2, this);
        this.f7369b.setHasFixedSize(true);
        this.f7369b.setAdapter(this.f7370c);
        m10150a(this.f7369b);
    }
}
