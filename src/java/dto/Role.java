/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author AdMins
 */
public class Role implements Serializable{
    private int id;
    private String nameRole;
    private int status;

    public Role() {
    }

    public Role(int id, String nameRole, int status) {
        this.id = id;
        this.nameRole = nameRole;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    
    
}
