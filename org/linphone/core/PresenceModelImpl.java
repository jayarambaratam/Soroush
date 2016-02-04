package org.linphone.core;

public class PresenceModelImpl implements PresenceModel {
    private long mNativePtr;

    protected PresenceModelImpl() {
        this.mNativePtr = newPresenceModelImpl();
    }

    protected PresenceModelImpl(long j) {
        this.mNativePtr = j;
    }

    protected PresenceModelImpl(PresenceActivityType presenceActivityType, String str) {
        this.mNativePtr = newPresenceModelImpl(presenceActivityType.toInt(), str);
    }

    protected PresenceModelImpl(PresenceActivityType presenceActivityType, String str, String str2, String str3) {
        this.mNativePtr = newPresenceModelImpl(presenceActivityType.toInt(), str, str2, str3);
    }

    private native int addActivity(long j, long j2);

    private native int addNote(long j, String str, String str2);

    private native int addPerson(long j, long j2);

    private native int addService(long j, long j2);

    private native int clearActivities(long j);

    private native int clearNotes(long j);

    private native int clearPersons(long j);

    private native int clearServices(long j);

    private native Object getActivity(long j);

    private native int getBasicStatus(long j);

    private native String getContact(long j);

    private native long getNbActivities(long j);

    private native long getNbPersons(long j);

    private native long getNbServices(long j);

    private native Object getNote(long j, String str);

    private native Object getNthActivity(long j, long j2);

    private native Object getNthPerson(long j, long j2);

    private native Object getNthService(long j, long j2);

    private native long getTimestamp(long j);

    private native long newPresenceModelImpl();

    private native long newPresenceModelImpl(int i, String str);

    private native long newPresenceModelImpl(int i, String str, String str2, String str3);

    private native int setActivity(long j, int i, String str);

    private native int setBasicStatus(long j, int i);

    private native void setContact(long j, String str);

    private native void unref(long j);

    public int addActivity(PresenceActivity presenceActivity) {
        return addActivity(this.mNativePtr, presenceActivity.getNativePtr());
    }

    public int addNote(String str, String str2) {
        return addNote(this.mNativePtr, str, str2);
    }

    public int addPerson(PresencePerson presencePerson) {
        return addPerson(this.mNativePtr, presencePerson.getNativePtr());
    }

    public int addService(PresenceService presenceService) {
        return addService(this.mNativePtr, presenceService.getNativePtr());
    }

    public int clearActivities() {
        return clearActivities(this.mNativePtr);
    }

    public int clearNotes() {
        return clearNotes(this.mNativePtr);
    }

    public int clearPersons() {
        return clearPersons(this.mNativePtr);
    }

    public int clearServices() {
        return clearServices(this.mNativePtr);
    }

    protected void finalize() {
        unref(this.mNativePtr);
    }

    public PresenceActivity getActivity() {
        return (PresenceActivity) getActivity(this.mNativePtr);
    }

    public PresenceBasicStatus getBasicStatus() {
        return PresenceBasicStatus.fromInt(getBasicStatus(this.mNativePtr));
    }

    public String getContact() {
        return getContact(this.mNativePtr);
    }

    public long getNativePtr() {
        return this.mNativePtr;
    }

    public long getNbActivities() {
        return getNbActivities(this.mNativePtr);
    }

    public long getNbPersons() {
        return getNbPersons(this.mNativePtr);
    }

    public long getNbServices() {
        return getNbServices(this.mNativePtr);
    }

    public PresenceNote getNote(String str) {
        return (PresenceNote) getNote(this.mNativePtr, str);
    }

    public PresenceActivity getNthActivity(long j) {
        return (PresenceActivity) getNthActivity(this.mNativePtr, j);
    }

    public PresencePerson getNthPerson(long j) {
        return (PresencePerson) getNthPerson(this.mNativePtr, j);
    }

    public PresenceService getNthService(long j) {
        return (PresenceService) getNthService(this.mNativePtr, j);
    }

    public long getTimestamp() {
        return getTimestamp(this.mNativePtr);
    }

    public int setActivity(PresenceActivityType presenceActivityType, String str) {
        return setActivity(this.mNativePtr, presenceActivityType.toInt(), str);
    }

    public int setBasicStatus(PresenceBasicStatus presenceBasicStatus) {
        return setBasicStatus(this.mNativePtr, presenceBasicStatus.toInt());
    }

    public void setContact(String str) {
        setContact(this.mNativePtr, str);
    }
}
