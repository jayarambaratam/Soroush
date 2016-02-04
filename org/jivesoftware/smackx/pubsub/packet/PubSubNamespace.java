package org.jivesoftware.smackx.pubsub.packet;

import java.util.Locale;

public enum PubSubNamespace {
    BASIC(null),
    ERROR("errors"),
    EVENT("event"),
    OWNER("owner");
    
    private String fragment;

    private PubSubNamespace(String str) {
        this.fragment = str;
    }

    public static PubSubNamespace valueOfFromXmlns(String str) {
        return str.lastIndexOf(35) != -1 ? valueOf(str.substring(str.lastIndexOf(35) + 1).toUpperCase(Locale.US)) : BASIC;
    }

    public String getFragment() {
        return this.fragment;
    }

    public String getXmlns() {
        String str = PubSub.NAMESPACE;
        return this.fragment != null ? str + '#' + this.fragment : str;
    }
}
