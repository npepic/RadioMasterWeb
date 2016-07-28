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
public class CommentsModel {

     
    private int id;
    //  private UserModel user;
    private int user_id;
    private String username;
    private String comment;
    private int report_count;
    private Date created_at;
    private StationsModel stationsModel;
    private UserModel user;
    

//    public CommentsModel() {
//
//    }
//
//    public CommentsModel(int id, UserModel user, String comment, int report_count, Date created_at) {
//        this.id = id;
//        this.user = user;
//        this.comment = comment;
//        this.report_count = report_count;
//        this.created_at = created_at;
//
//    }
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
     * @return the user
     */
//    public UserModel getUser() {
//        return user;
//    }
//
//    /**
//     * @param user the user to set
//     */
//    public void setUser(UserModel user) {
//        this.user = user;
//    }
    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the report_count
     */
    public int getReport_count() {
        return report_count;
    }

    /**
     * @param report_count the report_count to set
     */
    public void setReport_count(int report_count) {
        this.report_count = report_count;
    }

    /**
     * @return the created_at
     */
    public Date getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the stationsModel
     */
    public StationsModel getStationsModel() {
        return stationsModel;
    }

    /**
     * @param stationsModel the stationsModel to set
     */
    public void setStationsModel(StationsModel stationsModel) {
        this.stationsModel = stationsModel;
    }

    /**
     * @return the user
     */
    public UserModel getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserModel user) {
        this.user = user;
    }

}
