package com.p032a.p033a.p037d.p039b;

import android.os.MessageQueue.IdleHandler;
import com.p032a.p033a.p037d.C0667c;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.a.a.d.b.j */
class C0659j implements IdleHandler {
    private final Map<C0667c, WeakReference<C0671s<?>>> f2648a;
    private final ReferenceQueue<C0671s<?>> f2649b;

    public C0659j(Map<C0667c, WeakReference<C0671s<?>>> map, ReferenceQueue<C0671s<?>> referenceQueue) {
        this.f2648a = map;
        this.f2649b = referenceQueue;
    }

    public boolean queueIdle() {
        C0660k c0660k = (C0660k) this.f2649b.poll();
        if (c0660k != null) {
            this.f2648a.remove(c0660k.f2650a);
        }
        return true;
    }
}
