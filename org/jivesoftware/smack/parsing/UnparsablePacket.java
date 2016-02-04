package org.jivesoftware.smack.parsing;

public class UnparsablePacket {
    private final CharSequence content;
    private final Exception f8405e;

    public UnparsablePacket(CharSequence charSequence, Exception exception) {
        this.content = charSequence;
        this.f8405e = exception;
    }

    public CharSequence getContent() {
        return this.content;
    }

    public Exception getParsingException() {
        return this.f8405e;
    }
}
