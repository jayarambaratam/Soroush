package p000a.p001a.p002a;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: a.a.a.g */
public class C0006g {
    private static final ExecutorService f32i;
    boolean f33a;
    boolean f34b;
    boolean f35c;
    boolean f36d;
    boolean f37e;
    boolean f38f;
    ExecutorService f39g;
    List<Class<?>> f40h;

    static {
        f32i = Executors.newCachedThreadPool();
    }

    C0006g() {
        this.f33a = true;
        this.f34b = true;
        this.f35c = true;
        this.f36d = true;
        this.f38f = true;
        this.f39g = f32i;
    }
}
