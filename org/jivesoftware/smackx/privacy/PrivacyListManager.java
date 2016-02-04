package org.jivesoftware.smackx.privacy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.AbstractConnectionListener;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.IQResultReplyFilter;
import org.jivesoftware.smack.filter.IQTypeFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler.Mode;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.Type;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.privacy.filter.SetActiveListFilter;
import org.jivesoftware.smackx.privacy.filter.SetDefaultListFilter;
import org.jivesoftware.smackx.privacy.packet.Privacy;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;
import org.jivesoftware.smackx.search.UserSearch;

public class PrivacyListManager extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Map<XMPPConnection, PrivacyListManager> INSTANCES;
    public static final String NAMESPACE = "jabber:iq:privacy";
    public static final StanzaFilter PRIVACY_FILTER;
    private static final StanzaFilter PRIVACY_RESULT;
    private volatile String cachedActiveListName;
    private volatile String cachedDefaultListName;
    private final Set<PrivacyListListener> listeners;

    /* renamed from: org.jivesoftware.smackx.privacy.PrivacyListManager.1 */
    final class C27671 implements ConnectionCreationListener {
        C27671() {
        }

        public void connectionCreated(XMPPConnection xMPPConnection) {
            PrivacyListManager.getInstanceFor(xMPPConnection);
        }
    }

    /* renamed from: org.jivesoftware.smackx.privacy.PrivacyListManager.2 */
    class C27682 extends AbstractIqRequestHandler {
        C27682(String str, String str2, Type type, Mode mode) {
            super(str, str2, type, mode);
        }

        public IQ handleIQRequest(IQ iq) {
            Privacy privacy = (Privacy) iq;
            for (PrivacyListListener privacyListListener : PrivacyListManager.this.listeners) {
                for (Entry entry : privacy.getItemLists().entrySet()) {
                    String str = (String) entry.getKey();
                    List list = (List) entry.getValue();
                    if (list.isEmpty()) {
                        privacyListListener.updatedPrivacyList(str);
                    } else {
                        privacyListListener.setPrivacyList(str, list);
                    }
                }
            }
            return IQ.createResultIQ(privacy);
        }
    }

    /* renamed from: org.jivesoftware.smackx.privacy.PrivacyListManager.3 */
    class C27703 implements StanzaListener {

        /* renamed from: org.jivesoftware.smackx.privacy.PrivacyListManager.3.1 */
        class C27691 implements StanzaListener {
            final /* synthetic */ String val$activeListName;
            final /* synthetic */ boolean val$declinceActiveList;

            C27691(boolean z, String str) {
                this.val$declinceActiveList = z;
                this.val$activeListName = str;
            }

            public void processPacket(Stanza stanza) {
                if (this.val$declinceActiveList) {
                    PrivacyListManager.this.cachedActiveListName = null;
                } else {
                    PrivacyListManager.this.cachedActiveListName = this.val$activeListName;
                }
            }
        }

        C27703() {
        }

        public void processPacket(Stanza stanza) {
            XMPPConnection access$100 = PrivacyListManager.this.connection();
            Privacy privacy = (Privacy) stanza;
            access$100.addOneTimeSyncCallback(new C27691(privacy.isDeclineActiveList(), privacy.getActiveName()), new IQResultReplyFilter(privacy, access$100));
        }
    }

    /* renamed from: org.jivesoftware.smackx.privacy.PrivacyListManager.4 */
    class C27724 implements StanzaListener {

        /* renamed from: org.jivesoftware.smackx.privacy.PrivacyListManager.4.1 */
        class C27711 implements StanzaListener {
            final /* synthetic */ boolean val$declinceDefaultList;
            final /* synthetic */ String val$defaultListName;

            C27711(boolean z, String str) {
                this.val$declinceDefaultList = z;
                this.val$defaultListName = str;
            }

            public void processPacket(Stanza stanza) {
                if (this.val$declinceDefaultList) {
                    PrivacyListManager.this.cachedDefaultListName = null;
                } else {
                    PrivacyListManager.this.cachedDefaultListName = this.val$defaultListName;
                }
            }
        }

        C27724() {
        }

        public void processPacket(Stanza stanza) {
            XMPPConnection access$300 = PrivacyListManager.this.connection();
            Privacy privacy = (Privacy) stanza;
            access$300.addOneTimeSyncCallback(new C27711(privacy.isDeclineDefaultList(), privacy.getDefaultName()), new IQResultReplyFilter(privacy, access$300));
        }
    }

    /* renamed from: org.jivesoftware.smackx.privacy.PrivacyListManager.5 */
    class C27735 implements StanzaListener {
        C27735() {
        }

        public void processPacket(Stanza stanza) {
            Privacy privacy = (Privacy) stanza;
            String activeName = privacy.getActiveName();
            if (activeName != null) {
                PrivacyListManager.this.cachedActiveListName = activeName;
            }
            activeName = privacy.getDefaultName();
            if (activeName != null) {
                PrivacyListManager.this.cachedDefaultListName = activeName;
            }
        }
    }

    /* renamed from: org.jivesoftware.smackx.privacy.PrivacyListManager.6 */
    class C27746 extends AbstractConnectionListener {
        C27746() {
        }

        public void authenticated(XMPPConnection xMPPConnection, boolean z) {
            if (!z) {
                PrivacyListManager.this.cachedActiveListName = PrivacyListManager.this.cachedDefaultListName = null;
            }
        }
    }

    static {
        $assertionsDisabled = !PrivacyListManager.class.desiredAssertionStatus() ? true : $assertionsDisabled;
        PRIVACY_FILTER = new StanzaTypeFilter(Privacy.class);
        PRIVACY_RESULT = new AndFilter(IQTypeFilter.RESULT, PRIVACY_FILTER);
        INSTANCES = new WeakHashMap();
        XMPPConnectionRegistry.addConnectionCreationListener(new C27671());
    }

    private PrivacyListManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.listeners = new CopyOnWriteArraySet();
        xMPPConnection.registerIQRequestHandler(new C27682(UserSearch.ELEMENT, NAMESPACE, Type.set, Mode.sync));
        xMPPConnection.addPacketSendingListener(new C27703(), SetActiveListFilter.INSTANCE);
        xMPPConnection.addPacketSendingListener(new C27724(), SetDefaultListFilter.INSTANCE);
        xMPPConnection.addSyncStanzaListener(new C27735(), PRIVACY_RESULT);
        xMPPConnection.addConnectionListener(new C27746());
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(NAMESPACE);
    }

    public static synchronized PrivacyListManager getInstanceFor(XMPPConnection xMPPConnection) {
        PrivacyListManager privacyListManager;
        synchronized (PrivacyListManager.class) {
            privacyListManager = (PrivacyListManager) INSTANCES.get(xMPPConnection);
            if (privacyListManager == null) {
                privacyListManager = new PrivacyListManager(xMPPConnection);
                INSTANCES.put(xMPPConnection, privacyListManager);
            }
        }
        return privacyListManager;
    }

    private List<PrivacyItem> getPrivacyListItems(String str) {
        if ($assertionsDisabled || StringUtils.isNotEmpty(str)) {
            Privacy privacy = new Privacy();
            privacy.setPrivacyList(str, new ArrayList());
            return getRequest(privacy).getPrivacyList(str);
        }
        throw new AssertionError();
    }

    private Privacy getPrivacyWithListNames() {
        return getRequest(new Privacy());
    }

    private Privacy getRequest(Privacy privacy) {
        privacy.setType(Type.get);
        return (Privacy) connection().createPacketCollectorAndSend(privacy).nextResultOrThrow();
    }

    private Stanza setRequest(Privacy privacy) {
        privacy.setType(Type.set);
        return connection().createPacketCollectorAndSend(privacy).nextResultOrThrow();
    }

    public boolean addListener(PrivacyListListener privacyListListener) {
        return this.listeners.add(privacyListListener);
    }

    public void createPrivacyList(String str, List<PrivacyItem> list) {
        updatePrivacyList(str, list);
    }

    public void declineActiveList() {
        Privacy privacy = new Privacy();
        privacy.setDeclineActiveList(true);
        setRequest(privacy);
    }

    public void declineDefaultList() {
        Privacy privacy = new Privacy();
        privacy.setDeclineDefaultList(true);
        setRequest(privacy);
    }

    public void deletePrivacyList(String str) {
        Privacy privacy = new Privacy();
        privacy.setPrivacyList(str, new ArrayList());
        setRequest(privacy);
    }

    public PrivacyList getActiveList() {
        Privacy privacyWithListNames = getPrivacyWithListNames();
        String activeName = privacyWithListNames.getActiveName();
        if (StringUtils.isNullOrEmpty(activeName)) {
            return null;
        }
        boolean z = (activeName == null || !activeName.equals(privacyWithListNames.getDefaultName())) ? $assertionsDisabled : true;
        return new PrivacyList(true, z, activeName, getPrivacyListItems(activeName));
    }

    public String getActiveListName() {
        return this.cachedActiveListName != null ? this.cachedActiveListName : getPrivacyWithListNames().getActiveName();
    }

    public PrivacyList getDefaultList() {
        Privacy privacyWithListNames = getPrivacyWithListNames();
        String defaultName = privacyWithListNames.getDefaultName();
        return StringUtils.isNullOrEmpty(defaultName) ? null : new PrivacyList(defaultName.equals(privacyWithListNames.getActiveName()), true, defaultName, getPrivacyListItems(defaultName));
    }

    public String getDefaultListName() {
        return this.cachedDefaultListName != null ? this.cachedDefaultListName : getPrivacyWithListNames().getDefaultName();
    }

    public String getEffectiveListName() {
        String activeListName = getActiveListName();
        return activeListName != null ? activeListName : getDefaultListName();
    }

    public PrivacyList getPrivacyList(String str) {
        String str2 = (String) StringUtils.requireNotNullOrEmpty(str, "List name must not be null");
        return new PrivacyList($assertionsDisabled, $assertionsDisabled, str2, getPrivacyListItems(str2));
    }

    public List<PrivacyList> getPrivacyLists() {
        Privacy privacyWithListNames = getPrivacyWithListNames();
        Set<String> privacyListNames = privacyWithListNames.getPrivacyListNames();
        List<PrivacyList> arrayList = new ArrayList(privacyListNames.size());
        for (String str : privacyListNames) {
            arrayList.add(new PrivacyList(str.equals(privacyWithListNames.getActiveName()), str.equals(privacyWithListNames.getDefaultName()), str, getPrivacyListItems(str)));
        }
        return arrayList;
    }

    public boolean isSupported() {
        return ServiceDiscoveryManager.getInstanceFor(connection()).serverSupportsFeature(NAMESPACE);
    }

    public boolean removeListener(PrivacyListListener privacyListListener) {
        return this.listeners.remove(privacyListListener);
    }

    public void setActiveListName(String str) {
        Privacy privacy = new Privacy();
        privacy.setActiveName(str);
        setRequest(privacy);
    }

    public void setDefaultListName(String str) {
        Privacy privacy = new Privacy();
        privacy.setDefaultName(str);
        setRequest(privacy);
    }

    public void updatePrivacyList(String str, List<PrivacyItem> list) {
        Privacy privacy = new Privacy();
        privacy.setPrivacyList(str, list);
        setRequest(privacy);
    }
}
