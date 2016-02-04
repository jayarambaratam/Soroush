package mobi.mmdt.ott.view.contact.p209a;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p171e.C1611e;
import mobi.mmdt.ott.view.contact.p209a.p212c.C1954c;
import mobi.mmdt.ott.view.p178a.ah;

/* renamed from: mobi.mmdt.ott.view.contact.a.e */
public class C1958e extends AsyncTask<Object, ArrayList, ArrayList> {
    final /* synthetic */ C1944a f6289a;

    public C1958e(C1944a c1944a) {
        this.f6289a = c1944a;
    }

    protected ArrayList m9281a(Object... objArr) {
        int i = 0;
        String str = (String) objArr[0];
        List arrayList = new ArrayList();
        for (String add : this.f6289a.m9240a().keySet()) {
            String add2;
            arrayList.add(add2);
        }
        List arrayList2 = new ArrayList();
        if (this.f6289a.f6242i == null) {
            add2 = C1309a.m6934a(this.f6289a.getActivity()).m6942b();
            List arrayList3 = new ArrayList();
            arrayList3.add(add2);
            this.f6289a.f6242i = C1607a.m8159a(this.f6289a.getActivity(), arrayList3, true);
        }
        this.f6289a.f6239f = new C1954c(-1, this.f6289a.f6238e, this.f6289a.f6237d);
        if (this.f6289a.f6241h) {
            arrayList2.add(this.f6289a.f6239f);
        }
        if (str == null || str.isEmpty()) {
            for (C1611e a : this.f6289a.f6242i) {
                arrayList2.add(this.f6289a.m9227a(a, this.f6289a.f6241h));
            }
        } else {
            C1611e[] c = this.f6289a.f6242i;
            int length = c.length;
            while (i < length) {
                C1611e c1611e = c[i];
                if (c1611e.m8209k()) {
                    add2 = ah.m8469a(c1611e.m8205g(), c1611e.m8204f());
                } else {
                    add2 = ah.m8470b(c1611e.m8202d(), c1611e.m8201c());
                }
                if (add2.toLowerCase().contains(str.toLowerCase())) {
                    arrayList2.add(this.f6289a.m9227a(c1611e, this.f6289a.f6241h));
                }
                i++;
            }
        }
        Collections.sort(arrayList2);
        if (!(!this.f6289a.f6241h || arrayList == null || arrayList.isEmpty())) {
            this.f6289a.m9232a(arrayList2, arrayList);
        }
        return arrayList2;
    }

    protected void m9282a(ArrayList arrayList) {
        super.onPostExecute(arrayList);
        if (this.f6289a.getView() != null) {
            if (this.f6289a.f6235b == null) {
                this.f6289a.f6235b = new C1957d(this.f6289a, this.f6289a.getActivity());
            }
            this.f6289a.f6235b.m8656a((List) arrayList);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9281a(objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9282a((ArrayList) obj);
    }
}
