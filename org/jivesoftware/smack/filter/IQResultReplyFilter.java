package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;

public class IQResultReplyFilter extends IQReplyFilter {
    public IQResultReplyFilter(IQ iq, XMPPConnection xMPPConnection) {
        super(iq, xMPPConnection);
    }

    public boolean accept(Stanza stanza) {
        return !super.accept(stanza) ? false : IQTypeFilter.RESULT.accept(stanza);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" (" + super.toString() + ')');
        return stringBuilder.toString();
    }
}
