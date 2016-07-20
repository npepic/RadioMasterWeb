/**
* User Controller
*
* This controller class is used to get users from mysql radiomaster database. 
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
package radiomaster.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import radiomaster.model.UserModel;
import radiomaster.utility.Database;


@Path("user")
public class UserController {
    //region CLASS PARAMETERS
    Connection connection;
    Statement statement;
    ResultSet rs;
    //endregion
    
    //region CUSTOM METHODS
    
    /**
    * Calling this will send query to radiomaster database and get user in json    
    * object.
    *
    * @return user
    */

    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public UserModel getUser() {
        UserModel um = null;

        try {
            String query = "select * from user";
            connection = Database.connect();

            statement = connection.createStatement();
            
            rs = statement.executeQuery(query);

            while (rs.next()) {

                um = new UserModel();
                um.setId(rs.getInt("id"));
                um.setUsername(rs.getString("username"));
                um.setEmail(rs.getString("email"));
                um.setPassword(rs.getString("password"));
                um.setCreated_at(rs.getDate("created_at"));
                um.setUpdated_at(rs.getDate("updated_at"));

            }

        } catch (Exception e) {
        }

        return um;
    }
//endregion
}
