package com.otus.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import static com.otus.db.HomeworkPreparation.getRandomIntegerBetweenRange;

public class ClassForInsertData {

    private static final String INSERT_INTO_CURATOR_SQL =
            "INSERT INTO curator (fio) VALUES (?);";

    private static final String INSERT_INTO_GROUP_SQL =
            "INSERT INTO groupp (name, id_curator) VALUES (?, ?);";

    private static final String INSERT_INTO_STUDENT_SQL =
            "INSERT INTO student (fio, sex, id_group) VALUES (?, ?, ?);";

    public void insertDataIntoCuratorTable(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_INTO_CURATOR_SQL)) {

            for (int i = 1; i <= 4; i++) {
                statement.setString(1, "curator name " + i + " family " + i);
                statement.executeUpdate();
            }
        }
    }


    public void insertDataIntoGroupTable(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_INTO_GROUP_SQL)) {

            for (int i = 1; i <= 3; i++) {
                statement.setString(1, "group " + i);
                statement.setInt(2, getRandomIntegerBetweenRange(1, 4));
                statement.executeUpdate();
            }
        }
    }

    public void insertDataIntoStudentTable(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_INTO_STUDENT_SQL)) {

            Random random = new Random();

            for (int i = 1; i <= 15; i++) {

                boolean rand = random.nextBoolean();
                String sex;

                if (rand) {
                    sex = "F";
                } else {
                    sex = "M";
                }

                statement.setString(1, "student name " + i + " family " + i);
                statement.setString(2, sex);
                statement.setInt(3, getRandomIntegerBetweenRange(1, 3));
                statement.executeUpdate();
            }
        }
    }
}
