package mobi.mmdt.ott.p089b.p090a.p091a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.chat.ChatManagerListener;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Message.Body;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.chatstates.ChatState;
import org.jivesoftware.smackx.chatstates.ChatStateManager;
import org.jivesoftware.smackx.chatstates.packet.ChatStateExtension;
import org.jivesoftware.smackx.receipts.DeliveryReceiptManager;
import org.jivesoftware.smackx.receipts.DeliveryReceiptManager.AutoReceiptMode;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;
import org.jivesoftware.smackx.receipts.ReceiptReceivedListener;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.b.a.a.b */
public class C1139b implements ChatManagerListener, ChatMessageListener, ReceiptReceivedListener {
    private XMPPTCPConnection f4192a;
    private ChatManager f4193b;
    private ChatStateManager f4194c;
    private DeliveryReceiptManager f4195d;
    private HashMap<String, String> f4196e;
    private C1138a f4197f;

    public C1139b(C1138a c1138a) {
        this.f4196e = new HashMap();
        this.f4197f = c1138a;
    }

    private Chat m6491a(String str) {
        String str2 = (String) this.f4196e.get(str);
        if (str2 != null) {
            return this.f4193b.getThreadChat(str2);
        }
        Chat createChat = this.f4193b.createChat(str, this);
        this.f4196e.put(str, createChat.getThreadID());
        return createChat;
    }

    public String m6492a(String str, String str2, String str3, Map<String, String> map, boolean z) {
        Message message = new Message();
        message.setBody(str2);
        if (str3 != null) {
            message.setStanzaId(str3);
        }
        for (String str4 : map.keySet()) {
            String str5 = (String) map.get(str4);
            if (str5 != null) {
                message.addBody(str4, str5);
            }
        }
        if (z) {
            DeliveryReceiptRequest.addTo(message);
        }
        m6491a(str).sendMessage(message);
        return message.getStanzaId();
    }

    public void m6493a(XMPPTCPConnection xMPPTCPConnection) {
        this.f4192a = xMPPTCPConnection;
        this.f4193b = ChatManager.getInstanceFor(this.f4192a);
        this.f4193b.addChatListener(this);
        this.f4194c = ChatStateManager.getInstance(this.f4192a);
        this.f4195d = DeliveryReceiptManager.getInstanceFor(this.f4192a);
        this.f4195d.setAutoReceiptMode(AutoReceiptMode.always);
        this.f4195d.addReceiptReceivedListener(this);
    }

    public void m6494a(ChatState chatState, String str) {
        this.f4194c.setCurrentState(chatState, m6491a(str));
    }

    public void chatCreated(Chat chat, boolean z) {
        if (!z) {
            this.f4196e.put(chat.getParticipant(), chat.getThreadID());
            chat.addMessageListener(this);
        }
    }

    public void onReceiptReceived(String str, String str2, String str3, Stanza stanza) {
        this.f4197f.m6489b(str3, str);
    }

    public void processMessage(Chat chat, Message message) {
        switch (C1140c.f4198a[message.getType().ordinal()]) {
            case VideoSize.CIF /*1*/:
                ExtensionElement extension = message.getExtension(ChatStateExtension.NAMESPACE);
                if (extension != null) {
                    this.f4197f.m6488a(ChatState.valueOf(extension.getElementName()), message.getFrom());
                }
                if (message.getBody() != null) {
                    Collection<Body> bodies = message.getBodies();
                    Map hashMap = new HashMap();
                    for (Body body : bodies) {
                        hashMap.put(body.getLanguage(), body.getMessage());
                    }
                    this.f4197f.m6490b(message.getFrom(), message.getBody(), message.getStanzaId(), hashMap);
                }
            case VideoSize.HVGA /*2*/:
                C1104b.m6370d(this, "onReceiveMessageerror");
            case Version.API03_CUPCAKE_15 /*3*/:
                C1104b.m6370d(this, "onReceiveMessagegroupchat");
            case Version.API04_DONUT_16 /*4*/:
                C1104b.m6370d(this, "onReceiveMessageheadline");
            case Version.API05_ECLAIR_20 /*5*/:
                C1104b.m6370d(this, "onReceiveMessagenormal");
            default:
                C1104b.m6370d(this, "onReceiveMessagedefault");
        }
    }
}
