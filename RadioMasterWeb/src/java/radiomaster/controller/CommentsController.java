/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import radiomaster.model.CommentsModel;
import radiomaster.utility.Database;

/**
 *
 * @author <Paula>
 */
@Path("comments")
public class CommentsController {

    //region CLASS PARAMETERS
    Connection connection;
    //Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

//    private UserModel user;
    //endregion
    //region CUSTOM METHODS
    @GET
    @Path("/stations/list/{stations_id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getComments(@PathParam("stations_id") int id) throws SQLException {
        List<CommentsModel> commentsData = new ArrayList<>();
        CommentsModel commentsDatabase = null;
         String returnString = null;
        JSONObject jsonObject = new JSONObject();
//        JSONObject user = json.getJSONObject("user");
//        JSONObject status = user.getJSONObject("status");
        
         
        

        try {
            
           
            connection = Database.connect();
            preparedStatement = connection.prepareStatement("select "
                    + "                    a.id as id,"
                    + "                    a.comments as comments,"
                    + "                    a.report_count as report_count,"
                    + "                    a.created_at as created_at,"
                    + "                    b.id as stations_id,"
                    + "                    from comments a "
                    + "                    inner join stations b on a.stations=b.id"
                    + "                    where b.id=" + id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                commentsDatabase = new CommentsModel();
                commentsDatabase.setId(resultSet.getInt("id"));
                commentsDatabase.setComment(resultSet.getString("comments"));
                commentsDatabase.setReport_count(resultSet.getInt("report_count"));
                commentsDatabase.setCreated_at(resultSet.getDate("created_at"));

//                StationsModel stationsModel = new StationsModel();
//                stationsModel.setId(resultSet.getInt("stations_id"));
//                commentsDatabase.setStationsModel(stationsModel);
                
                commentsData.add(commentsDatabase);
                jsonObject.put("status", 200);
                jsonObject.put("message", "OK");
                jsonObject.put("content", commentsData);
                returnString = jsonObject.toString();
            }

        } catch (Exception e) {
            return Response.status(500).entity("Comments not found").build();
        }

        return Response.ok(returnString).build();

//endregion
    }

}
