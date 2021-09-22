package com.otus.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Создать таблицу Student Колонки id, fio, sex, id_group
//
//Создать таблицу Group Колонки id, name, id_curator
//
//Создать таблицу Curator Колонки id, fio
//
//Заполнить таблицы данными(15 студентов, 3 группы, 4 куратора)
//
//Вывести на экран информацию о всех студентах включая название группы и имя куратора
//
//Вывести на экран количество студентов
//
//Вывести студенток
//
//Обновить данные по группе сменив куратора
//
//Вывести список групп с их кураторами
//
//Используя вложенные запросы вывести на экран студентов из определенной группы(поиск по имени группы)

public class HomeworkPreparation {

    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/dz4";
    private static final String USER = "root";
    private static final String PASSWORD = "supersicret";

    public static int getRandomIntegerBetweenRange(int min, int max) {
        int x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    public static void main(String[] args) throws SQLException {

        ClassForCreateTable classForCreateTable = new ClassForCreateTable();
        ClassForInsertData classForInsertData = new ClassForInsertData();
        ClassForSelectData classForSelectData = new ClassForSelectData();
        ClassForUpdateTable classForUpdateTable = new ClassForUpdateTable();

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD)) {
            classForCreateTable.createCuratorTable(connection);
            classForCreateTable.createGroupTable(connection);
            classForCreateTable.createStudentTable(connection);
            classForInsertData.insertDataIntoCuratorTable(connection);
            classForInsertData.insertDataIntoGroupTable(connection);
            classForInsertData.insertDataIntoStudentTable(connection);
            classForSelectData.printGroupWithCurator(connection);
            classForSelectData.printStudentsWithGroupAndCurator(connection);
            classForSelectData.printCountStudents(connection);
            classForSelectData.printFemaleStudents(connection);
            classForSelectData.printStudentsFromGroup(connection);
            classForUpdateTable.UpdateGroupCurator(connection);

        }
    }
}
