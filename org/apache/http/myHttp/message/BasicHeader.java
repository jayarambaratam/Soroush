package org.apache.http.myHttp.message;

import java.io.Serializable;
import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.HeaderElement;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.util.Args;

@Immutable
public class BasicHeader implements Serializable, Cloneable, Header {
    private static final long serialVersionUID = -5427236326487562174L;
    private final String name;
    private final String value;

    public BasicHeader(String str, String str2) {
        this.name = (String) Args.notNull(str, "Name");
        this.value = str2;
    }

    public Object clone() {
        return super.clone();
    }

    public HeaderElement[] getElements() {
        return this.value != null ? BasicHeaderValueParser.parseElements(this.value, null) : new HeaderElement[0];
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return BasicLineFormatter.INSTANCE.formatHeader(null, (Header) this).toString();
    }
}
