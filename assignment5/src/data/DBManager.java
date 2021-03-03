package data;

import data.interfaces.IDBManager;

import java.sql.Connection;
import java.sql.DriverManager;
//This class is connecting program with database.
public class DBManager implements IDBManager {
    public Connection getConnection() {
        // using try/catch to catch exceptions if program had some
        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assignment_5", "postgres", "root");
            //Here I establish the connection with my postgres database
            return connection;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
