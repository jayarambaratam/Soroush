package mobi.mmdt.ott.view.stickermarket.stickersettings;

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
import mobi.mmdt.ott.provider.p175i.C1635a;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.stickermarket.stickersettings.p252b.C2603b;

public class StickerSettingsFragment extends Fragment implements LoaderCallbacks<Cursor>, C1790i, C2597a {
    private RecyclerView f8313a;
    private C2604c f8314b;
    private LinearLayoutManager f8315c;
    private C2596b f8316d;
    private int f8317e;

    public StickerSettingsFragment() {
        this.f8317e = 0;
    }

    public void m11039a(Loader<Cursor> loader, Cursor cursor) {
        if (this.f8314b != null) {
            this.f8314b.m8748c(cursor);
        }
    }

    public void m11040a(View view, int i) {
    }

    public void m11041a(C2603b c2603b) {
        C1635a.m8334a(getActivity(), c2603b.m11054b(), false);
    }

    public void m11042b(View view, int i) {
    }

    public void m11043b(C2603b c2603b) {
        C1635a.m8334a(getActivity(), c2603b.m11054b(), true);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f8316d = (C2596b) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnStickerSettingsFragmentInteractionListener");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null && getArguments().containsKey("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION")) {
            this.f8317e = getArguments().getInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION");
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1635a.m8335a(getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968753, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.f8313a != null) {
            this.f8313a.setItemAnimator(null);
            this.f8313a.setAdapter(null);
            this.f8313a = null;
        }
        this.f8314b = null;
        super.onDestroyView();
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m11039a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        if (this.f8314b != null) {
            this.f8314b.m8748c(null);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f8315c = new LinearLayoutManager(getActivity());
        this.f8313a = (RecyclerView) getView().findViewById(2131689797);
        this.f8314b = new C2604c(this, getActivity());
        this.f8313a.setHasFixedSize(true);
        this.f8313a.setAdapter(this.f8314b);
        this.f8313a.setLayoutManager(this.f8315c);
        this.f8313a.scrollToPosition(this.f8317e);
        getLoaderManager().initLoader(28, null, this);
    }
}
