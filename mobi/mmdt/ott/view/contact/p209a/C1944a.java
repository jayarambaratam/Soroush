package mobi.mmdt.ott.view.contact.p209a;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.provider.p171e.C1611e;
import mobi.mmdt.ott.view.components.p181b.C1720l;
import mobi.mmdt.ott.view.components.p181b.C1791j;
import mobi.mmdt.ott.view.contact.p209a.p210a.C1942a;
import mobi.mmdt.ott.view.contact.p209a.p212c.C1952a;
import mobi.mmdt.ott.view.contact.p209a.p212c.C1953b;
import mobi.mmdt.ott.view.contact.p209a.p212c.C1954c;
import mobi.mmdt.ott.view.contact.p209a.p212c.C1955d;
import mobi.mmdt.ott.view.p178a.ah;
import net.frakbot.glowpadbackport.BuildConfig;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.view.contact.a.a */
public class C1944a extends Fragment implements C1720l, C1943i {
    private RecyclerView f6234a;
    private C1957d f6235b;
    private C1959f f6236c;
    private int f6237d;
    private int f6238e;
    private C1954c f6239f;
    private int f6240g;
    private boolean f6241h;
    private C1611e[] f6242i;
    private LinearLayoutManager f6243j;

    public C1944a() {
        this.f6237d = 0;
        this.f6238e = 0;
        this.f6240g = 0;
    }

    private C1952a m9227a(C1611e c1611e, boolean z) {
        int j = (int) c1611e.m8208j();
        String c = c1611e.m8201c();
        String a = ah.m8469a(c1611e.m8205g(), c1611e.m8204f());
        String e = c1611e.m8203e();
        String a2 = c1611e.m8199a();
        Uri b = c1611e.m8200b();
        int b2 = C1111c.m6402b(getActivity(), c);
        return z ? new C1953b(-1, j, c, a, e, a2, b, b2, false) : new C1955d(-1, j, c, a, e, a2, b, b2, false);
    }

    private void m9232a(List<C1952a> list, List<String> list2) {
        List arrayList = new ArrayList();
        for (String str : list2) {
            for (C1952a c1952a : list) {
                if (c1952a instanceof C1953b) {
                    C1953b c1953b = (C1953b) c1952a;
                    if (c1953b.m9266j().equals(str)) {
                        arrayList.add(c1953b);
                        list.remove(c1953b);
                        if (!m9240a().containsKey(str)) {
                            m9240a().put(str, Boolean.valueOf(true));
                            this.f6237d++;
                        }
                        this.f6239f.m9269a(this.f6237d);
                    }
                }
            }
        }
        Collections.sort(arrayList);
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            list.add(0, arrayList.get(size));
        }
    }

    public LinkedHashMap<String, Boolean> m9240a() {
        return MyApplication.m6445a().f4171b;
    }

    public void m9241a(int i) {
        boolean z;
        int b = this.f6235b.m9280b(i);
        C1953b c1953b = (C1953b) this.f6235b.m8655a(b);
        if (m9240a().size() < this.f6238e) {
            m9240a().put(c1953b.m9266j(), Boolean.valueOf(true));
            z = true;
        } else {
            z = false;
        }
        int i2 = b;
        int i3 = b;
        while (i2 >= 0) {
            int i4;
            if (this.f6235b.m8655a(i2) instanceof C1954c) {
                i4 = i3 - 1;
            } else {
                if (this.f6235b.m8655a(i2) instanceof C1953b) {
                    C1953b c1953b2 = (C1953b) this.f6235b.m8655a(i2);
                    if (!m9240a().containsKey(c1953b2.m9266j())) {
                        i4 = i3 - 1;
                    } else if (c1953b.m9263e().compareTo(c1953b2.m9263e()) < 0) {
                        i4 = i3 - 1;
                    }
                }
                i4 = i3;
            }
            i2--;
            i3 = i4;
        }
        this.f6235b.m9278a(b, i3);
        if (z) {
            this.f6237d++;
        }
        C0002c.m2a().m17c(new C1942a(this.f6237d, this.f6238e));
        if (!z) {
            new Handler().postDelayed(new C1951b(this, i), 500);
            new Handler().postDelayed(new C1956c(this), 1000);
            Toast.makeText(getActivity(), "Can not select more than " + this.f6238e + " contacts!", 0).show();
        }
    }

    public void m9242a(View view, int i) {
        if (!this.f6241h && i > -1) {
            this.f6236c.m9283a(((C1955d) this.f6235b.m8655a(i)).m9276f());
        }
    }

    public void m9243a(String str) {
        new C1958e(this).execute(new Object[]{str});
    }

    public ArrayList<String> m9244b() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(m9240a().keySet());
        return arrayList;
    }

    public void m9245b(int i) {
        Object obj;
        int b = this.f6235b.m9280b(i);
        C1953b c1953b = (C1953b) this.f6235b.m8655a(b);
        if (m9240a().containsKey(c1953b.m9266j())) {
            m9240a().remove(c1953b.m9266j());
            obj = 1;
        } else {
            obj = null;
        }
        int i2 = b;
        for (int i3 = b; i3 < this.f6235b.getItemCount(); i3++) {
            if (this.f6235b.m8655a(i3) instanceof C1954c) {
                i2++;
            } else if (this.f6235b.m8655a(i3) instanceof C1953b) {
                C1953b c1953b2 = (C1953b) this.f6235b.m8655a(i3);
                if (m9240a().containsKey(c1953b2.m9266j())) {
                    i2++;
                } else if (c1953b.m9263e().compareTo(c1953b2.m9263e()) > 0) {
                    i2++;
                }
            }
        }
        this.f6235b.m9278a(b, i2);
        if (obj != null) {
            this.f6237d--;
        }
        C0002c.m2a().m17c(new C1942a(this.f6237d, this.f6238e));
    }

    public void m9246b(View view, int i) {
    }

    public int m9247c() {
        return this.f6243j.findFirstVisibleItemPosition();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f6236c = (C1959f) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCheckableContactsListFragmentInteractionListener");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = BuildConfig.FLAVOR;
        if (getArguments() != null) {
            if (getArguments().containsKey("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION")) {
                this.f6240g = getArguments().getInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION");
            }
            if (getArguments().containsKey("KEY_MULTIPLE_CONTACT_SELECTION")) {
                this.f6241h = getArguments().getBoolean("KEY_MULTIPLE_CONTACT_SELECTION");
            }
            if (getArguments().containsKey("KEY_MAXIMUM_CONTACT_SELECTION")) {
                this.f6238e = getArguments().getInt("KEY_MAXIMUM_CONTACT_SELECTION");
            }
            if (getArguments().containsKey("KEY_SEARCH_FILTER")) {
                str = getArguments().getString("KEY_SEARCH_FILTER");
            }
        }
        this.f6235b = new C1957d(this, getActivity());
        this.f6237d = m9240a().size();
        new C1958e(this).execute(new Object[]{str});
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968713, viewGroup, false);
    }

    public void onDestroyView() {
        if (this.f6234a != null) {
            this.f6234a.setItemAnimator(null);
            this.f6234a.setAdapter(null);
            this.f6234a = null;
        }
        this.f6235b = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6234a = (RecyclerView) getView().findViewById(2131689797);
        this.f6234a.setHasFixedSize(true);
        this.f6234a.setAdapter(this.f6235b);
        this.f6234a.addOnItemTouchListener(new C1791j(getActivity(), this.f6234a, this));
        this.f6243j = new LinearLayoutManager(getActivity());
        this.f6234a.setLayoutManager(this.f6243j);
        this.f6234a.scrollToPosition(this.f6240g);
    }
}
