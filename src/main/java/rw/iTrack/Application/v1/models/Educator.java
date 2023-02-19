package rw.iTrack.Application.v1.models;

import rw.iTrack.Application.v1.enums.Gender;

public class Educator {
    private Long ed_id;
    private String fullNames;
    private String username;
    private String national_id;
    private Gender gender;
    private String password;

    public Educator(){

    }

    public Educator(String fullNames, String username, String national_id, Gender gender, String password) {
        this.fullNames = fullNames;
        this.username = username;
        this.national_id = national_id;
        this.gender = gender;
        this.password = password;
    }

    public Long getEd_id() {
        return ed_id;
    }

    public void setEd_id(Long ed_id) {
        this.ed_id = ed_id;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNational_id() {
        return national_id;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
