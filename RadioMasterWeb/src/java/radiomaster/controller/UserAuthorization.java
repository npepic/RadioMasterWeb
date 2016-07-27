/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
import radiomaster.model.UserModel;
import radiomaster.utility.Database;

/**
 *
 * @author Nikolina Pepić
 */
@Path("user")
public class UserAuthorization {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public UserModel loginAuthorization(String email, String password) {

        UserModel userModel = null;
        
        try {
            connection = Database.connect();
            preparedStatement = connection.prepareStatement("SELECT * FROM "
                    + " user WHERE email=? AND password=?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userModel = new UserModel();
                userModel.setId(resultSet.getInt("id"));
                userModel.setUsername(resultSet.getString("username"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setPassword(resultSet.getString("password"));
                userModel.setCreated_at(resultSet.getString("created_at"));
                userModel.setUpdated_at(resultSet.getString("updated_at"));
            }
        } catch (Exception e) {
        }
        return userModel;

    }

    @POST
    @Path("/login")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED,
            MediaType.MULTIPART_FORM_DATA})
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(String incomingData) throws JSONException {

        UserAuthorization userAuth = new UserAuthorization();
        JSONObject jsonObject = new JSONObject();
        String email;
        String password;
        String returnString = null;

        try {

            JSONObject userData = new JSONObject(incomingData);
            email = userData.optString("email");
            password = userData.optString("password");

            UserModel userModel = userAuth.loginAuthorization(email, password);

            if (userModel != null) {
                jsonObject.put("status", "200");
                jsonObject.put("message", "OK");
                jsonObject.put("request", incomingData);
                returnString = jsonObject.toString();

            } else {
                jsonObject.put("status", "404");
                jsonObject.put("message", "User not found");
                returnString = jsonObject.toString();
                return Response.status(404).entity(returnString).build();

            }
        } catch (Exception e) {
            jsonObject.put("status", "500");
            jsonObject.put("message", "Server error");
            returnString = jsonObject.toString();
            return Response.status(500).entity(returnString).build();
        }
        return Response.ok(returnString).build();
    }

}
