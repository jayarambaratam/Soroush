package mobi.mmdt.ott.view.stickermarket;

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
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1455a;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1456b;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1461g;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1462h;
import mobi.mmdt.ott.logic.p112a.p149i.p151b.C1466d;
import mobi.mmdt.ott.logic.p112a.p149i.p151b.C1467e;
import mobi.mmdt.ott.logic.p112a.p149i.p151b.C1472j;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bb;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bc;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.stickermarket.p250b.C2575a;
import mobi.mmdt.ott.view.stickermarket.p250b.C2576b;
import mobi.mmdt.ott.view.stickermarket.p250b.C2577c;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.view.stickermarket.r */
public class C2594r extends Fragment implements C1790i {
    private RecyclerView f8302a;
    private ProgressWheel f8303b;
    private C2609y f8304c;
    private LinearLayoutManager f8305d;
    private C2569x f8306e;
    private C2610z f8307f;
    private String f8308g;
    private boolean f8309h;
    private C0950c f8310i;

    public C2594r() {
        this.f8307f = C2610z.LIST_TYPE_NEW;
    }

    public static C2594r m11029a(C2610z c2610z, String str) {
        C2594r c2594r = new C2594r();
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_LIST_TYPE", c2610z.ordinal());
        bundle.putString("KEY_EXTRA_STRING", str);
        c2594r.setArguments(bundle);
        return c2594r;
    }

    private void m11032b() {
        C0950c c1472j = new C1472j(getActivity(), this.f8307f);
        switch (C2608w.f8341a[this.f8307f.ordinal()]) {
            case VideoSize.CIF /*1*/:
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                c1472j = new C1472j(getActivity(), this.f8307f);
                break;
            case Version.API04_DONUT_16 /*4*/:
                c1472j = new C1467e(getActivity(), this.f8307f);
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                c1472j = new C1466d(getActivity(), this.f8307f, this.f8308g);
                break;
        }
        this.f8310i = c1472j;
        C1494c.m7539a(c1472j);
    }

    public void m11034a() {
        if (!this.f8309h) {
            this.f8303b.setVisibility(0);
            this.f8309h = true;
            m11032b();
        }
    }

    public void m11035a(View view, int i) {
        C2575a c2575a = (C2575a) this.f8304c.m8655a(i);
        switch (c2575a.m8659g()) {
            case VideoSize.CIF /*1*/:
                C2577c c2577c = (C2577c) c2575a;
                this.f8306e.m10935a(c2577c.m11017d(), c2577c.m11014a(), c2577c.m11015b(), c2577c.m11016c());
            case VideoSize.HVGA /*2*/:
                C2576b c2576b = (C2576b) c2575a;
                this.f8306e.m10936a(c2576b.m11012c(), c2576b.m11010a());
            default:
        }
    }

    public void m11036b(View view, int i) {
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m11032b();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f8306e = (C2569x) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IStickerMarketListFragmentCallback" + ".");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0002c.m2a().m14a((Object) this);
        if (getArguments() != null) {
            if (getArguments().containsKey("KEY_LIST_TYPE")) {
                this.f8307f = C2610z.values()[getArguments().getInt("KEY_LIST_TYPE")];
            }
            if (getArguments().containsKey("KEY_EXTRA_STRING")) {
                this.f8308g = getArguments().getString("KEY_EXTRA_STRING");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968750, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        C0002c.m2a().m16b(this);
    }

    public void onDestroyView() {
        if (this.f8302a != null) {
            this.f8302a.setItemAnimator(null);
            this.f8302a.setAdapter(null);
            this.f8302a = null;
        }
        this.f8304c = null;
        super.onDestroyView();
    }

    public void onEvent(C1455a c1455a) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new C2595s(this));
        }
        this.f8309h = false;
    }

    public void onEvent(C1456b c1456b) {
        if (this.f8310i instanceof C1467e) {
            bb[] a = c1456b.m7400a();
            List arrayList = new ArrayList();
            if (a != null) {
                for (int i = 0; i < a.length; i++) {
                    bb bbVar = a[i];
                    arrayList.add(new C2576b(bbVar.m6663b(), bbVar.m6664c(), bbVar.m6662a(), bbVar.m6665d(), i));
                }
            }
            if (getActivity() != null) {
                getActivity().runOnUiThread(new C2606u(this, arrayList));
            }
            this.f8309h = false;
        }
    }

    public void onEvent(C1461g c1461g) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new C2605t(this));
        }
        this.f8309h = false;
    }

    public void onEvent(C1462h c1462h) {
        if (((this.f8310i instanceof C1472j) && ((C1472j) this.f8310i).m7462j() == this.f8307f) || ((this.f8310i instanceof C1466d) && ((C1466d) this.f8310i).m7431j() == this.f8307f && ((C1466d) this.f8310i).m7432k().equals(this.f8308g))) {
            bc[] a = c1462h.m7409a();
            List arrayList = new ArrayList();
            if (a != null) {
                for (int i = 0; i < a.length; i++) {
                    bc bcVar = a[i];
                    arrayList.add(new C2577c(Integer.parseInt(bcVar.m6667b()), bcVar.m6670e(), bcVar.m6668c(), bcVar.m6666a(), bcVar.m6669d(), i));
                }
            }
            if (getActivity() != null) {
                getActivity().runOnUiThread(new C2607v(this, arrayList));
            }
            this.f8309h = false;
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay().getSize(new Point());
        this.f8305d = new LinearLayoutManager(getActivity());
        this.f8302a = (RecyclerView) getView().findViewById(2131689797);
        this.f8303b = (ProgressWheel) getView().findViewById(C1119f.progress_wheel);
        this.f8304c = new C2609y(this, getActivity());
        this.f8303b.setVisibility(0);
        this.f8302a.setHasFixedSize(true);
        this.f8302a.setAdapter(this.f8304c);
        this.f8302a.setLayoutManager(this.f8305d);
    }
}
