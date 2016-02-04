package mobi.mmdt.ott.p089b.p090a.p092b;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Message.Body;
import org.jivesoftware.smack.packet.Message.Type;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.chatstates.ChatState;
import org.jivesoftware.smackx.chatstates.packet.ChatStateExtension;
import org.jivesoftware.smackx.muc.DiscussionHistory;
import org.jivesoftware.smackx.muc.InvitationListener;
import org.jivesoftware.smackx.muc.MUCAffiliation;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.MultiUserChatManager;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.b.a.b.b */
public class C1145b implements MessageListener, InvitationListener {
    private XMPPTCPConnection f4213a;
    private C1141a f4214b;
    private MultiUserChatManager f4215c;

    public C1145b(C1141a c1141a) {
        this.f4214b = c1141a;
    }

    public String m6550a() {
        String str = "pri_" + this.f4213a.getUser().split("@")[0] + "_" + System.currentTimeMillis() + "@conference." + this.f4213a.getServiceName();
        this.f4215c.getMultiUserChat(str).addMessageListener(this);
        this.f4215c.getMultiUserChat(str).create(this.f4213a.getUser());
        if (!this.f4215c.getMultiUserChat(str).isJoined()) {
            this.f4215c.getMultiUserChat(str).join(this.f4213a.getUser(), null, null, 20000);
        }
        return str;
    }

    public String m6551a(String str, String str2, String str3, Map<String, String> map) {
        Message message = new Message(str, Type.groupchat);
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
        this.f4215c.getMultiUserChat(str).sendMessage(message);
        return str3;
    }

    public void m6552a(String str) {
        this.f4215c.getMultiUserChat(str).leave();
    }

    public void m6553a(String str, int i) {
        if (!this.f4215c.getMultiUserChat(str).isJoined()) {
            this.f4215c.getMultiUserChat(str).addMessageListener(this);
            DiscussionHistory discussionHistory = new DiscussionHistory();
            discussionHistory.setMaxStanzas(i);
            this.f4215c.getMultiUserChat(str).join(this.f4213a.getUser(), null, discussionHistory, 20000);
        }
    }

    public void m6554a(String str, long j) {
        if (this.f4215c.getMultiUserChat(str).isJoined()) {
            this.f4215c.getMultiUserChat(str).leave();
        }
        if (!this.f4215c.getMultiUserChat(str).isJoined()) {
            this.f4215c.getMultiUserChat(str).addMessageListener(this);
            DiscussionHistory discussionHistory = new DiscussionHistory();
            discussionHistory.setSince(new Date(j - 180000));
            this.f4215c.getMultiUserChat(str).join(this.f4213a.getUser(), null, discussionHistory, 20000);
        }
    }

    public void m6555a(String str, String str2) {
        try {
            this.f4215c.getMultiUserChat(str).banUser(str2, "Kill your self");
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
            throw e;
        }
    }

    public void m6556a(String str, String str2, String str3) {
        this.f4215c.getMultiUserChat(str).invite(str2, str3);
    }

    public void m6557a(String str, String str2, MUCAffiliation mUCAffiliation) {
        switch (C1146c.f4216a[mUCAffiliation.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f4215c.getMultiUserChat(str).grantAdmin(str2);
            case VideoSize.HVGA /*2*/:
                this.f4215c.getMultiUserChat(str).grantMembership(str2);
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f4215c.getMultiUserChat(str).grantOwnership(str2);
            case Version.API04_DONUT_16 /*4*/:
                this.f4215c.getMultiUserChat(str).banUser(str2, null);
            default:
        }
    }

    public void m6558a(XMPPTCPConnection xMPPTCPConnection) {
        this.f4213a = xMPPTCPConnection;
        this.f4215c = MultiUserChatManager.getInstanceFor(this.f4213a);
    }

    public void m6559a(ChatState chatState, String str) {
        Message message = new Message();
        message.setType(Type.groupchat);
        message.setFrom(this.f4213a.getUser());
        message.setTo(str);
        message.addExtension(new ChatStateExtension(chatState));
        this.f4215c.getMultiUserChat(str).sendMessage(message);
    }

    public void invitationReceived(XMPPConnection xMPPConnection, MultiUserChat multiUserChat, String str, String str2, String str3, Message message) {
    }

    public void processMessage(Message message) {
        if (message.getFrom().split("/").length == 2 || message.getFrom().split("/").length == 3) {
            ExtensionElement extension = message.getExtension(ChatStateExtension.NAMESPACE);
            if (extension != null) {
                ChatState valueOf = ChatState.valueOf(extension.getElementName());
                this.f4214b.m6496a(message.getFrom().split("/")[0], message.getFrom().split("/")[1] + "@" + this.f4213a.getServiceName(), valueOf);
            }
            if (message.getBody() != null) {
                Collection<Body> bodies = message.getBodies();
                Map hashMap = new HashMap();
                for (Body body : bodies) {
                    hashMap.put(body.getLanguage(), body.getMessage());
                }
                String str = message.getFrom().split("/")[1];
                this.f4214b.m6495a(message.getStanzaId(), message.getFrom().split("/")[0], str, message.getBody(), hashMap);
            }
        }
    }
}
