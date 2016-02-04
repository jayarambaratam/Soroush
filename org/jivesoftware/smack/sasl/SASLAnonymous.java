package org.jivesoftware.smack.sasl;

import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketWriter;

public class SASLAnonymous extends SASLMechanism {
    public static final String NAME = "ANONYMOUS";

    protected void authenticateInternal(CallbackHandler callbackHandler) {
    }

    public void checkIfSuccessfulOrThrow() {
    }

    protected byte[] getAuthenticationText() {
        return null;
    }

    public String getName() {
        return NAME;
    }

    public int getPriority() {
        return PacketWriter.QUEUE_SIZE;
    }

    public SASLAnonymous newInstance() {
        return new SASLAnonymous();
    }
}
