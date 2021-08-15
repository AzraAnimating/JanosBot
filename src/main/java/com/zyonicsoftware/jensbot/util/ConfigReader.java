package com.zyonicsoftware.jensbot.util;

import com.zyonicsoftware.jensbot.main.JensController;
import org.simpleyaml.configuration.file.YamlConfiguration;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.File;

public class ConfigReader {

    public void loadConfig(Config config) {
        try {

            final File configFile = new File("config.yml");

            if(!configFile.createNewFile()) {

                final YamlFile yamlFile = new YamlFile(configFile);
                yamlFile.load();

                config.setDiscordToken(yamlFile.getString("discordToken"));
                config.setTwitchAccessToken(yamlFile.getString("twitchAccessToken"));
                config.setTwitchClientID(yamlFile.getString("twitchClientID"));
                config.setTwitchClientSecret(yamlFile.getString("twitchClientSecret"));
                config.setMySQLHost(yamlFile.getString("mySQLHost"));
                config.setMySQLPort(yamlFile.getInt("mySQLPort"));
                config.setMySQLDatabase(yamlFile.getString("mySQLDatabase"));
                config.setMySQLUser(yamlFile.getString("mySQLUsername"));
                config.setMySQLPassword(yamlFile.getString("mySQLPassword"));
                config.setApiPort(yamlFile.getInt("apiPort"));
            } else {

                final YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(configFile);

                yamlConfiguration.createSection("discordToken");
                yamlConfiguration.set("discordToken", "token");
                yamlConfiguration.createSection("twitchAccessToken");
                yamlConfiguration.set("twitchAccessToken", "token");
                yamlConfiguration.createSection("twitchClientID");
                yamlConfiguration.set("twitchClientID", "clientid");
                yamlConfiguration.createSection("twitchClientSecret");
                yamlConfiguration.set("twitchClientSecret", "secret");
                yamlConfiguration.createSection("mySQLHost");
                yamlConfiguration.set("mySQLHost", "0.0.0.0");
                yamlConfiguration.createSection("mySQLPort");
                yamlConfiguration.set("mySQLPort", "3306");
                yamlConfiguration.createSection("mySQLDatabase");
                yamlConfiguration.set("mySQLDatabase", "JENSI");
                yamlConfiguration.createSection("mySQLUsername");
                yamlConfiguration.set("mySQLUsername", "Janos");
                yamlConfiguration.createSection("mySQLPassword");
                yamlConfiguration.set("mySQLPassword", "please_use_a_safe_password");
                yamlConfiguration.createSection("apiPort");
                yamlConfiguration.set("apiPort", 1234);
                yamlConfiguration.createSection("allowedTokens");
                yamlConfiguration.set("allowedTokens", "irgendwelche_Tokens_seperiert_mit_;");

                yamlConfiguration.save(configFile);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
