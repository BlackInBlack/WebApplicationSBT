package ru.aniskin.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;
    @Column(name = "Login")
    private String Login;
    private String Password;
    private String Email;
    private String SessionId;

    public User() {

    }

    public User(String login,String password, String email) {
        this.Login = login;
        this.Password = password;
        this.Email = email;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getLogin() {
        return Login;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }

    public String getSessionId() {
        return SessionId;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "UserId=" + UserId +
                ", Login='" + Login + '\'' +
                ", Email=" + Email +
                '}';
    }
}
