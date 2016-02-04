package org.linphone.core;

public interface PresenceActivity {
    String getDescription();

    long getNativePtr();

    PresenceActivityType getType();

    int setDescription(String str);

    int setType(PresenceActivityType presenceActivityType);

    String toString();
}
