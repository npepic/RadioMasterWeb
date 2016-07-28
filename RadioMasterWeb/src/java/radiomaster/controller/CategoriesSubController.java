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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import radiomaster.model.CategoriesModel;
import radiomaster.model.CategoriesSubModel;
import radiomaster.model.CreatedAt;
import radiomaster.utility.Database;

/**
 *
 * @author <Paula>
 */
@Path("categories")
public class CategoriesSubController {

    //region CLASS PARAMETERS
    Connection connection;
    //Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
//    private UserModel user;
    //endregion

    //region CUSTOM METHODS
    @GET
    @Path("/list/sub/{category_id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getCategoriesSub(@PathParam("categories_id") int id) {
        List<CategoriesSubModel> categoriesSubData = new ArrayList<>();
        
        CategoriesSubModel categoriesSubDatabase = new CategoriesSubModel();

        String returnString = null;

        CategoriesModel categories = new CategoriesModel();
        CreatedAt created = new CreatedAt();

        try {

            connection = Database.connect();
            preparedStatement = connection.prepareStatement("select "
                    + "                    a.id as id,"
                    + "                    a.title as title,"
                    + "                    a.description as description,"
                    + "                    b.id as categories_id,"
                    + "                    c.datum as date,"
                    + "                    c.timezone_type as timezonetypeCreated,"
                    + "                    c.timezone as timezone,"
                    + "                    from categories_sub a "
                    + "                    inner join categories b on a.categories=b.id"
                    + "                    inner join created_at c on a.created_at=c.id"
                    + "                    where b.id=" + id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                categoriesSubDatabase.setId(resultSet.getInt("id"));
                // categoriesSubDatabase.setParent_id(resultSet.getInt("parent_id"));
                categoriesSubDatabase.setTitle(resultSet.getString("title"));
                categoriesSubDatabase.setDescription(resultSet.getString("description"));

                categories.setId(resultSet.getInt("categories_id"));
                categoriesSubDatabase.setCategories(categories);

                created.setDatum(resultSet.getDate("date"));
                created.setTimezone_type(resultSet.getInt("timezonetypeCreated"));
                created.setTimezone(resultSet.getString("timezone"));
                categoriesSubDatabase.setCreated_at(created);

                categoriesSubData.add(categoriesSubDatabase);

                JSONObject jsonObject = new JSONObject();
                JSONObject created_at = new JSONObject(created);
                JSONObject categoriesList = new JSONObject(categoriesSubData);

                created_at.put("created_at", created_at);

                jsonObject.put("status", 200);
                jsonObject.put("message", "OK");
                jsonObject.put("content", categoriesSubData);
                returnString = jsonObject.toString();
            }

        } catch (Exception e) {
            return Response.status(500).entity("Categories_sub not found").build();
        }

        return Response.ok(returnString).build();

//endregion
    }

}
