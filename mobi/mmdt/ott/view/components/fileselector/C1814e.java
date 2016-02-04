package mobi.mmdt.ott.view.components.fileselector;

import android.os.AsyncTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mobi.mmdt.componentsutils.C1114a;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.view.components.fileselector.p199b.C1807a;
import mobi.mmdt.ott.view.components.fileselector.p199b.C1808b;
import mobi.mmdt.ott.view.components.fileselector.p199b.C1809c;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.components.fileselector.e */
public class C1814e extends AsyncTask<Object, List, List> {
    final /* synthetic */ C1811b f5836a;

    public C1814e(C1811b c1811b) {
        this.f5836a = c1811b;
    }

    private List m8819a(String str) {
        File file = new File(str);
        File[] listFiles = this.f5836a.f5828g != null ? file.listFiles(this.f5836a.f5828g) : file.listFiles();
        List arrayList = new ArrayList();
        for (File file2 : listFiles) {
            String str2;
            if (file2.isDirectory()) {
                if (file2.isHidden()) {
                    continue;
                } else {
                    String str3;
                    int i = 0;
                    int i2 = 0;
                    for (File file3 : file2.listFiles()) {
                        if (!file3.isHidden()) {
                            if (file3.isDirectory()) {
                                i++;
                            } else if (this.f5836a.f5828g.accept(file3)) {
                                i2++;
                            }
                        }
                    }
                    str2 = BuildConfig.FLAVOR;
                    if (i + i2 > 0) {
                        if (i > 0) {
                            str2 = i == 1 ? str2 + i + " Folder" : str2 + i + " Folders";
                        }
                        str3 = (i <= 0 || i2 <= 0) ? str2 : str2 + ", ";
                        if (i2 > 0) {
                            str3 = i2 == 1 ? str3 + i2 + " File" : str3 + i2 + " Files";
                        }
                    } else {
                        str3 = "Empty";
                    }
                    arrayList.add(new C1809c(file2.getName(), file2.getAbsolutePath(), str3, 1));
                }
            } else if (file2.isHidden()) {
                continue;
            } else {
                str2 = file2.getAbsolutePath();
                int i3 = 2130838511;
                if (C1114a.m6423a(str2)) {
                    i3 = 2130838513;
                } else {
                    try {
                        if (C1114a.m6424b(str2)) {
                            i3 = 2130838514;
                        } else if (C1114a.m6425c(str2)) {
                            i3 = 2130838515;
                        } else if (C1114a.m6426d(str2)) {
                            i3 = 2130838516;
                        } else if (C1114a.m6427e(str2)) {
                            i3 = 2130838510;
                        }
                    } catch (Throwable e) {
                        C1104b.m6368b((Object) this, e);
                    }
                }
                arrayList.add(new C1808b(file2.getName(), str2, C1111c.m6403b((int) file2.length()), i3, this.f5836a.m8810e().containsKey(str2), 1));
            }
        }
        Collections.sort(arrayList);
        List arrayList2 = new ArrayList();
        int i4 = 0;
        for (Object next : arrayList) {
            ((C1807a) next).m8787a(i4);
            arrayList2.add(next);
            i4++;
        }
        return arrayList2;
    }

    protected List m8820a(Object... objArr) {
        return m8819a((String) objArr[0]);
    }

    protected void m8821a(List list) {
        super.onPostExecute(list);
        if (this.f5836a.getView() != null) {
            if (this.f5836a.f5825d == null) {
                this.f5836a.getView().findViewById(2131689855).setVisibility(8);
                this.f5836a.f5825d = new C1815f(this.f5836a, this.f5836a.getActivity());
            }
            this.f5836a.f5825d.m8656a(list);
            if (list.size() == 0) {
                this.f5836a.getView().findViewById(2131689855).setVisibility(0);
            }
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m8820a(objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m8821a((List) obj);
    }
}
