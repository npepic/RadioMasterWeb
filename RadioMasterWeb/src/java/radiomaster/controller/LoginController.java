/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import radiomaster.model.UserModel;
import radiomaster.utility.Database;

/**
 *
 * @author Nikolina Pepić
 */
@Path("logincontroller")
public class LoginController {

    Connection connection;
    PreparedStatement statement;
    ResultSet rs;
    
    

    @GET
    @Path("/getData")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<UserModel> getDataInJSON() {

        ArrayList<UserModel> loginList = new ArrayList<>();
        
        

        try {
            connection = Database.connect();

            statement = connection.prepareStatement("select * from user");
        
        
        
        
        
//        (" select a.id, a.username, a.email, "
//                    + " b.id, b.date, b.timezone_type, b.timezone, "
//                    + " c.id, c.date, c.timezone_type, c.timezone "
//                    + " from user a "
//                    + " inner join created_at b on a.created_at=b.id "
//                    + " inner join updated_at c on a.updated_at=c.id ");

            statement.setString(1, "%");
            rs = statement.executeQuery();

            UserModel um;
            while (rs.next()) {
                um = new UserModel();
                um.setId(rs.getInt("id"));
                um.setUsername(rs.getString("username"));
                um.setEmail(rs.getString("email"));
                um.setCreated_at(rs.getDate("created_at"));
                um.setUpdated_at(rs.getDate("updated_at"));
                loginList.add(um);
                System.out.println(loginList);

            }
            System.out.println(loginList);
        } catch (Exception e) {
        }
        return loginList;
    }

    
}
