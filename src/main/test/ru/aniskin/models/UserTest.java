package ru.aniskin.models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void setUserId() {
        User user = new User("aniskin32","123123","aniskin@yandex.ru");
        int id = 999;
        user.setUserId(id);
        assertEquals(id,user.getUserId());
    }

    @Test
    public void getUserId() {
        User user = new User("aniskin32","123123","aniskin@yandex.ru");
        int id = 1;
        user.setUserId(id);
        assertEquals(id,user.getUserId());
    }

    @Test
    public void setLogin() {
        User user = new User("aniskin32","123123","aniskin@yandex.ru");
        String login = "aniskin3232";
        user.setLogin(login);
        assertEquals(login,user.getLogin());
    }

    @Test
    public void getLogin() {
        String s ="aniskin32";
        User user = new User(s,"123123","aniskin@yandex.ru");
        assertEquals(s,user.getLogin());
    }

    @Test
    public void setPassword() {
    }

    @Test
    public void getPassword() {
    }

    @Test
    public void setEmail() {
    }

    @Test
    public void getEmail() {
    }

    @Test
    public void setSessionId() {
    }

    @Test
    public void getSessionId() {
    }

}