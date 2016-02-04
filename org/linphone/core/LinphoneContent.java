package org.linphone.core;

public interface LinphoneContent {
    byte[] getData();

    String getDataAsString();

    String getEncoding();

    int getSize();

    String getSubtype();

    String getType();

    void setData(byte[] bArr);

    void setEncoding(String str);

    void setStringData(String str);

    void setSubtype(String str);

    void setType(String str);
}
