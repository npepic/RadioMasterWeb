/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.model;

import java.util.Date;

/**
 *
 * @author <Paula>
 */
public class CategoriesSubModel {
    
    private int id;
//   private int parent_id;
    private String title;
    private String description;
    private CreatedAt created_at;
    private CategoriesModel categories;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the parent_id
     */
//    public int getParent_id() {
//        return parent_id;
//    }
//
//    /**
//     * @param parent_id the parent_id to set
//     */
//    public void setParent_id(int parent_id) {
//        this.parent_id = parent_id;
//    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the created_at
     */
   

    /**
     * @return the categories
     */
    public CategoriesModel getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(CategoriesModel categories) {
        this.categories = categories;
    }

    /**
     * @return the created_at
     */
    public CreatedAt getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(CreatedAt created_at) {
        this.created_at = created_at;
    }
    
    
    
}
