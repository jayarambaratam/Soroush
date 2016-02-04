package org.jivesoftware.smackx.bookmarks;

public class BookmarkedConference implements SharedBookmark {
    private boolean autoJoin;
    private boolean isShared;
    private final String jid;
    private String name;
    private String nickname;
    private String password;

    protected BookmarkedConference(String str) {
        this.jid = str;
    }

    protected BookmarkedConference(String str, String str2, boolean z, String str3, String str4) {
        this.name = str;
        this.jid = str2;
        this.autoJoin = z;
        this.nickname = str3;
        this.password = str4;
    }

    public boolean equals(Object obj) {
        return (obj == null || !(obj instanceof BookmarkedConference)) ? false : ((BookmarkedConference) obj).getJid().equalsIgnoreCase(this.jid);
    }

    public String getJid() {
        return this.jid;
    }

    public String getName() {
        return this.name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isAutoJoin() {
        return this.autoJoin;
    }

    public boolean isShared() {
        return this.isShared;
    }

    protected void setAutoJoin(boolean z) {
        this.autoJoin = z;
    }

    protected void setName(String str) {
        this.name = str;
    }

    protected void setNickname(String str) {
        this.nickname = str;
    }

    protected void setPassword(String str) {
        this.password = str;
    }

    protected void setShared(boolean z) {
        this.isShared = z;
    }
}
