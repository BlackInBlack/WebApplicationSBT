package ru.aniskin.services;

public interface AccountService {
    public boolean authenticate(String userLogin, String userPassword);
    public int testData(String login,String password1, String password2, String email);
}
