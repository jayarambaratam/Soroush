package org.jivesoftware.smack.sasl.provided;

import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.StringUtils;
import org.p253a.p254a.C2643e;

public class SASLExternalMechanism extends SASLMechanism {
    public static final String NAME = "EXTERNAL";

    protected void authenticateInternal(CallbackHandler callbackHandler) {
    }

    public void checkIfSuccessfulOrThrow() {
    }

    protected byte[] getAuthenticationText() {
        return StringUtils.isNullOrEmpty(this.authenticationId) ? null : SASLMechanism.toBytes(C2643e.m11081a(this.authenticationId, this.serviceName));
    }

    public String getName() {
        return NAME;
    }

    public int getPriority() {
        return 510;
    }

    protected SASLMechanism newInstance() {
        return new SASLExternalMechanism();
    }
}
