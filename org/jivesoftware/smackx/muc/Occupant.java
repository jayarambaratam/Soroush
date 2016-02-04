package org.jivesoftware.smackx.muc;

import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.muc.packet.MUCItem;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.p253a.p254a.C2643e;

public class Occupant {
    private final MUCAffiliation affiliation;
    private final String jid;
    private final String nick;
    private final MUCRole role;

    Occupant(Presence presence) {
        MUCItem item = ((MUCUser) presence.getExtension(DataForm.ELEMENT, MUCUser.NAMESPACE)).getItem();
        this.jid = item.getJid();
        this.affiliation = item.getAffiliation();
        this.role = item.getRole();
        this.nick = C2643e.m11085c(presence.getFrom());
    }

    Occupant(MUCItem mUCItem) {
        this.jid = mUCItem.getJid();
        this.affiliation = mUCItem.getAffiliation();
        this.role = mUCItem.getRole();
        this.nick = mUCItem.getNick();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Occupant)) {
            return false;
        }
        return this.jid.equals(((Occupant) obj).jid);
    }

    public MUCAffiliation getAffiliation() {
        return this.affiliation;
    }

    public String getJid() {
        return this.jid;
    }

    public String getNick() {
        return this.nick;
    }

    public MUCRole getRole() {
        return this.role;
    }

    public int hashCode() {
        return (this.nick != null ? this.nick.hashCode() : 0) + (((((this.affiliation.hashCode() * 17) + this.role.hashCode()) * 17) + this.jid.hashCode()) * 17);
    }
}
