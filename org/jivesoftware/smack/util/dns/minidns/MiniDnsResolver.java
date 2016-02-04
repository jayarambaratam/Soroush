package org.jivesoftware.smack.util.dns.minidns;

import java.util.LinkedList;
import java.util.List;
import org.jivesoftware.smack.initializer.SmackInitializer;
import org.jivesoftware.smack.util.DNSUtil;
import org.jivesoftware.smack.util.dns.DNSResolver;
import org.jivesoftware.smack.util.dns.SRVRecord;
import org.p253a.p254a.p255a.C2635b;
import p000a.p003b.p004a.C0026a;
import p000a.p003b.p004a.C0028b;
import p000a.p003b.p004a.C0029c;
import p000a.p003b.p004a.C0032f;
import p000a.p003b.p004a.C0033g;
import p000a.p003b.p004a.C0035i;
import p000a.p003b.p004a.C0036j;
import p000a.p003b.p004a.p005a.C0024h;

public class MiniDnsResolver implements SmackInitializer, DNSResolver {
    private static final long ONE_DAY = 86400000;
    private static final C2635b<C0032f, C0029c> cache;
    private static final MiniDnsResolver instance;
    private final C0026a client;

    /* renamed from: org.jivesoftware.smack.util.dns.minidns.MiniDnsResolver.1 */
    class C26981 implements C0028b {
        C26981() {
        }

        public C0029c get(C0032f c0032f) {
            return (C0029c) MiniDnsResolver.cache.get(c0032f);
        }

        public void put(C0032f c0032f, C0029c c0029c) {
            long j = MiniDnsResolver.ONE_DAY;
            for (C0033g c0033g : c0029c.m57d()) {
                if (c0033g.m69a(c0032f)) {
                    j = c0033g.m70b();
                    break;
                }
            }
            MiniDnsResolver.cache.m11060a(c0032f, c0029c, j);
        }
    }

    static {
        instance = new MiniDnsResolver();
        cache = new C2635b(10, ONE_DAY);
    }

    public MiniDnsResolver() {
        this.client = new C0026a(new C26981());
    }

    public static DNSResolver getInstance() {
        return instance;
    }

    public static void setup() {
        DNSUtil.setDNSResolver(getInstance());
    }

    public List<Exception> initialize() {
        setup();
        return null;
    }

    public List<SRVRecord> lookupSRVRecords(String str) {
        List<SRVRecord> linkedList = new LinkedList();
        C0029c a = this.client.m43a(str, C0036j.SRV, C0035i.IN);
        if (a == null) {
            return linkedList;
        }
        for (C0033g a2 : a.m57d()) {
            C0024h c0024h = (C0024h) a2.m67a();
            linkedList.add(new SRVRecord(c0024h.m36d(), c0024h.m35c(), c0024h.m32a(), c0024h.m34b()));
        }
        return linkedList;
    }
}
