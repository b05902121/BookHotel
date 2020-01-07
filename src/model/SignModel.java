package model;

import databaseUtil.DatabaseUser;

public class SignModel {
    protected DatabaseUser dbUser = null;

    protected SignModel() {
        this.dbUser = new DatabaseUser("config/jdbc.properties");
    }
}
