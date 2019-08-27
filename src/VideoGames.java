/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe848lab5;

import java.util.ArrayList;

/**
 *
 * @author Danushyan
 */
public class VideoGames {
    
    Integer Id;
    String Title;
    String GenreId;
    Integer PublisherId;
    Integer StudioId;
    Integer PlayTime;
    String Ratings;
    String ReleaseDate;
    String ComposerId;
    //ArrayList<VideoGames> directors;
    //other attributes/fields/properties

    public VideoGames(Integer Id, String Title, String GenreId, Integer PublisherId, Integer StudioId, Integer PlayTime, String Ratings, String ReleaseDate, String ComposerId){
        this.Id = Id;
        this.Title = Title;
        this.GenreId = GenreId;
        this.PublisherId = PublisherId;
        this.StudioId = StudioId;
        this.PlayTime = PlayTime;
        this.Ratings = Ratings;
        this.ReleaseDate = ReleaseDate;
        this.ComposerId = ComposerId;
    }
    public VideoGames() {}

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        this.Id = Id;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }
    public String getGenreId() {
        return GenreId;
    }
    public void setGenreId(String GenreId) {
        this.GenreId = GenreId;
    }
    public Integer getPublisherId() {
        return PublisherId;
    }
    public void setPublisherId(Integer PublisherId) {
        this.PublisherId = PublisherId;
    }
    public Integer getStudioId() {
        return StudioId;
    }
    public void setStudioId(Integer StudioId) {
        this.StudioId = StudioId;
    }
    public Integer getPlayTime() {
        return PlayTime;
    }
    public void setPlayTime(Integer PlayTime) {
        this.PlayTime = PlayTime;
    }
    public String getRatings() {
        return Ratings;
    }
    public void setRatings(String Ratings) {
        this.Ratings = Ratings;
    }
    public String getReleaseDate() {
        return ReleaseDate;
    }
    public void setReleaseDate(String ReleaseDate) {
        this.ReleaseDate = ReleaseDate;
    }
    public String getComposerId() {
        return ComposerId;
    }
    public void setComposerId(String ComposerId) {
        this.ComposerId = ComposerId;
    }
    
    @Override
    public String toString() {
        String result = "ID:" + Id +"\nTitle:" + Title + "\nGenreId:" + GenreId + "\nPublisherId:" + PublisherId + "\nStudioId:" + StudioId;
        result = result + "PlayTime:" + PlayTime + "\nRatings:" + Ratings + "\nReleaseDate:" + ReleaseDate + "\nComposerId:" + ComposerId;
        
        //String result = Id
        
        return result;        
    }
    
}
