package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.IOException;
import java.net.Socket;
import java.util.Collection;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.XMPPException.XMPPErrorException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.Type;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.packet.XMPPError.Condition;
import org.jivesoftware.smackx.bytestreams.BytestreamRequest;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream.StreamHost;
import org.p253a.p254a.p255a.C2634a;
import org.p253a.p254a.p255a.C2635b;

public class Socks5BytestreamRequest implements BytestreamRequest {
    private static final C2634a<String, Integer> ADDRESS_BLACKLIST;
    private static final long BLACKLIST_LIFETIME = 7200000;
    private static final int BLACKLIST_MAX_SIZE = 100;
    private static int CONNECTION_FAILURE_THRESHOLD;
    private Bytestream bytestreamRequest;
    private Socks5BytestreamManager manager;
    private int minimumConnectTimeout;
    private int totalConnectTimeout;

    static {
        ADDRESS_BLACKLIST = new C2635b(BLACKLIST_MAX_SIZE, BLACKLIST_LIFETIME);
        CONNECTION_FAILURE_THRESHOLD = 2;
    }

    protected Socks5BytestreamRequest(Socks5BytestreamManager socks5BytestreamManager, Bytestream bytestream) {
        this.totalConnectTimeout = 10000;
        this.minimumConnectTimeout = 2000;
        this.manager = socks5BytestreamManager;
        this.bytestreamRequest = bytestream;
    }

    private void cancelRequest() {
        String str = "Could not establish socket with any provided host";
        XMPPError from = XMPPError.from(Condition.item_not_found, str);
        this.manager.getConnection().sendStanza(IQ.createErrorResponse(this.bytestreamRequest, from));
        throw new XMPPErrorException(str, from);
    }

    private Bytestream createUsedHostResponse(StreamHost streamHost) {
        Bytestream bytestream = new Bytestream(this.bytestreamRequest.getSessionID());
        bytestream.setTo(this.bytestreamRequest.getFrom());
        bytestream.setType(Type.result);
        bytestream.setStanzaId(this.bytestreamRequest.getStanzaId());
        bytestream.setUsedHost(streamHost.getJID());
        return bytestream;
    }

    public static int getConnectFailureThreshold() {
        return CONNECTION_FAILURE_THRESHOLD;
    }

    private int getConnectionFailures(String str) {
        Integer num = (Integer) ADDRESS_BLACKLIST.get(str);
        return num != null ? num.intValue() : 0;
    }

    private void incrementConnectionFailures(String str) {
        Integer num = (Integer) ADDRESS_BLACKLIST.get(str);
        ADDRESS_BLACKLIST.put(str, Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    public static void setConnectFailureThreshold(int i) {
        CONNECTION_FAILURE_THRESHOLD = i;
    }

    public Socks5BytestreamSession accept() {
        Socket socket;
        StreamHost streamHost = null;
        Collection<StreamHost> streamHosts = this.bytestreamRequest.getStreamHosts();
        if (streamHosts.size() == 0) {
            cancelRequest();
        }
        String createDigest = Socks5Utils.createDigest(this.bytestreamRequest.getSessionID(), this.bytestreamRequest.getFrom(), this.manager.getConnection().getUser());
        int max = Math.max(getTotalConnectTimeout() / streamHosts.size(), getMinimumConnectTimeout());
        for (StreamHost streamHost2 : streamHosts) {
            String str = streamHost2.getAddress() + ":" + streamHost2.getPort();
            int connectionFailures = getConnectionFailures(str);
            if (CONNECTION_FAILURE_THRESHOLD <= 0 || connectionFailures < CONNECTION_FAILURE_THRESHOLD) {
                try {
                    streamHost = streamHost2;
                    socket = new Socks5Client(streamHost2, createDigest).getSocket(max);
                    break;
                } catch (TimeoutException e) {
                    incrementConnectionFailures(str);
                } catch (IOException e2) {
                    incrementConnectionFailures(str);
                } catch (XMPPException e3) {
                    incrementConnectionFailures(str);
                }
            }
        }
        Object obj = streamHost;
        if (streamHost == null || socket == null) {
            cancelRequest();
        }
        this.manager.getConnection().sendStanza(createUsedHostResponse(streamHost));
        return new Socks5BytestreamSession(socket, streamHost.getJID().equals(this.bytestreamRequest.getFrom()));
    }

    public String getFrom() {
        return this.bytestreamRequest.getFrom();
    }

    public int getMinimumConnectTimeout() {
        return this.minimumConnectTimeout <= 0 ? 2000 : this.minimumConnectTimeout;
    }

    public String getSessionID() {
        return this.bytestreamRequest.getSessionID();
    }

    public int getTotalConnectTimeout() {
        return this.totalConnectTimeout <= 0 ? 10000 : this.totalConnectTimeout;
    }

    public void reject() {
        this.manager.replyRejectPacket(this.bytestreamRequest);
    }

    public void setMinimumConnectTimeout(int i) {
        this.minimumConnectTimeout = i;
    }

    public void setTotalConnectTimeout(int i) {
        this.totalConnectTimeout = i;
    }
}
