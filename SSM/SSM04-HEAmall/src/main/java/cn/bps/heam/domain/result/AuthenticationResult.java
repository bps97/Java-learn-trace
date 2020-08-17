package cn.bps.heam.domain.result;

import java.util.List;

public class AuthenticationResult {

    private String id;

    private String authName;

    private String path;

    private List<AuthenticationResult> children;

    private Integer index;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<AuthenticationResult> getChildren() {
        return children;
    }

    public void setChildren(List<AuthenticationResult> children) {
        this.children = children;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
