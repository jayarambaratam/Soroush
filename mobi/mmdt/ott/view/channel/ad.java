package mobi.mmdt.ott.view.channel;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.p065c.p066a.p067a.C0950c;
import com.pnikosis.materialishprogress.ProgressWheel;
import java.util.ArrayList;
import java.util.List;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1336b;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1337c;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1351c;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1352d;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1204g;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1216t;
import mobi.mmdt.ott.view.channel.p183b.C1723a;
import mobi.mmdt.ott.view.channel.p183b.C1724b;
import mobi.mmdt.ott.view.channel.p183b.C1725c;
import mobi.mmdt.ott.view.components.p181b.C1720l;
import mobi.mmdt.ott.view.components.p181b.C1791j;
import org.linphone.core.VideoSize;
import p000a.p001a.p002a.C0002c;

public class ad extends Fragment implements aj, C1720l {
    private RecyclerView f5673a;
    private ProgressWheel f5674b;
    private ah f5675c;
    private LinearLayoutManager f5676d;
    private ai f5677e;
    private String f5678f;
    private boolean f5679g;
    private C0950c f5680h;

    public static ad m8640a(String str) {
        ad adVar = new ad();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_CATEGORY_ID", str);
        adVar.setArguments(bundle);
        return adVar;
    }

    private void m8641a(List list) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new af(this, list));
        }
        this.f5679g = false;
    }

    private void m8642a(C1351c c1351c) {
        List arrayList = new ArrayList();
        if (c1351c != null) {
            int i;
            C1216t[] b = c1351c.m7042b();
            C1204g[] a = c1351c.m7041a();
            int i2 = 0;
            int i3 = 0;
            while (i2 < b.length) {
                C1216t c1216t = b[i2];
                i = i3 + 1;
                arrayList.add(new C1724b(c1216t.m6716c(), c1216t.m6717d(), c1216t.m6715b(), c1216t.m6714a(), i3));
                i2++;
                i3 = i;
            }
            i = 0;
            int i4 = i3;
            while (i < a.length) {
                C1204g c1204g = a[i];
                int i5 = i4 + 1;
                arrayList.add(new C1725c(c1204g.m6638c(), c1204g.m6639d(), c1204g.m6642g(), c1204g.m6643h(), c1204g.m6644i(), c1204g.m6700a(), i4));
                i++;
                i4 = i5;
            }
        }
        m8646c().clear();
        m8646c().addAll(arrayList);
        m8641a(arrayList);
    }

    private void m8644b() {
        C0950c c1352d = new C1352d(getActivity(), this.f5678f);
        this.f5680h = c1352d;
        C1494c.m7540b(c1352d);
    }

    private ArrayList<C1723a> m8646c() {
        return MyApplication.m6445a().f4176g;
    }

    public void m8648a() {
        if (!this.f5679g) {
            this.f5674b.setVisibility(0);
            this.f5679g = true;
            m8644b();
        }
    }

    public void m8649a(View view, int i) {
        C1723a c1723a = (C1723a) this.f5675c.m8655a(i);
        switch (c1723a.m8659g()) {
            case VideoSize.HVGA /*2*/:
                this.f5677e.m8604a(this.f5678f, ((C1724b) c1723a).m8662b());
            default:
        }
    }

    public void m8650a(String str, boolean z) {
        if (getActivity() != null && getView() != null) {
            getActivity().runOnUiThread(new ae(this, str, z));
        }
    }

    public void m8651b(View view, int i) {
    }

    public void m8652b(String str) {
        this.f5677e.m8603a(str);
    }

    public void m8653b(String str, boolean z) {
        this.f5677e.m8605a(str, z);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (m8646c() == null || m8646c().size() <= 0) {
            m8644b();
        } else {
            m8641a(m8646c());
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f5677e = (ai) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IExploreChannelsListFragmentCallback" + ".");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0002c.m2a().m14a((Object) this);
        if (getArguments() != null && getArguments().containsKey("KEY_CATEGORY_ID")) {
            this.f5678f = getArguments().getString("KEY_CATEGORY_ID");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968725, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        C0002c.m2a().m16b(this);
    }

    public void onDestroyView() {
        if (this.f5673a != null) {
            this.f5673a.setItemAnimator(null);
            this.f5673a.setAdapter(null);
            this.f5673a = null;
        }
        this.f5675c = null;
        super.onDestroyView();
    }

    public void onEvent(C1336b c1336b) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new ag(this));
        }
        this.f5679g = false;
    }

    public void onEvent(C1337c c1337c) {
        m8642a(c1337c.m7027a());
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay().getSize(new Point());
        this.f5676d = new LinearLayoutManager(getActivity());
        this.f5673a = (RecyclerView) getView().findViewById(2131689797);
        this.f5674b = (ProgressWheel) getView().findViewById(C1119f.progress_wheel);
        this.f5675c = new ah(this, getActivity());
        this.f5674b.setVisibility(0);
        this.f5673a.addOnItemTouchListener(new C1791j(getActivity(), this.f5673a, this));
        this.f5673a.setHasFixedSize(true);
        this.f5673a.setAdapter(this.f5675c);
        this.f5673a.setLayoutManager(this.f5676d);
    }
}
