package org.jivesoftware.smackx.filetransfer;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler.Mode;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.Type;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.packet.XMPPError.Condition;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.p253a.p254a.C2643e;

public class FileTransferManager extends Manager {
    private static final Map<XMPPConnection, FileTransferManager> INSTANCES;
    private final FileTransferNegotiator fileTransferNegotiator;
    private final List<FileTransferListener> listeners;

    /* renamed from: org.jivesoftware.smackx.filetransfer.FileTransferManager.1 */
    class C27311 extends AbstractIqRequestHandler {
        C27311(String str, String str2, Type type, Mode mode) {
            super(str, str2, type, mode);
        }

        public IQ handleIQRequest(IQ iq) {
            FileTransferRequest fileTransferRequest = new FileTransferRequest(FileTransferManager.this, (StreamInitiation) iq);
            for (FileTransferListener fileTransferRequest2 : FileTransferManager.this.listeners) {
                fileTransferRequest2.fileTransferRequest(fileTransferRequest);
            }
            return null;
        }
    }

    static {
        INSTANCES = new WeakHashMap();
    }

    private FileTransferManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.listeners = new CopyOnWriteArrayList();
        this.fileTransferNegotiator = FileTransferNegotiator.getInstanceFor(xMPPConnection);
        xMPPConnection.registerIQRequestHandler(new C27311(StreamInitiation.ELEMENT, StreamInitiation.NAMESPACE, Type.set, Mode.async));
    }

    public static synchronized FileTransferManager getInstanceFor(XMPPConnection xMPPConnection) {
        FileTransferManager fileTransferManager;
        synchronized (FileTransferManager.class) {
            fileTransferManager = (FileTransferManager) INSTANCES.get(xMPPConnection);
            if (fileTransferManager == null) {
                fileTransferManager = new FileTransferManager(xMPPConnection);
                INSTANCES.put(xMPPConnection, fileTransferManager);
            }
        }
        return fileTransferManager;
    }

    public void addFileTransferListener(FileTransferListener fileTransferListener) {
        this.listeners.add(fileTransferListener);
    }

    protected IncomingFileTransfer createIncomingFileTransfer(FileTransferRequest fileTransferRequest) {
        if (fileTransferRequest == null) {
            throw new NullPointerException("RecieveRequest cannot be null");
        }
        IncomingFileTransfer incomingFileTransfer = new IncomingFileTransfer(fileTransferRequest, this.fileTransferNegotiator);
        incomingFileTransfer.setFileInfo(fileTransferRequest.getFileName(), fileTransferRequest.getFileSize());
        return incomingFileTransfer;
    }

    public OutgoingFileTransfer createOutgoingFileTransfer(String str) {
        if (str == null) {
            throw new IllegalArgumentException("userID was null");
        } else if (C2643e.m11087e(str)) {
            return new OutgoingFileTransfer(connection().getUser(), str, this.fileTransferNegotiator.getNextStreamID(), this.fileTransferNegotiator);
        } else {
            throw new IllegalArgumentException("The provided user id was not a full JID (i.e. with resource part)");
        }
    }

    protected void rejectIncomingFileTransfer(FileTransferRequest fileTransferRequest) {
        connection().sendStanza(IQ.createErrorResponse(fileTransferRequest.getStreamInitiation(), new XMPPError(Condition.forbidden)));
    }

    public void removeFileTransferListener(FileTransferListener fileTransferListener) {
        this.listeners.remove(fileTransferListener);
    }
}
