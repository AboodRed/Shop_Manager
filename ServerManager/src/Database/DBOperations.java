/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import database.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iPod
 */
public class DBOperations {
    DBConnection DBConnect = new DBConnection();
    
// ====================================== Admin Login =================================================
public boolean dbAdminLogin(String username, String password) {
        try {
            DBConnection aDBConnection = DBConnection.getConnection();
            java.sql.Statement aStatement = aDBConnection.getStatement();
            String select = "select * from user where username ='" + username + "' and password = '" + password + "'";
            try {
                ResultSet rs = DBConnect.getStatement().executeQuery(select);
                if (rs.next()) {
                    if (rs.getString("account_type").equals("admin") && rs.getInt("isConnected") == 0) {
                        String update2 = "update user set isConnected= '" + 1 + "' where Username = '" + username + "'   ";
                        int a = aStatement.executeUpdate(update2);
                        return true;
                    }
                } else {
                    return false;
                }
                return false;
            } catch (Exception ex) {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
}
//==========================================Clientlogin=====================

        public boolean dbclientLogin(String username, String password) {
        try {
            DBConnection aDBConnection = DBConnection.getConnection();
            java.sql.Statement aStatement = aDBConnection.getStatement();
            String select = "select * from user where Username ='" + username + "' and password = '" + password + "'";
            try {
                ResultSet rs = DBConnect.getStatement().executeQuery(select);
                if (rs.next()) {
                    if (rs.getString("account_type").equals("client") && rs.getInt("isConnected") == 0) {
                        String update2 = "update user set isConnected= '" + 1 + "' where Username = '" + username + "'  ";
                        int a = aStatement.executeUpdate(update2);
                        return true;
                    }
                } else {
                    return false;
                }
                return false;
            } catch (Exception ex) {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
        }
        public boolean AddUser(int Client_ID, String username, String password, String account_Type, int balance){
             String insert = "insert into user values(" + Client_ID + ",'" + username + "','" + password + "','" + account_Type + "'," + balance + "," + 0 + ")";
        try {
            int rs = DBConnect.getStatement().executeUpdate(insert);
            if (rs > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
//            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        

 public boolean DeleteUser(int Client_ID){
        try {
            String  deleteuser = "delete from user where userID = "+Client_ID;
                        int rs = DBConnect.getStatement().executeUpdate(deleteuser);
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}

 //======================================================================================================================

    


    



