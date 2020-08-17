package cn.bps.common.lang.security;

import java.util.List;

public class Subject {
    protected Principal principal;
    protected String source;
    protected List<String> groups;
    protected List<String> roles;
    protected List<String> privileges;

    public Subject() {
    }
}
