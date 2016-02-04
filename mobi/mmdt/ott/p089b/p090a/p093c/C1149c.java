package mobi.mmdt.ott.p089b.p090a.p093c;

import org.jivesoftware.smack.packet.Presence.Type;
import org.jivesoftware.smack.roster.packet.RosterPacket.ItemType;

/* renamed from: mobi.mmdt.ott.b.a.c.c */
/* synthetic */ class C1149c {
    static final /* synthetic */ int[] f4222a;
    static final /* synthetic */ int[] f4223b;

    static {
        f4223b = new int[ItemType.values().length];
        try {
            f4223b[ItemType.both.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4223b[ItemType.from.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f4223b[ItemType.to.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f4223b[ItemType.none.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        f4222a = new int[Type.values().length];
        try {
            f4222a[Type.available.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
    }
}
