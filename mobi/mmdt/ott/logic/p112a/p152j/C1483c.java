package mobi.mmdt.ott.logic.p112a.p152j;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1474a;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1477d;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1480g;
import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.ar;
import mobi.mmdt.ott.p095c.p096a.p101c.p102a.C1248a;
import mobi.mmdt.ott.p095c.p096a.p101c.p102a.C1249b;
import mobi.mmdt.ott.p095c.p096a.p101c.p103b.p104a.C1250a;
import mobi.mmdt.ott.p095c.p096a.p101c.p103b.p104a.C1251b;
import mobi.mmdt.ott.p095c.p096a.p101c.p103b.p105b.C1252a;
import mobi.mmdt.ott.p095c.p096a.p101c.p103b.p105b.C1253b;
import mobi.mmdt.ott.p095c.p106b.C1265a;
import mobi.mmdt.ott.p095c.p106b.C1271g;
import mobi.mmdt.ott.p095c.p107c.C1275b;
import mobi.mmdt.ott.p095c.p107c.C1280g;
import mobi.mmdt.ott.p095c.p107c.C1287n;
import mobi.mmdt.ott.p095c.p107c.C1298z;
import mobi.mmdt.ott.p095c.p107c.aj;
import mobi.mmdt.ott.p095c.p108d.C1301b;
import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.HttpHeaders;
import org.apache.http.myHttp.entity.ContentType;
import org.apache.http.myHttp.entity.mime.MultipartEntityBuilder;
import org.apache.http.myHttp.entity.mime.content.FileBody;
import org.apache.http.myHttp.protocol.HTTP;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.json.JSONObject;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.j.c */
public class C1483c extends C1481a {
    private Uri f4954h;
    private Uri f4955i;

    public C1483c(Context context, int i, Uri uri, Uri uri2, boolean z) {
        super(context, i, z, false);
        this.f4954h = uri;
        this.f4955i = uri2;
    }

    private C1250a m7487a(Uri uri) {
        C1263m c1263m = new C1263m(this.b);
        JSONObject c1248a = new C1248a(uri, this.c.m6942b(), c1263m.m6847e(), c1263m.m6851g());
        try {
            return (C1250a) ar.m6742a(c1248a, C1271g.m6858a(this.b, this.c.m6967k() + "file_exists/", c1248a, C1301b.m6871b(this.b)), new C1252a(c1263m));
        } catch (aj e) {
            if (e.m6859a() == 340) {
                throw new C1280g(e.m6859a(), e.m6861c(), c1248a);
            } else if (e.m6859a() == 342) {
                throw new C1287n(e.m6859a(), e.m6861c(), c1248a);
            } else if (e.m6859a() == 341) {
                throw new C1275b(e.m6859a(), e.m6861c(), c1248a);
            } else if (e.m6859a() == 343) {
                throw new C1298z(e.m6859a(), e.m6861c(), c1248a);
            } else {
                throw new aj(e.m6859a(), e.m6861c(), c1248a);
            }
        }
    }

    public void m7488c() {
        C1250a c1250a = null;
        if (!this.e) {
            c1250a = m7487a(this.f4954h);
        }
        if (c1250a == null || !c1250a.m6776d()) {
            m7489k();
        } else {
            C0002c.m2a().m17c(new C1480g(this.d, c1250a.m6773a(), c1250a.m6774b(), c1250a.m6775c()));
        }
    }

    protected void m7489k() {
        C1263m c1263m = new C1263m(this.b);
        String str = "--boundary" + System.currentTimeMillis() + "\t--";
        System.setProperty("http.keepAlive", "false");
        System.setProperty("http.agent", C1301b.m6871b(this.b));
        String str2 = this.e ? this.c.m6967k() + "upload_static_file/" : this.c.m6967k() + "upload_file/";
        HttpURLConnection a = C1265a.m6853a(this.b, new URL(str2), false);
        a.setUseCaches(false);
        a.setDoOutput(true);
        a.setDoInput(true);
        a.setRequestMethod("POST");
        a.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, StringUtils.UTF8);
        a.setRequestProperty(HttpHeaders.CACHE_CONTROL, "no-cache");
        a.setRequestProperty(HTTP.CONTENT_TYPE, "multipart/form-data;boundary=" + str);
        if (VERSION.SDK_INT > 13) {
            a.setRequestProperty(HTTP.CONN_DIRECTIVE, Close.ELEMENT);
        }
        MultipartEntityBuilder create = MultipartEntityBuilder.create();
        create.setBoundary(str);
        JSONObject c1249b = new C1249b(this.c.m6942b(), c1263m.m6847e(), c1263m.m6851g());
        C1104b.m6366b((Object) "RestfulWS", "Post WebService <<" + c1249b + ">> URL <<" + str2 + ">>");
        create.addTextBody("Data", c1249b.toString(), ContentType.APPLICATION_JSON);
        create.addPart("File", new FileBody(new File(this.f4954h.getPath())));
        if (this.f4955i != null) {
            create.addPart("Thumbnail", new FileBody(new File(this.f4955i.getPath())));
        }
        HttpEntity build = create.build();
        a.setFixedLengthStreamingMode((int) build.getContentLength());
        OutputStream outputStream = a.getOutputStream();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        build.writeTo(byteArrayOutputStream);
        byteArrayOutputStream.close();
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        int length = toByteArray.length;
        boolean z = false;
        int i = 0;
        while (i < length && !this.a) {
            int i2 = length - i;
            if (i2 > 2000) {
                i2 = 2000;
            }
            outputStream.write(toByteArray, i, i2);
            i += i2;
            boolean z2 = (i * 100) / length;
            if (z2 != z) {
                C0002c.m2a().m17c(new C1477d(this.d, z2, false));
            } else {
                z2 = z;
            }
            z = z2;
        }
        if (this.a) {
            outputStream.close();
            a.disconnect();
            C0002c.m2a().m17c(new C1474a(this.d, false));
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            str = bufferedReader.readLine();
            if (str != null) {
                stringBuilder.append(str);
            } else {
                JSONObject jSONObject = new JSONObject(stringBuilder.toString());
                C1104b.m6366b((Object) "RestfulWS", "Receive WebService <<" + jSONObject + ">>");
                try {
                    C1251b c1251b = (C1251b) ar.m6742a(c1249b, jSONObject, new C1253b());
                    outputStream.close();
                    a.disconnect();
                    C0002c.m2a().m17c(new C1480g(this.d, c1251b.m6777a(), c1251b.m6779c(), c1251b.m6778b()));
                    return;
                } catch (aj e) {
                    outputStream.close();
                    a.disconnect();
                    if (e.m6859a() == 340) {
                        throw new C1280g(e.m6859a(), e.m6861c(), c1249b);
                    } else if (e.m6859a() == 342) {
                        throw new C1287n(e.m6859a(), e.m6861c(), c1249b);
                    } else if (e.m6859a() == 341) {
                        throw new C1275b(e.m6859a(), e.m6861c(), c1249b);
                    } else if (e.m6859a() == 343) {
                        throw new C1298z(e.m6859a(), e.m6861c(), c1249b);
                    } else {
                        throw new aj(e.m6859a(), e.m6861c(), c1249b);
                    }
                }
            }
        }
    }
}
