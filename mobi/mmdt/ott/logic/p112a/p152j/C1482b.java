package mobi.mmdt.ott.logic.p112a.p152j;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map.Entry;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1474a;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1475b;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1476c;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1477d;
import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p106b.C1265a;
import mobi.mmdt.ott.p095c.p108d.C1301b;
import mobi.mmdt.ott.p095c.p108d.C1302c;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import org.apache.http.myHttp.entity.mime.MIME;
import org.apache.http.myHttp.protocol.HTTP;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.json.JSONObject;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.j.b */
public class C1482b extends C1481a {
    private String f4950h;
    private Uri f4951i;
    private String f4952j;
    private int f4953k;

    public C1482b(Context context, int i, String str, String str2, Uri uri, boolean z, boolean z2) {
        super(context, i, z, z2);
        this.f4953k = 0;
        this.f4950h = str;
        this.f4951i = uri;
        this.f4952j = str2;
    }

    protected boolean m7484a(Throwable th) {
        if (this.f4953k > 3) {
            return super.m7479a(th);
        }
        this.f = (Exception) th;
        return true;
    }

    public void m7485c() {
        m7486k();
    }

    protected void m7486k() {
        String b;
        this.f4953k++;
        if (!this.e) {
            b = C1309a.m6934a(this.b).m6942b();
            String c = C1302c.m6877c(System.currentTimeMillis() + C1301b.m6869a(20) + b);
            this.f4950h += "/" + b + "/" + new C1263m(this.b).m6847e() + "/" + C1302c.m6874a(this.f4952j + b + c + new C1263m(this.b).m6851g()) + "/" + c;
        }
        b = C1301b.m6871b(this.b);
        HttpURLConnection a = C1265a.m6853a(this.b, new URL(this.f4950h), false);
        a.setUseCaches(false);
        a.setConnectTimeout(5000);
        System.setProperty("http.agent", b);
        a.setRequestMethod("GET");
        if (VERSION.SDK_INT > 13) {
            a.setRequestProperty(HTTP.CONN_DIRECTIVE, Close.ELEMENT);
        }
        boolean z = false;
        for (Entry entry : a.getHeaderFields().entrySet()) {
            boolean z2 = (entry.getKey() == null || !((String) entry.getKey()).equalsIgnoreCase(MIME.CONTENT_DISPOSITION)) ? z : true;
            z = z2;
        }
        C1104b.m6366b((Object) "RestfulWS", "get WebService <<>> URL <<" + this.f4950h + ">>");
        if (z) {
            InputStream inputStream = a.getInputStream();
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f4951i.getPath()), "rw");
            byte[] bArr = new byte[10240];
            int contentLength = a.getContentLength();
            z2 = false;
            int i = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                } else if (this.a) {
                    break;
                } else {
                    i += read;
                    randomAccessFile.write(bArr, 0, read);
                    boolean z3 = (i * 100) / contentLength;
                    if (z3 != z2) {
                        C0002c.m2a().m17c(new C1477d(this.d, z3, this.g));
                        z2 = z3;
                    }
                }
            }
            randomAccessFile.close();
            inputStream.close();
            a.disconnect();
            randomAccessFile.close();
            inputStream.close();
            a.disconnect();
            if (this.a) {
                C0002c.m2a().m17c(new C1474a(this.d, this.g));
                return;
            }
            C0002c.m2a().m17c(new C1477d(this.d, 100, this.g));
            C0002c.m2a().m17c(new C1475b(this.d, this.g));
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                stringBuilder.append(readLine).append("\n");
            } else {
                bufferedReader.close();
                C1104b.m6366b((Object) "RestfulWS", "Receive WebService <<" + stringBuilder.toString() + ">>");
                C0002c.m2a().m17c(new C1476c(this.d, new JSONObject(stringBuilder.toString()), this.g));
                return;
            }
        }
    }
}
