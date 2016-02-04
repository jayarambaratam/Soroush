package org.jivesoftware.smackx.pubsub;

public enum SubscribeOptionFields {
    deliver,
    digest,
    digest_frequency,
    expire,
    include_body,
    show_values,
    subscription_type,
    subscription_depth;

    public static SubscribeOptionFields valueOfFromElement(String str) {
        String substring = str.substring(str.lastIndexOf(36));
        return "show-values".equals(substring) ? show_values : valueOf(substring);
    }

    public String getFieldName() {
        return this == show_values ? "pubsub#" + toString().replace('_', '-') : "pubsub#" + toString();
    }
}
