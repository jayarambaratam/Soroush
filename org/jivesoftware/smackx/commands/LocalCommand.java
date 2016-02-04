package org.jivesoftware.smackx.commands;

import org.jivesoftware.smackx.commands.packet.AdHocCommandData;

public abstract class LocalCommand extends AdHocCommand {
    private long creationDate;
    private int currenStage;
    private String ownerJID;
    private String sessionID;

    public LocalCommand() {
        this.creationDate = System.currentTimeMillis();
        this.currenStage = -1;
    }

    void decrementStage() {
        this.currenStage--;
    }

    public long getCreationDate() {
        return this.creationDate;
    }

    public int getCurrentStage() {
        return this.currenStage;
    }

    public String getOwnerJID() {
        return this.ownerJID;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public abstract boolean hasPermission(String str);

    void incrementStage() {
        this.currenStage++;
    }

    public abstract boolean isLastStage();

    void setData(AdHocCommandData adHocCommandData) {
        adHocCommandData.setSessionID(this.sessionID);
        super.setData(adHocCommandData);
    }

    public void setOwnerJID(String str) {
        this.ownerJID = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
        getData().setSessionID(str);
    }
}
