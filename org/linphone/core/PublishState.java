package org.linphone.core;

import org.linphone.mediastream.Version;

public enum PublishState {
    None(0),
    Progress(1),
    Ok(2),
    Error(3),
    Expiring(4),
    Cleared(5);
    
    protected final int mValue;

    private PublishState(int i) {
        this.mValue = i;
    }

    protected static PublishState fromInt(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                return None;
            case VideoSize.CIF /*1*/:
                return Progress;
            case VideoSize.HVGA /*2*/:
                return Ok;
            case Version.API03_CUPCAKE_15 /*3*/:
                return Error;
            case Version.API04_DONUT_16 /*4*/:
                return Expiring;
            case Version.API05_ECLAIR_20 /*5*/:
                return Cleared;
            default:
                throw new LinphoneCoreException("Unhandled enum value " + i + " for PublishState");
        }
    }
}
