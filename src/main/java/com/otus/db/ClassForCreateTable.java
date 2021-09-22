package com.otus.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassForCreateTable {

    private static final String CREATE_CURATOR_TABLE_SQL =
            "CREATE TABLE curator ( id INT AUTO_INCREMENT PRIMARY KEY not null," +
                    " fio VARCHAR(50) not null);";

    private static final String CREATE_GROUP_TABLE_SQL =
            "CREATE TABLE groupp ( id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    " name VARCHAR(50) NOT NULL ," +
                    " id_curator INT NOT NULL," +
                    " FOREIGN KEY (id_curator) REFERENCES curator (id))";

    private static final String CREATE_STUDENT_TABLE_SQL = "CREATE TABLE student ( id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ," +
            " fio VARCHAR(50) NOT NULL ," +
            " sex VARCHAR(1) NOT NULL ," +
            " id_group INT NOT NULL ," +
            " FOREIGN KEY (id_group) REFERENCES groupp (id));";

    public void createCuratorTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(CREATE_CURATOR_TABLE_SQL);
        }
    }

    public void createGroupTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(CREATE_GROUP_TABLE_SQL);
        }
    }

    public void createStudentTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(CREATE_STUDENT_TABLE_SQL);
        }
    }
}
