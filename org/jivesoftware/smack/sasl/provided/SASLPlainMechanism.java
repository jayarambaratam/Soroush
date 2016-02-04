package org.jivesoftware.smack.sasl.provided;

import javax.security.auth.callback.CallbackHandler;
import org.apache.http.myHttp.HttpStatus;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.ByteUtils;

public class SASLPlainMechanism extends SASLMechanism {
    public static final String NAME = "PLAIN";

    protected void authenticateInternal(CallbackHandler callbackHandler) {
        throw new UnsupportedOperationException("CallbackHandler not (yet) supported");
    }

    public void checkIfSuccessfulOrThrow() {
    }

    protected byte[] getAuthenticationText() {
        return ByteUtils.concact(SASLMechanism.toBytes('\u0000' + this.authenticationId), SASLMechanism.toBytes('\u0000' + this.password));
    }

    public String getName() {
        return NAME;
    }

    public int getPriority() {
        return HttpStatus.SC_GONE;
    }

    public SASLPlainMechanism newInstance() {
        return new SASLPlainMechanism();
    }
}
