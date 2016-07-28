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
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import radiomaster.model.StationsModel;
import radiomaster.utility.Database;

/**
 *
 * @author <Paula>
 */
@Path("stations")
public class StationsController {

    //region CLASS PARAMETERS
    Connection connection;
    //Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
//    private UserModel user;
    //endregion

    //region CUSTOM METHODS
    @GET
    @Path("/filter/country")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getStations() {
        List<StationsModel> stationsData = new ArrayList<StationsModel>();
        StationsModel stationsDatabase = null;
        String returnString = "";

        try {
            //String query = "SELECT * from comments";
            connection = Database.connect();
            preparedStatement = connection.prepareStatement("SELECT * from stations");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                stationsDatabase = new StationsModel();
                stationsDatabase.setId(resultSet.getInt("id"));
                stationsDatabase.setName(resultSet.getString("name"));
                stationsDatabase.setDescription(resultSet.getString("description"));
                stationsDatabase.setWebsite(resultSet.getString("website"));
                stationsDatabase.setTwitter_url(resultSet.getString("twitter_url"));
                stationsDatabase.setFacebook_url(resultSet.getString("facebook_url"));
                stationsDatabase.setSlug(resultSet.getString("slug"));
                stationsDatabase.setImage_url(resultSet.getString("image_url"));
                stationsDatabase.setThumb_url(resultSet.getString("thumb_url"));
                stationsDatabase.setStream_url(resultSet.getString("stream_url"));
                stationsDatabase.setStream_bitrate(resultSet.getString("stream_bitrate"));
                stationsDatabase.setCreated_at(resultSet.getDate("created_at"));
                stationsDatabase.setUpdated_at(resultSet.getDate("updated_at"));
                stationsData.add(stationsDatabase);
              

                JSONObject jsonObject = new JSONObject();

                jsonObject.put("status", 200);
                jsonObject.put("message", "OK");
                jsonObject.put("content", stationsData);
                returnString = jsonObject.toString();

            }
        } catch (Exception e) {
            return Response.status(500).entity("Users not found").build();
        }

        return Response.ok(returnString).build();

//endregion
    }

}
