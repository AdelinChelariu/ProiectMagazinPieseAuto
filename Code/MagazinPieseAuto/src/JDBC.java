import java.sql.*;

public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/Magazin Piese Auto";
    private static final String USER = "root";
    private static final String PASSWORD = "Adelin2711";

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexiune reusita la baza de date!");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
