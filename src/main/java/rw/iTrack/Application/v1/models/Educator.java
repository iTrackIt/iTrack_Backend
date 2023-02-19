package rw.iTrack.Application.v1.models;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import rw.iTrack.Application.v1.enums.Gender;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "educators" , uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}) , @UniqueConstraint(columnNames = {"nat_id"})})
public class Educator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ed_id;
    @NotNull
    @ApiModelProperty("The full names of the Educator")
    private String fullNames;
    @NotNull
    @ApiModelProperty("The username of the Educator")
    private String username;

    @NotNull
    @ApiModelProperty("The email of the educator")
    @Column(name = "email")
    private String email;
    @NotNull
    @ApiModelProperty("The national id of the educator")
    @Column(name = "nat_id")
    private String national_id;
    @NotNull
    @ApiModelProperty("The gender of the educator male or female?")
    private Gender gender;
    @NotNull
    @ApiModelProperty("The password of the educator")
    private String password;

    public Educator(){

    }

    public Educator(String fullNames, String username, String email ,  String national_id, Gender gender, String password) {
        this.fullNames = fullNames;
        this.username = username;
        this.national_id = national_id;
        this.gender = gender;
        this.password = password;
        this.email = email;
    }

    public UUID getEd_id() {
        return ed_id;
    }

    public void setEd_id(UUID ed_id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
