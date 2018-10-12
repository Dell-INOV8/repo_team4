/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dellconnect;

import java.util.ArrayList;


/**
 * Class responsible for holding user information
 * @author Chance
 */
public class Profile {
    Integer id;
    String username;
    String name;
    String bio;
    String email;
    String position;
    String team;
    String buildingLocation;
    Integer technologyPreference;
    Integer businessPreference;
    Integer managementPreference;
    Integer hikingPreference;
    Integer gamingPreference;
    Integer cookingPreference;
    ArrayList<Integer> friends;
    
    public Profile() {
        this.id = -1;
        this.username = "NULL";
        this.bio = "NULL";
        this.email = "NULL";
        this.position = "NULL";
        this.team = "NULL";
        this.buildingLocation = "NULL";
        this.technologyPreference = -1;
        this.businessPreference = -1;
        this.managementPreference = -1;
        this.hikingPreference = -1;
        this.gamingPreference = -1;
        this.cookingPreference = -1;
        this.friends = null;
    }
    
    public Profile(Integer id, String username, String name, String bio, String email, String position, String team, String buildingLocation,
                   Integer technologyPreference, Integer businessPreference, Integer managementPreference, Integer hikingPreference, 
                   Integer gamingPreference, Integer cookingPreference, ArrayList<Integer> friends) {
        this.id = id;
        this.username = username;
        this.bio = bio;
        this.email = email;
        this. position = position;
        this.team = team;
        this.buildingLocation = buildingLocation;
        this.technologyPreference = technologyPreference;
        this.businessPreference = businessPreference;
        this.managementPreference = managementPreference;
        this.hikingPreference = hikingPreference;
        this.gamingPreference = gamingPreference;
        this.cookingPreference = cookingPreference;
        this.friends = friends;
    }
    
    public Integer getID() {
        return id;
    }
        
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getName() {
        return name;
    }
    
    public String getBio() {
        return bio;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPosition() {
        return position;
    }
    
    public String getTeam() {
        return team;
    }
    
    public String getBuildingLocation() {
        return buildingLocation;
    }
    
    public Integer getTechnologyPreference() {
        return technologyPreference;
    }
    
    public Integer getBusinessPreference() {
        return businessPreference;
    }
    
    public Integer getManagementPreference() {
        return managementPreference;
    }
    
    public Integer getHikingPreference() {
        return hikingPreference;
    }
    
    public Integer getGamingPreference() {
        return gamingPreference;
    }
    
    public Integer getCookingPreference() {
        return cookingPreference;
    }
}
