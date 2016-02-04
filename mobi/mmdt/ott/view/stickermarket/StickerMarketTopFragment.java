package mobi.mmdt.ott.view.stickermarket;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1459e;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1460f;
import mobi.mmdt.ott.logic.p112a.p149i.p151b.C1468f;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1201d;
import mobi.mmdt.ott.view.components.imageslider.C1868g;
import mobi.mmdt.ott.view.components.imageslider.C1869h;
import mobi.mmdt.ott.view.components.imageslider.SliderLayout;
import mobi.mmdt.ott.view.components.imageslider.Tricks.C1818k;
import mobi.mmdt.ott.view.components.imageslider.p201b.C1840a;
import mobi.mmdt.ott.view.components.imageslider.p201b.C1843e;
import net.frakbot.glowpadbackport.BuildConfig;
import p000a.p001a.p002a.C0002c;

public class StickerMarketTopFragment extends Fragment implements C1818k, C1843e {
    private View f8249a;
    private SliderLayout f8250b;
    private HashMap<String, String> f8251c;
    private ab f8252d;

    public StickerMarketTopFragment() {
        this.f8251c = new HashMap();
    }

    private void m10992a() {
        this.f8250b = (SliderLayout) this.f8249a.findViewById(2131689887);
        this.f8250b.setPresetTransformer(C1869h.ZoomOutSlide);
        this.f8250b.setPresetIndicator(C1868g.Center_Bottom);
        this.f8250b.setDuration(3000);
        this.f8250b.m8855a((C1818k) this);
    }

    public void m10994a(int i) {
    }

    public void m10995a(int i, float f, int i2) {
    }

    public void m10996a(C1840a c1840a) {
    }

    public void m10997b(int i) {
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f8252d.m10977m();
        C1494c.m7540b(new C1468f(getActivity()));
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f8252d = (ab) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnStickerMarketTopFragmentInteractionListener");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0002c.m2a().m14a((Object) this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f8249a = layoutInflater.inflate(2130968751, viewGroup, false);
        m10992a();
        return this.f8249a;
    }

    public void onDestroy() {
        super.onDestroy();
        C0002c.m2a().m16b(this);
    }

    public void onEvent(C1459e c1459e) {
    }

    public void onEvent(C1460f c1460f) {
        if (getActivity() != null && getView() != null) {
            C1201d[] a = c1460f.m7408a();
            if (a != null) {
                for (C1201d c1201d : a) {
                    this.f8251c.put(c1201d.m6698a() + BuildConfig.FLAVOR, c1201d.m6699b());
                }
            }
            getActivity().runOnUiThread(new aa(this));
        }
    }

    public void onResume() {
        super.onResume();
        this.f8250b.m8851a();
    }

    public void onStop() {
        super.onStop();
        this.f8250b.m8859b();
    }
}
