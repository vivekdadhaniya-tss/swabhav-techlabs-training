package com.tss.Creational.Singleton;

public class DatabaseConnection {

    private DatabaseConnection() {
    }

    private static class DBHelper {
        private static final DatabaseConnection INSTANCE =
                new DatabaseConnection();
    }

    public static DatabaseConnection getInstance() {
        return DBHelper.INSTANCE;
    }
}
