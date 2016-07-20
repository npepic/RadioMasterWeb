/**
 * Connection Manager
 *
 * neki opis
 *
 * @author Nikolina Pepić
 * @version 1.0
 *
 * Jul 18, 2016
 *
 * This code and information is provided "as is" without warranty of any kind,
 * either expressed or implied, including but not limited to the implied
 * warranties of merchantability and/or fitness for a particular purpose.
 *
 * Copyright (c) Gauss d.o.o. All rights reserved
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

    //region CLASS PARAMETERS
    private static Connection connection;
    private static Database database = null;
    //endregion 

    /**
     *
     */
    protected Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/radiomaster",
                    "radiomaster",
                    "radiomaster");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Calling this will establish connection with radiomaster database.
     *
     * @return connection
     */
    public static Connection connect() {
        if (database == null) {
            database = new Database();
        }
        return connection;
    }

    /**
     * Calling this will close the connection with radiomaster database.
     */
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
