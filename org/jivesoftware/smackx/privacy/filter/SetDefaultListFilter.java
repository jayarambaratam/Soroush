package org.jivesoftware.smackx.privacy.filter;

import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.packet.IQ.Type;
import org.jivesoftware.smackx.privacy.packet.Privacy;

public class SetDefaultListFilter extends FlexibleStanzaTypeFilter<Privacy> {
    public static final SetDefaultListFilter INSTANCE;

    static {
        INSTANCE = new SetDefaultListFilter();
    }

    private SetDefaultListFilter() {
    }

    protected boolean acceptSpecific(Privacy privacy) {
        return privacy.getType() != Type.set ? false : privacy.getDefaultName() != null || privacy.isDeclineDefaultList();
    }
}
