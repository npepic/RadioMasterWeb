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
import radiomaster.model.CategoriesModel;
import radiomaster.model.CreatedAt;
import radiomaster.utility.Database;

/**
 *
 * @author <Paula>
 */
@Path("categories")
public class CategoriesController {

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

    public Response getCategoriesList() {
        ArrayList<CategoriesModel> categoriesListData = new ArrayList<>();
        CategoriesModel categoriesListDatabase = new CategoriesModel();
        CreatedAt created = new CreatedAt();
        String returnString = null;

        try {
            //String query = "SELECT * from comments";
            connection = Database.connect();
            preparedStatement = connection.prepareStatement("select "
                    + "                    a.id as idCategorie,"
                    + "                    a.title as title,"
                    + "                    a.description as description,"
                    + "                    b.datum as datum,"
                    + "                    b.timezone_type as timezoneTypeCreated,"
                    + "                    b.timezone as timezoneCreated,"
                    + "                    from categories a "
                    + "                    inner join created_at b on a.created_at=b.id");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                categoriesListDatabase.setId(resultSet.getInt("id"));
                categoriesListDatabase.setTitle(resultSet.getString("title"));
                categoriesListDatabase.setDescription(resultSet.getString("description"));

                created.setDatum(resultSet.getDate("datum"));
                created.setTimezone_type(resultSet.getInt("timezoneTypeCreted"));
                created.setTimezone(resultSet.getString("timezoneCreated"));

                categoriesListDatabase.setCreated_at(created);
                categoriesListData.add(categoriesListDatabase);

                JSONObject createdAt = new JSONObject(created);
                JSONObject jsonObject = new JSONObject();
                JSONObject categ = new JSONObject(categoriesListData);
                
                categ.put("created_at", created);

                jsonObject.put("status", 200);
                jsonObject.put("message", "OK");
//                jsonObject.put("created_at", createdAt);
                jsonObject.put("content", categ);
                returnString = jsonObject.toString();
            }

        } catch (Exception e) {
            return Response.status(500).entity("Users not found").build();
        }

        return Response.ok(returnString).build();

//endregion
    }

}
