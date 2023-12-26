package com.programmingplanet.lld.designpatterns.creational.Builder;

import com.programmingplanet.lld.designpatterns.creational.DatabaseType;

import lombok.Getter;

@Getter
public class Database {
    String name;
    String hostname;
    int port;
    String username;
    String password;
    DatabaseType type;

    private Database() {
        
    }

    static class Builder {
        private Database database;
        
        public Builder() {
            database = new Database();
        }

        public Builder name(String name) {
            database.name = name;
            return this;
        }

        public Builder hostname(String hostname) {
            database.hostname = hostname;
            return this;
        }

        public Builder port(int port) {
            database.port = port;
            return this;
        }

        public Builder withCredentials(String username, String password) {
            database.username = username;
            database.password = password;
            return this;
        }

        public Builder MYSQL() {
            database.type = DatabaseType.MYSQL;
            if (database.port == 0) {
                database.port = 3306;
            }
            return this;
        }

        public Builder POSTGRESQL() {
            database.type = DatabaseType.POSTGRESQL;
            if (database.port == 0) {
                database.port = 5432;
            }
            return this;
        }

        private Boolean validate() {
            if (database.name == null || database.name.isEmpty()) {
                return false;
            }
            if (database.hostname == null || database.hostname.isEmpty()) {
                return false;
            }
            if (database.port == 0) {
                return false;
            }
            if (database.username == null || database.username.isEmpty()) {
                return false;
            }
            if (database.password == null || database.password.isEmpty()) {
                return false;
            }
            if (database.type == null) {
                return false;
            }
            return true;
        }

        public Database build() {
            // Clean the reference to the database and generate a new one
            if (!validate()) {
                throw new RuntimeException("Invalid database configuration");
            }
            Database returnDatabase = database;
            database = new Database();
            return returnDatabase;
        }
    }

}
