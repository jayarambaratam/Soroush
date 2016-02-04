package mobi.mmdt.ott.p089b.p090a.p093c;

import java.util.Collection;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Type;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.roster.RosterEntry;
import org.jivesoftware.smack.roster.RosterListener;
import org.jivesoftware.smack.roster.packet.RosterPacket.ItemType;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.iqlast.LastActivityManager;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.b.a.c.b */
public class C1148b implements RosterListener {
    private XMPPTCPConnection f4218a;
    private LastActivityManager f4219b;
    private Roster f4220c;
    private C1142a f4221d;

    public C1148b(C1142a c1142a) {
        this.f4221d = c1142a;
    }

    public void m6560a(String str) {
        Stanza presence = new Presence(Type.subscribe);
        presence.setTo(str);
        this.f4218a.sendStanza(presence);
    }

    public void m6561a(XMPPTCPConnection xMPPTCPConnection) {
        this.f4218a = xMPPTCPConnection;
        this.f4219b = LastActivityManager.getInstanceFor(this.f4218a);
        this.f4220c = Roster.getInstanceFor(this.f4218a);
    }

    public ItemType m6562b(String str) {
        RosterEntry entry = this.f4220c.getEntry(str);
        return entry == null ? ItemType.none : entry.getType();
    }

    public long m6563c(String str) {
        try {
            switch (C1149c.f4222a[this.f4220c.getPresence(str).getType().ordinal()]) {
                case VideoSize.CIF /*1*/:
                    return 0;
                default:
                    switch (C1149c.f4223b[m6562b(str).ordinal()]) {
                        case VideoSize.HVGA /*2*/:
                            m6560a(str);
                            break;
                        case Version.API04_DONUT_16 /*4*/:
                            m6560a(str);
                            break;
                    }
                    long[] jArr = new long[]{-1};
                    jArr[0] = this.f4219b.getLastActivity(str).lastActivity;
                    return jArr[0];
            }
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
            throw e;
        }
        C1104b.m6368b((Object) this, e);
        throw e;
    }

    public void entriesAdded(Collection<String> collection) {
    }

    public void entriesDeleted(Collection<String> collection) {
    }

    public void entriesUpdated(Collection<String> collection) {
    }

    public void presenceChanged(Presence presence) {
        this.f4221d.m6497a(presence.getFrom(), presence);
    }
}
