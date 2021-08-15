package com.zyonicsoftware.jensbot.main;

import com.zyonicsoftware.jensbot.discord.JensDiscordBot;
import com.zyonicsoftware.jensbot.util.Config;
import com.zyonicsoftware.jensbot.util.MySQLManager;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class JensController {

    private JensDiscordBot jensDiscordBot;
    private MySQLManager mySQLManager;
    private Timer timer;

    public JensController(Config config) throws LoginException, SQLException {
        //this.initTwitch(config);
        this.initDiscord(config.getDiscordToken());
        this.mySQLManager = new MySQLManager(this, config.getMySQLHost(), config.getMySQLPort(), config.getMySQLUser(), config.getMySQLPassword(), config.getMySQLDatabase());
        //this.timer = new Timer();
        //this.startScheduledTask();
    }

    private void initDiscord(String token) throws LoginException {
        this.jensDiscordBot = new JensDiscordBot(token, this);
    }

    public JensDiscordBot getJensDiscordBot() {
        return jensDiscordBot;
    }

    public MySQLManager getMySQLManager() {
        return mySQLManager;
    }

    private void startScheduledTask() {
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mySQLManager.loadFromDBIntoCache();
            }
        }, 600000, 600000);
    }
}
