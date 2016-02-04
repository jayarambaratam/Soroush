package mobi.mmdt.ott.p095c.p106b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import org.jivesoftware.smack.util.TLSUtils;

/* renamed from: mobi.mmdt.ott.c.b.f */
class C1270f extends C1269e {
    private C1270f(SSLSocket sSLSocket) {
        super(sSLSocket);
        if (!sSLSocket.getClass().getCanonicalName().equals("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl")) {
            try {
                Method method = sSLSocket.getClass().getMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
                if (method != null) {
                    method.invoke(sSLSocket, new Object[]{Boolean.valueOf(true)});
                }
            } catch (NoSuchMethodException e) {
            } catch (InvocationTargetException e2) {
            } catch (IllegalAccessException e3) {
            }
        }
    }

    public void setEnabledProtocols(String[] strArr) {
        if (strArr != null && strArr.length == 1 && TLSUtils.PROTO_SSL3.equals(strArr[0])) {
            List arrayList = new ArrayList(Arrays.asList(this.a.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove(TLSUtils.PROTO_SSL3);
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        super.setEnabledProtocols(strArr);
    }
}
