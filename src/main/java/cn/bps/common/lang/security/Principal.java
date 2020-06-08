package cn.bps.common.lang.security;

public class Principal {

    protected String id;
    protected String username;
    protected String currentGroup;

    public Principal() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrentGroup() {
        return this.currentGroup;
    }

    public void setCurrentGroup(String currentGroup) {
        this.currentGroup = currentGroup;
    }

}
