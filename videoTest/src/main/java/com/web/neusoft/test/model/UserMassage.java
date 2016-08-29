package com.web.neusoft.test.model;

public class UserMassage {
    private Integer id;

    private String username;

    private String identifier;

    private String memberflag;

    private String insterest;

    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    public String getMemberflag() {
        return memberflag;
    }

    public void setMemberflag(String memberflag) {
        this.memberflag = memberflag == null ? null : memberflag.trim();
    }

    public String getInsterest() {
        return insterest;
    }

    public void setInsterest(String insterest) {
        this.insterest = insterest == null ? null : insterest.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}