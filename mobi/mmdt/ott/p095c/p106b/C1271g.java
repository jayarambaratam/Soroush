package mobi.mmdt.ott.p095c.p106b;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import net.frakbot.glowpadbackport.BuildConfig;
import org.apache.http.myHttp.protocol.HTTP;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.b.g */
public class C1271g {
    public static JSONObject m6857a(Context context, String str, String str2) {
        HttpURLConnection httpURLConnection = null;
        if (str2 != null) {
            try {
                System.setProperty("http.agent", str2);
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
        httpURLConnection = C1265a.m6853a(context, new URL(str), true);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty(HTTP.CONTENT_TYPE, "application/json; charset=UTF-8");
        httpURLConnection.setUseCaches(false);
        C1104b.m6366b((Object) "RestfulWS", "GET WebService <<>> URL <<" + str + ">>");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            stringBuilder.append(readLine).append("\n");
        }
        bufferedReader.close();
        C1104b.m6366b((Object) "RestfulWS", "Receive WebService " + stringBuilder.toString().substring(0, stringBuilder.toString().length() - (stringBuilder.toString().length() / 100)) + BuildConfig.FLAVOR);
        JSONObject jSONObject = new JSONObject(stringBuilder.toString());
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        return jSONObject;
    }

    public static JSONObject m6858a(Context context, String str, JSONObject jSONObject, String str2) {
        HttpURLConnection httpURLConnection = null;
        if (str2 != null) {
            try {
                System.setProperty("http.agent", str2);
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        httpURLConnection = C1265a.m6853a(context, new URL(str), true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty(HTTP.CONTENT_TYPE, "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, Close.ELEMENT);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(false);
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        C1104b.m6366b((Object) "RestfulWS", "POST WebService <<" + jSONObject.toString() + ">> URL <<" + str + ">>");
        currentTimeMillis = System.currentTimeMillis();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(jSONObject.toString().getBytes(StringUtils.UTF8));
        outputStream.close();
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        System.currentTimeMillis();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            stringBuilder.append(readLine);
            stringBuilder.append('\r');
        }
        C1104b.m6366b((Object) "RestfulWS", "Receive WebService " + stringBuilder.toString().substring(0, stringBuilder.toString().length() - (stringBuilder.toString().length() / 50)) + BuildConfig.FLAVOR);
        bufferedReader.close();
        JSONObject jSONObject2 = new JSONObject(stringBuilder.toString());
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        return jSONObject2;
    }
}
