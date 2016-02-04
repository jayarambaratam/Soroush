package org.linphone.core;

public interface PresencePerson {
    int addActivitiesNote(PresenceNote presenceNote);

    int addActivity(PresenceActivity presenceActivity);

    int addNote(PresenceNote presenceNote);

    int clearActivitesNotes();

    int clearActivities();

    int clearNotes();

    String getId();

    long getNativePtr();

    long getNbActivities();

    long getNbActivitiesNotes();

    long getNbNotes();

    PresenceNote getNthActivitiesNote(long j);

    PresenceActivity getNthActivity(long j);

    PresenceNote getNthNote(long j);

    int setId(String str);
}
