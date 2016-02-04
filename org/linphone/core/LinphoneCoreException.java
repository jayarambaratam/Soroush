package org.linphone.core;

public class LinphoneCoreException extends Exception {
    public LinphoneCoreException(String str) {
        super(str);
    }

    public LinphoneCoreException(String str, Throwable th) {
        super(str, th);
    }

    public LinphoneCoreException(Throwable th) {
        super(th);
    }
}
