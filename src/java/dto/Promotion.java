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
public class Promotion implements Serializable{
    private int id;
    private int userId;
    private Date date;
    private double rankPromo;
    private String photo;
    private int status;

    public Promotion() {
    }

    public Promotion(int id, int userId, Date date, double rankPromo, String photo, int status) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.rankPromo = rankPromo;
        this.photo = photo;
        this.status = status;
    }

    public Promotion(int userId, double rankPromo, String photo, int status) {
        this.userId = userId;
        this.rankPromo = rankPromo;
        this.photo = photo;
        this.status = status;
    }

    public Promotion(int userId, double rankPromo, String photo) {
        this.userId = userId;
        this.rankPromo = rankPromo;
        this.photo = photo;
    }

    public Promotion(int id, int userId, Date date, double rankPromo, String photo) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.rankPromo = rankPromo;
        this.photo = photo;
    }
    
    

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    public double getRankPromo() {
        return rankPromo;
    }

    public String getPhoto() {
        return photo;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRankPromo(double rankPromo) {
        this.rankPromo = rankPromo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
       
        
}
