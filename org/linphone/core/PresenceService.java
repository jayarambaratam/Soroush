package org.linphone.core;

public interface PresenceService {
    int addNote(PresenceNote presenceNote);

    int clearNotes();

    PresenceBasicStatus getBasicStatus();

    String getContact();

    String getId();

    long getNativePtr();

    long getNbNotes();

    PresenceNote getNthNote(long j);

    int setBasicStatus(PresenceBasicStatus presenceBasicStatus);

    int setContact(String str);

    int setId(String str);
}
