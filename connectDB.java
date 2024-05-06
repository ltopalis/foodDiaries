import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
    private static String server = "localhost";
    private static String port = "3306";
    private static String database = "fooddiaries";
    private static String username = "root";
    private static String password = "root";

    public static String getServer() {
        return server;
    }

    public static void setServer(String server) {
        connectDB.server = server;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        connectDB.port = port;
    }

    public static String getDatabase() {
        return database;
    }

    public static void setDatabase(String database) {
        connectDB.database = database;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        connectDB.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        connectDB.password = password;
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://" + server + ":" + port + "/" + database;
        return DriverManager.getConnection(url, username, password);
    }
}
