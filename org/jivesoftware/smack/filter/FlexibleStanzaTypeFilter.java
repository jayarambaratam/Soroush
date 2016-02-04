package org.jivesoftware.smack.filter;

import java.lang.reflect.ParameterizedType;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.Objects;

public abstract class FlexibleStanzaTypeFilter<S extends Stanza> implements StanzaFilter {
    protected final Class<S> stanzaType;

    public FlexibleStanzaTypeFilter() {
        this.stanzaType = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public FlexibleStanzaTypeFilter(Class<S> cls) {
        this.stanzaType = (Class) Objects.requireNonNull(cls, "Type must not be null");
    }

    public final boolean accept(Stanza stanza) {
        return this.stanzaType.isInstance(stanza) ? acceptSpecific(stanza) : false;
    }

    protected abstract boolean acceptSpecific(S s);

    public String toString() {
        return getClass().getSimpleName() + ": " + this.stanzaType.toString();
    }
}
