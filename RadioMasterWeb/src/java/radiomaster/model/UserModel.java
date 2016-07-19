/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.model;

import java.util.Date;

/**
 *
 * @author Nikolina Pepić
 */
public class UserModel {

    private int id;
    private String username;
    private String email;

//    private DateTimeModel created_at;
//    private DateTimeModel updated_at;
    private Date created_at;
    private Date updated_at;

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

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

//    public DateTimeModel getCreated_at() {
//        return created_at;
//    }
//
//    public void setCreated_at(DateTimeModel created_at) {
//        this.created_at = created_at;
//    }
//
//    public DateTimeModel getUpdated_at() {
//        return updated_at;
//    }
//
//    public void setUpdated_at(DateTimeModel updated_at) {
//        this.updated_at = updated_at;
//    }
}
