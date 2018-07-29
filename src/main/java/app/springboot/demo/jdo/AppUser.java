package app.springboot.demo.jdo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class AppUser {

    private Long userId;
    @JsonProperty(value = "name", required = true)
    private String userName;
    @JsonProperty(value = "birthday", required = true)
    private Date userBirthday;
    @JsonProperty(value = "active", required = true)
    private Boolean userActive;

    public AppUser(){}

    public AppUser(String name) {
        this.userName = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Boolean getUserActive() {
        return userActive;
    }

    public void setUserActive(Boolean userActive) {
        this.userActive = userActive;
    }


}
