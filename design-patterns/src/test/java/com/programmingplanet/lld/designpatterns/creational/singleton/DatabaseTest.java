package com.programmingplanet.lld.designpatterns.creational.singleton;
import org.junit.Test;

public class DatabaseTest {
    @Test
    public void testGetInstance() {
        Database databaseInstance1 = Database.getInstance();
        Database databaseInstance2 = Database.getInstance();


        assert databaseInstance1 == databaseInstance2;
    }
}
