package org.apache.http.myHttp.message;

import java.io.Serializable;
import org.apache.http.myHttp.ProtocolVersion;
import org.apache.http.myHttp.StatusLine;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.util.Args;

@Immutable
public class BasicStatusLine implements Serializable, Cloneable, StatusLine {
    private static final long serialVersionUID = -2443303766890459269L;
    private final ProtocolVersion protoVersion;
    private final String reasonPhrase;
    private final int statusCode;

    public BasicStatusLine(ProtocolVersion protocolVersion, int i, String str) {
        this.protoVersion = (ProtocolVersion) Args.notNull(protocolVersion, "Version");
        this.statusCode = Args.notNegative(i, "Status code");
        this.reasonPhrase = str;
    }

    public Object clone() {
        return super.clone();
    }

    public ProtocolVersion getProtocolVersion() {
        return this.protoVersion;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String toString() {
        return BasicLineFormatter.INSTANCE.formatStatusLine(null, (StatusLine) this).toString();
    }
}
