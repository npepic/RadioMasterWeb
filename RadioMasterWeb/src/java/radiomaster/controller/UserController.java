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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import radiomaster.model.UserModel;
import radiomaster.utility.Database;

@Path("user")
public class UserController {

    //region CLASS PARAMETERS
    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
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

    //public ArrayList<UserModel> getUser() {
      public Response getUser(){
        ArrayList<UserModel> usersListFromDatabase = new ArrayList<>();
        String returnString = null;
        JSONObject jsonObject = new JSONObject();

        try {
            
            connection = Database.connect();
            preparedStatement = connection.prepareStatement("SELECT "
                    + "id,username,email,created_at,updated_at "
                    + "FROM user");
            resultSet = preparedStatement.executeQuery();

            UserModel userModel;
            while (resultSet.next()) {
                userModel = new UserModel();
                userModel.setId(resultSet.getInt("id"));
                userModel.setUsername(resultSet.getString("username"));
                userModel.setEmail(resultSet.getString("email"));
                //userModel.setPassword(resultSet.getString("password"));
                userModel.setCreated_at(resultSet.getString("created_at"));
                userModel.setUpdated_at(resultSet.getString("updated_at"));
                usersListFromDatabase.add(userModel);

                jsonObject.put("status", 200);
                jsonObject.put("message", "OK");
                jsonObject.put("content", usersListFromDatabase);
                returnString = jsonObject.toString();
            }

        } catch (Exception e) {
            return Response.status(500).entity("Users not found").build();
        }

        return Response.ok(returnString).build();
    }

//    public UserModel getUser1() {
//        UserModel userDatabase = null;
//
//        try {
//            String query = "SELECT * from user LIMIT 1";
//            connection = Database.connect();
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//                userDatabase = new UserModel();
//                userDatabase.setId(resultSet.getInt("id"));
//                userDatabase.setUsername(resultSet.getString("username"));
//                userDatabase.setEmail(resultSet.getString("email"));
//                //um.setPassword(rs.getString("password"));
////                userDatabase.setCreated_at(resultSet.getDate("created_at"));
////                userDatabase.setUpdated_at(resultSet.getDate("updated_at"));
//            }
//        } catch (Exception e) {
//        }
//        return userDatabase;
//    }

//endregion
}
