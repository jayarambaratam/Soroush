package mobi.mmdt.ott.view.conversation.p214b;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.view.components.p181b.C1720l;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1786a;
import mobi.mmdt.ott.view.components.p181b.C1791j;
import mobi.mmdt.ott.view.conversation.activities.C1992a;
import mobi.mmdt.ott.view.conversation.activities.ChannelConversationActivity;
import mobi.mmdt.ott.view.conversation.p213a.C1983c;
import mobi.mmdt.ott.view.conversation.p222d.C2151a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.conversation.b.a */
public class C2019a extends Fragment implements LoaderCallbacks<Cursor>, C1720l, C1983c {
    public static String f6561a;
    public static String f6562b;
    public static String f6563c;
    public static String f6564d;
    private static String f6565e;
    private int f6566A;
    private boolean f6567B;
    private RecyclerView f6568f;
    private TextView f6569g;
    private FloatingActionButton f6570h;
    private LinearLayoutManager f6571i;
    private RelativeLayout f6572j;
    private C1786a f6573k;
    private C1989e f6574l;
    private String f6575m;
    private int f6576n;
    private int f6577o;
    private int f6578p;
    private boolean f6579q;
    private boolean f6580r;
    private boolean f6581s;
    private int f6582t;
    private int f6583u;
    private int f6584v;
    private boolean f6585w;
    private int f6586x;
    private int f6587y;
    private int f6588z;

    static {
        f6565e = "KEY_EXPECTED_ITEMS_COUNT";
        f6561a = "KEY_PEER_PARTY";
        f6562b = "KEY_TOP_VISIBLE_ITEM_IN_ROTATION";
        f6563c = "KEY_IS_ROTATED";
        f6564d = "KEY_MESSAGES_COUNT_LIMIT";
    }

    public C2019a() {
        this.f6575m = BuildConfig.FLAVOR;
        this.f6579q = false;
        this.f6580r = false;
        this.f6581s = false;
        this.f6584v = 20;
        this.f6566A = -1;
    }

    private void m9629a(int i) {
        this.f6568f.scrollToPosition(i);
    }

    private void m9640h() {
        this.f6581s = false;
        this.f6570h.setVisibility(8);
        m9629a(0);
        this.f6574l.m9352s();
    }

    public void m9643a(Loader<Cursor> loader, Cursor cursor) {
        if (this.f6573k != null) {
            int position = cursor.getPosition();
            int i = -1;
            if (cursor.moveToFirst()) {
                i = cursor.getInt(cursor.getColumnIndex("_id"));
                cursor.moveToPosition(position);
            }
            position = i;
            this.f6583u = cursor.getCount();
            if (this.f6566A > 0) {
                if (this.f6583u < this.f6566A) {
                    this.f6567B = true;
                } else {
                    this.f6567B = false;
                }
            }
            this.f6573k.m8748c(cursor);
            if (this.f6579q) {
                m9629a(this.f6578p);
            } else if (this.f6588z < position) {
                if (((C2151a) this.f6573k.m8752a(0)).m9839a()) {
                    m9640h();
                } else {
                    this.f6574l.m9350F();
                    if (this.f6586x <= 2) {
                        m9640h();
                    } else {
                        this.f6568f.scrollBy(0, -this.f6568f.getChildAt(0).getHeight());
                        this.f6581s = true;
                        this.f6570h.setVisibility(0);
                    }
                }
            }
            if (this.f6583u > 0) {
                this.f6585w = false;
                this.f6579q = false;
            }
            this.f6582t = this.f6583u;
            this.f6588z = position;
            if (this.f6583u < 10) {
                this.f6569g.setVisibility(8);
            } else {
                this.f6569g.setVisibility(0);
            }
            if (this.f6583u > 0 && this.f6572j.getVisibility() == 0) {
                this.f6572j.setVisibility(8);
            }
        }
    }

    public void m9644a(View view, int i) {
    }

    public boolean m9645a() {
        return this.f6567B;
    }

