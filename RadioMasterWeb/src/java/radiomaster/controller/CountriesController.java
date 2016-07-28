/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
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
import radiomaster.model.CountriesModel;
import radiomaster.utility.Database;

/**
 *
 * @author <Paula>
 */
@Path("countries")
public class CountriesController {

    //region CLASS PARAMETERS
    Connection connection;
    //Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
//    private UserModel user;
    //endregion

    //region CUSTOM METHODS
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getCountries() {
        List<CountriesModel> countriesData = new ArrayList<>();
        CountriesModel countriesDatabase = null;

        String returnString = null;

        try {
            connection = Database.connect();
            preparedStatement = connection.prepareStatement("SELECT * from countries");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                countriesDatabase = new CountriesModel();
                countriesDatabase.setId(resultSet.getInt("id"));
                countriesDatabase.setName(resultSet.getString("name"));
                countriesDatabase.setCountry_code(resultSet.getString("country_code"));
                countriesDatabase.setRegion(resultSet.getString("region"));
                countriesDatabase.setSubregion(resultSet.getString("subregion"));
                countriesDatabase.setFlag_img_url(resultSet.getString("flag_img_url"));
                countriesData.add(countriesDatabase);

                JSONObject jsonObject = new JSONObject();

                jsonObject.put("status", 200);
                jsonObject.put("message", "OK");
                jsonObject.put("content", countriesData);
                returnString = jsonObject.toString();

            }
        } catch (Exception e) {
            return Response.status(500).entity("Users not found").build();
        }

        return Response.ok(returnString).build();

//endregion
    }

}
