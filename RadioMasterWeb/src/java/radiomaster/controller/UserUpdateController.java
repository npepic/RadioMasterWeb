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
import org.json.JSONObject;
import radiomaster.model.UserModel;
import radiomaster.utility.Database;

/**
 *
 * @author <Paula>
 */
@Path("/user/")
public class UserUpdateController {

    PreparedStatement preparedStatement;
    Connection connection;
    ResultSet resultSet;

    public int updateUser(UserModel userModel) {

        try {

            connection = Database.connect();
            preparedStatement = connection.prepareStatement(" UPDATE user SET "
                    + " username=?,email=?,password=?,created_at=?,updated_at=? "
                    + " WHERE id=? ");
            preparedStatement.setString(1, userModel.getUsername());
            preparedStatement.setString(2, userModel.getEmail());
            preparedStatement.setString(3, userModel.getPassword());
            preparedStatement.setInt(4, userModel.getCreated_at().getId());
            preparedStatement.setInt(5, userModel.getUpdated_at().getId());
            preparedStatement.setInt(6, userModel.getId());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 500;
        } finally {

            return 200;

        }
    }

    @POST
    @Path("/update")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA})
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser2(String incomingData) throws Exception {

        String returnString = null;
        //JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        UserModel userModel = new UserModel();

        try {

//            if (incomingData == MediaType.APPLICATION_JSON) {
            JSONObject userData = new JSONObject(incomingData);
            userModel.setUsername(userData.getString("username"));
            userModel.setEmail(userData.getString("email"));
            userModel.setPassword(userData.getString("password"));
//            userModel.setCreated_at(userData.getString("created_at"));
//            userModel.setUpdated_at(userData.getString("updated_at"));

//            }
            int http_code = updateUser(userModel);

            if (http_code == 200) {
                jsonObject.put("HTTP_CODE", "200");
                jsonObject.put("message", "User successfully added");
                jsonObject.put("username", userData.optString("username"));
                jsonObject.put("request", incomingData);
                returnString = jsonObject.toString();
                //returnString = jsonArray.put(jsonObject).toString();
            } else {
                return Response.status(500).entity("Unable to add user").build();

            }

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("Server error").build();

        }

        return Response.ok(returnString).build();
    }

}
