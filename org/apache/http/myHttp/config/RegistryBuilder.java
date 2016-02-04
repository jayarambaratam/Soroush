package org.apache.http.myHttp.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.util.Args;

@NotThreadSafe
public final class RegistryBuilder<I> {
    private final Map<String, I> items;

    RegistryBuilder() {
        this.items = new HashMap();
    }

    public static <I> RegistryBuilder<I> create() {
        return new RegistryBuilder();
    }

    public Registry<I> build() {
        return new Registry(this.items);
    }

    public RegistryBuilder<I> register(String str, I i) {
        Args.notEmpty((CharSequence) str, "ID");
        Args.notNull(i, "Item");
        this.items.put(str.toLowerCase(Locale.US), i);
        return this;
    }

    public String toString() {
        return this.items.toString();
    }
}
