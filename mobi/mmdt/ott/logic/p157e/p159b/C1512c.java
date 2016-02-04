package mobi.mmdt.ott.logic.p157e.p159b;

import java.util.concurrent.ConcurrentHashMap;
import mobi.mmdt.ott.MyApplication;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.e.b.c */
public class C1512c {
    public static synchronized int m7629a() {
        int i;
        synchronized (C1512c.class) {
            ConcurrentHashMap concurrentHashMap = MyApplication.m6445a().f4175f;
            i = 0;
            if (concurrentHashMap.containsKey("NewMessageSingleOrGroup")) {
                i = ((Integer) concurrentHashMap.get("NewMessageSingleOrGroup")).intValue();
            }
        }
        return i;
    }

    public static synchronized void m7630a(int i) {
        synchronized (C1512c.class) {
            ConcurrentHashMap concurrentHashMap = MyApplication.m6445a().f4175f;
            if (concurrentHashMap.containsKey("NewMessageSingleOrGroup")) {
                concurrentHashMap.remove("NewMessageSingleOrGroup");
            }
            concurrentHashMap.put("NewMessageSingleOrGroup", Integer.valueOf(i));
            C0002c.m2a().m17c(new C1511b(i));
        }
    }

    public static synchronized void m7631a(String str) {
        synchronized (C1512c.class) {
            ConcurrentHashMap concurrentHashMap = MyApplication.m6445a().f4175f;
            if (concurrentHashMap.containsKey(str)) {
                concurrentHashMap.put(str, Integer.valueOf(((Integer) concurrentHashMap.remove(str)).intValue() + 1));
            } else {
                concurrentHashMap.put(str, Integer.valueOf(1));
            }
        }
    }

    public static synchronized int m7632b() {
        int i;
        synchronized (C1512c.class) {
            ConcurrentHashMap concurrentHashMap = MyApplication.m6445a().f4175f;
            i = 0;
            if (concurrentHashMap.containsKey("NewMessageChannel")) {
                i = ((Integer) concurrentHashMap.get("NewMessageChannel")).intValue();
            }
        }
        return i;
    }

    public static synchronized int m7633b(String str) {
        int i;
        synchronized (C1512c.class) {
            ConcurrentHashMap concurrentHashMap = MyApplication.m6445a().f4175f;
            i = 0;
            if (concurrentHashMap.containsKey(str)) {
                i = ((Integer) concurrentHashMap.get(str)).intValue();
            }
        }
        return i;
    }

    public static synchronized void m7634b(int i) {
        synchronized (C1512c.class) {
            ConcurrentHashMap concurrentHashMap = MyApplication.m6445a().f4175f;
            if (concurrentHashMap.containsKey("NewMessageChannel")) {
                concurrentHashMap.remove("NewMessageChannel");
            }
            concurrentHashMap.put("NewMessageChannel", Integer.valueOf(i));
            C0002c.m2a().m17c(new C1510a(i));
        }
    }

    public static synchronized void m7635c(String str) {
        synchronized (C1512c.class) {
            ConcurrentHashMap concurrentHashMap = MyApplication.m6445a().f4175f;
            if (concurrentHashMap.containsKey(str)) {
                concurrentHashMap.remove(str);
            }
        }
    }
}
