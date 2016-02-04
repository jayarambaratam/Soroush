package mobi.mmdt.ott.view.conversation.sharedmediaviewer;

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
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.view.components.mediaselector.C1893a;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.sharedmediaviewer.p234b.C2280a;
import mobi.mmdt.ott.view.conversation.sharedmediaviewer.p234b.C2281b;
import mobi.mmdt.ott.view.conversation.sharedmediaviewer.p234b.C2282c;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.view.conversation.sharedmediaviewer.a */
public class C2279a extends Fragment implements C1790i {
    private RecyclerView f7512a;
    private C2284d f7513b;
    private GridLayoutManager f7514c;
    private C2276c f7515d;
    private int f7516e;
    private int f7517f;
    private String f7518g;
    private ProgressWheel f7519h;
    private int f7520i;
    private LoaderCallbacks<Cursor> f7521j;

    public C2279a() {
        this.f7520i = 0;
        this.f7521j = new C2283b(this);
    }

    public int m10283a() {
        return this.f7514c.findFirstCompletelyVisibleItemPosition();
    }

    public void m10284a(View view, int i) {
        C2280a c2280a = (C2280a) this.f7513b.m8752a(i);
        switch (c2280a.m8659g()) {
            case VideoSize.CIF /*1*/:
                C2281b c2281b = (C2281b) c2280a;
                this.f7515d.m10270a(c2281b.m10286a(), c2281b.m10287b());
            case VideoSize.HVGA /*2*/:
                C2282c c2282c = (C2282c) c2280a;
                this.f7515d.m10271b(c2282c.m10288a(), c2282c.m10289b());
            default:
        }
    }

    public void m10285b(View view, int i) {
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().getLoaderManager().initLoader(23, null, this.f7521j);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f7515d = (C2276c) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnSharedMediaViewerFragmentInteractionListener");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null && getArguments().containsKey("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION")) {
            this.f7520i = getArguments().getInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968748, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.f7512a != null) {
            this.f7512a.setItemAnimator(null);
            this.f7512a.setAdapter(null);
            this.f7512a = null;
        }
        this.f7513b = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i;
        super.onViewCreated(view, bundle);
        this.f7518g = getArguments().getString("KEY_PEER_PARTY");
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (getResources().getConfiguration().orientation == 1) {
            this.f7516e = point.x / 3;
            this.f7517f = this.f7516e;
            i = 3;
        } else {
            this.f7516e = point.x / 5;
            this.f7517f = this.f7516e;
            i = 5;
        }
        this.f7514c = new GridLayoutManager(getActivity(), i);
        this.f7519h = (ProgressWheel) getView().findViewById(C1119f.progress_wheel);
        this.f7512a = (RecyclerView) getView().findViewById(2131689797);
        this.f7512a.addItemDecoration(new C1893a((int) C1111c.m6388a(getActivity(), 2.0f), i));
        this.f7513b = new C2284d(this, getActivity());
        this.f7512a.setHasFixedSize(true);
        this.f7512a.setAdapter(this.f7513b);
        this.f7512a.setLayoutManager(this.f7514c);
        this.f7512a.scrollToPosition(this.f7520i);
    }
}
