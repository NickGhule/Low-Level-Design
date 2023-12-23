package com.programmingplanet.lld.designpatterns.creational.singleton;
import com.programmingplanet.lld.designpatterns.DatabaseType;

import lombok.*;


// Singleton pattern with Tread safe lazy initialization
@Getter
@Setter
public class Database {
    private static Database INSTANCE;

    String name;
    String hostname;
    int port;
    String username;
    String password;
    DatabaseType type;

    public static Database getInstance() {
        // Thread safe Lazy initialization
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Database();
                }
            }
        }
        return INSTANCE;
    }

    private Database() {
       // Private constructor
    }
}
