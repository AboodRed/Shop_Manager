package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private Connection aConnection;
    private Statement aStatement;
    private static final DBConnection aDBConnection = new DBConnection();

    public DBConnection() {
    }

    public static DBConnection getConnection() {
        return aDBConnection;
    }

    public Statement getStatement() throws Exception, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.aConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_db", "root", "");
     //   System.out.println("Connection Successful");
        this.aStatement = this.aConnection.createStatement();
        return this.aStatement;


    }

    public void disconnectToDB() {
        try {
            aConnection.close();
            aStatement.close();
        } catch (Exception e) {
        }
    }
   // public static void main(String[] args) throws Exception {
     //   getConnection().getStatement();
    //}

}

