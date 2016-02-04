package org.jivesoftware.smackx.commands;

public class AdHocCommandNote {
    private Type type;
    private String value;

    public enum Type {
        info,
        warn,
        error
    }

    public AdHocCommandNote(Type type, String str) {
        this.type = type;
        this.value = str;
    }

    public Type getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }
}
