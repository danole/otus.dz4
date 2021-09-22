package com.otus.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.otus.db.HomeworkPreparation.getRandomIntegerBetweenRange;


public class ClassForUpdateTable {

    private static final String UPDATE_GROUP_CURATOR = "UPDATE groupp SET id_curator=? WHERE id=?;";

    public void UpdateGroupCurator(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_GROUP_CURATOR)) {

            for (int i = 1; i <= 3; i++) {
                statement.setInt(1, getRandomIntegerBetweenRange(1, 4));
                statement.setInt(2, i);
                statement.executeUpdate();
            }
        }
    }
}
