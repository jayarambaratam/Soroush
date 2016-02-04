package org.linphone.core;

import org.linphone.mediastream.Version;

public enum SubscriptionState {
    None(0),
    OutoingInit(1),
    IncomingReceived(2),
    Pending(3),
    Active(4),
    Terminated(5),
    Error(6),
    Expiring(7);
    
    protected final int mValue;

    private SubscriptionState(int i) {
        this.mValue = i;
    }

    protected static SubscriptionState fromInt(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                return None;
            case VideoSize.CIF /*1*/:
                return OutoingInit;
            case VideoSize.HVGA /*2*/:
                return IncomingReceived;
            case Version.API03_CUPCAKE_15 /*3*/:
                return Pending;
            case Version.API04_DONUT_16 /*4*/:
                return Active;
            case Version.API05_ECLAIR_20 /*5*/:
                return Terminated;
            case Version.API06_ECLAIR_201 /*6*/:
                return Error;
            case Version.API07_ECLAIR_21 /*7*/:
                return Expiring;
            default:
                throw new LinphoneCoreException("Unhandled enum value " + i + " for SubscriptionState");
        }
    }
}
