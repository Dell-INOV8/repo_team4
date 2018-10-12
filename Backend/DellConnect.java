/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dellconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Main class responsible for keeping track of User Profiles and updating
 * clusters for suggesting friend preferences
 *
 * @author Chance
 */
public class DellConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create ArrayList of Profiles
        ArrayList<Profile> users = new ArrayList<>();

        // Init Profiles from DB
        Connection con = DBConnection.getConnection();
        ResultSet rs = null;
        try {
            rs = con.prepareStatement("SELECT * FROM profiles").executeQuery();

            while (rs.next()) {
                users.add(new Profile(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("bio"),
                        rs.getString("email"),
                        rs.getString("position"),
                        rs.getString("team"),
                        rs.getString("buildLoc"),
                        rs.getInt("technologyPref"),
                        rs.getInt("businessPref"),
                        rs.getInt("managementPref"),
                        rs.getInt("hikingPref"),
                        rs.getInt("gamingPref"),
                        rs.getInt("cookingPref"),
                        Arrays.asList(rs.getString("username").split(","))));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("A problem occurred when contacting the Database" + e.getMessage());
        }

        // Init a kMeans algorithm for AH
        kMeans afterHours = new kMeans(users, false);
        kMeans professional = new kMeans(users, true);

        // TODO: Suggest friend here based on mode (Professional vs. After Hours)
    }

}
