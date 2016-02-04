package org.linphone;

public class LinphoneException extends Exception {
    public LinphoneException(String str) {
        super(str);
    }

    public LinphoneException(String str, Throwable th) {
        super(str, th);
    }

    public LinphoneException(Throwable th) {
        super(th);
    }
}
