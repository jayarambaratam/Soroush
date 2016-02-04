package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.p016f.C0222q;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.app.v */
public class C0150v {
    private final C0147w<?> f1012a;

    private C0150v(C0147w<?> c0147w) {
        this.f1012a = c0147w;
    }

    public static final C0150v m1346a(C0147w<?> c0147w) {
        return new C0150v(c0147w);
    }

    public C0151x m1347a() {
        return this.f1012a.m1330i();
    }

    public View m1348a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1012a.f1001d.m1405a(view, str, context, attributeSet);
    }

    public List<Fragment> m1349a(List<Fragment> list) {
        if (this.f1012a.f1001d.f1023f == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList(m1362c());
        }
        list.addAll(this.f1012a.f1001d.f1023f);
        return list;
    }

    public void m1350a(Configuration configuration) {
        this.f1012a.f1001d.m1410a(configuration);
    }

    public void m1351a(Parcelable parcelable, List<Fragment> list) {
        this.f1012a.f1001d.m1412a(parcelable, (List) list);
    }

    public void m1352a(Fragment fragment) {
        this.f1012a.f1001d.m1416a(this.f1012a, this.f1012a, fragment);
    }

    public void m1353a(C0222q<String, av> c0222q) {
        this.f1012a.m1315a((C0222q) c0222q);
    }

    public void m1354a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f1012a.m1323b(str, fileDescriptor, printWriter, strArr);
    }

    public void m1355a(boolean z) {
        this.f1012a.m1318a(z);
    }

    public boolean m1356a(Menu menu) {
        return this.f1012a.f1001d.m1420a(menu);
    }

    public boolean m1357a(Menu menu, MenuInflater menuInflater) {
        return this.f1012a.f1001d.m1421a(menu, menuInflater);
    }

    public boolean m1358a(MenuItem menuItem) {
        return this.f1012a.f1001d.m1422a(menuItem);
    }

    public av m1359b() {
        return this.f1012a.m1331j();
    }

    public void m1360b(Menu menu) {
        this.f1012a.f1001d.m1427b(menu);
    }

    public boolean m1361b(MenuItem menuItem) {
        return this.f1012a.f1001d.m1429b(menuItem);
    }

    public int m1362c() {
        List list = this.f1012a.f1001d.f1023f;
        return list == null ? 0 : list.size();
    }

    public void m1363d() {
        this.f1012a.f1001d.m1444i();
    }

    public Parcelable m1364e() {
        return this.f1012a.f1001d.m1443h();
    }

    public List<Fragment> m1365f() {
        return this.f1012a.f1001d.m1442g();
    }

    public void m1366g() {
        this.f1012a.f1001d.m1445j();
    }

    public void m1367h() {
        this.f1012a.f1001d.m1446k();
    }

    public void m1368i() {
        this.f1012a.f1001d.m1447l();
    }

    public void m1369j() {
        this.f1012a.f1001d.m1448m();
    }

    public void m1370k() {
        this.f1012a.f1001d.m1449n();
    }

    public void m1371l() {
        this.f1012a.f1001d.m1450o();
    }

    public void m1372m() {
        this.f1012a.f1001d.m1451p();
    }

    public void m1373n() {
        this.f1012a.f1001d.m1453r();
    }

    public void m1374o() {
        this.f1012a.f1001d.m1454s();
    }

    public boolean m1375p() {
        return this.f1012a.f1001d.m1438e();
    }

    public void m1376q() {
        this.f1012a.m1333l();
    }

    public void m1377r() {
        this.f1012a.m1334m();
    }

    public void m1378s() {
        this.f1012a.m1335n();
    }

    public C0222q<String, av> m1379t() {
        return this.f1012a.m1336o();
    }
}
