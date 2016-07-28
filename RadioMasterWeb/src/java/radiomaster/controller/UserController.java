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
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import radiomaster.model.CreatedAt;
import radiomaster.model.UpdatedAt;
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
    @Consumes(MediaType.APPLICATION_JSON)

    public Response getUser() {

//        ArrayList<UserModel> userListFromDatabase = new ArrayList<>();
//        ArrayList<CreatedAt> createdAtFromDatabase = new ArrayList<>();
//        ArrayList<UpdatedAt> updatedAtFromDatabase = new ArrayList<>();

        String returnString = null;

        try {

            connection = Database.connect();
            preparedStatement = connection.prepareStatement("select "
                    + "                    a.id as id,"
                    + "                    a.username as username,"
                    + "                    a.email as email,"
                    + "                    a.password as password,"
                    + "                    b.datum as datumCreatedAt,"
                    + "                    b.timezone_type as timezoneTypeCreated,"
                    + "                    b.timezone as timezoneCreated,"
                    + "                    c.datum as datumUpdatedAt,"
                    + "                    c.timezone_type as timezoneTypeUpdated,"
                    + "                    c.timezone as timezoneUpdated,"
                    + "                    from user a "
                    + "                    inner join created_at b on a.created_at=b.id"
                    + "                    inner join updated_at c on a.updated_at=c.id");

            resultSet = preparedStatement.executeQuery();

            UserModel userModel;
            CreatedAt createdAt;
            UpdatedAt updatedAt;
            while (resultSet.next()) {
                userModel = new UserModel();
                userModel.setId(resultSet.getInt("id"));
                userModel.setUsername(resultSet.getString("username"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setPassword(resultSet.getString("password"));
                
               
                
                createdAt = new CreatedAt();
                createdAt.setDatum(resultSet.getDate("datumCreatedAt"));
                createdAt.setTimezone_type(resultSet.getInt("timezoneTypeCreated"));
                createdAt.setTimezone(resultSet.getString("timezoneCreated"));
                userModel.setCreated_at(createdAt);

                updatedAt = new UpdatedAt();
                updatedAt.setDatum(resultSet.getDate("datumUpdatedAt"));
                updatedAt.setTimezone_type(resultSet.getInt("timezoneTypeUpdated"));
                updatedAt.setTimezone(resultSet.getString("timezoneUpdated"));
                userModel.setUpdated_at(updatedAt);
                

                JSONObject jsonObject = new JSONObject();
                JSONObject created_at = new JSONObject(createdAt);
                JSONObject updated_at = new JSONObject(updatedAt);
                JSONObject usersFrom = new JSONObject(userModel);


                
                usersFrom.put("created_at", created_at);
                usersFrom.put("updated_at", updated_at);

                
                jsonObject.put("status", 200);
                jsonObject.put("message", "OK");
                jsonObject.put("content", usersFrom);
                
//                created_at.put("created_at", createdAt);
//                updated_at.put("updated_at", updatedAt);
//                
//                jsonObject.put("created_at", created_at);
//                jsonObject.put("created_at", updated_at);
                
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
