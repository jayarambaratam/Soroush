package org.linphone.core;

public interface PresenceModel {
    int addActivity(PresenceActivity presenceActivity);

    int addNote(String str, String str2);

    int addPerson(PresencePerson presencePerson);

    int addService(PresenceService presenceService);

    int clearActivities();

    int clearNotes();

    int clearPersons();

    int clearServices();

    PresenceActivity getActivity();

    PresenceBasicStatus getBasicStatus();

    String getContact();

    long getNbActivities();

    long getNbPersons();

    long getNbServices();

    PresenceNote getNote(String str);

    PresenceActivity getNthActivity(long j);

    PresencePerson getNthPerson(long j);

    PresenceService getNthService(long j);

    long getTimestamp();

    int setActivity(PresenceActivityType presenceActivityType, String str);

    int setBasicStatus(PresenceBasicStatus presenceBasicStatus);

    void setContact(String str);
}
