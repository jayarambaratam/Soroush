package org.linphone.core;

public interface LpConfig {
    boolean getBool(String str, String str2, boolean z);

    float getFloat(String str, String str2, float f);

    int getInt(String str, String str2, int i);

    int[] getIntRange(String str, String str2, int i, int i2);

    String getString(String str, String str2, String str3);

    void setBool(String str, String str2, boolean z);

    void setFloat(String str, String str2, float f);

    void setInt(String str, String str2, int i);

    void setIntRange(String str, String str2, int i, int i2);

    void setString(String str, String str2, String str3);

    void sync();
}
