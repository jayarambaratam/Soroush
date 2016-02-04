package org.jivesoftware.smack.iqrequest;

import org.jivesoftware.smack.iqrequest.IQRequestHandler.Mode;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.Type;
import org.linphone.core.VideoSize;

public abstract class AbstractIqRequestHandler implements IQRequestHandler {
    private final String element;
    private final Mode mode;
    private final String namespace;
    private final Type type;

    /* renamed from: org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler.1 */
    /* synthetic */ class C26721 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        static {
            $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = new int[Type.values().length];
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[Type.set.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[Type.get.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    protected AbstractIqRequestHandler(String str, String str2, Type type, Mode mode) {
        switch (C26721.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[type.ordinal()]) {
            case VideoSize.CIF /*1*/:
            case VideoSize.HVGA /*2*/:
                this.element = str;
                this.namespace = str2;
                this.type = type;
                this.mode = mode;
            default:
                throw new IllegalArgumentException("Only get and set IQ type allowed");
        }
    }

    public String getElement() {
        return this.element;
    }

    public Mode getMode() {
        return this.mode;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public Type getType() {
        return this.type;
    }

    public abstract IQ handleIQRequest(IQ iq);
}
