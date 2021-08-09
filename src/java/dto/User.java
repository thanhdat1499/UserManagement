/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author AdMins
 */
public class User implements Serializable{
    private int id;
    private int role_Id;
    private String username;
    private String password;
    private String displayName;
    private String email;
    private String phone;
    private String address;
    private String photo;
    private int status;
    private Date create_Date;

    public User() {
    }

    public User(int id, int role_Id, String username, String password, String displayName, String email, String phone, String address, String photo, int status, Date create_Date) {
        this.id = id;
        this.role_Id = role_Id;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.photo = photo;
        this.status = status;
        this.create_Date = create_Date;
    }

    public User(int id, int role_Id, String username, String password, String displayName, String email, String phone, String address, String photo, int status) {
        this.id = id;
        this.role_Id = role_Id;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.photo = photo;
        this.status = status;
    }

    public User(int id, int role_Id, String displayName, String email, String phone, String address, String photo, int status) {
        this.id = id;
        this.role_Id = role_Id;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.photo = photo;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getRole_Id() {
        return role_Id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoto() {
        return photo;
    }

    public int getStatus() {
        return status;
    }

    public Date getCreate_Date() {
        return create_Date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole_Id(int role_Id) {
        this.role_Id = role_Id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCreate_Date(Date create_Date) {
        this.create_Date = create_Date;
    }

    
    
    
    
}
