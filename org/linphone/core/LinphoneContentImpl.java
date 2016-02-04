package org.linphone.core;

public class LinphoneContentImpl implements LinphoneContent {
    private byte[] mData;
    private String mEncoding;
    private String mSubtype;
    private String mType;

    public LinphoneContentImpl(String str, String str2, byte[] bArr, String str3) {
        this.mType = str;
        this.mSubtype = str2;
        this.mData = bArr;
        this.mEncoding = str3;
    }

    public byte[] getData() {
        return this.mData;
    }

    public String getDataAsString() {
        return new String(this.mData);
    }

    public String getEncoding() {
        return this.mEncoding;
    }

    public int getSize() {
        return this.mData.length;
    }

    public String getSubtype() {
        return this.mSubtype;
    }

    public String getType() {
        return this.mType;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setEncoding(String str) {
        this.mEncoding = str;
    }

    public void setStringData(String str) {
        this.mData = str.getBytes();
    }

    public void setSubtype(String str) {
        this.mSubtype = str;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
