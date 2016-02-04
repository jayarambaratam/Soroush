package org.linphone.core;

public class LinphoneInfoMessageImpl implements LinphoneInfoMessage {
    private LinphoneContent mContent;
    protected long nativePtr;

    public LinphoneInfoMessageImpl(long j) {
        this.nativePtr = j;
        this.mContent = (LinphoneContent) getContent(this.nativePtr);
    }

    private native void addHeader(long j, String str, String str2);

    private native void delete(long j);

    private native Object getContent(long j);

    private native String getHeader(long j, String str);

    private native void setContent(long j, String str, String str2, String str3);

    public void addHeader(String str, String str2) {
        addHeader(this.nativePtr, str, str2);
    }

    protected void finalize() {
        delete(this.nativePtr);
    }

    public LinphoneContent getContent() {
        return this.mContent;
    }

    public String getHeader(String str) {
        return getHeader(this.nativePtr, str);
    }

    public void setContent(LinphoneContent linphoneContent) {
        this.mContent = linphoneContent;
        setContent(this.nativePtr, this.mContent.getType(), this.mContent.getSubtype(), this.mContent.getDataAsString());
    }
}
