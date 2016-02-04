package p000a.p003b.p004a;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import java.util.HashMap;
import org.apache.http.myHttp.HttpStatus;
import org.linphone.core.Privacy;

/* renamed from: a.b.a.j */
public enum C0036j {
    A(1),
    NS(2),
    MD(3),
    MF(4),
    CNAME(5),
    SOA(6),
    MB(7),
    MG(8),
    MR(9),
    NULL(10),
    WKS(11),
    PTR(12),
    HINFO(13),
    MINFO(14),
    MX(15),
    TXT(16),
    RP(17),
    AFSDB(18),
    X25(19),
    ISDN(20),
    RT(21),
    NSAP(22),
    NSAP_PTR(23),
    SIG(24),
    KEY(25),
    PX(26),
    GPOS(27),
    AAAA(28),
    LOC(29),
    NXT(30),
    EID(31),
    NIMLOC(32),
    SRV(33),
    ATMA(34),
    NAPTR(35),
    KX(36),
    CERT(37),
    A6(38),
    DNAME(39),
    SINK(40),
    OPT(41),
    APL(42),
    DS(43),
    SSHFP(44),
    IPSECKEY(45),
    RRSIG(46),
    NSEC(47),
    DNSKEY(48),
    DHCID(49),
    NSEC3(50),
    NSEC3PARAM(51),
    HIP(55),
    NINFO(56),
    RKEY(57),
    TALINK(58),
    SPF(99),
    UINFO(100),
    UID(HttpStatus.SC_SWITCHING_PROTOCOLS),
    GID(HttpStatus.SC_PROCESSING),
    TKEY(249),
    TSIG(Callback.DEFAULT_SWIPE_ANIMATION_DURATION),
    IXFR(251),
    AXFR(252),
    MAILB(253),
    MAILA(254),
    ANY(255),
    TA(Privacy.DEFAULT),
    DLV(32769);
    
    private static final HashMap<Integer, C0036j> ar;
    private final int aq;

    static {
        ar = new HashMap();
        C0036j[] values = C0036j.values();
        int length = values.length;
        int i;
        while (i < length) {
            C0036j c0036j = values[i];
            ar.put(Integer.valueOf(c0036j.m74a()), c0036j);
            i++;
        }
    }

    private C0036j(int i) {
        this.aq = i;
    }

    public static C0036j m73a(int i) {
        return (C0036j) ar.get(Integer.valueOf(i));
    }

    public int m74a() {
        return this.aq;
    }
}
