package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
        createTable();
    }

    private void createTable() {
        try (Statement statement = connection.createStatement()) {
            String query = "create table if not exists items(id serial primary key, name text, created timestamp)";
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Item add(Item item) {
        Item result = null;
        try (Statement statement = connection.createStatement()) {
            String query = String.format("insert into items(name, created) values('%s', '%s')", item.getName(), Timestamp.valueOf(item.getCreated()));
            statement.execute(query);
            result = item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (Statement statement = connection.createStatement()) {
            String query = String.format("update items set name = '%s' where id = %s", item.getName(), id);
            statement.execute(query);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        try (Statement statement = connection.createStatement()) {
            String query = String.format("delete from items where id = %s", id);
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        ResultSet resultSet;
        List<Item> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String query = "select * from items";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result.add(new Item(resultSet.getString(2), resultSet.getInt(1), resultSet.getTimestamp(3).toLocalDateTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        ResultSet resultSet;
        List<Item> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String query = String.format("select * from items where name = '%s'", key);
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result.add(new Item(resultSet.getString(2), resultSet.getInt(1), resultSet.getTimestamp(3).toLocalDateTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        ResultSet resultSet;
        Item result = null;
        try (Statement statement = connection.createStatement()) {
            String query = String.format("select * from items where id = %s", id);
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                result = new Item(resultSet.getString(2), resultSet.getInt(1), resultSet.getTimestamp(3).toLocalDateTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
