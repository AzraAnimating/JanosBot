package com.zyonicsoftware.jensbot.util;

import com.zyonicsoftware.jensbot.main.JensController;
import de.daschi.core.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class MySQLManager {

    private final MySQL mySQL;
    private final JensController jensController;
    private final HashMap<String, String> commandCache;

    public MySQLManager(JensController jensController, final String hostname, final int port, final String user, final String password, final String database) throws SQLException {
        this.jensController = jensController;
        this.mySQL = new MySQL(hostname, port, user, password, database);
        this.mySQL.openConnection();
        this.commandCache = new HashMap<>();
        this.loadFromDBIntoCache();
    }

    public boolean isConnected() throws SQLException {
        return this.mySQL.isConnectionOpen();
    }

    public void disconnect() throws SQLException {
        this.mySQL.closeConnection();
    }

    public void addNewCommand(String commandName, String commandReply) {
        try {
            if(!commandCache.containsKey(commandName)) {
                this.mySQL.executeUpdate("INSERT INTO twdcCommands(commandname, response) VALUES ('" + commandName + "','" + commandReply + "');");
                this.commandCache.put(commandName, commandReply);
            } else {
                this.mySQL.executeUpdate("UPDATE twdcCommands SET response = '" + commandReply + "' WHERE commandname = '" + commandName + "';");
                this.commandCache.put(commandName, commandReply);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeCommand(String commandName) {
        try {
            this.mySQL.executeUpdate("DELETE FROM twdcCommands WHERE commandname = '" + commandName + "';");
            this.commandCache.remove(commandName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public HashMap<String, String> getCommandCache() {
        return commandCache;
    }

    public void loadFromDBIntoCache() {
        try {
            ResultSet resultSet =this.mySQL.executeQuery("SELECT * FROM twdcCommands");
            while (resultSet.next()) {
                this.commandCache.put(resultSet.getString("commandname"), resultSet.getString("response"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
