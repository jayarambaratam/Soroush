package android.support.v4.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.s */
class C0148s extends C0147w<C0145q> {
    final /* synthetic */ C0145q f1008a;

    public C0148s(C0145q c0145q) {
        this.f1008a = c0145q;
        super(c0145q);
    }

    public View m1337a(int i) {
        return this.f1008a.findViewById(i);
    }

    public void m1338a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f1008a.dump(str, fileDescriptor, printWriter, strArr);
    }

    public boolean m1339a() {
        Window window = this.f1008a.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    public boolean m1340a(Fragment fragment) {
        return !this.f1008a.isFinishing();
    }

    public LayoutInflater m1341b() {
        return this.f1008a.getLayoutInflater().cloneInContext(this.f1008a);
    }

    public void m1342b(Fragment fragment) {
        this.f1008a.m1305a(fragment);
    }

    public void m1343c() {
        this.f1008a.m1309d();
    }

    public boolean m1344d() {
        return this.f1008a.getWindow() != null;
    }

    public int m1345e() {
        Window window = this.f1008a.getWindow();
        return window == null ? 0 : window.getAttributes().windowAnimations;
    }
}
