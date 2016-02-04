package org.apache.http.myHttp.entity;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Locale;
import org.apache.http.myHttp.Consts;
import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.HeaderElement;
import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.NameValuePair;
import org.apache.http.myHttp.ParseException;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.message.BasicHeaderValueFormatter;
import org.apache.http.myHttp.message.BasicHeaderValueParser;
import org.apache.http.myHttp.message.ParserCursor;
import org.apache.http.myHttp.protocol.HTTP;
import org.apache.http.myHttp.util.Args;
import org.apache.http.myHttp.util.CharArrayBuffer;
import org.apache.http.myHttp.util.TextUtils;

@Immutable
public final class ContentType implements Serializable {
    public static final ContentType APPLICATION_ATOM_XML;
    public static final ContentType APPLICATION_FORM_URLENCODED;
    public static final ContentType APPLICATION_JSON;
    public static final ContentType APPLICATION_OCTET_STREAM;
    public static final ContentType APPLICATION_SVG_XML;
    public static final ContentType APPLICATION_XHTML_XML;
    public static final ContentType APPLICATION_XML;
    public static final ContentType DEFAULT_BINARY;
    public static final ContentType DEFAULT_TEXT;
    public static final ContentType MULTIPART_FORM_DATA;
    public static final ContentType TEXT_HTML;
    public static final ContentType TEXT_PLAIN;
    public static final ContentType TEXT_XML;
    public static final ContentType WILDCARD;
    private static final long serialVersionUID = -7768694718232371896L;
    private final Charset charset;
    private final String mimeType;
    private final NameValuePair[] params;

    static {
        APPLICATION_ATOM_XML = create("application/atom+xml", Consts.ISO_8859_1);
        APPLICATION_FORM_URLENCODED = create("application/x-www-form-urlencoded", Consts.ISO_8859_1);
        APPLICATION_JSON = create("application/json", Consts.UTF_8);
        APPLICATION_OCTET_STREAM = create(HTTP.OCTET_STREAM_TYPE, (Charset) null);
        APPLICATION_SVG_XML = create("application/svg+xml", Consts.ISO_8859_1);
        APPLICATION_XHTML_XML = create("application/xhtml+xml", Consts.ISO_8859_1);
        APPLICATION_XML = create("application/xml", Consts.ISO_8859_1);
        MULTIPART_FORM_DATA = create("multipart/form-data", Consts.ISO_8859_1);
        TEXT_HTML = create("text/html", Consts.ISO_8859_1);
        TEXT_PLAIN = create(HTTP.PLAIN_TEXT_TYPE, Consts.ISO_8859_1);
        TEXT_XML = create("text/xml", Consts.ISO_8859_1);
        WILDCARD = create("*/*", (Charset) null);
        DEFAULT_TEXT = TEXT_PLAIN;
        DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
    }

    ContentType(String str, Charset charset) {
        this.mimeType = str;
        this.charset = charset;
        this.params = null;
    }

    ContentType(String str, NameValuePair[] nameValuePairArr) {
        this.mimeType = str;
        this.params = nameValuePairArr;
        Object parameter = getParameter("charset");
        this.charset = !TextUtils.isBlank(parameter) ? Charset.forName(parameter) : null;
    }

    public static ContentType create(String str) {
        return new ContentType(str, (Charset) null);
    }

    public static ContentType create(String str, String str2) {
        return create(str, !TextUtils.isBlank(str2) ? Charset.forName(str2) : null);
    }

    public static ContentType create(String str, Charset charset) {
        String toLowerCase = ((String) Args.notBlank(str, "MIME type")).toLowerCase(Locale.US);
        Args.check(valid(toLowerCase), "MIME type may not contain reserved characters");
        return new ContentType(toLowerCase, charset);
    }

    private static ContentType create(HeaderElement headerElement) {
        String name = headerElement.getName();
        NameValuePair[] parameters = headerElement.getParameters();
        if (parameters == null || parameters.length <= 0) {
            parameters = null;
        }
        return new ContentType(name, parameters);
    }

    public static ContentType get(HttpEntity httpEntity) {
        if (httpEntity == null) {
            return null;
        }
        Header contentType = httpEntity.getContentType();
        if (contentType == null) {
            return null;
        }
        HeaderElement[] elements = contentType.getElements();
        return elements.length > 0 ? create(elements[0]) : null;
    }

    public static ContentType getOrDefault(HttpEntity httpEntity) {
        ContentType contentType = get(httpEntity);
        return contentType != null ? contentType : DEFAULT_TEXT;
    }

    public static ContentType parse(String str) {
        Args.notNull(str, "Content type");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        HeaderElement[] parseElements = BasicHeaderValueParser.INSTANCE.parseElements(charArrayBuffer, new ParserCursor(0, str.length()));
        if (parseElements.length > 0) {
            return create(parseElements[0]);
        }
        throw new ParseException("Invalid content type: " + str);
    }

    private static boolean valid(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"' || charAt == ',' || charAt == ';') {
                return false;
            }
        }
        return true;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getParameter(String str) {
        Args.notEmpty((CharSequence) str, "Parameter name");
        if (this.params == null) {
            return null;
        }
        for (NameValuePair nameValuePair : this.params) {
            if (nameValuePair.getName().equalsIgnoreCase(str)) {
                return nameValuePair.getValue();
            }
        }
        return null;
    }

    public String toString() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        charArrayBuffer.append(this.mimeType);
        if (this.params != null) {
            charArrayBuffer.append("; ");
            BasicHeaderValueFormatter.INSTANCE.formatParameters(charArrayBuffer, this.params, false);
        } else if (this.charset != null) {
            charArrayBuffer.append(HTTP.CHARSET_PARAM);
            charArrayBuffer.append(this.charset.name());
        }
        return charArrayBuffer.toString();
    }

    public ContentType withCharset(String str) {
        return create(getMimeType(), str);
    }

    public ContentType withCharset(Charset charset) {
        return create(getMimeType(), charset);
    }
}
