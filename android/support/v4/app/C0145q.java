package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.p016f.C0222q;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: android.support.v4.app.q */
public class C0145q extends C0140m {
    final Handler f989a;
    final C0150v f990b;
    boolean f991c;
    boolean f992d;
    boolean f993e;
    boolean f994f;
    boolean f995g;
    boolean f996h;

    public C0145q() {
        this.f989a = new C0146r(this);
        this.f990b = C0150v.m1346a(new C0148s(this));
    }

    private static String m1302a(View view) {
        char c = 'F';
        char c2 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case VideoSize.QCIF /*0*/:
                stringBuilder.append('V');
                break;
            case Version.API04_DONUT_16 /*4*/:
                stringBuilder.append('I');
                break;
            case Version.API08_FROYO_22 /*8*/:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        stringBuilder.append(view.isFocusable() ? 'F' : '.');
        stringBuilder.append(view.isEnabled() ? 'E' : '.');
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        stringBuilder.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        stringBuilder.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        stringBuilder.append(view.isClickable() ? 'C' : '.');
        stringBuilder.append(view.isLongClickable() ? 'L' : '.');
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.isSelected() ? 'S' : '.');
        if (view.isPressed()) {
            c2 = 'P';
        }
        stringBuilder.append(c2);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m1303a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(C0145q.m1302a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m1303a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    final View m1304a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f990b.m1348a(view, str, context, attributeSet);
    }

    public void m1305a(Fragment fragment) {
    }

    void m1306a(boolean z) {
        if (!this.f994f) {
            this.f994f = true;
            this.f995g = z;
            this.f989a.removeMessages(1);
            m1310e();
        }
    }

    protected boolean m1307a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public void a_() {
        C0126a.m1022b(this);
    }

    protected void b_() {
        this.f990b.m1369j();
    }

    public Object m1308c() {
        return null;
    }

    public void m1309d() {
        if (VERSION.SDK_INT >= 11) {
            C0130c.m1202a(this);
        } else {
            this.f996h = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f991c);
            printWriter.print("mResumed=");
            printWriter.print(this.f992d);
            printWriter.print(" mStopped=");
            printWriter.print(this.f993e);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f994f);
            this.f990b.m1354a(str2, fileDescriptor, printWriter, strArr);
            this.f990b.m1347a().m1385a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m1303a(str + "  ", printWriter, getWindow().getDecorView());
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f991c);
            printWriter.print("mResumed=");
            printWriter.print(this.f992d);
            printWriter.print(" mStopped=");
            printWriter.print(this.f993e);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f994f);
            this.f990b.m1354a(str2, fileDescriptor, printWriter, strArr);
            this.f990b.m1347a().m1385a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m1303a(str + "  ", printWriter, getWindow().getDecorView());
        }
    }

    void m1310e() {
        this.f990b.m1355a(this.f995g);
        this.f990b.m1372m();
    }

    public C0151x m1311f() {
        return this.f990b.m1347a();
    }

    public av m1312g() {
        return this.f990b.m1359b();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f990b.m1363d();
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            int c = this.f990b.m1362c();
            if (c == 0 || i3 < 0 || i3 >= c) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = (Fragment) this.f990b.m1349a(new ArrayList(c)).get(i3);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                fragment.m955a(InBandBytestreamManager.MAXIMUM_BLOCK_SIZE & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f990b.m1347a().m1387c()) {
            a_();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f990b.m1350a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.f990b.m1352a(null);
        super.onCreate(bundle);
        C0149t c0149t = (C0149t) getLastNonConfigurationInstance();
        if (c0149t != null) {
            this.f990b.m1353a(c0149t.f1011c);
        }
        if (bundle != null) {
            this.f990b.m1351a(bundle.getParcelable("android:support:fragments"), c0149t != null ? c0149t.f1010b : null);
        }
        this.f990b.m1366g();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        return VERSION.SDK_INT >= 11 ? super.onCreatePanelMenu(i, menu) | this.f990b.m1357a(menu, getMenuInflater()) : true;
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        m1306a(false);
        this.f990b.m1373n();
        this.f990b.m1377r();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f990b.m1374o();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case VideoSize.QCIF /*0*/:
                return this.f990b.m1358a(menuItem);
            case Version.API06_ECLAIR_201 /*6*/:
                return this.f990b.m1361b(menuItem);
            default:
                return false;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f990b.m1363d();
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                this.f990b.m1360b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f992d = false;
        if (this.f989a.hasMessages(2)) {
            this.f989a.removeMessages(2);
            b_();
        }
        this.f990b.m1370k();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f989a.removeMessages(2);
        b_();
        this.f990b.m1375p();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f996h) {
            this.f996h = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return m1307a(view, menu) | this.f990b.m1356a(menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 8) & 255;
        if (i2 != 0) {
            i2--;
            int c = this.f990b.m1362c();
            if (c == 0 || i2 < 0 || i2 >= c) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = (Fragment) this.f990b.m1349a(new ArrayList(c)).get(i2);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            } else {
                fragment.m957a(i & 255, strArr, iArr);
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.f989a.sendEmptyMessage(2);
        this.f992d = true;
        this.f990b.m1375p();
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f993e) {
            m1306a(true);
        }
        Object c = m1308c();
        List f = this.f990b.m1365f();
        C0222q t = this.f990b.m1379t();
        if (f == null && t == null && c == null) {
            return null;
        }
        C0149t c0149t = new C0149t();
        c0149t.f1009a = c;
        c0149t.f1010b = f;
        c0149t.f1011c = t;
        return c0149t;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable e = this.f990b.m1364e();
        if (e != null) {
            bundle.putParcelable("android:support:fragments", e);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f993e = false;
        this.f994f = false;
        this.f989a.removeMessages(1);
        if (!this.f991c) {
            this.f991c = true;
            this.f990b.m1367h();
        }
        this.f990b.m1363d();
        this.f990b.m1375p();
        this.f990b.m1376q();
        this.f990b.m1368i();
        this.f990b.m1378s();
    }

    public void onStateNotSaved() {
        this.f990b.m1363d();
    }

    protected void onStop() {
        super.onStop();
        this.f993e = true;
        this.f989a.sendEmptyMessage(1);
        this.f990b.m1371l();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
}
