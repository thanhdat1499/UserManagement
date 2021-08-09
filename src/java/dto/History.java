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
public class History implements Serializable{
    private int id;
    private int promotion_id;
    private int userId;
    private String description;
    private Date create_date;

    public History() {
    }

    public History(int id, int promotion_id, int userId, String description, Date create_date) {
        this.id = id;
        this.promotion_id = promotion_id;
        this.userId = userId;
        this.description = description;
        this.create_date = create_date;
    }

    public int getId() {
        return id;
    }

    public int getPromotion_id() {
        return promotion_id;
    }

    public int getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPromotion_id(int promotion_id) {
        this.promotion_id = promotion_id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    
    
}
