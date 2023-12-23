package com.programmingplanet.lld.designpatterns.creational.Builder;

import org.junit.Test;

import com.programmingplanet.lld.designpatterns.DatabaseType;

public class DatabaseTest {
    @Test
    public void testBuild() {
        Database.Builder databaseBuilder = new Database.Builder();
        databaseBuilder
                    .name("Indian Railways")
                    .MYSQL()
                    .hostname("localhost")
                    .withCredentials("nikhil", "password");

        Database database = databaseBuilder.build();

        databaseBuilder
                    .name("Central Railways")
                    .POSTGRESQL();

        Database database1 = databaseBuilder.build();

        assert database != database1;
        assert database.getName().equals("Indian Railways");
        assert database1.getName().equals("Central Railways");
        assert database.getType() == DatabaseType.MYSQL;
        assert database1.getType() == DatabaseType.POSTGRESQL;
        assert database1.getPort() == 5432;


    }
}
