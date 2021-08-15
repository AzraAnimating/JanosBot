package com.zyonicsoftware.jensbot.main;

import com.zyonicsoftware.jensbot.discord.JensDiscordBot;
import com.zyonicsoftware.jensbot.util.Config;
import com.zyonicsoftware.jensbot.util.ConfigReader;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

public class Initializer {

    public static void main(String[] args) {
        Config config = new Config();
        ConfigReader configReader = new ConfigReader();
        configReader.loadConfig(config);
        System.out.println(config.getDiscordToken());
        try {
            JensController jensController = new JensController(config);
        } catch (LoginException | SQLException e) {
            e.printStackTrace();
        }
    }

}