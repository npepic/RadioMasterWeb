/**
 * Model User
 *
 * This model class represents the User object and also have logic to update
 * controller if its data changes.
 *
 * @author Nikolina Pepić
 * @version 1.0
 *
 * Jul 18, 2016
 *
 * This code and information is provided "as is" without warranty of any kind,
 * either expressed or implied, including but not limited to the implied
 * warranties of merchantability and/or fitness for a particular purpose.
 *
 * Copyright (c) Gauss d.o.o. All rights reserved
 */
package radiomaster.model;

public class UserModel {

    //region CLASS PARAMETERS
    private int id;
    private String username;
    private String email;
    private String password;
    private CreatedAt created_at;
    private UpdatedAt updated_at;

    //endregion
    public UserModel() {

    }

//    public UserModel(int id, String username, String email, String password, String created_at, String updated_at) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.created_at = created_at;
//        this.updated_at = updated_at;
//
//    }

    //region GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    /**
     * @return the updated_at
     */
    public UpdatedAt getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at the updated_at to set
     */
    public void setUpdated_at(UpdatedAt updated_at) {
        this.updated_at = updated_at;
    }

   
    
    

}
 