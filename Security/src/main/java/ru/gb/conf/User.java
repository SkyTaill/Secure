package ru.gb.conf;

public class User {
    private String userRights ="user";
    private String userLoggin="1";
    private String userPassword="1";
    private String adminRights ="ADMIN";
    private String adminLoggin="2";
    private String adminPassword="2";

    public String getUserRights() {
        return userRights;
    }

    public String getUserLoggin() {
        return userLoggin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getAdminRights() {
        return adminRights;
    }

    public String getAdminLoggin() {
        return adminLoggin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userRights='" + userRights + '\'' +
                ", userLoggin='" + userLoggin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", adminRights='" + adminRights + '\'' +
                ", adminLoggin='" + adminLoggin + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}
