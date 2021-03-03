package data.interfaces;

import java.sql.Connection;
//Interface that needs to get the connection with database
public interface IDBManager {
    public Connection getConnection();
}
