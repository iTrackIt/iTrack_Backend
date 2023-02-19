package rw.iTrack.Application.v1.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {

    //the function to hash the given password
    public String hashPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    //the function to match the given password
    public boolean isMatch(String givenPassword , String savedPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(givenPassword , savedPassword);
    }
}
