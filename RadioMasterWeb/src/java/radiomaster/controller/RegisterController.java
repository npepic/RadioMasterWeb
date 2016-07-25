///**
//* User Controller
//*
//* This controller class is used to get users from mysql radiomaster database. 
//*
//* @author Nikolina Pepić
//* @version 1.0
//*
//* Jul 18, 2016
//*
//* This code and information is provided "as is" without warranty of any kind,
//* either expressed or implied, including but not limited to the implied
//* warranties of merchantability and/or fitness for a particular purpose.
//*
//* Copyright (c) Gauss d.o.o. All rights reserved
//*
package radiomaster.controller;

import java.sql.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import radiomaster.model.UserModel;
import radiomaster.utility.Database;

public class RegisterController {

    public int insertIntoRegister(String username, String email, String password, String created_at, String updated_at) {

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;

        try {

            connection = Database.connect();
            preparedStatement = connection.prepareStatement("INSERT INTO user "
                    + "(username,email,password,created_at,updated_at) "
                    + "VALUES (?,?,?,null,null)");
            preparedStatement.setString(1, "username");
            preparedStatement.setString(2, "email");
            preparedStatement.setString(3, "password");
            preparedStatement.setString(4, "created_at");
            preparedStatement.setString(5, "updated_at");

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 500;
        } finally {

            return 200;

        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(String incomingData) throws Exception {
        String returnString = null;
        JSONArray jsonArray = new JSONArray();
        UserModel userModel = new UserModel();

//        try {
//
//            System.out.println("incoming data" + incomingData);
//
//            ObjectMapper mapper = new ObjectMapper();
//            RegisterEntry registerEntry = mapper.readValue(incomingData, 
//                    RegisterEntry.class);
//
//            int http_code = insertIntoRegister(
//                    registerEntry.username, 
//                    registerEntry.email, 
//                    registerEntry.password, 
//                    registerEntry.created_at, 
//                    registerEntry.updated_at);
//
//            if (http_code == 200) {
//                //returnString = jsonArray.toString();
//                returnString = "User added";
//            } else {
//                return Response.status(500).entity("Unable to add user").build();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Response.status(500).entity("Unable to create new user").build();
//        }

        return Response.ok(returnString).build();
    }

}
