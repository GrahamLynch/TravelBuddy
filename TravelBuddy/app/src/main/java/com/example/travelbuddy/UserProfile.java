package com.example.travelbuddy;

public class UserProfile {
    String name;
    String email;
    String password;
    String airline;

    public UserProfile(){

    }



    public UserProfile(String name, String email, String password, String airline) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.airline = airline;
    }

    public String getName() {
        return name;
    }

    public String getAirline(){
        return airline;
    }

    public void setAirline(String airline){
        this.airline = airline;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
