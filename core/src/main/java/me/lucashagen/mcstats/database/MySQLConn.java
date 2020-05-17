package me.lucashagen.mcstats.database;

import me.lucashagen.mcstats.Main;
import me.lucashagen.mcstats.api.Lang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class MySQLConn {

    private String hostname;
    private String database;

    private String username;
    private String password;

    private Connection conn;

    public MySQLConn(String hostname, String database, String username,
                     String password) {
        this.hostname = hostname;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            this.conn = DriverManager.getConnection(
                    String.format("jdbc:mysql://%s/%s", hostname, database),
                    username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Main.getAPI().log(Level.SEVERE,
                    Lang.ERROR_CONSOLE.getMessage(ex.getMessage(),
                            ex.toString()));
        }
    }

}
