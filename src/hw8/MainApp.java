package hw8;

import java.io.IOException;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException, IOException {
        DatabaseRepositorySQLitelmpl databaseRepositorySQLite = new DatabaseRepositorySQLitelmpl();
        AccuWeatherProvider accuWeatherProvider = new AccuWeatherProvider();

        databaseRepositorySQLite.getConnection();
        databaseRepositorySQLite.createTableIfNotExists();

        //запускает интерфейс (консоль)
        UserInterface userInterface = new UserInterface();
        //запускает приложение
        userInterface.runApplication();

        accuWeatherProvider.readWeatherDayFromDB(accuWeatherProvider.detectCityKey());
    }

}