    public int m9646b() {
        return this.f6584v;
    }

    public void m9647b(View view, int i) {
        if (i >= 0) {
            C1722f a = this.f6573k.m8752a(i);
            if (a instanceof C2152a) {
                this.f6574l.m9351a((C2152a) a);
            }
        }
    }

    public void m9648c() {
        this.f6585w = true;
        ((C1992a) getActivity()).m9403a(this.f6573k.getItemCount(), this.f6583u > 0 ? ((C2151a) this.f6573k.m8752a(0)).m9844f() : null);
    }

    public void m9649d() {
        this.f6584v = ((C1992a) getActivity()).m9439n() + this.f6584v;
        Bundle bundle = new Bundle();
        bundle.putInt(f6565e, this.f6584v);
        getActivity().getLoaderManager().restartLoader(9, bundle, this);
    }

    public int m9650e() {
        return this.f6586x;
    }

    public void m9651f() {
        this.f6573k.notifyDataSetChanged();
    }

    public void m9652g() {
        m9629a(this.f6586x);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f6574l = (C1989e) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnConversationsListFragmentInteractionListener");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f6575m = getArguments().getString(f6561a);
            this.f6578p = getArguments().getInt(f6562b);
            this.f6584v = getArguments().getInt(f6564d, ((C1992a) getActivity()).m9438m());
            this.f6579q = getArguments().getBoolean(f6563c);
        }
        int l = ((C1992a) getActivity()).m9437l();
        if (!this.f6579q && l > 0) {
            this.f6579q = true;
            this.f6578p = l - 1;
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        this.f6566A = -1;
        if (bundle != null) {
            this.f6566A = bundle.getInt(f6565e, -1);
        }
        return C1583c.m7970a(getActivity(), this.f6575m, this.f6584v);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968718, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.f6568f != null) {
            this.f6568f.setItemAnimator(null);
            this.f6568f.setAdapter(null);
            this.f6568f = null;
        }
        this.f6573k = null;
        super.onDestroyView();
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m9643a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        if (this.f6573k != null) {
            this.f6573k.m8748c(null);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        int g = (int) C1111c.m6415g(getActivity());
        int h = (int) C1111c.m6416h(getActivity());
        int i = C1111c.m6414f(getActivity()).x / 2;
        int z = C1309a.m6934a(getActivity()).m6983z();
        this.f6576n = C1111c.m6389a(getActivity());
        this.f6577o = ((C1992a) getActivity()).m9440o();
        this.f6568f = (RecyclerView) getView().findViewById(2131689797);
        this.f6569g = (TextView) getView().findViewById(2131689717);
        this.f6570h = (FloatingActionButton) getView().findViewById(2131689842);
        this.f6572j = (RelativeLayout) getView().findViewById(2131689843);
        this.f6572j.setClickable(false);
        ProgressWheel progressWheel = (ProgressWheel) getView().findViewById(2131689739);
        ((TextView) getView().findViewById(2131689738)).setText(getString(2131230882));
        progressWheel.setVisibility(0);
        this.f6569g.setText(C1111c.m6395a(getActivity(), System.currentTimeMillis()));
        this.f6573k = new C2023f(getActivity(), this, g, g, h, i, z);
        this.f6568f.setHasFixedSize(true);
        this.f6568f.setAdapter(this.f6573k);
        this.f6568f.addOnItemTouchListener(new C1791j(getActivity(), this.f6568f, this));
        this.f6571i = new LinearLayoutManager(getActivity());
        this.f6571i.setReverseLayout(true);
        this.f6568f.setLayoutManager(this.f6571i);
        this.f6568f.addOnScrollListener(new C2020b(this));
        this.f6570h.setOnClickListener(new C2021c(this));
        if (getActivity() instanceof ChannelConversationActivity) {
            getActivity().getLoaderManager().initLoader(9, null, this);
            return;
        }
        this.f6572j.setVisibility(8);
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f6565e, this.f6584v);
        getActivity().getLoaderManager().initLoader(9, bundle2, this);
    }
}
