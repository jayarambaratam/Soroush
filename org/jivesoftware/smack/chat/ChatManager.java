package org.jivesoftware.smack.chat;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.filter.FromMatchesFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.ThreadFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Message.Type;
import org.jivesoftware.smack.packet.Stanza;
import org.p253a.p254a.C2643e;

public class ChatManager extends Manager {
    private static final Map<XMPPConnection, ChatManager> INSTANCES;
    private static boolean defaultIsNormalInclude;
    private static MatchMode defaultMatchMode;
    private Map<String, Chat> baseJidChats;
    private Set<ChatManagerListener> chatManagerListeners;
    private Map<MessageListener, StanzaFilter> interceptors;
    private Map<String, Chat> jidChats;
    private MatchMode matchMode;
    private boolean normalIncluded;
    private final StanzaFilter packetFilter;
    private Map<String, Chat> threadChats;

    /* renamed from: org.jivesoftware.smack.chat.ChatManager.1 */
    class C26641 extends FlexibleStanzaTypeFilter<Message> {
        C26641() {
        }

        protected boolean acceptSpecific(Message message) {
            return ChatManager.this.normalIncluded && message.getType() == Type.normal;
        }
    }

    /* renamed from: org.jivesoftware.smack.chat.ChatManager.2 */
    class C26652 implements StanzaListener {
        C26652() {
        }

        public void processPacket(Stanza stanza) {
            Message message = (Message) stanza;
            Chat access$100 = message.getThread() == null ? ChatManager.this.getUserChat(message.getFrom()) : ChatManager.this.getThreadChat(message.getThread());
            if (access$100 == null) {
                access$100 = ChatManager.this.createChat(message);
            }
            if (access$100 != null) {
                ChatManager.this.deliverMessage(access$100, message);
            }
        }
    }

    public enum MatchMode {
        NONE,
        SUPPLIED_JID,
        BARE_JID
    }

    static {
        INSTANCES = new WeakHashMap();
        defaultIsNormalInclude = true;
        defaultMatchMode = MatchMode.BARE_JID;
    }

    private ChatManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.packetFilter = new OrFilter(MessageTypeFilter.CHAT, new C26641());
        this.normalIncluded = defaultIsNormalInclude;
        this.matchMode = defaultMatchMode;
        this.threadChats = new ConcurrentHashMap();
        this.jidChats = new ConcurrentHashMap();
        this.baseJidChats = new ConcurrentHashMap();
        this.chatManagerListeners = new CopyOnWriteArraySet();
        this.interceptors = new WeakHashMap();
        xMPPConnection.addSyncStanzaListener(new C26652(), this.packetFilter);
        INSTANCES.put(xMPPConnection, this);
    }

    private Chat createChat(String str, String str2, boolean z) {
        Chat chat = new Chat(this, str, str2);
        this.threadChats.put(str2, chat);
        this.jidChats.put(str, chat);
        this.baseJidChats.put(C2643e.m11086d(str), chat);
        for (ChatManagerListener chatCreated : this.chatManagerListeners) {
            chatCreated.chatCreated(chat, z);
        }
        return chat;
    }

    private Chat createChat(Message message) {
        String from = message.getFrom();
        if (from == null) {
            return null;
        }
        String thread = message.getThread();
        if (thread == null) {
            thread = nextID();
        }
        return createChat(from, thread, false);
    }

    private void deliverMessage(Chat chat, Message message) {
        chat.deliver(message);
    }

    public static synchronized ChatManager getInstanceFor(XMPPConnection xMPPConnection) {
        ChatManager chatManager;
        synchronized (ChatManager.class) {
            chatManager = (ChatManager) INSTANCES.get(xMPPConnection);
            if (chatManager == null) {
                chatManager = new ChatManager(xMPPConnection);
            }
        }
        return chatManager;
    }

    private Chat getUserChat(String str) {
        if (this.matchMode == MatchMode.NONE || str == null) {
            return null;
        }
        Chat chat = (Chat) this.jidChats.get(str);
        return (chat == null && this.matchMode == MatchMode.BARE_JID) ? (Chat) this.baseJidChats.get(C2643e.m11086d(str)) : chat;
    }

    private static String nextID() {
        return UUID.randomUUID().toString();
    }

    public static void setDefaultIsNormalIncluded(boolean z) {
        defaultIsNormalInclude = z;
    }

    public static void setDefaultMatchMode(MatchMode matchMode) {
        defaultMatchMode = matchMode;
    }

    public void addChatListener(ChatManagerListener chatManagerListener) {
        this.chatManagerListeners.add(chatManagerListener);
    }

    public void addOutgoingMessageInterceptor(MessageListener messageListener) {
        addOutgoingMessageInterceptor(messageListener, null);
    }

    public void addOutgoingMessageInterceptor(MessageListener messageListener, StanzaFilter stanzaFilter) {
        if (messageListener != null) {
            this.interceptors.put(messageListener, stanzaFilter);
        }
    }

    void closeChat(Chat chat) {
        this.threadChats.remove(chat.getThreadID());
        String participant = chat.getParticipant();
        this.jidChats.remove(participant);
        this.baseJidChats.remove(C2643e.m11086d(participant));
    }

    public Chat createChat(String str) {
        return createChat(str, null);
    }

    public Chat createChat(String str, String str2, ChatMessageListener chatMessageListener) {
        if (str2 == null) {
            str2 = nextID();
        }
        if (((Chat) this.threadChats.get(str2)) != null) {
            throw new IllegalArgumentException("ThreadID is already used");
        }
        Chat createChat = createChat(str, str2, true);
        createChat.addMessageListener(chatMessageListener);
        return createChat;
    }

    public Chat createChat(String str, ChatMessageListener chatMessageListener) {
        return createChat(str, null, chatMessageListener);
    }

    PacketCollector createPacketCollector(Chat chat) {
        return connection().createPacketCollector(new AndFilter(new ThreadFilter(chat.getThreadID()), FromMatchesFilter.create(chat.getParticipant())));
    }

    public Set<ChatManagerListener> getChatListeners() {
        return Collections.unmodifiableSet(this.chatManagerListeners);
    }

    public MatchMode getMatchMode() {
        return this.matchMode;
    }

    public Chat getThreadChat(String str) {
        return (Chat) this.threadChats.get(str);
    }

    public boolean isNormalIncluded() {
        return this.normalIncluded;
    }

    public void removeChatListener(ChatManagerListener chatManagerListener) {
        this.chatManagerListeners.remove(chatManagerListener);
    }

    void sendMessage(Chat chat, Message message) {
        for (Entry entry : this.interceptors.entrySet()) {
            StanzaFilter stanzaFilter = (StanzaFilter) entry.getValue();
            if (stanzaFilter != null && stanzaFilter.accept(message)) {
                ((MessageListener) entry.getKey()).processMessage(message);
            }
        }
        if (message.getFrom() == null) {
            message.setFrom(connection().getUser());
        }
        connection().sendStanza(message);
    }

    public void setMatchMode(MatchMode matchMode) {
        this.matchMode = matchMode;
    }

    public void setNormalIncluded(boolean z) {
        this.normalIncluded = z;
    }
}
