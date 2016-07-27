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
    private String created_at;
    private String updated_at;

    //endregion
    

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
    
    
//    public Date getCreated_at() {
//        return created_at;
//    }
//
//    public void setCreated_at(Date created_at) {
//        this.created_at = created_at;
//    }
//
//    public Date getUpdated_at() {
//        return updated_at;
//    }
//
//    public void setUpdated_at(Date updated_at) {
//        this.updated_at = updated_at;
//    }
    
    
    //endregion

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }


}


