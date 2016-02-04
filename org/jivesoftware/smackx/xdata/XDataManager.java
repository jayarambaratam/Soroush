package org.jivesoftware.smackx.xdata;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;

public class XDataManager extends Manager {
    private static final Map<XMPPConnection, XDataManager> INSTANCES;
    public static final String NAMESPACE = "jabber:x:data";

    /* renamed from: org.jivesoftware.smackx.xdata.XDataManager.1 */
    final class C27871 implements ConnectionCreationListener {
        C27871() {
        }

        public void connectionCreated(XMPPConnection xMPPConnection) {
            XDataManager.getInstanceFor(xMPPConnection);
        }
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new C27871());
        INSTANCES = new WeakHashMap();
    }

    private XDataManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(NAMESPACE);
    }

    public static synchronized XDataManager getInstanceFor(XMPPConnection xMPPConnection) {
        XDataManager xDataManager;
        synchronized (XDataManager.class) {
            xDataManager = (XDataManager) INSTANCES.get(xMPPConnection);
            if (xDataManager == null) {
                xDataManager = new XDataManager(xMPPConnection);
                INSTANCES.put(xMPPConnection, xDataManager);
            }
        }
        return xDataManager;
    }

    public boolean isSupported(String str) {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(str, NAMESPACE);
    }
}
