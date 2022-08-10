package hw8;
import java.sql.*;

public class DatabaseRepositorySQLitelmpl {
    //регистрация драйвера
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //создание таблицы
    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "city TEXT NOT NULL,\n" +
            "date_time TEXT NOT NULL,\n" +
            "weather_text TEXT NOT NULL,\n" +
            "temperature REAL NOT NULL);";


    public void DatabaseRepositorySQLiteImpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
    }
//

    //соединение
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:weather");
        return connection;
    }

    //метод создания
    public void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void performDropTable() throws SQLException {
        try (Connection connection = getConnection()) {
            connection.createStatement().executeUpdate("DROP TABLE IF EXISTS weather");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
