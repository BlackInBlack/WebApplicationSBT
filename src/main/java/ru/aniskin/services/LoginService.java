package ru.aniskin.services;

public interface LoginService {
    public boolean authenticate(String userLogin, String userPassword);
}
