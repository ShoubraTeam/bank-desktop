package com.bank.database;

import com.bank.config.Env;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;


public class DatabaseProvider {
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        String dbUrl = Env.getEnv().get("DB_URL");
        String dbUser = Env.getEnv().get("DB_USER");
        String dbPassword = Env.getEnv().get("DB_PASSWORD");

        if (dbUrl == null || dbUser == null || dbPassword == null) {
            throw new IllegalStateException("Database environment variables are not set");
        }

        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUser);
        config.setPassword(dbPassword);

        config.setMaximumPoolSize(5);  // default 10                    1 source pool enough
        config.setMinimumIdle(2);
        config.setIdleTimeout(60000); // default 30 seconds             value => 1 minute
        config.setConnectionTimeout(60000); // default 30 seconds       value => 1 minute
        config.setMaxLifetime(900000); // default 30 minutes        value => 15 minutes

        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    private DatabaseProvider() {}
}
// connection time out => time that a client can wait without any connection with database.
// if the time exceeded the value configured in setConnectionTimeOut() we can throw an exception.

// setIdleTimeout() configure the maximum time that a connection can be idle without any client.
// setMinimumIdle() configure the minimum idle connection pools

// setMaximumPoolSize() configure the number of pools in the connection pool area
// example: provided = 4 pools,     used = 2 pools
// default value is 10 for maximum pool size.


// setMaxLifetime() => configure the maximum lifetime of the connection in a pool
// we can connect to this pool for 30 minutes
// default value 30 minute