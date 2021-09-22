package com.otus.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassForSelectData {

    private static final String GET_GROUP_WITH_CURATOR = "SELECT g.id,g.name,c.fio " +
            "FROM groupp as g JOIN curator as c ON g.id_curator=c.id ORDER BY g.id ASC";

    private static final String GET_STUDENTS_WITH_GROUP_AND_CURATOR = "SELECT s.id,s.fio,s.sex,g.name,c.fio" +
            " FROM student as s JOIN groupp as g ON s.id_group=g.id" +
            " JOIN curator as c ON g.id_curator=c.id ORDER BY s.id ASC;";

    private static final String GET_COUNT_STUDENT = "SELECT COUNT(id) FROM student;";

    private static final String GET_FEMALE_STUDENT = "SELECT fio FROM student WHERE sex='F';";

    private static final String group = "group 2";  // Вводить группу, по названию которой искать студентов

    private static final String GET_STUDENT_FROM_GROUP = "SELECT fio " +
            "FROM student WHERE id_group=(SELECT id FROM groupp WHERE name='" + group + "' )";

    public void printGroupWithCurator(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_GROUP_WITH_CURATOR);

        while (resultSet.next()) {
            int idGroup = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String fio = resultSet.getString(3);

            String row = String.format("ID: %s, NAME: %s, FIO: %s;", idGroup, name, fio);
            System.out.println(row);
        }

    }

    public void printStudentsWithGroupAndCurator(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_STUDENTS_WITH_GROUP_AND_CURATOR);

        while (resultSet.next()) {
            int idGroup = resultSet.getInt(1);
            String fio = resultSet.getString(2);
            String sex = resultSet.getString(3);
            String name = resultSet.getString(4);
            String fioCurator = resultSet.getString(5);

            String row = String.format("ID: %s, StudentName: %s, Sex: %s, GroupName: %s, CuratorName: %s ;", idGroup, fio, sex, name, fioCurator);
            System.out.println(row);
        }

    }

    public void printCountStudents(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_COUNT_STUDENT);

        while (resultSet.next()) {
            int count = resultSet.getInt(1);

            String row = String.format("CountStudent: %s ;", count);
            System.out.println(row);
        }

    }

    public void printFemaleStudents(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_FEMALE_STUDENT);

        while (resultSet.next()) {
            String fio = resultSet.getString(1);

            String row = String.format("NameFemaleStudent: %s ;", fio);
            System.out.println(row);
        }

    }

    public void printStudentsFromGroup(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_STUDENT_FROM_GROUP);

        while (resultSet.next()) {
            String fio = resultSet.getString(1);
            String row = String.format("StudentsFromGroup: %s ;", fio);
            System.out.println(row);
        }
    }
}
