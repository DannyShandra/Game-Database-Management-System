/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coe848lab5;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Danushyan
 */
public class Coe848lab5 {

    /**
     * @param args the command line arguments
     */
    
    public static Connection conn = null;
    public static Statement s = null;
    
    public static Connection connectDB(){
        Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            //c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Danushyan\\Documents\\Education\\Ryerson University\\Y6 S2 (W2019)\\COE848 - Fundamentals of Data Engineering\\Labs\\Lab 5\\Gameshop.db");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\data\\Gameshop.db");

            if(c == null)
                throw new Exception("Connection to the database is null", null);
            c.setAutoCommit(false);  
        }
        catch(Exception e){
            System.err.println("Problem Encountered!");
            e.printStackTrace();
            //throw e;
        }
        //.out.println("Opened database successfully
        return c;
    }
    
    public static void addRecord(){
        System.out.println("NOTE: Only View Record Option Available");
    }
    
    public static void viewRecord(){
        //VideoGames vg = new VideoGames(1, "Batman", "1", 2, 1, 3, "3/10", "3/21/2007", "2");
        //System.out.println(vg.toString());
        
        Scanner input = new Scanner(System.in);
        String sql = "";
        
        int op = 0;
        while (op != 9){
            System.out.println("What do you want to see?");
            System.out.println("1. Display the games in order by Title");
            System.out.println("2. List games for a Genre");
            System.out.println("3. List games and their playtime in terms of days");
            System.out.println("4. Display games by a publisher");
            System.out.println("9. Go to previous Menu");
            System.out.println("Enter Query Choice:");
            op = input.nextInt();
            
            switch (op){
                case 1:
                    sql = "SELECT * ";
                    sql += "FROM VideoGames ";
                    sql += "ORDER BY Title ";
                    displayResult(sql, 0);
                    break;
                case 2:
                    System.out.println("Enter Genre:");
                    String Genre = input.nextLine();
                    Genre = input.nextLine();
                    
                    sql = "SELECT VG.* FROM VideoGames VG ";
                    sql += "INNER JOIN Genre G ";
                    sql += "ON VG.GenreId = G.Id ";
                    sql += "WHERE G.GenreName = '" + Genre + "' ";
                    displayResult(sql, 0);
                    break;
                case 3:
                    sql = "SELECT * ";
                    sql += "FROM VideoGames ";
                    displayResult(sql, 1);

                    break;
                case 4:
                    System.out.println("Enter Publisher Name:");
                    String PublisherName = input.nextLine();
                    PublisherName = input.nextLine();
                    
                    sql = "SELECT VG.* FROM VideoGames VG ";
                    sql += "INNER JOIN Publisher P ";
                    sql += "ON VG.PublisherId = P.Id ";
                    sql += "WHERE P.Name = '" + PublisherName + "' ";
                    displayResult(sql, 0);
                    break;
            }
            
            
        }
    }
    
    public static void modifyRecord(){
        System.out.println("NOTE: Only View Record Option Available");
    }
    
    public static void deleteRecord(){
        System.out.println("NOTE: Only View Record Option Available");
    }
    
    public static void displayResult(String sql, int option){
        try{
            conn = connectDB();
            
            s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()){
              
                Integer Id = rs.getInt("Id");
                String Title = rs.getString("Title");
                String GenreId = rs.getString("GenreId");
                Integer PublisherId = rs.getInt("PublisherId");
                Integer StudioId = rs.getInt("StudioId");
                Integer PlayTime = rs.getInt("PlayTime");
                String Ratings = rs.getString("Ratings");
                String ReleaseDate = rs.getString("ReleaseDate");
                String ComposerId = rs.getString("ComposerId");
                
                VideoGames vg = new VideoGames(Id, Title, GenreId, PublisherId, StudioId, PlayTime, Ratings, ReleaseDate, ComposerId);
                
                if (option == 1){
                    // Format result for
                    double pt = (double)vg.getPlayTime()/24.0;
                    //int pt1 = (int)pt*100;
                    //double pt2 = (double)pt1/100.0;
                   
                    System.out.println("Title: " + vg.getTitle() + "\nPlayTime: " + pt);
                }else{
                    System.out.println(vg.toString());
                }
                
                
            }
            
            
            conn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
        int op = 0;     // declare option variable
        
        while (op != 5){ 
            
            System.out.println("1. Add Record");
            System.out.println("2. View Record");
            System.out.println("3. Modify Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Quit");
            System.out.println("Enter Choice:");
            op = input.nextInt();
            
            switch (op){
                case 1:
                    addRecord();
                    break;
                case 2:
                    viewRecord();
                    break;
                case 3:
                    modifyRecord();
                    break;
                case 4:
                    deleteRecord();
                    break;
            }
                    
        }
      
    }
    
}
