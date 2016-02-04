package org.jivesoftware.smack;

public abstract class AbstractConnectionClosedListener extends AbstractConnectionListener {
    public final void connectionClosed() {
        connectionTerminated();
    }

    public final void connectionClosedOnError(Exception exception) {
        connectionTerminated();
    }

    public abstract void connectionTerminated();
}
