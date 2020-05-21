package me.lucashagen.mcstats.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.lucashagen.mcstats.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;

public class MySQLDatabase implements AutoCloseable {

    /**
     * Hikari Configuration
     */
    private final HikariConfig config = new HikariConfig();

    /**
     * Hikari Connection Pool
     */
    private HikariDataSource dataSource;

    /**
     * Thread pool for async executions
     */
    private Executor asyncExecutor;

    /**
     * Constructs a DatabaseConn and initializes the connection pool.
     *
     * @param host     MySQL host, ip and port (example: localhost:3306)
     * @param database MySQL database name
     * @param username MySQL username
     * @param password MySQL password
     */
    public MySQLDatabase(String host, String database, String username,
                         String password) {
        config.setJdbcUrl("jdbc:mysql://" + host + "/" + database);
        config.setUsername(username);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("allowPublicKeyRetrieval", true);
        config.addDataSourceProperty("useSSL", false);
    }

    public void initialize() throws IOException {
        dataSource = new HikariDataSource(config);
        asyncExecutor = Executors.newCachedThreadPool();

        createTablesIfNotExist();
    }

    /**
     * Creates all necessary tables
     */
    private void createTablesIfNotExist() throws IOException {
        String command = getCreateTablesCommand();

        executeUpdate(command);
    }

    /**
     * Loads the command to create the MySQL tables from the 'create_tables.sql'
     * file.
     *
     * @return Whole file content
     * @throws IOException Error reading file
     */
    private String getCreateTablesCommand() throws IOException {
        InputStream in = getClass().getResourceAsStream("/create_tables.sql");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder commandBuilder = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            commandBuilder.append(line).append("\n");
        }
        reader.close();
        in.close();

        return commandBuilder.toString();
    }

    /**
     * Run update queries.
     * Every query is run sequentially.
     *
     * @param queries Queries
     * @return if the updated succeed
     */
    public boolean executeUpdate(String... queries) {
        boolean success = true;

        try (Connection conn = dataSource.getConnection()) {
            for (String query : queries) {
                PreparedStatement st = conn.prepareStatement(query);
                st.executeUpdate();

                st.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            Main.getAPI().log(Level.SEVERE, "MYSQL ERROR: " + exception.getErrorCode());
            success = false;
        }

        return true;
    }

    /**
     * Run update queries asynchronously.
     * A new Thread is used to run all queries sequentially.
     *
     * @param queries Queries
     */
    public void executeUpdateAsync(String... queries) {
        asyncExecutor.execute(() -> {
            executeUpdate(queries);
        });
    }

    /**
     * Closes the connection pool
     *
     * @throws Exception Exception
     */
    @Override
    public void close() throws Exception {
        dataSource.close();
    }
}
