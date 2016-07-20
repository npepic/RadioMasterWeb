/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikolina Pepić
 */
public class Database {

   
    private static Connection veza;
    private static Database database = null;

    protected Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            veza = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/radiomaster",
                    "radiomaster",
                    "radiomaster");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection connect() {
        if (database == null) {
            database = new Database();
        }
        return veza;
    }

    public static void closeConnection() {
        try {
            veza.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
