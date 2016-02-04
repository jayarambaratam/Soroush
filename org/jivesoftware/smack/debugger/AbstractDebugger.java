package org.jivesoftware.smack.debugger;

import java.io.Reader;
import java.io.Writer;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.ObservableReader;
import org.jivesoftware.smack.util.ObservableWriter;
import org.jivesoftware.smack.util.ReaderListener;
import org.jivesoftware.smack.util.WriterListener;
import org.p253a.p254a.C2643e;

public abstract class AbstractDebugger implements SmackDebugger {
    public static boolean printInterpreted;
    private final ConnectionListener connListener;
    private final XMPPConnection connection;
    private final StanzaListener listener;
    private ObservableReader reader;
    private final ReaderListener readerListener;
    private ObservableWriter writer;
    private final WriterListener writerListener;

    /* renamed from: org.jivesoftware.smack.debugger.AbstractDebugger.1 */
    class C26681 implements ReaderListener {
        final /* synthetic */ XMPPConnection val$connection;

        C26681(XMPPConnection xMPPConnection) {
            this.val$connection = xMPPConnection;
        }

        public void read(String str) {
            AbstractDebugger.this.log("RECV (" + this.val$connection.getConnectionCounter() + "): " + str);
        }
    }

    /* renamed from: org.jivesoftware.smack.debugger.AbstractDebugger.2 */
    class C26692 implements WriterListener {
        final /* synthetic */ XMPPConnection val$connection;

        C26692(XMPPConnection xMPPConnection) {
            this.val$connection = xMPPConnection;
        }

        public void write(String str) {
            AbstractDebugger.this.log("SENT (" + this.val$connection.getConnectionCounter() + "): " + str);
        }
    }

    /* renamed from: org.jivesoftware.smack.debugger.AbstractDebugger.3 */
    class C26703 implements StanzaListener {
        final /* synthetic */ XMPPConnection val$connection;

        C26703(XMPPConnection xMPPConnection) {
            this.val$connection = xMPPConnection;
        }

        public void processPacket(Stanza stanza) {
            if (AbstractDebugger.printInterpreted) {
                AbstractDebugger.this.log("RCV PKT (" + this.val$connection.getConnectionCounter() + "): " + stanza.toXML());
            }
        }
    }

    /* renamed from: org.jivesoftware.smack.debugger.AbstractDebugger.4 */
    class C26714 implements ConnectionListener {
        final /* synthetic */ XMPPConnection val$connection;

        C26714(XMPPConnection xMPPConnection) {
            this.val$connection = xMPPConnection;
        }

        public void authenticated(XMPPConnection xMPPConnection, boolean z) {
            String str = "XMPPConnection authenticated (" + xMPPConnection.getConnectionCounter() + ")";
            if (z) {
                str = str + " and resumed";
            }
            AbstractDebugger.this.log(str);
        }

        public void connected(XMPPConnection xMPPConnection) {
            AbstractDebugger.this.log("XMPPConnection connected (" + xMPPConnection.getConnectionCounter() + ")");
        }

        public void connectionClosed() {
            AbstractDebugger.this.log("XMPPConnection closed (" + this.val$connection.getConnectionCounter() + ")");
        }

        public void connectionClosedOnError(Exception exception) {
            AbstractDebugger.this.log("XMPPConnection closed due to an exception (" + this.val$connection.getConnectionCounter() + ")");
            exception.printStackTrace();
        }

        public void reconnectingIn(int i) {
            AbstractDebugger.this.log("XMPPConnection (" + this.val$connection.getConnectionCounter() + ") will reconnect in " + i);
        }

        public void reconnectionFailed(Exception exception) {
            AbstractDebugger.this.log("Reconnection failed due to an exception (" + this.val$connection.getConnectionCounter() + ")");
            exception.printStackTrace();
        }

        public void reconnectionSuccessful() {
            AbstractDebugger.this.log("XMPPConnection reconnected (" + this.val$connection.getConnectionCounter() + ")");
        }
    }

    static {
        printInterpreted = false;
    }

    public AbstractDebugger(XMPPConnection xMPPConnection, Writer writer, Reader reader) {
        this.connection = xMPPConnection;
        this.reader = new ObservableReader(reader);
        this.readerListener = new C26681(xMPPConnection);
        this.reader.addReaderListener(this.readerListener);
        this.writer = new ObservableWriter(writer);
        this.writerListener = new C26692(xMPPConnection);
        this.writer.addWriterListener(this.writerListener);
        this.listener = new C26703(xMPPConnection);
        this.connListener = new C26714(xMPPConnection);
    }

    public Reader getReader() {
        return this.reader;
    }

    public StanzaListener getReaderListener() {
        return this.listener;
    }

    public Writer getWriter() {
        return this.writer;
    }

    public StanzaListener getWriterListener() {
        return null;
    }

    protected abstract void log(String str);

    public Reader newConnectionReader(Reader reader) {
        this.reader.removeReaderListener(this.readerListener);
        ObservableReader observableReader = new ObservableReader(reader);
        observableReader.addReaderListener(this.readerListener);
        this.reader = observableReader;
        return this.reader;
    }

    public Writer newConnectionWriter(Writer writer) {
        this.writer.removeWriterListener(this.writerListener);
        ObservableWriter observableWriter = new ObservableWriter(writer);
        observableWriter.addWriterListener(this.writerListener);
        this.writer = observableWriter;
        return this.writer;
    }

    public void userHasLogged(String str) {
        String a = C2643e.m11080a(str);
        boolean equals = BuildConfig.FLAVOR.equals(a);
        StringBuilder append = new StringBuilder().append("User logged (").append(this.connection.getConnectionCounter()).append("): ");
        if (equals) {
            a = BuildConfig.FLAVOR;
        }
        log(append.append(a).append("@").append(this.connection.getServiceName()).append(":").append(this.connection.getPort()).toString() + "/" + C2643e.m11085c(str));
        this.connection.addConnectionListener(this.connListener);
    }
}
