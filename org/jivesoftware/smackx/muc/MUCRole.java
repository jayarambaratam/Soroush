package org.jivesoftware.smackx.muc;

import java.util.Locale;

public enum MUCRole {
    moderator,
    none,
    participant,
    visitor;

    public static MUCRole fromString(String str) {
        return str == null ? null : valueOf(str.toLowerCase(Locale.US));
    }
}
