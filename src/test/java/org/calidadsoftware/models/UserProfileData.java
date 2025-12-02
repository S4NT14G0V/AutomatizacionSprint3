package org.calidadsoftware.models;

public class UserProfileData {
    private String username;
    private String fullname;
    private static UserProfileData last;

    public UserProfileData(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
        last = this;
    }

    public static String getLastUsernameEdited() {
        return last.username;
    }

    public static String getLastFullnameEdited() {
        return last.fullname;
    }

    public String getUsername() { return username; }
    public String getFullname() { return fullname; }
}
