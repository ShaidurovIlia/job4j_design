package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private static Properties readProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream in = TableEditor.class
        .getClassLoader()
        .getResourceAsStream("jdbc.properties")) {
            properties.load(in);
        }
        return properties;
    }

    private void initConnection() {
        try {
            Class.forName(properties.getProperty("jdbc.connection.driver_class"));
            connection = DriverManager.getConnection(
                    properties.getProperty("jdbc.connection.url"),
                    properties.getProperty("jdbc.connection.username"),
                    properties.getProperty("jdbc.connection.password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) throws SQLException {
        executeOrder(String.format(
                "create table if not exists %s()",
                tableName
        ));
    }

    public void dropTable(String tableName) throws SQLException {
        executeOrder(String.format(
                "drop table if exists %s",
                tableName
        ));
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        executeOrder(String.format(
                "alter table if exists %s add column %s %s;",
                tableName, columnName, type
        ));
    }

    public void dropColumn(String tableName, String columnName)
            throws SQLException {
        executeOrder(String.format(
                "alter table if exists %s drop column %s;",
                tableName, columnName
        ));
    }

    public void renameColumn(String tableName, String columnName, String newColumn)
            throws SQLException {
        executeOrder(String.format(
                "alter table if exists %s rename column %s to %s;",
                tableName, columnName, newColumn
        ));
    }

    public void executeOrder(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public static String getTableScheme(Connection connection, String tableName)
            throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

        @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        try (TableEditor table = new TableEditor(readProperties())) {
            table.createTable("table_editor");
            System.out.println(getTableScheme(table.connection, "table_editor"));
            table.addColumn("table_editor", "student", "text");
            System.out.println(getTableScheme(table.connection, "table_editor"));
            table.dropColumn("table_editor", "student");
            System.out.println(getTableScheme(table.connection, "table_editor"));
            table.renameColumn("table_editor", "student", "studentJ4j");
            System.out.println(getTableScheme(table.connection, "table_editor"));
            table.dropTable("table_editor");
        }
    }
}
