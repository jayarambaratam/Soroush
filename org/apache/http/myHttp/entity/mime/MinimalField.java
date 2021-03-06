package org.apache.http.myHttp.entity.mime;

public class MinimalField {
    private final String name;
    private final String value;

    public MinimalField(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public String getBody() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(": ");
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }
}
