package com.zyonicsoftware.jensbot.util;

import java.util.ArrayList;
import java.util.Arrays;

public class Config {

    private String discordToken;
    private String twitchAccessToken;
    private String twitchClientID;
    private String twitchClientSecret;
    private String mySQLHost;
    private int mySQLPort;
    private String mySQLDatabase;
    private String mySQLUser;
    private String mySQLPassword;
    private int port;

    public int getMySQLPort() {
        return mySQLPort;
    }

    public String getDiscordToken() {
        return discordToken;
    }

    public String getMySQLHost() {
        return mySQLHost;
    }

    public String getMySQLPassword() {
        return mySQLPassword;
    }

    public String getMySQLUser() {
        return mySQLUser;
    }

    public String getTwitchAccessToken() {
        return twitchAccessToken;
    }

    public String getTwitchClientID() {
        return twitchClientID;
    }

    public String getTwitchClientSecret() {
        return twitchClientSecret;
    }

    public String getMySQLDatabase() {
        return mySQLDatabase;
    }

    public void setDiscordToken(String discordToken) {
        this.discordToken = discordToken;
    }

    public void setMySQLHost(String mySQLHost) {
        this.mySQLHost = mySQLHost;
    }

    public void setMySQLPassword(String mySQLPassword) {
        this.mySQLPassword = mySQLPassword;
    }

    public void setMySQLPort(int mySQLPort) {
        this.mySQLPort = mySQLPort;
    }

    public void setMySQLUser(String mySQLUser) {
        this.mySQLUser = mySQLUser;
    }

    public void setTwitchAccessToken(String twitchAccessToken) {
        this.twitchAccessToken = twitchAccessToken;
    }

    public void setTwitchClientID(String twitchClientID) {
        this.twitchClientID = twitchClientID;
    }

    public void setTwitchClientSecret(String twitchClientSecret) {
        this.twitchClientSecret = twitchClientSecret;
    }

    public void setMySQLDatabase(String mySQLDatabase) {
        this.mySQLDatabase = mySQLDatabase;
    }

    public void setApiPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
}
