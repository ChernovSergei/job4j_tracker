package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
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

    private void setIdFromDB(ResultSet resultSet, Item item) throws SQLException {
        int id = -1;
        if (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        if (id != -1) {
            item.setId(id);
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = connection.prepareStatement("insert into items(name, created) values (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                setIdFromDB(resultSet, item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement("update items set name = ? where id = ?", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setInt(2, id);
            statement.execute();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                setIdFromDB(resultSet, item);
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        ResultSet resultSet;
        List<Item> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from items")) {
            resultSet = statement.executeQuery();
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
        try (PreparedStatement statement = connection.prepareStatement("select * from items where name = ?")) {
            statement.setString(1, key);
            resultSet = statement.executeQuery();
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
        try (PreparedStatement statement = connection.prepareStatement("select * from items where id = ?")) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
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
