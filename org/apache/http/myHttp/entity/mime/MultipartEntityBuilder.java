package org.apache.http.myHttp.entity.mime;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.entity.ContentType;
import org.apache.http.myHttp.entity.mime.content.ByteArrayBody;
import org.apache.http.myHttp.entity.mime.content.ContentBody;
import org.apache.http.myHttp.entity.mime.content.FileBody;
import org.apache.http.myHttp.entity.mime.content.InputStreamBody;
import org.apache.http.myHttp.entity.mime.content.StringBody;
import org.apache.http.myHttp.protocol.HTTP;
import org.apache.http.myHttp.util.Args;
import org.linphone.core.VideoSize;

public class MultipartEntityBuilder {
    private static final String DEFAULT_SUBTYPE = "form-data";
    private static final char[] MULTIPART_CHARS;
    private List<FormBodyPart> bodyParts;
    private String boundary;
    private Charset charset;
    private HttpMultipartMode mode;
    private String subType;

    /* renamed from: org.apache.http.myHttp.entity.mime.MultipartEntityBuilder.1 */
    /* synthetic */ class C26441 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$http$myHttp$entity$mime$HttpMultipartMode;

        static {
            $SwitchMap$org$apache$http$myHttp$entity$mime$HttpMultipartMode = new int[HttpMultipartMode.values().length];
            try {
                $SwitchMap$org$apache$http$myHttp$entity$mime$HttpMultipartMode[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$apache$http$myHttp$entity$mime$HttpMultipartMode[HttpMultipartMode.RFC6532.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static {
        MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    MultipartEntityBuilder() {
        this.subType = DEFAULT_SUBTYPE;
        this.mode = HttpMultipartMode.STRICT;
        this.boundary = null;
        this.charset = null;
        this.bodyParts = null;
    }

    public static MultipartEntityBuilder create() {
        return new MultipartEntityBuilder();
    }

    private String generateBoundary() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            stringBuilder.append(MULTIPART_CHARS[random.nextInt(MULTIPART_CHARS.length)]);
        }
        return stringBuilder.toString();
    }

    private String generateContentType(String str, Charset charset) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("multipart/form-data; boundary=");
        stringBuilder.append(str);
        if (charset != null) {
            stringBuilder.append(HTTP.CHARSET_PARAM);
            stringBuilder.append(charset.name());
        }
        return stringBuilder.toString();
    }

    public MultipartEntityBuilder addBinaryBody(String str, File file) {
        return addBinaryBody(str, file, ContentType.DEFAULT_BINARY, file != null ? file.getName() : null);
    }

    public MultipartEntityBuilder addBinaryBody(String str, File file, ContentType contentType, String str2) {
        return addPart(str, new FileBody(file, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, InputStream inputStream) {
        return addBinaryBody(str, inputStream, ContentType.DEFAULT_BINARY, null);
    }

    public MultipartEntityBuilder addBinaryBody(String str, InputStream inputStream, ContentType contentType, String str2) {
        return addPart(str, new InputStreamBody(inputStream, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, byte[] bArr) {
        return addBinaryBody(str, bArr, ContentType.DEFAULT_BINARY, null);
    }

    public MultipartEntityBuilder addBinaryBody(String str, byte[] bArr, ContentType contentType, String str2) {
        return addPart(str, new ByteArrayBody(bArr, contentType, str2));
    }

    public MultipartEntityBuilder addPart(String str, ContentBody contentBody) {
        Args.notNull(str, "Name");
        Args.notNull(contentBody, "Content body");
        return addPart(new FormBodyPart(str, contentBody));
    }

    MultipartEntityBuilder addPart(FormBodyPart formBodyPart) {
        if (formBodyPart != null) {
            if (this.bodyParts == null) {
                this.bodyParts = new ArrayList();
            }
            this.bodyParts.add(formBodyPart);
        }
        return this;
    }

    public MultipartEntityBuilder addTextBody(String str, String str2) {
        return addTextBody(str, str2, ContentType.DEFAULT_TEXT);
    }

    public MultipartEntityBuilder addTextBody(String str, String str2, ContentType contentType) {
        return addPart(str, new StringBody(str2, contentType));
    }

    public HttpEntity build() {
        return buildEntity();
    }

    MultipartFormEntity buildEntity() {
        AbstractMultipartForm httpBrowserCompatibleMultipart;
        String str = this.subType != null ? this.subType : DEFAULT_SUBTYPE;
        Charset charset = this.charset;
        String generateBoundary = this.boundary != null ? this.boundary : generateBoundary();
        List arrayList = this.bodyParts != null ? new ArrayList(this.bodyParts) : Collections.emptyList();
        switch (C26441.$SwitchMap$org$apache$http$myHttp$entity$mime$HttpMultipartMode[(this.mode != null ? this.mode : HttpMultipartMode.STRICT).ordinal()]) {
            case VideoSize.CIF /*1*/:
                httpBrowserCompatibleMultipart = new HttpBrowserCompatibleMultipart(str, charset, generateBoundary, arrayList);
                break;
            case VideoSize.HVGA /*2*/:
                httpBrowserCompatibleMultipart = new HttpRFC6532Multipart(str, charset, generateBoundary, arrayList);
                break;
            default:
                httpBrowserCompatibleMultipart = new HttpStrictMultipart(str, charset, generateBoundary, arrayList);
                break;
        }
        return new MultipartFormEntity(httpBrowserCompatibleMultipart, generateContentType(generateBoundary, charset), httpBrowserCompatibleMultipart.getTotalLength());
    }

    public MultipartEntityBuilder setBoundary(String str) {
        this.boundary = str;
        return this;
    }

    public MultipartEntityBuilder setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public MultipartEntityBuilder setLaxMode() {
        this.mode = HttpMultipartMode.BROWSER_COMPATIBLE;
        return this;
    }

    public MultipartEntityBuilder setMode(HttpMultipartMode httpMultipartMode) {
        this.mode = httpMultipartMode;
        return this;
    }

    public MultipartEntityBuilder setStrictMode() {
        this.mode = HttpMultipartMode.STRICT;
        return this;
    }
}
